package com.mdf.epix_agent;

import android.app.Activity;
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
	public boolean onTouchEvent(MotionEvent event)
	{
		if (!login) {
			setContentView(R.layout.login_dialog);
			login = true;
		}
		
		return super.onTouchEvent(event);
	}
}
