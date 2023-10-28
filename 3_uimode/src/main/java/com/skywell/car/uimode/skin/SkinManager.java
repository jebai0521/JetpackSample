package com.skywell.car.uimode.skin;

import android.graphics.drawable.Drawable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.LayoutInflaterCompat;

import com.skywell.car.uimode.util.SkinCompatResources;
import com.skywell.car.uimode.util.SkinCompatThemeUtils;

import java.util.HashMap;

public class SkinManager {

    private volatile static SkinManager sInstance = new SkinManager();

    private HashMap<AppCompatActivity, SkinLayoutInflater> mInflaterHashMap = new HashMap<>();

    public static SkinManager getInstance() {
        return sInstance;
    }

    public void registerActivity(AppCompatActivity activity) {
        SkinLayoutInflater inflater = new SkinLayoutInflater(activity);
        LayoutInflaterCompat.setFactory2(activity.getLayoutInflater(), inflater);
        mInflaterHashMap.put(activity, inflater);
    }

    public void unregisterActivity(AppCompatActivity activity) {
        mInflaterHashMap.remove(activity);
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
