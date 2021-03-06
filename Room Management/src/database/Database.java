/**
 * Aplikasi Room Management
 * @author Irene Wiliudarsan - 13513002
 * @author William Sentosa - 13513026
 * @author Angela Lynn - 13513032
 * @author Devina Ekawati - 13513088
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    private final String username = "root";
    private final String password = "";
    private Connection conn;
    
    public Database() {
        conn = null;
    }
    
    /**
     * Creating a connection to database
     * @param database database name
     */
    public void connect(String database) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(database, username, password);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    /**
     * Fetching data from database, need a connection to database
     * @param sql input query, like SELECT, etc
     * @return tbe result in ResultSet
     */
    public ResultSet fetchData(String sql) {
        try {
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            ResultSet rs = dbStatement.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }       
    
    /**
     * Change data in database, need a connection.
     * @param sql input query, like INSERT, UPDATE, etc
     * @return 
     */
    public String changeData(String sql) {
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
            return "Change success";
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return "Change failed";
        }
    }
    
    /**
     * Closing the database.
     */
    public void closeDatabase() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            
}
