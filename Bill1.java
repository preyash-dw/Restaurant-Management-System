import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Bill1 extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	DefaultTableModel model;
	DefaultTableModel model1;
	DefaultTableModel model2;
	DefaultTableModel model3;
	DefaultTableModel model4;
	DefaultTableModel model5;
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private Connection cn;
	private Statement st;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private String uname,pass;
	private JLayeredPane layeredPane;
	private JPanel panel_4;
	private JPanel panel_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JPanel panel_6;
	static JTable table;
	private JTextField textField_8;
	
	static JTable table_3;
	private JPanel panel_13;
	private JPanel panel_11;
	private JTable table_2;
	private JPanel panel_16;
	private JTable table_5;
	private JPanel panel_15;
	private JLabel lbldate;
	private JLabel lblday;
	private JLabel lbltime;
	private JTable table_4;
	private JTable table_6;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_9;
	
	static JTable table_1;
	static int total=0;
	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
		//EventQueue.invokeLater(new Runnable() {
			//public void run() {
				//try {
					//Bill1 frame = new Bill1();
					//frame.setVisible(true);
				//} catch (Exception e) {
					//e.printStackTrace();
				//}
			//}
		//});
	//}
	
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
	public Bill1(String username,String pass1) {

		this.uname=username;
		this.pass=pass1;
		
		try {
			cn=ConnectionProvider.getConnection();
			st=cn.createStatement();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(1370,720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);


		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 1354, 681);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(0, 0, 1354, 92);
		panel.add(panel_1);
		panel_1.setLayout(null);
		Image img1= new ImageIcon(this.getClass().getResource("/u.png")).getImage();

		JLabel lblNewLabel_3 = new JLabel("PROVIDE BILL");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblNewLabel_3.setBounds(563, 0, 287, 92);
		panel_1.add(lblNewLabel_3);

		JButton btnNewButton = new JButton("EXIT");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(1265, 69, 89, 23);
		panel_1.add(btnNewButton);

		JButton btnNewButton_2 = new JButton("HOME");
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);

			}
		});
		
		
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(1138, 69, 89, 23);
		panel_1.add(btnNewButton_2);



		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.GRAY);
		panel_3.setBounds(0, 91, 1354, 35);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JButton btnNewButton_3 = new JButton("ADD NEW BILL");
		btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Select(panel_4);
			}
		});
		btnNewButton_3.setForeground(new Color(255, 140, 0));
		btnNewButton_3.setFont(new Font("Serif", Font.BOLD, 13));
		btnNewButton_3.setBounds(10, 11, 141, 23);
		panel_3.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("PRIVATE CABIN BILLING");
		btnNewButton_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Select(panel_5);
			}
		});
		btnNewButton_4.setForeground(new Color(255, 140, 0));
		btnNewButton_4.setFont(new Font("Serif", Font.BOLD, 13));
		btnNewButton_4.setBounds(184, 11, 193, 23);
		panel_3.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("BIRTHDAY PARTY BILLING");
		btnNewButton_5.setForeground(new Color(255, 140, 0));
		btnNewButton_5.setFont(new Font("Serif", Font.BOLD, 13));
		btnNewButton_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Select(panel_6);
			}
		});
		btnNewButton_5.setBounds(405, 11, 212, 23);
		panel_3.add(btnNewButton_5);

		 layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 137, 1354, 544);
		panel.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));

		 panel_4 = new JPanel();
		panel_4.setBackground(new Color(240, 230, 140));
		layeredPane.add(panel_4);
		panel_4.setLayout(null);
		panel_5 = new JPanel();
		panel_5.setBackground(new Color(240, 230, 140));
		layeredPane.add(panel_5, "name_81986654533500");
		panel_5.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("Name.");
		lblNewLabel_4.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblNewLabel_4.setBounds(67, 92, 46, 14);
		panel_4.add(lblNewLabel_4);

		textField = new JTextField("Enter customer name");
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textField.getText().equals("Enter customer name")) {
					textField.setText("");
				}

			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textField.getText().equals("")) {
					textField.setText("Enter customer name");
				}
			}
		});
		textField.setBounds(137, 90, 176, 20);
		panel_4.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Mobile No.");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(56, 117, 73, 14);
		panel_4.add(lblNewLabel_5);

		textField_1 = new JTextField("Enter Customer mobile number");
		textField_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textField_1.getText().equals("Enter Customer mobile number")) {
					textField_1.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textField_1.getText().equals("")) {
					textField_1.setText("Enter Customer mobile number");
				}
			}
		});
		textField_1.setBounds(137, 121, 176, 20);
		panel_4.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("ADD ITEMS");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(807, 92, 81, 14);
		panel_4.add(lblNewLabel_6);

		textField_2 = new JTextField("Search Item Name Here.....");
		textField_2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textField_2.getText().equals("Search Item Name Here.....")) {
					textField_2.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textField_2.getText().equals("")) {
					textField_2.setText("Search Item Name Here.....");
				}
			}
		});
		textField_2.setBounds(898, 90, 336, 30);
		panel_4.add(textField_2);
		textField_2.setColumns(10);
		

		 panel_16 = new JPanel();
		panel_16.setBounds(928, 117, 416, 362);
		panel_5.add(panel_16);
		panel_16.setLayout(null);
		
		



		JButton btnNewButton_6 = new JButton("Search");
		btnNewButton_6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					String itm=textField_2.getText();
	  			int count=model.getRowCount();
				for(int i=count-1;i>=0;i--) {
					model.removeRow(i);
				}
	  			String query="select * from item where itemname like '"+itm+"%'";
	  			ResultSet re=st.executeQuery(query);
	  			ResultSetMetaData rsmd= re.getMetaData();
	  			String name,price;
	  			while(re.next()) {
	  				name=re.getString(1);
	  				price=re.getString(2);
	  				String []row1= {name,price};
	  				model.addRow(row1);
	  				panel_11.setVisible(true);
	  				
	  				

	  			}//else {

				
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});

		btnNewButton_6.setBounds(1244, 89, 89, 23);
		panel_4.add(btnNewButton_6);

				JLabel lblNewLabel_15 = new JLabel("CUSTOMER DETAILS");
		lblNewLabel_15.setForeground(new Color(189, 183, 107));
		lblNewLabel_15.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_15.setBounds(91, 40, 176, 14);
		panel_4.add(lblNewLabel_15);

		JPanel panel_9 = new JPanel();
		panel_9.setBounds(10, 170, 450, 352);
		panel_4.add(panel_9);
		panel_9.setLayout(null);

		JLabel lblNewLabel_7 = new JLabel("ITEMS PREVIEW");
		lblNewLabel_7.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblNewLabel_7.setBounds(183, 11, 116, 14);
		panel_9.add(lblNewLabel_7);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 37, 430, 284);
		panel_9.add(scrollPane_3);

		table_1 = new JTable();
		 model3=new DefaultTableModel();
			Object[] coloumne= {"ItemName","Price","Quantity","total price"};
			Object[] rowe=new Object[0];
			model3.setColumnIdentifiers(coloumne);
			table_1.setModel(model3);
			table_1.setBackground(Color.LIGHT_GRAY);

		scrollPane_3.setViewportView(table_1);

		JButton btnNewButton_8 = new JButton("CLEAR");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int select=table_1.getSelectedRow();
				model3.removeRow(select);
				
			}
		});
		btnNewButton_8.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton_8.setBounds(0, 329, 89, 23);
		panel_9.add(btnNewButton_8);

		JButton btnNewButton_9 = new JButton("RESET");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count=model3.getRowCount();
				for(int i=count-1;i>=0;i--) {
					model3.removeRow(i);
				}
			}
		});
		btnNewButton_9.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton_9.setBounds(361, 329, 89, 23);
		panel_9.add(btnNewButton_9);

		JPanel panel_10 = new JPanel();
		panel_10.setBounds(739, 274, 149, 203);
		panel_4.add(panel_10);
		panel_10.setLayout(null);

		JLabel lblNewLabel_23 = new JLabel(" SELECT QUANTITY");
		lblNewLabel_23.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblNewLabel_23.setBounds(10, 11, 129, 14);
		panel_10.add(lblNewLabel_23);

		JButton btnNewButton_10 = new JButton("OK");
		btnNewButton_10.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//String it1=model
				//adder(it1,it2);
				int select=table_4.getSelectedRow();
				String it1=model.getValueAt(select,0).toString();
				String it2=model.getValueAt(select, 1).toString();
				int it3=Integer.parseInt(textField_10.getText());
				int p=Integer.parseInt(it2);
				int total=it3*p;
				adder(it1,it2,it3,total);
				textField_2.setText("");
				textField_10.setText("");
				panel_11.setVisible(false);
				panel_10.setVisible(false);
			}
		});
		btnNewButton_10.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton_10.setBounds(21, 169, 89, 23);
		panel_10.add(btnNewButton_10);
		
		textField_10 = new JTextField("Enter Quantity of selected Item");
		textField_10.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textField_10.getText().equals("Enter Quantity of selected Item")) {
					textField_10.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textField_10.getText().equals("")) {
					textField_10.setText("Enter Quantity of selected Item");
				}
			}
		});
		textField_10.setBounds(10, 54, 129, 20);
		panel_10.add(textField_10);
		

		JButton btnNewButton_21 = new JButton("PRINT BILL");
		btnNewButton_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n=model3.getRowCount();
				String cn=textField.getText();
				String cmo=textField_1.getText();
				boolean result=cmo.matches("[0-9]+");
				if(cn.length()>0) {
					if(cmo.length()==10) {
						if(result==true) {
							if(n>0) {
							String cbn="NO";
							String duration="0";
							
							for(int i=0;i<=n-1;i++) {
								String t=(String) model3.getValueAt(i, 3);
								int num=Integer.parseInt(t);
								total+=num;
							}
							print(cn,cmo,cbn,duration);}
							else {
								JOptionPane.showMessageDialog(null, "Add Items first");
							}
							
							
						}else {
							JOptionPane.showMessageDialog(null, "Enter valid Mobile no");
							textField_1.setText("");
						}
					}else {
						JOptionPane.showMessageDialog(null, "Enter valid Mobile no");
						textField_1.setText("");
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "Enter Customer name");
				}
		
			}
		});
		btnNewButton_21.setBounds(470, 496, 147, 23);
		panel_4.add(btnNewButton_21);

		 panel_11 = new JPanel();
		panel_11.setBounds(896, 131, 437, 346);
		panel_4.add(panel_11);
		panel_11.setLayout(null);

		JButton btnNewButton_7 = new JButton("ADD");
		btnNewButton_7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int select=model.getRowCount();
				if(select!=0)
				{
					panel_10.setVisible(true);
				}
			}
		});
		btnNewButton_7.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton_7.setBounds(348, 323, 89, 23);
		panel_11.add(btnNewButton_7);
		
		JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 11, 417, 301);
		panel_11.add(scrollPane);
		
		table_4 = new JTable();
		
	    model=new DefaultTableModel();
		Object[] coloumn= {"ItemName","Price"};
		Object[] row=new Object[0];
		model.setColumnIdentifiers(coloumn);
		table_4.setModel(model);
		table_4.setBackground(Color.LIGHT_GRAY);

		
		scrollPane.setViewportView(table_4);

		

		JLabel lblNewLabel_8 = new JLabel("Name.");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_8.setBounds(60, 88, 46, 14);
		panel_5.add(lblNewLabel_8);

		textField_3 = new JTextField("Enter Customer Name");
		textField_3.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textField_3.getText().equals("Enter Customer Name")) {
					textField_3.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textField_3.getText().equals("")) {
					textField_3.setText("Enter Customer Name");
				}
			}
		});
		textField_3.setBounds(116, 86, 158, 20);
		panel_5.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("Contact No.");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_9.setBounds(26, 126, 73, 14);
		panel_5.add(lblNewLabel_9);

		textField_4 = new JTextField("Enter Customer Mobile No.");
		textField_4.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textField_4.getText().equals("Enter Customer Mobile No.")) {
					textField_4.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textField_4.getText().equals("")) {
					textField_4.setText("Enter CUSTOMER Mobile No.");
				}
			}
		});
		textField_4.setBounds(116, 124, 158, 20);
		panel_5.add(textField_4);
		textField_4.setColumns(10);

		JLabel lblNewLabel_10 = new JLabel("Cabin Duration");
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_10.setBounds(365, 72, 122, 14);
		panel_5.add(lblNewLabel_10);


		JLabel lblNewLabel_13 = new JLabel("ADD ITEMS");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_13.setBounds(887, 72, 84, 14);
		panel_5.add(lblNewLabel_13);

		textField_5 = new JTextField("Search Items Here.....");
		textField_5.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textField_5.getText().equals("Search Items Here.....")) {
					textField_5.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textField_5.getText().equals("")) {
					textField_5.setText("Enter Customer Name Here.....");
				}
			}
		});
		textField_5.setBounds(981, 70, 251, 20);
		panel_5.add(textField_5);
		textField_5.setColumns(10);
		
		

		JButton btnNewButton_11 = new JButton("SEARCH");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String itm=textField_5.getText();
	  			int count=model1.getRowCount();
				for(int i=count-1;i>=0;i--) {
					model1.removeRow(i);
				}
	  			String query="select * from item where itemname like '"+itm+"%'";
	  			ResultSet rs=st.executeQuery(query);
	  			ResultSetMetaData rsmd= rs.getMetaData();
	  			String name,price;
	  			while(rs.next()) {
	  				name=rs.getString(1);
	  				price=rs.getString(3);
	  				String []row11= {name,price};
	  				model1.addRow(row11);
	  				panel_16.setVisible(true);
	  				
	  				

	  			}//else {

				
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		
		btnNewButton_11.setBounds(1242, 69, 89, 23);
		panel_5.add(btnNewButton_11);

		JPanel panel_12 = new JPanel();
		panel_12.setBounds(10, 165, 593, 368);
		panel_5.add(panel_12);
		panel_12.setLayout(null);

		JLabel lblNewLabel_14 = new JLabel("ITEMS PREVIEW");
		lblNewLabel_14.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblNewLabel_14.setBounds(179, 11, 111, 14);
		panel_12.add(lblNewLabel_14);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(10, 44, 573, 288);
		panel_12.add(scrollPane_4);

		table_3 = new JTable();
		model4=new DefaultTableModel();
		Object[] coloumnee= {"ItemName","Price","Quantity","total price"};
		Object[] rowee=new Object[0];
		model4.setColumnIdentifiers(coloumnee);
		table_3.setModel(model4);
		table_3.setBackground(Color.LIGHT_GRAY);

		scrollPane_4.setViewportView(table_3);

		JButton btnNewButton_14 = new JButton("CLEAR");
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int select=table_3.getSelectedRow();
				model4.removeRow(select);			}
		});
		btnNewButton_14.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton_14.setBounds(0, 345, 89, 23);
		panel_12.add(btnNewButton_14);

		JButton btnNewButton_15 = new JButton("RESET");
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count=model4.getRowCount();
				for(int i=count-1;i>=0;i--) {
					model4.removeRow(i);
				}
			}
		});
		btnNewButton_15.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton_15.setBounds(494, 345, 89, 23);
		panel_12.add(btnNewButton_15);

		panel_13 = new JPanel();
		panel_13.setBounds(746, 303, 172, 176);
		panel_5.add(panel_13);
		panel_13.setLayout(null);

		JLabel lblNewLabel_24 = new JLabel("Quantity");
		lblNewLabel_24.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblNewLabel_24.setBounds(10, 11, 96, 14);
		panel_13.add(lblNewLabel_24);

		JButton btnNewButton_22 = new JButton("OK");
		btnNewButton_22.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int qn=Integer.parseInt(textField_12.getText()); 
				int select=table_2.getSelectedRow();
				String it1=model1.getValueAt(select, 0).toString();
				String it2=model1.getValueAt(select, 1).toString();
				int p=Integer.parseInt(it2);
				int total=qn*p;
				
				adder1(it1,it2,qn,total);
				panel_13.setVisible(false);
				panel_16.setVisible(false);
				
				//panel_13.setVisible(false);
			}
		});
		btnNewButton_22.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton_22.setBounds(35, 142, 89, 23);
		panel_13.add(btnNewButton_22);
		
		textField_12 = new JTextField("Enter Quantity Here");
		textField_12.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textField_12.getText().equals("Enter Quantity Here")) {
					textField_12.setText("");
				}
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textField_12.getText().equals("")) {
					textField_12.setText("Enter Quantity Here");
				}
			}
		});
		textField_12.setBounds(0, 36, 172, 20);
		panel_13.add(textField_12);
		textField_12.setColumns(10);

		JLabel lblNewLabel_25 = new JLabel("CUSTOMER DETAIL");
		lblNewLabel_25.setForeground(new Color(0, 0, 0));
		lblNewLabel_25.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_25.setBounds(64, 47, 158, 30);
		panel_5.add(lblNewLabel_25);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 416, 332);
		panel_16.add(scrollPane_1);
		
		table_2 = new JTable();
		model1=new DefaultTableModel();
		Object[] coloumn11= {"ItemName","Price"};
	    Object[] row11=new Object[0];
	    model1.setColumnIdentifiers(coloumn11);
		table_2.setModel(model1);
		table_2.setBackground(Color.LIGHT_GRAY);


		scrollPane_1.setViewportView(table_2);

		JPanel panel_14 = new JPanel();
		panel_14.setBackground(new Color(128, 128, 0));
		panel_14.setForeground(new Color(0, 0, 0));
		panel_14.setBounds(49, 47, 151, 23);
		panel_5.add(panel_14);

		JButton btnNewButton_12 = new JButton("ADD");
		btnNewButton_12.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int select=table_2.getSelectedRowCount();
				if(select!=0) {
				panel_13.setVisible(true);
				textField_5.setText("");
				}
			}
		});
		btnNewButton_12.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton_12.setBounds(327, 339, 89, 23);
		panel_16.add(btnNewButton_12);
		
		textField_11 = new JTextField("Enter Hour");
		textField_11.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textField_11.getText().equals("Enter Hour")) {
					textField_11.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textField_11.getText().equals("")) {
					textField_11.setText("Enter minute");
				}
			}
		});
		textField_11.setBounds(375, 95, 100, 20);
		panel_5.add(textField_11);
		textField_11.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Print Bill");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n=model4.getRowCount();
				String cn=textField_3.getText();
				String cmo=textField_4.getText();
				boolean result=cmo.matches("[0-9]+");
				if(cn.length()>0) {
					if(cmo.length()==10) {
						if(result==true) {
							if(n>0) {
							String cbn="YES";
							String duration=textField_11.getText();
							
							for(int i=0;i<=n-1;i++) {
								String t=(String) model4.getValueAt(i, 3);
								int num=Integer.parseInt(t);
								total+=num;
							}
							print(cn,cmo,cbn,duration);}
							else {
								JOptionPane.showMessageDialog(null,"Add some items first");
							}
						}else {
							JOptionPane.showMessageDialog(null, "Enter valid Mobile no");
							textField_4.setText("");
						}
					}else {
						JOptionPane.showMessageDialog(null, "Enter valid Mobile no");
						textField_4.setText("");
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "Enter Customer name");
				}
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Serif", Font.BOLD, 11));
		btnNewButton_1.setBounds(613, 510, 132, 23);
		panel_5.add(btnNewButton_1);
				 panel_6 = new JPanel();
		panel_6.setBackground(new Color(240, 230, 140));
		layeredPane.add(panel_6, "name_255273742250800");
		panel_6.setLayout(null);

		JLabel lblNewLabel_16 = new JLabel("Customer Details");
		lblNewLabel_16.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblNewLabel_16.setBounds(73, 46, 141, 21);
		panel_6.add(lblNewLabel_16);

		JLabel lblNewLabel_17 = new JLabel("NAME:");
		lblNewLabel_17.setFont(new Font("Serif", Font.BOLD, 12));
		lblNewLabel_17.setBounds(24, 94, 81, 21);
		panel_6.add(lblNewLabel_17);

		textField_6 = new JTextField("Enter Customer Name");
		textField_6.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textField_6.getText().equals("Enter Customer Name")) {
					textField_6.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textField_6.getText().equals("")) {
					textField_6.setText("Enter Customer Name");
				}
			}
		});
		textField_6.setBounds(86, 95, 209, 20);
		panel_6.add(textField_6);
		textField_6.setColumns(10);

		JLabel lblNewLabel_18 = new JLabel("Contact no.");
		lblNewLabel_18.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
		lblNewLabel_18.setBounds(10, 139, 81, 14);
		panel_6.add(lblNewLabel_18);

		textField_7 = new JTextField("Enter Customer Mobile No.");
		textField_7.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textField_7.getText().equals("Enter Customer Mobile No.")) {
					textField_7.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textField_7.getText().equals("")) {
					textField_7.setText("Enter Customer Mobile No.");
				}
			}
		});
		textField_7.setBounds(86, 136, 209, 20);
		panel_6.add(textField_7);
		textField_7.setColumns(10);

		JPanel panel_7 = new JPanel();
		panel_7.setBounds(731, 251, 209, 236);
		panel_6.add(panel_7);

		panel_7.setLayout(null);

		JLabel lblNewLabel_20 = new JLabel("Quantity");
		lblNewLabel_20.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblNewLabel_20.setBounds(10, 11, 121, 22);
		panel_7.add(lblNewLabel_20);

		JButton btnNewButton_19 = new JButton("OK");
		btnNewButton_19.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int n=table_5.getSelectedRow();
				int qn=Integer.parseInt(textField_13.getText());
				String it1=model2.getValueAt(n, 0).toString();
				String it2=model2.getValueAt(n, 1).toString();
				int p=Integer.parseInt(it2);
				int total=qn*p;
			     adder2(it1,it2,qn,total);
			     panel_7.setVisible(false);
			     panel_15.setVisible(false);
			}
		});
		btnNewButton_19.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnNewButton_19.setBounds(23, 202, 89, 23);
		panel_7.add(btnNewButton_19);
		
		textField_13 = new JTextField("Enter Quantity");
		textField_13.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textField_13.getText().equals("Enter Quantity")) {
					textField_13.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textField_13.getText().equals("")) {
					textField_13.setText("Enter Quantity");
				}
			}
		});
		textField_13.setBounds(10, 44, 189, 20);
		panel_7.add(textField_13);
		textField_13.setColumns(10);

		JLabel lblNewLabel_21 = new JLabel("Duration");
		lblNewLabel_21.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblNewLabel_21.setBounds(332, 97, 81, 14);
		panel_6.add(lblNewLabel_21);

		JPanel panel_8 = new JPanel();
		panel_8.setBounds(24, 182, 440, 351);
		panel_6.add(panel_8);
		panel_8.setLayout(null);

		JLabel lblNewLabel_19 = new JLabel("ITEMS PREVIEW");
		lblNewLabel_19.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_19.setBounds(187, 11, 96, 23);
		panel_8.add(lblNewLabel_19);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(10, 50, 420, 231);
		panel_8.add(scrollPane_5);

		table = new JTable();
		model5=new DefaultTableModel();
		Object[] coloumn5= {"ItemName","Price","Quantity","total price"};
	    Object[] row5=new Object[0];
	    model5.setColumnIdentifiers(coloumn5);
		table.setModel(model5);
		table.setBackground(Color.LIGHT_GRAY);

		scrollPane_5.setViewportView(table);

		JButton btnNewButton_16 = new JButton("CLEAR");
		btnNewButton_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count=table.getSelectedRow();
				model5.removeRow(count);
				
			}
		});
		btnNewButton_16.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton_16.setBounds(10, 292, 89, 23);
		panel_8.add(btnNewButton_16);

		JButton btnNewButton_17 = new JButton("RESET");
		btnNewButton_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count=model5.getRowCount();
				for(int i=count-1;i>=0;i--) {
					model5.removeRow(i);
				}
			}
		});
		btnNewButton_17.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton_17.setBounds(341, 292, 89, 23);
		panel_8.add(btnNewButton_17);

		JButton btnNewButton_18 = new JButton("PRINT BILL");
		btnNewButton_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n=model5.getRowCount();
				String cn=textField_6.getText();
				String cmo=textField_7.getText();
				boolean result=cmo.matches("[0-9]+");
				if(cn.length()>0) {
					if(cmo.length()==10) {
						if(result==true) {
							if(n>0) {
							String cbn="YES";
							String duration=textField_9.getText();
							
							for(int i=0;i<=n-1;i++) {
								String t=(String) model5.getValueAt(i, 3);
								int num=Integer.parseInt(t);
								total+=num;
							}
							print(cn,cmo,cbn,duration);}
							else {
								JOptionPane.showMessageDialog(null,"Add some items first");
							}
						}else {
							JOptionPane.showMessageDialog(null, "Enter valid Mobile no");
							textField_7.setText("");
						}
					}else {
						JOptionPane.showMessageDialog(null, "Enter valid Mobile no");
						textField_7.setText("");
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "Enter Customer name");
				}
			}
		});
		btnNewButton_18.setBounds(467, 510, 141, 23);
		panel_6.add(btnNewButton_18);

		JLabel lblNewLabel_22 = new JLabel("ADD ITEMS");
		lblNewLabel_22.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
		lblNewLabel_22.setBounds(890, 98, 72, 14);
		panel_6.add(lblNewLabel_22);

		textField_8 = new JTextField("Search Item Here.....");
		textField_8.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textField_8.getText().equals("Search Item Here.....")) {
					textField_8.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textField_8.getText().equals("")) {
					textField_8.setText("Search Item Here.....");
				}
			}
		});

		textField_8.setBounds(950, 94, 301, 20);
		panel_6.add(textField_8);
		textField_8.setColumns(10);

		JButton btnNewButton_20 = new JButton("SEARCH");
		btnNewButton_20.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					String itm=textField_8.getText().toLowerCase();
	  			int count=model2.getRowCount();
				for(int i=count-1;i>=0;i--) {
					model2.removeRow(i);
				}
	  			String query="select * from item where itemname like '"+itm+"%'";
	  			ResultSet rss=st.executeQuery(query);
	  			ResultSetMetaData rsmd1= rss.getMetaData();
	  			String name,price;
	  			while(rss.next()) {
	  				name=rss.getString(1);
	  				price=rss.getString(3);
	  				String []row12= {name,price};
	  				model2.addRow(row12);
	  				
	  				panel_15.setVisible(true);

	  			}//else {

				
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}

				
			}
		});
		btnNewButton_20.setBounds(1255, 92, 89, 23);
		panel_6.add(btnNewButton_20);

		panel_15 = new JPanel();
		panel_15.setBounds(950, 128, 394, 359);
		panel_6.add(panel_15);
		panel_15.setLayout(null);

		JButton btnNewButton_23 = new JButton("ADD");
		btnNewButton_23.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton_23.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int select =table_5.getRowCount();
				if(select!=0) {
						panel_7.setVisible(true);
				}
			}
		});
		btnNewButton_23.setBounds(305, 336, 89, 23);
		panel_15.add(btnNewButton_23);
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
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 11, 374, 306);
		panel_15.add(scrollPane_2);



		table_5 = new JTable();
		model2=new DefaultTableModel();
		model2=new DefaultTableModel();
		Object[] coloumn111= {"ItemName","Price"};
	    Object[] row111=new Object[0];
	    model2.setColumnIdentifiers(coloumn111);
		table_5.setModel(model2);
		table_5.setBackground(Color.LIGHT_GRAY);



		scrollPane_2.setViewportView(table_5);
		
		textField_9 = new JTextField("Enter hour");
		textField_9.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textField_9.getText().equals("Enter hour")) {
					textField_9.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textField_9.getText().equals("")) {
					textField_9.setText("Enter hour");
				}
			}
		});
		textField_9.setBounds(327, 136, 137, 20);
		panel_6.add(textField_9);
		textField_9.setColumns(10);
		panel_7.setVisible(false);
		panel_10.setVisible(false);
		panel_11.setVisible(true);
		panel_13.setVisible(false);
		panel_16.setVisible(true);
		panel_15.setVisible(true);
	

	}
	public void adder(String it1,String it2,int it3,int id4) {
		String im=it1;
		String ip=it2;
		String tot=String.valueOf(id4);
		String qn=String.valueOf(it3);
		
		String[] r= {im,ip,qn,tot};
		model3.addRow(r);
		
	}
	public void adder1(String it1,String it2,int it3,int total) {
		String im=it1;
		String ip=it2;
		String qn=String.valueOf(it3);
		String t=String.valueOf(total);
		String[] r= {im,ip,qn,t};
		model4.addRow(r);
		
	}
	public void adder2(String it1,String it2,int it3,int total) {
		String im=it1;
		String ip=it2;
		String qn=String.valueOf(it3);
		String t=String.valueOf(total);
		String[] r= {im,ip,qn,t};
		model5.addRow(r);
		
	}
	public void print(String name,String mob,String cab,String dul) {
		String n=name;
		String mo=mob;
		String cb=cab;
		String dura=dul;
		
		new table(n,mo,cb,dura).setVisible(true);
	}
	public void Select(JPanel p) {
		layeredPane.removeAll();
		layeredPane.add(p);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
}
