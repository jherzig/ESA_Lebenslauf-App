package com.example.lebenslauf_app;

public class Berufserfahrung {
	public String firma;
	public String dauer;
	public String tatigkeit;
	
	public Berufserfahrung(String firma, String dauer, String tatigkeit)
	{
		this.firma = firma;
		this.dauer = dauer;
		this.tatigkeit = tatigkeit;
	}
	
	public String getFirma(){
		return firma;
	}
	public String getDauer(){
		return dauer;
	}
	public String getTatigkeit(){
		return tatigkeit;
	}

}
