/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package javaapplication1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Deposit extends JFrame implements ActionListener {
    JTextField t1;
    JButton b1,b2;
    String pin;
    Deposit(String pin){

        this.pin=pin;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("ICONS/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        
        JLabel text=new JLabel("Enter the amount you want to deposit");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170,300,400,20);
        image.add(text);
        
         t1 = new JTextField();
         t1.setFont(new Font("Raleway", Font.BOLD, 22));
         t1.setBounds(170,350,320,25);
         image.add(t1);
         
         
          b1 = new JButton("DEPOSIT");
          b1.setBounds(355,485,150,30);
          b1.addActionListener(this);
          image.add(b1);
          
          b2 = new JButton("BACK");
          b2.setBounds(355,520,150,30);
          b2.addActionListener(this);
          image.add(b2);
           
        setSize(900,900);
        setUndecorated(true);
        setLocation(300,0);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        try{
        if(ae.getSource()==b1){
            String amount=t1.getText();
            java.util.Date date = new java.util.Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String ndate = dateFormat.format(date);
            if(amount.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to Deposit");
            }
            else{
                try{
                conn c=new conn();
                String q="insert into bank values('"+pin+"','"+ndate+"','Deposit','"+amount+"')";
                c.s.executeUpdate(q);
                
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Deposited Successfully");
                setVisible(false);
                new Transaction(pin).setVisible(true);
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
        }
        
        else if(ae.getSource()==b2){
            setVisible(false);
            new Transaction(pin).setVisible(true);
        }
        }
        catch(Exception e){
            System.out.println(e);
        }
            
            
        }
        
    

    
    public static void main(String args[]) {
        new Deposit("");
        // TODO code application logic here
    }
}

    
    