/**
 * Aplikasi Room Management
 * @author Irene Wiliudarsan - 13513002
 * @author William Sentosa - 13513026
 * @author Angela Lynn - 13513032
 * @author Devina Ekawati - 13513088
 */
package administrator;

import database.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by User on 2/4/2016.
 */
public class Administrator {
    private final String path = "jdbc:mysql://localhost:3306/room_management";
    private Database database;
    
    // Konstruktor
    public Administrator() {
        database = new Database();
    }

    // Method
    // Melakukan validasi login
    public boolean validateLogin(String password) {
        database.connect(path);
        String query = "SELECT password FROM pengguna;";
        ResultSet rs = database.fetchData(query);
        try {
            rs.next();
            String dbPassword = rs.getString("password");
            database.closeDatabase();
            return (password.compareTo(dbPassword) == 0);
        } catch(SQLException e) {
            database.closeDatabase();
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    // Menangani pengubahan password
    public void changePassword(String newPassword) {
        database.connect(path);
        String query = "UPDATE pengguna SET password = '" + newPassword + "';";
        database.changeData(query);
        database.closeDatabase();
    }
    
}
