import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import dao.ConnectionProvider;

public class Sign extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private Connection cn;
	private Statement st;
	private JTextField txtEnterRestaurantname;
	private JTextField txtEnterUsername;
	private JTextField txtEnterMobileNumber;
	private JTextField txtEnterEmailAdress;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
		//EventQueue.invokeLater(new Runnable() {
			//@Override
			//public void run() {
				//try {
					//Sign frame = new Sign();
					//frame.setVisible(true);
				//} catch (Exception e) {
					//e.printStackTrace();
				//}
			//}
		//});
	//}

	/**
	 * Create the frame.
	 */
	public Sign() {

		try {
			cn=ConnectionProvider.getConnection();
			st=cn.createStatement();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(1300,700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(224, 255, 255));
		panel.setBounds(428, 112, 520, 405);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Restaurant Name");
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 52, 104, 14);
		panel.add(lblNewLabel);

		txtEnterRestaurantname = new JTextField();
		
		txtEnterRestaurantname.setFont(new Font("Trebuchet MS", Font.ITALIC, 11));
		txtEnterRestaurantname.setBounds(146, 49, 164, 20);
		panel.add(txtEnterRestaurantname);
		txtEnterRestaurantname.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("User Name.");
		lblNewLabel_1.setFont(new Font("Serif", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 93, 91, 14);
		panel.add(lblNewLabel_1);

		txtEnterUsername = new JTextField();
		
		txtEnterUsername.setFont(new Font("Trebuchet MS", Font.ITALIC, 12));
		txtEnterUsername.setBounds(146, 91, 164, 20);
		panel.add(txtEnterUsername);
		txtEnterUsername.setColumns(10);

		txtEnterMobileNumber = new JTextField();
		

		txtEnterMobileNumber.setFont(new Font("Trebuchet MS", Font.ITALIC, 11));
		txtEnterMobileNumber.setBounds(146, 122, 164, 20);
		panel.add(txtEnterMobileNumber);
		txtEnterMobileNumber.setColumns(10);

		txtEnterEmailAdress = new JTextField();
		
		txtEnterEmailAdress.setFont(new Font("Trebuchet MS", Font.ITALIC, 11));
		txtEnterEmailAdress.setBounds(146, 153, 164, 20);
		panel.add(txtEnterEmailAdress);
		txtEnterEmailAdress.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Contact No.");
		lblNewLabel_2.setFont(new Font("Serif", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 125, 91, 14);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("E-Mail.");
		lblNewLabel_3.setFont(new Font("Serif", Font.BOLD, 13));
		lblNewLabel_3.setBounds(10, 156, 46, 14);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setFont(new Font("Serif", Font.BOLD, 13));
		lblNewLabel_4.setBounds(10, 193, 91, 14);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Verify Password");
		lblNewLabel_5.setFont(new Font("Serif", Font.BOLD, 13));
		lblNewLabel_5.setBounds(10, 224, 104, 14);
		panel.add(lblNewLabel_5);

		passwordField = new JPasswordField();
		
			
			
		passwordField.setEchoChar('*');
		passwordField.setBounds(146, 184, 164, 20);
		panel.add(passwordField);

		passwordField_1 = new JPasswordField();
		
		
		passwordField_1.setEchoChar('*');
		passwordField_1.setBounds(145, 222, 165, 20);
		panel.add(passwordField_1);

		 JButton btnNewButton = new JButton("SUBMIT");
		 btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String res=txtEnterRestaurantname.getText();
					String name=txtEnterUsername.getText();
					String mob= txtEnterMobileNumber.getText();
					boolean result=mob.matches("[0-9]+");
					String em=txtEnterEmailAdress.getText();
					String pass =new String(passwordField.getPassword());
					String pass2=new String(passwordField_1.getPassword());
					String query="insert into log(name,Mobileno,email,password,res) values('"+name+"','"+mob+"','"+em+"','"+pass+"','"+res+"')";
					if(res.length()>0) {
						if(name.length()>0) {
							if(mob.length()==10) {
								if(result==true) {
								if(em.length()>8) {
									if(pass.equals(pass2)) {
										st.executeUpdate(query);
										JOptionPane.showMessageDialog(null,"Saved succesfully");
										Login1 ob=new Login1();
										ob.setVisible(true);


										txtEnterRestaurantname.setText("");
										txtEnterUsername.setText("");
										txtEnterMobileNumber.setText("");
										txtEnterEmailAdress.setText("");
										passwordField.setText("");
										passwordField_1.setText("");
										setVisible(false);

									}else {
										JOptionPane.showMessageDialog(null, "Enter password again");
										passwordField_1.setText("");
									}
								}else {
									JOptionPane.showMessageDialog(null,"Enter valid email");
									txtEnterEmailAdress.setText("");
								}
								}else {
									JOptionPane.showMessageDialog(null, "Do not enter character in Mobile No");
									txtEnterMobileNumber.setText("");
								}
							}else {
								JOptionPane.showMessageDialog(null, "Enter valid Mobile no");
								txtEnterMobileNumber.setText("");
							}
						}else {
							JOptionPane.showMessageDialog(null, "Enter User Name");
						}
					}else {
						JOptionPane.showMessageDialog(null, "Enter Restaurant name");
					}

					}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnNewButton.setBounds(126, 307, 171, 23);
		panel.add(btnNewButton);

		JCheckBox chckbxNewCheckBox = new JCheckBox("Show Password");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox.isSelected()) {
						passwordField.setEchoChar((char)0);}
				else {
					passwordField.setEchoChar('*');
				}
				
			}
		});
		chckbxNewCheckBox.setBounds(330, 183, 112, 23);
		panel.add(chckbxNewCheckBox);

		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Show Password");
		chckbxNewCheckBox_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_1.isSelected()) {
					passwordField_1.setEchoChar((char)0);
				}
				else {
					passwordField_1.setEchoChar('*');
				}
			}
		});
		chckbxNewCheckBox_1.setBounds(330, 221, 112, 23);
		panel.add(chckbxNewCheckBox_1);

		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtEnterRestaurantname.setText("Enter Restautrant Name");
				txtEnterUsername.setText("Enter User name");
				txtEnterMobileNumber.setText("Enter Mobile Number");
				txtEnterEmailAdress.setText("Enter Email");
				passwordField.setText("Enter Password");
				passwordField_1.setText("Re-enter Password");


			}
		});
		btnNewButton_1.setBounds(12, 307, 89, 23);
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Close");
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Login1().setVisible(true);
			}
		});
		btnNewButton_2.setBounds(365, 308, 89, 23);
		panel.add(btnNewButton_2);
		JLabel lblNewLabel_6 = new JLabel("Create Account");
		lblNewLabel_6.setBounds(428, 89, 126, 29);
		contentPane.add(lblNewLabel_6);
		lblNewLabel_6.setFont(new Font("Yu Gothic", Font.PLAIN, 18));
		lblNewLabel_6.setBackground(new Color(255, 250, 205));
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(238, 232, 170));
		panel_1.setBounds(428, 81, 144, 37);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 0));
		panel_2.setBounds(0, 0, 1369, 746);
		contentPane.add(panel_2);
		panel_2.setLayout(null);



	}
}
