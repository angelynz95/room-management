package bookinginformation;

import database.BorrowingModel;
import database.Database;
import database.MaintenanceModel;
import database.RoomModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;

/**
 * Created by User on 2/4/2016.
 */
public class BookingInformation {
    // Atribut
    private LinkedHashMap<RoomModel, Map<Integer, Object>> tableSchedule;
    private Map<Integer, Object> roomSchedule;
    private Database database;
    private String path = "jdbc:mysql://localhost:3306/room_management";

    // Method
    // Konstruktor
    public BookingInformation() {
        // Mengisi tabel dengan daftar nama seluruh ruangan pada basis data
        database = new Database();
        database.connect(path);
        String query = "SELECT * FROM ruangan;";
        ResultSet rs = database.fetchData(query);
        tableSchedule = new LinkedHashMap<>();

        try {
            // Mengisi data ruangan pada tabel jadwal
            while(rs.next()) {
                int roomId = rs.getInt("id_ruangan");
                String roomName = rs.getString("nama");
                int roomCapacity = rs.getInt("kapasitas");
                String roomStatus = rs.getString("status");
                RoomModel room = new RoomModel(roomId, roomName, roomCapacity, roomStatus);
                roomSchedule = new TreeMap<>();
                tableSchedule.put(room, roomSchedule);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        database.closeDatabase();
    }

    // Menampilkan jadwal peminjaman pada suatu waktu tertentu
    private void showBookingSchedule(Date today) {
        database.connect(path);
        String query = "SELECT * FROM peminjaman" +
                " WHERE waktu_mulai = " + today +
                " ORDER BY id_ruangan, waktu_mulai;";
        ResultSet rs = database.fetchData(query);
        try {
            while (rs.next()) {
                int roomIdNow = rs.getInt("id_ruangan");
                int roomId = roomIdNow;
                do {
                    int borrowingId = rs.getInt("id_peminjaman");
                    int borrowerId = rs.getInt("id_peminjam");
                    String borrowerName = rs.getString("nama_peminjam");
                    String borrowerStatus = rs.getString("status_peminjam");
                    String borrowerAddress = rs.getString("alamat_peminjam");
                    String borrowerPhone = rs.getString("nomor_telepon_peminjam");
                    String organizationName = rs.getString("nama_lembaga");
                    String activityName = rs.getString("nama_kegiatan");
                    int totalParticipant = rs.getInt("jumlah_peserta");
                    Timestamp permissionTime = rs.getTimestamp("waktu_izin");
                    Timestamp startTime = rs.getTimestamp("waktu_mulai");
                    Timestamp finishTime = rs.getTimestamp("waktu_selesai");

                    BorrowingModel borrowing = new BorrowingModel(borrowingId, borrowerId, roomId, borrowerName, borrowerStatus, borrowerAddress, borrowerPhone, organizationName, activityName, totalParticipant, permissionTime, startTime, finishTime);

                    if (startTime.getDate()== finishTime.getDate()) {
                        for (int i=startTime.getHours(); i<finishTime.getHours(); i++) {
                            roomSchedule.put(i, borrowing);
                        }
                        tableSchedule.put(searchRoomById(roomId), roomSchedule);
                    } else {
                        // Tanggal dimulai berbeda dengan tanggal selesai
                        for (int i=startTime.getHours(); i<BorrowingModel.MAX_BORROW_HOUR; i++) {
                            roomSchedule.put(i, borrowing);
                        }
                        tableSchedule.put(searchRoomById(roomId), roomSchedule);
                    }

                    roomId= rs.getInt("id_ruangan");
                } while(roomIdNow == roomId);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        database.closeDatabase();
    }

    // Menampilkan jadwal pemeliharaan pada suatu waktu tertentu
    private void showMaintenanceSchedule(Date today) {
        database.connect(path);
        String query = "SELECT * FROM pemeliharaan" +
                " WHERE waktu_mulai = " + today +
                " ORDER BY id_ruangan, waktu_mulai;";
        ResultSet rs = database.fetchData(query);
        try {
            while (rs.next()) {
                int roomIdNow = rs.getInt("id_ruangan");
                int roomId = roomIdNow;
                do {
                    int maintenanceId = rs.getInt("id_pemeliharaan");
                    String description = rs.getString("deskripsi");
                    Timestamp startTime = rs.getTimestamp("waktu_mulai");
                    Timestamp finishTime = rs.getTimestamp("waktu_selesai");

                    MaintenanceModel maintenance = new MaintenanceModel(maintenanceId, roomId, description, startTime, finishTime);

                    if (startTime.getDate() == finishTime.getDate()) {
                        for (int i=startTime.getHours(); i<finishTime.getHours(); i++) {
                            roomSchedule.put(i, maintenance);
                        }
                        tableSchedule.put(searchRoomById(roomId), roomSchedule);
                    } else {
                        // Tanggal dimulai berbeda dengan tanggal selesai
                        for (int i=startTime.getHours(); i<MaintenanceModel.MAX_MAINTAIN_HOUR; i++) {
                            roomSchedule.put(i, maintenance);
                        }
                        tableSchedule.put(searchRoomById(roomId), roomSchedule);
                    }

                    roomId= rs.getInt("id_ruangan");
                } while(roomIdNow == roomId);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        database.closeDatabase();
    }

    // Mencari ruangan pada tabel jadwal dengan menggunakan ID ruangan
    RoomModel searchRoomById(int roomId) {
        Iterator schedules = tableSchedule.entrySet().iterator();
        Map.Entry<RoomModel, Map<Integer, Object>> schedule = null;
        boolean isFound = false;
        while (schedules.hasNext() && !isFound) {
            schedule = (Map.Entry) schedules.next();
            int mapRoomId = schedule.getKey().getId();
            if (mapRoomId == roomId) {
                isFound = true;
            }
        }
        if (isFound) {
            return schedule.getKey();
        } else {
            return null;
        }
    }
}
