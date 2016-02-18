/**
 * Aplikasi Room Management
 * @author Irene Wiliudarsan - 13513002
 * @author William Sentosa - 13513026
 * @author Angela Lynn - 13513032
 * @author Devina Ekawati - 13513088
 */
package gui;

import statistic.Statistic;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author angelynz95
 */
public class StatisticPanel extends javax.swing.JPanel {
    private DefaultTableCellRenderer headerRenderer;
    private DefaultTableCellRenderer cellRenderer;
    private JTable roomBrokenFrequencyStatistic;
    private JTable roomUsedStatistic;
    private List<List<Object>> roomBorrowedFrequencyData;
    private List<List<Object>> roomBrokenFrequencyData;
    private List<List<Object>> roomUsedData;
    private List<Object> roomBorrowedFrequencyColumns;
    private List<Object> roomBrokenFrequencyColumns;
    private List<Object> roomUsedColumns;
    private MainFrame frame;
    private Statistic statistic;

    /**
     * Creates new form StatisticPanel
     */
    public StatisticPanel() {
        initComponents();
        customizeScrollPane();
        statistic = new Statistic();
        frame = MainFrame.getInstance();
        // Inisialisasi kolom frekuensi peminjaman ruangan
        roomBorrowedFrequencyColumns = new ArrayList<Object>();
        // Inisialisasi kolom frekuensi kerusakan ruangan
        roomBrokenFrequencyColumns = new ArrayList<Object>();
        // Inisialisasi penggunaan ruangan oleh kelompok user tertentu
        roomUsedColumns = new ArrayList<Object>();
        // Inisialisasi data statistik
        roomBorrowedFrequencyData = new ArrayList<List<Object>>();
        roomBrokenFrequencyData = new ArrayList<List<Object>>();
        roomUsedData = new ArrayList<List<Object>>();
        // Menampilkan statistik
        setRoomBorrowedFrequencyColumns();
        setRoomBrokenFrequencyColumns();
        setRoomUsedColumns();
        setRoomBorrowedFrequencyData();
        setRoomBrokenFrequencyData();
        setRoomUsedData();
        customizeTable();
        showRoomBorrowedFrequencyStatistic();
        showRoomBrokenFrequencyStatistic();
        showRoomUsedStatistic();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        statisticPane = new javax.swing.JTabbedPane();
        roomBorrowedFrequencyPanel = new javax.swing.JPanel();
        roomBorrowedFrequencyPane = new javax.swing.JScrollPane();
        roomBrokenFrequencyPanel = new javax.swing.JPanel();
        roomBrokenFrequencyPane = new javax.swing.JScrollPane();
        roomUsedPanel = new javax.swing.JPanel();
        roomUsedPane = new javax.swing.JScrollPane();

        statisticPane.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N

        roomBorrowedFrequencyPane.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        roomBorrowedFrequencyPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        roomBorrowedFrequencyPane.setOpaque(false);

        javax.swing.GroupLayout roomBorrowedFrequencyPanelLayout = new javax.swing.GroupLayout(roomBorrowedFrequencyPanel);
        roomBorrowedFrequencyPanel.setLayout(roomBorrowedFrequencyPanelLayout);
        roomBorrowedFrequencyPanelLayout.setHorizontalGroup(
            roomBorrowedFrequencyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roomBorrowedFrequencyPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1190, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        roomBorrowedFrequencyPanelLayout.setVerticalGroup(
            roomBorrowedFrequencyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roomBorrowedFrequencyPane, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        statisticPane.addTab("Frekuensi Penggunaan Ruang", roomBorrowedFrequencyPanel);

        roomBrokenFrequencyPane.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout roomBrokenFrequencyPanelLayout = new javax.swing.GroupLayout(roomBrokenFrequencyPanel);
        roomBrokenFrequencyPanel.setLayout(roomBrokenFrequencyPanelLayout);
        roomBrokenFrequencyPanelLayout.setHorizontalGroup(
            roomBrokenFrequencyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roomBrokenFrequencyPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1190, Short.MAX_VALUE)
        );
        roomBrokenFrequencyPanelLayout.setVerticalGroup(
            roomBrokenFrequencyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roomBrokenFrequencyPane, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
        );

        statisticPane.addTab("Frekuensi Kerusakan Ruang", roomBrokenFrequencyPanel);

        roomUsedPane.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout roomUsedPanelLayout = new javax.swing.GroupLayout(roomUsedPanel);
        roomUsedPanel.setLayout(roomUsedPanelLayout);
        roomUsedPanelLayout.setHorizontalGroup(
            roomUsedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roomUsedPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1190, Short.MAX_VALUE)
        );
        roomUsedPanelLayout.setVerticalGroup(
            roomUsedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roomUsedPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
        );

        statisticPane.addTab("Penggunaan Ruang oleh Kelompok Pengguna", roomUsedPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statisticPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statisticPane)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void setRoomBorrowedFrequencyColumns() {
        roomBorrowedFrequencyColumns.add("Nama Ruangan");
        roomBorrowedFrequencyColumns.add("Frekuensi Peminjaman");
    }
    
    private void setRoomBrokenFrequencyColumns() {
        roomBrokenFrequencyColumns.add("Nama Ruangan");
        roomBrokenFrequencyColumns.add("Frekuensi Pemeliharaan");
    }
    
    private void setRoomUsedColumns() {
        roomUsedColumns.add("Nama Lembaga");
        roomUsedColumns.add("Frekuensi Peminjaman");
    }
    
    private void setRoomBorrowedFrequencyData() {
        roomBorrowedFrequencyData = new ArrayList<List<Object>>();
        statistic.generateRoomUsageStatistics();
        List<String> roomNames = statistic.getLabels();
        List<Integer> count = statistic.getNumbers();
        for(int i=0; i<roomNames.size(); i++) {
            List<Object> temp = new ArrayList<Object>();
            temp.add(roomNames.get(i));
            temp.add(count.get(i));
            roomBorrowedFrequencyData.add(temp);
        }
    }
    
    private void setRoomBrokenFrequencyData() {
        roomBrokenFrequencyData = new ArrayList<List<Object>>();
        statistic.generateRoomMaintenanceStatistics();
        List<String> roomNames = statistic.getLabels();
        List<Integer> count = statistic.getNumbers();
        for(int i=0; i<roomNames.size(); i++) {
            List<Object> temp = new ArrayList<Object>();
            temp.add(roomNames.get(i));
            temp.add(count.get(i));
            roomBrokenFrequencyData.add(temp);
        }
    }
    
    private void setRoomUsedData() {
        roomUsedData = new ArrayList<List<Object>>();
        statistic.generateGroupBookingStatistics();
        List<String> groupNames = statistic.getLabels();
        List<Integer> count = statistic.getNumbers();
        for(int i=0; i<groupNames.size(); i++) {
            List<Object> temp = new ArrayList<Object>();
            temp.add(groupNames.get(i));
            temp.add(count.get(i));
            roomUsedData.add(temp);
        }
    }
  
    private void showRoomBrokenFrequencyStatistic() {
        Object[] temp = new Object[roomBrokenFrequencyColumns.size()];
        Object[][] temp2 = new Object[roomBrokenFrequencyData.size()][roomBrokenFrequencyColumns.size()];
        ArrayList<Object[]> rows = new ArrayList<Object[]>();
        for (List<Object> datum : roomBrokenFrequencyData) {
            rows.add((Object[]) datum.toArray());
        }
        
        roomBrokenFrequencyStatistic = new JTable(rows.toArray(temp2), roomBrokenFrequencyColumns.toArray(temp));
        roomBrokenFrequencyStatistic.setEnabled(false);
        roomBrokenFrequencyStatistic.setOpaque(false);
        roomBrokenFrequencyStatistic.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        roomBrokenFrequencyStatistic.getTableHeader().setReorderingAllowed(false);
        // Menerapkan customization
        roomBrokenFrequencyStatistic.getTableHeader().setDefaultRenderer(headerRenderer);
        for (int i = 0; i < roomBrokenFrequencyStatistic.getColumnCount(); i++) {
            roomBrokenFrequencyStatistic.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }
        // Mengatur font
        roomBrokenFrequencyStatistic.setFont(new Font("Roboto", Font.PLAIN, 16));
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i=0; i<roomBrokenFrequencyData.size(); i++) {
            List<Object> datum = roomBrokenFrequencyData.get(i);
            String roomName = datum.get(0).toString();
            int count = (int) datum.get(1);
            dataset.addValue(count, "", roomName);
        }
        
        JFreeChart barChart = ChartFactory.createBarChart("Frekuensi Pemeliharaan Ruangan", "Nama Ruangan", "Frekuensi Peminjaman", dataset, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel chartPanel = new ChartPanel(barChart);
        
        JPanel scrollPaneContainer = new JPanel();
        scrollPaneContainer.setLayout(new BoxLayout(scrollPaneContainer, BoxLayout.Y_AXIS));
        scrollPaneContainer.add(chartPanel);
        scrollPaneContainer.add(Box.createRigidArea(new Dimension(0,50)));
        scrollPaneContainer.add(new JScrollPane(roomBrokenFrequencyStatistic));
        roomBrokenFrequencyPane.getViewport().add(scrollPaneContainer);
    }
    
    private void showRoomUsedStatistic() {
        Object[] temp = new Object[roomUsedColumns.size()];
        Object[][] temp2 = new Object[roomUsedData.size()][roomUsedColumns.size()];
        ArrayList<Object[]> rows = new ArrayList<Object[]>();
        for (List<Object> datum : roomUsedData) {
            rows.add((Object[]) datum.toArray());
        }
        
        roomUsedStatistic = new JTable(rows.toArray(temp2), roomUsedColumns.toArray(temp));
        roomUsedStatistic.setEnabled(false);
        roomUsedStatistic.setOpaque(false);
        roomUsedStatistic.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        roomUsedStatistic.getTableHeader().setReorderingAllowed(false);
        // Menerapkan customization
        roomUsedStatistic.getTableHeader().setDefaultRenderer(headerRenderer);
        for (int i = 0; i < roomUsedStatistic.getColumnCount(); i++) {
            roomUsedStatistic.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }
        // Mengatur font
        roomUsedStatistic.setFont(new Font("Roboto", Font.PLAIN, 16));
        roomUsedPane.getViewport().add(roomUsedStatistic);
        
        // Pie chart
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (int i=0; i<roomUsedData.size(); i++) {
            List<Object> datum = roomUsedData.get(i);
            String user = datum.get(0).toString();
            int count = (int) datum.get(1);
            dataset.setValue(user, count);
        }
        
        JFreeChart pieChart = ChartFactory.createPieChart("Penggunaan Ruangan oleh Kelompok User", dataset, true, true, false);
        ChartPanel chartPanel = new ChartPanel(pieChart);
        
        JPanel scrollPaneContainer = new JPanel();
        scrollPaneContainer.setLayout(new BoxLayout(scrollPaneContainer, BoxLayout.Y_AXIS));
        scrollPaneContainer.add(chartPanel);
        scrollPaneContainer.add(Box.createRigidArea(new Dimension(0,50)));
        scrollPaneContainer.add(new JScrollPane(roomUsedStatistic));
        roomUsedPane.getViewport().add(scrollPaneContainer);
    }
    
    private void showRoomBorrowedFrequencyStatistic() {
        JFreeChart barChart = showRoomBorrowedFrequencyChart("Frekuensi Penggunaan Ruangan", "Nama Ruangan", "Frekuensi Peminjaman");
        ChartPanel chartPanel = new ChartPanel(barChart);
        JTable table = showRoomBorrowedFrequencyTable();
        
        JPanel scrollPaneContainer = new JPanel();
        scrollPaneContainer.setLayout(new BoxLayout(scrollPaneContainer, BoxLayout.Y_AXIS));
        scrollPaneContainer.add(chartPanel);
        scrollPaneContainer.add(Box.createRigidArea(new Dimension(0,50)));
        scrollPaneContainer.add(new JScrollPane(table));
        roomBorrowedFrequencyPane.getViewport().add(scrollPaneContainer);
    }
    
    private JTable showRoomBorrowedFrequencyTable() {
        Object[] temp = new Object[roomBorrowedFrequencyColumns.size()];
        Object[][] temp2 = new Object[roomBorrowedFrequencyData.size()][roomBorrowedFrequencyColumns.size()];
        ArrayList<Object[]> rows = new ArrayList<Object[]>();
        for (List<Object> datum : roomBorrowedFrequencyData) {  
            rows.add((Object[]) datum.toArray());
        }
        
        JTable table = new JTable(rows.toArray(temp2), roomBorrowedFrequencyColumns.toArray(temp));
        table.setEnabled(false);
        table.setOpaque(false);
        table.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        table.getTableHeader().setReorderingAllowed(false);
        // Menerapkan customization tabel
        table.getTableHeader().setDefaultRenderer(headerRenderer);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }
        
        // Mengatur font
        table.setFont(new Font("Roboto", Font.PLAIN, 16));
        return table;
    }
    
    private JFreeChart showRoomBorrowedFrequencyChart(String chartTitle, String xLabel, String yLabel) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i=0; i<roomBorrowedFrequencyData.size(); i++) {
            List<Object> datum = roomBorrowedFrequencyData.get(i);
            String roomName = datum.get(0).toString();
            int count = (int) datum.get(1);
            dataset.addValue(count, "", roomName);
        }
        
        JFreeChart barChart = ChartFactory.createBarChart(chartTitle, xLabel, yLabel, dataset, PlotOrientation.VERTICAL, true, true, false);
        return barChart;
    }
    
    private void customizeTable() {
        headerRenderer = new DefaultTableCellRenderer();
        cellRenderer = new DefaultTableCellRenderer();
        // Membuat alignment center
        cellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        cellRenderer.setVerticalAlignment(SwingConstants.CENTER);
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        headerRenderer.setVerticalAlignment(SwingConstants.CENTER);
        // Membuat warna berbeda antara header dan cell biasa
        headerRenderer.setBackground(Color.lightGray);
        cellRenderer.setOpaque(false);
    }
    
    private void customizeScrollPane() {
        roomBorrowedFrequencyPane.setOpaque(false);
        roomBorrowedFrequencyPane.getViewport().setOpaque(false);
        roomBrokenFrequencyPane.setOpaque(false);
        roomBrokenFrequencyPane.getViewport().setOpaque(false);
        roomUsedPane.setOpaque(false);
        roomUsedPane.getViewport().setOpaque(false);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane roomBorrowedFrequencyPane;
    private javax.swing.JPanel roomBorrowedFrequencyPanel;
    private javax.swing.JScrollPane roomBrokenFrequencyPane;
    private javax.swing.JPanel roomBrokenFrequencyPanel;
    private javax.swing.JScrollPane roomUsedPane;
    private javax.swing.JPanel roomUsedPanel;
    private javax.swing.JTabbedPane statisticPane;
    // End of variables declaration//GEN-END:variables

    public static void main(String[] args) {
        MainFrame frame = MainFrame.getInstance();
        frame.setContentPane(new StatisticPanel());
        frame.setVisible(true);
    }

}
