package com.tencent.desi;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings;
import android.provider.Settings.Secure;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import com.tencent.idk.R;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Objects;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManagerFactory;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    public SSLContext context = null;

    public native void update(int i, int i2);

    static {
        System.loadLibrary("native-lib");
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!isRootAvailable() || VERSION.SDK_INT <= 22) {
            setContentView((int) R.layout.no_root);
        } else if (!isRootGiven()) {
            setContentView((int) R.layout.provide_root);
        } else {
            permission();
            setContentView((int) R.layout.activity_main);
            final TextView textView = (TextView) findViewById(R.id.keyvalue);
            Button button = (Button) findViewById(R.id.startHomeView);
            Button button2 = (Button) findViewById(R.id.getfreekey);
            final TextView textView2 = (TextView) findViewById(R.id.telText);
            textView2.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse("https://t.me/desiesp"));
                    MainActivity.this.startActivity(intent);
                }
            });
            ((Button) findViewById(R.id.telegram)).setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse("https://t.me/desiesp"));
                    MainActivity.this.startActivity(intent);
                }
            });
            ((Button) findViewById(R.id.donatScrn)).setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse("https://t.me/desikey"));
                    MainActivity.this.startActivity(intent);
                }
            });
            button2.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse("http://desiesp.com"));
                    MainActivity.this.startActivity(intent);
                }
            });
            textView.setText(getKey());
            final TextView textView3 = (TextView) findViewById(R.id.textView5);
            button.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (textView.getText().length() < 1) {
                        MainActivity.this.error("Enter Valid Key");
                        return;
                    }
                    MainActivity.this.error("Please wait...");
                    new Thread(new Runnable() {
                        public void run() {
                            String imei = MainActivity.this.getImei();
                            if (imei.length() < 10 || imei.length() > 25) {
                                imei = MainActivity.this.getDeviceUniqueID(MainActivity.this);
                            }
                            StringBuilder sb = new StringBuilder();
                            sb.append("https://www.google.com/?key=");
                            sb.append(textView.getText());
                            sb.append("&uid=");
                            sb.append(imei);
                            String sb2 = sb.toString();
                            String str = null;
                            try {
                                str = MainActivity.this.visitSite(sb2);
                            } catch (IOException | KeyManagementException | KeyStoreException | NoSuchAlgorithmException | CertificateException e) {
                                MainActivity.this.updateError(e.toString());
                            }
                            try {
                                JSONObject jSONObject = new JSONObject(str);
                                boolean equals = jSONObject.getString("code").equals("1");
                                String str2 = NotificationCompat.CATEGORY_MESSAGE;
                                if (equals) {
                                    MainActivity.this.setKey(String.valueOf(textView.getText()));
                                    String str3 = "type";
                                    if (Overlay.verify(Integer.parseInt(String.valueOf(textView2.getText()).substring(37, 40)), Integer.parseInt(String.valueOf(textView3.getText()).substring(149, 152)))) {
                                        MainActivity.this.update(Integer.parseInt(jSONObject.getString(str3)), Integer.parseInt(jSONObject.getString(str2)));
                                    }
                                    MainActivity.this.start(jSONObject.getString(str3), jSONObject.getString(str2));
                                } else {
                                    MainActivity.this.updateError(jSONObject.getString(str2));
                                }
                            } catch (JSONException unused) {
                                MainActivity.this.updateError("Dec Fail");
                            }
                            MainActivity.this.setKey(String.valueOf(textView.getText()));
                        }
                    }).start();
                }
            });
        }
    }

    /* access modifiers changed from: 0000 */
    public void start(String str, String str2) {
        Intent intent = new Intent(getApplicationContext(), HomeView.class);
        intent.putExtra("type", str);
        intent.putExtra("validity", str2);
        startActivity(intent);
        finish();
    }

    /* access modifiers changed from: 0000 */
    public String visitSite(String str) throws IOException, CertificateException, KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
        HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
            public boolean verify(String str, SSLSession sSLSession) {
                return true;
            }
        });
        Certificate generateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(getAssets().open("load-der.crt"));
        KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
        instance.load(null, null);
        instance.setCertificateEntry("ca", generateCertificate);
        TrustManagerFactory instance2 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        instance2.init(instance);
        SSLContext instance3 = SSLContext.getInstance("TLS");
        this.context = instance3;
        instance3.init(null, instance2.getTrustManagers(), null);
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
        httpsURLConnection.setSSLSocketFactory(this.context.getSocketFactory());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String readLine = bufferedReader.readLine();
        if (readLine == null) {
            return null;
        }
        sb.append(readLine);
        sb.append(httpsURLConnection.getResponseCode());
        return readLine;
    }

    /* access modifiers changed from: 0000 */
    public void permission() {
        if (VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("package:");
            sb.append(getPackageName());
            startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse(sb.toString())), 69);
        }
    }

    /* access modifiers changed from: 0000 */
    public void error(String str) {
        ((TextView) findViewById(R.id.errorPlace)).setText(str);
    }

    /* access modifiers changed from: 0000 */
    public void updateError(final String str) {
        runOnUiThread(new Runnable() {
            public void run() {
                ((TextView) MainActivity.this.findViewById(R.id.errorPlace)).setText(str);
            }
        });
    }

    public static boolean isRootAvailable() {
        for (String file : ((String) Objects.requireNonNull(System.getenv("PATH"))).split(":")) {
            if (new File(file, "su").exists()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0040, code lost:
        if (r0 != null) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0049, code lost:
        if (r0 == null) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004b, code lost:
        r0.destroy();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isRootGiven() {
        /*
            boolean r0 = isRootAvailable()
            if (r0 == 0) goto L_0x0055
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch:{ Exception -> 0x0045 }
            java.lang.String r2 = "su"
            java.lang.String r3 = "-c"
            java.lang.String r4 = "id"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3, r4}     // Catch:{ Exception -> 0x0045 }
            java.lang.Process r0 = r1.exec(r2)     // Catch:{ Exception -> 0x0045 }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0045 }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0045 }
            java.io.InputStream r3 = r0.getInputStream()     // Catch:{ Exception -> 0x0045 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0045 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0045 }
            java.lang.String r1 = r1.readLine()     // Catch:{ Exception -> 0x0045 }
            if (r1 == 0) goto L_0x0040
            java.lang.String r1 = r1.toLowerCase()     // Catch:{ Exception -> 0x0045 }
            java.lang.String r2 = "uid=0"
            boolean r1 = r1.contains(r2)     // Catch:{ Exception -> 0x0045 }
            if (r1 == 0) goto L_0x0040
            r1 = 1
            if (r0 == 0) goto L_0x003f
            r0.destroy()
        L_0x003f:
            return r1
        L_0x0040:
            if (r0 == 0) goto L_0x0055
            goto L_0x004b
        L_0x0043:
            r1 = move-exception
            goto L_0x004f
        L_0x0045:
            r1 = move-exception
            r1.printStackTrace()     // Catch:{ all -> 0x0043 }
            if (r0 == 0) goto L_0x0055
        L_0x004b:
            r0.destroy()
            goto L_0x0055
        L_0x004f:
            if (r0 == 0) goto L_0x0054
            r0.destroy()
        L_0x0054:
            throw r1
        L_0x0055:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.desi.MainActivity.isRootGiven():boolean");
    }

    /* access modifiers changed from: private */
    public void setKey(String str) {
        Editor edit = getSharedPreferences("espValue", 0).edit();
        edit.putString("key", str);
        edit.apply();
    }

    public String getDeviceUniqueID(Activity activity) {
        return Secure.getString(activity.getContentResolver(), "android_id");
    }

    /* access modifiers changed from: 0000 */
    public String getImei() {
        String str = "";
        try {
            Process exec = Runtime.getRuntime().exec("su");
            OutputStream outputStream = exec.getOutputStream();
            exec.getErrorStream();
            InputStream inputStream = exec.getInputStream();
            outputStream.write("service call iphonesubinfo 1 | toybox cut -d \"'\" -f2 | toybox grep -Eo '[0-9]' | toybox xargs | toybox sed 's/\\ //g'\n".getBytes());
            outputStream.write("exit\n".getBytes());
            outputStream.flush();
            outputStream.close();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            str = bufferedReader.readLine();
            bufferedReader.close();
            exec.waitFor();
            exec.destroy();
            return str;
        } catch (Exception unused) {
            return str;
        }
    }

    /* access modifiers changed from: 0000 */
    public String getKey() {
        return getSharedPreferences("espValue", 0).getString("key", "");
    }
}
