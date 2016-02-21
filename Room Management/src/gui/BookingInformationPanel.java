/**
 * Aplikasi Room Management
 * @author Irene Wiliudarsan - 13513002
 * @author William Sentosa - 13513026
 * @author Angela Lynn - 13513032
 * @author Devina Ekawati - 13513088
 */
package gui;

import bookinginformation.BookingInformation;
import database.BorrowingModel;
import database.MaintenanceModel;
import database.RoomModel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

/**
 *
 * @author angelynz95
 */
public class BookingInformationPanel extends javax.swing.JPanel {
    BookingInformation bookingInformation;
    Color defaultColor;
    GregorianCalendar date;
    List<String> rooms;
    List<String> roomStatus;
    List<String> schedules;
    MainFrame mainFrame;

    /**
     * Creates new form BookingInformation
     */
    public BookingInformationPanel(GregorianCalendar date) {
        initComponents();
        bookingInformation = new BookingInformation();
        this.date = date;
        rooms = new ArrayList<String>();
        roomStatus = new ArrayList<String>();
        schedules = new ArrayList<String>();
        mainFrame = MainFrame.getInstance();
        dateField.setDate(date.getTime());
        setRooms();
        setRoomStatus();
        setSchedules();
        customizeBookingInformationPane();
        showBookingInformation();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bookingInformationPane = new javax.swing.JScrollPane();
        bookingInformationPanel = new javax.swing.JPanel();
        borrowingButton = new javax.swing.JButton();
        maintenanceButton = new javax.swing.JButton();
        dateField = new org.freixas.jcalendar.JCalendarCombo();
        timePanel = new javax.swing.JPanel();

        javax.swing.GroupLayout bookingInformationPanelLayout = new javax.swing.GroupLayout(bookingInformationPanel);
        bookingInformationPanel.setLayout(bookingInformationPanelLayout);
        bookingInformationPanelLayout.setHorizontalGroup(
            bookingInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1154, Short.MAX_VALUE)
        );
        bookingInformationPanelLayout.setVerticalGroup(
            bookingInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 535, Short.MAX_VALUE)
        );

        bookingInformationPane.setViewportView(bookingInformationPanel);

        borrowingButton.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        borrowingButton.setText("Peminjaman");
        borrowingButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                borrowingButtonMouseClicked(evt);
            }
        });

        maintenanceButton.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        maintenanceButton.setText("Pemeliharaan");
        maintenanceButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                maintenanceButtonMouseClicked(evt);
            }
        });

        dateField.setDateFormat(new SimpleDateFormat("dd/MM/yyyy"));
        dateField.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        dateField.addDateListener(new org.freixas.jcalendar.DateListener() {
            public void dateChanged(org.freixas.jcalendar.DateEvent evt) {
                dateFieldDateChanged(evt);
            }
        });
        dateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout timePanelLayout = new javax.swing.GroupLayout(timePanel);
        timePanel.setLayout(timePanelLayout);
        timePanelLayout.setHorizontalGroup(
            timePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );
        timePanelLayout.setVerticalGroup(
            timePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 511, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(435, Short.MAX_VALUE)
                        .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(230, 230, 230)
                        .addComponent(borrowingButton)
                        .addGap(18, 18, 18)
                        .addComponent(maintenanceButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(timePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bookingInformationPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(borrowingButton)
                    .addComponent(maintenanceButton)
                    .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bookingInformationPane, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void dateFieldDateChanged(org.freixas.jcalendar.DateEvent evt) {//GEN-FIRST:event_dateFieldDateChanged
        timePanel.removeAll();
        bookingInformationPanel.removeAll();
        date = (GregorianCalendar) evt.getSelectedDate();
        bookingInformation = new BookingInformation();
        showBookingInformation();
        timePanel.repaint();
        bookingInformationPanel.repaint();
        timePanel.revalidate();
        bookingInformationPanel.revalidate();
    }//GEN-LAST:event_dateFieldDateChanged

    private void dateFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateFieldActionPerformed

    private void borrowingButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_borrowingButtonMouseClicked
        if (roomStatus.contains("OK")) {
            BorrowingFrame borrowingFrame = new BorrowingFrame(date);
            borrowingFrame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Tidak ada ruangan yang bisa dipinjam", "Pesan", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_borrowingButtonMouseClicked

    private void maintenanceButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maintenanceButtonMouseClicked
        if (roomStatus.contains("Rusak")) {
            MaintenanceFrame maintenanceFrame = new MaintenanceFrame(date);
            maintenanceFrame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Tidak ada ruangan yang rusak", "Pesan", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_maintenanceButtonMouseClicked

    private void setRooms() {
        for(Map.Entry<RoomModel, Map<Integer, Object>> roomSchedule: bookingInformation.getRoomsSchedule().entrySet()) {
            rooms.add(roomSchedule.getKey().getName());
        }
    }
    
    private void setSchedules() {
        schedules.add("");
        for (int i = 7; i < 9; i++) {
            schedules.add("0" + i + ".00 - 0" + (i+1) + ".00");
        }
        schedules.add("09.00 - 10.00");
        for (int i = 0; i < 9; i++) {
            schedules.add("1" + i + ".00 - 1" + (i+1) + ".00");
        }
        schedules.add("19.00 - 20.00");
        for (int i = 0; i <= 2; i++) {
            schedules.add("2" + i + ".00 - 2" + (i+1) + ".00");
        }
    }
    
    private void setRoomStatus() {
        List<RoomModel> roomModels = new ArrayList<>(bookingInformation.getRoomsSchedule().keySet());
        
        for (int i = 0; i < roomModels.size(); i++) {
            roomStatus.add(roomModels.get(i).getStatus());
        }
    }
    
    private void customizeBookingInformationPane() {
        bookingInformationPane.setOpaque(false);
        bookingInformationPane.getViewport().setOpaque(false);
        bookingInformationPane.setBorder(null);
        bookingInformationPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        bookingInformationPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        bookingInformationPanel.setLayout(new GridLayout(0, rooms.size()));
        timePanel.setLayout(new GridLayout(0, 1));
    }
    
    private void showBookingInformation() {
        bookingInformation.showBookingSchedule(date);
        bookingInformation.showMaintenanceSchedule(date);
        customizeRoomCells();
        customizeTimeCells();
        customizeScheduleCells();
    }
    
    private void customizeRoomCells() {
        JLabel roomLabel;
        
        for (int i = 0; i < rooms.size(); i++) {
            roomLabel = new JLabel();
            customizeLabel(roomLabel);
            roomLabel.setBackground(Color.lightGray);
            roomLabel.setText(rooms.get(i));
            bookingInformationPanel.add(roomLabel);
        }
    }
    
    private void customizeTimeCells() {
        JLabel timeLabel;
        
        for (int i = 0; i < schedules.size(); i++) {
            timeLabel = new JLabel();
            
            timeLabel.setBackground(Color.lightGray);
            timeLabel.setPreferredSize(new Dimension(175, 30));
            timeLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
            timeLabel.setVerticalAlignment(SwingConstants.CENTER);
            timeLabel.setFont(new Font("Roboto", Font.PLAIN, 16));
            timeLabel.setOpaque(true);
            timeLabel.setText(schedules.get(i));
            timePanel.add(timeLabel);
        }
    }
    
    private void customizeScheduleCells() {
        JLabel scheduleLabel;
        
        for (int i = 0; i < schedules.size() - 1; i++) {
            for (int j = 0; j < rooms.size(); j++) {
                String roomName = rooms.get(j);
                List roomModuls = new ArrayList(bookingInformation.getRoomsSchedule().keySet());

                scheduleLabel = new JLabel();                
                customizeLabel(scheduleLabel);

                if (bookingInformation.getRoomsSchedule().get(roomModuls.get(j)).size() > 0) {
                    if (bookingInformation.getRoomsSchedule().get(roomModuls.get(j)).containsKey(i + 7)) {
                        if (bookingInformation.getRoomsSchedule().get(roomModuls.get(j)).get(i + 7).getClass().equals(BorrowingModel.class)) {
                            BorrowingModel borrowing = (BorrowingModel) bookingInformation.getRoomsSchedule().get(roomModuls.get(j)).get(i + 7);
                            scheduleLabel.setBackground(new Color(138, 199, 222));
                            scheduleLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                            scheduleLabel.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent mouseEvent) {
                                    BorrowingDetailFrame bookingDetailFrame = new BorrowingDetailFrame(borrowing, roomName);
                                    bookingDetailFrame.setVisible(true);
                                }
                            });
                        } else if (bookingInformation.getRoomsSchedule().get(roomModuls.get(j)).get(i + 7).getClass().equals(MaintenanceModel.class)) {
                            MaintenanceModel maintenance = (MaintenanceModel) bookingInformation.getRoomsSchedule().get(roomModuls.get(j)).get(i + 7);
                            scheduleLabel.setBackground(new Color(250, 127, 119));
                            scheduleLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                            scheduleLabel.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent mouseEvent) {
                                    MaintenanceDetailFrame maintenanceDetailFrame = new MaintenanceDetailFrame(maintenance, roomName);
                                    maintenanceDetailFrame.setVisible(true);
                                }
                            });
                        }
                    }
                }
                bookingInformationPanel.add(scheduleLabel);
            }
        }
    }
    
    private void customizeLabel(JLabel label) {
        label.setPreferredSize(new Dimension(175, 16));
        label.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Roboto", Font.PLAIN, 16));
        label.setOpaque(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane bookingInformationPane;
    private javax.swing.JPanel bookingInformationPanel;
    private javax.swing.JButton borrowingButton;
    private org.freixas.jcalendar.JCalendarCombo dateField;
    private javax.swing.JButton maintenanceButton;
    private javax.swing.JPanel timePanel;
    // End of variables declaration//GEN-END:variables
}
