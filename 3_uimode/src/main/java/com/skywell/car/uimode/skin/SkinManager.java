package com.skywell.car.uimode.skin;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.LayoutInflaterCompat;

import com.skywell.car.uimode.util.SkinCompatResources;
import com.skywell.car.uimode.util.SkinCompatThemeUtils;

import java.util.WeakHashMap;

public class SkinManager {

    private volatile static SkinManager sInstance = new SkinManager();

    private WeakHashMap<Context, SkinFactory2> mInflaterHashMap = new WeakHashMap<>();

    public static SkinManager getInstance() {
        return sInstance;
    }

    public void register(Context context) {
        SkinFactory2 inflater = new SkinFactory2(context);
        LayoutInflaterCompat.setFactory2(LayoutInflater.from(context), inflater);
        mInflaterHashMap.put(context, inflater);
        if (context instanceof Application) {
            ((Application)context).registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
                @Override
                public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {
                    register(activity);
                }

                @Override
                public void onActivityStarted(@NonNull Activity activity) {

                }

                @Override
                public void onActivityResumed(@NonNull Activity activity) {

                }

                @Override
                public void onActivityPaused(@NonNull Activity activity) {

                }

                @Override
                public void onActivityStopped(@NonNull Activity activity) {

                }

                @Override
                public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {

                }

                @Override
                public void onActivityDestroyed(@NonNull Activity activity) {
                    unregister(activity);
                }
            });
        }
    }

    public void unregister(Context context) {
        mInflaterHashMap.remove(context);
    }

    public void onConfigurationChanged(AppCompatActivity activity) {
        mInflaterHashMap.get(activity).onUiModeChanged();
        int windowBackgroundResId = SkinCompatThemeUtils.getWindowBackgroundResId(activity);
//        if (checkResourceId(windowBackgroundResId) != INVALID_ID) {
            Drawable drawable = SkinCompatResources.getInstance().getDrawable(windowBackgroundResId);
            if (drawable != null) {
                activity.getWindow().setBackgroundDrawable(drawable);
            }
//        }
    }
}
