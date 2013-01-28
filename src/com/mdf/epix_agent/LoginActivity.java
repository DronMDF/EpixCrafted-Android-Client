package com.mdf.epix_agent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class LoginActivity extends Activity
{
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_dialog);
	}
	
	@Override
	public void onBackPressed () {
		Intent intent = getIntent();
		intent.putExtra("session_id", "test session id");
		
		if (getParent() == null) {
			setResult(Activity.RESULT_OK, intent);
		} else {
			getParent().setResult(Activity.RESULT_OK, intent);
		}
		
		super.onBackPressed();
	}
}
