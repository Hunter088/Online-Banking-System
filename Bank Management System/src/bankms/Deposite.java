package bankms;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Deposite extends JFrame implements ActionListener {
	
	JLabel l1,l2;
	JTextField t1,t2;
	JButton b1,b2;
	
	public Deposite() {
		
		l1 = new JLabel("Enter Pin :");
		l1.setFont(new Font("Arial",Font.BOLD,20));
		l1.setBounds(20, 80, 150,100);
		add(l1);
		
		l2 = new JLabel("Enter Amount :");
		l2.setFont(new Font("Arial",Font.BOLD,20));
		l2.setBounds(20,140,150,100);
		add(l2);
		
		t1 =new JTextField();
		t1.setBounds(170,120,180,30);
		add(t1);
		
		t2 =new JTextField();
		t2.setBounds(170,180,180,30);
		add(t2);
		
		b1 = new JButton("DEPOSITE");
		b1.setFont(new Font("Arial",Font.BOLD,20));
		b1.setForeground(Color.WHITE);
		b1.setBackground(Color.BLACK);
		b1.setBounds(120,260,150,30);
		add(b1);
		b1.addActionListener(this);
		
		b2 = new JButton("EXIT");
		b2.setFont(new Font("Arial",Font.BOLD,20));
		b2.setForeground(Color.WHITE);
		b2.setBackground(Color.BLACK);
		b2.setBounds(120,300,150,30);
		add(b2);
		b2.addActionListener(this);
	
		
		setSize(400,500);
		setTitle("Deposite");
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			
			String a = t1.getText();
			String b = t2.getText();
			
			if(e.getSource()==b1) {
				
				conn c1 = new conn();
                
                
                
                ResultSet rs = c1.s.executeQuery(" select * from bank where pin = '"+a+"' ");
                
                double balance = 0;
                if(rs.next()){
                    String pin = rs.getString("pin");
                    
                    balance = rs.getDouble("balance");
                    
                    double d = Double.parseDouble(b);
                    balance+=d;
                    String q1= "update bank set balance = '"+balance+"' where pin= '"+a+"'";
                
                    c1.s.executeUpdate(q1);
                    
			}
                JOptionPane.showMessageDialog(null, "Rs. "+b+" Deposited Successfully");
                
                new Transcation().setVisible(true);
                setVisible(false);
			}
			
		} catch (Exception e2) {
			System.out.println(e2);
		}
	
		if(e.getSource()==b2) {
			System.exit(0);
		}
	}
}
