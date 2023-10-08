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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PinChange extends JFrame implements ActionListener{
    
    JPasswordField pin,repin;
    JButton change, back;
    String cardnumber,pinnumber;
    
    
    public PinChange(String cardnumber,String pinnumber) {
        this.pinnumber=pinnumber;
        this.cardnumber=cardnumber;
        
        setLayout(null);
        
        //background
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        //header
        JLabel text = new JLabel("Change Your Pin");
        text.setBounds(300, 250, 700, 35);
        text.setForeground(Color.DARK_GRAY);
        text.setFont(new Font("Calibri",Font.BOLD,20));
        image.add(text);
        
        //new pin
        JLabel pintext = new JLabel("New PIN:");
        pintext.setBounds(230, 320, 400, 20);
        pintext.setForeground(Color.DARK_GRAY);
        pintext.setFont(new Font("Calibri",Font.BOLD,16));
        image.add(pintext);
        
        pin = new JPasswordField();
        pin.setBounds(370, 320, 100, 20);
        pin.setFont(new Font("Calibri",Font.BOLD,16));
        image.add(pin);
        
        //new pin repeat
        JLabel repintext = new JLabel("Re-Enter New PIN:");
        repintext.setBounds(230, 360, 400, 20);
        repintext.setForeground(Color.DARK_GRAY);
        repintext.setFont(new Font("Calibri",Font.BOLD,16));
        image.add(repintext);
        
        repin = new JPasswordField();
        repin.setBounds(370, 360, 100, 20);
        repin.setFont(new Font("Calibri",Font.BOLD,16));
        image.add(repin);
        
        //change button
        change = new JButton("Change");
        change.setBounds(390, 420, 150, 25);
        change.setBackground(Color.DARK_GRAY);
        change.setForeground(Color.WHITE);
        change.addActionListener(this);
        image.add(change);
        
        //back button
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
        new PinChange("","");
    }

    @Override
    public void actionPerformed(ActionEvent e1) {
        if(e1.getSource()==change){
        try{
            String npin = pin.getText();
            String rpin = repin.getText();
            
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }
            
            if(npin.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter new PIN");
                return;
            }
            
            if(rpin.equals("")){
                JOptionPane.showMessageDialog(null, "Please re-enter PIN");
                return;
            }
            
            ATMDBConnect atmdbConnect = new ATMDBConnect();
            String query1="update bank set pin = '"+rpin+"' where card_number = '"+cardnumber+"' and pin = '"+pinnumber+"'";
            String query2="update login set pin = '"+rpin+"' where card_number = '"+cardnumber+"' and pin = '"+pinnumber+"'";
            String query3="update signup2 set pin_number = '"+rpin+"' where card_number = '"+cardnumber+"' and pin_number = '"+pinnumber+"'";
            
            atmdbConnect.stmt.executeUpdate(query1);
            atmdbConnect.stmt.executeUpdate(query2);
            atmdbConnect.stmt.executeUpdate(query3);
            
            JOptionPane.showMessageDialog(null, "PIN changed successfully");
            
            setVisible(false);
            new Transactions(cardnumber,rpin).setVisible(true);
            
            
        }catch(Exception e2){
            e2.printStackTrace();
        }
    }else{
            setVisible(false);
            new Transactions(cardnumber,pinnumber).setVisible(true);
        }
    }
}
