package database;

/**
 * Aplikasi Room Management
 * @author Irene Wiliudarsan - 13513002
 * @author William Sentosa - 13513026
 * @author Angela Lynn - 13513032
 * @author Devina Ekawati - 13513088
 */

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MaintenanceModel {
    public final int MAX_MAINTAIN_HOUR = 23;
    private int id;
    private int roomId;
    private String description;
    private Calendar startTime;
    private Calendar finishTime;

    public MaintenanceModel() {
        
    }

    public MaintenanceModel(int id, int roomId, String description, Calendar startTime, Calendar finishTime) {
        this.id = id;
        this.roomId = roomId;
        this.description = description;
        this.startTime = startTime;
        this.finishTime = finishTime;
    }

    public int getId() {
        return id;
    }

    public int getRoomId() {
        return roomId;
    }

    public String getDescription() {
        return description;
    }

    public Calendar getStartTime() {
        return startTime;
    }

    public Calendar getFinishTime() {
        return finishTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStartTime(Calendar startTime) {
        this.startTime = startTime;
    }

    public void setFinishTime(Calendar finishTime) {
        this.finishTime = finishTime;
    }

    // Mengkonversi tipe data Calendar ke calendar
    public final Calendar setCalendarToCalendar(Timestamp timestamp) {
        long timeMillis =  timestamp.getTime();
        Calendar result = new GregorianCalendar();
        result.setTimeInMillis(timeMillis);
        return result;
    }
}
