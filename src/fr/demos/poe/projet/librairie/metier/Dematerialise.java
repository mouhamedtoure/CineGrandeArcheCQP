package fr.demos.poe.projet.librairie.metier;

public class Dematerialise {
	
	String format;
	String url;

	public Dematerialise(String format, String url) {
		// TODO Auto-generated constructor stub
		this.format=format;
		this.url=url;
		
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Dematerialise [format=" + format + ", url=" + url + "]";
	}

	
	
}
