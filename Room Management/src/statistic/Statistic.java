/**
 * Aplikasi Room Management
 * @author Irene Wiliudarsan - 13513002
 * @author William Sentosa - 13513026
 * @author Angela Lynn - 13513032
 * @author Devina Ekawati - 13513088
 */
package statistic;

import database.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author William Sentosa
 */
public class Statistic {
    /* Atribute */
    private ArrayList<Integer> numbers;
    private ArrayList<String> labels;
    private Database database;
    private final String path = "jdbc:mysql://localhost:3306/room_management";
    
    public Statistic() {
        numbers = new ArrayList<>();
        labels = new ArrayList<>();
        database = new Database();
    }
    
    /**
     * Get numbers which are paired with labels
     * @return all of the numbers
     */
    public ArrayList<Integer> getNumbers() {
        return numbers;
    }
    
    /**
     * Get labels which are paired with numbers
     * @return all of the labels
     */
    public ArrayList<String> getLabels() {
        return labels;
    }
    
    /**
     * Generate room usage statistics consisted of the name of the room as labels and the count of its usage as numbers
     */
    public void generateRoomUsageStatistics() {
        database.connect(path);
        String sql = "SELECT nama, frequency FROM ruangan NATURAL JOIN ( SELECT id_ruangan, count(id_ruangan) AS frequency from peminjaman group by id_ruangan ) AS tabel;";
        ResultSet rs = database.fetchData(sql);
        resetList();
        try {
            while (rs.next()) {
                labels.add(rs.getString("nama"));
                numbers.add(rs.getInt("frequency"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Statistic.class.getName()).log(Level.SEVERE, null, ex);
        }
        database.closeDatabase();
    }
    
    void resetList() {
        numbers = new ArrayList<>();
        labels = new ArrayList<>();
    }
    
    /**
     * Generate room maintenance statistics which consist of the name of the room as labels and the count of its maintenance as numbers 
     */
    public void generateRoomMaintenanceStatistics() {
        database.connect(path);
        String sql = "SELECT nama, frequency FROM ruangan NATURAL JOIN ( SELECT id_ruangan, count(id_ruangan) AS frequency from pemeliharaan group by id_ruangan ) AS tabel;";
        ResultSet rs = database.fetchData(sql);
        resetList();
        try {
            while (rs.next()) {
                labels.add(rs.getString("nama"));
                numbers.add(rs.getInt("frequency"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Statistic.class.getName()).log(Level.SEVERE, null, ex);
        }
        database.closeDatabase();
    }
    
    /**
     * Generate booking statistic of certain groups consisted of the name of the group as labels and the count of booking as the numbers
     */
    public void generateGroupBookingStatistics() {
        database.connect(path);
        String sql = "SELECT nama_lembaga, count(nama_lembaga) AS frequency from peminjaman group by nama_lembaga;";
        ResultSet rs = database.fetchData(sql);
        resetList();
        try {
            while (rs.next()) {
                labels.add(rs.getString("nama_lembaga"));
                numbers.add(rs.getInt("frequency"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Statistic.class.getName()).log(Level.SEVERE, null, ex);
        }
        database.closeDatabase();
    }
    
    public static void main(String args[]) {
        Statistic stat = new Statistic();
        ArrayList<String> labels1, labels2, labels3;
        ArrayList<Integer> numbers1, numbers2, numbers3;
        stat.generateRoomUsageStatistics();
        labels1 = stat.getLabels();
        numbers1 = stat.getNumbers();
        System.out.println("*** Statistik pengunaan ruangan ***");
        for(int i=0; i<labels1.size(); i++) {
            System.out.println(labels1.get(i) + " : " + numbers1.get(i));
        }
        stat.generateRoomMaintenanceStatistics();
        labels2 = stat.getLabels();
        numbers2 = stat.getNumbers();
        System.out.println("*** Statistik pemeliharaan ruangan ***");
        for(int i=0; i<labels2.size(); i++) {
            System.out.println(labels2.get(i) + " : " + numbers2.get(i));
        }
        stat.generateGroupBookingStatistics();
        labels3 = stat.getLabels();
        numbers3 = stat.getNumbers();
        System.out.println("*** Statistik peminjaman ruangan oleh suatu kelompok ***");
        for(int i=0; i<labels3.size(); i++) {
            System.out.println(labels3.get(i) + " : " + numbers3.get(i));
        }
    }
    
}
    
