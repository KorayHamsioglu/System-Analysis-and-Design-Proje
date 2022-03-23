package YemekSiparis;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class restoranGui extends JFrame {
    static Restoran restoran=new Restoran();
	private JPanel contentPane;
	private DefaultTableModel siparislerTable=null;
	private Object[] siparisUrun=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					restoranGui frame = new restoranGui(restoran);
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
	public restoranGui(Restoran restoran) {
		setTitle("Restoran Aray\u00FCz\u00FC");
		setResizable(false);
		siparislerTable=new DefaultTableModel();
		Object[] colUrun=new Object[4];
		colUrun[0]="ad";
		colUrun[1]="fiyat";
		colUrun[2]="açýklama";
		colUrun[3]="restoran_id";
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Urun Y\u00F6netimi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				urunYonetimGui uyGui;
				try {
					uyGui = new urunYonetimGui(restoran);
					uyGui.setLocationRelativeTo(null);
					uyGui.setVisible(true);
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(127, 205, 162, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u00C7\u0131k\u0131\u015F Yap");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				 uye frame=new uye();
				 frame.setLocationRelativeTo(null);
			      frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(10, 11, 85, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(127, 55, 162, 36);
		contentPane.add(lblNewLabel);
		lblNewLabel.setText(restoran.getAd());
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_2.setBounds(127, 113, 162, 14);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setText("Adres: " + restoran.getAdres());
	}
}
