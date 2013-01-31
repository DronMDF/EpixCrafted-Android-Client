package com.mdf.epix_agent;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
		
		String session_id = getSessionId(login.getText().toString(), 
			password.getText().toString());
		
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
	
	private String getSessionId(String login, String password) {
		JSONObject json = new JSONObject();
		try {
			json.put("login", login);
			json.put("password", password);
			json.put("client", "android");
		} catch (JSONException e) {
			Log.d("JSON", e.getMessage());
		}
		
		String session_id = "";
		
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost("http://epixcrafted.org/api/method");
		try {
			post.setEntity(new StringEntity(json.toString()));
			HttpResponse response = client.execute(post);
			StatusLine statusLine = response.getStatusLine();
			if (statusLine.getStatusCode() == 200) {
				HttpEntity entity = response.getEntity();
				session_id = entity.toString();
			} else {
				Log.e("HTTP", "Failed to request");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return session_id;
	}
}
