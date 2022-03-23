package YemekSiparis;

public class Urun {
private String ad;
private double fiyat;

public Urun(String ad,  double fiyat) {
	
	this.ad = ad;
	
	this.fiyat = fiyat;
}

public String getAd() {
	return ad;
}



public double getFiyat() {
	return fiyat;
}

public void setFiyat(double fiyat) {
	this.fiyat = fiyat;
}



}