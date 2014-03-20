package ch.DB_BR_HJ.LebenslaufApp;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class ZusammenfassungActivity extends Activity {

	String name;
	String adresse;
	public ArrayList<String> berufserfahrungen = new ArrayList<String>();
	public ArrayList<String> bildungen = new ArrayList<String>();
	public String skillGrad;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_zusammenfassung);

		final Bundle extras = getIntent().getExtras();
		if (extras != null) {
			berufserfahrungen = extras
					.getStringArrayList(SkillsActivity.BERUFSERFAHRUNGEN);
			name = extras.getString(SkillsActivity.NAME);
			adresse = extras.getString(SkillsActivity.ADRESSE);
			bildungen = extras.getStringArrayList(SkillsActivity.BILDUNGEN);
			skillGrad = extras.getString(SkillsActivity.SKILL);
			
			String[] firmaTeile = berufserfahrungen.get(0).split("/"); 
			
			String[] schuleTeile = bildungen.get(0).split("/");

			// Personalien

			final TextView txtName = (TextView) findViewById(R.id.edt_zusammenfassung_person_name);
			txtName.setText(String.valueOf(name));

			final TextView txtAdresse = (TextView) findViewById(R.id.edt_zusammenfassung_person_adresse);
			txtAdresse.setText(String.valueOf(adresse));

			//Berufserfahrung

			final TextView txtFirma = (TextView) findViewById(R.id.edt_zusammenfassung_firma);
			txtFirma.setText(String.valueOf(firmaTeile[0]));

			final TextView txtFirmaDauer = (TextView) findViewById(R.id.edt_zusammenfassung_firma_dauer);
			txtFirmaDauer.setText(String.valueOf(firmaTeile[1]));

			final TextView txtFirmaTaetigkeit = (TextView) findViewById(R.id.edt_zusammenfassung_firma_taetigkeit);
			txtFirmaTaetigkeit.setText(String.valueOf(firmaTeile[2]));
			
			//Bildung
			
			final TextView txtSchuleArt = (TextView) findViewById(R.id.edt_zusammenfassung_schule_art);
			txtSchuleArt.setText(String.valueOf(schuleTeile[0]));
			
			final TextView txtSchule = (TextView) findViewById(R.id.edt_zusammenfassung_schule);
			 txtSchule.setText(String.valueOf(schuleTeile[1]));
			
			final TextView txtSchuleDauer = (TextView) findViewById(R.id.edt_zusammenfassung_schule_dauer);
			txtSchuleDauer.setText(String.valueOf(schuleTeile[2]));
			
			final TextView txtSchuleAdresse = (TextView) findViewById(R.id.edt_zusammenfassung_schule_adresse);
			txtSchuleAdresse.setText(String.valueOf(schuleTeile[3]));
			
			//Skills
			
			final TextView txtSkill = (TextView) findViewById(R.id.edt_zusammenfassung_itkenntnisse);
			txtSkill.setText(String.valueOf(skillGrad));
			
		}
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
