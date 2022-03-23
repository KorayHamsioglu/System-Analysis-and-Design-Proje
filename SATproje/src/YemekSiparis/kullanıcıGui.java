package YemekSiparis;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;

import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

public class kullanýcýGui extends JFrame {
    static Musteri musteri=new Musteri();
	private JPanel contentPane;
	private dbas conn=new dbas();
	private JTable table;
	private int restoranid;
	private DefaultTableModel RestoranUrunTable=null;
	private DefaultTableModel RestoranUrunTable1=null;
	private Object[] urunler=null;
	private Object[] urunler1=null;
	private JTable table_1;
	private JTable table_2;
	private Siparis siparis=new Siparis();
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kullanýcýGui frame = new kullanýcýGui(musteri);
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
	 * @throws SQLException 
	 */
	public kullanýcýGui(Musteri musteri) throws SQLException {
		setResizable(false);
		setTitle("Sipari\u015F Ekran\u0131");
		RestoranUrunTable=new DefaultTableModel();
		Object[] colUrun=new Object[2];
		colUrun[0]="ürün_ad";
		colUrun[1]="fiyat";
		RestoranUrunTable.setColumnIdentifiers(colUrun);
		urunler=new Object[2];
		
		RestoranUrunTable1=new DefaultTableModel();
		Object[] colUrun1=new Object[2];
		colUrun1[0]="ürün_ad";
		colUrun1[1]="fiyat";
		RestoranUrunTable1.setColumnIdentifiers(colUrun);
		urunler1=new Object[2];
		
		Connection con=conn.baglanti();
		Statement stat=con.createStatement();
		ResultSet rs=stat.executeQuery("SELECT * FROM restoranlar");
		
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 574);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		
		comboBox.setBounds(249, 125, 137, 24);
		while(rs.next()) {
			
			comboBox.addItem(rs.getString("restoran_adý"));
		}
		
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Restoran Se\u00E7iniz");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(259, 90, 137, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Urunler");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(75, 175, 103, 14);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(272, 481, 143, 14);
		contentPane.add(lblNewLabel_3);
	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 216, 155, 208);
		contentPane.add(scrollPane);
		scrollPane.setVisible(false);
		table_1 = new JTable(RestoranUrunTable);
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
				
			}
		});
		scrollPane.setViewportView(table_1);
		JButton btnNewButton = new JButton("Ekle");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Urun urun=new Urun(table_1.getValueAt(table_1.getSelectedRow(), 0).toString(),Double.parseDouble(table_1.getValueAt(table_1.getSelectedRow(), 1).toString()));
				siparis.urunEkle(urun);
				
				urunler1[0]=table_1.getValueAt(table_1.getSelectedRow(),0).toString();
				urunler1[1]=table_1.getValueAt(table_1.getSelectedRow(), 1);
				RestoranUrunTable1.addRow(urunler1);
				lblNewLabel_3.setText("Toplam Tutar: " +String.valueOf(siparis.getToplamTutar()));
				
			}
		});
		btnNewButton.setBackground(new Color(0, 100, 0));
		btnNewButton.setBounds(67, 438, 89, 23);
		contentPane.add(btnNewButton);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Sepet");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(490, 175, 89, 14);
		contentPane.add(lblNewLabel_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(442, 216, 155, 198);
		contentPane.add(scrollPane_1);
		
		table_2 = new JTable(RestoranUrunTable1);
		scrollPane_1.setViewportView(table_2);
		
		JButton btnNewButton_2 = new JButton("\u00C7\u0131kar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Urun urun=new Urun(table_2.getValueAt(table_2.getSelectedRow(), 0).toString(),Double.parseDouble(table_2.getValueAt(table_2.getSelectedRow(), 1).toString()));
				siparis.urunCikar(urun);
				
				lblNewLabel_3.setText("Toplam Tutar: " +String.valueOf(siparis.getToplamTutar()));
				RestoranUrunTable1.removeRow(table_2.getSelectedRow());
			}
		});
		btnNewButton_2.setBackground(Color.RED);
		btnNewButton_2.setBounds(477, 438, 89, 23);
		contentPane.add(btnNewButton_2);
		
		
		btnNewButton.setVisible(false);
		
		
	
		
		
	
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RestoranUrunTable.setRowCount(0);
				try {
					Statement stat2=con.createStatement();
					ResultSet rs2=stat2.executeQuery("SELECT * FROM restoranlar");
					while(rs2.next()) {
						if(rs2.getString("restoran_adý").equals(comboBox.getSelectedItem())) {
							lblNewLabel_1.setVisible(true);
							scrollPane.setVisible(true);
							btnNewButton.setVisible(true);
							restoranid=rs2.getInt("restoran_id");
							
			
				}	
					}
					Statement stat3=con.createStatement();
					ResultSet rs3=stat3.executeQuery("SELECT * FROM menü_ürünler WHERE restoran_id='"+restoranid+"' ");
					while(rs3.next()) {
						urunler[0]=rs3.getString("ürün_ad");
						urunler[1]=rs3.getDouble("fiyat");
						RestoranUrunTable.addRow(urunler);
						
						
				}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		JButton btnNewButton_1 = new JButton("Sipari\u015F Ver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean kontrol=false;
				try {
					
					kontrol=musteri.siparisver(siparis);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.out.println("hata");
					e1.printStackTrace();
				}
				if(kontrol) {
					
					Popup.popup("success");
					
					
				}
				else {
					Popup.popup("fail");
				}
			}
		});
		btnNewButton_1.setBounds(442, 472, 143, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("\u00C7\u0131k\u0131\u015F Yap");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				 uye frame=new uye();
				 frame.setLocationRelativeTo(null);
			     frame.setVisible(true);
			
				
			}
		});
		btnNewButton_3.setBounds(41, 11, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_4 = new JLabel("Uygulamay\u0131 de\u011Ferlendir ( 1-5 ): ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(249, 20, 193, 14);
		contentPane.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(442, 18, 28, 16);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("Oyla !");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					boolean key=musteri.uygulamaDegerlendir(musteri.getKullanýcýAdi(), Double.parseDouble(textField.getText())%5);
					if(key==false) {
						Popup.popup("hata1");
						textField.setEditable(false);
					}
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_4.setBounds(490, 17, 89, 17);
		contentPane.add(btnNewButton_4);
		
	}
}
