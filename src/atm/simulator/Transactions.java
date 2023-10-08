package atm.simulator;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Transactions extends JFrame implements ActionListener{
    
    JButton deposit, withdrawl, fastcash,ministatement,pinchange,balanceenquiry,exit;
    String cardnumber,pinnumber;

    public Transactions(String cardnumber,String pinnumber){
        
        this.cardnumber=cardnumber;
        this.pinnumber=pinnumber;
        setLayout(null);
        
        //background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 800);
        add(image);
         
        //heading
        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(265, 230, 700, 35);
        text.setForeground(Color.DARK_GRAY);
        text.setFont(new Font("Calibri",Font.BOLD,18));
        image.add(text);
        
        //deposit
        deposit = new JButton("Deposit");
        deposit.setBounds(220, 315, 150, 25);
        deposit.setBackground(Color.DARK_GRAY);
        deposit.setForeground(Color.WHITE);
        deposit.addActionListener(this);
        image.add(deposit);
        
        //withdrawl        
        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(390, 315, 150, 25);
        withdrawl.setBackground(Color.DARK_GRAY);
        withdrawl.setForeground(Color.WHITE);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        //pinchange        
        pinchange = new JButton("Pin Change");
        pinchange.setBounds(220, 350, 150, 25);
        pinchange.setBackground(Color.DARK_GRAY);
        pinchange.setForeground(Color.WHITE);
        pinchange.addActionListener(this);
        image.add(pinchange);
           
        //balance
        balanceenquiry = new JButton("Balance Enquiry");
        balanceenquiry.setBounds(390, 350, 150, 25);
        balanceenquiry.setBackground(Color.DARK_GRAY);
        balanceenquiry.setForeground(Color.WHITE);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
          
        //exit
        exit = new JButton("Exit");
        exit.setBounds(390, 400, 150, 25);
        exit.setBackground(Color.DARK_GRAY);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        image.add(exit);
                
   
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
   
    }
    
    

    public static void main(String args[]) {
        new Transactions("","");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            System.exit(0);
        }else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(cardnumber,pinnumber).setVisible(true);
        }else if(ae.getSource()==withdrawl){
            setVisible(false);
            new Withdrawl(cardnumber,pinnumber).setVisible(true);
        }else if(ae.getSource()==pinchange){
            setVisible(false);
            new PinChange(cardnumber,pinnumber).setVisible(true);
        }else if(ae.getSource()==balanceenquiry){
            setVisible(false);
            new BalanceEnquiry(cardnumber,pinnumber).setVisible(true);
        }
    }
}
