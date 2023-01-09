import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.ConnectionProvider;
import javax.swing.JScrollPane;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Staff extends JFrame {

	private JPanel contentPane;
	private JTextField txtNameOfStaff;
	private JLayeredPane layeredPane;
	private JPanel JPanel;
	private javax.swing.JPanel panel_5;
	private javax.swing.JPanel panel_6;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;
	private ButtonGroup buttongr=new ButtonGroup();
	private JLabel lblNewLabel_14;
	private JComboBox comboBox;
	private Connection cn;
	private Statement st;
	private JComboBox comboBox_1;
	private javax.swing.JPanel panel_9;
	DefaultTableModel model;
	private JLabel lblNewLabel_15;
	private JLabel lblNewLabel_17;
	private JLabel lblNewLabel_19;
	private JLabel lblNewLabel_20;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private String name;


	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
		//EventQueue.invokeLater(new Runnable() {
			//@Override
			//public void run() {
				//try {
					//Staff frame = new Staff();
				//	frame.setVisible(true);
				//} catch (Exception e) {
					//e.printStackTrace();
				//}
			//}
		//});
	//}

	/**
	 * Create the frame.
	 */
	public Staff(String username) {
		this.name=username;
		try {
			cn=ConnectionProvider.getConnection();
			st=cn.createStatement();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);}
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(1260,700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 224));
		panel.setBounds(0, 0, 1244, 97);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 0, 154, 97);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("WELCOME");
		lblNewLabel_2.setForeground(new Color(139, 69, 19));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_2.setBounds(10, 0, 149, 47);
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(10, 47, 124, 39);
		lblNewLabel_3.setText(name);
		panel_1.add(lblNewLabel_3);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(248, 248, 255));
		panel_2.setBounds(1102, 0, 143, 97);
		panel.add(panel_2);
		panel_2.setLayout(null);

		 lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_4.setBounds(10, 11, 123, 25);
		panel_2.add(lblNewLabel_4);

		 lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setForeground(new Color(0, 0, 0));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(10, 32, 123, 28);
		panel_2.add(lblNewLabel_5);

		JLabel lblNewLabel = new JLabel("STAFF RECORD");
		lblNewLabel.setBackground(new Color(218, 165, 32));
		lblNewLabel.setForeground(new Color(143, 188, 143));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(511, 11, 403, 75);
		panel.add(lblNewLabel);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(210, 180, 140));
		panel_3.setBounds(0, 97, 1244, 59);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JButton btnNewButton_1 = new JButton("Add New Staff");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Select(panel_5);
			}
		});
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setForeground(new Color(255, 215, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(183, 36, 144, 23);
		panel_3.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Profile");
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Select(panel_6);
			}
		});
		btnNewButton_2.setBackground(new Color(0, 0, 0));
		btnNewButton_2.setForeground(new Color(255, 215, 0));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.setBounds(10, 36, 144, 23);
		panel_3.add(btnNewButton_2);

		JButton btnNewButton_6 = new JButton("New button");
		btnNewButton_6.setBounds(1153, 37, -227, -28);
		panel_3.add(btnNewButton_6);

		JButton btnNewButton_7 = new JButton("Exit");
		btnNewButton_7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_7.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_7.setForeground(new Color(139, 0, 0));
		btnNewButton_7.setBounds(1155, 37, 89, 23);
		panel_3.add(btnNewButton_7);

		 layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 155, 1244, 506);
		contentPane.add(layeredPane);

		 panel_5 = new JPanel();
		 panel_5.setBackground(new Color(240, 230, 140));
		layeredPane.setLayer(panel_5, 0);
		panel_5.setBounds(0, 0, 1244, 506);
		layeredPane.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblNewLabel_7 = new JLabel("Register");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_7.setBounds(589, 91, 93, 22);
		panel_5.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Name");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_8.setBounds(493, 143, 68, 22);
		panel_5.add(lblNewLabel_8);

		textField_1 = new JTextField();
		textField_1.setBounds(589, 144, 148, 20);
		panel_5.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("Contact No.");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_9.setBounds(460, 190, 68, 14);
		panel_5.add(lblNewLabel_9);

		textField_2 = new JTextField();
		textField_2.setBounds(589, 187, 148, 20);
		panel_5.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel_10 = new JLabel("Aadhar Card No");
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_10.setBounds(460, 245, 93, 14);
		panel_5.add(lblNewLabel_10);

		textField_3 = new JTextField();
		textField_3.setBounds(589, 242, 148, 20);
		panel_5.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblNewLabel_11 = new JLabel("Gender");
		lblNewLabel_11.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_11.setBounds(458, 289, 46, 14);
		panel_5.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Profession");
		lblNewLabel_12.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_12.setBounds(460, 336, 82, 14);
		panel_5.add(lblNewLabel_12);

		comboBox = new JComboBox(new String[] {"Waiter","Helper","Chef","Other"});
		comboBox.setBounds(589, 332, 148, 22);
		panel_5.add(comboBox);

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(211, 211, 211));
		panel_7.setBounds(437, 70, 431, 369);
		panel_5.add(panel_7);
		panel_7.setLayout(null);

		JButton btnNewButton_4 = new JButton("SUBMIT");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String n=textField_1.getText();
					String m=textField_2.getText();
					boolean result=m.matches("[0-9]+");
					String a=textField_3.getText();
					if(n.length()>0) {
						if(m.length()==10) {
							if(result==true) {
							if(a.length()==12) {	String nam=textField_1.getText().toLowerCase();
							String con=textField_2.getText();
							String aadhar=textField_3.getText();
							 String gen= (String)comboBox_1.getItemAt(comboBox_1.getSelectedIndex());
							    String  selected= (String)comboBox.getItemAt(comboBox.getSelectedIndex());
							    String query="insert into staff(name,mobileno,aadhar,gender,profession) values('"+nam+"','"+con+"','"+aadhar+"','"+gen+"','"+selected+"')";
							    st.executeUpdate(query);
							    JOptionPane.showMessageDialog(null,"Staff Details Added");
							    textField_1.setText("");
							    textField_2.setText("");
							    textField_3.setText("");
							}else {
								JOptionPane.showMessageDialog(null, "Enter valid Aadhar no ");
							}}
							else {
								JOptionPane.showMessageDialog(null, "don't enter character in mobile no.");
								textField_2.setText("");
							}
							
						}else {
							JOptionPane.showMessageDialog(null, "enter valid Mobile no");
							textField_2.setText("");;
						}
					}else {
						JOptionPane.showMessageDialog(null,"Enter name");
					}
				}
				catch(Exception e3) {
					JOptionPane.showMessageDialog(null, e3);
				}
			}
		});
		btnNewButton_4.setBounds(97, 335, 140, 23);
		panel_7.add(btnNewButton_4);
		
		comboBox_1 = new JComboBox(new String[] {"MALE","FEMALE"});
		comboBox_1.setBounds(152, 221, 64, 22);
		panel_7.add(comboBox_1);
		

		 panel_6 = new JPanel();
		 panel_6.setBackground(new Color(238, 232, 170));
		 layeredPane.setLayer(panel_6, 0);
		panel_6.setBounds(0, 0, 1244, 506);
		layeredPane.add(panel_6);
		panel_6.setLayout(null);

		 lblNewLabel_14 = new JLabel("NAME");
		lblNewLabel_14.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_14.setBounds(35, 104, 68, 33);
		panel_6.add(lblNewLabel_14);

		textField_4 = new JTextField("Name of staff");
		textField_4.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textField_4.getText().equals("Name of staff"));{
					textField_4.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textField_4.getText().equals("")) {
					textField_4.setText("Name of staff");
				}
			}
		});
		textField_4.setBounds(84, 104, 142, 26);
		panel_6.add(textField_4);
		textField_4.setColumns(10);

		JPanel panel_8 = new JPanel();
		panel_8.setBounds(20, 156, 372, 228);
		panel_6.add(panel_8);
		panel_8.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 352, 194);
		panel_8.add(scrollPane);

		table = new JTable();
		
		model=new DefaultTableModel();
		Object[] coloumnee= {"NAME","PROFESSION"};
		Object[] rowee=new Object[0];
		model.setColumnIdentifiers(coloumnee);
		table.setModel(model);
		table.setBackground(Color.LIGHT_GRAY);

		scrollPane.setViewportView(table);

		JButton btnNewButton_5 = new JButton("Confirm");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{int select=table.getRowCount();
				if(select!=0) {
					
					String t=textField_4.getText();
					int i=table.getSelectedRow();
					String text=model.getValueAt(i,0).toString();
					String query="select *from staff where name='"+text+"'";
					ResultSet rs=st.executeQuery(query);
				    if(rs.next()) {
				    	String n=rs.getString(1).toUpperCase();
				    	String mob=rs.getString(2);
				    	String adh=rs.getString(3);
				    	String gen=rs.getString(4);
				    	String prof=rs.getString(5).toUpperCase();
				    	lblNewLabel_15.setText(n);
				    	lblNewLabel_17.setText(mob);
				    	lblNewLabel_19.setText(adh);
				    	lblNewLabel_20.setText(prof);
				    }
				    panel_9.setVisible(true);
				}}
				catch(Exception e4) {
					JOptionPane.showMessageDialog(null, e4);
				}
			}
		});
		btnNewButton_5.setBounds(273, 205, 89, 23);
		panel_8.add(btnNewButton_5);

		 panel_9 = new JPanel();
		 panel_9.setBackground(new Color(220, 220, 220));
		panel_9.setBounds(476, 23, 465, 318);
		panel_6.add(panel_9);
		panel_9.setLayout(null);

		 lblNewLabel_15 = new JLabel("n");
		 lblNewLabel_15.setForeground(new Color(143, 188, 143));
		lblNewLabel_15.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblNewLabel_15.setBounds(10, 23, 110, 52);
		panel_9.add(lblNewLabel_15);

		JLabel lblNewLabel_16 = new JLabel("Contact Details");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_16.setBounds(10, 126, 110, 25);
		panel_9.add(lblNewLabel_16);

		 lblNewLabel_17 = new JLabel("");
		lblNewLabel_17.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_17.setBounds(141, 122, 206, 29);
		panel_9.add(lblNewLabel_17);

		JLabel lblNewLabel_18 = new JLabel("Aadhar No.");
		lblNewLabel_18.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_18.setBounds(10, 189, 122, 29);
		panel_9.add(lblNewLabel_18);

		lblNewLabel_19 = new JLabel("");
		lblNewLabel_19.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_19.setBounds(126, 184, 206, 34);
		panel_9.add(lblNewLabel_19);
		
		lblNewLabel_20 = new JLabel("");
		lblNewLabel_20.setBounds(114, 50, 102, 17);
		panel_9.add(lblNewLabel_20);
		
		JButton btnNewButton_8 = new JButton("SEARCH");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int count=model.getRowCount();
					for(int i=count-1;i>=0;i--) {
						model.removeRow(i);
					}
					String text=textField_4.getText().toLowerCase();
				String query="select *from staff where name like'"+text+"%'";
				ResultSet re=st.executeQuery(query);
				while(re.next()) {
					String name=re.getString(1);
					String profession=re.getString(5);
					String row[]= {name,profession};
					model.addRow(row);
				}
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnNewButton_8.setBounds(246, 104, 89, 23);
		panel_6.add(btnNewButton_8);
		
		
		panel_9.setVisible(false);
		clock();
	}
	public void clock()
	{
		Thread clock=new Thread()
		{

		@Override
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


						lblNewLabel_5.setText(""+day+"-"+mon+"-"+year);
						lblNewLabel_4.setText(""+hour+":"+min+":"+sec);
					sleep(1000);}
				}catch(InterruptedException e) {
					e.printStackTrace();
					}

			}
		};clock.start();
	}

	public void Select(JPanel p) {

			layeredPane.removeAll();
			layeredPane.add(p);
			layeredPane.repaint();
			layeredPane.revalidate();
		}
	}

