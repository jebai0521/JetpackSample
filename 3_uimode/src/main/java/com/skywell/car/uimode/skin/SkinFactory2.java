package com.skywell.car.uimode.skin;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.app.AppCompatViewInflater;


import com.skywell.car.uimode.skin.attr.AttrFactory;
import com.skywell.car.uimode.skin.attr.AttrSkin;
import com.skywell.car.uimode.skin.observer.SkinChangeObserver;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * author : mingchen
 * e-mail : mingchen@coocaa.com
 * time : 2023/10/25
 * desc :
 * </pre>
 */
public class SkinFactory2 implements LayoutInflater.Factory2 {
    private static final String TAG = "SkyLayoutInflater";
    private WeakReference<Context> mContextWeakReference;

    private Map<View, SkinItem> mSkinMap = new HashMap<>();

    private List<SkinChangeObserver> mObservers = new ArrayList<>();


    private AppCompatViewInflater mAppCompatViewInflater;

    public SkinFactory2(Context context) {
        mContextWeakReference = new WeakReference<>(context);
    }

    @Nullable
    @Override
    public View onCreateView(@Nullable View parent, @NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        Log.i(TAG, "onCreateView " + name);

        Context ctx = mContextWeakReference.get();
        View view = null;
        if (ctx == null) {
            return view;
        }

        if (ctx instanceof AppCompatActivity) {
            AppCompatDelegate delegate = ((AppCompatActivity) ctx).getDelegate();
            view = delegate.createView(parent, name, context, attrs);
        } else  {
            if (mAppCompatViewInflater == null) {
                mAppCompatViewInflater = new AppCompatViewInflater();
            }

            boolean inheritContext = false;
            return mAppCompatViewInflater.createView(parent, name, context, attrs, false,
                    false,
                    true,
                    false
            );
        }

        if (view != null) {
            collectSkinView(context, name, attrs, view);
        }
        return view;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        return onCreateView(null, name, context, attrs);
    }

    private void collectSkinView(Context context, String name, AttributeSet attrs, View view) {

        List<AttrSkin> par = new ArrayList<>();
        for (int i = 0; i < attrs.getAttributeCount(); i++) {
            String attrName = attrs.getAttributeName(i);
            String attrValue = attrs.getAttributeValue(i);
            Log.i(TAG, "collectSkinView name = " + name + " attrName = " + attrName + " attrValue = " + attrValue);
            if (AttrFactory.isSupportedAttr(attrName)) {
                int id = Integer.parseInt(attrValue.substring(1));
                String entryName = context.getResources().getResourceEntryName(id);
                //typeName，eg:color、drawable
                String typeName = context.getResources().getResourceTypeName(id);

                AttrSkin change = AttrFactory.get(attrName, id, entryName, typeName);
                par.add(change);
            }
        }

        if (par.size() == 0) {
            return;
        }
        SkinItem item = new SkinItem(view, par);
        mSkinMap.put(view, item);

        if (view instanceof SkinChangeObserver) {
            mObservers.add((SkinChangeObserver) view);
        }
    }

    public void onUiModeChanged() {
        Log.i(TAG, "onUiModeChanged " + mSkinMap.size());
        mSkinMap.forEach((view, skinItem) -> skinItem.apply());
        mObservers.forEach(SkinChangeObserver::applySkin);
    }
}
