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

}
