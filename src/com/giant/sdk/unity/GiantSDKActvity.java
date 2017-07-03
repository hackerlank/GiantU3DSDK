package com.giant.sdk.unity;

import android.content.Intent;
import android.content.res.Configuration;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;

import com.unity3d.player.UnityPlayerActivity;
import com.ztgame.mobileappsdk.common.IZTLibBase;

public class GiantSDKActvity extends UnityPlayerActivity{
	   private  static String  Tag = GiantSDKActvity.class.getSimpleName();
	    @Override
	    protected void onCreate(Bundle args) {
	         super.onCreate(args);
	         
	         IZTLibBase.newInstance(this);//实例化
			 
	    }
	 
	    @Override
	    protected void onDestroy() {
	    	super.onDestroy();
	     
	    try {
	    	 IZTLibBase.getInstance().destroyZTGame();
	 	    IZTLibBase.delInstance();
		} catch (Exception e) {
			// TODO: handle exception
		}
	      
	    }

	    @Override
	    protected void onPause() {	      
	      super.onPause();
	      try {
	    	  IZTLibBase.getInstance().onPauseZTGame();
		} catch (Exception e) {
			// TODO: handle exception
		}
	     
	    }

	    @Override
	    protected void onStop() {
	        super.onStop();     
	        try {
	        	  IZTLibBase.getInstance().onStopZTGame();
			} catch (Exception e) {
				// TODO: handle exception
			}
	    }

	    @Override
	    protected void onResume() {	     
	      super.onResume();     
	       
	    	  IZTLibBase.getInstance().onResumeZTGame();
	    
	    }

	    @Override
	    protected void onStart() {
	        super.onStart();
	        IZTLibBase.getInstance().onStartZTGame();
			 
	    }

	    @Override
	    protected void onRestart() {
	        super.onRestart();
	        
	        try {
	        	IZTLibBase.getInstance().onRestartZTGame();
			} catch (Exception e) {
				// TODO: handle exception
			}
	    }

	    @Override
	    public void onConfigurationChanged(Configuration newConfig) {
	        super.onConfigurationChanged(newConfig);       
	        
	        try {
	        	IZTLibBase.getInstance().onConfigurationChangedZTGame(newConfig);
			} catch (Exception e) {
				// TODO: handle exception
			}
	    }

	    @Override
	    protected void onNewIntent(Intent intent) {
	        super.onNewIntent(intent);
	       
	        try {
	        	 IZTLibBase.getInstance().onNewIntentZTGame(intent);
			} catch (Exception e) {
				// TODO: handle exception
			}
	    }

	    @Override
	    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	        super.onActivityResult(requestCode, resultCode, data);
	      
	        try {
	        	  IZTLibBase.getInstance().onActivityResultZTGame(requestCode, resultCode, data);
			} catch (Exception e) {
				// TODO: handle exception
			}
	    }

	    @Override
	    public void onSaveInstanceState(Bundle outState) {
	        super.onSaveInstanceState(outState);
	       
	        try {
	        	 IZTLibBase.getInstance().onSaveInstanceState(outState);
			} catch (Exception e) {
				// TODO: handle exception
			}
	    }

	/**
	 * 头像设置调用
	 * TODO: 获取相册图片 - 打开相册拍照
	 * @param strObjectName Unity回调对象名字
	 * @param strFuncName Unity回调挂在对象上的Mono函数名
	 * @param strFileName Unity传过来的 图片保存名字 (仅仅是文件名,并非全路径)
	 * !!Warnning!! : 图片文件统一保存在路径 Application.persistentDataPath (For Unity)中
	 */
	public  void SettingAvaterFormMobile(
			String strObjectName,String strFuncName, String strFileName)
	{
		if (strFileName.equals(null) || strObjectName.equals(null) || strFuncName.equals(null))
		{
			CommonUtil.Log("at func [SettingAvaterFormMobile],some string is null!");
			CommonUtil.Log("strObjectName = " + strObjectName);
			CommonUtil.Log("strFuncName = " + strFuncName);
			CommonUtil.Log("strFileName = " + strFileName);
			return;
		}

		Intent intent = new Intent(this, UserAvatarActivity.class);
		intent.putExtra(CommonUtil.ENUM_PARAM.eParam_ObjectName.toString(),strObjectName);
		intent.putExtra(CommonUtil.ENUM_PARAM.eParam_FuncName.toString(),strFuncName);
		intent.putExtra(CommonUtil.ENUM_PARAM.eParam_FileName.toString(),strFileName);
		this.startActivity(intent);
	}

}
