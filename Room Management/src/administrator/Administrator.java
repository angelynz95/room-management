/**
 * Aplikasi Room Management
 * @author Irene Wiliudarsan - 13513002
 * @author William Sentosa - 13513026
 * @author Angela Lynn - 13513032
 * @author Devina Ekawati - 13513088
 */
package administrator;

import database.Database;
import static java.lang.Math.random;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Administrator {
    private final String path = "jdbc:mysql://localhost:3306/room_management";
    private Database database;
    private static final int ITERATIONS = 10000;
    private static final int KEY_LENGTH = 128;
    
    // Konstruktor
    public Administrator() {
        database = new Database();
    }

    // Method
    // Melakukan validasi login
    public boolean validateLogin(String password) {
        database.connect(path);
        String query = "SELECT password, salt FROM pengguna;";
        ResultSet rs = database.fetchData(query);
        try {
            rs.next();
            String dbPassword = rs.getString("password");
            byte[] dbSalt = rs.getString("salt").getBytes();
            database.closeDatabase();
            
            // Hash password masukkan pengguna dengan salt database
            Base64.Encoder enc = Base64.getEncoder();
            String hashedPassword = enc.encodeToString(hashPassword(password, dbSalt));
            
            return authenticate(password, dbPassword, dbSalt);
        } catch(SQLException e) {
            database.closeDatabase();
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    // Menangani pengubahan password
    public void changePassword(String newPassword) {
        database.connect(path);
        
        // Hash password baru dengan salt random
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[8];
        random.nextBytes(salt);
        
        Base64.Encoder enc = Base64.getEncoder();
        String newSalt = enc.encodeToString(salt);
        String newHashedPassword = enc.encodeToString(hashPassword(newPassword, newSalt.getBytes()));
        
        String query = "UPDATE pengguna SET password = '" + newHashedPassword + "', salt = '" + newSalt + "';";
        database.changeData(query);
        database.closeDatabase();
    }
    
    // Enkripsi password
    private byte[] hashPassword(String password, byte[] salt) {
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, ITERATIONS, KEY_LENGTH);
        try {            
            SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            byte[] hash = f.generateSecret(spec).getEncoded();
            
            return hash;
        } catch (InvalidKeySpecException | NoSuchAlgorithmException ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public boolean authenticate(String attemptedPassword, String encryptedPassword, byte[] salt) {
        byte[] hashedAttemptedPassword = hashPassword(attemptedPassword, salt);
        Base64.Encoder enc = Base64.getEncoder();
        
        Arrays.fill(attemptedPassword.toCharArray(), Character.MIN_VALUE);
        if (!enc.encodeToString(hashedAttemptedPassword).equals(encryptedPassword)) return false;
        return true;
    }

    public static void main(String args[]) throws NoSuchAlgorithmException, InvalidKeySpecException {
        Administrator a = new Administrator();
        a.changePassword("admin");
        if (a.validateLogin("admin")) {
            System.out.println("ok");
        } else {
            System.out.println("yah");
        }
        
//        SecureRandom random = new SecureRandom();
//        byte[] salt = new byte[8];
//        random.nextBytes(salt);
//        String hash = a.hashPassword("admin", salt)
//        
//        String userPassword = "admin";
//        Administrator admin = new Administrator();
//        if (admin.validateLogin(userPassword)) {
//            System.out.println("Password valid");
//        } else {
//            System.out.println("Password salah");
//        }
//        
//        String newPassword = "adminlagi";
//        admin.changePassword(newPassword);
//        if (admin.validateLogin(newPassword)) {
//            System.out.println("Penggantian password berhasil");
//        } else {
//            System.out.println("Penggantian password tidak berhasil");
//        }
    }
}
