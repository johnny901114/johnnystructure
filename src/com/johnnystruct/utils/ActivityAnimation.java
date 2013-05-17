package com.johnnystruct.utils;

import com.johnnystruct.R;

import android.app.Activity;

public class ActivityAnimation {

	public static void slideInRight(Activity context) {
		context.overridePendingTransition(R.anim.slide_in_right,
				R.anim.slide_out_left);
	}

	public static void slideInLeft(Activity context) {
		context.overridePendingTransition(R.anim.slide_in_left,
				R.anim.slide_out_right);
	}

	public static void slideInBottom(Activity context) {
		context.overridePendingTransition(R.anim.slide_in_bottom,
				R.anim.slide_out_top);
	}
	public static void slideInTop(Activity context) {
		context.overridePendingTransition(R.anim.slide_in_top,
				R.anim.slide_out_bottom);
	}

}
