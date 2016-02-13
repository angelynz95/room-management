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
import database.MaintenanceModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Maintenance {

    private Database database;
    private final String path = "jdbc:mysql://localhost:3306/room_management";

    public Maintenance() {
        database = new Database();
    }

    public String addMaintenance(MaintenanceModel maintenance) {
        database.connect(path);

        String sql = "INSERT INTO pemeliharaan (id_ruangan, deskripsi, waktu_mulai, waktu_selesai) VALUES (" +
                maintenance.getRoomId() + " , " + maintenance.getDescription() + " , " + maintenance.getStartTime() +
                " , " + maintenance.getFinishTime() + ")";

        return database.changeData(sql);
    }

    public ArrayList<MaintenanceModel> getClashMaintenance(MaintenanceModel maintenance) {
        ArrayList<MaintenanceModel> clashMaintenance = new ArrayList<>();

        database.connect(path);

        String sql = "SELECT * FROM pemeliharaan WHERE id_ruangan = " + maintenance.getRoomId() + " AND ((waktu_mulai >= " +
                maintenance.getStartTime() + " AND waktu_mulai <= " + maintenance.getFinishTime() + ") OR (waktu_selesai >= " +
                maintenance.getStartTime() + " AND waktu_selesai <= " + maintenance.getFinishTime();

        ResultSet rs = database.fetchData(sql);

        try {
          while(rs.next()) {
            clashMaintenance.add(new MaintenanceModel(rs.getInt("id_pemeliharaan"), rs.getInt("id_ruangan"), rs.getString("deskripsi"), rs.getTimestamp("waktu_mulai"), rs.getTimestamp("waktu_selesai")));
          }
        } catch (SQLException ex) {
          Logger.getLogger(Maintenance.class.getName()).log(Level.SEVERE, null, ex);
        }

        return clashMaintenance;
    }

    public String deleteMaintenance(MaintenanceModel maintenance) {
        database.connect(path);

        String sql = "DELETE FROM pemeliharaan WHERE id_peminjaman = " + maintenance.getId();

        return database.changeData(sql);
    }
}
