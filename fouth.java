import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.protocol.Resultset;

import dao.ConnectionProvider;

public class fouth extends JFrame {


	private JPanel contentPane;
	private JLabel lbldate;
	private JLabel lblday;
	private JLabel lbltime;
	private String username;
	static String name;
	private String pass;
	private Connection cn;
	private Statement st;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_4;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
		//EventQueue.invokeLater(new Runnable() {
			//public void run() {
				//try {
					//fouth frame = new fouth(String uname);
					//frame.setVisible(true);
				//} catch (Exception e) {
				//	e.printStackTrace();
				//}
			//}
		//});
	//}
	public void clock()
	{
		Thread clock=new Thread()
		{

		public void run()
			{
				try {
					for(;;) {
					Calendar cal=Calendar.getInstance();
					int day=cal.get(Calendar.DAY_OF_MONTH);
					int mon=cal.get(Calendar.MONTH);
					int year=cal.get(Calendar.YEAR);

					int sec=cal.get(Calendar.SECOND);
					int min=cal.get(Calendar.MINUTE);
					int hour=cal.get(Calendar.HOUR);


					lblday.setText(""+day+"-"+mon+"-"+year);
					lbltime.setText(""+hour+":"+min+":"+sec);
					sleep(1000);}
				}catch(Exception e) {
					e.printStackTrace();
					}

			}
		};clock.start();
	}

	/**
	 * Create the frame.
	 */
	public fouth(String uname,String password) {
		this.username=uname;
		this.pass=password;
		name=username;
		try {
			cn=ConnectionProvider.getConnection();
			st=cn.createStatement();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}

	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(1130,700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(211, 211, 211));
		panel.setBounds(0, 0, 1112, 77);
		contentPane.add(panel);
		panel.setLayout(null);

		 lbltime = new JLabel("New label");
		lbltime.setForeground(new Color(139, 0, 0));
		lbltime.setFont(new Font("Serif", Font.BOLD, 15));
		lbltime.setBounds(1047, 0, 97, 26);
		panel.add(lbltime);

	     lblday = new JLabel("New label");
		lblday.setForeground(new Color(139, 0, 0));
		lblday.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 13));
		lblday.setBounds(1047, 23, 108, 26);
		panel.add(lblday);

		 lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setForeground(new Color(85, 107, 47));
		lblNewLabel_2.setBackground(new Color(240, 240, 240));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 50));
		lblNewLabel_2.setBounds(282, 8, 549, 44);
		panel.add(lblNewLabel_2);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 146, 77);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		Image img1= new ImageIcon(this.getClass().getResource("/u.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img1));
		lblNewLabel.setBounds(0, 0, 94, 77);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("WELCOME");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setForeground(new Color(139, 69, 19));
		lblNewLabel_1.setBounds(55, 0, 164, 33);
		panel_1.add(lblNewLabel_1);

		 lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setForeground(new Color(189, 183, 107));
		lblNewLabel_4.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		
		lblNewLabel_4.setBounds(55, 29, 164, 26);
		panel_1.add(lblNewLabel_4);


		JButton btnNewButton_5 = new JButton("HOME");
		btnNewButton_5.setBackground(new Color(255, 255, 255));
		btnNewButton_5.setForeground(new Color(218, 165, 32));
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_5.setBounds(558, 100, 108, 34);
		contentPane.add(btnNewButton_5);

		JButton btnNewButton = new JButton("BILLING");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Bill1(username,pass).setVisible(true);


			}
		});
		btnNewButton.setBackground(new Color(189, 183, 107));
		btnNewButton.setForeground(new Color(184, 134, 11));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(703, 102, 89, 34);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("STAFF");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="select * from log where( Mobileno='"+username+"'AND password='"+pass+"')";
					ResultSet rs=st.executeQuery(query);
					if(rs.next()) {
						String re=rs.getString(5);
						String user=rs.getString(1);
						new Staff(user).setVisible(true);
					}

				}catch(Exception e1){
					JOptionPane.showMessageDialog(null,e1);
				}
				
				
			}
		});
		btnNewButton_1.setBackground(new Color(189, 183, 107));
		btnNewButton_1.setForeground(new Color(184, 134, 11));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(822, 102, 102, 34);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_3 = new JButton("Edit Items Price");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="select * from log where( Mobileno='"+username+"'AND password='"+pass+"')";
					ResultSet rs=st.executeQuery(query);
					if(rs.next()) {
						String re=rs.getString(5);
						String user=rs.getString(1);
						new price(user).setVisible(true);
					}

				}catch(Exception e1){
					JOptionPane.showMessageDialog(null,e1);
				}
				
			}
		});
		btnNewButton_3.setBackground(new Color(189, 183, 107));
		btnNewButton_3.setForeground(new Color(184, 134, 11));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_3.setBounds(946, 100, 139, 34);
		contentPane.add(btnNewButton_3);
		JButton btnNewButton_4 = new JButton("LOGOUT");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login1().setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_4.setBackground(new Color(0, 0, 0));
		btnNewButton_4.setForeground(new Color(139, 0, 0));
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_4.setBounds(1004, 608, 108, 23);
		contentPane.add(btnNewButton_4);

		JLabel lblNewLabel_3 = new JLabel("New label");
		Image img2= new ImageIcon(this.getClass().getResource("/for.png")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(img2));
		lblNewLabel_3.setBounds(0, 77, 1114, 584);
		contentPane.add(lblNewLabel_3);

		try {
			String query="select * from log where( Mobileno='"+username+"'AND password='"+pass+"')";
			ResultSet rs=st.executeQuery(query);
			if(rs.next()) {
				String re=rs.getString(5);
				String user=rs.getString(1);
				lblNewLabel_2.setText(re+"   Restaurant");
				lblNewLabel_4.setText(user+"");
			}

		}catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
		}
		clock();



	}
}
