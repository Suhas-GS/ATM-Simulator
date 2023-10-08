package atm.simulator;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BalanceEnquiry extends JFrame implements ActionListener{
    
    JButton back;
    String cardnumber,pinnumber;

    public BalanceEnquiry(String cardnumber,String pinnumber) {
        this.cardnumber=cardnumber;
        this.pinnumber=pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        back = new JButton("Back");
        back.setBounds(390, 460, 150, 25);
        back.setBackground(Color.DARK_GRAY);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        image.add(back);
        
        ATMDBConnect atmdbConnect = new ATMDBConnect();
        int bal=0; 
        try {
            
            String query="select * from login where card_number = '"+cardnumber+"' and pin = '"+pinnumber+"'";
            ResultSet res = atmdbConnect.stmt.executeQuery(query);
            res.next();
            
            bal = res.getInt("balance");            
            
            
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        
        JLabel text = new JLabel("Your current balance is:");
        text.setBounds(235, 300, 700, 25);
        text.setForeground(Color.DARK_GRAY);
        text.setFont(new Font("Calibri",Font.BOLD,25));
        image.add(text);
        
        JLabel text1 = new JLabel("Rs."+bal);
        text1.setBounds(235, 330, 700, 25);
        text1.setForeground(Color.DARK_GRAY);
        text1.setFont(new Font("Calibri",Font.BOLD,25));
        image.add(text1);
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public static void main(String args[]) {
        new BalanceEnquiry("","");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Transactions(cardnumber,pinnumber).setVisible(true); 
    }
}
