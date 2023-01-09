import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import dao.ConnectionProvider;

public class Login1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private Connection cn;
	private Statement st;
	private String uname;
	private String pass;
	static String s;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
		//EventQueue.invokeLater(new Runnable() {
	//		public void run() {
			//	try {
				//	Login1 frame = new Login1();
					//frame.setVisible(true);
			//	} catch (Exception e) {
				//	e.printStackTrace();
				//}
			//}
	//	});
	//}

	/**
	 * Create the frame.
	 */
	public Login1() {
		try {
			cn=ConnectionProvider.getConnection();
			st=cn.createStatement();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}


		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(900,600);
		setUndecorated(true);
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);


		JLabel lblNewLabel_2 = new JLabel("");
		Image img1= new ImageIcon(this.getClass().getResource("/log.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img1));
		lblNewLabel_2.setBounds(196, 135, 236, 316);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("USER");
		lblNewLabel_1.setForeground(new Color(112, 128, 144));
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setFont(new Font("Serif", Font.BOLD, 15));
		lblNewLabel_1.setBounds(442, 155, 87, 23);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField("Enter Mobile No");
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textField.getText().equals("Enter Mobile No")) {
					textField.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textField.getText().equals("")) {
					textField.setText("Enter Mobile No");
				}
			}
		});
		textField.setBounds(442, 179, 200, 23);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("PASSWORD");
		lblNewLabel_3.setForeground(new Color(119, 136, 153));
		lblNewLabel_3.setFont(new Font("Serif", Font.BOLD, 15));
		lblNewLabel_3.setBounds(442, 213, 87, 14);
		contentPane.add(lblNewLabel_3);

		passwordField = new JPasswordField();
		passwordField.setBounds(442, 238, 200, 20);
		contentPane.add(passwordField);

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			private String pass;

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					 uname=textField.getText();
					 pass =new String(passwordField.getPassword());
					String query="select * from log where Mobileno='"+uname+"'and password='"+pass+"'";
					ResultSet rs=st.executeQuery(query);
					if(rs.next()) {
						JOptionPane.showMessageDialog(null, "Login succesfull");
						s=textField.getText();
						textField.setText("");
						passwordField.setText("");
						fouth ob=new fouth(uname,pass);
						ob.setVisible(true);
						setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(null, "Invalid Username or Password");
						textField.setText("Enter Mobile No");
						passwordField.setText("");
					}

				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnNewButton.setBorder(BorderFactory.createEmptyBorder());
		Image img2= new ImageIcon(this.getClass().getResource("/corr.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img2));
		btnNewButton.setBounds(491, 269, 72, 33);
		contentPane.add(btnNewButton);

		JButton btnNewButton_3 = new JButton("CREATE");
		btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 new Sign().setVisible(true);
				 setVisible(false);

			}
		});
		btnNewButton_3.setBackground(new Color(245, 245, 245));
		btnNewButton_3.setForeground(new Color(112, 128, 144));
		btnNewButton_3.setBounds(455, 405, 108, 23);
		contentPane.add(btnNewButton_3);

		JLabel lblNewLabel_4 = new JLabel("Not having a account....");
		lblNewLabel_4.setBounds(445, 381, 118, 14);
		contentPane.add(lblNewLabel_4);

		JButton btnNewButton_4 = new JButton("Forgot Password");
		btnNewButton_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			new forgot().setVisible(true);
			}
		});

		btnNewButton_4.setBackground(new Color(245, 245, 245));
		btnNewButton_4.setForeground(new Color(105, 105, 105));
		btnNewButton_4.setBounds(533, 331, 127, 23);
		contentPane.add(btnNewButton_4);

		JPanel panel = new JPanel();
		panel.setForeground(new Color(230, 230, 250));
		panel.setBounds(433, 135, 236, 316);
		contentPane.add(panel);
		panel.setLayout(null);
		Image img3= new ImageIcon(this.getClass().getResource("/welcome.png")).getImage();

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(107, 142, 35));
		panel_1.setBounds(176, 99, 139, 38);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(107, 142, 35));
		panel_2.setBounds(316, 450, 372, 23);
		contentPane.add(panel_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(107, 142, 35));
		panel_3.setBounds(545, 99, 143, 38);
		contentPane.add(panel_3);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(107, 142, 35));
		panel_4.setBounds(176, 135, 20, 316);
		contentPane.add(panel_4);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(107, 142, 35));
		panel_5.setBounds(176, 450, 144, 23);
		contentPane.add(panel_5);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(107, 142, 35));
		panel_6.setBounds(670, 99, 18, 352);
		contentPane.add(panel_6);

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(107, 142, 35));
		panel_7.setBounds(300, 99, 263, 38);
		contentPane.add(panel_7);

		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(205, 133, 63));
		panel_8.setBounds(141, 55, 607, 452);
		contentPane.add(panel_8);
		panel_8.setLayout(null);

		JButton btnNewButton_1 = new JButton("EXIT");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);

			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(518, 429, 89, 23);
		panel_8.add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("");
		panel_8.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(img3));
		lblNewLabel.setBounds(180, -44, 262, 159);

		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(128, 0, 0));
		panel_9.setBounds(96, 29, 708, 510);
		contentPane.add(panel_9);

		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(192, 192, 192));
		panel_10.setBounds(10, 0, 872, 567);
		contentPane.add(panel_10);
		panel_10.setLayout(null);
	}

}
