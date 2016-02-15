/**
 * Aplikasi Room Management
 * @author Irene Wiliudarsan - 13513002
 * @author William Sentosa - 13513026
 * @author Angela Lynn - 13513032
 * @author Devina Ekawati - 13513088
 */
package gui;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.SpinnerDateModel;

/**
 *
 * @author angelynz95
 */
public class BorrowingFrame extends javax.swing.JFrame {

    /**
     * Creates new form BorrowingFrame
     */
    public BorrowingFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        borrowerAddressField = new javax.swing.JTextField();
        borrowerPhoneField = new javax.swing.JTextField();
        activityNameField = new javax.swing.JTextField();
        organizationNameField = new javax.swing.JTextField();
        addBorrowingButton = new javax.swing.JButton();
        roomNameLabel = new javax.swing.JLabel();
        startTimeField = new javax.swing.JSpinner(new SpinnerDateModel());
        finishTimeField = new javax.swing.JSpinner(new SpinnerDateModel());
        timeSeperatorLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        roomNameDropdown = new javax.swing.JComboBox();
        lecturerStatusButton = new javax.swing.JRadioButton();
        studentStatusButton = new javax.swing.JRadioButton();
        othersStatusButton = new javax.swing.JRadioButton();
        jSpinner1 = new javax.swing.JSpinner();
        totalParticipantLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        borrowerAddressField.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        borrowerPhoneField.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        activityNameField.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        organizationNameField.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        addBorrowingButton.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        addBorrowingButton.setText("Simpan");

        roomNameLabel.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        roomNameLabel.setText("Nama Ruangan");

        startTimeField.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        finishTimeField.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        timeSeperatorLabel.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        timeSeperatorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeSeperatorLabel.setText("-");
        timeSeperatorLabel.setAlignmentX(0.5F);

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel3.setText("Data Peminjam");

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel4.setText("Tujuan Peminjaman");

        roomNameDropdown.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        roomNameDropdown.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lecturerStatusButton.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lecturerStatusButton.setText("Dosen");

        studentStatusButton.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        studentStatusButton.setText("Mahasiswa");

        othersStatusButton.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        othersStatusButton.setText("Lainnya");

        jSpinner1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        totalParticipantLabel1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        totalParticipantLabel1.setText("orang");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(borrowerStatusLabel)
                            .addComponent(borrowerPhoneLabel)
                            .addComponent(borrowerNameLabel)
                            .addComponent(borrowerIdLabel)
                            .addComponent(borrowerAddressLabel)
                            .addComponent(jLabel4)
                            .addComponent(activityNameLabel)
                            .addComponent(organizationNameLabel)
                            .addComponent(totalParticipantLabel)
                            .addComponent(timeLabel)
                            .addComponent(roomNameLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(organizationNameField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(activityNameField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totalParticipantLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lecturerStatusButton)
                                .addGap(53, 53, 53)
                                .addComponent(studentStatusButton)
                                .addGap(42, 42, 42)
                                .addComponent(othersStatusButton))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(borrowerIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(borrowerNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(borrowerAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(borrowerPhoneField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(roomNameDropdown, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(109, 109, 109)
                                    .addComponent(startTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
<<<<<<< HEAD
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(115, 115, 115)
=======
                                    .addComponent(timeSeperatorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(finishDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
>>>>>>> 5c9848aa9c52473147be303e23861df40573dfc8
                                    .addComponent(finishTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addBorrowingButton)
                .addGap(38, 38, 38))
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
<<<<<<< HEAD
                    .addComponent(jLabel2)
=======
                    .addComponent(timeSeperatorLabel)
                    .addComponent(startDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
>>>>>>> 5c9848aa9c52473147be303e23861df40573dfc8
                    .addComponent(startTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(finishTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timeLabel))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(borrowerIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(borrowerIdLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(borrowerNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(borrowerNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(borrowerAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(borrowerAddressLabel))
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
                .addComponent(jLabel4)
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
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalParticipantLabel)
                    .addComponent(totalParticipantLabel1))
                .addGap(18, 18, 18)
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

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
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
                new BorrowingFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField activityNameField;
    private javax.swing.JLabel activityNameLabel;
    private javax.swing.JButton addBorrowingButton;
    private javax.swing.JTextField borrowerAddressField;
    private javax.swing.JLabel borrowerAddressLabel;
    private javax.swing.JTextField borrowerIdField;
    private javax.swing.JLabel borrowerIdLabel;
    private javax.swing.JTextField borrowerNameField;
    private javax.swing.JLabel borrowerNameLabel;
    private javax.swing.JTextField borrowerPhoneField;
    private javax.swing.JLabel borrowerPhoneLabel;
    private javax.swing.JLabel borrowerStatusLabel;
    private javax.swing.JSpinner finishTimeField;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JRadioButton lecturerStatusButton;
    private javax.swing.JTextField organizationNameField;
    private javax.swing.JLabel organizationNameLabel;
    private javax.swing.JRadioButton othersStatusButton;
    private javax.swing.JComboBox roomNameDropdown;
    private javax.swing.JLabel roomNameLabel;
    private javax.swing.JSpinner startTimeField;
    private javax.swing.JRadioButton studentStatusButton;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JLabel timeSeperatorLabel;
    private javax.swing.JLabel totalParticipantLabel;
    private javax.swing.JLabel totalParticipantLabel1;
    // End of variables declaration//GEN-END:variables
}
