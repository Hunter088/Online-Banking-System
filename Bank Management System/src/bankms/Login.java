package bankms;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;

public class Login extends JFrame implements ActionListener {

	JLabel l1,l2,l3;
	JTextField tf;
	JButton btn1, btn3;
	JPasswordField pf;
	
	public Login() {
		
		setTitle("Bank Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(65, 105, 225));
		setResizable(false);
		setLayout(null);
		setSize(500,300);
		
		lables();
		
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	public void lables() {

		l1 = new JLabel("Welcome to Online Banking");
		l1.setFont(new Font("Arial",Font.BOLD,25));
		l1.setBounds(80, 20, 400, 50);
		add(l1);
		
		l2 = new JLabel("Enter Email:");
		l2.setFont(new Font("serief",Font.BOLD,20));
		l2.setBounds(80, 100, 150, 20);
		add(l2);
		
		l3 = new JLabel("Enter Pin:");
		l3.setFont(new Font("serief",Font.BOLD,20));
		l3.setBounds(80, 150, 150, 20);
		add(l3);
		
		tf = new JTextField(15);
		tf.setBounds(250, 100, 150, 20);
		add(tf);
		
		pf = new JPasswordField(15);
		pf.setBounds(250, 150, 150, 20);
		add(pf);
		
		btn1 = new JButton("LOGIN");
		btn1.setBackground(Color.CYAN);
		btn1.setForeground(Color.BLACK);
		btn1.setBounds(190,200,90,30);
		add(btn1);
		
		
		btn3 = new JButton("SING UP");
		btn3.setBackground(Color.CYAN);
		btn3.setForeground(Color.BLACK);
		btn3.setBounds(290,200,90,30);
		add(btn3);
		
		btn1.addActionListener(this);
		
		btn3.addActionListener(this);
		
		
	}


	public void actionPerformed(ActionEvent e) {
		
		try {
			
			conn con = new conn();
			String a = tf.getText();
			String b = pf.getText();
			String q = "select * from login where E_mail = '"+a+"' and pin = '"+b+"'";
			
			ResultSet rs = con.s.executeQuery(q);
			
			if(e.getSource()==btn1) {
				if(rs.next()) {
					new Transcation();
					setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null, "Incorrect Password or Email");
				}
			}
			if(e.getSource() == btn3) {
				new Singup().setVisible(true);
				setVisible(false);
			}
			
			
		} catch (Exception e2) {
			System.out.println(e2);
		}
		
	}
	


public static void main(String args[]) {
	Login log = new Login();
	
}
}