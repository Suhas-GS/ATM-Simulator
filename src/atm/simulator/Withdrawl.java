package atm.simulator;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Withdrawl extends JFrame implements ActionListener{
    
    JTextField amount;
    JButton withdraw,back;
    String cardnumber,pinnumber;
    
    Withdrawl(String cardnumber,String pinnumber){
        
        this.cardnumber=cardnumber;
        this.pinnumber=pinnumber;
        setLayout(null);
        
        //background
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        //heading
        JLabel text = new JLabel("Enter the amount you want to withdraw");
        text.setBounds(218, 250, 700, 35);
        text.setForeground(Color.DARK_GRAY);
        text.setFont(new Font("Calibri",Font.BOLD,19));
        image.add(text);
        
        //amount
        amount = new JTextField();
        amount.setFont(new Font("Calibri",Font.BOLD,22));
        amount.setBounds(250, 300, 250, 30);
        image.add(amount);
        
        //withdraw
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(390, 420, 150, 25);
        withdraw.setBackground(Color.DARK_GRAY);
        withdraw.setForeground(Color.WHITE);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        //back
        back = new JButton("Back");
        back.setBounds(390, 460, 150, 25);
        back.setBackground(Color.DARK_GRAY);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }


    public static void main(String args[]) {
        new Withdrawl("","");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==withdraw){
            String amt = amount.getText();
            Date date = new Date();
            if(amt.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
            }else{
                ATMDBConnect atmdbConnect = new ATMDBConnect();
                String query = "select balance from login where card_number = '"+cardnumber+"' and pin = '"+pinnumber+"'";
                int amt1 = Integer.parseInt(amt);
                try{
                    ResultSet res = atmdbConnect.stmt.executeQuery(query);
                    res.next();
                    int bal = res.getInt("balance");
                if(amt1 >bal){
                    JOptionPane.showMessageDialog(null, "The account does not have a sufficient balance");
                }else{
                    
                String query1 = "insert into bank values"
                        + "('"+cardnumber+"','"+pinnumber+"','"+date+"','Withdrawl','"+amt+"')";
                String query2= "update login set balance=balance-"+amt+" where card_number = '"+cardnumber+"' and pin = '"+pinnumber+"'";
                try {
                    atmdbConnect.stmt.executeUpdate(query1);
                    atmdbConnect.stmt.executeUpdate(query2);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "Rs. "+amt+" withdraw successfully");
                setVisible(false);
                new Transactions(cardnumber,pinnumber).setVisible(true);
                }
                }catch(Exception e){
                    e.printStackTrace();
                }
                
            }
            
            
        }else if(ae.getSource()==back){
            setVisible(false);
            new Transactions(cardnumber,pinnumber).setVisible(true);
        }
    }
}
