package com.example.lebenslauf_app;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class ZusammenfassungActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_zusammenfassung);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.zusammenfassung, menu);
		return true;
	}

	public void onClickSkills(View Button) {
		final Intent intent = new Intent(this, SkillsActivity.class);

		startActivity(intent);

	}

	public void onClickStart(View Button) {
		final Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}

}
