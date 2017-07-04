//*************************************************************************
//	创建日期:	2015-9-23
//	文件名称:	CommonUtil.java
//  创建作者:	Rect 	
//	版权所有:	Shadowkong.com
//	相关说明:	
//*************************************************************************
package com.giant.photo;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

public class CommonUtil 
{
	// ----------------------------------------------------------------------
	// 参数类型
	public enum ENUM_PARAM 
	{
		eParam_ObjectName, 
		eParam_FuncName, 
		eParam_FileName
	}

	// ----------------------------------------------------------------------
	// 返回消息类型 
	public enum ENUM_RESULT 
	{
		eResult_Failed, 
		eResult_Camera, 
		eResult_Picture, 
		eResult_Cancel, 
		eResult_Success, 
		eResult_Finish
	}

	// ----------------------------------------------------------------------
	private static String m_strLogTag = "Rect4Avatar";
	// ----------------------------------------------------------------------
	public static void Log(String strLog) 
	{
		Log.e(m_strLogTag, strLog);
	}

	public static int getLayoutId(Context paramContext, String paramString) {
		return paramContext.getResources().getIdentifier(paramString, "layout",
				paramContext.getPackageName());
	}

	public static int getAnimId(Context paramContext, String paramString) {
		return paramContext.getResources().getIdentifier(paramString, "anim",
				paramContext.getPackageName());
	}

	public static int getStringId(Context paramContext, String paramString) {
		return paramContext.getResources().getIdentifier(paramString, "string",
				paramContext.getPackageName());
	}

	public static int getDrawableId(Context paramContext, String paramString) {
		return paramContext.getResources().getIdentifier(paramString,
				"drawable", paramContext.getPackageName());
	}

	public static int getStyleId(Context paramContext, String paramString) {
		return paramContext.getResources().getIdentifier(paramString, "style",
				paramContext.getPackageName());
	}

	public static int getId(Context paramContext, String paramString) {
		return paramContext.getResources().getIdentifier(paramString, "id",
				paramContext.getPackageName());
	}

	public static int getColorId(Context paramContext, String paramString) {
		return paramContext.getResources().getIdentifier(paramString, "color",
				paramContext.getPackageName());
	}

	public static int getRawId(Context paramContext, String paramString) {
		return paramContext.getResources().getIdentifier(paramString, "raw",
				paramContext.getPackageName());
	}

	public static int getStyleableId(Context paramContext, String paramString) {
		return paramContext.getResources().getIdentifier(paramString,
				"styleable", paramContext.getPackageName());
	}

	public static int getAttrId(Context paramContext, String paramString) {
		return paramContext.getResources().getIdentifier(paramString, "attr",
				paramContext.getPackageName());
	}

	public static int getDimenById(Context paramContext, String paramString) {
		return paramContext.getResources().getIdentifier(paramString, "dimen", paramContext.getPackageName());
	}


}
