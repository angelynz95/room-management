package database;

/**
 * Aplikasi Room Management
 * @author Irene Wiliudarsan - 13513002
 * @author William Sentosa - 13513026
 * @author Angela Lynn - 13513032
 * @author Devina Ekawati - 13513088
 */

public class Room {
  String name;
  int capacity;
  String status;
  
  public Room() {
    
  }

  public Room(String name, int capacity, String status) {
    this.name = name;
    this.capacity = capacity;
    this.status = status;
  }

  public String getName() {
    return name;
  }

  public int getCapacity() {
    return capacity;
  }

  public String getStatus() {
    return status;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}