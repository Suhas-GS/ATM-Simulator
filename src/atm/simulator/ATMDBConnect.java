package atm.simulator;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;

public class ATMDBConnect {
    String url="jdbc:mysql://localhost:3306/atmsimulatordb";
    String un="root";
    String pwd="root";
    
    Connection con;
    Statement stmt;
            
    public ATMDBConnect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con =  DriverManager.getConnection(url,un,pwd);
            stmt = con.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
