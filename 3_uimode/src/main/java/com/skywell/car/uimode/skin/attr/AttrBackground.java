package com.skywell.car.uimode.skin.attr;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;

public class AttrBackground extends AttrSkin {

	@Override
	public void apply(View view) {

		if(RES_TYPE_NAME_COLOR.equals(attrValueTypeName)){
			view.setBackgroundColor(view.getContext().getColor(attrValueRefId));
			Log.i("attr", "_________________________________________________________");
			Log.i("attr", "apply as color");
		}else if(RES_TYPE_NAME_DRAWABLE.equals(attrValueTypeName)){
			Drawable bg = view.getContext().getDrawable(attrValueRefId);
			view.setBackground(bg);
			Log.i("attr", "_________________________________________________________");
			Log.i("attr", "apply as drawable");
			Log.i("attr", "bg.toString()  " + bg.toString());

			Log.i("attr", this.attrValueRefName + " 是否可变换状态? : " + bg.isStateful());
		}
	}
}
