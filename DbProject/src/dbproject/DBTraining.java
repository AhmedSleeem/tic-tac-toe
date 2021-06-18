package dbproject;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBTraining {
       Connection con;
      Statement st;
        ResultSet  rs;
    public DBTraining(){
         String url="jdbc:mysql://localhost:3306/company";
        String uname="root";
        String pass="";
       
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
           ex.printStackTrace();
        }
      
        try {
            con = DriverManager.getConnection(url,uname,pass);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
         
        try {
            st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        } catch (SQLException ex) {
            Logger.getLogger(DBTraining.class.getName()).log(Level.SEVERE, null, ex);
        }
        
           try {
               rs= st.executeQuery("select id,Emp_Name,salary from Employee");
           } catch (SQLException ex) {
               ex.printStackTrace();
           }
           
        
    }
    
    
    public boolean processResultSet(int type){
        boolean ans=false;
        //last
        if(type==0){
            if(rs!=null){
                ans=true;
            }
        }
        //next
        else if(type==1){
            try {
               ans= rs.next();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }else if(type==2){try {
            //previous
            ans=rs.previous();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return ans;
        
    }
     public void queeryDB(String query){
           try {
             rs= st.executeQuery(query);
           } catch (SQLException ex) {
               ex.printStackTrace();
           }   
    }
     public int dbInsert(String query){
         int ret=-1;
           try {
               ret=st.executeUpdate(query);
           } catch (SQLException ex) {
               ex.printStackTrace();
           }
         return ret;
     }
    
}
