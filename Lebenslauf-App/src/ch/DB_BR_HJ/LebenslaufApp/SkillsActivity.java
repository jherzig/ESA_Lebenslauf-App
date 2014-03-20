package ch.DB_BR_HJ.LebenslaufApp;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.SeekBar;

public class SkillsActivity extends Activity {

	String name;
	String adresse;
	public static final String NAME = "name";
	public static final String ADRESSE = "adresse";
	public ArrayList<String> berufserfahrungen = new ArrayList<String>();
	public static final String BERUFSERFAHRUNGEN = "berufserfahrungen";
	public ArrayList<String> bildungen = new ArrayList<String>();
	public static final String BILDUNGEN = "bildung";
	public String skillGrad;
	public static final String SKILL = "skill";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_skills);

		final Bundle extras = getIntent().getExtras();
		if (extras != null) {
			berufserfahrungen = extras
					.getStringArrayList(BildungActivity.BERUFSERFAHRUNGEN);
			name = extras.getString(BildungActivity.NAME);
			adresse = extras.getString(BildungActivity.ADRESSE);
			bildungen = extras.getStringArrayList(BildungActivity.BILDUNGEN);
		}

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
		
		intent.putExtra(NAME, name);
		intent.putExtra(ADRESSE, adresse);

		intent.putStringArrayListExtra(BERUFSERFAHRUNGEN, berufserfahrungen);
		
		intent.putStringArrayListExtra(BILDUNGEN, bildungen);
		
		intent.putExtra(SKILL, skillGrad);

		startActivity(intent);
	}

	public void onClickAddSkill(View Button) {
		SeekBar seek = (SeekBar) findViewById(R.id.edt_skills_itkenntnisse);
		Integer x = seek.getProgress();
		skillGrad = x.toString();
	

	}

}
