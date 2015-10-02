package com.sy.qrcode.util;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Settings;

import com.sy.qrcode.TwoCodeApp;
import com.sy.scantool.R;

/**
 * @项目名称：TwoCodeTools    
 * @类名称：IntentUtils    
 * @类描述：    
 * @创建人：Administrator    
 * @创建时间：2015-5-30 下午9:00:48    
 * @修改人：Administrator    
 * @修改时间：2015-5-30 下午9:00:48    
 * @修改备注：    
 * @version     
 */
public final class IntentUtils {
	
	/** 拨打电话  */
	public static void call(Context context , String phoneNum) {
		Uri uri = Uri.parse("tel:"+phoneNum);
		Intent intent = new Intent(Intent.ACTION_DIAL, uri);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(intent);
	}
	
	/** 进入发短信界面 */
	public static void sendSMS(Context context , String content) {
		Uri uri = Uri.parse("smsto:");
		Intent intent = new Intent(Intent.ACTION_SENDTO,uri);
		intent.putExtra("sms_body", content);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(intent);
	}
	
	/** 跳转到网络设置 */
	public static void settingNetwork() {
		Intent intent = new Intent("android.settings.WIRELESS_SETTINGS");
		TwoCodeApp.getInstance().startActivity(intent);
	}
	
	/** 
     * 打开GPS 
     * @param context 
     */  
    public static void openGPS(Context context) {  
    	Intent intent = new Intent();
        intent.setAction(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }  
    
	public static boolean hasShortcut(Context context) {
		boolean isInstallShortcut = false;
		final ContentResolver cr = context.getContentResolver();
		final String AUTHORITY = "com.android.launcher.settings";
		final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/favorites?notify=true");
		Cursor c = cr.query(CONTENT_URI, new String[] { "title", "iconResource" }, "title=?", new String[] { context.getString(R.string.app_name)
				.trim() }, null);
		if (c != null && c.getCount() > 0) {
			isInstallShortcut = true;
		}
		return isInstallShortcut;
	}
}
