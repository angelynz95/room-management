/**
 * Aplikasi Room Management
 *
 * @author Irene Wiliudarsan - 13513002
 * @author William Sentosa - 13513026
 * @author Angela Lynn - 13513032
 * @author Devina Ekawati - 13513088
 */
package maintenance;

import database.BorrowingModel;
import database.Database;
import database.MaintenanceModel;
import database.RoomModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import roominformation.RoomInformation;

public class Maintenance {

    private Database database;
    private final String path = "jdbc:mysql://localhost:3306/room_management";
    SimpleDateFormat sdf;
    
    public Maintenance() {
        database = new Database();
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
    
    public MaintenanceModel searchMaintenanceById(int id) {
        MaintenanceModel model = new MaintenanceModel();
        database.connect(path);
        String sql = "SELECT * FROM pemeliharaan WHERE id_pemeliharaan = " + id + ";";
        ResultSet rs = database.fetchData(sql);
        try {
            rs.next();
            model.setId(rs.getInt("id_pemeliharaan"));
            model.setRoomId(rs.getInt("id_ruangan"));
            model.setStartTime(BorrowingModel.convertTimestampToCalendar(rs.getTimestamp("waktu_mulai")));
            model.setFinishTime(BorrowingModel.convertTimestampToCalendar(rs.getTimestamp("waktu_selesai")));
        } catch (SQLException ex) {
            Logger.getLogger(Maintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }
    
    public String addMaintenance(MaintenanceModel maintenance) {
        database.connect(path);
        String message;
        
        RoomInformation roomInformation = new RoomInformation();
        
        String roomStatus = roomInformation.getRoomStatus(maintenance.getRoomId());
        if (roomStatus.equals("Rusak")) {
            String sql = "INSERT INTO pemeliharaan (id_ruangan, deskripsi, waktu_mulai, waktu_selesai) VALUES ('" +
                    maintenance.getRoomId() + "' , '" + maintenance.getDescription() + "' , '" + sdf.format(maintenance.getStartTime().getTime()) +
                    "' , '" + sdf.format(maintenance.getFinishTime().getTime()) + "')";
            message = database.changeData(sql);

            database.closeDatabase();
        } else {
            message = "Maintenance can't be done";
        }
        return message;
    }

    public ArrayList<MaintenanceModel> getClashMaintenance(MaintenanceModel maintenance) {
        ArrayList<MaintenanceModel> clashMaintenance = new ArrayList<>();

        database.connect(path);

        String sql = "SELECT * FROM pemeliharaan WHERE id_pemeliharaan <> " + maintenance.getId() + " AND id_ruangan = '" + maintenance.getRoomId() + "' AND ((waktu_mulai >= '" +
                sdf.format(maintenance.getStartTime().getTime()) + "' AND waktu_mulai <= '" + sdf.format(maintenance.getFinishTime().getTime()) + "') OR (waktu_selesai >= '" +
                sdf.format(maintenance.getStartTime().getTime()) + "' AND waktu_selesai <= '" + sdf.format(maintenance.getFinishTime().getTime()) + "'))";
        
        ResultSet rs = database.fetchData(sql);

        try {
          while(rs.next()) {
              clashMaintenance.add(new MaintenanceModel(rs.getInt("id_pemeliharaan"), rs.getInt("id_ruangan"), rs.getString("deskripsi"), 
                      MaintenanceModel.convertTimestampToCalendar(rs.getTimestamp("waktu_mulai")), MaintenanceModel.convertTimestampToCalendar(rs.getTimestamp("waktu_selesai"))));
          }
        } catch (SQLException ex) {
          Logger.getLogger(Maintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        database.closeDatabase();
        
        return clashMaintenance;
    }
    
    public ArrayList<BorrowingModel> getClashBorrowing(MaintenanceModel maintenance) {
        ArrayList<BorrowingModel> clashBorrowing = new ArrayList<>();

        database.connect(path);

        String sql = "SELECT * FROM peminjaman WHERE id_ruangan = '" + maintenance.getRoomId() + "' AND ((waktu_mulai >= '" +
                sdf.format(maintenance.getStartTime().getTime()) + "' AND waktu_mulai <= '" + sdf.format(maintenance.getFinishTime().getTime()) + "') OR (waktu_selesai >= '" +
                sdf.format(maintenance.getStartTime().getTime()) + "' AND waktu_selesai <= '" + sdf.format(maintenance.getFinishTime().getTime()) + "'))";
        
        ResultSet rs = database.fetchData(sql);

        try {
          while(rs.next()) {
              clashBorrowing.add(new BorrowingModel(rs.getInt("id_peminjaman"), rs.getInt("id_peminjam"), rs.getInt("id_ruangan"), rs.getString("nama_peminjam"),
                      rs.getString("status_peminjam"), rs.getString("alamat_peminjam"), rs.getString("nomor_telepon_peminjam"), rs.getString("nama_lembaga"), rs.getString("nama_kegiatan"), 
                      rs.getInt("jumlah_peserta"), BorrowingModel.convertTimestampToCalendar(rs.getTimestamp("waktu_mulai")), 
                      BorrowingModel.convertTimestampToCalendar(rs.getTimestamp("waktu_selesai"))));
          }
        } catch (SQLException ex) {
          Logger.getLogger(Maintenance.class.getName()).log(Level.SEVERE, null, ex);
        }

        return clashBorrowing;
    }
    
    public String editMaintenance(MaintenanceModel maintenance) {
        database.connect(path);
        
        String sql = "UPDATE pemeliharaan SET id_ruangan = '" + maintenance.getRoomId() + "', deskripsi = '" + 
                maintenance.getDescription() + "', waktu_mulai = '"  + sdf.format(maintenance.getStartTime().getTime()) + "', waktu_selesai = '" + sdf.format(maintenance.getFinishTime().getTime()) + 
                "' WHERE id_pemeliharaan = '" + maintenance.getId() + "'";
        String message = database.changeData(sql);
        
        database.closeDatabase();
        
        return message;
    }
    
    public String deleteMaintenance(MaintenanceModel maintenance) {
        database.connect(path);

        String sql = "DELETE FROM pemeliharaan WHERE id_pemeliharaan = '" + maintenance.getId() + "'";
        String message = database.changeData(sql);
        
        database.closeDatabase();
        
        return message;
    }
    
    public String deleteAllMaintenance() {
        database.connect(path);
        
        String sql = "DELETE FROM pemeliharaan";
        String message = database.changeData(sql);
        
        database.closeDatabase();
        
        return message;
    }
    public static final void main(String args[]) {
        Maintenance maintenance = new Maintenance();
        
        int idMaintenance = 5;
        int roomId = 2;
        String description = "Papan tulis rusak";
        Calendar startTime = new GregorianCalendar(2016, 1, 23, 13, 30);
        Calendar finishTime = new GregorianCalendar(2016, 1, 23, 18, 30);
        
        MaintenanceModel maintenanceModel = new MaintenanceModel(idMaintenance, roomId, description, startTime, finishTime);
        String msg = maintenance.addMaintenance(maintenanceModel);
        System.out.println(msg);
        
        ArrayList<MaintenanceModel> clashMaintenance = new ArrayList<>();
        clashMaintenance = maintenance.getClashMaintenance(maintenanceModel);
        for (int i = 0; i < clashMaintenance.size(); i++) {
            System.out.println(clashMaintenance.get(i).getId());
        }
        
        ArrayList<BorrowingModel> clashBorrowing = new ArrayList<>();
        clashBorrowing = maintenance.getClashBorrowing(maintenanceModel);
        for (int i = 0; i < clashBorrowing.size(); i++) {
            System.out.println(clashBorrowing.get(i).getId());
        }
        
    }
}
