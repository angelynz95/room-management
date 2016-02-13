package roominformation;

import database.BorrowingModel;
import database.Database;
import database.RoomModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import database.RoomModel;
import statistic.Statistic;

/**
 *
 * @author William Sentosa
 */
public class RoomInformation {
    /* Atribute */
    private Database database;
    private final String path = "jdbc:mysql://localhost:3306/room_management";
    
    public RoomInformation() {
        database = new Database();
    }
    
    /**
     * Fetch all room data in database
     * @return list of room which exist in database
     */
    public ArrayList<RoomModel> fetchRoomData() {
        ArrayList<RoomModel> result = new ArrayList<>();
        database.connect(path);
        String sql = "SELECT * from ruangan;";
        ResultSet rs = database.fetchData(sql);
        try {
            while (rs.next()) {
                RoomModel room = new RoomModel();
                room.setId(rs.getInt("id_ruangan"));
                room.setName(rs.getString("nama"));
                room.setCapacity(rs.getInt("kapasitas"));
                room.setStatus(rs.getString("status"));
                result.add(room);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Statistic.class.getName()).log(Level.SEVERE, null, ex);
        }
        database.closeDatabase();
        return result;
    }
    
    /**
     * Search room with namaRuangan as the name
     * @param namaRuangan the name of the room which meant to be searched
     * @return room with the name
     */
    public RoomModel searchRoomData(String namaRuangan) {
        RoomModel result = new RoomModel();
        database.connect(path);
        String sql = "SELECT * FROM ruangan WHERE nama = '" + namaRuangan + "';";
        ResultSet rs = database.fetchData(sql);
        try {
            while (rs.next()) {
                result.setId(rs.getInt("id_ruangan"));
                result.setName(rs.getString("nama"));
                result.setCapacity(rs.getInt("kapasitas"));
                result.setStatus(rs.getString("status"));

                RoomModel room = new RoomModel();
                room.setId(rs.getInt("id_ruangan"));
                room.setName(rs.getString("nama"));
                room.setCapacity(rs.getInt("kapasitas"));
                room.setStatus(rs.getString("status"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Statistic.class.getName()).log(Level.SEVERE, null, ex);
        }
        database.closeDatabase();
        return result;
    }
    
    private ArrayList<BorrowingModel> fetchBorrowingByIdRoomAndTime(int id, Timestamp time) {
        ArrayList<BorrowingModel> result = new ArrayList<>();
        String sql = "SELECT * FROM peminjaman WHERE id_ruangan = " + id + " AND waktu_mulai > " + time + ";";
        ResultSet rs = database.fetchData(sql);
        try {
            while (rs.next()) {
                BorrowingModel b = new BorrowingModel();
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
                b.setPermissionTime(rs.getTimestamp("waktu_izin"));
                b.setStart(rs.getTimestamp("waktu_mulai"));
                b.setFinish(rs.getTimestamp("waktu_selesai"));
                result.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Statistic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    /**
     * Change the status of a room with certain id into new status  
     * @param id room id
     * @return list of borrowing data which was held in this room
     */
    public ArrayList<BorrowingModel> changeRoomStatus(int id) {
        ArrayList<BorrowingModel> result = new ArrayList<>();
        database.connect(path);
        String status = "", newStatus = "";
        String sql = "SELECT status FROM ruangan WHERE id_ruangan = " + id + ";";
        ResultSet rs = database.fetchData(sql);
        try {
            while (rs.next()) {
                RoomModel room = new RoomModel();
                status = rs.getString("status");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Statistic.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (status.compareTo("rusak") == 0) {
            newStatus = "OK";
            String query = "UPDATE ruangan SET status = '"+ newStatus +"' WHERE id_ruangan = " + id;
            database.changeData(query);
        } else if (status.compareTo("OK") == 0) {
            newStatus = "rusak";
            String query = "UPDATE ruangan SET status = '"+ newStatus +"' WHERE id_ruangan = " + id;
            database.changeData(query);
            Date date = new Date();
            result = fetchBorrowingByIdRoomAndTime(id, new Timestamp(date.getTime()));
        }
        database.closeDatabase();
        return result;
    }
    
    public static final void main(String args[]) {
        RoomInformation roomInformation = new RoomInformation();
        ArrayList<RoomModel> rooms = roomInformation.fetchRoomData();
        for(RoomModel r : rooms) {
            System.out.println(r.getId() + " " + r.getName() + " " + r.getCapacity() + " " + r.getStatus());
        }

        String name = "R 7606";
        RoomModel searchedRoom = roomInformation.searchRoomData(name);

        System.out.println("*** Ruangan dengan nama " + name + " ***");
        System.out.println(searchedRoom.getId() + " " + searchedRoom.getName() + " " + searchedRoom.getCapacity() + " " + searchedRoom.getStatus());
    }
    
}
