/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

/**
 *
 * @author sivas
 */
public class MiniStatement extends JFrame implements ActionListener {
    JButton b1, b2;
    JLabel l1;
    String pin;
   
     
    MiniStatement(String pin){
        this.pin=pin;
        
        setTitle("Mini Statement");
        setLayout(null);
        
        
        
        JLabel mini=new JLabel();
        add(mini);
        
        
        
        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);
        
         JLabel balance= new JLabel();
        balance.setBounds(20, 400, 300, 20);
        add(balance);
        
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        
        
        
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from login where pinnumber = '"+pin+"'");
            while (rs.next()) {
             String cardNumber = rs.getString("cardnumber");
             card.setText("Card Number: " + cardNumber.substring(0, 4) + "XXXXXXXX" + cardNumber.substring(12));
             }

        }
        catch(Exception e){
        System.out.println(e);
        }
        	 
        try{
            int bal = 0;
            conn c1  = new conn();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM bank where pin = '"+pin+"'");
            while(rs.next()){
                mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
                
                
                if(rs.getString("type").equals("Deposit")){
                    bal += Integer.parseInt(rs.getString("amount"));
                }else{
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your total Balance is Rs "+bal);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        setLayout(null);
        b1 = new JButton("Exit");
        add(b1);
        
        b1.addActionListener(this);
        
        mini.setBounds(20, 140, 400, 200);
        b1.setBounds(20, 500, 100, 25);
    }
    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
    }
    
    public static void main(String[] args){
        new MiniStatement("904").setVisible(true);
    }
    
}