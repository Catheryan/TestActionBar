package com.test.common;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.widget.ShareActionProvider;

import com.example.testactionbar.R;

public class PlusActionProvider extends ShareActionProvider {

	private Context context;

	public PlusActionProvider(Context context) {
		super(context);
		this.context = context;
	}

	@Override
	public View onCreateActionView() {
		return null;
	}



	@Override
	public void onPrepareSubMenu(SubMenu subMenu) {
		subMenu.clear();
		subMenu.add(R.id.action_plus, R.id.action_about, 0, "分享");
		subMenu.add(context.getString(R.string.plus_group_chat))
				.setIcon(R.drawable.ofm_group_chat_icon)
				.setOnMenuItemClickListener(new OnMenuItemClickListener() {
					@Override
					public boolean onMenuItemClick(MenuItem item) {
						
						setShareIntent();
						Log.i("test", "msg:zhuanghuan");
						return true;
					}
				});
		subMenu.add(context.getString(R.string.plus_add_friend))
				.setIcon(R.drawable.ofm_add_icon)
				.setOnMenuItemClickListener(new OnMenuItemClickListener() {
					@Override
					public boolean onMenuItemClick(MenuItem item) {
						return false;
					}
				});
		subMenu.add(context.getString(R.string.plus_video_chat))
				.setIcon(R.drawable.ofm_video_icon)
				.setOnMenuItemClickListener(new OnMenuItemClickListener() {
					@Override
					public boolean onMenuItemClick(MenuItem item) {
						return false;
					}
				});
		subMenu.add(context.getString(R.string.plus_scan))
				.setIcon(R.drawable.ofm_qrcode_icon)
				.setOnMenuItemClickListener(new OnMenuItemClickListener() {
					@Override
					public boolean onMenuItemClick(MenuItem item) {
						return false;
					}
				});
		subMenu.add(context.getString(R.string.plus_take_photo))
				.setIcon(R.drawable.ofm_camera_icon)
				.setOnMenuItemClickListener(new OnMenuItemClickListener() {
					@Override
					public boolean onMenuItemClick(MenuItem item) {
						return false;
					}
				});
	}

	@Override
	public boolean hasSubMenu() {
		return true;
	}
	private boolean setShareIntent() {
	    	Intent shareIntent = new Intent(Intent.ACTION_SEND);
	    	shareIntent.setType("text/plain");
	    	shareIntent.putExtra(Intent.EXTRA_TEXT, "这是要发送的文本");
	    	
	    	PackageManager pm = context.getPackageManager();	    	
	    	//检查手机上是否存在可以处理这个动作的应用
	    	List<ResolveInfo> infolist = pm.queryIntentActivities(shareIntent, 0);
	    	if (!infolist.isEmpty()) {
	    		this.setShareIntent(shareIntent);
	    		return true;
	    	}
	        return false;
	}
}