import database.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by User on 2/4/2016.
 */
public class Administrator {
    // Method
    // Konstruktor
    public Administrator() {
    }

    // Melakukan validasi login
    private String validateLogin(String password) {
        Database database = new Database();
        database.connect("room-management");
        String query = "SELECT password FROM pengguna;";
        ResultSet rs = database.fetchData(query);
        try {
            String dbPassword = rs.getString("password");
            database.closeDatabase();

            String message;
            if (password.equals(dbPassword)) {
                message = "You have successfully login";
            } else {
                message = "Sorry, your password is not matched";
            }
            return message;
        } catch(SQLException ex) {
            database.closeDatabase();
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    // Menangani pengubahan password
    private void changePassword(String newPassword) {
        Database database = new Database();
        database.connect("room-management");
        String query = "UPDATE pengguna SET password = " + newPassword + ";";
        database.changeData(query);
        database.closeDatabase();
    }
}
