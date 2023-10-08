package atm.simulator;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class Signup2 extends JFrame implements ActionListener{
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String app_num;

    public Signup2(String app_num) {
        this.app_num = app_num;
        setLayout(null);
        
        //background
        ImageIcon I1 = new ImageIcon(ClassLoader.getSystemResource("icons/signupbackground.jpg"));
        Image I2 = I1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT); //image dimension
        ImageIcon I3 = new ImageIcon(I2);
        JLabel backg = new JLabel(I3);
        backg.setBounds(0,0,700,700); //image label dimension
        add(backg);
        
        //Header
        JLabel l1 = new JLabel("Account Details");
        l1.setFont(new Font("Calibri",Font.BOLD,26));
        l1.setForeground(Color.WHITE);
        l1.setBounds(250, 15, 400, 40);
        backg.add(l1);
        
        //acc type
        JLabel type= new JLabel("Account Type");
        type.setFont(new Font("Calibri",Font.BOLD,22));
        type.setForeground(Color.WHITE);
        type.setBounds(100, 80, 200, 30);
        backg.add(type);
        
        r1 = new JRadioButton("Savings Account");
        r1.setFont(new Font("Calibri",Font.BOLD,16));
        r1.setForeground(Color.LIGHT_GRAY);
        r1.setBackground(Color.BLACK);
        r1.setBounds(100,130,150,20);
        backg.add(r1);
        
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Calibri",Font.BOLD,16));
        r2.setForeground(Color.LIGHT_GRAY);
        r2.setBackground(Color.BLACK);
        r2.setBounds(350,130,190,20);
        backg.add(r2);
        
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Calibri",Font.BOLD,16));
        r3.setForeground(Color.LIGHT_GRAY);
        r3.setBackground(Color.BLACK);
        r3.setBounds(100,170,150,20);
        backg.add(r3);
        
        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Calibri",Font.BOLD,16));
        r4.setForeground(Color.LIGHT_GRAY);
        r4.setBackground(Color.black);
        r4.setBounds(350,170,215,20);
        backg.add(r4);
        
        ButtonGroup groupacc = new ButtonGroup();
        groupacc.add(r1);
        groupacc.add(r2);
        groupacc.add(r3);
        groupacc.add(r4);
        
        //Card number
        JLabel card = new JLabel("Card Number");
        card.setFont(new Font("Calibri",Font.BOLD,22));
        card.setForeground(Color.WHITE);
        card.setBounds(100, 240, 200, 30);
        backg.add(card);
        
        JLabel cnum = new JLabel("XXXXX");
        cnum.setFont(new Font("Calibri",Font.BOLD,22));
        cnum.setForeground(Color.WHITE);
        cnum.setBounds(330, 240, 300, 30);
        backg.add(cnum);
        
        JLabel carddetail = new JLabel("Your 5 digit card number");
        carddetail.setFont(new Font("Calibri",Font.BOLD,12));
        carddetail.setForeground(Color.WHITE);
        carddetail.setBounds(100, 265, 300, 20);
        backg.add(carddetail);
        
        //Pin
        JLabel pin = new JLabel("PIN");
        pin.setFont(new Font("Calibri",Font.BOLD,22));
        pin.setForeground(Color.WHITE);
        pin.setBounds(100, 300, 200, 30);
        backg.add(pin);
        
        JLabel pnum = new JLabel("XXX");
        pnum.setFont(new Font("Calibri",Font.BOLD,22));
        pnum.setForeground(Color.WHITE);
        pnum.setBounds(330, 300, 300, 30);
        backg.add(pnum);
        
        JLabel pindetail = new JLabel("Your 3 digit pin number");
        pindetail.setFont(new Font("Calibri",Font.BOLD,12));
        pindetail.setForeground(Color.WHITE);
        pindetail.setBounds(100, 325, 300, 20);
        backg.add(pindetail);
        
        //services
        JLabel services = new JLabel("Services Required");
        services.setFont(new Font("Calibri",Font.BOLD,22));
        services.setForeground(Color.WHITE);
        services.setBounds(100, 380, 400, 30);
        backg.add(services);
        
        c1 = new JCheckBox("ATM Card");
        c1.setFont(new Font("Calibri",Font.BOLD,16));
        c1.setForeground(Color.LIGHT_GRAY);
        c1.setBackground(Color.black);
        c1.setBounds(100, 420, 200, 30);
        backg.add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setFont(new Font("Calibri",Font.BOLD,16));
        c2.setForeground(Color.LIGHT_GRAY);
        c2.setBackground(Color.black);
        c2.setBounds(350, 420, 200, 30);
        backg.add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Calibri",Font.BOLD,16));
        c3.setForeground(Color.LIGHT_GRAY);
        c3.setBackground(Color.black);
        c3.setBounds(100, 460, 200, 30);
        backg.add(c3);
        
        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setFont(new Font("Calibri",Font.BOLD,16));
        c4.setForeground(Color.LIGHT_GRAY);
        c4.setBackground(Color.black);
        c4.setBounds(350, 460, 200, 30);
        backg.add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setFont(new Font("Calibri",Font.BOLD,16));
        c5.setForeground(Color.LIGHT_GRAY);
        c5.setBackground(Color.black);
        c5.setBounds(100, 500, 200, 30);
        backg.add(c5);
        
        c6 = new JCheckBox("E-Statement");
        c6.setFont(new Font("Calibri",Font.BOLD,16));
        c6.setForeground(Color.LIGHT_GRAY);
        c6.setBackground(Color.black);
        c6.setBounds(350, 500, 200, 30);
        backg.add(c6);
        
        //declaration
        c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge");
        c7.setFont(new Font("Calibri",Font.BOLD,12));
        c7.setForeground(Color.LIGHT_GRAY);
        c7.setBackground(Color.black);
        c7.setBounds(100, 550, 460, 30);
        backg.add(c7);
        
        //buttons
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.lightGray);
        submit.setFont(new Font("Arial",Font.BOLD,14));
        submit.setBounds(200, 600, 100, 30);
        submit.addActionListener(this);
        backg.add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.lightGray);
        cancel.setFont(new Font("Arial",Font.BOLD,14));
        cancel.setBounds(370, 600, 100, 30);
        cancel.addActionListener(this);
        backg.add(cancel);
        

        setSize(700,700);
        setLocation(300,25);
        setUndecorated(true);
        setVisible(true);
        
    }

    public static void main(String args[]) {
       new Signup2("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==submit){
           String accountType=null;
           if(r1.isSelected()){
               accountType="Saving Account";
           }else if(r2.isSelected()){
               accountType="Fixed Deposit Account";
           }else if(r3.isSelected()){
               accountType="Current Account";
           }else if(r4.isSelected()){
               accountType="Recurring Account";
           }
           
           String cardnumber = ""+app_num;
           Random random = new Random();
           int n = random.nextInt(900)+100;
           String pinnumber = ""+n;
           
           String facility ="";
           if(c1.isSelected()){
               facility = facility+"ATM Card";
           }
           if(c2.isSelected()){
               facility = facility+"Internet Banking";
           }
           if(c3.isSelected()){
               facility = facility+"Mobile Banking";
           }
           if(c4.isSelected()){
               facility = facility+"EMAIL & SMS Alerts";
           }
           if(c5.isSelected()){
               facility = facility+"Cheque Book";
           }
           if(c6.isSelected()){
               facility = facility+"E-Statement";
           }
           
           try{
               if(accountType.equals("")){
                   JOptionPane.showMessageDialog(null, "Account Type is Required");
               }else{
                   ATMDBConnect atmdbConnect = new ATMDBConnect();
                   String query1 = "insert into signup2 values"
                           + "('"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                   String query2 = "insert into login(card_number,pin) values"
                           + "('"+cardnumber+"','"+pinnumber+"')";
                   atmdbConnect.stmt.executeUpdate(query1);
                   atmdbConnect.stmt.executeUpdate(query2);
                   
                   JOptionPane.showMessageDialog(null, "Card Number: "+cardnumber+"\n Pin: "+pinnumber);
                   
                   setVisible(false);
                   new Deposit(cardnumber,pinnumber).setVisible(true);
                   
               }
           }catch(Exception e2){
               e2.printStackTrace();
           }
           
       }else if(e.getSource()==cancel){
           setVisible(false);
           new Login().setVisible(true);
       }
    }
}
