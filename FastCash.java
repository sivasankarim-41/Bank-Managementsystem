/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package javaapplication1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author sivas
 */
public class FastCash extends JFrame implements ActionListener{
    JButton deposit, withdrawal, fastcash,ministatement, pinchange,balanceenquiry, exit;
    String pinnumber;
    FastCash(String pinnumber){
        setLayout(null);
        this.pinnumber=pinnumber;
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("iCONS/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2); 
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("SELECT WITHDRAWAL AMOUNT");
        text.setBounds(200,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,16));
        image.add(text);
        
        
        deposit=new JButton("Rs 100");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawal=new JButton("Rs 500");
        withdrawal.setBounds(355,415,150,30);
        withdrawal.addActionListener(this);
        image.add(withdrawal);
     
        fastcash=new JButton("Rs 1000");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement=new JButton("Rs 2000");
        ministatement.setBounds(355,450,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange=new JButton("Rs 5000");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balanceenquiry=new JButton("Rs 10000");
        balanceenquiry.setBounds(355,485,150,30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
        exit=new JButton("Back");
        exit.setBounds(355,520,150,30);
        image.add(exit);
        
        
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
           setVisible(false);
           new Transaction(pinnumber).setVisible(true);
            
        }
        else{
            String amount=((JButton)ae.getSource()).getText().substring(3);
            conn c=new conn();
            try{
              ResultSet rs=c.s.executeQuery("select * from bank where pin ='"+pinnumber+"'");
              int balance=0;
              while(rs.next()){
                  if(rs.getString("type").equals("Deposit")){
                      
                      balance+=Integer.parseInt(rs.getString("amount"));
                  }
                  else{
                      balance-=Integer.parseInt(rs.getString("amount"));
                  }
                  
              }
              if(ae.getSource()!=exit && balance<Integer.parseInt(amount)){
                  JOptionPane.showMessageDialog(null, "Insufficent Balance");
                  return;
              }
              java.util.Date date = new java.util.Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String ndate = dateFormat.format(date);
              String query="insert into bank values ('"+pinnumber+"', '"+ndate+"','Withdrawal','"+amount+"')";
              c.s.executeUpdate(query);
              JOptionPane.showMessageDialog(null, "Rs"+amount+" Debited Successfully");
              setVisible(false);
              new Transaction(pinnumber).setVisible(true);
            }
            catch(Exception e){
                System.out.println(e);
                
            }            
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        new FastCash("");
        // TODO code application logic here
    }
}

