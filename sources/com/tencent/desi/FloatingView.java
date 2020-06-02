package com.tencent.desi;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import android.widget.TextView;
import com.tencent.idk.R;

public class FloatingView extends Service implements OnClickListener {
    private static FloatingView Instance;
    View espView;
    View logoView;
    /* access modifiers changed from: private */
    public View mFloatingView;
    /* access modifiers changed from: private */
    public WindowManager mWindowManager;

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onClick(View view) {
    }

    public void onCreate() {
        super.onCreate();
        Instance = this;
        createOver();
        TextView textView = (TextView) this.mFloatingView.findViewById(R.id.textView4);
        if (!String.valueOf(textView.getText()).substring(2, 3).equals(String.valueOf(textView.getText()).substring(5, 6))) {
            System.exit(-1);
        }
        this.logoView = this.mFloatingView.findViewById(R.id.relativeLayoutParent);
        this.espView = this.mFloatingView.findViewById(R.id.espView);
        InitMain();
    }

    public static void ShowFloat(Context context) {
        if (Instance == null) {
            context.startService(new Intent(context, FloatingView.class));
        }
    }

    /* access modifiers changed from: 0000 */
    public void createOver() {
        this.mFloatingView = LayoutInflater.from(this).inflate(R.layout.float_logo, null);
        final LayoutParams layoutParams = new LayoutParams(-2, -2, VERSION.SDK_INT >= 26 ? 2038 : 2002, 8, 1);
        WindowManager windowManager = (WindowManager) getSystemService("window");
        this.mWindowManager = windowManager;
        windowManager.addView(this.mFloatingView, layoutParams);
        final GestureDetector gestureDetector = new GestureDetector(this, new SingleTapConfirm());
        ((TextView) this.mFloatingView.findViewById(R.id.closeBtn)).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                FloatingView.this.espView.setVisibility(8);
                FloatingView.this.logoView.setVisibility(0);
            }
        });
        this.mFloatingView.findViewById(R.id.relativeLayoutParent).setOnTouchListener(new OnTouchListener() {
            private float initialTouchX;
            private float initialTouchY;
            private int initialX;
            private int initialY;

            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (gestureDetector.onTouchEvent(motionEvent)) {
                    FloatingView.this.espView.setVisibility(0);
                    FloatingView.this.logoView.setVisibility(8);
                    return true;
                }
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.initialX = layoutParams.x;
                    this.initialY = layoutParams.y;
                    this.initialTouchX = motionEvent.getRawX();
                    this.initialTouchY = motionEvent.getRawY();
                    return true;
                } else if (action != 2) {
                    return false;
                } else {
                    layoutParams.x = this.initialX + ((int) (motionEvent.getRawX() - this.initialTouchX));
                    layoutParams.y = this.initialY + ((int) (motionEvent.getRawY() - this.initialTouchY));
                    FloatingView.this.mWindowManager.updateViewLayout(FloatingView.this.mFloatingView, layoutParams);
                    return true;
                }
            }
        });
    }

    public void onDestroy() {
        super.onDestroy();
        View view = this.mFloatingView;
        if (view != null) {
            this.mWindowManager.removeView(view);
        }
    }

    /* access modifiers changed from: private */
    public void setValue(String str, boolean z) {
        Editor edit = getSharedPreferences("espValue", 0).edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    /* access modifiers changed from: 0000 */
    public boolean getConfig(String str) {
        return getSharedPreferences("espValue", 0).getBoolean(str, false);
    }

    public static void HideFloat() {
        FloatingView floatingView = Instance;
        if (floatingView != null) {
            floatingView.Hide();
        }
    }

    public void Hide() {
        stopSelf();
        System.exit(-1);
    }

    /* access modifiers changed from: 0000 */
    public void InitMain() {
        final Switch switchR = (Switch) this.mFloatingView.findViewById(R.id.isItem);
        switchR.setChecked(getConfig((String) switchR.getText()));
        switchR.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                FloatingView.this.setValue(String.valueOf(switchR.getText()), switchR.isChecked());
            }
        });
        final Switch switchR2 = (Switch) this.mFloatingView.findViewById(R.id.isSkelton);
        switchR2.setChecked(getConfig((String) switchR2.getText()));
        switchR2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                FloatingView.this.setValue(String.valueOf(switchR2.getText()), switchR2.isChecked());
            }
        });
        final Switch switchR3 = (Switch) this.mFloatingView.findViewById(R.id.isBox);
        switchR3.setChecked(getConfig((String) switchR3.getText()));
        switchR3.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                FloatingView.this.setValue(String.valueOf(switchR3.getText()), switchR3.isChecked());
            }
        });
        final Switch switchR4 = (Switch) this.mFloatingView.findViewById(R.id.isHealth);
        switchR4.setChecked(getConfig((String) switchR4.getText()));
        switchR4.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                FloatingView.this.setValue(String.valueOf(switchR4.getText()), switchR4.isChecked());
            }
        });
        final Switch switchR5 = (Switch) this.mFloatingView.findViewById(R.id.isVech);
        switchR5.setChecked(getConfig((String) switchR5.getText()));
        switchR5.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                FloatingView.this.setValue(String.valueOf(switchR5.getText()), switchR5.isChecked());
            }
        });
        final Switch switchR6 = (Switch) this.mFloatingView.findViewById(R.id.isLine);
        switchR6.setChecked(getConfig((String) switchR6.getText()));
        switchR6.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                FloatingView.this.setValue(String.valueOf(switchR6.getText()), switchR6.isChecked());
            }
        });
        final Switch switchR7 = (Switch) this.mFloatingView.findViewById(R.id.isDist);
        switchR7.setChecked(getConfig((String) switchR7.getText()));
        switchR7.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                FloatingView.this.setValue(String.valueOf(switchR7.getText()), switchR7.isChecked());
            }
        });
        final Switch switchR8 = (Switch) this.mFloatingView.findViewById(R.id.isName);
        switchR8.setChecked(getConfig((String) switchR8.getText()));
        switchR8.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                FloatingView.this.setValue(String.valueOf(switchR8.getText()), switchR8.isChecked());
            }
        });
        final Switch switchR9 = (Switch) this.mFloatingView.findViewById(R.id.isHead);
        switchR9.setChecked(getConfig((String) switchR9.getText()));
        switchR9.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                FloatingView.this.setValue(String.valueOf(switchR9.getText()), switchR9.isChecked());
            }
        });
        final Switch switchR10 = (Switch) this.mFloatingView.findViewById(R.id.isBack);
        switchR10.setChecked(getConfig((String) switchR10.getText()));
        switchR10.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                FloatingView.this.setValue(String.valueOf(switchR10.getText()), switchR10.isChecked());
            }
        });
    }
}
