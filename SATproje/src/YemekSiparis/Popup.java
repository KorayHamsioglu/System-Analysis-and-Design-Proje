package YemekSiparis;
import javax.swing.JOptionPane;
public class Popup {
	
	public static void popup(String message) {
		String msg=null;
		
		switch(message) {
		case "success":
			msg="iþlem baþarýlý !";
			break;
		case "fail":
			msg="Ýþlem baþarýsýz. Lütfen tekar deneyiniz.";
			break;
		case "hata":
			msg="Hatalý giriþ yaptýnýz. Lütfen tekrar deneyin.";
			break;
		case "hata1":
			msg="Daha önce oylama yaptýnýz !";
			break;
		}
		JOptionPane.showConfirmDialog(null, msg, "Mesaj", JOptionPane.INFORMATION_MESSAGE);
		
	}

}
