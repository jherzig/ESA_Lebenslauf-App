package ch.DB_BR_HJ.LebenslaufApp;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

public class BildungActivity extends Activity {

	String name;
	String adresse;
	public static final String NAME = "name";
	public static final String ADRESSE = "adresse";
	public ArrayList<String> berufserfahrungen = new ArrayList<String>();
	public static final String BERUFSERFAHRUNGEN = "berufserfahrungen";
	public ArrayList<String> bildungen = new ArrayList<String>();
	public static final String BILDUNGEN = "bildung";

	@Override
	protected void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.activity_bildung);

		final Bundle extras = getIntent().getExtras();
		if (extras != null) {
			berufserfahrungen = extras
					.getStringArrayList(BerufserfahrungActivity.BERUFSERFAHRUNGEN);
			name = extras.getString(BerufserfahrungActivity.NAME);
			adresse = extras.getString(BerufserfahrungActivity.ADRESSE);
		}
		/*
		 * if (berufserfahrungen.isEmpty() != true) { Log.e("meldung",
		 * "bevore GET"); berufserfahrung = berufserfahrungen.get(0);
		 * Log.e("MELDUNG", "Data: " + berufserfahrung); String[] a =
		 * berufserfahrung.split("/"); final TextView txtSchule = (TextView)
		 * findViewById(R.id.edt_bildung_schule_x);
		 * txtSchule.setText(String.valueOf(a[0]));
		 * 
		 * final TextView txtDauer = (TextView)
		 * findViewById(R.id.edt_bildung_dauer_x);
		 * txtDauer.setText(String.valueOf(a[1]));
		 * 
		 * final TextView txtAdresse = (TextView)
		 * findViewById(R.id.edt_bildung_adresse_x);
		 * txtAdresse.setText(String.valueOf(a[2])); }
		 */
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
		
		intent.putExtra(NAME, name);
		intent.putExtra(ADRESSE, adresse);

		intent.putStringArrayListExtra(BERUFSERFAHRUNGEN, berufserfahrungen);
		
		intent.putStringArrayListExtra(BILDUNGEN, bildungen);

		startActivity(intent);
	}

	public void onClickAddBildung(View Button) {
		String bildung;
		String bildungArt;

		final EditText txtSchule = (EditText) findViewById(R.id.edt_bildung_schule);
		String schule = txtSchule.getText().toString();

		final EditText txtDauer = (EditText) findViewById(R.id.edt_bildung_dauer);
		String dauer = txtDauer.getText().toString();

		final EditText txtAdresse = (EditText) findViewById(R.id.edt_bildung_adresse);
		String adresse = txtAdresse.getText().toString();

		final RadioGroup rg = (RadioGroup) findViewById(R.id.edt_radiogroup_ausbildung);
		switch (rg.getCheckedRadioButtonId()) {
		case R.id.edt_radio_grund:
			bildungArt = "Grundbildung";
			break;
		case R.id.edt_radio_ausb:
			bildungArt = "Ausbildung";
			break;
		case R.id.edt_radio_weiter:
			bildungArt = "Weiterbildung";
			break;
		default:
			bildungArt = "Grundbildung";
		}

		bildung = bildungArt + "/" + schule + "/" + dauer + "/" + adresse;

		bildungen.add(bildung);

	}

}
