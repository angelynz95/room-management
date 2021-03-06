/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import borrowing.Borrowing;
import database.BorrowingModel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class BorrowingDetailFrame extends javax.swing.JFrame {
    
    private BorrowingModel borrowingModel;
    private MainFrame mainFrame;
    private String roomName;
    private Borrowing borrowing;
     
    public BorrowingDetailFrame(BorrowingModel borrowingModel, String roomName) {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2 - 20);
        
        this.borrowingModel = borrowingModel;
        mainFrame = MainFrame.getInstance();
        this.roomName = roomName;
        borrowing = new Borrowing();
        setComponent();
    }

    private void setComponent() {
        jumlahPesertaLabel.setText(Integer.toString(borrowingModel.getTotalParticipant()));
        namaKegiatanLabel.setText(borrowingModel.getActivityName());
        namaLembagaLabel.setText(borrowingModel.getOrganizationName());
        namaPeminjamLabel.setText(borrowingModel.getBorrowerName());
        namaRuanganLabel.setText(roomName);
        noTelpLabel.setText(borrowingModel.getBorrowerPhone());
        statusPeminjamLabel.setText(borrowingModel.getBorrowerStatus());
        waktuIzinLabel.setText(borrowingModel.getPermissionTime().getTime().toString());
        waktuMulaiLabel.setText(borrowingModel.getStartTime().getTime().toString());
        waktuSelesaiLabel.setText(borrowingModel.getFinishTime().getTime().toString());
        idPeminjamLabel.setText(Long.toString(borrowingModel.getBorrowerId()));
        alamatLabel.setText(borrowingModel.getBorrowerAddress());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        borrowingDetailLabel = new javax.swing.JLabel();
        roomNameLabel = new javax.swing.JLabel();
        borrowerNameLabel = new javax.swing.JLabel();
        borrowerStatusLabel = new javax.swing.JLabel();
        borrowerIdLabel = new javax.swing.JLabel();
        borrowerAddressLabel = new javax.swing.JLabel();
        borrowerPhoneLabel = new javax.swing.JLabel();
        organizationNameLabel = new javax.swing.JLabel();
        activityNameLabel = new javax.swing.JLabel();
        totalParticipantLabel = new javax.swing.JLabel();
        permissionTimeLabel = new javax.swing.JLabel();
        startTimeLabel = new javax.swing.JLabel();
        finishTimeLabel = new javax.swing.JLabel();
        deleteButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        namaRuanganLabel = new javax.swing.JLabel();
        namaPeminjamLabel = new javax.swing.JLabel();
        statusPeminjamLabel = new javax.swing.JLabel();
        alamatLabel = new javax.swing.JLabel();
        idPeminjamLabel = new javax.swing.JLabel();
        noTelpLabel = new javax.swing.JLabel();
        namaKegiatanLabel = new javax.swing.JLabel();
        namaLembagaLabel = new javax.swing.JLabel();
        jumlahPesertaLabel = new javax.swing.JLabel();
        waktuMulaiLabel = new javax.swing.JLabel();
        waktuSelesaiLabel = new javax.swing.JLabel();
        waktuIzinLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        borrowingDetailLabel.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        borrowingDetailLabel.setText("Detail Peminjaman");

        roomNameLabel.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        roomNameLabel.setText("Nama Ruangan ");

        borrowerNameLabel.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        borrowerNameLabel.setText("Nama Peminjam ");

        borrowerStatusLabel.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        borrowerStatusLabel.setText("Status Peminjam ");

        borrowerIdLabel.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        borrowerIdLabel.setText("NIM / NIP ");

        borrowerAddressLabel.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        borrowerAddressLabel.setText("Alamat Peminjam ");

        borrowerPhoneLabel.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        borrowerPhoneLabel.setText("Nomor Telepon Peminjam ");

        organizationNameLabel.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        organizationNameLabel.setText("Nama Lembaga");

        activityNameLabel.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        activityNameLabel.setText("Nama Kegiatan");

        totalParticipantLabel.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        totalParticipantLabel.setText("Jumlah Peserta");

        permissionTimeLabel.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        permissionTimeLabel.setText("Waktu izin");

        startTimeLabel.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        startTimeLabel.setText("Waktu mulai");

        finishTimeLabel.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        finishTimeLabel.setText("Waktu selesai");

        deleteButton.setText("Hapus");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        editButton.setText("Ubah");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        namaRuanganLabel.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        namaPeminjamLabel.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        statusPeminjamLabel.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        alamatLabel.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        idPeminjamLabel.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        noTelpLabel.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        namaKegiatanLabel.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        namaLembagaLabel.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        jumlahPesertaLabel.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        waktuMulaiLabel.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        waktuSelesaiLabel.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        waktuIzinLabel.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(deleteButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(borrowingDetailLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(borrowerPhoneLabel)
                            .addComponent(borrowerAddressLabel)
                            .addComponent(borrowerStatusLabel)
                            .addComponent(borrowerNameLabel)
                            .addComponent(roomNameLabel)
                            .addComponent(borrowerIdLabel)
                            .addComponent(organizationNameLabel)
                            .addComponent(activityNameLabel)
                            .addComponent(totalParticipantLabel)
                            .addComponent(permissionTimeLabel)
                            .addComponent(startTimeLabel)
                            .addComponent(finishTimeLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(namaRuanganLabel)
                            .addComponent(namaPeminjamLabel)
                            .addComponent(statusPeminjamLabel)
                            .addComponent(alamatLabel)
                            .addComponent(idPeminjamLabel)
                            .addComponent(noTelpLabel)
                            .addComponent(namaKegiatanLabel)
                            .addComponent(namaLembagaLabel)
                            .addComponent(jumlahPesertaLabel)
                            .addComponent(waktuMulaiLabel)
                            .addComponent(waktuSelesaiLabel)
                            .addComponent(waktuIzinLabel))))
                .addContainerGap(163, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(borrowingDetailLabel)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roomNameLabel)
                    .addComponent(namaRuanganLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(borrowerNameLabel)
                    .addComponent(namaPeminjamLabel))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(borrowerStatusLabel)
                    .addComponent(statusPeminjamLabel))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(borrowerIdLabel)
                    .addComponent(idPeminjamLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(borrowerAddressLabel)
                    .addComponent(alamatLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(borrowerPhoneLabel)
                    .addComponent(noTelpLabel))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(organizationNameLabel)
                    .addComponent(namaLembagaLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(activityNameLabel)
                    .addComponent(namaKegiatanLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalParticipantLabel)
                    .addComponent(jumlahPesertaLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(permissionTimeLabel)
                    .addComponent(waktuIzinLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(startTimeLabel)
                    .addComponent(waktuMulaiLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(finishTimeLabel)
                    .addComponent(waktuSelesaiLabel))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteButton)
                    .addComponent(editButton))
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        String message = "Apakah Anda yakin ingin menghapus jadwal ini?";
        String title = "Konfirmasi Penghapusan";
        Object[] options = {"Ya", "Tidak"};
        int answerId = JOptionPane.showOptionDialog(null, message, title, JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[1]);
        if (options[answerId].equals("Ya")) {
            borrowing.deleteBorrowing(borrowingModel);
        }
        
        // Refresh tampilan organisasi jadwal
        JTabbedPane menuPane = (JTabbedPane) mainFrame.getContentPane().getComponent(0);
        JPanel bookingInformationPanel = (JPanel) menuPane.getComponentAt(0);
        bookingInformationPanel.removeAll();
        bookingInformationPanel.add(new BookingInformationPanel(new GregorianCalendar(borrowingModel.getStartTime().get(Calendar.YEAR), borrowingModel.getStartTime().get(Calendar.MONTH), borrowingModel.getStartTime().get(Calendar.DATE))));
        bookingInformationPanel.repaint();
        bookingInformationPanel.revalidate();
        
        this.dispose();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        BorrowingFrame borrowingFrame = new BorrowingFrame(borrowingModel, roomName);
        borrowingFrame.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_editButtonActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BorrowingDetailFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BorrowingDetailFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BorrowingDetailFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BorrowingDetailFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Borrowing b = new Borrowing();
                new BorrowingDetailFrame(b.searchBorrowingById(8), "R 7606").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel activityNameLabel;
    private javax.swing.JLabel alamatLabel;
    private javax.swing.JLabel borrowerAddressLabel;
    private javax.swing.JLabel borrowerIdLabel;
    private javax.swing.JLabel borrowerNameLabel;
    private javax.swing.JLabel borrowerPhoneLabel;
    private javax.swing.JLabel borrowerStatusLabel;
    private javax.swing.JLabel borrowingDetailLabel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel finishTimeLabel;
    private javax.swing.JLabel idPeminjamLabel;
    private javax.swing.JLabel jumlahPesertaLabel;
    private javax.swing.JLabel namaKegiatanLabel;
    private javax.swing.JLabel namaLembagaLabel;
    private javax.swing.JLabel namaPeminjamLabel;
    private javax.swing.JLabel namaRuanganLabel;
    private javax.swing.JLabel noTelpLabel;
    private javax.swing.JLabel organizationNameLabel;
    private javax.swing.JLabel permissionTimeLabel;
    private javax.swing.JLabel roomNameLabel;
    private javax.swing.JLabel startTimeLabel;
    private javax.swing.JLabel statusPeminjamLabel;
    private javax.swing.JLabel totalParticipantLabel;
    private javax.swing.JLabel waktuIzinLabel;
    private javax.swing.JLabel waktuMulaiLabel;
    private javax.swing.JLabel waktuSelesaiLabel;
    // End of variables declaration//GEN-END:variables
}
