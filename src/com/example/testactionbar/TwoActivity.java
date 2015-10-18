package com.example.testactionbar;


import com.test.utils.ActionBarManager;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class TwoActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ActionBarManager.initBackTitle(getApplicationContext(), getActionBar(), "二逼");
		TextView tv=(TextView) findViewById(R.id.textView1);
		tv.setText("4554");
	}
}
