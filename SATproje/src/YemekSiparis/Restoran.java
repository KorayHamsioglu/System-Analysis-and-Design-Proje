package YemekSiparis;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class Restoran extends Uyelik{
	
	private int id;
	private Urun[] urunler;
	private Connection con=conn.baglanti();
	private Statement st=null;
	private ResultSet rs=null;
	private PreparedStatement pst=null;
	
	public Restoran() {
		
	}

	public Restoran(int id,String ad, String sifre,String adres) {
		super(ad, sifre,adres);
		// TODO Auto-generated constructor stub
		this.id=id;
		this.urunler=new Urun[10];
	}

	

	public int getId() {
		return id;
	}
	public boolean restoranUrunEkle(String ad,double fiyat,String açýklama) throws SQLException {
		String sql="INSERT INTO menü_ürünler "+ "(ürün_ad,fiyat,ürün_açýklamasý,restoran_id) VALUES"+"(?,?,?,?) ";
		st=(Statement) con.createStatement();
		boolean key=false;
		try {
			st=(Statement) con.createStatement();
			pst=(PreparedStatement) con.prepareStatement(sql);
			pst.setString(1, ad);
			pst.setDouble(2, fiyat);
			pst.setString(3, açýklama);
			pst.setInt(4, this.id);
		
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
	
	public boolean restoranUrunCýkar(String ürün_ad) {
		String sql="delete from menü_ürünler where ürün_ad=?";
		boolean key=false;
		try {
			st=(Statement) con.createStatement();
			pst=(PreparedStatement) con.prepareStatement(sql);
			pst.setString(1, ürün_ad);
			
		   
			if(pst.executeUpdate()==1) {
				key=true;
			}
			
			
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
	public ArrayList<Urun>  ürünleriListele() throws SQLException{
		ArrayList<Urun> list=new ArrayList<>();
		st=(Statement) con.createStatement();
		return list;
	}
		
		

		
		
		
	
	
	

}
