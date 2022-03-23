package YemekSiparis;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;

public class uye extends JFrame {
	Uygulama uygulama=new Uygulama();
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private dbas conn=new dbas();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					uye frame = new uye();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public uye() {
		setResizable(false);
		setTitle("Giri\u015F Yap");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 451);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 140, 0), null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Kay\u0131t ol");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kayýtGui kGui=new kayýtGui();
				kGui.setLocationRelativeTo(null);
				kGui.setVisible(true);
				dispose();
				
			
				
				
			}
		});
		btnNewButton.setBounds(214, 341, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Yemek Sipari\u015F Uygulamas\u0131na Ho\u015F geldiniz.");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(108, 11, 344, 30);
		contentPane.add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(84, 99, 368, 189);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new CompoundBorder());
		tabbedPane.addTab("Kullanýcý Giriþi", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Kullan\u0131c\u0131 ad\u0131 :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(27, 31, 83, 24);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u015Eifre :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(27, 66, 46, 14);
		panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(108, 34, 122, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(108, 64, 122, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Giri\u015F Yap");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection con=conn.baglanti();
					Statement stat=con.createStatement();
					ResultSet rs=stat.executeQuery("SELECT * FROM müþteriler");
					while(rs.next()) {
						if(textField.getText().equals(rs.getString("kullanýcý_adý"))&&textField_1.getText().equals(rs.getString("þifre"))) {
							Musteri musteri=new Musteri(rs.getString("kullanýcý_adý"));
							kullanýcýGui kGui=new kullanýcýGui(musteri);
							kGui.setLocationRelativeTo(null);
							kGui.setVisible(true);
							dispose();
						}
					}
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setBounds(127, 114, 91, 23);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Restoran Giriþi", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Restoran ID :");
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel_3.setBounds(26, 33, 82, 14);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u015Eifre :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(26, 69, 46, 14);
		panel_1.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(102, 31, 131, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(102, 67, 131, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Giri\u015F Yap");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection con=conn.baglanti();
					Statement stat;
					stat = con.createStatement();
					ResultSet rs=stat.executeQuery("SELECT * FROM restoranlar");
					int key=0;
					while(rs.next()) {
						if(textField_2.getText().equals(rs.getString("restoran_id"))&&textField_3.getText().equals(rs.getString("þifre"))) {
							
							Restoran restoran=new Restoran(rs.getInt("restoran_id"),rs.getString("restoran_adý"),rs.getString("þifre"),rs.getString("adres"));
							restoranGui rgui=new restoranGui(restoran);
							rgui.setLocationRelativeTo(null);
							rgui.setVisible(true);
							
							dispose();
							key=1;
						}
					}
					if(key==0) {
						Popup.popup("hata");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_2.setBounds(123, 127, 89, 23);
		panel_1.add(btnNewButton_2);
	}
}
