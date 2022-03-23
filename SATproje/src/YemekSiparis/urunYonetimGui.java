package YemekSiparis;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;

public class urunYonetimGui extends JFrame {
	private static Restoran restoran=new Restoran();
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private dbas conn=new dbas();
	private JTable table;
	private DefaultTableModel RestoranUrunTable=null;
	private Object[] urunler=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					urunYonetimGui frame = new urunYonetimGui(restoran);
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
	public urunYonetimGui(Restoran restoran) throws SQLException {
		setResizable(false);
		setTitle("\u00DCr\u00FCn Y\u00F6netimi");
		RestoranUrunTable=new DefaultTableModel();
		int rID=restoran.getId();
		Object[] colUrun=new Object[2];
		colUrun[0]="ürün_ad";
		colUrun[1]="fiyat";
		RestoranUrunTable.setColumnIdentifiers(colUrun);
		urunler=new Object[2];
		Connection con=conn.baglanti();
		Statement st=(Statement) con.createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM menü_ürünler WHERE restoran_id='"+rID+"' ");
		while(rs.next()) {
			urunler[0]=rs.getString("ürün_ad");
			urunler[1]=rs.getDouble("fiyat");
			RestoranUrunTable.addRow(urunler);
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 582, 536);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u00DCr\u00FCn Ekle");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(64, 57, 201, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u00DCr\u00FCn \u00C7\u0131kar");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(64, 308, 107, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(85, 103, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u00DCr\u00FCn ad\u0131 :");
		lblNewLabel_2.setBounds(10, 106, 56, 14);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(85, 154, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u00DCr\u00FCn fiyat\u0131 :");
		lblNewLabel_3.setBounds(10, 157, 65, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("A\u00E7\u0131klama :");
		lblNewLabel_4.setBounds(10, 212, 56, 14);
		contentPane.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(85, 209, 155, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(85, 352, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\u00DCr\u00FCn ad\u0131 :");
		lblNewLabel_5.setBounds(10, 355, 65, 14);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("Ekle");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double d=Double.parseDouble(textField_1.getText());
			
				boolean kontrol=false;
				try {
					
					
						urunler[0]=textField.getText();
						urunler[1]=textField_1.getText();
						RestoranUrunTable.addRow(urunler);
					
					kontrol= restoran.restoranUrunEkle(textField.getText(), d, textField_2.getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
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
		btnNewButton.setBounds(82, 255, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u00C7\u0131kar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean kontrol=false;
				kontrol= restoran.restoranUrunCýkar( textField_3.getText());
				int count=0;
				int rowID=0;
				while(count<RestoranUrunTable.getRowCount()) {
					if(textField_3.getText()==RestoranUrunTable.getValueAt(count, 0)) {
						
						rowID=count;
						RestoranUrunTable.removeRow(rowID);
						
						
						
						
						
						
					}
					count++;
				}
				
			 
				if(kontrol) {
					
					Popup.popup("success");
					dispose();
					restoranGui rest=new restoranGui(restoran);
					rest.setLocationRelativeTo(null);
					rest.setVisible(true);
					
					
				}
				else {
					Popup.popup("fail");
				}
			}
		});
		btnNewButton_1.setBounds(82, 397, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(284, 78, 180, 200);
		contentPane.add(scrollPane);
		
		table = new JTable(RestoranUrunTable);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_2 = new JButton("<--");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				restoranGui restorangui=new restoranGui(restoran);
				restorangui.setLocationRelativeTo(null);
				restorangui.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(10, 11, 56, 23);
		contentPane.add(btnNewButton_2);
	}
}
