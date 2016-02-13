/**
 * Aplikasi Room Management
 *
 * @author Irene Wiliudarsan - 13513002
 * @author William Sentosa - 13513026
 * @author Angela Lynn - 13513032
 * @author Devina Ekawati - 13513088
 */
package borrowing;


import database.BorrowingModel;
import database.Database;
import database.MaintenanceModel;
import java.util.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Borrowing {
  
    private Database database;
    private final String path = "jdbc:mysql://localhost:3306/room_management";
    SimpleDateFormat sdf;
    
    public Borrowing() {
        database = new Database();
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public String addBorrowing(BorrowingModel borrowing) {
        database.connect(path);

        String sql = "INSERT INTO peminjaman (id_ruangan, id_peminjam, nama_peminjam, nomor_telepon_peminjam, "
                + "status_peminjam, alamat_peminjam, nama_kegiatan, nama_lembaga, waktu_mulai, waktu_selesai, jumlah_peserta)"
                + " VALUES ('" + borrowing.getRoomId() + "', '" + borrowing.getBorrowerId() + "','" + borrowing.getBorrowerName() + "','" + borrowing.getBorrowerPhone() + "','" 
                + borrowing.getBorrowerStatus() + "','" + borrowing.getBorrowerAddress() + "','" + borrowing.getActivityName() + "','" + borrowing.getOrganizationName() + "', '"
                + sdf.format(borrowing.getStartTime().getTime()) + "','" + sdf.format(borrowing.getFinishTime().getTime()) + "','" + borrowing.getTotalParticipant() + "')";
        String message = database.changeData(sql);
        
        database.closeDatabase();
        
        return message;
    }

    public String editBorrowing(BorrowingModel borrowing) {
        database.connect(path);

        String sql = "UPDATE peminjaman SET id_ruangan = '" + borrowing.getId() + "', id_peminjam = '" + borrowing.getBorrowerId()
                + "', nama_peminjam = '" + borrowing.getBorrowerName() + "', nomor_telepon_peminjam = '" + borrowing.getBorrowerPhone() + "', status_peminjam = '"
                + borrowing.getBorrowerStatus() + "', alamat_peminjam = '" + borrowing.getBorrowerAddress() + "', nama_kegiatan = '" + borrowing.getActivityName()
                + "', nama_lembaga = '" + borrowing.getOrganizationName() + "', waktu_mulai = '" + sdf.format(borrowing.getStartTime().getTime()) + "', waktu_selesai = '" + sdf.format(borrowing.getFinishTime().getTime())
                + "', jumlah_peserta = '" + borrowing.getTotalParticipant() + "' WHERE id_peminjaman = '" + borrowing.getId() + "'";
        String message = database.changeData(sql);
        
        
        
        database.closeDatabase();
        
        return message;
    }

    public String deleteBorrowing(BorrowingModel borrowing) {
        database.connect(path);

        String sql = "DELETE FROM peminjaman WHERE id_peminjaman = '" + borrowing.getId() + "'";
        String message = database.changeData(sql);
        
        database.closeDatabase();
        
        return message;
    }

    public ArrayList<BorrowingModel> showClashBorrowing(BorrowingModel borrowing) {
        ArrayList<BorrowingModel> clashBorrowing = new ArrayList<>();
        database.connect(path);

        String sql = "SELECT * FROM peminjaman WHERE id_ruangan = '" + borrowing.getId() + "' AND ((waktu_mulai >= '" + sdf.format(borrowing.getStartTime().getTime()) + "' AND waktu_mulai <= '"
                + sdf.format(borrowing.getFinishTime().getTime()) + "') OR (waktu_selesai >= '" + sdf.format(borrowing.getStartTime().getTime()) + "' AND waktu_selesai <= '" + sdf.format(borrowing.getFinishTime().getTime()) + "'))";
        
        ResultSet rs = database.fetchData(sql);
        
        try {
            while (rs.next()) {
                clashBorrowing.add(new BorrowingModel(rs.getInt("id_peminjaman"), rs.getInt("id_peminjam"), rs.getInt("id_ruangan"), rs.getString("nama_peminjam"),
                      rs.getString("status_peminjam"), rs.getString("alamat_peminjam"), rs.getString("nomor_telepon_peminjam"), rs.getString("nama_lembaga"), rs.getString("nama_kegiatan"), 
                      rs.getInt("jumlah_peserta"), BorrowingModel.convertTimestampToCalendar(rs.getTimestamp("waktu_izin")), BorrowingModel.convertTimestampToCalendar(rs.getTimestamp("waktu_mulai")), 
                      BorrowingModel.convertTimestampToCalendar(rs.getTimestamp("waktu_selesai"))));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Borrowing.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        database.closeDatabase();
        
        return clashBorrowing;
    }
    
    public ArrayList<MaintenanceModel> getClashMaintenance(BorrowingModel borrowing) {
        ArrayList<MaintenanceModel> clashMaintenance = new ArrayList<>();

        database.connect(path);

        String sql = "SELECT * FROM pemeliharaan WHERE id_ruangan = '" + borrowing.getRoomId() + "' AND ((waktu_mulai >= '" +
                sdf.format(borrowing.getStartTime().getTime()) + "' AND waktu_mulai <= '" + sdf.format(borrowing.getFinishTime().getTime()) + "') OR (waktu_selesai >= '" +
                sdf.format(borrowing.getStartTime().getTime()) + "' AND waktu_selesai <= '" + sdf.format(borrowing.getFinishTime().getTime()) + "'))";
        
        ResultSet rs = database.fetchData(sql);

        try {
          while(rs.next()) {
              clashMaintenance.add(new MaintenanceModel(rs.getInt("id_pemeliharaan"), rs.getInt("id_ruangan"), rs.getString("deskripsi"), 
                      MaintenanceModel.convertTimestampToCalendar(rs.getTimestamp("waktu_mulai")), MaintenanceModel.convertTimestampToCalendar(rs.getTimestamp("waktu_selesai"))));
          }
        } catch (SQLException ex) {
          Logger.getLogger(Borrowing.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        database.closeDatabase();
        
        return clashMaintenance;
    }
    
    public static final void main(String args[]) {
        Borrowing borrowing = new Borrowing();
        
        Calendar startTime = new GregorianCalendar(2016, 1, 23, 13, 30);
        Calendar finishTime = new GregorianCalendar(2016, 1, 23, 18, 30);
        Calendar permissionTime = new GregorianCalendar();
        BorrowingModel borrowingModel = new BorrowingModel(16, 22222222, 2, "Nina", "Dosen", "JL Cisitu", "0823133224333", "Informatika ITB", "kuliah", 50, permissionTime, startTime, finishTime);
        
//        String msg = borrowing.deleteBorrowing(borrowingModel);
//        System.out.println(msg);
        
        ArrayList<BorrowingModel> clashBorrowing = new ArrayList<>();
        clashBorrowing = borrowing.showClashBorrowing(borrowingModel);
        for (int i = 0; i < clashBorrowing.size(); i++) {
            System.out.println(clashBorrowing.get(i).getId());
        }
        
        ArrayList<MaintenanceModel> clashMaintenance = new ArrayList<>();
        clashMaintenance = borrowing.getClashMaintenance(borrowingModel);
        
        for (int i = 0; i < clashBorrowing.size(); i++) {
            System.out.println(clashMaintenance.get(i).getId());
        }
    }
}
