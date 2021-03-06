package ch.DB_BR_HJ.LebenslaufApp;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class BerufserfahrungActivity extends Activity {

	String name;
	String adresse;
	public static final String NAME = "name";
	public static final String ADRESSE = "adresse";
	public ArrayList<String> berufserfahrungen = new ArrayList<String>();
	public static final String BERUFSERFAHRUNGEN = "berufserfahrungen";

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

		intent.putExtra(NAME, name);
		intent.putExtra(ADRESSE, adresse);

		intent.putStringArrayListExtra(BERUFSERFAHRUNGEN, berufserfahrungen);

		startActivity(intent);
	}

	public void onClickAddBerufserfahrung(View Button) {
		String berufserfahrung;

		final EditText txtFirma = (EditText) findViewById(R.id.edt_berufserfahrung_firma);
		String firma = txtFirma.getText().toString();

		final EditText txtDauer = (EditText) findViewById(R.id.edt_berufserfahrung_dauer);
		String dauer = txtDauer.getText().toString();

		final EditText txtTatigkeit = (EditText) findViewById(R.id.edt_berufserfahrung_taetigkeit);
		String tatigkeit = txtTatigkeit.getText().toString();

		berufserfahrung = firma + "/" + dauer + "/" + tatigkeit;

		berufserfahrungen.add(berufserfahrung);

	}

}
