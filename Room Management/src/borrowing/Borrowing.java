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
    
    public BorrowingModel searchBorrowingById(int id) {
        BorrowingModel b = new BorrowingModel();
        database.connect(path);
        String sql = "SELECT * FROM peminjaman WHERE id_peminjaman = " + id + ";";
        ResultSet rs = database.fetchData(sql);
        try { 
            rs.next();
            b.setId(rs.getInt("id_peminjaman"));
            b.setRoomId(rs.getInt("id_ruangan"));
            b.setBorrowerId(rs.getInt("id_peminjam"));
            b.setBorrowerName(rs.getString("nama_peminjam"));
            b.setBorrowerStatus(rs.getString("status_peminjam"));
            b.setBorrowerAddress(rs.getString("alamat_peminjam"));
            b.setBorrowerPhone(rs.getString("nomor_telepon_peminjam"));
            b.setOrganizationName(rs.getString("nama_lembaga"));
            b.setActivityName(rs.getString("nama_kegiatan"));
            b.setTotalParticipant(rs.getInt("jumlah_peserta"));
            b.setPermissionTime( BorrowingModel.convertTimestampToCalendar(rs.getTimestamp("waktu_izin")));
            b.setStart(BorrowingModel.convertTimestampToCalendar(rs.getTimestamp("waktu_mulai")));
            b.setFinish(BorrowingModel.convertTimestampToCalendar(rs.getTimestamp("waktu_selesai")));
        } catch (SQLException ex) {
            Logger.getLogger(Borrowing.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b;
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
    
    
    
    public void addWeekelyBorrowing(BorrowingModel borrowing, Calendar calendarStart, Calendar calendarEnd, int startHour, int endHour) {
        database.connect(path);
        Calendar tempStart = new GregorianCalendar();
        Calendar tempEnd = new GregorianCalendar();
        int day = borrowing.getStartTime().get(Calendar.DAY_OF_WEEK);
        while (calendarStart.before(calendarEnd)) {
            tempStart.set(calendarStart.get(Calendar.YEAR), calendarStart.get(Calendar.MONTH), calendarStart.get(Calendar.DATE), startHour, 0, 0);
            tempEnd.set(calendarStart.get(Calendar.YEAR), calendarStart.get(Calendar.MONTH), calendarStart.get(Calendar.DATE), endHour, 0, 0);
            if (calendarStart.get(Calendar.DAY_OF_WEEK) == day) {
                String sql = "INSERT INTO peminjaman (id_ruangan, id_peminjam, nama_peminjam, nomor_telepon_peminjam, "
                + "status_peminjam, alamat_peminjam, nama_kegiatan, nama_lembaga, waktu_mulai, waktu_selesai, jumlah_peserta)"
                + " VALUES ('" + borrowing.getRoomId() + "', '" + borrowing.getBorrowerId() + "','" + borrowing.getBorrowerName() + "','" + borrowing.getBorrowerPhone() + "','" 
                + borrowing.getBorrowerStatus() + "','" + borrowing.getBorrowerAddress() + "','" + borrowing.getActivityName() + "','" + borrowing.getOrganizationName() + "', '"
                + sdf.format(tempStart.getTime()) + "','" + sdf.format(tempEnd.getTime()) + "','" + borrowing.getTotalParticipant() + "')";
                String message = database.changeData(sql);
                System.out.println(sdf.format(tempStart.getTime()) + " - " + sdf.format(tempEnd.getTime()));
            }
            calendarStart.add(Calendar.DATE, 1);
        }
        database.closeDatabase();
    }
    
    public ArrayList<BorrowingModel> getClashBorrowing(BorrowingModel borrowing) {
        ArrayList<BorrowingModel> clashBorrowing = new ArrayList<>();
        database.connect(path);

        String sql = "SELECT * FROM peminjaman WHERE id_peminjaman <> " + borrowing.getId() + " AND id_ruangan = '" + borrowing.getRoomId()+ "' AND ((waktu_mulai >= '" + sdf.format(borrowing.getStartTime().getTime()) + "' AND waktu_mulai <= '"
                + sdf.format(borrowing.getFinishTime().getTime()) + "') OR (waktu_selesai >= '" + sdf.format(borrowing.getStartTime().getTime()) + "' AND waktu_selesai <= '" + sdf.format(borrowing.getFinishTime().getTime()) + "'))";
        
        ResultSet rs = database.fetchData(sql);
        
        try {
            while (rs.next()) {
                clashBorrowing.add(new BorrowingModel(rs.getInt("id_peminjaman"), rs.getInt("id_peminjam"), rs.getInt("id_ruangan"), rs.getString("nama_peminjam"),
                      rs.getString("status_peminjam"), rs.getString("alamat_peminjam"), rs.getString("nomor_telepon_peminjam"), rs.getString("nama_lembaga"), rs.getString("nama_kegiatan"), 
                      rs.getInt("jumlah_peserta"), BorrowingModel.convertTimestampToCalendar(rs.getTimestamp("waktu_mulai")), 
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

        String sql = "SELECT * FROM pemeliharaan WHERE id_peminjaman <> " + borrowing.getId() + " AND id_ruangan = '" + borrowing.getRoomId() + "' AND ((waktu_mulai >= '" +
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
        
        Calendar startTime = new GregorianCalendar(2016, 3, 7, 7, 00);
        Calendar finishTime = new GregorianCalendar(2016, 3, 21, 9, 00);
        BorrowingModel borrowingModel = new BorrowingModel(16, 22222222, 1, "Nina", "Dosen", "JL Cisitu", "0823133224333", "Informatika ITB", "kuliah PBD", 50, startTime, finishTime);
        
        borrowing.addWeekelyBorrowing(borrowingModel, startTime, finishTime, 7, 9);
        
        
    }
}
