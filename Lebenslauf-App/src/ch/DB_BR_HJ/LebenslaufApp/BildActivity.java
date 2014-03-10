package com.example.lebenslauf_app;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class BildActivity extends Activity {

	public static final String NAME = "name";
	public static final String ADRESSE = "adresse";
	
	@Override
	protected void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.activity_bild);

	}

	public void onClickBerufserfahrung(View Button) {
		final Intent intent = new Intent(this, BerufserfahrungActivity.class);
		
		
		final EditText txtName = (EditText) findViewById(R.id.edt_person_name);
		String name = txtName.getText().toString();
		
		final EditText txtAdresse = (EditText) findViewById(R.id.edt_person_adresse);
		String adresse = txtAdresse.getText().toString();
		
		intent.putExtra(NAME, name);
		intent.putExtra(ADRESSE, adresse);
		startActivity(intent);

	}

	public void onClickStart(View Button) {
		final Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}

}
