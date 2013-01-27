package com.mdf.epix_agent;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;

public class EpixCrafted extends Activity
{
	private boolean login = false;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		SharedPreferences settings = getPreferences(0);
		String session_id = settings.getString("session_id", "");
		if (session_id == "") {
			// Start login activity;
			setContentView(R.layout.login_dialog);
		}
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		if (!login) {
			setContentView(R.layout.login_dialog);
			login = true;
		}
		
		return super.onTouchEvent(event);
	}
}
