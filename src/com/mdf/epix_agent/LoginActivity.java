package com.mdf.epix_agent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends Activity
{
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_dialog);
	}

	public void onOkClick(View v) {
		EditText login = (EditText)findViewById(R.id.login); 
		EditText password = (EditText)findViewById(R.id.password);
		
		String session_id = login.getText().toString() + ":" + 
				password.getText().toString();
		
		Intent intent = getIntent();
		intent.putExtra("session_id", session_id);
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
