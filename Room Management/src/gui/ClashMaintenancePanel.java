/**
 * Aplikasi Room Management
 *
 * @author Irene Wiliudarsan - 13513002
 * @author William Sentosa - 13513026
 * @author Angela Lynn - 13513032
 * @author Devina Ekawati - 13513088
 */
package gui;

import database.BorrowingModel;
import database.MaintenanceModel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import static javax.swing.BorderFactory.createEmptyBorder;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import maintenance.Maintenance;

public class ClashMaintenancePanel extends javax.swing.JPanel {
    
    private DefaultTableCellRenderer headerRenderer;
    private DefaultTableCellRenderer cellRenderer;
    private JTable clashBorrowingTable;
    private JTable clashMaintenanceTable;
    private List<List<Object>> clashBorrowingData;
    private List<List<Object>> clashMaintenanceData;
    private List<Object> clashBorrowingColoumn;
    private List<Object> clashMaintenanceColoumn;
    private MaintenanceModel maintenanceModel;
    private JPanel clashBorrowingPanel;
    private JPanel clashMaintenancePanel;
    private JScrollPane clashBorrowingScrollPane;
    private JScrollPane clashMaintenanceScrollPane;
    
    /**
     * Creates new form ClashMaintenancePanel
     */
    public ClashMaintenancePanel(ArrayList<BorrowingModel> clashBorrowing, ArrayList<MaintenanceModel> clashMaintenance) {
        initComponents();
        
        BoxLayout layoutPanel = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(layoutPanel);
        
        clashBorrowingData = new ArrayList<List<Object>>();
        clashMaintenanceData = new ArrayList<List<Object>>();
        clashBorrowingColoumn = new ArrayList<Object>();
        clashMaintenanceColoumn = new ArrayList<Object>();
        
        clashBorrowingPanel = new JPanel();
        BoxLayout layoutClashBorrowingPanel = new BoxLayout(clashBorrowingPanel, BoxLayout.Y_AXIS);
        clashBorrowingPanel.setLayout(layoutClashBorrowingPanel);
        clashMaintenancePanel = new JPanel();
        BoxLayout layoutClashMaintenancePanel = new BoxLayout(clashMaintenancePanel, BoxLayout.Y_AXIS);
        clashMaintenancePanel.setLayout(layoutClashMaintenancePanel);
        
        // Tabel Peminjaman yang bertabrakan
        setClashBorrowingColoumn();
        setClashBorrowingData(clashBorrowing);
        
        // Tabel Pemeliharaan yang bertabrakan
        setClashMaintenanceColoumn();
        setClashMaintenanceData(clashMaintenance);
        customizeTable();
        
        add(Box.createRigidArea(new Dimension(0,50)));
        if (clashBorrowingData.size() > 0) {
            JLabel clashBorrowingTitle = new JLabel("Peminjaman Ruangan yang Bertabrakan");
            clashBorrowingTitle.setFont(new Font("Roboto", Font.PLAIN, 20));
            clashBorrowingTitle.setAlignmentX(JComponent.CENTER_ALIGNMENT);
            clashBorrowingPanel.add(clashBorrowingTitle);
            clashBorrowingPanel.add(Box.createRigidArea(new Dimension(0,50)));
            showClashBorrowing();
            add(clashBorrowingPanel);
        }
        add(Box.createRigidArea(new Dimension(0,50)));
        if (clashMaintenanceData.size() > 0) {
            JLabel clashMaintenanceTitle = new JLabel("Pemeliharaan Ruangan yang Bertabrakan");
            clashMaintenanceTitle.setFont(new Font("Roboto", Font.PLAIN, 20));
            clashMaintenanceTitle.setAlignmentX(JComponent.CENTER_ALIGNMENT);
            clashBorrowingPanel.add(clashMaintenanceTitle);
            showClashMaintenance();
            add(clashMaintenancePanel);
        }
        add(Box.createRigidArea(new Dimension(0,50)));
    }
    
    private void setClashBorrowingColoumn() {
        clashBorrowingColoumn.add("Waktu Mulai Peminjaman");
        clashBorrowingColoumn.add("Waktu Selesai Peminjaman");
        clashBorrowingColoumn.add("Nama Peminjam");
        clashBorrowingColoumn.add("No. Telepon Peminjam");
    }
    
    private void setClashMaintenanceColoumn() {
        clashMaintenanceColoumn.add("Waktu Mulai Pemeliharan");
        clashMaintenanceColoumn.add("Waktu Selesai Pemeliharran");
        clashMaintenanceColoumn.add("Deskripsi Pemeliharaan");
    }
    
    private void setClashBorrowingData(ArrayList<BorrowingModel> clashBorrowing) {
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (int i = 0; i < clashBorrowing.size(); i++) {
            List<Object> temp = new ArrayList<Object>();
            temp.add(sdf.format(clashBorrowing.get(i).getStartTime().getTime()));
            temp.add(sdf.format(clashBorrowing.get(i).getFinishTime().getTime()));
            temp.add(clashBorrowing.get(i).getBorrowerName());
            temp.add(clashBorrowing.get(i).getBorrowerPhone());
            clashBorrowingData.add(temp);
        }
    }
    
    private void setClashMaintenanceData(ArrayList<MaintenanceModel> clashMaintenance) {
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (int i = 0; i < clashMaintenance.size(); i++) {
            List<Object> temp = new ArrayList<Object>();
            temp.add(sdf.format(clashMaintenance.get(i).getStartTime().getTime()));
            temp.add(sdf.format(clashMaintenance.get(i).getFinishTime().getTime()));
            temp.add(clashMaintenance.get(i).getDescription());
            clashMaintenanceData.add(temp);
        }
    }
    
    private void showClashBorrowing() {
        Object[] temp1 = new Object[clashBorrowingColoumn.size()];
        Object[][] temp2 = new Object[clashBorrowingData.size()][clashBorrowingColoumn.size()];
        ArrayList<Object[]> rows = new ArrayList<Object[]>();
        for (List<Object> datum : clashBorrowingData) {
            rows.add((Object[]) datum.toArray());
        }
        
        clashBorrowingTable = new JTable(rows.toArray(temp2), clashBorrowingColoumn.toArray(temp1));
        clashBorrowingTable.setOpaque(false);
        clashBorrowingTable.setEnabled(false);
        clashBorrowingTable.getTableHeader().setReorderingAllowed(false);
        // Menerapkan customization tabel
        clashBorrowingTable.getTableHeader().setDefaultRenderer(headerRenderer);
        for (int i = 0; i < clashBorrowingTable.getColumnCount(); i++) {
            clashBorrowingTable.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }
        // Mengatur font
        clashBorrowingTable.setFont(new Font("Roboto", Font.PLAIN, 16));
        clashBorrowingScrollPane = new JScrollPane(clashBorrowingTable);
        clashBorrowingScrollPane.setOpaque(false);
        clashBorrowingScrollPane.getViewport().setOpaque(false);
        clashBorrowingScrollPane.setBorder(createEmptyBorder());
        clashBorrowingPanel.add(clashBorrowingScrollPane);
    }
    
    private void showClashMaintenance() {
        Object[] temp1 = new Object[clashMaintenanceColoumn.size()];
        Object[][] temp2 = new Object[clashMaintenanceData.size()][clashMaintenanceColoumn.size()];
        ArrayList<Object[]> rows = new ArrayList<Object[]>();
        for (List<Object> datum : clashMaintenanceData) {
            rows.add((Object[]) datum.toArray());
        }
        
        clashMaintenanceTable = new JTable(rows.toArray(temp2), clashMaintenanceColoumn.toArray(temp1));
        clashMaintenanceTable.setOpaque(false);
        clashMaintenanceTable.setEnabled(false);
        clashMaintenanceTable.getTableHeader().setReorderingAllowed(false);
        // Menerapkan customization tabel
        clashMaintenanceTable.getTableHeader().setDefaultRenderer(headerRenderer);
        for (int i = 0; i < clashMaintenanceTable.getColumnCount(); i++) {
            clashMaintenanceTable.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }
        // Mengatur font
        clashMaintenanceTable.setFont(new Font("Roboto", Font.PLAIN, 16));
        clashMaintenanceScrollPane = new JScrollPane(clashMaintenanceTable);
        clashMaintenanceScrollPane.setOpaque(false);
        clashMaintenanceScrollPane.getViewport().setOpaque(false);
        clashMaintenanceScrollPane.setBorder(createEmptyBorder());
        
        clashMaintenancePanel.add(clashMaintenanceScrollPane);
    }
    
    private void customizeTable() {
        headerRenderer = new DefaultTableCellRenderer();
        cellRenderer = new DefaultTableCellRenderer();
        // Membuat alignment center
        cellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        cellRenderer.setVerticalAlignment(SwingConstants.CENTER);
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        headerRenderer.setVerticalAlignment(SwingConstants.CENTER);
        // Membuat warna berbeda pada header
        headerRenderer.setBackground(Color.lightGray);
        cellRenderer.setOpaque(false);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setPreferredSize(new java.awt.Dimension(836, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    
    public static void main(String[] args) {
        ClashBookingFrame frame = new ClashBookingFrame();
        Maintenance maintenance = new Maintenance();
        int idMaintenance = 5;
        int roomId = 1;
        String description = "Papan tulis rusak";
        Calendar startTime = new GregorianCalendar(2016, 1, 23, 13, 30);
        Calendar finishTime = new GregorianCalendar(2016, 1, 23, 18, 30);
        MaintenanceModel maintenanceModel = new MaintenanceModel(idMaintenance, roomId, description, startTime, finishTime);
        
        ArrayList<BorrowingModel> clashBorrowing = new ArrayList<>();
        clashBorrowing = maintenance.getClashBorrowing(maintenanceModel);

        ArrayList<MaintenanceModel> clashMaintenance = new ArrayList<>();
        clashMaintenance = maintenance.getClashMaintenance(maintenanceModel);
        frame.setContentPane(new ClashMaintenancePanel(clashBorrowing, clashMaintenance));
        frame.setVisible(true);
    }
}
