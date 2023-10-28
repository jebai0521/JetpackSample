package com.skywell.car.uimode.skin.attr;

import android.view.View;
import android.widget.AbsListView;

public class AttrListSelector extends AttrSkin {

	@Override
	public void apply(View view) {
		if(view instanceof AbsListView){
			AbsListView tv = (AbsListView)view;

			if(RES_TYPE_NAME_COLOR.equals(attrValueTypeName)){
				tv.setSelector(attrValueRefId);
			}else if(RES_TYPE_NAME_DRAWABLE.equals(attrValueTypeName)){
				tv.setSelector(view.getContext().getDrawable(attrValueRefId));
			}
		}
	}
}
