
package database;

import java.sql.*;
import java.util.ArrayList;

public class Dbase {

   public Connection con = null;
   public Statement stmt = null;
   public ResultSet rs = null;
    boolean flag = false;

    public Dbase() {
        
        while (!flag) {
            try {
                ArrayList<String> list = new ArrayList<String>();
                String url = "jdbc:mysql://localhost:3306?&serverTimezone=UTC";
                con = DriverManager.getConnection(url, "root", "root");
                stmt = con.createStatement();
                DatabaseMetaData meta = con.getMetaData();
                String database = "tictactoegame";
                rs = meta.getCatalogs();
                while (rs.next()) {
                    String listofDatabases = rs.getString("TABLE_CAT");
                    list.add(listofDatabases);
                }
                if (list.contains(database)) {
                    System.out.println("Database already exists");
                    url = "jdbc:mysql://localhost:3306/tictactoegame?&serverTimezone=UTC";
                    con = DriverManager.getConnection(url, "root", "root");
                    stmt = con.createStatement();
                    flag = true;
                } else {
                    String hrappSQL = "CREATE DATABASE tictactoegame";
                    stmt.executeUpdate(hrappSQL);
                    url = "jdbc:mysql://localhost:3306/tictactoegame?&serverTimezone=UTC";
                    con = DriverManager.getConnection(url, "root", "root");
                    stmt = con.createStatement();
                    flag = true;
                }
                // System.out.println(list);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
        }
       
    }
}
