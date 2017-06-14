package com.giant.sdk;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.text.TextUtils;
import android.util.Log;

import com.giant.jujias.common.GiantConsts;
import com.plugin.ZTLibGiant;
import com.unity3d.player.UnityPlayer;
import com.ztgame.mobileappsdk.common.IZTLibBase;
import com.ztgame.mobileappsdk.common.ZTConsts;
import com.ztgame.mobileappsdk.common.IZTListener;

public class GiantListener implements IZTListener {
	public static final String TAG = GiantListener.class.getSimpleName();
	private String orderId;

	@Override
	public void onFinished(int what, int errcode, JSONObject jsonObject) {
		Log.d(TAG, String.valueOf(what) + "####" + errcode + "####" + jsonObject);

		try {
			String jsonStr = "";
			String param = "";
			switch (what) {
			case ZTConsts.ZTGAME_INIT:

				jsonStr = "";
				param = String.format("%s=%s&%s=%s&%s=%s",
						new Object[] { "what", String.valueOf(what), "code", String.valueOf(errcode), "msg", jsonStr });
				break;
			case ZTConsts.ZTGAME_LOGIN:

				if (jsonObject != null) {
					jsonStr = jsonObject.toString();
				}
				param = String.format("%s=%s&%s=%s&%s=%s",
						new Object[] { "what", String.valueOf(what), "code", String.valueOf(errcode), "msg", jsonStr });
				break;
			case ZTConsts.ZTGAME_LOGOUT:

				jsonStr = "";
				param = String.format("%s=%s&%s=%s&%s=%s",
						new Object[] { "what", String.valueOf(what), "code", String.valueOf(errcode), "msg", jsonStr });
				break;
			case ZTConsts.ZTGAME_CREATE_ORDER: {

				orderId = jsonObject.toString();
			}
				break;
			case ZTConsts.ZTGAME_PAY: {
				jsonStr = orderId;

				param = String.format("%s=%s&%s=%s&%s=%s",
						new Object[] { "what", String.valueOf(what), "code", String.valueOf(errcode), "msg", jsonStr });
			}
				break;
			case ZTConsts.ZTGAME_QUIT:
				jsonStr = jsonObject.toString();

				param = String.format("%s=%s&%s=%s&%s=%s",
						new Object[] { "what", String.valueOf(what), "code", String.valueOf(errcode), "msg", jsonStr });

				break;
			case GiantConsts.ZTGAME_REFERER_SETTING:
				jsonStr = "";
				param = String.format("%s=%s&%s=%s&%s=%s",
						new Object[]{"what", String.valueOf(what), "code", String.valueOf(errcode), "msg", jsonStr});
				break;
			
			case GiantConsts.ZTGAME_REALINFO_SETTING:
				jsonStr = "";
				param = String.format("%s=%s&%s=%s&%s=%s",
						new Object[]{"what", String.valueOf(what), "code", String.valueOf(errcode), "msg", jsonStr});
				break;
			}
				
			if (TextUtils.isEmpty(param)) {
				Log.d(TAG, " param empty ");
				return;
			}
			Log.d(TAG, "resultCallBack=" + param);
			UnityPlayer.UnitySendMessage(GiantSDK.getInstance().mUnityGameObjectName,
					GiantSDK.getInstance().mUnityMethodName, param);
			// GiantSDK.resultCallBack(what, errcode,jsonStr);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
};
