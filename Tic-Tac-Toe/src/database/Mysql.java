
package database;

import database.Dbase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;




public class Mysql {

    public Mysql() {
    }
    

    
    Dbase db =new Dbase();
   // PositionRecorder po = new PositionRecorder();

 
    private boolean checkIfPlayerIsExists(String playerEmail) throws SQLException{
        System.out.println("checkIfPlayerIsExists");
        String query=" select p_id from players where p_email='"+playerEmail+"'";
      
            ResultSet rs = db.stmt.executeQuery(query);
            return rs.next();
        
    }
    
    public void addPlayer(String playerEmail) throws SQLException{
        System.out.println("addPlayer");
        
        if(!checkIfPlayerIsExists(playerEmail)){
            String query="insert into players(p_email,no_of_wins,no_of_losses,no_of_draws) values('"+playerEmail+"',0,0,0);";
            db.stmt.executeUpdate(query);
           // db.con.setAutoCommit(false);
        }
       
    }
    
    public ArrayList<String> getFinalRecord() throws SQLException{
        
        String query="select * from game order by game_id desc limit 1;";
        ResultSet rs=db.stmt.executeQuery(query);
        
        rs.next();
        ArrayList<String> ans=new ArrayList<>();
        for(int i=2;i<=13;++i){
            ans.add(rs.getString(i));
        }
        return ans;
       
    } 
    
  

    public void updatePlayer2win(String player2) throws SQLException {
       
        String query=" update players set no_of_wins=no_of_wins+1 where p_email='"+player2+"'";
        
        int executeUpdate = db.stmt.executeUpdate(query);
        System.out.println(executeUpdate>0?"updated winner executed":"no change is done");
        
    }
    public void updatePlayer2loss(String player2) throws SQLException {
       
        String query=" update players set no_of_losses=no_of_losses+1 where p_email='"+player2+"'";
        
        int executeUpdate = db.stmt.executeUpdate(query);
        System.out.println(executeUpdate>0?"updated winner executed":"no change is done");
        
    }
    public void updatePlayer2draw(String player2) throws SQLException {
       
        String query=" update players set no_of_draws=no_of_draws+1 where p_email='"+player2+"'";
        
        int executeUpdate = db.stmt.executeUpdate(query);
        System.out.println(executeUpdate>0?"updated winner executed":"no change is done");
        
    }
    public boolean insertGame(String player1, String player2, String winner,
            int pos1, int pos2, int pos3, int pos4, int pos5, int pos6, int pos7, int pos8, int pos9) throws SQLException{
            String query="insert into game (player1,player2,winner,pos1,pos2,pos3,pos4,pos5,pos6,pos7,pos8,pos9) " +
"values('"+player1+"','"+player2+"','"+winner+"',"+pos1+","+pos2+","+pos3+","+pos4+","
                    + ""+pos5+","+pos6+","+pos7+","+pos8+","+pos9+");";
            
        int executeUpdate = db.stmt.executeUpdate(query);
            
        return executeUpdate>0;    
    }
    
    
    public ArrayList<ArrayList<String>> showHistory(String player) throws SQLException{
        
        
        String query="select * from game where player1='"+player+"' or player2='"+player+"'; ";
        ResultSet rs=db.stmt.executeQuery(query);
        ArrayList<ArrayList<String>>ans=new ArrayList<>();
        while(rs.next()){
            ArrayList<String>tmp =new ArrayList<>();
            for(int i=2;i<=13;++i){
            tmp.add(rs.getString(i));
        }
            ans.add(tmp);
        }
        return ans;
    }
    
    
//    public void records(int pos1, int pos2, int pos3, int pos4, int pos5, int pos6, int pos7, int pos8, int pos9) {
//       
//        String queryString = new String("select * from game");
//        try {
//            db.rs = db.stmt.executeQuery(queryString);
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        try {
//            db.rs.last();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        String gname="";
//        try {
//            gname = db.rs.getString("game_name");
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        String sql = "INSERT INTO record2(g_name,pos1,pos2,pos3,pos4,pos5,pos6,pos7,pos8,pos9) VALUES ('" + gname + "','" + pos1 + "','" + pos2 + "','" + pos3 + "','" + pos4 + "','" + pos5 + "','" + pos6 + "','" + pos7 + "','" + pos8 + "','" + pos9 + "')";
//        try {
//            db.stmt.executeUpdate(sql);
//        } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//        try {
//            db.con.setAutoCommit(false);
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        if (db.con != null) {
//            try {
//                db.con.close();
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//        }
//        if (db.stmt != null) {
//            try {
//                db.stmt.close();
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//        }
//        if (db.rs != null) {
//            try {
//                db.rs.close();
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//        }
//    }
//
//    public Vector<String> view() {
//        try {
//            Vector<String> allRecords = new Vector<>();
//            
//            String queryString = new String("select * from game");
//            db.rs = db.stmt.executeQuery(queryString);
//            while (db.rs.next()) {
//                String name1 = db.rs.getString("game_name");
//                String winner = db.rs.getString("winner");
//                allRecords.add(name1);
//            }
//            //System.out.println(allRecords.get(0));
//            db.con.setAutoCommit(false);
//            if (db.con != null) {
//                db.con.close();
//            }
//            if (db.stmt != null) {
//                db.stmt.close();
//            }
//            if (db.rs != null) {
//                db.rs.close();
//            }
//            return allRecords;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return null;
//    }
//
//    public PositionRecorder viewRecord() {
//       
//         
//        try {
//            String gname = po.getName();
//            String queryString = new String("select * from record2 Where g_name= '" + gname + "' ");
//            db.rs = db.stmt.executeQuery(queryString);
//            db.rs.first();
//            int pos1 = db.rs.getInt("pos1");
//            int pos2 = db.rs.getInt("pos2");
//            int pos3 = db.rs.getInt("pos3");
//            int pos4 = db.rs.getInt("pos4");
//            int pos5 = db.rs.getInt("pos5");
//            int pos6 = db.rs.getInt("pos6");
//            int pos7 = db.rs.getInt("pos7");
//            int pos8 = db.rs.getInt("pos8");
//            int pos9 = db.rs.getInt("pos9");
//            po = new PositionRecorder(pos1, pos2, pos3, pos4, pos5, pos6, pos7, pos8, pos9);
//            System.out.println(pos1 + pos2 +pos3);
//            db.con.setAutoCommit(false);
//       
//            if (db.con != null) {
//                db.con.rollback();
//                System.out.println("Rollback");
//            }
//        
//            if (db.con != null) {
//                db.con.close();
//            }
//            if (db.stmt != null) {
//                db.stmt.close();
//            }
//            if (db.rs != null) {
//                db.rs.close();
//            }
//            
//            return po;
//        } catch (SQLException ex) {
//            Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
//
//    public Vector<String> viewDate() {
//        try {
//            Vector<String> Records = new Vector<>();
//            
//            
//            
//            String queryString = new String("select * from game");
//            db.rs = db.stmt.executeQuery(queryString);
//            while (db.rs.next()) {
//                String date = db.rs.getString("play_date");
//                Records.add(date);
//            }
//            //System.out.println(Records.get(0));
//            db.con.setAutoCommit(false);
//            
//            if (db.con != null) {
//                db.con.rollback();
//                System.out.println("Rollback");
//            }
//            
//            
//            if (db.con != null) {
//                db.con.close();
//            }
//            
//            if (db.stmt != null) {
//                db.stmt.close();
//            }
//            
//            if (db.rs != null) {
//                db.rs.close();
//            }
//            
//            
//            return Records;
//        } catch (SQLException ex) {
//            Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
    
//      public void insert(String gname, String player1, String player2, String winner) throws SQLException {
//       
//        
//        //String sql = "INSERT INTO game(game_name,player1,"
//          //      + "player2,winner,play_date) VALUES ('" + gname + "','" + player1 + "','" + player2 + "','" + winner + "','" + strDate + "')";
//        //db.stmt.executeUpdate(sql);
//        db.con.setAutoCommit(false);
//        if (db.con != null) {
//            db.con.close();
//        }
//        if (db.stmt != null) {
//            db.stmt.close();
//        }
//        if (db.rs != null) {
//            db.rs.close();
//        }
//    }

}
