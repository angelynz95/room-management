/**
 * Aplikasi Room Management
 * @author Irene Wiliudarsan - 13513002
 * @author William Sentosa - 13513026
 * @author Angela Lynn - 13513032
 * @author Devina Ekawati - 13513088
 */
package gui;

import java.awt.Color;
import borrowing.Borrowing;
import database.BorrowingModel;
import database.MaintenanceModel;
import database.RoomModel;
import java.awt.Dimension;
import java.awt.Toolkit;
import roominformation.RoomInformation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.UIManager;

/**
 *
 * @author angelynz95
 */
public class BorrowingFrame extends javax.swing.JFrame {
    /**
     * Creates new form BorrowingFrame
     */
    public BorrowingFrame(Calendar defaultDate) {
        initComponents();
        mainFrame = MainFrame.getInstance();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2 - 20);
        
        roomNameDropdown.setEnabled(true);
        startDateField.setDate(defaultDate.getTime());
        finishDateField.setDate(defaultDate.getTime());
        
        this.borrowingId = 0;
        textFields = new ArrayList<>();
        textFields.add(borrowerIdField);
        textFields.add(borrowerNameField);
        textFields.add(borrowerPhoneField);
        textFields.add(activityNameField);
        textFields.add(organizationNameField);
    }
    
    public BorrowingFrame(BorrowingModel model, String roomName) {
        initComponents();
        mainFrame = MainFrame.getInstance();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2 - 20);
        
        roomNameDropdown.setEnabled(false);
        this.borrowingId = model.getId();
        this.roomNameDropdown.setSelectedItem(roomName);
        
        textFields = new ArrayList<>();
        textFields.add(borrowerIdField);
        textFields.add(borrowerNameField);
        textFields.add(borrowerPhoneField);
        textFields.add(activityNameField);
        textFields.add(organizationNameField);
        
        Calendar startTime = model.getStartTime();
        this.startDateField.setDate(startTime.getTime());
        this.startTimeField.setValue(startTime.getTime());
        
        Calendar finishTime = model.getFinishTime();
        this.finishDateField.setDate(finishTime.getTime());
        this.finishTimeField.setValue(finishTime.getTime());
        
        this.borrowerIdField.setText(Integer.toString(model.getBorrowerId()));
        this.borrowerNameField.setText(model.getBorrowerName());
        this.borrowerAddressField.setText(model.getBorrowerAddress());
        this.borrowerPhoneField.setText(model.getBorrowerPhone());
        
        String borrowerStatus = model.getBorrowerStatus();
        for (Enumeration<AbstractButton> buttons = borrowerStatusButtonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.getText().equals(borrowerStatus)) {
                borrowerStatusButtonGroup.setSelected(button.getModel(), true);
            }
        }
        
        this.activityNameField.setText(model.getActivityName());
        this.organizationNameField.setText(model.getOrganizationName());
        this.totalParticipantField.setValue(model.getTotalParticipant());
        
        mainFrame = MainFrame.getInstance();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        borrowerStatusButtonGroup = new javax.swing.ButtonGroup();
        borrowerIdLabel = new javax.swing.JLabel();
        borrowerNameLabel = new javax.swing.JLabel();
        borrowerAddressLabel = new javax.swing.JLabel();
        borrowerPhoneLabel = new javax.swing.JLabel();
        borrowerStatusLabel = new javax.swing.JLabel();
        activityNameLabel = new javax.swing.JLabel();
        organizationNameLabel = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        totalParticipantLabel = new javax.swing.JLabel();
        borrowerIdField = new javax.swing.JTextField();
        borrowerNameField = new javax.swing.JTextField();
        borrowerPhoneField = new javax.swing.JTextField();
        activityNameField = new javax.swing.JTextField();
        organizationNameField = new javax.swing.JTextField();
        addBorrowingButton = new javax.swing.JButton();
        roomNameLabel = new javax.swing.JLabel();
        startDateField = new org.freixas.jcalendar.JCalendarCombo();
        startTimeField = new javax.swing.JSpinner(new SpinnerDateModel());
        finishDateField = new org.freixas.jcalendar.JCalendarCombo();
        finishTimeField = new javax.swing.JSpinner(new SpinnerDateModel());
        timeSeperatorLabel = new javax.swing.JLabel();
        borrowerTitleLabel = new javax.swing.JLabel();
        purposeTitleLabel = new javax.swing.JLabel();
        RoomInformation roomInformation = new RoomInformation();
        ArrayList<RoomModel> roomsModel = new ArrayList<RoomModel>();
        ArrayList<String> roomsName = new ArrayList<String>();
        roomsModel = roomInformation.fetchRoomData();
        for (int i = 0; i < roomsModel.size(); i++) {
            roomsName.add(roomsModel.get(i).getName());
        }
        roomNameDropdown = new javax.swing.JComboBox(roomsName.toArray());
        lecturerStatusButton = new javax.swing.JRadioButton();
        studentStatusButton = new javax.swing.JRadioButton();
        othersStatusButton = new javax.swing.JRadioButton();
        totalParticipantField = new javax.swing.JSpinner();
        peopleLabel = new javax.swing.JLabel();
        isWeeklyCheckBox = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        borrowerAddressField = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Penambahan Peminjaman Ruangan");
        setResizable(false);

        borrowerIdLabel.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        borrowerIdLabel.setText("NIM / NIP");

        borrowerNameLabel.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        borrowerNameLabel.setText("Nama");

        borrowerAddressLabel.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        borrowerAddressLabel.setText("Alamat");

        borrowerPhoneLabel.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        borrowerPhoneLabel.setText("No. Telepon");

        borrowerStatusLabel.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        borrowerStatusLabel.setText("Status");

        activityNameLabel.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        activityNameLabel.setText("Nama Kegiatan");

        organizationNameLabel.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        organizationNameLabel.setText("Nama Lembaga");

        timeLabel.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        timeLabel.setText("Waktu Peminjaman");

        totalParticipantLabel.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        totalParticipantLabel.setText("Jumlah Peserta");

        borrowerIdField.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        borrowerNameField.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        borrowerPhoneField.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        activityNameField.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        organizationNameField.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        addBorrowingButton.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        addBorrowingButton.setText("Simpan");
        addBorrowingButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addBorrowingButtonMouseClicked(evt);
            }
        });

        roomNameLabel.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        roomNameLabel.setText("Nama Ruangan");

        startDateField.setDateFormat(new SimpleDateFormat("dd/MM/yyyy"));
        startDateField.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        startTimeField.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        finishDateField.setDateFormat(new SimpleDateFormat("dd/MM/yyyy"));
        finishDateField.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        finishTimeField.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        timeSeperatorLabel.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        timeSeperatorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeSeperatorLabel.setText("-");
        timeSeperatorLabel.setAlignmentX(0.5F);

        borrowerTitleLabel.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        borrowerTitleLabel.setText("Data Peminjam");

        purposeTitleLabel.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        purposeTitleLabel.setText("Tujuan Peminjaman");

        roomNameDropdown.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        borrowerStatusButtonGroup.add(lecturerStatusButton);
        lecturerStatusButton.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lecturerStatusButton.setSelected(true);
        lecturerStatusButton.setText("Dosen");

        borrowerStatusButtonGroup.add(studentStatusButton);
        studentStatusButton.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        studentStatusButton.setText("Mahasiswa");

        borrowerStatusButtonGroup.add(othersStatusButton);
        othersStatusButton.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        othersStatusButton.setText("Lainnya");

        totalParticipantField.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        peopleLabel.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        peopleLabel.setText("orang");

        isWeeklyCheckBox.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        isWeeklyCheckBox.setText("Ulangi tiap minggu");

        borrowerAddressField.setColumns(20);
        borrowerAddressField.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        borrowerAddressField.setRows(2);
        jScrollPane1.setViewportView(borrowerAddressField);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(borrowerStatusLabel)
                                    .addComponent(borrowerPhoneLabel)
                                    .addComponent(borrowerNameLabel)
                                    .addComponent(borrowerIdLabel)
                                    .addComponent(borrowerAddressLabel)
                                    .addComponent(purposeTitleLabel)
                                    .addComponent(activityNameLabel)
                                    .addComponent(organizationNameLabel)
                                    .addComponent(totalParticipantLabel))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(organizationNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                                    .addComponent(activityNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(totalParticipantField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(peopleLabel))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lecturerStatusButton)
                                        .addGap(53, 53, 53)
                                        .addComponent(studentStatusButton)
                                        .addGap(42, 42, 42)
                                        .addComponent(othersStatusButton))
                                    .addComponent(borrowerIdField, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                                    .addComponent(borrowerNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                                    .addComponent(borrowerPhoneField, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(addBorrowingButton)
                                .addGap(2, 2, 2)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(timeLabel)
                                .addComponent(roomNameLabel))
                            .addGap(39, 39, 39)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(isWeeklyCheckBox)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(roomNameDropdown, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(startDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(startTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(timeSeperatorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(finishDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(finishTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addComponent(borrowerTitleLabel))
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(roomNameDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roomNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(timeSeperatorLabel)
                    .addComponent(startDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(finishDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(finishTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(isWeeklyCheckBox)
                .addGap(18, 18, 18)
                .addComponent(borrowerTitleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(borrowerIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(borrowerIdLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(borrowerNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(borrowerNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(borrowerAddressLabel)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(borrowerPhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(borrowerPhoneLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lecturerStatusButton)
                    .addComponent(studentStatusButton)
                    .addComponent(othersStatusButton)
                    .addComponent(borrowerStatusLabel))
                .addGap(18, 18, 18)
                .addComponent(purposeTitleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(activityNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(activityNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(organizationNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(organizationNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(totalParticipantField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalParticipantLabel)
                    .addComponent(peopleLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addBorrowingButton)
                .addGap(36, 36, 36))
        );

        javax.swing.JSpinner.DateEditor startTimeEditor = new javax.swing.JSpinner.DateEditor(startTimeField, "HH.mm");
        startTimeField.setEditor(startTimeEditor);

        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(new Date());
        startTimeField.setValue(new Date(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), calendar.get(Calendar.HOUR_OF_DAY), 0)); // Will only show the current time
        javax.swing.JSpinner.DateEditor finishTimeEditor = new javax.swing.JSpinner.DateEditor(finishTimeField, "HH.mm");
        finishTimeField.setEditor(finishTimeEditor);
        finishTimeField.setValue(new Date(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), calendar.get(Calendar.HOUR_OF_DAY), 0)); // Will only show the current time

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addBorrowingButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBorrowingButtonMouseClicked
        if (isDateValid()) {
            startDateField.setBorder(UIManager.getBorder("Spinner.border"));
            startTimeField.setBorder(UIManager.getBorder("Spinner.border"));
            finishDateField.setBorder(UIManager.getBorder("Spinner.border"));
            finishTimeField.setBorder(UIManager.getBorder("Spinner.border"));
        } else {
            startDateField.setBorder(BorderFactory.createLineBorder(Color.red));
            startTimeField.setBorder(BorderFactory.createLineBorder(Color.red));
            finishDateField.setBorder(BorderFactory.createLineBorder(Color.red));
            finishTimeField.setBorder(BorderFactory.createLineBorder(Color.red));
        }
        
        boolean isBorrowerIdValid = true;
        try {
            Long borrowerId = Long.parseLong(borrowerIdField.getText());
        } catch (NumberFormatException e) {
            isBorrowerIdValid = false;
        }
        if (isBorrowerIdValid) {
            borrowerIdField.setBorder(UIManager.getBorder("TextField.border"));
        } else {
            borrowerIdField.setBorder(BorderFactory.createLineBorder(Color.red));
        }
        
        boolean isBorrowerAddressValid = !borrowerAddressField.getText().isEmpty();
        if (isBorrowerAddressValid) {
            borrowerAddressField.setBorder(UIManager.getBorder("TextField.border"));
        } else {
            borrowerAddressField.setBorder(BorderFactory.createLineBorder(Color.red));
        }
        
        boolean isTextFieldValid = true;
        for(int i=0; i<textFields.size(); i++) {
            if (textFields.get(i).getText().isEmpty()) {
                isTextFieldValid = false;
                textFields.get(i).setBorder(BorderFactory.createLineBorder(Color.red));
            } else {
                textFields.get(i).setBorder(UIManager.getBorder("TextField.border"));
            }
        }
        
        if (isTotalParticipantValid()) {
            totalParticipantField.setBorder(UIManager.getBorder("Spinner.border"));
        } else {
            totalParticipantField.setBorder(BorderFactory.createLineBorder(Color.red));
        }
        
        if (isDateValid() && isBorrowerIdValid && isBorrowerAddressValid && isTextFieldValid && isTotalParticipantValid()) {
            sendToDatabase();
        }
    }//GEN-LAST:event_addBorrowingButtonMouseClicked
    
    private void sendToDatabase() {
        // Jika form valid
        Borrowing borrowing = new Borrowing();
        
        int id = borrowingId;
        int borrowerId = Integer.parseInt(borrowerIdField.getText());
        
        RoomInformation roomInformation = new RoomInformation();
        int roomId = roomInformation.searchRoomData(roomNameDropdown.getSelectedItem().toString()).get(0).getId();
        
        String borrowerName = borrowerNameField.getText();
        
        String borrowerStatus = "";
        for (Enumeration<AbstractButton> buttons = borrowerStatusButtonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                borrowerStatus = button.getText();
            }
        }
        
        String borrowerAddress = borrowerAddressField.getText();
        String borrowerPhone = borrowerPhoneField.getText();
        String organizationName = organizationNameField.getText();
        String activityName = activityNameField.getText();
        
        Calendar date = startDateField.getCalendar();
        Calendar time = Calendar.getInstance();
        time.setTime((Date) startTimeField.getValue());
        Calendar startTime = convertTimeToCalendar(date, time);

        date = finishDateField.getCalendar();
        time = Calendar.getInstance();
        time.setTime((Date) finishTimeField.getValue());
        Calendar finishTime = convertTimeToCalendar(date, time);
        int totalParticipant = Integer.parseInt(totalParticipantField.getValue().toString());
        BorrowingModel borrowingModel = new BorrowingModel(id, borrowerId, roomId, borrowerName, borrowerStatus, borrowerAddress,
                borrowerPhone, organizationName, activityName, totalParticipant, startTime, finishTime);

        ArrayList<BorrowingModel> clashBorrowing = new ArrayList<>();
        clashBorrowing = borrowing.getClashBorrowing(borrowingModel);

        ArrayList<MaintenanceModel> clashMaintenance = new ArrayList<>();
        clashMaintenance = borrowing.getClashMaintenance(borrowingModel);

        if ((clashBorrowing.size() > 0) || (clashMaintenance.size() > 0)) {
            ClashBookingFrame frame = new ClashBookingFrame();
            frame.setContentPane(new ClashBorrowingPanel(clashBorrowing, clashMaintenance));
            frame.setVisible(true);
        } else {
            if (borrowingId == 0) {
                if(isWeeklyCheckBox.isSelected()) {
                    borrowing.addWeeklyBorrowing(borrowingModel);
                } else {
                    borrowing.addBorrowing(borrowingModel);
                }
            } else {
                borrowing.editBorrowing(borrowingModel);
            }
            dispose();
            
            // Refresh tampilan organisasi jadwal
            JTabbedPane menuPane = (JTabbedPane) mainFrame.getContentPane().getComponent(0);
            JPanel bookingInformationPanel = (JPanel) menuPane.getComponentAt(0);
            bookingInformationPanel.removeAll();
            bookingInformationPanel.add(new BookingInformationPanel(new GregorianCalendar(borrowingModel.getStartTime().get(Calendar.YEAR), borrowingModel.getStartTime().get(Calendar.MONTH), borrowingModel.getStartTime().get(Calendar.DATE))));
            bookingInformationPanel.repaint();
            bookingInformationPanel.revalidate();
        }
    }
   
    private boolean isTotalParticipantValid() {
        int participantNumber = (int) totalParticipantField.getValue();
        
        RoomInformation roomInformation = new RoomInformation();
        int roomCapacity = roomInformation.searchRoomData(roomNameDropdown.getSelectedItem().toString()).get(0).getCapacity();
        return (0<participantNumber && participantNumber<=roomCapacity);
    }
    
    /**
     * Check whether user date and time input are valid or not.
     * Datetime will be valid if start date is earlier than now and
     * finish time is later than now.
     * 
     * @return true if date is valid
     */
    private boolean isDateValid() {
        Calendar date = startDateField.getCalendar();
        Calendar time = Calendar.getInstance();
        time.setTime((Date) startTimeField.getValue());
        int startHour = time.get(Calendar.HOUR_OF_DAY);
        Calendar startTime = convertTimeToCalendar(date, time);

        date = finishDateField.getCalendar();
        time = Calendar.getInstance();
        time.setTime((Date) finishTimeField.getValue());
        int finishHour = time.get(Calendar.HOUR_OF_DAY);
        Calendar finishTime = convertTimeToCalendar(date, time);
        
        Calendar nowTime = GregorianCalendar.getInstance();
        nowTime.setTime(new Date());
        
        boolean isDateTimeValid = nowTime.before(startTime) && startTime.before(finishTime);
        boolean isWorkingHourValid = (startHour>=7) && (finishHour<=23);
        if (isDateTimeValid && isWorkingHourValid) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Convert date and time to become one Calendar data type.
     * 
     * @param date date
     * @param time time
     * @return date and time in Calendar data type
     */
    private Calendar convertTimeToCalendar(Calendar date, Calendar time) {
        int year = date.get(Calendar.YEAR);
        int month = date.get(Calendar.MONTH);
        int day = date.get(Calendar.DATE);
        int hour = time.get(Calendar.HOUR_OF_DAY);
        int minute = time.get(Calendar.MINUTE);
        Calendar calendar = new GregorianCalendar(year, month, day, hour, minute);
        return calendar;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Windows look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BorrowingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BorrowingFrame(new GregorianCalendar()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField activityNameField;
    private javax.swing.JLabel activityNameLabel;
    private javax.swing.JButton addBorrowingButton;
    private javax.swing.JTextArea borrowerAddressField;
    private javax.swing.JLabel borrowerAddressLabel;
    private javax.swing.JTextField borrowerIdField;
    private javax.swing.JLabel borrowerIdLabel;
    private javax.swing.JTextField borrowerNameField;
    private javax.swing.JLabel borrowerNameLabel;
    private javax.swing.JTextField borrowerPhoneField;
    private javax.swing.JLabel borrowerPhoneLabel;
    private javax.swing.ButtonGroup borrowerStatusButtonGroup;
    private javax.swing.JLabel borrowerStatusLabel;
    private javax.swing.JLabel borrowerTitleLabel;
    private org.freixas.jcalendar.JCalendarCombo finishDateField;
    private javax.swing.JSpinner finishTimeField;
    private javax.swing.JCheckBox isWeeklyCheckBox;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton lecturerStatusButton;
    private javax.swing.JTextField organizationNameField;
    private javax.swing.JLabel organizationNameLabel;
    private javax.swing.JRadioButton othersStatusButton;
    private javax.swing.JLabel peopleLabel;
    private javax.swing.JLabel purposeTitleLabel;
    private javax.swing.JComboBox roomNameDropdown;
    private javax.swing.JLabel roomNameLabel;
    private org.freixas.jcalendar.JCalendarCombo startDateField;
    private javax.swing.JSpinner startTimeField;
    private javax.swing.JRadioButton studentStatusButton;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JLabel timeSeperatorLabel;
    private javax.swing.JSpinner totalParticipantField;
    private javax.swing.JLabel totalParticipantLabel;
    // End of variables declaration//GEN-END:variables

    private List<JTextField> textFields;
    private int borrowingId;
    private MainFrame mainFrame;
}
