package com.johnnystruct.utils;

import android.content.Context;
import android.content.Intent;

import com.johnnystruct.MainActivity;

/**
 * 系统退出工具类
 * 
 * @author YZQ
 * 
 */
public class SystemExit {
	public static final int EXIT_APPLICATION = 0x0001;

	private Context mContext;

	public static final String KEY = "flag";

	public SystemExit(Context context) {
		this.mContext = context;
	}

	// 完全退出应用
	public void exit() {
		// 1.5 - 2.1之前下面两行是ok的,2.2之后就不行了，所以不通用
		// ActivityManager am =
		// (ActivityManager)mContext.getSystemService(Context.ACTIVITY_SERVICE);
		// am.restartPackage("com.tutor.exit");
		Intent mIntent = new Intent();
		mIntent.setClass(mContext, MainActivity.class);
		// 这里设置flag还是比较 重要的
		mIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		// 发出退出程序指示
		mIntent.putExtra(KEY, EXIT_APPLICATION);
		mContext.startActivity(mIntent);
	}

	
	public static void clearSysRes(Context context) {
		// 清空在线离线患者
		//FriendsManage.offline.clear();
		//FriendsManage.online.clear();
		// 关闭数据库资源
		//DBHelper.getInstance(context).close();
		// 移除对连接的监听
		//ConnectionManage.getInstance().removeListener();
	}
}
