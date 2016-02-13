/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.JPanel;

/**
 *
 * @author angelynz95
 */
public class MenuPanel extends javax.swing.JPanel {

    /**
     * Creates new form MainPanel
     */
    public MenuPanel() {
        initComponents();
        // Tampilan Organisasi Jadwal
        bookingInformationPanel.setLayout(new FlowLayout());
        bookingInformationPanel.add(new BookingInformation());
        // Tampilan Info Ruangan
        roomInformationPanel.setLayout(new FlowLayout());
        roomInformationPanel.add(new RoomInformation());
        // Tampilan Statistik
        statisticPanel.setLayout(new FlowLayout());
        statisticPanel.add(new StatisticPanel());
        // Tampilan Ubah Kata Sandi
        changePasswordPanel.setLayout(new FlowLayout());
        changePasswordPanel.add(new ChangePasswordPanel());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuPane = new javax.swing.JTabbedPane();
        bookingInformationPanel = new javax.swing.JPanel();
        roomInformationPanel = new javax.swing.JPanel();
        statisticPanel = new javax.swing.JPanel();
        changePasswordPanel = new javax.swing.JPanel();
        logoutLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1200, 700));

        menuPane.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        menuPane.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N

        javax.swing.GroupLayout bookingInformationPanelLayout = new javax.swing.GroupLayout(bookingInformationPanel);
        bookingInformationPanel.setLayout(bookingInformationPanelLayout);
        bookingInformationPanelLayout.setHorizontalGroup(
            bookingInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1195, Short.MAX_VALUE)
        );
        bookingInformationPanelLayout.setVerticalGroup(
            bookingInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 626, Short.MAX_VALUE)
        );

        menuPane.addTab("Organisasi Jadwal", bookingInformationPanel);

        javax.swing.GroupLayout roomInformationPanelLayout = new javax.swing.GroupLayout(roomInformationPanel);
        roomInformationPanel.setLayout(roomInformationPanelLayout);
        roomInformationPanelLayout.setHorizontalGroup(
            roomInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1195, Short.MAX_VALUE)
        );
        roomInformationPanelLayout.setVerticalGroup(
            roomInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 626, Short.MAX_VALUE)
        );

        menuPane.addTab("Info Ruangan", roomInformationPanel);

        javax.swing.GroupLayout statisticPanelLayout = new javax.swing.GroupLayout(statisticPanel);
        statisticPanel.setLayout(statisticPanelLayout);
        statisticPanelLayout.setHorizontalGroup(
            statisticPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1195, Short.MAX_VALUE)
        );
        statisticPanelLayout.setVerticalGroup(
            statisticPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 626, Short.MAX_VALUE)
        );

        menuPane.addTab("Statistik", statisticPanel);

        javax.swing.GroupLayout changePasswordPanelLayout = new javax.swing.GroupLayout(changePasswordPanel);
        changePasswordPanel.setLayout(changePasswordPanelLayout);
        changePasswordPanelLayout.setHorizontalGroup(
            changePasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1195, Short.MAX_VALUE)
        );
        changePasswordPanelLayout.setVerticalGroup(
            changePasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 626, Short.MAX_VALUE)
        );

        menuPane.addTab("Ubah Kata Sandi", changePasswordPanel);

        logoutLabel.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        logoutLabel.setText("Keluar");

        titleLabel.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        titleLabel.setText("Room Management");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuPane)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutLabel)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logoutLabel)
                    .addComponent(titleLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(menuPane, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bookingInformationPanel;
    private javax.swing.JPanel changePasswordPanel;
    private javax.swing.JLabel logoutLabel;
    private javax.swing.JTabbedPane menuPane;
    private javax.swing.JPanel roomInformationPanel;
    private javax.swing.JPanel statisticPanel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
