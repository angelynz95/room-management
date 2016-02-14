/**
 * Aplikasi Room Management
 * @author Irene Wiliudarsan - 13513002
 * @author William Sentosa - 13513026
 * @author Angela Lynn - 13513032
 * @author Devina Ekawati - 13513088
 */
package bookinginformation;

import database.BorrowingModel;
import database.Database;
import database.MaintenanceModel;
import database.RoomModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by User on 2/4/2016.
 */
public class BookingInformation {
    // Atribut
    private LinkedHashMap<RoomModel, Map<Integer, Object>> tableSchedule;
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
                Map<Integer, Object> roomSchedule = new TreeMap<>();
                tableSchedule.put(room, roomSchedule);
            }
        } catch (SQLException e) {
            Logger.getLogger(BookingInformation.class.getName()).log(Level.SEVERE, null, e);
        }
        database.closeDatabase();
    }
    
    // Getter
    public LinkedHashMap<RoomModel, Map<Integer, Object>> getRoomsSchedule() {
        return tableSchedule;
    }

    // Menampilkan jadwal peminjaman pada suatu waktu tertentu
    public void showBookingSchedule(Calendar date) {
        database.connect(path);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String query = "SELECT * FROM peminjaman" +
                " WHERE CAST(waktu_mulai AS DATE) = '" + sdf.format(date.getTime()) +
                "' ORDER BY id_ruangan, waktu_mulai;";
        ResultSet rs = database.fetchData(query);
        try {
            while (rs.next()) {
                int roomIdNow = rs.getInt("id_ruangan");
                int roomId = roomIdNow;
                RoomModel room = searchRoomById(roomId);
                        
                // Looping untuk setiap ruangan
                do {
                    String borrowerName = rs.getString("nama_peminjam");
                    int borrowingId = rs.getInt("id_peminjaman");
                    int borrowerId = rs.getInt("id_peminjam");
                    String borrowerStatus = rs.getString("status_peminjam");
                    String borrowerAddress = rs.getString("alamat_peminjam");
                    String borrowerPhone = rs.getString("nomor_telepon_peminjam");
                    String organizationName = rs.getString("nama_lembaga");
                    String activityName = rs.getString("nama_kegiatan");
                    int totalParticipant = rs.getInt("jumlah_peserta");
                    Calendar permissionTime = BorrowingModel.convertTimestampToCalendar(rs.getTimestamp("waktu_izin"));
                    Calendar startTime = BorrowingModel.convertTimestampToCalendar(rs.getTimestamp("waktu_mulai"));
                    Calendar finishTime = BorrowingModel.convertTimestampToCalendar(rs.getTimestamp("waktu_selesai"));

                    BorrowingModel borrowing = new BorrowingModel(borrowingId, borrowerId, roomId, borrowerName, borrowerStatus, borrowerAddress, borrowerPhone, organizationName, activityName, totalParticipant, permissionTime, startTime, finishTime);
                    Map<Integer, Object> roomSchedule = tableSchedule.get(room);

                    if (startTime.get(Calendar.DAY_OF_MONTH) == finishTime.get(Calendar.DAY_OF_MONTH)) {
                        for (int i=startTime.get(Calendar.HOUR_OF_DAY); i<finishTime.get(Calendar.HOUR_OF_DAY); i++) {
                            roomSchedule.put(i, borrowing);
                        }
                    } else {
                        // Tanggal dimulai berbeda dengan tanggal selesai
                        for (int i=startTime.get(Calendar.HOUR_OF_DAY); i<BorrowingModel.MAX_BORROW_HOUR; i++) {
                            roomSchedule.put(i, borrowing);
                        }
                    }

                    roomId = rs.getInt("id_ruangan");
                } while((roomIdNow==roomId) && rs.next());
            }
        } catch(SQLException e) {
            Logger.getLogger(BookingInformation.class.getName()).log(Level.SEVERE, null, e);
        }
        database.closeDatabase();
    }

    // Menampilkan jadwal pemeliharaan pada suatu waktu tertentu
    public void showMaintenanceSchedule(Calendar date) {
        database.connect(path);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String query = "SELECT * FROM pemeliharaan" +
                " WHERE CAST(waktu_mulai AS DATE) = '" + sdf.format(date.getTime()) +
                "' ORDER BY id_ruangan, waktu_mulai;";
        ResultSet rs = database.fetchData(query);
        try {
            while (rs.next()) {
                int roomIdNow = rs.getInt("id_ruangan");
                int roomId = roomIdNow;
                RoomModel room = searchRoomById(roomId);
                
                // Looping untuk setiap ruangan
                do {
                    int maintenanceId = rs.getInt("id_pemeliharaan");
                    String description = rs.getString("deskripsi");
                    Calendar startTime = MaintenanceModel.convertTimestampToCalendar(rs.getTimestamp("waktu_mulai"));
                    Calendar finishTime = MaintenanceModel.convertTimestampToCalendar(rs.getTimestamp("waktu_selesai"));

                    MaintenanceModel maintenance = new MaintenanceModel(maintenanceId, roomId, description, startTime, finishTime);
                    Map<Integer, Object> roomSchedule = tableSchedule.get(room);

                    if (startTime.get(Calendar.DAY_OF_MONTH) == finishTime.get(Calendar.DAY_OF_MONTH)) {
                        for (int i=startTime.get(Calendar.HOUR_OF_DAY); i<finishTime.get(Calendar.HOUR_OF_DAY); i++) {
                            roomSchedule.put(i, maintenance);
                        }
                    } else {
                        // Tanggal dimulai berbeda dengan tanggal selesai
                        for (int i=startTime.get(Calendar.HOUR_OF_DAY); i<MaintenanceModel.MAX_MAINTAIN_HOUR; i++) {
                            roomSchedule.put(i, maintenance);
                        }
                    }

                    roomId= rs.getInt("id_ruangan");
                } while((roomIdNow==roomId) && rs.next());
            }
        } catch(SQLException e) {
            Logger.getLogger(BookingInformation.class.getName()).log(Level.SEVERE, null, e);
        }
        database.closeDatabase();
    }

    // Mencari ruangan pada tabel jadwal dengan menggunakan ID ruangan
    private RoomModel searchRoomById(int roomId) {
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

    public static void main(String[] args) {
        BookingInformation roomsSchedule = new BookingInformation();
        Calendar date = new GregorianCalendar(2016, 1, 22); // 22 Februari 2016
        roomsSchedule.showBookingSchedule(date);
        roomsSchedule.showMaintenanceSchedule(date);
        
        for(Map.Entry<RoomModel, Map<Integer, Object>> roomSchedule: roomsSchedule.getRoomsSchedule().entrySet()) {
            RoomModel room = roomSchedule.getKey();
            System.out.println("Ruangan: " + room.getId() + " - " + room.getName());
            for(Map.Entry<Integer, Object> roomHourSchedule: roomSchedule.getValue().entrySet()) {
                int hour = roomHourSchedule.getKey();
                Object booking = roomHourSchedule.getValue();
                
                System.out.print("Pukul: " + hour);
                if (booking.getClass().equals(BorrowingModel.class)) {
                    BorrowingModel borrowing = (BorrowingModel) booking;
                    System.out.println(" | Peminjaman: " + borrowing.getId() + " - " + borrowing.getActivityName());
                } else {
                    MaintenanceModel maintenance = (MaintenanceModel) booking;
                    System.out.println(" | Pemeliharaan: " + maintenance.getId() + " - " + maintenance.getDescription());
                }
            }
            System.out.println();
        }
    }
}
