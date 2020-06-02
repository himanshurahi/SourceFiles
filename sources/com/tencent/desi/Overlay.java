package com.tencent.desi;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.tencent.idk.R;
import java.io.PrintStream;

public class Overlay extends Service {
    private static Overlay Instance = null;
    static int xem = 224;
    String amit = "DesiEsp by amits2249";
    Paint backCirclePaint = new Paint();
    Canvas canvas;
    Paint distancePaint = new Paint();
    Paint espBoxPaint = new Paint();
    Paint headEnemyPaint = new Paint();
    Paint healthBoxPaint = new Paint();
    Paint healthPaint = new Paint();
    int height;
    ImageView imgv;
    Paint itemPaint = new Paint();
    Paint linePaint = new Paint();
    private View mFloatingView;
    WindowManager manager;
    Paint namePaint = new Paint();
    Paint rectPaint = new Paint();
    Paint sideDistancePaint = new Paint();
    Paint skeltonPaint = new Paint();
    Paint textPaint = new Paint();
    Paint vechilePaint = new Paint();
    int width;

    static boolean verify(int i, int i2) {
        return i == i2;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public native void stringFromJNI(int i, int i2);

    public void onCreate() {
        super.onCreate();
        Instance = this;
        SetFloatView();
        Display defaultDisplay = this.manager.getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        int i = point.x;
        int i2 = point.y;
        if (i > i2) {
            this.height = i2;
            this.width = i;
        } else {
            this.height = i;
            this.width = i2;
        }
        init();
        Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Config.ARGB_8888);
        this.canvas = new Canvas(createBitmap);
        ImageView imageView = (ImageView) this.mFloatingView.findViewById(R.id.imageView);
        this.imgv = imageView;
        imageView.setImageBitmap(createBitmap);
        new Thread(new Runnable() {
            public void run() {
                Overlay overlay = Overlay.this;
                overlay.stringFromJNI(overlay.height, Overlay.this.width);
                System.out.println("Sssssssstttooooooopppppppeeemmmmmmmmmmmmmmmmmmmmmmmmmmmm");
            }
        }).start();
    }

    /* access modifiers changed from: 0000 */
    public boolean isRun() {
        return Instance != null;
    }

    /* access modifiers changed from: 0000 */
    public boolean updateOverChk(String str) {
        PrintStream printStream = System.out;
        StringBuilder sb = new StringBuilder();
        sb.append(">");
        sb.append(str);
        sb.append("<");
        printStream.println(sb.toString());
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x02ee  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean updateOver(java.lang.String r39) {
        /*
            r38 = this;
            r0 = r38
            int r1 = r39.length()
            r2 = 1
            r3 = 0
            if (r1 >= r2) goto L_0x000e
            r38.Hide()
            return r3
        L_0x000e:
            r38.clearCanvas()
            java.lang.String r1 = "/"
            r4 = r39
            java.lang.String[] r1 = r4.split(r1)
            int r4 = r1.length
            r5 = 0
            r6 = 0
            r7 = 0
        L_0x001d:
            java.lang.String r9 = ""
            r11 = 2
            if (r6 >= r4) goto L_0x0611
            r12 = r1[r6]
            java.lang.String r13 = ","
            java.lang.String[] r12 = r12.split(r13)
            r13 = r12[r3]     // Catch:{ Exception -> 0x00cc }
            float r13 = java.lang.Float.parseFloat(r13)     // Catch:{ Exception -> 0x00cc }
            r14 = 1082130432(0x40800000, float:4.0)
            r15 = 6
            r16 = 3
            r17 = 1077936128(0x40400000, float:3.0)
            r18 = 1073741824(0x40000000, float:2.0)
            r19 = 1065353216(0x3f800000, float:1.0)
            r8 = 0
            java.lang.String r3 = " m"
            int r20 = (r13 > r19 ? 1 : (r13 == r19 ? 0 : -1))
            if (r20 == 0) goto L_0x00d4
            int r20 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            if (r20 == 0) goto L_0x00d4
            int r20 = (r13 > r18 ? 1 : (r13 == r18 ? 0 : -1))
            if (r20 != 0) goto L_0x004c
            goto L_0x00d4
        L_0x004c:
            int r8 = (r13 > r17 ? 1 : (r13 == r17 ? 0 : -1))
            if (r8 != 0) goto L_0x0099
            r8 = r12[r2]     // Catch:{ Exception -> 0x00cc }
            float r8 = java.lang.Float.parseFloat(r8)     // Catch:{ Exception -> 0x00cc }
            r9 = r12[r11]     // Catch:{ Exception -> 0x00cc }
            float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ Exception -> 0x00cc }
            r10 = r12[r16]     // Catch:{ Exception -> 0x00cc }
            float r10 = java.lang.Float.parseFloat(r10)     // Catch:{ Exception -> 0x00cc }
            r11 = r12[r15]     // Catch:{ Exception -> 0x0065 }
            goto L_0x0066
        L_0x0065:
        L_0x0066:
            int r11 = (r10 > r19 ? 1 : (r10 == r19 ? 0 : -1))
            if (r11 >= 0) goto L_0x006b
            goto L_0x00cc
        L_0x006b:
            int r11 = java.lang.Math.round(r10)
            java.lang.String r12 = "Vehicle"
            boolean r12 = r0.getConfig(r12)
            if (r12 == 0) goto L_0x00cc
            r12 = 1092616192(0x41200000, float:10.0)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 <= 0) goto L_0x00cc
            android.graphics.Canvas r10 = r0.canvas
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "🚗:"
            r12.append(r13)
            r12.append(r11)
            r12.append(r3)
            java.lang.String r3 = r12.toString()
            android.graphics.Paint r11 = r0.vechilePaint
            r10.drawText(r3, r8, r9, r11)
            goto L_0x00cc
        L_0x0099:
            int r3 = (r13 > r14 ? 1 : (r13 == r14 ? 0 : -1))
            if (r3 != 0) goto L_0x00cc
            r3 = r12[r2]     // Catch:{ Exception -> 0x00cc }
            float r3 = java.lang.Float.parseFloat(r3)     // Catch:{ Exception -> 0x00cc }
            r8 = r12[r11]     // Catch:{ Exception -> 0x00cc }
            float r8 = java.lang.Float.parseFloat(r8)     // Catch:{ Exception -> 0x00cc }
            r5 = r12[r15]     // Catch:{ Exception -> 0x00ac }
            goto L_0x00ad
        L_0x00ac:
        L_0x00ad:
            java.lang.String r10 = "Important Items"
            boolean r10 = r0.getConfig(r10)
            if (r10 != 0) goto L_0x00b6
            goto L_0x00cc
        L_0x00b6:
            int r10 = java.lang.Integer.parseInt(r5)
            java.lang.String r10 = r0.getItemName(r10)
            boolean r9 = r10.equals(r9)
            if (r9 == 0) goto L_0x00c5
            goto L_0x00cc
        L_0x00c5:
            android.graphics.Canvas r9 = r0.canvas
            android.graphics.Paint r11 = r0.itemPaint
            r9.drawText(r10, r3, r8, r11)
        L_0x00cc:
            r28 = r1
            r35 = r4
            r37 = r6
            goto L_0x0607
        L_0x00d4:
            r20 = r12[r2]     // Catch:{ Exception -> 0x00cc }
            float r2 = java.lang.Float.parseFloat(r20)     // Catch:{ Exception -> 0x00cc }
            r20 = r12[r11]     // Catch:{ Exception -> 0x00cc }
            float r11 = java.lang.Float.parseFloat(r20)     // Catch:{ Exception -> 0x00cc }
            r16 = r12[r16]     // Catch:{ Exception -> 0x00cc }
            float r16 = java.lang.Float.parseFloat(r16)     // Catch:{ Exception -> 0x00cc }
            int r20 = (r16 > r19 ? 1 : (r16 == r19 ? 0 : -1))
            if (r20 >= 0) goto L_0x00eb
            goto L_0x00cc
        L_0x00eb:
            r20 = 4
            r22 = r12[r20]     // Catch:{ Exception -> 0x00cc }
            float r22 = java.lang.Float.parseFloat(r22)     // Catch:{ Exception -> 0x00cc }
            r14 = 5
            r24 = r12[r14]     // Catch:{ Exception -> 0x00cc }
            float r24 = java.lang.Float.parseFloat(r24)     // Catch:{ Exception -> 0x00cc }
            r5 = r12[r15]     // Catch:{ Exception -> 0x00fc }
        L_0x00fc:
            r15 = 7
            r15 = r12[r15]     // Catch:{ Exception -> 0x00cc }
            r25 = 8
            r12 = r12[r25]     // Catch:{ Exception -> 0x0104 }
            goto L_0x0105
        L_0x0104:
        L_0x0105:
            int r7 = r7 + 1
            int r12 = java.lang.Math.round(r16)
            int r8 = r0.width
            int r14 = r8 / 4
            float r14 = (float) r14
            float r27 = r16 * r24
            float r14 = r14 / r27
            float r10 = (float) r8
            r28 = 1068540887(0x3fb0a3d7, float:1.38)
            float r10 = r10 / r28
            float r10 = r10 / r27
            float r28 = r11 - r10
            float r8 = (float) r8
            r29 = 1071225242(0x3fd9999a, float:1.7)
            float r8 = r8 / r29
            float r8 = r8 / r27
            float r8 = r28 + r8
            r28 = r1
            int r29 = (r13 > r19 ? 1 : (r13 == r19 ? 0 : -1))
            if (r29 == 0) goto L_0x013e
            int r29 = (r13 > r18 ? 1 : (r13 == r18 ? 0 : -1))
            if (r29 != 0) goto L_0x0133
            goto L_0x013e
        L_0x0133:
            r35 = r4
            r37 = r6
            r36 = r7
        L_0x0139:
            r1 = 1082130432(0x40800000, float:4.0)
            r9 = 0
            goto L_0x02e8
        L_0x013e:
            int r30 = (r13 > r18 ? 1 : (r13 == r18 ? 0 : -1))
            if (r30 != 0) goto L_0x015d
            android.graphics.Paint r1 = r0.linePaint
            r35 = r4
            r4 = 232(0xe8, float:3.25E-43)
            r36 = r7
            r7 = 222(0xde, float:3.11E-43)
            r37 = r6
            r31 = r9
            r6 = 30
            r9 = 200(0xc8, float:2.8E-43)
            r1.setARGB(r9, r6, r4, r7)
            android.graphics.Paint r1 = r0.espBoxPaint
            r1.setARGB(r9, r6, r4, r7)
            goto L_0x0178
        L_0x015d:
            r35 = r4
            r37 = r6
            r36 = r7
            r31 = r9
            r9 = 200(0xc8, float:2.8E-43)
            android.graphics.Paint r1 = r0.linePaint
            r4 = 102(0x66, float:1.43E-43)
            r6 = 179(0xb3, float:2.51E-43)
            r7 = 255(0xff, float:3.57E-43)
            r1.setARGB(r7, r7, r4, r6)
            android.graphics.Paint r1 = r0.espBoxPaint
            r4 = 0
            r1.setARGB(r9, r7, r4, r4)
        L_0x0178:
            int r1 = (r13 > r19 ? 1 : (r13 == r19 ? 0 : -1))
            if (r1 != 0) goto L_0x0187
            java.lang.String r1 = "Skelton"
            boolean r1 = r0.getConfig(r1)
            if (r1 == 0) goto L_0x0187
            r0.DrawBones(r2, r11, r15)
        L_0x0187:
            int r1 = r5.length()
            r4 = 5
            if (r1 >= r4) goto L_0x0191
            r9 = r31
            goto L_0x0195
        L_0x0191:
            java.lang.String r9 = r0.getName(r5)
        L_0x0195:
            int r1 = r0.width
            float r1 = (float) r1
            r4 = 1113325568(0x425c0000, float:55.0)
            float r1 = r1 / r4
            r4 = 0
            int r6 = (r22 > r4 ? 1 : (r22 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x01e2
            java.lang.String r1 = "Health"
            boolean r1 = r0.getConfig(r1)
            if (r1 == 0) goto L_0x01bd
            android.graphics.Canvas r1 = r0.canvas
            int r4 = r0.height
            float r4 = (float) r4
            r6 = 1108344832(0x42100000, float:36.0)
            float r4 = r4 / r6
            float r4 = r2 - r4
            r6 = 1084227584(0x40a00000, float:5.0)
            float r6 = r8 - r6
            android.graphics.Paint r7 = r0.distancePaint
            java.lang.String r15 = "Knocked"
            r1.drawText(r15, r4, r6, r7)
        L_0x01bd:
            java.lang.String r1 = "Name"
            boolean r1 = r0.getConfig(r1)
            if (r1 == 0) goto L_0x0139
            android.graphics.Canvas r1 = r0.canvas
            int r4 = r9.length()
            int r6 = r0.height
            int r4 = r4 * r6
            float r4 = (float) r4
            r7 = 1132920832(0x43870000, float:270.0)
            float r4 = r4 / r7
            float r4 = r2 - r4
            float r6 = (float) r6
            r7 = 1109000192(0x421a0000, float:38.5)
            float r6 = r6 / r7
            float r6 = r8 - r6
            android.graphics.Paint r7 = r0.namePaint
            r1.drawText(r9, r4, r6, r7)
            goto L_0x0139
        L_0x01e2:
            java.lang.String r4 = "Name"
            boolean r4 = r0.getConfig(r4)
            if (r4 == 0) goto L_0x0203
            android.graphics.Canvas r4 = r0.canvas
            int r6 = r9.length()
            int r7 = r0.height
            int r6 = r6 * r7
            float r6 = (float) r6
            r7 = 1124532224(0x43070000, float:135.0)
            float r6 = r6 / r7
            float r6 = r2 - r6
            r7 = 1096810496(0x41600000, float:14.0)
            float r7 = r8 - r7
            android.graphics.Paint r15 = r0.namePaint
            r4.drawText(r9, r6, r7, r15)
        L_0x0203:
            java.lang.String r4 = "Health"
            boolean r4 = r0.getConfig(r4)
            if (r4 == 0) goto L_0x02e5
            r4 = 1103626240(0x41c80000, float:25.0)
            int r4 = (r22 > r4 ? 1 : (r22 == r4 ? 0 : -1))
            if (r4 >= 0) goto L_0x021a
            android.graphics.Paint r4 = r0.healthPaint
            r6 = -65536(0xffffffffffff0000, float:NaN)
            r4.setColor(r6)
            r9 = 0
            goto L_0x0242
        L_0x021a:
            r4 = 1112014848(0x42480000, float:50.0)
            int r4 = (r22 > r4 ? 1 : (r22 == r4 ? 0 : -1))
            if (r4 >= 0) goto L_0x022b
            android.graphics.Paint r4 = r0.healthPaint
            r6 = 165(0xa5, float:2.31E-43)
            r7 = 255(0xff, float:3.57E-43)
            r9 = 0
            r4.setARGB(r7, r7, r6, r9)
            goto L_0x0242
        L_0x022b:
            r9 = 0
            r4 = 1117126656(0x42960000, float:75.0)
            int r4 = (r22 > r4 ? 1 : (r22 == r4 ? 0 : -1))
            if (r4 >= 0) goto L_0x023a
            android.graphics.Paint r4 = r0.healthPaint
            r6 = -256(0xffffffffffffff00, float:NaN)
            r4.setColor(r6)
            goto L_0x0242
        L_0x023a:
            android.graphics.Paint r4 = r0.healthPaint
            r6 = -16711936(0xffffffffff00ff00, float:-1.7146522E38)
            r4.setColor(r6)
        L_0x0242:
            r4 = 1116340224(0x428a0000, float:69.0)
            int r4 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r4 >= 0) goto L_0x02a3
            float r1 = r11 + r10
            int r4 = r0.height
            float r4 = (float) r4
            float r4 = r4 / r17
            float r4 = r4 / r27
            float r1 = r1 + r4
            android.graphics.Paint r4 = r0.healthPaint
            int r6 = r0.width
            float r6 = (float) r6
            r7 = 1142292480(0x44160000, float:600.0)
            float r6 = r6 / r7
            r4.setStrokeWidth(r6)
            android.graphics.Canvas r4 = r0.canvas
            float r6 = r2 + r14
            int r7 = r0.width
            float r15 = (float) r7
            r16 = 1135542272(0x43af0000, float:350.0)
            float r15 = r15 / r16
            float r30 = r6 + r15
            float r7 = (float) r7
            r15 = 1135542272(0x43af0000, float:350.0)
            float r7 = r7 / r15
            float r32 = r6 + r7
            float r7 = r1 - r8
            float r7 = r7 * r22
            r15 = 1120403456(0x42c80000, float:100.0)
            float r7 = r7 / r15
            float r33 = r1 - r7
            android.graphics.Paint r7 = r0.healthPaint
            r29 = r4
            r31 = r1
            r34 = r7
            r29.drawLine(r30, r31, r32, r33, r34)
            android.graphics.Canvas r4 = r0.canvas
            int r7 = r0.width
            float r15 = (float) r7
            r16 = 1140457472(0x43fa0000, float:500.0)
            float r15 = r15 / r16
            float r30 = r6 + r15
            float r7 = (float) r7
            r15 = 1132068864(0x437a0000, float:250.0)
            float r7 = r7 / r15
            float r32 = r6 + r7
            android.graphics.Paint r6 = r0.healthBoxPaint
            r29 = r4
            r31 = r8
            r33 = r1
            r34 = r6
            r29.drawRect(r30, r31, r32, r33, r34)
            goto L_0x02e6
        L_0x02a3:
            android.graphics.Paint r4 = r0.healthPaint
            int r6 = r0.height
            float r6 = (float) r6
            r7 = 1127481344(0x43340000, float:180.0)
            float r6 = r6 / r7
            r4.setStrokeWidth(r6)
            android.graphics.Canvas r4 = r0.canvas
            float r6 = r2 - r1
            r7 = 1090519040(0x41000000, float:8.0)
            float r33 = r8 - r7
            float r7 = -r1
            float r7 = r7 + r2
            float r18 = r18 * r1
            float r18 = r18 * r22
            r15 = 1120403456(0x42c80000, float:100.0)
            float r18 = r18 / r15
            float r32 = r7 + r18
            android.graphics.Paint r7 = r0.healthPaint
            r29 = r4
            r30 = r6
            r31 = r33
            r34 = r7
            r29.drawLine(r30, r31, r32, r33, r34)
            android.graphics.Canvas r4 = r0.canvas
            r7 = 1093664768(0x41300000, float:11.0)
            float r31 = r8 - r7
            float r32 = r2 + r1
            r1 = 1084227584(0x40a00000, float:5.0)
            float r33 = r8 - r1
            android.graphics.Paint r1 = r0.healthBoxPaint
            r29 = r4
            r34 = r1
            r29.drawRect(r30, r31, r32, r33, r34)
            goto L_0x02e6
        L_0x02e5:
            r9 = 0
        L_0x02e6:
            r1 = 1082130432(0x40800000, float:4.0)
        L_0x02e8:
            int r1 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x02ee
            goto L_0x0605
        L_0x02ee:
            int r1 = r0.height
            float r4 = (float) r1
            r6 = 1093455053(0x412ccccd, float:10.8)
            float r4 = r4 / r6
            float r6 = (float) r1
            r7 = 1132920832(0x43870000, float:270.0)
            float r6 = r6 / r7
            float r7 = (float) r1
            r15 = 1096286208(0x41580000, float:13.5)
            float r7 = r7 / r15
            r15 = 1123024896(0x42f00000, float:120.0)
            r16 = 0
            int r13 = (r13 > r16 ? 1 : (r13 == r16 ? 0 : -1))
            if (r13 != 0) goto L_0x0427
            java.lang.String r1 = "Back Mark"
            boolean r1 = r0.getConfig(r1)
            if (r1 == 0) goto L_0x0605
            int r1 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r1 < 0) goto L_0x036d
            int r1 = r0.height
            int r1 = r1 + -150
            float r1 = (float) r1
            int r1 = (r11 > r1 ? 1 : (r11 == r1 ? 0 : -1))
            if (r1 > 0) goto L_0x036d
            int r1 = r0.width
            int r8 = r1 / 2
            float r8 = (float) r8
            int r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r2 >= 0) goto L_0x034a
            android.graphics.Canvas r2 = r0.canvas
            float r1 = (float) r1
            android.graphics.Paint r6 = r0.backCirclePaint
            r2.drawCircle(r1, r11, r4, r6)
            android.graphics.Canvas r1 = r0.canvas
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r12)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            int r3 = r0.width
            float r3 = (float) r3
            float r3 = r3 - r7
            r4 = 1097859072(0x41700000, float:15.0)
            float r11 = r11 + r4
            android.graphics.Paint r4 = r0.sideDistancePaint
            r1.drawText(r2, r3, r11, r4)
            goto L_0x0605
        L_0x034a:
            android.graphics.Canvas r1 = r0.canvas
            android.graphics.Paint r2 = r0.backCirclePaint
            r7 = 0
            r1.drawCircle(r7, r11, r4, r2)
            android.graphics.Canvas r1 = r0.canvas
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r12)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r3 = 1097859072(0x41700000, float:15.0)
            float r11 = r11 + r3
            android.graphics.Paint r3 = r0.sideDistancePaint
            r1.drawText(r2, r6, r11, r3)
            goto L_0x0605
        L_0x036d:
            int r1 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r1 >= 0) goto L_0x03c2
            int r1 = r0.width
            int r8 = r1 / 2
            float r8 = (float) r8
            int r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r2 >= 0) goto L_0x03a0
            android.graphics.Canvas r2 = r0.canvas
            float r1 = (float) r1
            android.graphics.Paint r6 = r0.backCirclePaint
            r2.drawCircle(r1, r15, r4, r6)
            android.graphics.Canvas r1 = r0.canvas
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r12)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            int r3 = r0.width
            float r3 = (float) r3
            float r3 = r3 - r7
            android.graphics.Paint r4 = r0.sideDistancePaint
            r6 = 1124532224(0x43070000, float:135.0)
            r1.drawText(r2, r3, r6, r4)
            goto L_0x0605
        L_0x03a0:
            android.graphics.Canvas r1 = r0.canvas
            android.graphics.Paint r2 = r0.backCirclePaint
            r7 = 0
            r1.drawCircle(r7, r15, r4, r2)
            android.graphics.Canvas r1 = r0.canvas
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r12)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            android.graphics.Paint r3 = r0.sideDistancePaint
            r4 = 1124532224(0x43070000, float:135.0)
            r1.drawText(r2, r6, r4, r3)
            goto L_0x0605
        L_0x03c2:
            int r1 = r0.width
            int r8 = r1 / 2
            float r8 = (float) r8
            int r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r2 >= 0) goto L_0x03fb
            android.graphics.Canvas r2 = r0.canvas
            float r1 = (float) r1
            int r6 = r0.height
            int r6 = r6 + -120
            float r6 = (float) r6
            android.graphics.Paint r8 = r0.backCirclePaint
            r2.drawCircle(r1, r6, r4, r8)
            android.graphics.Canvas r1 = r0.canvas
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r12)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            int r3 = r0.width
            float r3 = (float) r3
            float r3 = r3 - r7
            int r4 = r0.height
            int r4 = r4 + -120
            int r4 = r4 + 15
            float r4 = (float) r4
            android.graphics.Paint r6 = r0.sideDistancePaint
            r1.drawText(r2, r3, r4, r6)
            goto L_0x0605
        L_0x03fb:
            android.graphics.Canvas r1 = r0.canvas
            int r2 = r0.height
            int r2 = r2 + -120
            float r2 = (float) r2
            android.graphics.Paint r7 = r0.backCirclePaint
            r8 = 0
            r1.drawCircle(r8, r2, r4, r7)
            android.graphics.Canvas r1 = r0.canvas
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r12)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            int r3 = r0.height
            int r3 = r3 + -120
            int r3 = r3 + 15
            float r3 = (float) r3
            android.graphics.Paint r4 = r0.sideDistancePaint
            r1.drawText(r2, r6, r3, r4)
            goto L_0x0605
        L_0x0427:
            int r13 = r0.width
            int r9 = -r13
            int r9 = r9 / 4
            float r9 = (float) r9
            int r9 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r9 < 0) goto L_0x04e7
            int r9 = r13 / 3
            int r13 = r13 + r9
            float r9 = (float) r13
            int r9 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r9 <= 0) goto L_0x043b
            goto L_0x04e7
        L_0x043b:
            float r1 = (float) r1
            r3 = 1089470464(0x40f00000, float:7.5)
            float r1 = r1 / r3
            float r1 = r1 / r27
            java.lang.String r3 = "Head Position"
            boolean r3 = r0.getConfig(r3)
            if (r3 == 0) goto L_0x0450
            android.graphics.Canvas r3 = r0.canvas
            android.graphics.Paint r4 = r0.headEnemyPaint
            r3.drawCircle(r2, r11, r1, r4)
        L_0x0450:
            java.lang.String r1 = "Box"
            boolean r1 = r0.getConfig(r1)
            if (r1 == 0) goto L_0x0474
            android.graphics.Canvas r1 = r0.canvas
            float r30 = r2 - r14
            float r32 = r2 + r14
            float r3 = r11 + r10
            int r4 = r0.height
            float r4 = (float) r4
            float r4 = r4 / r17
            float r4 = r4 / r27
            float r33 = r3 + r4
            android.graphics.Paint r3 = r0.espBoxPaint
            r29 = r1
            r31 = r8
            r34 = r3
            r29.drawRect(r30, r31, r32, r33, r34)
        L_0x0474:
            java.lang.String r1 = "Line"
            boolean r1 = r0.getConfig(r1)
            if (r1 == 0) goto L_0x04b3
            int r1 = r0.height
            r3 = 1000(0x3e8, float:1.401E-42)
            if (r1 >= r3) goto L_0x049b
            android.graphics.Canvas r1 = r0.canvas
            int r3 = r0.width
            r4 = 2
            int r3 = r3 / r4
            float r3 = (float) r3
            r23 = 1118437376(0x42aa0000, float:85.0)
            android.graphics.Paint r4 = r0.linePaint
            r21 = r1
            r22 = r3
            r24 = r2
            r25 = r8
            r26 = r4
            r21.drawLine(r22, r23, r24, r25, r26)
            goto L_0x04b3
        L_0x049b:
            android.graphics.Canvas r1 = r0.canvas
            int r3 = r0.width
            r4 = 2
            int r3 = r3 / r4
            float r3 = (float) r3
            r23 = 1122369536(0x42e60000, float:115.0)
            android.graphics.Paint r4 = r0.linePaint
            r21 = r1
            r22 = r3
            r24 = r2
            r25 = r8
            r26 = r4
            r21.drawLine(r22, r23, r24, r25, r26)
        L_0x04b3:
            java.lang.String r1 = "Distance"
            boolean r1 = r0.getConfig(r1)
            if (r1 == 0) goto L_0x0605
            android.graphics.Canvas r1 = r0.canvas
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r12)
            java.lang.String r4 = "  m"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r4 = 1103626240(0x41c80000, float:25.0)
            float r2 = r2 - r4
            float r11 = r11 + r10
            int r4 = r0.height
            float r4 = (float) r4
            float r4 = r4 / r17
            r6 = 1101004800(0x41a00000, float:20.0)
            float r4 = r4 - r6
            float r4 = r4 / r27
            float r11 = r11 + r4
            r4 = 1106247680(0x41f00000, float:30.0)
            float r11 = r11 + r4
            android.graphics.Paint r4 = r0.distancePaint
            r1.drawText(r3, r2, r11, r4)
            goto L_0x0605
        L_0x04e7:
            java.lang.String r1 = "Back Mark"
            boolean r1 = r0.getConfig(r1)
            if (r1 != 0) goto L_0x04f1
            goto L_0x0605
        L_0x04f1:
            int r1 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r1 < 0) goto L_0x0557
            int r1 = r0.height
            int r8 = r1 + -150
            float r8 = (float) r8
            int r8 = (r11 > r8 ? 1 : (r11 == r8 ? 0 : -1))
            if (r8 > 0) goto L_0x0557
            int r8 = r0.width
            int r9 = r8 / 2
            float r9 = (float) r9
            int r2 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r2 <= 0) goto L_0x0531
            android.graphics.Canvas r2 = r0.canvas
            float r6 = (float) r8
            float r1 = (float) r1
            float r1 = r1 - r11
            android.graphics.Paint r8 = r0.backCirclePaint
            r2.drawCircle(r6, r1, r4, r8)
            android.graphics.Canvas r1 = r0.canvas
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r12)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            int r3 = r0.width
            float r3 = (float) r3
            float r3 = r3 - r7
            int r4 = r0.height
            float r4 = (float) r4
            float r4 = r4 - r11
            android.graphics.Paint r6 = r0.sideDistancePaint
            r1.drawText(r2, r3, r4, r6)
            goto L_0x0605
        L_0x0531:
            android.graphics.Canvas r2 = r0.canvas
            float r1 = (float) r1
            float r1 = r1 - r11
            android.graphics.Paint r7 = r0.backCirclePaint
            r8 = 0
            r2.drawCircle(r8, r1, r4, r7)
            android.graphics.Canvas r1 = r0.canvas
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r12)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            int r3 = r0.height
            float r3 = (float) r3
            float r3 = r3 - r11
            android.graphics.Paint r4 = r0.sideDistancePaint
            r1.drawText(r2, r6, r3, r4)
            goto L_0x0605
        L_0x0557:
            int r1 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r1 >= 0) goto L_0x05a7
            int r1 = r0.width
            int r8 = r1 / 2
            float r8 = (float) r8
            int r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r2 <= 0) goto L_0x0588
            android.graphics.Canvas r2 = r0.canvas
            float r1 = (float) r1
            android.graphics.Paint r6 = r0.backCirclePaint
            r2.drawCircle(r1, r15, r4, r6)
            android.graphics.Canvas r1 = r0.canvas
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r12)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            int r3 = r0.width
            float r3 = (float) r3
            float r3 = r3 - r7
            android.graphics.Paint r4 = r0.sideDistancePaint
            r1.drawText(r2, r3, r15, r4)
            goto L_0x0605
        L_0x0588:
            android.graphics.Canvas r1 = r0.canvas
            android.graphics.Paint r2 = r0.backCirclePaint
            r7 = 0
            r1.drawCircle(r7, r15, r4, r2)
            android.graphics.Canvas r1 = r0.canvas
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r12)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            android.graphics.Paint r3 = r0.sideDistancePaint
            r1.drawText(r2, r6, r15, r3)
            goto L_0x0605
        L_0x05a7:
            int r1 = r0.width
            int r8 = r1 / 2
            float r8 = (float) r8
            int r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r2 <= 0) goto L_0x05dd
            android.graphics.Canvas r2 = r0.canvas
            float r1 = (float) r1
            int r6 = r0.height
            int r6 = r6 + -120
            float r6 = (float) r6
            android.graphics.Paint r8 = r0.backCirclePaint
            r2.drawCircle(r1, r6, r4, r8)
            android.graphics.Canvas r1 = r0.canvas
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r12)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            int r3 = r0.width
            float r3 = (float) r3
            float r3 = r3 - r7
            int r4 = r0.height
            int r4 = r4 + -120
            float r4 = (float) r4
            android.graphics.Paint r6 = r0.sideDistancePaint
            r1.drawText(r2, r3, r4, r6)
            goto L_0x0605
        L_0x05dd:
            android.graphics.Canvas r1 = r0.canvas
            int r2 = r0.height
            int r2 = r2 + -120
            float r2 = (float) r2
            android.graphics.Paint r7 = r0.backCirclePaint
            r8 = 0
            r1.drawCircle(r8, r2, r4, r7)
            android.graphics.Canvas r1 = r0.canvas
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r12)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            int r3 = r0.height
            int r3 = r3 + -120
            float r3 = (float) r3
            android.graphics.Paint r4 = r0.sideDistancePaint
            r1.drawText(r2, r6, r3, r4)
        L_0x0605:
            r7 = r36
        L_0x0607:
            int r6 = r37 + 1
            r1 = r28
            r4 = r35
            r2 = 1
            r3 = 0
            goto L_0x001d
        L_0x0611:
            r31 = r9
            if (r7 == 0) goto L_0x068c
            int r1 = r0.height
            r2 = 1000(0x3e8, float:1.401E-42)
            if (r1 >= r2) goto L_0x0654
            android.graphics.Canvas r8 = r0.canvas
            int r1 = r0.width
            int r2 = r1 / 2
            r3 = 30
            int r2 = r2 - r3
            float r9 = (float) r2
            r10 = 1112014848(0x42480000, float:50.0)
            r2 = 2
            int r1 = r1 / r2
            int r1 = r1 + r3
            float r11 = (float) r1
            r12 = 1118437376(0x42aa0000, float:85.0)
            android.graphics.Paint r13 = r0.rectPaint
            r8.drawRect(r9, r10, r11, r12, r13)
            android.graphics.Canvas r1 = r0.canvas
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r3 = r31
            r2.append(r3)
            r2.append(r7)
            java.lang.String r2 = r2.toString()
            int r3 = r0.width
            r4 = 2
            int r3 = r3 / r4
            int r3 = r3 + -15
            float r3 = (float) r3
            r4 = 1118044160(0x42a40000, float:82.0)
            android.graphics.Paint r5 = r0.textPaint
            r1.drawText(r2, r3, r4, r5)
            goto L_0x068c
        L_0x0654:
            r3 = r31
            android.graphics.Canvas r8 = r0.canvas
            int r1 = r0.width
            int r2 = r1 / 2
            r4 = 30
            int r2 = r2 - r4
            float r9 = (float) r2
            r10 = 1117126656(0x42960000, float:75.0)
            r2 = 2
            int r1 = r1 / r2
            int r1 = r1 + r4
            float r11 = (float) r1
            r12 = 1122369536(0x42e60000, float:115.0)
            android.graphics.Paint r13 = r0.rectPaint
            r8.drawRect(r9, r10, r11, r12, r13)
            android.graphics.Canvas r1 = r0.canvas
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r3)
            r2.append(r7)
            java.lang.String r2 = r2.toString()
            int r3 = r0.width
            r4 = 2
            int r3 = r3 / r4
            int r3 = r3 + -20
            float r3 = (float) r3
            r4 = 1121976320(0x42e00000, float:112.0)
            android.graphics.Paint r5 = r0.textPaint
            r1.drawText(r2, r3, r4, r5)
        L_0x068c:
            android.widget.ImageView r1 = r0.imgv
            r1.postInvalidate()
            r1 = 1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.desi.Overlay.updateOver(java.lang.String):boolean");
    }

    public void clearCanvas() {
        this.canvas.drawColor(0, Mode.CLEAR);
        this.canvas.drawText(this.amit, 30.0f, (float) (this.height - 30), this.distancePaint);
    }

    public void clearCanvasNative() {
        this.canvas.drawColor(0, Mode.CLEAR);
        this.canvas.drawText(this.amit, 30.0f, (float) (this.height - 30), this.distancePaint);
        this.imgv.postInvalidate();
    }

    public void lobby() {
        this.canvas.drawColor(0, Mode.CLEAR);
        this.canvas.drawText(this.amit, 30.0f, (float) (this.height - 30), this.distancePaint);
        String str = "Lobby";
        if (this.height < 1000) {
            this.canvas.drawText(str, (float) ((this.width / 2) - 25), 82.0f, this.textPaint);
        } else {
            this.canvas.drawText(str, (float) ((this.width / 2) - 30), 112.0f, this.textPaint);
        }
        this.imgv.postInvalidate();
    }

    public static void HideFloat() {
        Overlay overlay = Instance;
        if (overlay != null) {
            overlay.Hide();
        }
    }

    public void Hide() {
        Instance = null;
        try {
            this.manager.removeView(this.mFloatingView);
        } catch (Exception e) {
            System.out.println(e);
        }
        stopSelf();
        onDestroy();
    }

    /* access modifiers changed from: 0000 */
    public void init() {
        this.textPaint.setARGB(255, 255, 0, 0);
        this.textPaint.setTextSize(((float) this.height) / 27.0f);
        this.rectPaint.setARGB(40, 0, 200, 0);
        this.healthBoxPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.healthBoxPaint.setStyle(Style.STROKE);
        this.healthBoxPaint.setStrokeWidth(((float) this.height) / 1080.0f);
        this.linePaint.setStrokeWidth(((float) this.height) / 360.0f);
        this.linePaint.setAntiAlias(true);
        this.vechilePaint.setTextSize(((float) this.height) / 36.0f);
        this.vechilePaint.setColor(InputDeviceCompat.SOURCE_ANY);
        this.vechilePaint.setAlpha(150);
        this.distancePaint.setColor(SupportMenu.CATEGORY_MASK);
        this.distancePaint.setTextSize(((float) this.height) / 36.0f);
        this.namePaint.setColor(-1);
        this.namePaint.setTextSize(((float) this.height) / 36.0f);
        this.namePaint.setAntiAlias(true);
        this.headEnemyPaint.setColor(-16711936);
        this.headEnemyPaint.setAlpha(150);
        this.espBoxPaint.setStyle(Style.STROKE);
        this.espBoxPaint.setStrokeWidth(((float) this.height) / 540.0f);
        this.backCirclePaint.setColor(-65281);
        this.backCirclePaint.setAlpha(100);
        this.sideDistancePaint.setColor(-16711936);
        this.sideDistancePaint.setTextSize(((float) this.height) / 36.0f);
        this.itemPaint.setColor(-16776961);
        this.itemPaint.setFakeBoldText(true);
        this.itemPaint.setTextSize(((float) this.height) / 36.0f);
    }

    public static void ShowFloat(Context context) {
        if (Instance == null) {
            context.startService(new Intent(context, Overlay.class));
        }
    }

    /* access modifiers changed from: 0000 */
    public void DrawBones(float f, float f2, String str) {
        String[] split = str.split(":");
        try {
            float parseFloat = Float.parseFloat(split[0]);
            float parseFloat2 = Float.parseFloat(split[1]);
            float parseFloat3 = Float.parseFloat(split[2]);
            float parseFloat4 = Float.parseFloat(split[3]);
            float parseFloat5 = Float.parseFloat(split[4]);
            float parseFloat6 = Float.parseFloat(split[5]);
            float parseFloat7 = Float.parseFloat(split[6]);
            float parseFloat8 = Float.parseFloat(split[7]);
            float parseFloat9 = Float.parseFloat(split[8]);
            float parseFloat10 = Float.parseFloat(split[9]);
            float parseFloat11 = Float.parseFloat(split[10]);
            float parseFloat12 = Float.parseFloat(split[11]);
            float parseFloat13 = Float.parseFloat(split[12]);
            float parseFloat14 = Float.parseFloat(split[13]);
            float parseFloat15 = Float.parseFloat(split[14]);
            float parseFloat16 = Float.parseFloat(split[15]);
            float parseFloat17 = Float.parseFloat(split[16]);
            float parseFloat18 = Float.parseFloat(split[17]);
            float parseFloat19 = Float.parseFloat(split[18]);
            float parseFloat20 = Float.parseFloat(split[19]);
            float parseFloat21 = Float.parseFloat(split[20]);
            float parseFloat22 = Float.parseFloat(split[21]);
            float parseFloat23 = Float.parseFloat(split[22]);
            float parseFloat24 = Float.parseFloat(split[23]);
            float parseFloat25 = Float.parseFloat(split[24]);
            float parseFloat26 = Float.parseFloat(split[25]);
            float parseFloat27 = Float.parseFloat(split[26]);
            float parseFloat28 = Float.parseFloat(split[27]);
            float parseFloat29 = Float.parseFloat(split[28]);
            float parseFloat30 = Float.parseFloat(split[29]);
            this.skeltonPaint.setARGB(120, 255, 255, 255);
            this.skeltonPaint.setStrokeWidth(((float) this.height) / 400.0f);
            this.canvas.drawLine(f, f2, parseFloat, parseFloat2, this.skeltonPaint);
            float f3 = parseFloat;
            float f4 = parseFloat2;
            this.canvas.drawLine(f3, f4, parseFloat3, parseFloat4, this.skeltonPaint);
            this.canvas.drawLine(parseFloat3, parseFloat4, parseFloat5, parseFloat6, this.skeltonPaint);
            this.canvas.drawLine(f3, f4, parseFloat7, parseFloat8, this.skeltonPaint);
            this.canvas.drawLine(f3, f4, parseFloat9, parseFloat10, this.skeltonPaint);
            this.canvas.drawLine(parseFloat7, parseFloat8, parseFloat11, parseFloat12, this.skeltonPaint);
            this.canvas.drawLine(parseFloat9, parseFloat10, parseFloat13, parseFloat14, this.skeltonPaint);
            this.canvas.drawLine(parseFloat11, parseFloat12, parseFloat15, parseFloat16, this.skeltonPaint);
            this.canvas.drawLine(parseFloat13, parseFloat14, parseFloat17, parseFloat18, this.skeltonPaint);
            float f5 = parseFloat5;
            float f6 = parseFloat6;
            this.canvas.drawLine(f5, f6, parseFloat19, parseFloat20, this.skeltonPaint);
            this.canvas.drawLine(f5, f6, parseFloat21, parseFloat22, this.skeltonPaint);
            this.canvas.drawLine(parseFloat19, parseFloat20, parseFloat23, parseFloat24, this.skeltonPaint);
            this.canvas.drawLine(parseFloat21, parseFloat22, parseFloat25, parseFloat26, this.skeltonPaint);
            this.canvas.drawLine(parseFloat23, parseFloat24, parseFloat27, parseFloat28, this.skeltonPaint);
            this.canvas.drawLine(parseFloat25, parseFloat26, parseFloat29, parseFloat30, this.skeltonPaint);
        } catch (Exception unused) {
        }
    }

    public static void ShowFloat(Context context, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (Instance == null) {
            Intent intent = new Intent(context, Overlay.class);
            String str = "isBox";
            String str2 = "1";
            String str3 = "0";
            if (i == 1) {
                intent.putExtra(str, str2);
            } else {
                intent.putExtra(str, str3);
            }
            String str4 = "isLine";
            if (i2 == 1) {
                intent.putExtra(str4, str2);
            } else {
                intent.putExtra(str4, str3);
            }
            String str5 = "isHead";
            if (i3 == 1) {
                intent.putExtra(str5, str2);
            } else {
                intent.putExtra(str5, str3);
            }
            String str6 = "isDist";
            if (i4 == 1) {
                intent.putExtra(str6, str2);
            } else {
                intent.putExtra(str6, str3);
            }
            String str7 = "isName";
            if (i6 == 1) {
                intent.putExtra(str7, str2);
            } else {
                intent.putExtra(str7, str3);
            }
            String str8 = "isHealth";
            if (i7 == 1) {
                intent.putExtra(str8, str2);
            } else {
                intent.putExtra(str8, str3);
            }
            String str9 = "isBack";
            if (i5 == 1) {
                intent.putExtra(str9, str2);
            } else {
                intent.putExtra(str9, str3);
            }
            context.startService(intent);
        }
    }

    private void SetFloatView() {
        this.mFloatingView = LayoutInflater.from(this).inflate(R.layout.float_view, null);
        LayoutParams layoutParams = new LayoutParams(-1, -1, 0, getNavigationBarHeight(), VERSION.SDK_INT >= 26 ? 2038 : 2006, 1304, 1);
        if (VERSION.SDK_INT >= 28) {
            layoutParams.layoutInDisplayCutoutMode = 1;
        }
        layoutParams.gravity = 8388659;
        layoutParams.x = 0;
        layoutParams.y = 0;
        WindowManager windowManager = (WindowManager) getSystemService("window");
        this.manager = windowManager;
        windowManager.addView(this.mFloatingView, layoutParams);
    }

    /* access modifiers changed from: 0000 */
    public String getName(String str) {
        String[] split = str.split(":");
        char[] cArr = new char[split.length];
        for (int i = 0; i < split.length; i++) {
            cArr[i] = (char) Integer.parseInt(split[i]);
        }
        return new String(cArr);
    }

    public int getNavigationBarHeight() {
        boolean hasPermanentMenuKey = ViewConfiguration.get(this).hasPermanentMenuKey();
        int identifier = getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier <= 0 || hasPermanentMenuKey) {
            return 0;
        }
        return getResources().getDimensionPixelSize(identifier);
    }

    private String getItemName(int i) {
        if (i == 203005) {
            this.itemPaint.setARGB(255, 247, 99, 245);
            return "8x";
        } else if (i == 203014) {
            this.itemPaint.setARGB(255, 99, 198, 255);
            return "3X";
        } else if (i == 203015) {
            this.itemPaint.setARGB(255, 247, 99, 245);
            return "6x";
        } else if (i == 203004) {
            this.itemPaint.setARGB(255, 99, 198, 255);
            return "4x";
        } else if (i == 101004) {
            this.itemPaint.setARGB(255, 131, 222, 143);
            return "M416";
        } else if (i == 101001) {
            this.itemPaint.setARGB(255, 43, 26, 28);
            return "AKM";
        } else if (i == 103002) {
            this.itemPaint.setARGB(255, 247, 99, 245);
            return "M24";
        } else if (i == 103001) {
            this.itemPaint.setARGB(255, 247, 99, 245);
            return "Kar98k";
        } else if (i == 501006 || i == 501003) {
            this.itemPaint.setARGB(255, 106, 89, 255);
            return "Bag L3";
        } else if (i == 503003) {
            this.itemPaint.setARGB(255, 106, 89, 255);
            return "Vest L3";
        } else if (i == 502003) {
            this.itemPaint.setARGB(255, 106, 89, 255);
            return "Helmet L3";
        } else if (i != 106007) {
            return "";
        } else {
            this.itemPaint.setARGB(255, 189, 107, 227);
            return "Flare Gun";
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean getConfig(String str) {
        return getSharedPreferences("espValue", 0).getBoolean(str, false);
    }
}
