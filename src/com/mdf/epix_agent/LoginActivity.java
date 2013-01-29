package com.mdf.epix_agent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends Activity
{
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_dialog);
	}

	public void onOkClick(View v) {
		Intent intent = getIntent();
		intent.putExtra("session_id", "test session id");
		returnResult(RESULT_OK, intent);
		finish();
	}

	public void onCancelClick(View v) {
		returnResult(RESULT_CANCELED, null);
		finish();
	}

	@Override
	public void onBackPressed() {
		returnResult(RESULT_CANCELED, null);
		super.onBackPressed();
	}
	
	private void returnResult(int code, Intent intent) {
		if (getParent() == null) {
			setResult(code, intent);
		} else {
			getParent().setResult(code, intent);
		}
	}
}
