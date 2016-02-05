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
  private String roomName;
  private String description;
  private Timestamp start;
  private Timestamp finish;
  
  public Maintenance() {
    
  }
  
  public Maintenance(String roomName, String description, Timestamp start, Timestamp finish) {
    this.roomName = roomName;
    this.description = description;
    this.start = start;
    this.finish = finish;
  }
  
  public String getRoomName() {
    return roomName;
  }

  public String getDescription() {
    return description;
  }

  public Timestamp getStart() {
    return start;
  }

  public Timestamp getFinish() {
    return finish;
  }

  public void setRoomId(String roomName) {
    this.roomName = roomName;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setStart(Timestamp start) {
    this.start = start;
  }

  public void setFinish(Timestamp finish) {
    this.finish = finish;
  }
}
