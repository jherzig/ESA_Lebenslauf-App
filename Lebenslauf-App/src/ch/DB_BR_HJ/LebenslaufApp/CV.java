package ch.DB_BR_HJ.LebenslaufApp;

import java.util.ArrayList;
import java.util.UUID;
import android.annotation.SuppressLint;
import android.media.Image;
import android.os.Parcel;

@SuppressLint("ParcelCreator")
public class CV {
	public String id;
	public int bezeichnung;
	public String name;
	public String adresse;
	public Image foto;
	public ArrayList<Berufserfahrung> beEr = new ArrayList<Berufserfahrung>();
	public ArrayList<Bildung> bildung = new ArrayList<Bildung>();

	public CV(Parcel in) {
		id = UUID.randomUUID().toString();
	}

	public String getID() {
		return id;
	}

	public void addBerufserfahrung(Berufserfahrung be) {
		beEr.add(be);
	}

	public void deleteBerufserfahrung(int id) {
		beEr.remove(id);
	}

	public void addBildung(Bildung bil) {
		bildung.add(bil);
	}

	public void deleteBildung(int id) {
		bildung.remove(id);
	}

}
