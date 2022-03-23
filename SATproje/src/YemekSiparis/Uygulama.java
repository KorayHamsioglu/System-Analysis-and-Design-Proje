package YemekSiparis;



public class Uygulama {
	static double puan;
	
	static Uyelik[] uyelikler;
	

	public Uygulama() {
		
		this.uyelikler = new Uyelik[100];
		
	}

	public double getPuan() {
		return puan;
	}

	public void setPuan(double puan) {
		this.puan = puan;
	}
	
	

}
