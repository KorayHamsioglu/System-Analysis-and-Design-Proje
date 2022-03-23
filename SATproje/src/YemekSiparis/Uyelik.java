package YemekSiparis;

public abstract class Uyelik {
private String ad;
private String adres;
private String sifre;
static dbas conn=new dbas();

public Uyelik() {
	
}
public Uyelik(String ad, String sifre,String adres) {
	
	this.ad = ad;
    this.adres=adres;
	this.sifre = sifre;
}


public String getAd() {
	return ad;
}


public String getAdres() {
	return adres;
}


public String getSifre() {
	return sifre;
}





}
