/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learning.java.PostgreSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class DAO {

    private Connection conn;
    private ResultSet rs;
    private PreparedStatement stmt;

    public void load() {
        // TODO code application logic here
        try {
            Connect c = new Connect();
            conn = c.getSQLServerConnection();

            String query = "select * from public.\"Student\"";
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.print("  " + rs.getString(1));
                System.out.print("  " + rs.getString(2));
                System.out.print("  " + rs.getString(3));
                System.out.println("  " + rs.getString(4));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void Insert(String name, String mark, String major) {
        try {
            Connect a = new Connect();
            conn = a.getSQLServerConnection();
            String sql = "INSERT INTO Student VALUES(?,?,?,?)";
            stmt = conn.prepareStatement(sql);
            //SET
            DAO d = new DAO();

            stmt.setInt(1, d.getID() + 1);
            stmt.setString(2, name);
            stmt.setString(3, mark);
            stmt.setString(4, major);
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int getID() {
        int id = 0;
        try {
            Connect c = new Connect();
            conn = c.getSQLServerConnection();

            String query = "SELECT \"ID\" FROM Student ORDER BY \"ID\" DESC LIMIT 1";
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();
            rs.next();
            id = rs.getInt(1);
        } catch (Exception e) {
            System.out.println(e);
        }
        return id;
    }

    public void Connect() {
        try {
            Connect a = new Connect();
            conn = a.getSQLServerConnection();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public boolean loginUser(String username, String password) {
        try {
            Connect a = new Connect();
            conn = a.getSQLServerConnection();
//            String sql = "Select Username from public.\"User\" where Username like ? and Password like ?";
            String sql = "Select \"Username\" from public.\"User\" WHERE \"Username\" like ? and \"Password\" like ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            rs = stmt.executeQuery();
            return rs.next();
//            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

        public ArrayList<Students> listStudent() {
        try {
            Connect c = new Connect();
            conn = c.getSQLServerConnection();
            String query = "select \"Name\",\"Mark\",\"Major\" from public.\"Student\"";
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();

            ArrayList<Students> list = new ArrayList<>();
            while (rs.next()) {
                Students st = new Students();
                st.setName(rs.getString(1));
                st.setMark(rs.getString(2));
                st.setMajor(rs.getString(3));
                list.add(st);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;

    }
        
    public static void main(String[] args) {
        DAO d = new DAO();
//        d.Connect();
//        d.Insert("name2", "mark2", "major2");
//        d.load();
        System.out.println(d.loginUser("admin", "admin"));
//        System.out.println(d.getID());

//        List<Students> list = d.listStudent();
//        for (Students s : list) {
//            System.out.println(s.getName());
//            System.out.println(s.getMajor());
//            System.out.println(s.getMark());
//            System.out.println("---------------------");
//        }

    }
}
