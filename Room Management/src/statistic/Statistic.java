/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistic;

import database.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author William Sentosa
 */
public class Statistic {
    private ArrayList<Integer> numbers;
    private ArrayList<String> labels;
    private Database database;
    
    public Statistic() {
        numbers = new ArrayList<>();
        labels = new ArrayList<>();
        database = new Database();
    }
    
    public ArrayList<Integer> getNumbers() {
        return numbers;
    }

    public ArrayList<String> getLabels() {
        return labels;
    }
    
    public void generateRoomUsageStatistics() {
        database.connect("room-management");
        String sql = "SELECT nama, frequency FROM ruangan NATURAL JOIN ( SELECT count(id_ruangan) AS frequency from peminjaman group by id_ruangan ) AS tabel;";
        ResultSet rs = database.fetchData(sql);
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
    
    public void generateRoomMaintananceStatistics() {
        database.connect("room-management");
        String sql = "SELECT nama, frequency FROM ruangan NATURAL JOIN ( SELECT count(id_ruangan) AS frequency from pemeliharaan group by id_ruangan ) AS tabel;";
        ResultSet rs = database.fetchData(sql);
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
    
    public void generateGroupBookingStatistics() {
        database.connect("room-management");
        String sql = "SELECT nama_lembaga, count(id_ruangan) AS frequency from peminjaman group by id_ruangan;";
        ResultSet rs = database.fetchData(sql);
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
    
}
    
