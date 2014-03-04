package com.example.lebenslauf_app;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class BerufserfahrungActivity extends Activity {

	String name;
	String adresse;
	public static final String NAME = "name";
	public static final String ADRESSE = "adresse";
	//
	public static final String BERUFSERFAHRUNGEN = "berufserfahrungen";

	public ArrayList<String> berufserfahrungen = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.activity_berufserfahrung);

		final Bundle extras = getIntent().getExtras();

		if (extras != null) {
			name = extras.getString(BildActivity.NAME);
			adresse = extras.getString(BildActivity.ADRESSE);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.berufserfahrung, menu);
		return true;
	}

	public void onClickBild(View Button) {
		final Intent intent = new Intent(this, BildActivity.class);
		startActivity(intent);
	}

	public void onClickBildung(View Button) {
		final Intent intent = new Intent(this, BildungActivity.class);

		//intent.putExtra(NAME, name);
		//intent.putExtra(ADRESSE, adresse);

		intent.putStringArrayListExtra(BERUFSERFAHRUNGEN, berufserfahrungen);
		
		startActivity(intent);
	}

	public void onClickAdd(View Button) {
		String berufserfahrung;

		final EditText txtFirma = (EditText) findViewById(R.id.edt_berufserfahrung_firma);
		String firma = txtFirma.getText().toString();

		final EditText txtDauer = (EditText) findViewById(R.id.edt_berufserfahrung_dauer);
		String dauer = txtDauer.getText().toString();

		final EditText txtTatigkeit = (EditText) findViewById(R.id.edt_berufserfahrung_taetigkeit);
		String tatigkeit = txtTatigkeit.getText().toString();

		berufserfahrung = firma+"/"+dauer+"/"+tatigkeit;
		
		//Log.e("MELDUNG", "Data: "+berufserfahrung[0]+berufserfahrung[1]+berufserfahrung[2]);
		berufserfahrungen.add(berufserfahrung);
		//String y = berufserfahrungen.get(0);
		//Log.e("MELDUNG", "Data: "+y);

	}

}
