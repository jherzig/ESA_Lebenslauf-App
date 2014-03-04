package com.example.lebenslauf_app;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class SkillsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_skills);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.skills, menu);
		return true;
	}
	
	public void onClickBildung(View Button) {
		final Intent intent = new Intent(this, BildungActivity.class);
		startActivity(intent);
	}

	public void onClickZusammenfassung(View Button) {
		final Intent intent = new Intent(this, ZusammenfassungActivity.class);

		startActivity(intent);
	}

}
