package YemekSiparis;
import javax.swing.JOptionPane;
public class Popup {
	
	public static void popup(String message) {
		String msg=null;
		
		switch(message) {
		case "success":
			msg="i�lem ba�ar�l� !";
			break;
		case "fail":
			msg="��lem ba�ar�s�z. L�tfen tekar deneyiniz.";
			break;
		case "hata":
			msg="Hatal� giri� yapt�n�z. L�tfen tekrar deneyin.";
			break;
		case "hata1":
			msg="Daha �nce oylama yapt�n�z !";
			break;
		}
		JOptionPane.showConfirmDialog(null, msg, "Mesaj", JOptionPane.INFORMATION_MESSAGE);
		
	}

}
