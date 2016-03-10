import java.sql.*;
import javax.swing.*;

public class sqliteConnection {
    public static void main(String[] args) {

    }
    Connection conn = null;

    public static Connection dbConnector() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:databas.db");
            JOptionPane.showMessageDialog(null, "Conected to Database");
            return conn;
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    try{
        String sql="insert into test (test) value (?)";
        PreparedStatement pst=conn.prepareStatement(sql);
        pst.setString(1, Test.getText());    
    }catch (Exception e){
       e.printStackTrace();
    }
}     
}