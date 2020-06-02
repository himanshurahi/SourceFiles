package com.tencent.desi;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings;
import android.provider.Settings.Secure;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.internal.view.SupportMenu;
import com.tencent.idk.R;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Objects;

public class HomeView extends AppCompatActivity {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    int type = 0;
    int validty = 0;

    public native void closeSock();

    public native void stringFromJNI(int i, int i2, int i3, String str, String str2);

    static {
        System.loadLibrary("native-lib");
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        this.validty = Integer.parseInt(Objects.requireNonNull(extras.get("validity")).toString());
        this.type = Integer.parseInt(Objects.requireNonNull(extras.get("type")).toString());
        if (!isRootAvailable()) {
            setContentView((int) R.layout.no_root);
        } else if (!isRootGiven()) {
            setContentView((int) R.layout.provide_root);
        } else {
            bitmap(1);
            setContentView((int) R.layout.home_view);
            final Spinner spinner = (Spinner) findViewById(R.id.spinner);
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, 17367048, new String[]{"Global", "Korea", "Vietnam", "Taiwan"});
            arrayAdapter.setDropDownViewResource(17367049);
            spinner.setAdapter(arrayAdapter);
            final Spinner spinner2 = (Spinner) findViewById(R.id.selmode);
            ArrayAdapter arrayAdapter2 = new ArrayAdapter(this, 17367048, new String[]{"FULL Mode", "Simple Mode"});
            arrayAdapter2.setDropDownViewResource(17367049);
            spinner2.setAdapter(arrayAdapter2);
            spinner2.setOnItemSelectedListener(new OnItemSelectedListener() {
                public void onNothingSelected(AdapterView<?> adapterView) {
                }

                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                    if (spinner2.getSelectedItem().toString().equals("Simple Mode")) {
                        HomeView.this.bitmap(2);
                    }
                }
            });
            Button button = (Button) findViewById(R.id.button);
            TextView textView = (TextView) findViewById(R.id.textView);
            final TextView textView2 = (TextView) findViewById(R.id.telText);
            textView2.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse("https://t.me/desiesp"));
                    HomeView.this.startActivity(intent);
                }
            });
            ((Button) findViewById(R.id.telegram)).setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse("https://t.me/desiesp"));
                    HomeView.this.startActivity(intent);
                }
            });
            textView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse("https://t.me/desiesp"));
                    HomeView.this.startActivity(intent);
                }
            });
            TextView textView3 = (TextView) findViewById(R.id.mode);
            if (this.type != 1 || this.validty <= 0) {
                if (this.type == 2) {
                    int i = this.validty;
                    if (i > 0) {
                        int floor = (int) Math.floor((double) (((float) i) / 86400.0f));
                        int floor2 = (int) Math.floor((double) (((float) (this.validty % 86400)) / 3600.0f));
                        StringBuilder sb = new StringBuilder();
                        sb.append("DM: ");
                        sb.append(floor);
                        sb.append(" day ");
                        sb.append(floor2);
                        sb.append(" hours");
                        textView3.setText(sb.toString());
                    }
                }
                System.exit(-1);
            } else {
                textView3.setText("Free Mode");
            }
            final String str = "Stop ESP";
            final String str2 = "Activate ESP";
            final Button button2 = button;
            C03955 r2 = new OnClickListener() {
                public void onClick(View view) {
                    HomeView.this.closeSock();
                    if (button2.getText() == str) {
                        button2.setText(str2);
                        button2.setBackgroundColor(Color.parseColor("#673AB7"));
                        spinner.setVisibility(0);
                        Overlay.HideFloat();
                        HomeView.this.finish();
                        FloatingView.HideFloat();
                        return;
                    }
                    int i = spinner.getSelectedItem().toString().equals("Global") ? 1 : spinner.getSelectedItem().toString().equals("Korea") ? 2 : spinner.getSelectedItem().toString().equals("Vietnam") ? 3 : spinner.getSelectedItem().toString().equals("Taiwan") ? 4 : 0;
                    HomeView homeView = HomeView.this;
                    int i2 = homeView.type;
                    int parseInt = Integer.parseInt(String.valueOf(textView2.getText()).substring(37, 40));
                    HomeView homeView2 = HomeView.this;
                    homeView.stringFromJNI(i, i2, parseInt, homeView2.getDeviceUniqueID(homeView2), HomeView.this.getKey());
                    button2.setText(str);
                    HomeView.this.start(spinner);
                    button2.setBackgroundColor(SupportMenu.CATEGORY_MASK);
                    spinner.setVisibility(4);
                    Overlay.ShowFloat(HomeView.this.getApplicationContext());
                    FloatingView.ShowFloat(HomeView.this.getApplicationContext());
                    HomeView.this.stDm();
                }
            };
            button.setOnClickListener(r2);
        }
    }

    /* access modifiers changed from: 0000 */
    public void start(Spinner spinner) {
        String str = spinner.getSelectedItem().toString().equals("Global") ? "com.tencent.ig" : spinner.getSelectedItem().toString().equals("Korea") ? "com.pubg.krmobile" : spinner.getSelectedItem().toString().equals("Vietnam") ? "com.vng.pubgmobile" : "com.rekoo.pubgm";
        StringBuilder sb = new StringBuilder();
        sb.append("am start -n ");
        sb.append(str);
        sb.append("/com.epicgames.ue4.SplashActivity");
        Shell(sb.toString());
    }

    /* access modifiers changed from: 0000 */
    public void bitmap(int i) {
        FileOutputStream fileOutputStream;
        String str = "chmod +x ";
        StringBuilder sb = new StringBuilder();
        sb.append(getApplicationContext().getFilesDir());
        String str2 = "/bitmap.so";
        sb.append(str2);
        new File(sb.toString()).delete();
        InputStream openRawResource = getResources().openRawResource(R.raw.view);
        if (i == 2) {
            openRawResource = getResources().openRawResource(R.raw.sview);
        }
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(getApplicationContext().getFilesDir());
            sb2.append(str2);
            fileOutputStream = new FileOutputStream(sb2.toString());
            byte[] bArr = new byte[1024];
            while (true) {
                try {
                    int read = openRawResource.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                } catch (IOException e) {
                    e.printStackTrace();
                    openRawResource.close();
                }
            }
            openRawResource.close();
            fileOutputStream.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            openRawResource.close();
            fileOutputStream.close();
            throw th;
        }
        try {
            Runtime runtime = Runtime.getRuntime();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append(getApplicationContext().getFilesDir());
            sb3.append(str2);
            runtime.exec(sb3.toString());
        } catch (IOException unused) {
            System.out.println("done");
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append(str);
        sb4.append(getApplicationContext().getFilesDir());
        sb4.append(str2);
        Shell(sb4.toString());
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
    public String Shell(String str) {
        String str2 = "\n";
        String str3 = "";
        try {
            Process exec = Runtime.getRuntime().exec("su");
            OutputStream outputStream = exec.getOutputStream();
            exec.getErrorStream();
            InputStream inputStream = exec.getInputStream();
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(str2);
            outputStream.write(sb.toString().getBytes());
            outputStream.write("exit\n".getBytes());
            outputStream.flush();
            outputStream.close();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str3);
                sb2.append(str2);
                sb2.append(readLine);
                str3 = sb2.toString();
            }
            bufferedReader.close();
            exec.waitFor();
            exec.destroy();
        } catch (Exception unused) {
        }
        return str3;
    }

    public String getDeviceUniqueID(Activity activity) {
        return Secure.getString(activity.getContentResolver(), "android_id");
    }

    /* access modifiers changed from: 0000 */
    public String getKey() {
        return getSharedPreferences("espValue", 0).getString("key", "");
    }

    public static boolean isRootAvailable() {
        for (String file : ((String) Objects.requireNonNull(System.getenv("PATH"))).split(":")) {
            if (new File(file, "su").exists()) {
                return true;
            }
        }
        return false;
    }

    public void stDm() {
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                HomeView homeView = HomeView.this;
                StringBuilder sb = new StringBuilder();
                sb.append(HomeView.this.getApplicationContext().getFilesDir());
                sb.append("/bitmap.so");
                homeView.Shell(sb.toString());
            }
        }).start();
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.desi.HomeView.isRootGiven():boolean");
    }
}
