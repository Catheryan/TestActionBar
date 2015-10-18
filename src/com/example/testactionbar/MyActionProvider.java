package com.example.testactionbar;

import android.content.Context;
import android.content.ContextWrapper;
import android.util.Log;
import android.view.ActionProvider;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;

public class MyActionProvider extends ActionProvider{
	//private List<PopMenuItem> itemList;
    private ContextWrapper mContextWrapper;
    private OnMenuItemClickListener mOnMenuItemClickListener;
    private PopupMenu popup;
    public MyActionProvider(Context context) {
        super(context);
        mContextWrapper = (ContextWrapper)context;
    }

    @Override
    public View onCreateActionView() {
        LayoutInflater layoutInflater = LayoutInflater.from(mContextWrapper);
        View view = layoutInflater.inflate(R.layout.my_action_provider, null);
        ImageView popupView = (ImageView)view.findViewById(R.id.popup_view);
        popupView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup(v);
            }
        });
        return view;
    }

    private void showPopup(View v) {
        popup = new PopupMenu(mContextWrapper, v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.actionbar_menu, popup.getMenu());
        popup.setOnMenuItemClickListener(mOnMenuItemClickListener);
        mOnMenuItemClickListener = new OnMenuItemClickListener() {
            private String TAG = "mOnMenuItemClickListener";

            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                case R.id.action_about:
                    Log.v(TAG , "Settings1");
//                    popup.dismiss();
                    return true;
                case R.id.action_search:
                    Log.v(TAG , "Settings2");
                    //popup.dismiss();
                    return true;
				default:
                    break;
                }
                return false;
            }
        };
        popup.show();
    }
   /* public void initPopData() {  
		itemList.add(new PopMenuItem(R.drawable.sldemenu_head,  "浮云"));  
        itemList.add(new PopMenuItem(R.drawable.menu_vip, "vip"));  
        itemList.add(new PopMenuItem(R.drawable.menu_nearby, "附近消息"));  
        itemList.add(new PopMenuItem(R.drawable.menu_checktime, "签到"));  
        itemList.add(new PopMenuItem(R.drawable.subset, "设置"));  
        itemList.add(new PopMenuItem(R.drawable.submsg, "消息"));  
    }  
  
    /**  
     * 弹出 menu item的popupwindow  
     *//*  
    public void initPopWindow() {  
        if (itemList.size() <= 2) {  
            initPopData();  
        }  
  
        popMenuAdapter = new PopupMenuAdapter(this, itemList);  
        View popView = LayoutInflater.from(this).inflate(  
                R.layout.acy_actionbarmenu, null);  
        popWind = new PopupWindow(popView, LayoutParams.WRAP_CONTENT,  
                LayoutParams.WRAP_CONTENT);  
        // 使其聚集,可以点击里面的组件  
        popWind.setFocusable(true);  
        // 设置允许在外点击消失  
        popWind.setOutsideTouchable(true);  
        // 点击back也能消失  
        popWind.setBackgroundDrawable(new BitmapDrawable());  
        // 状态栏的高度  
        Rect frame = new Rect();  
        getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);  
        int statusBarHeight = frame.top;  
        popWind.showAtLocation(popView, Gravity.RIGHT | Gravity.TOP, 20,  
                mactionBar.getHeight() + statusBarHeight);  
  
        popListView = (ListView) popView.findViewById(R.id.lv_acbarmenu);  
        popListView.setAdapter(popMenuAdapter);  
        popListView.setOnItemClickListener(new OnItemClickListener() {  
  
            @Override  
            public void onItemClick(AdapterView<?> arg0, View view, int pos,  
                    long arg3) {  
                // TODO Auto-generated method stub  
  
                // 设置  
                if (4 == pos) {  
                    intent = new Intent(Main.this, Setting.class);  
                    startActivity(intent);  
                }  
            }  
        });  
  
    }
    class PopMenuItem{
    	private int ResId;
    	private String str;
    	public PopMenuItem(int ResId,String str){
    		this.ResId=ResId;
    		this.str=str;
    	}
    }*/
}
