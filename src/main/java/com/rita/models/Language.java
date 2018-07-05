package com.rita.models;

public class Language {
	private String language;
	private boolean official;
	private double percentaje;
	
	public Language(String language, boolean official, double percentaje) {
		this.language = language;
		this.official = official;
		this.percentaje = percentaje;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public boolean isOfficial() {
		return official;
	}

	public void setOfficial(boolean official) {
		this.official = official;
	}

	public double getPercentaje() {
		return percentaje;
	}

	public void setPercentaje(double percentaje) {
		this.percentaje = percentaje;
	}
	
	
	
	
}

