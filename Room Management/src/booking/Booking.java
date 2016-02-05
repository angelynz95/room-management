/**
 * Aplikasi Room Management
 *
 * @author Irene Wiliudarsan - 13513002
 * @author William Sentosa - 13513026
 * @author Angela Lynn - 13513032
 * @author Devina Ekawati - 13513088
 */
package booking;

import database.Borrowing;
import database.Database;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Booking {
  
  ArrayList<Borrowing> borrowings;
  
  public Booking() {
    borrowings = new ArrayList<>();
  }
  
  public String addBooking(Borrowing borrowing) {
    Database database = new Database();
    database.connect("room-management");

    String sql = "INSERT INTO borrowing (id_ruangan, id_peminjam, nama_peminjam, nomor_telepon_peminjam, "
            + "status_peminjam, alamat_peminjam, nama_kegiatan, nama_lembaga, waktu_mulai, waktu_selesai, jumlah_peserta)"
            + "VALUES (" + borrowing.getBorrowerId() + "," + borrowing.getBorrowerName() + "," + borrowing.getBorrowerPhone() + "," 
            + borrowing.getBorrowerStatus() + "," + borrowing.getBorrowerAddress() + "," + borrowing.getActivityName() + "," + borrowing.getOrganizationName()
            + borrowing.getStart() + "," + borrowing.getFinish() + "," + borrowing.getTotalParticipant() + ")";
    return database.changeData(sql);
  }
  
  public String changeBooking(Borrowing borrowing) {
    Database database = new Database();
    database.connect("room-management");

    String sql = "UPDATE borrowing SET id_ruangan = " + borrowing.getId() + ", id_peminjam = " + borrowing.getBorrowerId()
            + ", nama_peminjam = " + borrowing.getBorrowerName() + ", nomor_telepon_peminjam = " + borrowing.getBorrowerPhone() + "status_peminjam = "
            + borrowing.getBorrowerStatus() + ", alamat_peminjam = " + borrowing.getBorrowerAddress() + ", nama_kegiatan = " + borrowing.getActivityName()
            + ", nama_lembaga = " + borrowing.getOrganizationName() + ", waktu_mulai = " + borrowing.getStart() + ", waktu_selesai = " + borrowing.getFinish()
            + ", jumlah_peserta = " + borrowing.getTotalParticipant() + " WHERE id_peminjaman = " + borrowing.getId();
    return database.changeData(sql);
  }
  
  public String deleteBooking(Borrowing borrowing) {
    Database database = new Database();
    database.connect("room-management");

    String sql = "DELETE FROM peminjaman WHERE id_peminjaman = " + borrowing.getId();
    return database.changeData(sql);
  }
  
  public ArrayList<Borrowing> showClashBooking(Borrowing borrowing) {
    ArrayList<Borrowing> borrowings = new ArrayList<>();
    Database database = new Database();
    database.connect("room-management");
    
    String sql = "SELECT * FROM peminjaman WHERE id_ruangan = " + borrowing.getId() + " AND ((waktu_mulai >= " + borrowing.getStart() + "AND waktu_mulai <= "
            + borrowing.getFinish() + ") OR (waktu_selesai >= " + borrowing.getStart() + " AND waktu_selesai <= " + borrowing.getFinish();
    
    ResultSet rs = database.fetchData(sql);
    
    try {
      while (rs.next()) {
        borrowings.add(new Borrowing(rs.getInt("id_peminjaman"), rs.getString("id_peminjam"), rs.getInt("id_ruangan"), rs.getString("nama_ruangan"), rs.getString("nama_peminjam"),
                rs.getString("status_peminjam"), rs.getString("alamat_peminjam"), rs.getString("nomor_telepon_peminjam"), rs.getString("nama_lembaga"), rs.getString("nama_kegiatan"), 
                rs.getInt("jumlah_peserta"), rs.getTimestamp("waktu_mulai"), rs.getTimestamp("waktu_selesai")));
      }
      rs.close();
    } catch (SQLException ex) {
      Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
    }
    return borrowings;
  }
}
