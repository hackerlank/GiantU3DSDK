package com.giant.sdk;

import android.app.Activity;
import android.util.Log;

import com.plugin.ZTLibGiant;
import com.unity3d.player.UnityPlayer;
import com.ztgame.mobileappsdk.common.IZTLibBase;
import com.ztgame.mobileappsdk.common.IZTListener;
import com.ztgame.mobileappsdk.common.ZTPayInfo;

import java.util.HashMap;
import java.util.Map;

public class GiantSDK {
	static private String TAG = GiantSDK.class.getSimpleName();
	static IZTListener  gaListener = null;
	public String mUnityGameObjectName;
    public String mUnityMethodName;
    
    private static GiantSDK Instance = null;
    public static GiantSDK getInstance() {
        if (null == Instance) {
            Instance = new GiantSDK();
        }
        return Instance;
    }

	public static void registerActionResultCallback(String gameObjectName, String functionName)
	  {
		 Log.d(TAG,"registerActionResultCallback");
	     getInstance().mUnityGameObjectName = gameObjectName;
	     getInstance().mUnityMethodName = functionName;
	     
	     Log.d(TAG, gameObjectName+",method = "+functionName);
	  }
	  

	public static void initGA(final String gameId,final String appName,final boolean isLanscape){
		
		getU3DContext().runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				 // 初始化
		        IZTLibBase.newInstance(getU3DContext());
		        
		        if(gaListener == null)
		        	gaListener = new GiantListener();
		        
		        Log.d(TAG," java data  from c# gameid =  "+gameId+",appName = "+appName);
		        
		        IZTLibBase.getInstance().initZTGame(gameId,appName,isLanscape, gaListener);
			}
		});
	}
	 
	public static void login(final boolean isautoLogin){
		Log.d(TAG, " Start login isautoLogin new = "+isautoLogin );
		getU3DContext().runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				
				((ZTLibGiant)IZTLibBase.getInstance()).loginZTGame("", "", isautoLogin);
			}
			});
	}
	public static void showRealInfoView(){
		Log.d(TAG, "   showRealInfoView  " );
		getU3DContext().runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				
				((ZTLibGiant)IZTLibBase.getInstance()).showRealInfoView();
			}
			});
	}
	
	public static boolean isRealInfoSetted(){
		Log.d(TAG, "   isRealInfoSetted  " );
		return ((ZTLibGiant)IZTLibBase.getInstance()).isRealInfoSetted();
	}
	public static void promoterCenter(){
		Log.d(TAG, "   PromoterCenter  " );
		getU3DContext().runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				
				((ZTLibGiant)IZTLibBase.getInstance()).doPromoterCenter();
			}
			});
	}
	
	public static boolean isRefererSetted(){
		Log.d(TAG, "   isRefererSetted  " );
		return ((ZTLibGiant)IZTLibBase.getInstance()).isRefererSetted();
	}

	public static String getAuthCode(){
		Log.d(TAG, "   getAuthCode  " );
		return ((ZTLibGiant)IZTLibBase.getInstance()).getAuthCode();
	}
	
	 
	public static void pay(final String zoneId, final String productId,final String productName,final int money,
			final int exchangeRatio,final String extra){
		
		// 订单信息
		Log.d(TAG,"zoneid = "+zoneId+",");
		getU3DContext().runOnUiThread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				IZTLibBase.getInstance().setZoneId(zoneId);
				ZTPayInfo payInfo = new ZTPayInfo();
				payInfo.setProductId(productId);
				payInfo.setProductName(productName);
				payInfo.setAmount(money);
				payInfo.setExchangeRatio(exchangeRatio);
				payInfo.setExtra(extra); // 扩展信息，需要回传游戏服务器的请设置这个字段
				((ZTLibGiant)IZTLibBase.getInstance()).payZTGame(payInfo);
			}
		});
	
	}
	
	public static void switchUser(){
			Log.d(TAG, "switch login start");
			getU3DContext().runOnUiThread(new Runnable() {
				
				@Override
				public void run() {
					
					IZTLibBase.getInstance().switchAccountZTGame();
				}
				});
			
		}
		
		
	public static void userCenter(){
		getU3DContext().runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				IZTLibBase.getInstance().enterCenterZTGame();
			}
			});
	
	}
	/**
     * 是否需要用户中心按钮接口
     *
     * 以上为某些渠道判断是否存在用户中心按钮倘若返回false不作处理，倘若返回true需要显示用户中心按钮，点击此按钮后调用enterCenterZTGame()
     */
    public static boolean   hasUserCenter(){
    	 
	    return  IZTLibBase.getInstance().isHasCenterZTGame();
    }

	 /**
     * 是否需要切换账号按钮接口
     * 以上接口返回true则游戏需要添加一个切换账号按钮以方便用户切换账号.
     * 点击此按钮后调用switchAccountZTGame()
     */
    public static boolean  hasSwitchUser() {
    	 
    	return IZTLibBase.getInstance().isHasSwitchAccountZTGame();
    }

    /**
     * 是否有第三方渠道的退出确认弹出框（必接）
     *  
     * 如果此函数返回true，请游戏不要弹出游戏自身的退出确认弹出框而是直接调用quitZTGame来弹出第三方的退出弹出框，在ZTGame_Quit回调内处理游戏的退出操作
     * （销毁代码，而不是再次弹出退出确认对话框。返回false则按照游戏自己的退出流程处理即可。)
     */
    public static  boolean hasQuitDialog(){
    	
    	 return  IZTLibBase.getInstance().isHasQuitDialog();
    }
    /**
     * 弹出第三方退出弹出确认框接口（必接）
     */
    public static void quitZTGame(){
    	Log.d(TAG, " quitZTGame"); 	
    	
    	getU3DContext().runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				
				IZTLibBase.getInstance().quitZTGame();
			}
			});
    }


    /**
     * 开启日志输出接口
     * 游戏上线前需要注释该行代码以关闭日志输出
     */
    public static void enableDebugMode(){
    	Log.d(TAG, " enableDebugMode ");
    	
    	getU3DContext().runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				
				IZTLibBase.getInstance().enableDebugMode();
			}
			});
    }
    /**
     * 获取渠道id
     *
     * 渠道id以及游戏id可以统一从此wiki链接查询.
     * @see http://wiki.mztgame.com/index.php/%E6%B8%A0%E9%81%93%E4%BF%A1%E6%81%AF%E5%88%97%E8%A1%A8
     */
    public static int getPlatformID(){
    	 
    	return IZTLibBase.getInstance().getPlatform();
    }
    
    
    /**
     * 更新服务器id
     * 玩家切换服务器后需要调用此方法更新当前服务器id
     */
    public static void setZoneId(final String zoneId){
    	Log.d(TAG, " setZoneId : "+ zoneId); 	 
    	getU3DContext().runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				
				IZTLibBase.getInstance().setZoneId(zoneId);
				
			}
			});
    }

    /**
     * 更新当前活动Activity
     * 如果游戏当前Activity变更，需要更新activity到SDK
     */
    public static void setActivity(){
    	Log.d(TAG, " setActivity  "); 	 
    	
    	getU3DContext().runOnUiThread(new Runnable() {
				
				@Override
				public void run() {
					IZTLibBase.getInstance().setActivity(getU3DContext());
				}
				});
    } 

    /**
     * 是否已经登录
     */
    public static boolean isLogined(){
    	 
    	return IZTLibBase.getInstance().isLogined();
    }


    /**
     * 是否有一键加QQ群功能接口
     *
     * 注: 接入此接口时，游戏会收到ZTGAME_QQGROUP消息，当errcode为0表示有一键加QQ功能，-1表示没有该功能
     */
    public static void isHasJoinQQGroup(){
    	   	
    }
    /**
     * 登录完成数据统计接口（必接）
     *
     * 角色进入游戏后调用
     *
     * @param roleId     角色ID
     * @param roleName   角色名称
     * @param roleLevel  角色等级
     * @param zoneId     游戏区ID
     * @param zoneName   游戏区名称
     */
    public static void loginOkZTGame(final String roleId,final String roleName,final String roleLevel,final String zoneId,final String zoneName,final String extra) {
    	final Map<String, Object>  maps = new HashMap<String, Object>();
    	 getU3DContext().runOnUiThread(new Runnable() {
				
				@Override
				public void run() {
					 Log.d(TAG, " loginOkZTGame roleId : "+roleId+",roleName = "+roleName+",roleLevel = "+roleLevel+
							 ",zoneId = "+zoneId+",zoneName = "+zoneName); 	
					 if (extra != null && extra.length()>0) {
							String[] strs = extra.split("\\&");
							for(String str :strs){
								
								String[] ms = str.split("=");
								maps.put(ms[0], ms[1]);
							}
						}
			    	 IZTLibBase.getInstance().loginOkZTGame(roleId, roleName, roleLevel, zoneId, zoneName,maps);
					 
				}
				});
    }
    
    

    /**
     * 创建角色数据统计接口（必接）
     *
     * 玩家创建角色后调用.
     *
     * @param roleId     角色ID
     * @param roleName   角色名称
     * @param roleLevel  角色等级
     * @param zoneId     游戏区ID
     * @param zoneName   游戏区名称
     */
    public static void createRoleZTGame(final String roleId,final String roleName,final String roleLevel,
    		final String zoneId,final String zoneName,final String extra) {
    	final Map<String, Object>  maps = new HashMap<String, Object>();
    	getU3DContext().runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				Log.d(TAG, " createRoleZTGame roleId : "+roleId+",roleName = "+roleName+
						",roleLevel = "+roleLevel+",zoneId = "+zoneId+",zoneName = "+zoneName+",extra ="+extra);
				if (extra != null && extra.length()>0) {
					String[] strs = extra.split("\\&");
					for(String str :strs){
						
						String[] ms = str.split("=");
						maps.put(ms[0], ms[1]);
					}
				}
				
		    	IZTLibBase.getInstance().createRoleZTGame(roleId, roleName, roleLevel, zoneId, zoneName,maps);
			}
			});
    }

    /**
     * 角色等级升级信息接口（必接）
     *
     * @param roleId     角色ID
     * @param roleName   角色名称
     * @param zoneId     游戏区ID
     * @param zoneName   游戏区名称
     * @param level      角色等级
     */
    public static void roleLevelUpZTGame(final String roleId,final String roleName,final String zoneId,final String zoneName,
    		final String level,final String extra){
    	final Map<String, Object>  maps = new HashMap<String, Object>();
    	getU3DContext().runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				Log.d(TAG, " roleLevelUpZTGame roleId : "+roleId+",roleName = "+roleName+
						",zoneId = "+zoneId+",zoneName = "+zoneName+",level = "+level);
				if (extra != null && extra.length()>0) {
					String[] strs = extra.split("\\&");
					for(String str :strs){
						
						String[] ms = str.split("=");
						maps.put(ms[0], ms[1]);
					}
				}
		    	IZTLibBase.getInstance().roleLevelUpZTGame(roleId, roleName, zoneId, zoneName, level,maps);
		    	
			}});
		    	
    }
    
    public static void showToolBar() {
		getU3DContext().runOnUiThread(new Runnable() {
				
				@Override
				public void run() {
					Log.d(TAG, " roleLevelUpZTGame roleId ");
					
			    	IZTLibBase.getInstance().toolBarZTGame();
			    	
				}});
	}
    
	public static void hideToolBar() {
			getU3DContext().runOnUiThread(new Runnable() {
						
						@Override
						public void run() {
							Log.d(TAG, " roleLevelUpZTGame roleId ");
							
					    	IZTLibBase.getInstance().hideToolBar();
					    	
						}});
		}
    
    private static Activity getU3DContext() {
        return UnityPlayer.currentActivity;
    }
    
    
}

