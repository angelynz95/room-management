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
  
    private Database database;
    private final String path = "jdbc:mysql://localhost:3306/room_management";
    
    public Booking() {
        database = new Database();
    }

    public String addBooking(Borrowing borrowing) {
        database.connect(path);

        String sql = "INSERT INTO borrowing (id_ruangan, id_peminjam, nama_peminjam, nomor_telepon_peminjam, "
                + "status_peminjam, alamat_peminjam, nama_kegiatan, nama_lembaga, waktu_mulai, waktu_selesai, jumlah_peserta)"
                + "VALUES (" + borrowing.getBorrowerId() + "," + borrowing.getBorrowerName() + "," + borrowing.getBorrowerPhone() + "," 
                + borrowing.getBorrowerStatus() + "," + borrowing.getBorrowerAddress() + "," + borrowing.getActivityName() + "," + borrowing.getOrganizationName()
                + borrowing.getStartTime() + "," + borrowing.getFinishTime() + "," + borrowing.getTotalParticipant() + ")";
        return database.changeData(sql);
    }

    public String changeBooking(Borrowing borrowing) {
        database.connect(path);

        String sql = "UPDATE borrowing SET id_ruangan = " + borrowing.getId() + ", id_peminjam = " + borrowing.getBorrowerId()
                + ", nama_peminjam = " + borrowing.getBorrowerName() + ", nomor_telepon_peminjam = " + borrowing.getBorrowerPhone() + "status_peminjam = "
                + borrowing.getBorrowerStatus() + ", alamat_peminjam = " + borrowing.getBorrowerAddress() + ", nama_kegiatan = " + borrowing.getActivityName()
                + ", nama_lembaga = " + borrowing.getOrganizationName() + ", waktu_mulai = " + borrowing.getStartTime() + ", waktu_selesai = " + borrowing.getFinishTime()
                + ", jumlah_peserta = " + borrowing.getTotalParticipant() + " WHERE id_peminjaman = " + borrowing.getId();
        return database.changeData(sql);
    }

    public String deleteBooking(Borrowing borrowing) {
        database.connect(path);

        String sql = "DELETE FROM peminjaman WHERE id_peminjaman = " + borrowing.getId();
        return database.changeData(sql);
    }

    public ArrayList<Borrowing> showClashBooking(Borrowing borrowing) {
        ArrayList<Borrowing> clashBooking = new ArrayList<>();
        database.connect(path);

        String sql = "SELECT * FROM peminjaman WHERE id_ruangan = " + borrowing.getId() + " AND ((waktu_mulai >= " + borrowing.getStartTime() + "AND waktu_mulai <= "
                + borrowing.getFinishTime() + ") OR (waktu_selesai >= " + borrowing.getStartTime() + " AND waktu_selesai <= " + borrowing.getFinishTime();

        ResultSet rs = database.fetchData(sql);

        try {
            while (rs.next()) {
              clashBooking.add(new Borrowing(rs.getInt("id_peminjaman"), rs.getInt("id_peminjam"), rs.getInt("id_ruangan"), rs.getString("nama_peminjam"),
                      rs.getString("status_peminjam"), rs.getString("alamat_peminjam"), rs.getString("nomor_telepon_peminjam"), rs.getString("nama_lembaga"), rs.getString("nama_kegiatan"), 
                      rs.getInt("jumlah_peserta"), rs.getTimestamp(""), rs.getTimestamp("waktu_mulai"), rs.getTimestamp("waktu_selesai")));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clashBooking;
      }
}
