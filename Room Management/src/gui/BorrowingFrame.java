/**
 * Aplikasi Room Management
 * @author Irene Wiliudarsan - 13513002
 * @author William Sentosa - 13513026
 * @author Angela Lynn - 13513032
 * @author Devina Ekawati - 13513088
 */
package gui;

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
        borrowerStatusField = new javax.swing.JTextField();
        activityNameField = new javax.swing.JTextField();
        organizationNameField = new javax.swing.JTextField();
        startTimeField = new javax.swing.JTextField();
        endTimeField = new javax.swing.JTextField();
        totalParticipantField = new javax.swing.JTextField();
        addBorrowingButton = new javax.swing.JButton();
        stripLabel = new javax.swing.JLabel();
        roomNameLabel = new javax.swing.JLabel();
        roomNameField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Borrowing Form");
        setResizable(false);

        borrowerIdLabel.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        borrowerIdLabel.setText("NIM / NIP");

        borrowerNameLabel.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        borrowerNameLabel.setText("Nama Peminjam");

        borrowerAddressLabel.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        borrowerAddressLabel.setText("Alamat Peminjam");

        borrowerPhoneLabel.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        borrowerPhoneLabel.setText("No. Telepon Peminjam");

        borrowerStatusLabel.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        borrowerStatusLabel.setText("Status Peminjam");

        activityNameLabel.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        activityNameLabel.setText("Nama Kegiatan");

        organizationNameLabel.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        organizationNameLabel.setText("Nama Lembaga");

        timeLabel.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        timeLabel.setText("Waktu Peminjaman");

        totalParticipantLabel.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        totalParticipantLabel.setText("Jumlah Peserta");

        borrowerIdField.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N

        borrowerNameField.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N

        borrowerAddressField.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N

        borrowerPhoneField.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N

        borrowerStatusField.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N

        activityNameField.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N

        organizationNameField.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N

        startTimeField.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N

        endTimeField.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N

        totalParticipantField.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N

        addBorrowingButton.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        addBorrowingButton.setText("Simpan");

        stripLabel.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        stripLabel.setText("-");

        roomNameLabel.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        roomNameLabel.setText("Nama Ruangan");

        roomNameField.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roomNameLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(borrowerPhoneLabel)
                            .addComponent(borrowerAddressLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(borrowerNameLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(borrowerIdLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(borrowerStatusLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(activityNameLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(organizationNameLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(timeLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(totalParticipantLabel, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(borrowerAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(borrowerNameField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(borrowerIdField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(borrowerPhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(borrowerStatusField, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(addBorrowingButton)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(startTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(stripLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(endTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(organizationNameField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(activityNameField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(totalParticipantField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(roomNameField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(55, 55, 55))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(borrowerIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(borrowerIdLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(borrowerNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(borrowerNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(borrowerAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(borrowerAddressLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(borrowerPhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(borrowerPhoneLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(borrowerStatusField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(borrowerStatusLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(activityNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(activityNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(organizationNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(organizationNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roomNameLabel)
                    .addComponent(roomNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timeLabel)
                    .addComponent(stripLabel)
                    .addComponent(endTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalParticipantLabel)
                    .addComponent(totalParticipantField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(addBorrowingButton)
                .addGap(40, 40, 40))
        );

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BorrowingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BorrowingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BorrowingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
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
    private javax.swing.JTextField borrowerStatusField;
    private javax.swing.JLabel borrowerStatusLabel;
    private javax.swing.JTextField endTimeField;
    private javax.swing.JTextField organizationNameField;
    private javax.swing.JLabel organizationNameLabel;
    private javax.swing.JTextField roomNameField;
    private javax.swing.JLabel roomNameLabel;
    private javax.swing.JTextField startTimeField;
    private javax.swing.JLabel stripLabel;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JTextField totalParticipantField;
    private javax.swing.JLabel totalParticipantLabel;
    // End of variables declaration//GEN-END:variables
}
