import java.sql.*;

     
public class PrintColumns  {

  public static void main(String args[]) {
    
      
    String url = "jdbc:sqlite:databas.db";
    Connection con;
    String query = "select * from medlem";
    Statement stmt;
  
    try {
      Class.forName("org.sqlite.JDBC");
    }

    catch(java.lang.ClassNotFoundException e) {
        System.err.print("ClassNotFoundException: "); 
        System.err.println(e.getMessage());
    }

    try {
      con = DriverManager.getConnection(url);

      stmt = con.createStatement();              
  
      ResultSet rs = stmt.executeQuery(query);
      ResultSetMetaData rsmd = rs.getMetaData();
  
      int numberOfColumns = rsmd.getColumnCount();
  
      for (int i = 1; i <= numberOfColumns; i++) {
        if (i > 1) System.out.print("\t");
        String columnName = rsmd.getColumnName(i);
        System.out.print(columnName);
      }
      System.out.println("\n");

      while (rs.next()) {
        for (int i = 1; i <= numberOfColumns; i++) {
          if (i > 1) System.out.print("\t");
          String columnValue = rs.getString(i);
          System.out.print(columnValue);
        }
        System.out.println("\n");
      }

      stmt.close();
      con.close();
      }

      catch(SQLException ex) {
        System.err.print("SQLException: ");
        System.err.println(ex.getMessage());
    }  
  }
}