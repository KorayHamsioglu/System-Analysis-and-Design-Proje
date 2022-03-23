package YemekSiparis;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class Musteri extends Uyelik {
	private String kullanýcý_adý;
	private String soyad;
	private double bakiye;
	private double puan;
	private Connection con=conn.baglanti();
	private Statement st=null;
	private ResultSet rs=null;
	private PreparedStatement pst=null;
	public Musteri() {
		
	}
	public Musteri(String kullanýcý_adý) {
		this.kullanýcý_adý=kullanýcý_adý;
	}
	public Musteri(String ad, String adres, String sifre, String soyad, double bakiye,String kullanýcý_adý) {
		super(ad, sifre,adres);
		this.soyad = soyad;
		this.bakiye = 0;
		this.kullanýcý_adý=kullanýcý_adý;
	}
	public double getBakiye() {
		return bakiye;
	}
	public void setBakiye(double bakiye) {
		this.bakiye = bakiye;
	}
	public String getSoyad() {
		return soyad;
	}
	public double getPuan() {
		return puan;
	}
	public void setPuan(double puan) {
		this.puan = puan;
	}
	
	public String getKullanýcýAdi() {
		return kullanýcý_adý;
	}

	public boolean kayitYap(String kullanýcý_adý,String sifre,String ad,String soyad,String adres) throws SQLException {
		String sql="INSERT INTO müþteriler "+"(kullanýcý_adý,þifre,ad,soyad,adres) VALUES"+"(?,?,?,?,?) ";
		
		st=(Statement) con.createStatement();
		boolean key=false;
		try {
			st=(Statement) con.createStatement();
			pst=(PreparedStatement) con.prepareStatement(sql);
			pst.setString(1, kullanýcý_adý);
			pst.setString(2, sifre);
			pst.setString(3, ad);
			pst.setString(4, soyad);
			pst.setString(5, adres);
			pst.executeUpdate();
			key=true;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(key) {
			return true;
		}
		else {
			return false;
		}
			
	}
	
	public boolean siparisver(Siparis siparis) throws SQLException {
		String sql="INSERT INTO sipariþler"+"(siparis_no,toplam_fiyat) VALUES"+"(?,?)" ;
		st=(Statement) con.createStatement();
		rs=st.executeQuery("SELECT * FROM sipariþler");
		
		boolean key=false;
		try {
			pst=(PreparedStatement) con.prepareStatement(sql);
			
			while(rs.next()) {
				if(rs.isLast()) {
					pst.setInt(1, rs.getInt("siparis_no")+1);
				}
				
			}
			
			
			pst.setDouble(2, siparis.getToplamTutar());
			pst.executeUpdate();
			key=true;
		} catch (Exception e) {
			System.out.println("hata1");
			// TODO: handle exception
		}
		if(key) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean uygulamaDegerlendir(String kullanýcýadi,double puan) throws SQLException {
		String sql="INSERT INTO uygulama_deðerlendir"+"(kullanýcý_adý,puan) VALUES"+"(?,?)" ;
		st=(Statement) con.createStatement();
		rs=st.executeQuery("SELECT * FROM uygulama_deðerlendir");
		
		boolean key=false;
		try {
			pst=(PreparedStatement) con.prepareStatement(sql);
			while(rs.next()) {
				if(rs.getString("kullanýcý_adý").equals(kullanýcýadi)==true) {
					
					return false;
				}
			}
			
		    pst.setString(1, kullanýcýadi);
			pst.setDouble(2, puan);
			
			
			
			pst.executeUpdate();
			key=true;
		} catch (Exception e) {
			System.out.println("hata1");
			// TODO: handle exception
		}
		if(key) {
			return true;
		}
		else {
			return false;
		}
		
	}
	

}
