/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package javaapplication1;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;


public class Signup3 extends JFrame implements ActionListener{
    
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit, cancel;
    String formno;
    
   
    
    Signup3(String formno){
        this.formno=formno;
        
        setLayout(null);
        JLabel i1=new JLabel("Page 3: Account Details:");
        i1.setFont(new Font("Raleway", Font.BOLD,22));
        i1.setBounds(280,40,400,40);
        add(i1);
        
        
        JLabel type=new JLabel("Account type");
        type.setFont(new Font("Raleway", Font.BOLD,22));
        type.setBounds(100,140,200,30);
        add(type);
        
        r1=new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100,180,150,20);
        add(r1);
        
        r2=new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350,180,300,20);
        add(r2);
        
        r3=new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100,220,150,20);
        add(r3);
        
        r4=new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350,220,300,20);
        add(r4);
        
        
        ButtonGroup b1=new ButtonGroup();
        b1.add(r1);
        b1.add(r2);
        b1.add(r3);
        b1.add(r4);
        
        JLabel card=new JLabel("Card No:");
        card.setFont(new Font("Raleway", Font.BOLD,22));
        card.setBounds(100,300,200,30);
        add(card);
        
        JLabel number=new JLabel("XXXX-XXXX-XXXX-4104");
        number.setFont(new Font("Raleway", Font.BOLD,22));
        number.setBounds(330,300,300,30);
        add(number);
        
        JLabel carddetail =new JLabel("Your 16 Digit Number");
        carddetail.setFont(new Font("Raleway", Font.BOLD,12));
        carddetail.setBounds(100,330,300,20);
        add(carddetail);
        
        
        
        JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD,22));
        pin.setBounds(100,370,200,30);
        add(pin);
        
        JLabel pnumber=new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway", Font.BOLD,22));
        pnumber.setBounds(330,370,300,30);
        add(pnumber);
        
        JLabel pindetail =new JLabel("Your 4 Password");
        pindetail.setFont(new Font("Raleway", Font.BOLD,12));
        pindetail.setBounds(100,400,300,20);
        add(pindetail);
        
        JLabel services =new JLabel("Services Required");
        services.setFont(new Font("Raleway", Font.BOLD,22));
        services.setBounds(100,450,200,30);
        add(services);
        
        c1= new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD,12));
        c1.setBounds(100,500,200,30);
        add(c1);
        
        
        c2= new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD,16));
        c2.setBounds(350,500,200,30);
        add(c2);
        
        c3= new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD,16));
        c3.setBounds(100,550,200,30);
        add(c3);
        
        c4= new JCheckBox("EMAIL & SMS Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD,16));
        c4.setBounds(350,550,200,30);
        add(c4);
        
        c5= new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD,16));
        c5.setBounds(100,600,200,30);
        add(c5);
        
        c6= new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD,16));
        c6.setBounds(350,600,200,30);
        add(c6);
        
        
        c7= new JCheckBox("Here declares that the above entered details are corrrect to the best of my knowledge");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD,16));
        c7.setBounds(100,680,800,30);
        add(c7);
        
        submit=new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD,14));
        submit.setBounds(250,720,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel=new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD,14));
        cancel.addActionListener(this);
        cancel.setBounds(420,720,100,30);
        
        add(cancel);
        
        getContentPane().setBackground(Color.WHITE);
      
        
        setSize(850,820);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
      if(ae.getSource()==submit){
          String accountype=null;
          if(r1.isSelected()){
              accountype="Saving Account";
          }
          else if(r2.isSelected()){
              accountype="Fixed Deposit Account";
              
          }
          else if(r3.isSelected()){
              accountype="Current Account";
              
          }
          else if(r4.isSelected()){
              accountype="Reccuring Deposit Account";
              
          }

          Random random=new Random();
          String cardnumber=""+Math.abs((random.nextLong()%90000000L)+5040936000000000L);
          String Pinnumber = ""+Math.abs((random.nextLong()%9000L)+1000L);
          String facility="";
          if(c1.isSelected()){
              facility=facility+"ATM CARD";
              
          }
          else if(c2.isSelected()){
              facility=facility+"Internet Banking";
              
          }
          else if(c3.isSelected()){
              facility=facility+"Mobile Banking";
              
          }
          else if(c4.isSelected()){
              facility=facility+"EMAIL & SMS Alert";
              
          }
          else if(c5.isSelected()){
              facility=facility+"Cheque Book";
              
          }
          if(c6.isSelected()){
              facility=facility+"E-Statement";
              
          }
          try{
              if(accountype.equals("")){
                  JOptionPane.showMessageDialog(null, "Account type is Required");
              }
              else{
                  conn c=new conn();
                  String q2="insert into signupthree values('"+formno+"','"+accountype+"','"+cardnumber+"','"+Pinnumber+"','"+facility+"')";
                  String q3="insert into login values('"+formno+"','"+cardnumber+"','"+Pinnumber+"')";
                  c.s.executeUpdate(q2);
                  
                  c.s.executeUpdate(q3);
                  JOptionPane.showMessageDialog(null, "Card Number:"+cardnumber+"\n Pin:"+Pinnumber);
                  
                   setVisible(false);
                   new Deposit(Pinnumber).setVisible(false);


                  
                  
                 
                 
              }
          }
          catch(Exception e){
              System.out.println(e);
          }
          
          
          
      }
      else if(ae.getSource()==cancel){
          setVisible(false);
          new Login().setVisible(true);
         
      }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        new Signup3("").setVisible(true);
        // TODO code application logic here
    }
}
