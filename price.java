
	import java.awt.Color;
import java.awt.Component;
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
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import dao.ConnectionProvider;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class price extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JTextField txtEntersearchItems;
	private JTable table;
	private JLayeredPane layeredPane;
	private JPanel panel_3;
	private JPanel panel_4;
	private JTextField textField_1;
	private String name,pass;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPanel panel_7;
	private String inm;
	private Connection cn;
	private Statement st;
	private JPanel panel_5;
	private String ip;
	private JTextField textField_4;
	private String cbp,itm1,itm2;
	private JTextField textField_5;
	private JTable table_1;
	DefaultTableModel model;
	DefaultTableModel model1;
	private JTable table_2;
	private JTextField textField_6;
	private JTextField textField_7;
	private JPanel panel_8;
	private JButton btnNewButton_5;
	private JTextField textField;
	private JTextField textField_8;
	private JButton btnNewButton_8;
	private JPanel panel_9;
	private JLabel lblNewLabel_3,lblNewLabel_1;
	private JButton btnNewButton_4;
	private JButton btnNewButton_13;
	private JLabel lblNewLabel_4;

	/**
	 * Launch the application.
	 */
	//public static void main(String args[]) {
		//EventQueue.invokeLater(new Runnable() {
			//@Override
			//public void run() {
				//try {
					//price frame = new price();
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
	public price(String username) {
		this.name=username;
		
		
		try {
			cn=ConnectionProvider.getConnection();
			st=cn.createStatement();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		//user();
	

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(1360,700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(true);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(169, 169, 169));
		panel.setBounds(0, 0, 1344, 101);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("SET PRICE");
		lblNewLabel.setForeground(new Color(107, 142, 35));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 50));
		lblNewLabel.setBounds(481, 0, 343, 101);
		panel.add(lblNewLabel);
		Image img1= new ImageIcon(this.getClass().getResource("/u.png")).getImage();

		JLabel lblNewLabel_2 = new JLabel("WELCOME");
		lblNewLabel_2.setForeground(new Color(139, 0, 0));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 21));
		lblNewLabel_2.setBounds(10, 0, 146, 39);
		panel.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblNewLabel_3.setBounds(20, 44, 146, 36);
		lblNewLabel_3.setText(name.toUpperCase()+"");
		panel.add(lblNewLabel_3);
		
		 lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(1266, 16, 78, 14);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblNewLabel_4.setBounds(1256, 44, 103, 27);
		panel.add(lblNewLabel_4);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBounds(1240, 0, 104, 74);
		panel.add(panel_10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 163, 90);
		panel.add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(0, 101, 1344, 78);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JButton btnNewButton_3 = new JButton("Table Item Price");
		btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Switch(panel_3);
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_3.setBounds(773, 55, 125, 23);
		panel_2.add(btnNewButton_3);

		JButton btnNewButton_10 = new JButton("ADD ITEMS");
		btnNewButton_10.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent e) {
				Switch(panel_5);
			}
		});
		btnNewButton_10.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_10.setBounds(1103, 55, 113, 23);
		panel_2.add(btnNewButton_10);
		
		btnNewButton_4 = new JButton("Cabin Price");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch(panel_4);
				
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_4.setBounds(938, 55, 125, 23);
		panel_2.add(btnNewButton_4);
		
		btnNewButton_13 = new JButton("EXIT");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_13.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_13.setBounds(1255, 55, 89, 23);
		panel_2.add(btnNewButton_13);

		 layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 184, 1344, 496);
		contentPane.add(layeredPane);
		  model=new DefaultTableModel();
			Object[] coloumn= {"ItemName","Price"};
			Object[] row=new Object[0];
			model.setColumnIdentifiers(coloumn);
		 model1=new DefaultTableModel();
			Object[] coloumn1= {"ItemName","Cabin Price"};
			Object[] row2=new Object[0];
			model1.setColumnIdentifiers(coloumn1);
		
				  panel_3 = new JPanel();
				  panel_3.setBounds(0, 0, 1344, 496);
				  layeredPane.add(panel_3);
				  layeredPane.setLayer(panel_3, 0);
				  panel_3.setBackground(Color.GRAY);
				  panel_3.setLayout(null);
				  
				  		  JScrollPane scrollPane = new JScrollPane();
				  		  scrollPane.setBounds(68, 85, 488, 247);
				  		  panel_3.add(scrollPane);
				  		  
				  		  table_1 = new JTable();
				  		  table_1.addMouseListener(new MouseAdapter() {
				  		  	@Override
				  		  	public void mouseClicked(MouseEvent e) {
				  		  		int select=table_1.getSelectedRow();
				  		  		textField_6.setText(model.getValueAt(select,0).toString());
				  		  		textField_6.setVisible(true);
				  		  		btnNewButton_5.setVisible(true);
				  		  		
				  		  	}
				  		  });
				  		  table_1.setModel(model);
				  		  table_1.setBackground(Color.LIGHT_GRAY);
				  		  scrollPane.setViewportView(table_1);
				  		  JButton btnNewButton_6 = new JButton("SEARCH");
				  		  btnNewButton_6.addActionListener(new ActionListener() {
				  		  	@Override
			public void actionPerformed(ActionEvent e) {
				  		  		try {
				  		  			
				  		  			itm1=textField_5.getText().toLowerCase();
				  		  			int count=model.getRowCount();
					for(int i=count-1;i>=0;i--) {
						model.removeRow(i);
					}
				  		  			String query="select * from item where itemname like '"+itm1+"%'";
				  		  			ResultSet re=st.executeQuery(query);
				  		  			ResultSetMetaData rsmd= re.getMetaData();
				  		  			String name,price;
				  		  			while(re.next()) {
				  		  				name=re.getString(1);
				  		  				price=re.getString(2);
				  		  				String []row1= {name,price};
				  		  				model.addRow(row1);
				  		  				
				  		  				

				  		  			}//else {
				  		  				//JOptionPane.showMessageDialog(null, "Not found,Add this Item");
				  		  			//}
				  		  		}catch(Exception e7) {
				  		  			JOptionPane.showMessageDialog(null, e7);
				  		  		}
				  		  	}
				  		  });
				  		  btnNewButton_6.setBounds(467, 30, 89, 23);
				  		  panel_3.add(btnNewButton_6);
				  		  
				  		  		  textField_5 = new JTextField("Enter Item name");
				  		  		  textField_5.addFocusListener(new FocusAdapter() {
				  		  		  	@Override
				  		  		  	public void focusGained(FocusEvent e) {
				  		  		  		if(textField_5.getText().equals("Enter Item name")) {
				  		  		  			textField_5.setText("");
				  		  		  		}
				  		  		  	}
				  		  		  	@Override
				  		  		  	public void focusLost(FocusEvent e) {
				  		  		  		if(textField_5.getText().equals("")) {
				  		  		  			textField.setText("Enter Item name");
				  		  		  		}
				  		  		  	}
				  		  		  });
				  		  		  textField_5.setBounds(67, 31, 390, 30);
				  		  		  panel_3.add(textField_5);
				  		  		  textField_5.setColumns(10);
				  		  		  
				  		  		  textField_6 = new JTextField();
				  		  		  textField_6.setBounds(653, 83, 287, 20);
				  		  		  panel_3.add(textField_6);
				  		  		  textField_6.setColumns(10);
				  		  		  
				  		  		   btnNewButton_5 = new JButton("Edit");
				  		  		   btnNewButton_5.addActionListener(new ActionListener() {
				  		  		   	public void actionPerformed(ActionEvent e) {
				  		  		   		
				  		  		   		try {
				  		  		   			String itm=textField_6.getText().toLowerCase();
			  		String Query="select *from item where itemname='"+itm+"'";
					ResultSet rs=st.executeQuery(Query);
					if(rs.next()) {
						panel_8.setVisible(true);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				  		  		   	}
				  		  		   });
				  		  		   btnNewButton_5.setBounds(985, 82, 89, 23);
				  		  		   panel_3.add(btnNewButton_5);
				  		  		   
				  		  		    panel_8 = new JPanel();
				  		  		    panel_8.setBounds(653, 114, 419, 121);
				  		  		    panel_3.add(panel_8);
				  		  		    panel_8.setLayout(null);
				  		  		    
				  		  		    textField_7 = new JTextField("Enter new price for above item");
				  		  		    textField_7.addFocusListener(new FocusAdapter() {
				  		  		    	@Override
				  		  		    	public void focusGained(FocusEvent e) {
				  		  		    		if(textField_7.getText().equals("Enter new price for above item")) {
				  		  		    			textField_7.setText("");
				  		  		    		}
				  		  		    		
				  		  		    	}
				  		  		    	@Override
				  		  		    	public void focusLost(FocusEvent e) {
				  		  		    		if(textField_7.getText().equals("")) {
				  		  		    			textField_7.setText("Enter new price for above item");
				  		  		    		}
				  		  		    	}
				  		  		    });
				  		  		    textField_7.setBounds(10, 11, 376, 20);
				  		  		    panel_8.add(textField_7);
				  		  		    textField_7.setColumns(10);
				  		  		    
				  		  		    JButton btnNewButton_11 = new JButton("Update");
				  		  		    btnNewButton_11.addActionListener(new ActionListener() {
				  		  		    	public void actionPerformed(ActionEvent e) {
				  		  		    		try{String name=textField_6.getText();
				  		  		    		int pr=Integer.parseInt(textField_7.getText());
				  		  		    		String query="UPDATE item set price='"+pr+"' where itemname='"+name+"'";
				  		  		    		st.executeUpdate(query);
				  		  		    		JOptionPane.showMessageDialog(null, "Updated");
				  		  		    		panel_8.setVisible(false);
				  		  		    		btnNewButton_5.setVisible(false);
				  		  		    		textField_6.setVisible(false);
				  		  		    		
				  		  		    	
				  		  		    		
				  		  		    		}
				  		  		    		catch(Exception e4) {
				  		  		    			JOptionPane.showMessageDialog(null, e4);
				  		  		    		}
				  		  		    	}
				  		  		    });
				  		  		    btnNewButton_11.setBounds(297, 59, 89, 23);
				  		  		    panel_8.add(btnNewButton_11);
				  		  		    

		 panel_4 = new JPanel();
		 panel_4.setBounds(0, 0, 1344, 496);
		 layeredPane.add(panel_4);
		 layeredPane.setLayer(panel_4, 1);
		 panel_4.setBackground(Color.GRAY);
		 panel_4.setLayout(null);
		 
		 		JButton btnNewButton_7 = new JButton("SEARCH");
		 		btnNewButton_7.addActionListener(new ActionListener() {
		 			@Override
		 			public void actionPerformed(ActionEvent e) {
		 				try{
		 					itm2=textField_1.getText().toLowerCase();
		 					int count=model1.getRowCount();
		 					for(int i=count-1;i>=0;i--) {
		 						model1.removeRow(i);
		 					}

		 				String query="select *from item where itemname like'"+itm2+"%'";
		 				ResultSet rs=st.executeQuery(query);
		 				ResultSetMetaData rsmd1= rs.getMetaData();
	  			String name,price;
	  			while(rs.next()) {
	  				name=rs.getString(1);
	  				price=rs.getString(3);
	  				String []row3= {name,price};
	  				model1.addRow(row3);
	  				
	  				

	  			}//else {
		 					//JOptionPane.showMessageDialog(null, "NotFound");
		 				//}
		 				}
		 				catch(Exception e5) {
		 					JOptionPane.showMessageDialog(null, e5);
		 				}
		 			}
		 		});
		 		btnNewButton_7.setBounds(352, 30, 89, 23);
		 		panel_4.add(btnNewButton_7);
		 		
		 				textField_1 = new JTextField("enter item name");
		 				textField_1.addFocusListener(new FocusAdapter() {
		 					@Override
		 					public void focusGained(FocusEvent e) {
		 						if(textField_1.getText().equals("enter item name")) {
		 							textField_1.setText("");
		 						}
		 					}
		 					@Override
		 					public void focusLost(FocusEvent e) {
		 						if(textField_1.getText().equals("")) {
		 							textField_1.setText("enter item name");
		 						}
		 					}
		 				});
		 				textField_1.setBounds(25, 31, 317, 38);
		 				panel_4.add(textField_1);
		 				textField_1.setColumns(10);
		 				
		 				JScrollPane scrollPane_1 = new JScrollPane();
		 				scrollPane_1.setBounds(25, 94, 424, 238);
		 				panel_4.add(scrollPane_1);
		 				
		 				table_2 = new JTable();
		 				table_2.addMouseListener(new MouseAdapter() {
		 					@Override
		 					public void mouseClicked(MouseEvent e) {
		 						int select=table_2.getSelectedRow();
		 				  		textField.setText(model1.getValueAt(select,0).toString());
		 				  		textField.setVisible(true);
		 				  		btnNewButton_8.setVisible(true);
		 					}
		 				});
		 				table_2.setModel(model1);
		 				table_2.setBackground(Color.LIGHT_GRAY);
		 				
		
		scrollPane_1.setViewportView(table_2);
		
		textField = new JTextField();
		textField.setBounds(481, 92, 283, 20);
		panel_4.add(textField);
		textField.setColumns(10);
		
		 btnNewButton_8 = new JButton("Edit");
		 btnNewButton_8.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {

		  		try {
		  			String itm=textField.getText().toLowerCase();
			  		String Query="select *from item where itemname='"+itm+"'";
					ResultSet rs=st.executeQuery(Query);
					if(rs.next()) {
						panel_9.setVisible(true);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

		 		
		 	}
		 });
		 btnNewButton_8.setBounds(778, 91, 89, 23);
		 panel_4.add(btnNewButton_8);
		 
		  panel_9 = new JPanel();
		  panel_9.setBounds(481, 134, 392, 155);
		  panel_4.add(panel_9);
		  panel_9.setLayout(null);
		  
		  textField_8 = new JTextField("Enter price to be added");
		  textField_8.addFocusListener(new FocusAdapter() {
		  	@Override
		  	public void focusGained(FocusEvent e) {
		  		if(textField_8.getText().equals("Enter price to be added")) {
		  			textField_8.setText("");
		  		}
		  	}
		  	@Override
		  	public void focusLost(FocusEvent e) {
		  		if(textField_8.getText().equals("")) {
		  			textField_8.setText("Enter price to be added");
		  		}
		  	}
		  });
		  textField_8.setBounds(10, 11, 372, 20);
		  panel_9.add(textField_8);
		  textField_8.setColumns(10);
		  
		  JButton btnNewButton_12 = new JButton("Update");
		  btnNewButton_12.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		try{String name=textField.getText();
		  		int pr=Integer.parseInt(textField_8.getText());
		  		String query="UPDATE item set cabinprice='"+pr+"'where itemname='"+name+"'";
		  		st.executeUpdate(query);
		  		JOptionPane.showMessageDialog(null, "Updated");
		  		panel_9.setVisible(false);
		  		btnNewButton_8.setVisible(false);
		  		textField.setVisible(false);
		  		}
		  		catch(Exception e5) {
		  			JOptionPane.showMessageDialog(null, e5);
		  		}
		  	}
		  });
		  btnNewButton_12.setBounds(293, 75, 89, 23);
		  panel_9.add(btnNewButton_12);
		  panel_9.setVisible(false);
		  btnNewButton_8.setVisible(false);
		  textField.setVisible(false);
				  		  		    panel_8.setVisible(false);
				  		  		    textField_6.setVisible(false);
				  		  		    btnNewButton_5.setVisible(false);


		 panel_5 = new JPanel();
		panel_5.setBackground(new Color(192, 192, 192));
		layeredPane.setLayer(panel_5, 0);
		panel_5.setBounds(0, 0, 1344, 485);
		layeredPane.add(panel_5);
		panel_5.setLayout(null);

		JPanel panel_6 = new JPanel();
		panel_6.setBounds(391, 138, 463, 275);
		panel_5.add(panel_6);
		panel_6.setLayout(null);

		JLabel lblNewLabel_8 = new JLabel("Add Item");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_8.setBounds(166, 11, 74, 14);
		panel_6.add(lblNewLabel_8);

		textField_2 = new JTextField("Enter Item name to add");
		textField_2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textField_2.getText().equals("Enter Item name to add")) {
					textField_2.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textField_2.getText().equals("")) {
					textField_2.setText("Enter Item name to add");
				}
			}
		});
		textField_2.setBounds(64, 78, 267, 20);
		panel_6.add(textField_2);
		textField_2.setColumns(10);

		JButton btnNewButton_2 = new JButton("ADD");
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			try{
				inm=textField_2.getText();
				String itnm=inm.toString();
				String query1="select price from item where (itemname='"+itnm+"') ";
				ResultSet rs= st.executeQuery(query1);
				if(rs.next()) {
					JOptionPane.showMessageDialog(null, "Items Already here.");
				}else {
			            panel_7.setVisible(true);
				}

			}catch(Exception e1) {
				JOptionPane.showMessageDialog(null, e1);
			}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(242, 109, 89, 23);
		panel_6.add(btnNewButton_2);

		 panel_7 = new JPanel();
		panel_7.setBounds(64, 147, 267, 85);
		panel_6.add(panel_7);
		panel_7.setLayout(null);

		textField_3 = new JTextField("Enter Price");
		textField_3.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textField_3.getText().equals("Enter Price")) {
					textField_3.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textField_3.getText().equals("")) {
					textField_3.setText("");
				}
			}
		});
		textField_3.setBounds(85, 11, 172, 20);
		panel_7.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("PRICE");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_9.setBounds(10, 14, 46, 14);
		panel_7.add(lblNewLabel_9);

		JButton btnNewButton_9 = new JButton("SUBMIT");
		btnNewButton_9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					ip=textField_3.getText();
					cbp=textField_4.getText();

				inm=textField_2.getText().toLowerCase();
				String qu="insert into item(itemname,price,cabinprice) values('"+inm+"','"+ip+"','"+cbp+"')";
				st.executeUpdate(qu);
				JOptionPane.showMessageDialog(null, "Added in List");
				textField_3.setText("");
				textField_4.setText("");
				textField_2.setText("");
				panel_7.setVisible(false);

				}
				catch(Exception e4) {
					JOptionPane.showMessageDialog(null, e4);

				}

			}
		});
		btnNewButton_9.setBounds(188, 62, 89, 23);
		panel_7.add(btnNewButton_9);

		textField_4 = new JTextField("Enter Cabin Item price");
		textField_4.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textField_4.getText().equals("Enter Cabin Item price")) {
					textField_4.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textField_4.getText().equals("")) {
					textField_4.setText("Enter Cabin Item price");
				}
			}
		});
		textField_4.setBounds(85, 35, 172, 20);
		panel_7.add(textField_4);
		textField_4.setColumns(10);

       panel_7.setVisible(false);
       clock();




	}
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
	public void Switch(JPanel p) {
		layeredPane.removeAll();
		layeredPane.add(p);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	public void user() {
		try {
			String query="select name from log where password='"+pass+"'";
			ResultSet rs=st.executeQuery(query);
			ResultSetMetaData rdms = rs.getMetaData();
			if(rs.next()) {
				String u=rs.getString(1);
				lblNewLabel_3.setText(u);
				
			}
			
		}catch(Exception e1) {
			JOptionPane.showMessageDialog(null, e1);
		}
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


						lblNewLabel_4.setText(""+day+"-"+mon+"-"+year);
						lblNewLabel_1.setText(""+hour+":"+min+":"+sec);
				
					sleep(1000);}
				}catch(InterruptedException e) {
					e.printStackTrace();
					}

			}
		};clock.start();
	}
}