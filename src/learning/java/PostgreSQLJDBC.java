/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learning.java;

/**
 *
 * @author PC
 */
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.Properties;
 

//public class JdbcPostgresqlConnection {
// 
//    public static void main(String[] args) {
//        // create three connections to three different databases on localhost
//        Connection conn1 = null;
//        Connection conn2 = null;
//        Connection conn3 = null;
// 
//        try {
//            // Connect method #1
//            String dbURL1 = "jdbc:postgresql:INF205?user=root&password=ppkiet123";
//            conn1 = DriverManager.getConnection(dbURL1);
//            if (conn1 != null) {
//                System.out.println("Connected to database #1");
//            }
// 
//            // Connect method #2
//            String dbURL2 = "jdbc:postgresql://localhost/INF205";
//            String user = "root";
//            String pass = "ppkiet123";
// 
//            conn2 = DriverManager.getConnection(dbURL2, user, pass);
//            if (conn2 != null) {
//                System.out.println("Connected to database #2");
//            }
// 
//            // Connect method #3
//            String dbURL3 = "jdbc:postgresql://localhost:5432/INF205";
//            Properties parameters = new Properties();
//            parameters.put("user", "root");
//            parameters.put("password", "ppkiet123");
// 
//            conn3 = DriverManager.getConnection(dbURL3, parameters);
//            if (conn3 != null) {
//                System.out.println("Connected to database #3");
//            }
// 
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } finally {
//            try {
//                if (conn1 != null && !conn1.isClosed()) {
//                    conn1.close();
//                }
//                if (conn2 != null && !conn2.isClosed()) {
//                    conn2.close();
//                }
//                if (conn3 != null && !conn3.isClosed()) {
//                    conn3.close();
//                }
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//        }
//    }
//}
//////////////////////////////////////////////////////////////////////////////
//import java.sql.Connection;
//import java.sql.DriverManager;
//
//public class PostgreSQLJDBC {
//   public static void main(String args[]) {
//      Connection c = null;
//      try {
//         Class_.forName("org.postgresql.Driver");
//         c = DriverManager
//            .getConnection("jdbc:postgresql://localhost:5432/INF205",
//            "root", "ppkiet123");
//      } catch (Exception e) {
//         e.printStackTrace();
//         System.err.println(e.getClass().getName()+": "+e.getMessage());
//         System.exit(0);
//      }
//      System.out.println("Opened database successfully");
//   }
//}

/////////////////////////////////////////////////////////////////////////////////
import java.sql.*;
/**
 *
 * @author shankar
 */
public class PostgreSQLJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
          System.out.println("——– PostgreSQL JDBC Connection Testing ————");

      try {
        Class.forName("org.postgresql.Driver");
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
             conn = DriverManager.getConnection("jdbc:postgresql://localhost/INF205","postgres","ppkiet123");
       if (conn != null)
          {
                
        

                  String query="select * from demo";
                  stmt = conn.prepareStatement(query);
                  rs = stmt.executeQuery();
                  while(rs.next())
                  {
                      System.out.print("  "+rs.getString(1));
                      System.out.print("  "+rs.getString(2));
                      System.out.print("  "+rs.getString(3));
                      System.out.println("  "+rs.getString(4));
                  }
                

          }
          else
              System.out.println("Connection Failed!");
      }
          catch(Exception e){
                              e.printStackTrace();
          }
    
    }
}

