package com.skywell.car.uimode;

import android.app.Application;

import com.skywell.car.uimode.skin.SkinManager;
import com.skywell.car.uimode.util.SkinCompatResources;

/**
 * <pre>
 * author : mingchen
 * e-mail : mingchen@coocaa.com
 * time : 2023/10/26
 * desc :
 * </pre>
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SkinManager.getInstance().register(this);
        SkinCompatResources.init(this);
    }
}
