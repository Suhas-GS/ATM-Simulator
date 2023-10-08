package atm.simulator;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class Signup1 extends JFrame implements ActionListener{
    
    int appNo;
    JTextField nameTextField,pnumTextField,emailTextField,addressTextField,cityTextField,
            stateTextField,pincodeTextField;
    JButton next,back;
    JRadioButton male,female,other;
    JDateChooser dateChooser;
    JComboBox<String> occupation;

    public Signup1(){
        
        setLayout(null);
        
        //applicant number
        Random random = new Random();
        appNo = random.nextInt(90000) + 10000;
        
        //background
        ImageIcon I1 = new ImageIcon(ClassLoader.getSystemResource("icons/signupbackground.jpg"));
        Image I2 = I1.getImage().getScaledInstance(750, 700, Image.SCALE_DEFAULT); //image dimension
        ImageIcon I3 = new ImageIcon(I2);
        JLabel backg = new JLabel(I3);
        backg.setBounds(0,0,750,700); //image label dimension
        add(backg);
        
        //header
        JLabel form = new JLabel("APPLICATION FORM");
        form.setFont(new Font("Calibri",Font.BOLD,38));
        form.setForeground(Color.WHITE);
        form.setBounds(200, 20, 600, 40);
        backg.add(form);
        
        //name
        JLabel name = new JLabel("Name");
        name.setFont(new Font("Calibri",Font.BOLD,20));
        name.setForeground(Color.WHITE);
        name.setBounds(70, 90, 100, 30);
        backg.add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Calibri",Font.BOLD,14));
        nameTextField.setBounds(270, 90, 400, 30);
        backg.add(nameTextField);
        
        //pan number
        JLabel pnum = new JLabel("PAN Number");
        pnum.setFont(new Font("Calibri",Font.BOLD,20));
        pnum.setForeground(Color.WHITE);
        pnum.setBounds(70, 140, 200, 30);
        backg.add(pnum);
        
        pnumTextField = new JTextField();
        pnumTextField.setFont(new Font("Calibri",Font.BOLD,14));
        pnumTextField.setBounds(270, 140, 400, 30);
        backg.add(pnumTextField);
        
        //dob
        JLabel dob = new JLabel("Date of Birth");
        dob.setFont(new Font("Calibri",Font.BOLD,20));
        dob.setForeground(Color.WHITE);
        dob.setBounds(70, 190, 200, 30);
        backg.add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(270, 190, 400, 30);
        dateChooser.setForeground(Color.BLACK);
        backg.add(dateChooser);
        
        //gender
        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("Calibri",Font.BOLD,20));
        gender.setForeground(Color.WHITE);
        gender.setBounds(70, 240, 200, 30);
        backg.add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(270, 240, 60, 30);
        backg.add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(420, 240, 100, 30);
        backg.add(female);
        
        other = new JRadioButton("Other");
        other.setBounds(570, 240, 60, 30);
        backg.add(other);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        gendergroup.add(other);
        
        //email
        JLabel email = new JLabel("Email ID");
        email.setFont(new Font("Calibri",Font.BOLD,20));
        email.setForeground(Color.WHITE);
        email.setBounds(70, 290, 200, 30);
        backg.add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Calibri",Font.BOLD,14));
        emailTextField.setBounds(270, 290, 400, 30);
        backg.add(emailTextField);
        
        //occupation
        JLabel occ = new JLabel("Occupation");
        occ.setFont(new Font("Calibri",Font.BOLD,20));
        occ.setForeground(Color.WHITE);
        occ.setBounds(70, 340, 200, 30);
        backg.add(occ);
        
        String[] occupationValues={"Salaried","Self-Employed","Bussiness","Student","Retired","Others"};
        occupation = new JComboBox<>(occupationValues);
        occupation.setFont(new Font("Calibri",Font.BOLD,14));
        occupation.setBounds(270, 340, 400, 30);
        occupation.setBackground(Color.WHITE);
        backg.add(occupation);
        
        
        //address
        JLabel address = new JLabel("Address");
        address.setFont(new Font("Calibri",Font.BOLD,20));
        address.setForeground(Color.WHITE);
        address.setBounds(70, 390, 200, 30);
        backg.add(address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Calibri",Font.BOLD,14));
        addressTextField.setBounds(270, 390, 400, 30);
        backg.add(addressTextField);
        
        //city
        JLabel city = new JLabel("City");
        city.setFont(new Font("Calibri",Font.BOLD,20));
        city.setForeground(Color.WHITE);
        city.setBounds(70, 440, 200, 30);
        backg.add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Calibri",Font.BOLD,14));
        cityTextField.setBounds(270, 440, 400, 30);
        backg.add(cityTextField);
        
        //state
        JLabel state = new JLabel("State");
        state.setFont(new Font("Calibri",Font.BOLD,20));
        state.setForeground(Color.WHITE);
        state.setBounds(70, 490, 200, 30);
        backg.add(state);
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Calibri",Font.BOLD,14));
        stateTextField.setBounds(270, 490, 400, 30);
        backg.add(stateTextField);
        
        //pincode
        JLabel pincode = new JLabel("Pin Code");
        pincode.setFont(new Font("Calibri",Font.BOLD,20));
        pincode.setForeground(Color.WHITE);
        pincode.setBounds(70, 540, 200, 30);
        backg.add(pincode);
        
        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Calibri",Font.BOLD,14));
        pincodeTextField.setBounds(270, 540, 400, 30);
        backg.add(pincodeTextField);
        
        //next button
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Arial",Font.BOLD,14));
        next.setBounds(590, 600, 80, 30);
        next.addActionListener(this);
        backg.add(next);
        
        //back button
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Arial",Font.BOLD,14));
        back.setBounds(490, 600, 80, 30);
        back.addActionListener(this);
        backg.add(back);
        
        
        setSize(750,700);
        setLocation(350, 10);
        setUndecorated(true);
        setVisible(true);
    }

    public static void main(String args[]) {
        new Signup1();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String app_num = "" + appNo;
        String name = nameTextField.getText();
        String pnum = pnumTextField.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected()){
            gender="Male";
        }else if(female.isSelected()){
            gender="Female";
        }else{
            gender="Other";
        }
        
        String email = emailTextField.getText();
        String occupationval = (String)occupation.getSelectedItem();
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pincode = pincodeTextField.getText();
        
        try {
            
            if(e.getSource()==back){
                setVisible(false);
                new Login().setVisible(true);
            }else if(name.equals("") || pnum.equals("") || dob.equals("") || gender.equals(null) || email.equals("") || occupationval.equals("") || address.equals("") || city.equals("") || state.equals("")|| pincode.equals("") ){
                JOptionPane.showMessageDialog(null, "Fill all the details");
            }else if(e.getSource() == next){
                ATMDBConnect atmdbConnect = new ATMDBConnect();
                String query ="insert into signup"
                        + " values('"+app_num+"','"+name+"','"+pnum+"','"+dob+"','"+gender+"','"+email+"','"+occupationval+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
                atmdbConnect.stmt.executeUpdate(query);
                
                //SignUp2 object
                setVisible(false);
                new Signup2(app_num).setVisible(true);
            }
                    
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
