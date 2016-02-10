/**
 * Aplikasi Room Management
 *
 * @author Irene Wiliudarsan - 13513002
 * @author William Sentosa - 13513026
 * @author Angela Lynn - 13513032
 * @author Devina Ekawati - 13513088
 */
package maintenance;

import database.Database;
import database.Maintenance;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RoomMaintenance {
  
  public RoomMaintenance() {
    
  }
  
  public String addMaintenance(Maintenance maintenance) {
    Database database = new Database();
    database.connect("room-management");
    
    String sql = "INSERT INTO pemeliharaan (id_ruangan, deskripsi, waktu_mulai, waktu_selesai) VALUES (" +
            maintenance.getRoomId() + " , " + maintenance.getDescription() + " , " + maintenance.getStartTime() +
            " , " + maintenance.getFinishTime() + ")";
    
    return database.changeData(sql);
  }
  
  public ArrayList<Maintenance> getClashMaintenance(Maintenance maintenance) {
    ArrayList<Maintenance> clashMaintenance = new ArrayList<>();
    
    Database database = new Database();
    database.connect("room-management");
    
    String sql = "SELECT * FROM pemeliharaan WHERE id_ruangan = " + maintenance.getRoomId() + " AND ((waktu_mulai >= " + 
            maintenance.getStartTime() + " AND waktu_mulai <= " + maintenance.getFinishTime() + ") OR (waktu_selesai >= " +
            maintenance.getStartTime() + " AND waktu_selesai <= " + maintenance.getFinishTime();
    
    ResultSet rs = database.fetchData(sql);
    
    try {
      while(rs.next()) {
        clashMaintenance.add(new Maintenance(rs.getInt("id_pemeliharaan"), rs.getInt("id_ruangan"), rs.getString("deskripsi"), rs.getTimestamp("waktu_mulai"), rs.getTimestamp("waktu_selesai")));
      }
    } catch (SQLException ex) {
      Logger.getLogger(RoomMaintenance.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return clashMaintenance;
  }
  
  public String deleteBooking(Maintenance maintenance) {
    Database database = new Database();
    database.connect("room-management");
    
    String sql = "DELETE FROM peminjaman WHERE id_peminjaman = " + maintenance.getId();
    
    return database.changeData(sql);
  }
}
