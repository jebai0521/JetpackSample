package com.skywell.car.uimode.skin.attr;


public class AttrFactory {

	public static final String BACKGROUND = "background";
	public static final String TEXT_COLOR = "textColor";
	public static final String LIST_SELECTOR = "listSelector";
	public static final String DIVIDER = "divider";

	public static AttrSkin get(String attrName, int attrValueRefId, String attrValueRefName, String typeName){

		AttrSkin mSkinAttr = null;

		if(BACKGROUND.equals(attrName)){
			mSkinAttr = new AttrBackground();
		}else if(TEXT_COLOR.equals(attrName)){
			mSkinAttr = new AttrTextColor();
		}else if(LIST_SELECTOR.equals(attrName)){
			mSkinAttr = new AttrListSelector();
		}else if(DIVIDER.equals(attrName)){
			mSkinAttr = new AttrDivider();
		}else{
			return null;
		}

		mSkinAttr.attrName = attrName;
		mSkinAttr.attrValueRefId = attrValueRefId;
		mSkinAttr.attrValueRefName = attrValueRefName;
		mSkinAttr.attrValueTypeName = typeName;
		return mSkinAttr;
	}

	/**
	 * Check whether the attribute is supported
	 * @param attrName
	 * @return true : supported <br>
	 * 		   false: not supported
	 */
	public static boolean isSupportedAttr(String attrName){
		if(BACKGROUND.equals(attrName)){
			return true;
		}
		if(TEXT_COLOR.equals(attrName)){
			return true;
		}
		if(LIST_SELECTOR.equals(attrName)){
			return true;
		}
		if(DIVIDER.equals(attrName)){
			return true;
		}
		return false;
	}
}
