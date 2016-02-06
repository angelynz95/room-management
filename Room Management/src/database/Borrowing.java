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
    private int id;
    private int roomId;
    private int borrowerId;
    private String borrowerName;
    private String borrowerStatus;
    private String borrowerAddress;
    private String borrowerPhone;
    private String organizationName;
    private String activityName;
    private int totalParticipant;
    private Timestamp permissionTime;
    private Timestamp startTime;
    private Timestamp finishTime;
    
    public Borrowing() {
        
    }

    public Borrowing(int id, int borrowerId, int roomID, String borrowerName, String borrowerStatus, String borrowerAddress, String borrowerPhone, String organizationName, String activityName, int totalParticipant, Timestamp permissionTime, Timestamp startTime, Timestamp finishTime) {
        this.id = id;
        this.borrowerId = borrowerId;
        this.roomId = roomID;
        this.borrowerName = borrowerName;
        this.borrowerStatus = borrowerStatus;
        this.borrowerAddress = borrowerAddress;
        this.borrowerPhone = borrowerPhone;
        this.organizationName = organizationName;
        this.activityName = activityName;
        this.totalParticipant = totalParticipant;
        this.permissionTime = permissionTime;
        this.startTime = startTime;
        this.finishTime = finishTime;
    }

    public int getId() {
        return id;
    }

    public int getBorrowerId() {
        return borrowerId;
    }

    public int getRoomId() {
        return roomId;
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

    public Timestamp getPermissionTime() {
        return permissionTime;
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

    public void setBorrowerId(int borrowerId) {
        this.borrowerId = borrowerId;
    }

    public void setRoomId(int roomID) {
        this.roomId = roomID;
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

    public void setPermissionTime(Timestamp permissionTime) {
        this.permissionTime = permissionTime;
    }

    public void setStart(Timestamp startTime) {
        this.startTime = startTime;
    }

    public void setFinish(Timestamp finishTime) {
        this.finishTime = finishTime;
    }
}
