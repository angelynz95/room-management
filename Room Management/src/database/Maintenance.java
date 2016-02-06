package database;

/**
 * Aplikasi Room Management
 * @author Irene Wiliudarsan - 13513002
 * @author William Sentosa - 13513026
 * @author Angela Lynn - 13513032
 * @author Devina Ekawati - 13513088
 */

import java.sql.*;

public class Maintenance {
    private int id;
    private int roomId;
    private String description;
    private Timestamp startTime;
    private Timestamp finishTime;
    
    public Maintenance() {
        
    }

    public Maintenance(int id, int roomId, String description, Timestamp startTime, Timestamp finishTime) {
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

    public Timestamp getStartTime() {
        return startTime;
    }

    public Timestamp getFinishTime() {
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

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public void setFinishTime(Timestamp finishTime) {
        this.finishTime = finishTime;
    }
}
