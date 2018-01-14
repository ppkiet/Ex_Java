package learning.java.PostgreSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

    private Connection conn;

    //netstat -an -P TCP
    public Connection getSQLServerConnection()
            throws SQLException, ClassNotFoundException {
        String hostName = "ec2-54-163-234-4.compute-1.amazonaws.com";
        String database = "derku4jhcvtue9";
        String userName = "gxbmypcqratzce";
        String password = "67fab8ca783471cc6ae1cece8104e17e593268c9852dffb65542a440924399f5";

        return getSQLServerConnection(hostName, database, userName, password);
    }

    public Connection getSQLServerConnection(String hostName, String database, String userName, String password) {
        try {
            Class.forName("org.postgresql.Driver");
            String connectionURL = "jdbc:postgresql://" + hostName + ":5432/" + database + "?sslmode=require";

            conn = DriverManager.getConnection(connectionURL, userName, password);
            System.out.println("thanh cong");
        } catch (Exception e) {
            System.out.println("that bai " + e);
        }
        return conn;
    }
}
