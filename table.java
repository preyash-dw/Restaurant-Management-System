import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.ConnectionProvider;

import java.awt.Color;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class table extends JFrame {

	private JPanel contentPane;
	DefaultTableModel model;
	private JLabel lblNewLabel_16;
	private JPanel panel_1;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_15;
	private String name,contact,set,durat,totall;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_18;
	private JLabel lblNewLabel_19;
	private JLabel lblNewLabel;
	private Connection cn;
	private Statement st;
	
	

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
		//EventQueue.invokeLater(new Runnable() {
			//@Override
			//public void run() {
				//try {
					//table frame = new table();
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
	public table(String cname,String mob,String cabin,String duration) {
		this.name=cname;
		this.contact=mob;
		this.set=cabin;
		this.durat=duration;
		try {
			cn=ConnectionProvider.getConnection();
			st=cn.createStatement();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(803,705);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(true);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(238, 232, 170));
		panel.setBounds(10, 90, 781, 560);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("NAME:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_1.setBounds(24, 11, 77, 36);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblNewLabel_2.setBounds(79, 10, 185, 36);
		lblNewLabel_2.setText(name);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Contact No :");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_3.setBounds(187, 21, 77, 14);
		
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setFont(new Font("Serif", Font.BOLD, 15));
		lblNewLabel_4.setBounds(285, 9, 220, 36);
		lblNewLabel_4.setText(contact);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("BOOKING");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(10, 58, 77, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(79, 58, 65, 14);
		lblNewLabel_6.setText(set);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("DURATION");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setBounds(154, 57, 77, 14);
		panel.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setBounds(254, 57, 92, 14);
		lblNewLabel_8.setText(durat);
		panel.add(lblNewLabel_8);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 93, 629, 219);
		panel.add(scrollPane);
		
		
		/*table = new JTable();
		model=new DefaultTableModel();
		Object[] coloumnee= {"Item name","Quantity","Price of Item"};
		Object[] rowee=new Object[0];
		model.setColumnIdentifiers(coloumnee);
		table.setModel(model);
		table.setBackground(Color.LIGHT_GRAY);*/
		if(Bill1.table==null&&Bill1.table_1==null) {
			scrollPane.setViewportView(Bill1.table_3);
		}else if(Bill1.table==null&&Bill1.table_3==null) {
			scrollPane.setViewportView(Bill1.table_1);
		}else {
			scrollPane.setViewportView(Bill1.table);
		}

	
		
		 panel_1 = new JPanel();
		 panel_1.setBounds(10, 330, 504, 219);
		 panel.add(panel_1);
		 panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("Total Price");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_9.setBounds(232, 0, 91, 46);
		panel_1.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Booking Charge");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_10.setBounds(21, 39, 112, 33);
		panel_1.add(lblNewLabel_10);
		
		
		int tim=Integer.parseInt(lblNewLabel_8.getText());
		int show=0;
		show+=300*tim;
		 

		
		 lblNewLabel_11 = new JLabel("New label");
		 lblNewLabel_11.setText(show+"");
		 lblNewLabel_11.setBounds(180, 40, 143, 33);
		 panel_1.add(lblNewLabel_11);
		 
		 JLabel lblNewLabel_12 = new JLabel("Total Item Price");
		 lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 11));
		 lblNewLabel_12.setBounds(21, 83, 105, 14);
		 panel_1.add(lblNewLabel_12);
		 
		 JLabel lblNewLabel_14 = new JLabel("GST");
		 lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 11));
		 lblNewLabel_14.setBounds(31, 111, 46, 14);
		 panel_1.add(lblNewLabel_14);
		 
		  lblNewLabel_13 = new JLabel("New label");
		  lblNewLabel_13.setText(String.valueOf(Bill1.total)+"");
		  lblNewLabel_13.setBounds(180, 77, 125, 26);
		  panel_1.add(lblNewLabel_13);
		  
		  

			int n=Bill1.total;
			int gs=(int)(n*0.05);
			
		   lblNewLabel_15 = new JLabel("New label");
		   lblNewLabel_15.setBounds(180, 105, 112, 26);
		   lblNewLabel_15.setText(gs+"");
		   panel_1.add(lblNewLabel_15);
		   int sum=n+gs+show;
		   
		    lblNewLabel_16 = new JLabel("New label");
		    lblNewLabel_16.setFont(new Font("Times New Roman", Font.BOLD, 15));
		    lblNewLabel_16.setText(sum+"");
		    lblNewLabel_16.setBounds(164, 142, 219, 32);
		    panel_1.add(lblNewLabel_16);
		    
		    JLabel lblNewLabel_17 = new JLabel("Grand Total");
		    lblNewLabel_17.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 18));
		    lblNewLabel_17.setBounds(10, 142, 131, 33);
		    panel_1.add(lblNewLabel_17);
		    
		    JSeparator separator = new JSeparator();
		    separator.setBounds(0, 136, 502, 2);
		    panel_1.add(separator);
		    
		    JButton btnNewButton = new JButton("PRINT");
		    btnNewButton.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		JOptionPane.showMessageDialog(null, "Bill Generated");
		    		setVisible(false);
		    	}
		    });
		    btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		    btnNewButton.setBounds(413, 196, 89, 23);
		    panel_1.add(btnNewButton);
				
		
		
		
		 lblNewLabel = new JLabel("New label");
		 lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 50));
		lblNewLabel.setBounds(203, 11, 647, 68);
		contentPane.add(lblNewLabel);
		
		 lblNewLabel_18 = new JLabel("New label");
		lblNewLabel_18.setBounds(1259, 0, 85, 23);
		contentPane.add(lblNewLabel_18);
		
		 lblNewLabel_19 = new JLabel("New label");
		lblNewLabel_19.setBounds(1257, 27, 46, 14);
		contentPane.add(lblNewLabel_19);
		
		try {
			String m=Login1.s;
			String query="select *from log where mobileno='"+m+"'";
			ResultSet rs=st.executeQuery(query);
			if(rs.next()) {
				String res=rs.getString(5);
				lblNewLabel.setText(res+"");
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}

		
            clock();
			}
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


					lblNewLabel_19.setText(""+day+"-"+mon+"-"+year);
					lblNewLabel_18.setText(""+hour+":"+min+":"+sec);
					sleep(1000);}
				}catch(Exception e) {
					e.printStackTrace();
					}

			}
		};clock.start();
	}
}
