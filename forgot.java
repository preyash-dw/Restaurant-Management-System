import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import dao.ConnectionProvider;


public class forgot extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private Connection cn;
	private Statement st;
	private String uname;
	private String nm;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
		//EventQueue.invokeLater(new Runnable() {
			//@Override
			//public void run() {
				//try {
					//forgot frame = new forgot();
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
	public forgot() {
		try {
			cn=ConnectionProvider.getConnection();
			st=cn.createStatement();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);}



		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(true);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblNewLabel.setBounds(138, 90, 49, 14);
		contentPane.add(lblNewLabel);

		textField = new JTextField("Enter Email Adress");
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textField.getText().equals("Enter Email Adress")) {
					textField.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textField.getText().equals("")) {
					textField.setText("Enter Email Adress");
				}

			}
		});
		textField.setBounds(197, 87, 308, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBounds(138, 156, 367, 109);
		contentPane.add(panel);
		panel.setVisible(false);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("New Password");
		lblNewLabel_1.setForeground(new Color(139, 69, 19));
		lblNewLabel_1.setFont(new Font("Serif", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 11, 94, 14);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Verify Password");
		lblNewLabel_2.setForeground(new Color(139, 69, 19));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(10, 47, 105, 14);
		panel.add(lblNewLabel_2);

		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try{String pass1=new String(passwordField.getPassword());
				String pass2=new String(passwordField_1.getPassword());
				nm=textField.getText();
				if(pass1.equals(pass2))
				{
				   if(pass1.length()==0) {
					   JOptionPane.showMessageDialog(null,"Enter Password first");
				   }else {
					   String query="update log set password='"+pass1+"'where email='"+nm+"'";
					   st.executeUpdate(query);
					   JOptionPane.showMessageDialog(null, "Password changed succesfully");
					   new Login1().setVisible(true);
						setVisible(false);
				   }

			}
				else {
					JOptionPane.showMessageDialog(null, "Re-enter Password");
					passwordField.setText("");
					passwordField_1.setText("");
				}}
				catch(Exception e3) {
					JOptionPane.showMessageDialog(null, e3);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(278, 86, 89, 23);
		panel.add(btnNewButton);

		passwordField = new JPasswordField();
		passwordField.setBounds(114, 9, 243, 20);
		panel.add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(114, 44, 243, 20);
		panel.add(passwordField_1);

		JButton btnNewButton_1 = new JButton("OK");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				try{
					uname=textField.getText();

				String query="select email from log where(email='"+uname+"')";
				ResultSet rs=st.executeQuery(query);
				if(rs.next()) {
					panel.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null,"Email not found");
				}
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnNewButton_1.setFont(new Font("Serif", Font.BOLD, 14));
		btnNewButton_1.setBounds(418, 111, 87, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("EXIT");
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_2.setBackground(new Color(0, 0, 0));
		btnNewButton_2.setForeground(new Color(139, 0, 0));
		btnNewButton_2.setBounds(479, 359, 89, 23);
		contentPane.add(btnNewButton_2);
	}
	}

