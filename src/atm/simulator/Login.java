package atm.simulator;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {
    
    JButton signin,clear,signup,exit;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    public Login(){
        
        //title
        setTitle("ATM Simulator");
        
        //background
        ImageIcon I1 = new ImageIcon(ClassLoader.getSystemResource("icons/loginbackground.jpg"));
        Image I2 = I1.getImage().getScaledInstance(800, 480, Image.SCALE_DEFAULT); //image dimension
        ImageIcon I3 = new ImageIcon(I2);
        JLabel backg = new JLabel(I3);
        backg.setBounds(0,0,800,480); //image label dimension
        add(backg);
        
        //Header
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Calibri",Font.BOLD,38));
        text.setForeground(Color.WHITE);
        text.setBounds(200, 49, 400, 40);
        backg.add(text);
        
        //Card Number
        JLabel cardno = new JLabel("Card No.");
        cardno.setFont(new Font("Calibri",Font.BOLD,28));
        cardno.setForeground(Color.WHITE);
        cardno.setBounds(50, 150, 150, 30);
        backg.add(cardno);
        
        cardTextField = new JTextField();
        cardTextField.setBounds(180, 150, 230, 30);
        cardTextField.setFont(new Font("Calibri",Font.BOLD,14));
        backg.add(cardTextField);
        
        //PIN
        JLabel pin = new JLabel("PIN");
        pin.setFont(new Font("Calibri",Font.BOLD,28));
        pin.setForeground(Color.WHITE);
        pin.setBounds(50, 220, 250, 30);
        backg.add(pin);
        
        pinTextField = new JPasswordField();
        pinTextField.setBounds(180, 220, 230, 30);
        pinTextField.setFont(new Font("Calibri",Font.BOLD,14));
        backg.add(pinTextField);
        
        //Buttons
        
        //Sign In
        signin = new JButton("Sign In");
        signin.setBounds(180, 300, 100, 30);
        signin.setBackground(Color.BLACK);
        signin.setForeground(Color.lightGray);
        signin.setFont(new Font("Arial",Font.BOLD,12));
        signin.addActionListener(this);
        backg.add(signin);
        
        //Clear
        clear = new JButton("Clear");
        clear.setBounds(310, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.lightGray);
        clear.addActionListener(this);
        clear.setFont(new Font("Arial",Font.BOLD,12));
        backg.add(clear);
        
        //SignUp
        signup = new JButton("Sign Up");
        signup.setBounds(180, 350, 100, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.lightGray);
        signup.addActionListener(this);
        signup.setFont(new Font("Arial",Font.BOLD,12));
        backg.add(signup);
        
        //Exit
        exit = new JButton("Exit");
        exit.setBounds(310, 350, 100, 30);
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.lightGray);
        exit.addActionListener(this);
        exit.setFont(new Font("Arial",Font.BOLD,12));
        backg.add(exit);
        
        setLayout(null);
        setSize(800,480);
        setLocation(270,150);
        setUndecorated(true);
        setVisible(true);
    }
    
    public static void main(String[] args){
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }else if(ae.getSource() == signin){
            ATMDBConnect atmdbConnect = new ATMDBConnect();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * from login where card_number = '"+cardnumber+"' and pin = '"+pinnumber+"'";
            
            try {
                ResultSet rs = atmdbConnect.stmt.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(cardnumber,pinnumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
        }else if(ae.getSource() == signup){
            setVisible(false);
            new Signup1().setVisible(true);
        }else if(ae.getSource() == exit){
            System.exit(0);
        }
    }  
}



