package com.skywell.car.uimode.skin.attr;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ListView;

public class AttrDivider extends AttrSkin {

	public int dividerHeight = 1;

	@Override
	public void apply(View view) {
		if(view instanceof ListView){
			ListView tv = (ListView)view;
			if(RES_TYPE_NAME_COLOR.equals(attrValueTypeName)){
				int color = view.getContext().getColor(attrValueRefId);
				ColorDrawable sage = new ColorDrawable(color);
				tv.setDivider(sage);
				tv.setDividerHeight(dividerHeight);
			}else if(RES_TYPE_NAME_DRAWABLE.equals(attrValueTypeName)){
				tv.setDivider(view.getContext().getDrawable(attrValueRefId));
			}
		}
	}
}
