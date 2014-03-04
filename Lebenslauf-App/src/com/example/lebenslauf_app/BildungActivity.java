package com.example.lebenslauf_app;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class BildungActivity extends Activity {

	ArrayList<String> berufserfahrungen = new ArrayList<String>();
	String berufserfahrung;

	@Override
	protected void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.activity_bildung);

		final Bundle extras = getIntent().getExtras();
		if (extras != null) {
			berufserfahrungen = extras
					.getStringArrayList(BerufserfahrungActivity.BERUFSERFAHRUNGEN);
			Log.e("MELDUNG", "etras ok");
		}
		else
		{
			Log.e("MELDUNG", "etras ok leer");
		}

		if(berufserfahrungen.isEmpty())
		{
			Log.e("meldung", "ArrayList leer");
		}else{
			Log.e("meldung", "bevore GET");
		berufserfahrung = berufserfahrungen.get(0);
		Log.e("MELDUNG", "Data: "+berufserfahrung);
		String[] a = berufserfahrung.split("/");
		final TextView txtSchule = (TextView) findViewById(R.id.edt_bildung_schule_x);
		txtSchule.setText(String.valueOf(a[0]));
		
		final TextView txtDauer = (TextView) findViewById(R.id.edt_bildung_dauer_x);
		txtDauer.setText(String.valueOf(a[1]));
		
		final TextView txtAdresse = (TextView) findViewById(R.id.edt_bildung_adresse_x);
		txtAdresse.setText(String.valueOf(a[2]));
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bildung, menu);
		return true;
	}

	public void onClickBerufserfahrung(View Button) {
		final Intent intent = new Intent(this, BerufserfahrungActivity.class);
		startActivity(intent);
	}

	public void onClickSkills(View Button) {
		final Intent intent = new Intent(this, SkillsActivity.class);

		startActivity(intent);
	}

}
