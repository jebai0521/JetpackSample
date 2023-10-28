package com.skywell.car.uimode.skin;

import android.util.Log;
import android.view.View;

import com.skywell.car.uimode.skin.attr.AttrSkin;
import com.skywell.car.uimode.util.ListUtils;

import java.util.ArrayList;
import java.util.List;

public class SkinItem {
	private static final String TAG = "SkinItem";

	public View view;

	public List<AttrSkin> attrs;

	public SkinItem(){
		attrs = new ArrayList<AttrSkin>();
	}

	public SkinItem(View view, List<AttrSkin> attrs){
		this.view = view;
		this.attrs = new ArrayList<AttrSkin>(attrs);
	}

	public void apply(){
		Log.i(TAG, "apply " + attrs.size());
		if(ListUtils.isEmpty(attrs)){
			return;
		}
		for(AttrSkin at : attrs){
			at.apply(view);
		}
	}

	public void clean(){
		if(ListUtils.isEmpty(attrs)){
			return;
		}
		for(AttrSkin at : attrs){
			at = null;
		}
	}

	@Override
	public String toString() {
		return "SkinItem [view=" + view.getClass().getSimpleName() + ", attrs=" + attrs + "]";
	}
}
