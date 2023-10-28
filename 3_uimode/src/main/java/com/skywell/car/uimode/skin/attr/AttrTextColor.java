package com.skywell.car.uimode.skin.attr;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.skywell.car.uimode.R;

public class AttrTextColor extends AttrSkin {

	private static final String TAG = "TextColorAttr";

	@Override
	public void apply(View view) {
		if(view instanceof TextView){
			TextView tv = (TextView)view;
			if(RES_TYPE_NAME_COLOR.equals(attrValueTypeName)){
				Log.e(TAG, view + " TextColorAttr -> " + attrValueTypeName + " , " + R.color.textColor + ", " + view.getContext().getColor(R.color.textColor));
				tv.setTextColor(view.getContext().getColorStateList(attrValueRefId));
			}
		}
	}
}
