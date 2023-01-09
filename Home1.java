import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class Home1 extends JFrame {

	private JPanel contentPane;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel lblNewLabel_1;
	private JPanel panel_4;
	private JPanel panel_5;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Home1 frame = new Home1();
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
	public Home1() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);


		javax.swing.JPanel panel = new javax.swing.JPanel();
		panel.setBounds(0, 0, 773, 388);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("CONTINUE");

		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					btnNewButton.setVisible(false);
					panel_5.setVisible(true);
					lblNewLabel_1.setVisible(true);
					Thread.sleep(800);
					panel_1.setVisible(true);
					panel_3.setVisible(true);
				}catch(Exception e6) {
					JOptionPane.showMessageDialog(null,e6);
				}
			}
		});

		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setForeground(new Color(139, 0, 0));
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		btnNewButton.setBounds(0, 357, 98, 31);
		panel.add(btnNewButton);

		 panel_1 = new JPanel();
		 panel_1.addComponentListener(new ComponentAdapter() {
		 	@Override
		 	public void componentShown(ComponentEvent e) {
		 		try {
					Thread.sleep(800);
					panel_2.setVisible(true);
				}catch(Exception e6) {
					JOptionPane.showMessageDialog(null,e6);
				}
		 	}
		 });
		panel_1.setBackground(new Color(50, 205, 50));
		panel_1.setBounds(0, 366, 245, 22);
		panel.add(panel_1);

		 panel_2 = new JPanel();
		 panel_2.addComponentListener(new ComponentAdapter() {
		 	@Override
		 	public void componentShown(ComponentEvent e) {
		 		try {

					Thread.sleep(900);
					new Login1().setVisible(true);
					setVisible(false);
				}catch(Exception e6) {
					JOptionPane.showMessageDialog(null,e6);
				}
		 	}
		 });
		panel_2.setBackground(new Color(50, 205, 50));
		panel_2.setBounds(245, 366, 269, 22);
		panel.add(panel_2);

		 panel_3 = new JPanel();
		panel_3.setBounds(0, 366, 585, 22);
		panel.add(panel_3);

		 lblNewLabel_1 = new JLabel("Taking you to Login page...");
		 lblNewLabel_1.setForeground(Color.WHITE);
		 lblNewLabel_1.setBackground(new Color(0, 0, 0));
			lblNewLabel_1.setBounds(0, 341, 176, 14);
			panel.add(lblNewLabel_1);



			panel_5 = new JPanel();
			panel_5.setBackground(new Color(250, 250, 210));
			panel_5.setBounds(145, 136, 294, 46);

			panel.add(panel_5);
			panel_5.setLayout(null);

			lblNewLabel_2 = new JLabel("Restaurant Management System");
			lblNewLabel_2.setBackground(new Color(250, 250, 210));
			lblNewLabel_2.setForeground(new Color(255, 215, 0));
			lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
			lblNewLabel_2.setBounds(10, 11, 274, 24);
			panel_5.add(lblNewLabel_2);

		JLabel lblNewLabel = new JLabel("");
		Image img1= new ImageIcon(this.getClass().getResource("/f.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img1));
		lblNewLabel.setBounds(0, 0, 585, 388);
		panel.add(lblNewLabel);





		panel_1.setVisible(false);
		panel_2.setVisible(false);
		panel_3.setVisible(false);
		panel_5.setVisible(false);
		lblNewLabel_1.setVisible(false);



	}
}
