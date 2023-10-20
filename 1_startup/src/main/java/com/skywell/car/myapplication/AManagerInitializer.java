package com.skywell.car.myapplication;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.startup.Initializer;

import java.util.Collections;
import java.util.List;

public class AManagerInitializer implements Initializer<AManager> {
    private static final String TAG = "AInitialize";
    @NonNull
    @Override
    public AManager create(@NonNull Context context) {
        Log.i(TAG, "onCreate");
        return new AManager();
    }

    @NonNull
    @Override
    public List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.emptyList();
    }
}
