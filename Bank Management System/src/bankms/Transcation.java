package bankms;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Transcation extends JFrame implements ActionListener{

    JLabel l1;
    JButton b1,b2,b3,b4,b7;
    
    public Transcation(){
        
    
        l1 = new JLabel("Please Select Your Transaction");
        l1.setFont(new Font("System", Font.BOLD, 25));
        l1.setBounds(120,10,500,40);
        add(l1);
    
       
        b1 = new JButton("DEPOSIT");
        b1.setFont(new Font("System", Font.BOLD, 18));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(40,100,250,50);
        add(b1);
    
        b2 = new JButton("CASH WITHDRAWL");
        b2.setFont(new Font("System", Font.BOLD, 18));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(300,100,250,50);
        add(b2);
        
        b3 = new JButton("PIN CHANGE");
        b3.setFont(new Font("System", Font.BOLD, 18));
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(40,210,250,50);
        add(b3);
        
        b4 = new JButton("BALANCE ENQUIRY");
        b4.setFont(new Font("System", Font.BOLD, 18));
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.setBounds(300,210,250,50);
        add(b4);
        
       
        
        b7 = new JButton("EXIT");
        b7.setFont(new Font("System", Font.BOLD, 18));
        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.WHITE);
        b7.setBounds(200,450,200,60);
        add(b7);
        
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        
        b7.addActionListener(this);
       
        
        setTitle("Transcation");
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(600,600);
        setLocationRelativeTo(null);
        setVisible(true);
        
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==b1){ 
            
            new Deposite().setVisible(true);
            setVisible(false);
            
        }
        else if(ae.getSource()==b2){ 
            
           new Withdrawl().setVisible(true);
            setVisible(false);
            
        }else if(ae.getSource()==b3){ 
            
            new Pin().setVisible(true);
            setVisible(false);
            
        }else if(ae.getSource()==b4){ 
            
            String pinn = JOptionPane.showInputDialog("Enter PIN"); 
            conn c1 = new conn();
                    
            try {
                
                ResultSet rs = c1.s.executeQuery(" SELECT balance FROM bank ORDER BY pin  = '"+pinn+"' DESC LIMIT 1");
                
                if(rs.next()){
                
                String balance = rs.getString("balance");
                
                JOptionPane.showMessageDialog(null,"Your Account Balance is "+balance);
                
                }
                
                  
                
            } catch (Exception e) {
             
                e.printStackTrace();
            
            }
            
  
                    
            
        }else if(ae.getSource()==b7){ 
            
            System.exit(0);
            
        }
        
            
        
        
    }
    
   
}
