package com.mdf.epix_agent;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;

public class LoginActivity extends Activity
{
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_dialog);
		setResult(RESULT_OK);
	}
}
