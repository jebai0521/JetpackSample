package com.skywell.car.uimode;

import android.app.UiModeManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class MainActivity2 extends BaseActivity {

    private static final String TAG = "MainActivity2";

    private TextView mMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMessage = findViewById(R.id.message);
        String message = "Hello";
        switch (mUiModeManager.getNightMode()) {
            case UiModeManager.MODE_NIGHT_NO:
                message = "MODE_NIGHT_NO";
                break;
            case UiModeManager.MODE_NIGHT_YES:
                message = "MODE_NIGHT_YES";
                break;
            case UiModeManager.MODE_NIGHT_AUTO:
                message = "MODE_NIGHT_AUTO";
                break;
            case UiModeManager.MODE_NIGHT_CUSTOM:
                message = "MODE_NIGHT_CUSTOM";
                break;
            default:
                message = "MODE_NIGHT_CUSTOM";
                break;
        }
        mMessage.setText(message);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        String message = "Hello";
        switch (mUiModeManager.getNightMode()) {
            case UiModeManager.MODE_NIGHT_NO:
                message = "MODE_NIGHT_NO";
                break;
            case UiModeManager.MODE_NIGHT_YES:
                message = "MODE_NIGHT_YES";
                break;
            case UiModeManager.MODE_NIGHT_AUTO:
                message = "MODE_NIGHT_AUTO";
                break;
            case UiModeManager.MODE_NIGHT_CUSTOM:
                message = "MODE_NIGHT_CUSTOM";
                break;
            default:
                message = "MODE_NIGHT_CUSTOM";
                break;
        }
        mMessage.setText(message);
        Log.i(TAG, "view : " + mMessage);
//        mMessage.setTextColor(getColor(R.color.textColor));
    }
}
