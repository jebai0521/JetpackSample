package com.skywell.car.uimode;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class BaseActivity extends AppCompatActivity {

    private static final String TAG = "BaseActivity";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        Log.i(TAG, this.getClass().getSimpleName() + " onCreate");
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, this.getClass().getSimpleName() + " onCreate");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, this.getClass().getSimpleName() + " onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, this.getClass().getSimpleName() + " onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, this.getClass().getSimpleName() + " onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, this.getClass().getSimpleName() + " onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, this.getClass().getSimpleName() + " onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, this.getClass().getSimpleName() + " onDestroy");
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        int uiMode = newConfig.uiMode & Configuration.UI_MODE_NIGHT_MASK;

        Log.i(TAG, this.getClass().getSimpleName() + " onConfigurationChanged" + newConfig + ", " + newConfig.uiMode + ", " + uiMode);

//        recreate();
//        getDelegate().setLocalNightMode(newConfig.uiMode);
//        if (uiMode == Configuration.UI_MODE_NIGHT_NO) {
//            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//        } else if (uiMode == Configuration.UI_MODE_NIGHT_YES) {
//            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//        } else {
//            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//        }

        if (uiMode == Configuration.UI_MODE_NIGHT_NO) {
//            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        } else if (uiMode == Configuration.UI_MODE_NIGHT_YES) {
//            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
//            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }

    @Override
    protected void onNightModeChanged(int mode) {
        super.onNightModeChanged(mode);
        Log.i(TAG, this.getClass().getSimpleName() + " onNightModeChanged " + mode);
//        recreate();
    }
}
