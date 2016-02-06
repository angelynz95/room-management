package database;

/**
 * Aplikasi Room Management
 * @author Irene Wiliudarsan - 13513002
 * @author William Sentosa - 13513026
 * @author Angela Lynn - 13513032
 * @author Devina Ekawati - 13513088
 */

import java.sql.*;

public class Borrowing {
    int id;
    String borrowerId;
    int roomId;
    String roomName;
    String borrowerName;
    String borrowerStatus;
    String borrowerAddress;
    String borrowerPhone;
    String organizationName;
    String activityName;
    int totalParticipant;
    Timestamp start;
    Timestamp finish;
    
    public Borrowing() {
        
    }

    public Borrowing(int id, String borrowerId, int roomID, String roomName, String borrowerName, String borrowerStatus, String borrowerAddress, String borrowerPhone, String organizationName, String activityName, int totalParticipant, Timestamp start, Timestamp finish) {
        this.id = id;
        this.borrowerId = borrowerId;
        this.roomId = roomID;
        this.roomName = roomName;
        this.borrowerName = borrowerName;
        this.borrowerStatus = borrowerStatus;
        this.borrowerAddress = borrowerAddress;
        this.borrowerPhone = borrowerPhone;
        this.organizationName = organizationName;
        this.activityName = activityName;
        this.totalParticipant = totalParticipant;
        this.start = start;
        this.finish = finish;
    }

    public int getId() {
        return id;
    }

    public String getBorrowerId() {
        return borrowerId;
    }

    public int getRoomId() {
        return roomId;
    }
    
    public String getRoomName() {
        return roomName;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public String getBorrowerStatus() {
        return borrowerStatus;
    }

    public String getBorrowerAddress() {
        return borrowerAddress;
    }

    public String getBorrowerPhone() {
        return borrowerPhone;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public String getActivityName() {
        return activityName;
    }

    public int getTotalParticipant() {
        return totalParticipant;
    }

    public Timestamp getStart() {
        return start;
    }

    public Timestamp getFinish() {
        return finish;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBorrowerId(String borrowerId) {
        this.borrowerId = borrowerId;
    }

    public void setRoomId(int roomID) {
        this.roomId = roomID;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public void setBorrowerStatus(String borrowerStatus) {
        this.borrowerStatus = borrowerStatus;
    }

    public void setBorrowerAddress(String borrowerAddress) {
        this.borrowerAddress = borrowerAddress;
    }

    public void setBorrowerPhone(String borrowerPhone) {
        this.borrowerPhone = borrowerPhone;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public void setTotalParticipant(int totalParticipant) {
        this.totalParticipant = totalParticipant;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    public void setFinish(Timestamp finish) {
        this.finish = finish;
    }
}
