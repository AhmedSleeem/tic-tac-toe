
package database;


import java.sql.*;


public class TableCheck {
    Dbase db=new Dbase();
    DatabaseMetaData dbmd; 
    public TableCheck(){}
    public TableCheck(String tableName) {
        try{
        dbmd = db.con.getMetaData();
        db.rs = dbmd.getTables(null, null, tableName, null);
        if(tableName.equals("players")){
           if(db.rs.next()){
            System.out.println("Table players Exists");
        }else{
            String sql= "create table players (" +
"p_id int primary key auto_increment, " +
"p_email varchar(50) unique not null, " +
"no_of_wins int default 0, " +
"no_of_losses int default 0, " +
"no_of_draws int default 0 " +
");";
            db.stmt.executeUpdate(sql);
        }
        }
        else if(tableName.equals("game")){
        if(db.rs.next()){
            System.out.println("Table game Exists");
        }else{
            String sql= "CREATE TABLE game( " +
" game_id int  primary key AUTO_INCREMENT, " +
" player1 varchar(50) , " +
" player2 varchar(50) , " +
" winner varchar(50) , " +
" pos1 int default NULL,pos2 int default NULL,pos3 int default NULL,pos4 int default NULL,pos5 int default NULL,pos6 int default NULL " +
" ,pos7 int default NULL " +
" ,pos8 int default NULL " +
" ,pos9 int default NULL,  " +
" FOREIGN KEY(player1) REFERENCES players(p_email), " +
" FOREIGN KEY(player2) REFERENCES players(p_email), " +
" FOREIGN KEY(winner) REFERENCES players(p_email) " +
" );";
            db.stmt.executeUpdate(sql);
        }}
             db.con.setAutoCommit(false);
        } catch (SQLException ex) {
            ex.printStackTrace();
            try {
                if (db.con != null) {
                    db.con.rollback();
                    System.out.println("Rollback");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } finally {
            try {
                if (db.con != null) {
                    db.con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            try {
                if (db.stmt != null) {
                    db.stmt.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            try {
                if (db.rs != null) {
                    db.rs.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
