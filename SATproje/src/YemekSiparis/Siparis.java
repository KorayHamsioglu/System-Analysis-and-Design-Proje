package YemekSiparis;



public class Siparis {
private Urun[] urunler;



public Siparis() {
	
	this.urunler=new Urun[50];
}

public void urunEkle(Urun urun) {
	
	for(int i=0;i<urunler.length;i++) {
		if(urunler[i]==null) {
			urunler[i]=urun;
			return;
		}
		
	}
	
}
	public void urunCikar(Urun urun) {
		
		for(int i=0;i<urunler.length;i++) {
			if(urunler[i]!=null && urunler[i].getAd().equals(urun.getAd())) {
				urunler[i]=null;
				
				return;
			}
			
		}
	}
	public double getToplamTutar() {
	    double toplam=0;
		for(int i=0;i<urunler.length;i++) {
			if(urunler[i]!=null) {
			toplam= toplam +urunler[i].getFiyat();
				
			}
		}
		
		return toplam;
		
		
	}
	public void urunleriGoster() {
		
		for(int i=0;i<urunler.length;i++) {
			if(urunler[i]!=null) {
				System.out.println(urunler[i].getAd());
			}
		}
	}
	
	
	
	
	








}