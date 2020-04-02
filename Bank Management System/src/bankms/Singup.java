package bankms;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class Singup extends JFrame implements ActionListener {

	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
	JTextField f1,f2,f3,f4,f5,f6,f7,f8;
	JComboBox c1,c2;
	JButton btn1;
	
	Random ran = new Random();
	long first4 = (ran.nextLong() % 9000L) + 100L;
	long first = Math.abs(first4);
	
	public Singup() {
		setTitle("Application Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.YELLOW);
		setResizable(false);
		setLayout(null);
		
		l1 = new JLabel("Application Form No." +first);
		l1.setFont(new Font("Serife",Font.BOLD,30));
		l1.setBounds(150,0,450,90);
		add(l1);
		
		l2 = new JLabel("Enter Your Personal Detail");
		l2.setFont(new Font("Serife",Font.BOLD,20));
		l2.setBounds(185,30,300,90);
		add(l2);
		
		l3 = new JLabel("Name:");
		l3.setFont(new Font("Serife",Font.BOLD,15));
		l3.setBounds(80,120,100,20);
		add(l3);
		
		l4 = new JLabel("Father Name:");
		l4.setFont(new Font("Serife",Font.BOLD,15));
		l4.setBounds(80,160,100,20);
		add(l4);
		
		l5 = new JLabel("Date of Brith:");
		l5.setFont(new Font("Serife",Font.BOLD,15));
		l5.setBounds(80,200,100,20);
		add(l5);
		
		l6 = new JLabel("Gender:");
		l6.setFont(new Font("Serife",Font.BOLD,15));
		l6.setBounds(80,240,100,20);
		add(l6);
		
		l7 = new JLabel("Email:");
		l7.setFont(new Font("Serife",Font.BOLD,15));
		l7.setBounds(80,280,100,20);
		add(l7);
		
		l8 = new JLabel("Address:");
		l8.setFont(new Font("Serife",Font.BOLD,15));
		l8.setBounds(80,320,100,20);
		add(l8);
		
		l9 = new JLabel("Marital Status:");
		l9.setFont(new Font("Serife",Font.BOLD,15));
		l9.setBounds(80,360,150,20);
		add(l9);
		
		l10 = new JLabel("Pincode:");
		l10.setFont(new Font("Serife",Font.BOLD,15));
		l10.setBounds(80,400,100,20);
		add(l10);
		
		l11 = new JLabel("City:");
		l11.setFont(new Font("Serife",Font.BOLD,15));
		l11.setBounds(80,440,100,20);
		add(l11);
		
		l12 = new JLabel("State:");
		l12.setFont(new Font("Serife",Font.BOLD,15));
		l12.setBounds(80,480,100,20);
		add(l12);
		
		f1 = new JTextField();
		f1.setBounds(200,120,300,20);
		add(f1);
		
		f2 = new JTextField();
		f2.setBounds(200,160,300,20);
		add(f2);
		
		f3 = new JTextField();
		f3.setBounds(200,200,300,20);
		add(f3);
		
		f4 = new JTextField();
		f4.setBounds(200,280,300,20);
		add(f4);
		
		f5 = new JTextField();
		f5.setBounds(200,320,300,20);
		add(f5);
		
		f6 = new JTextField();
		f6.setBounds(200,400,300,20);
		add(f6);
		
		f7 = new JTextField();
		f7.setBounds(200,440,300,20);
		add(f7);
		
		f8 = new JTextField();
		f8.setBounds(200,480,300,20);
		add(f8);
		
		
		String gender[] = {"Male","Femal", "Other"};
		c1 = new JComboBox(gender);
		c1.setBounds(200,240,300,20);
		add(c1);
		
		String marital[] = {"Married", "Unmarried", "Divorce"};
		c2 = new JComboBox(marital);
		c2.setBounds(200,360,300,20);
		add(c2);
		
		btn1 = new JButton("Submit");
		btn1.setBackground(Color.CYAN);
		btn1.setBounds(400,520,100,30);
		add(btn1);
		
		btn1.addActionListener(this);
		
		setSize(600,600);
		setLocation(350,100);
		setVisible(true);
		
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		
		String name = f1.getText();
		String fname = f2.getText();
		String date = f3.getText();
		String email = f4.getText();
		String address = f5.getText();
		String pincode = f6.getText();
		String city = f7.getText();
		String state = f8.getText();
		
		String gen = (String) c1.getSelectedItem();
		String marital = (String) c2.getSelectedItem();
		
		long first1 = (ran.nextLong() % 90000000L) + 5040936000000000L;
		long first2 = Math.abs(first1);
		
		long first3 = (ran.nextLong() % 9000L) + 1000L;
		long first4 = Math.abs(first3);
				
		try {
			
			if(e.getSource()==btn1) {
				
				if(marital.equals("")) {
					JOptionPane.showMessageDialog(null, "Fill all Detail");
				}
				else {
					double balance = 0;
					conn c = new conn();
					String q = "insert into signup values('"+name+"','"+fname+"','"+date+"','"+gen+"','"+email+"','"+address+"','"+marital+"','"+pincode+"','"+city+"','"+state+"','"+first2+"','"+first4+"')";
					String q2 = "insert into login values('"+email+"','"+first2+"','"+first4+"')";
					String q3 = "insert into bank values('"+email+"','"+first2+"','"+first4+"','"+balance+"')";
					
					c.s.executeUpdate(q);
					c.s.executeUpdate(q2);
					c.s.executeUpdate(q3);
					JOptionPane.showMessageDialog(null, "Card Number"+first2+"\n Pin:"+first4);
					
					new Deposite().setVisible(true);
					setVisible(false);
					
				}
			}
			
			
		} catch (Exception e2) {
			System.out.println(e2);
		}
		
	}

}
