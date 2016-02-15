/**
 * Aplikasi Room Management
 * @author Irene Wiliudarsan - 13513002
 * @author William Sentosa - 13513026
 * @author Angela Lynn - 13513032
 * @author Devina Ekawati - 13513088
 */
package gui;

import database.BorrowingModel;
import database.RoomModel;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import roominformation.RoomInformation;

/**
 *
 * @author angelynz95
 */
public class RoomInformationPanel extends javax.swing.JPanel {
    private JTable table;
    private List<List<Object>> data;
    private List<Object> columns;
    private RoomInformation roomInformation;
    /**
     * Creates new form RoomInformation
     */
    public RoomInformationPanel() {
        
        initComponents();
        roomInformation = new RoomInformation();
        // Inisialisasi columns
        columns = new ArrayList<Object>();
        // Inisialisasi data
        data = new ArrayList<List<Object>>();
        // Menampilkan tabel
        setColumns();
        setData();
        showTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        roomInformationPane = new javax.swing.JScrollPane();

        searchField.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N

        searchButton.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        searchButton.setText("Cari");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(272, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roomInformationPane, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(searchField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchButton)))
                .addContainerGap(275, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roomInformationPane, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void setColumns() {
        columns.add("Nama Ruangan");
        columns.add("Kapasitas Ruangan");
        columns.add("Status Ruangan");
    }
    
    private void setData() {
        List<RoomModel> rooms = roomInformation.fetchRoomData();
        for(int i=0; i<rooms.size(); i++) {
            data.add(new ArrayList<Object>());
            data.get(i).add(rooms.get(i).getName());
            data.get(i).add(rooms.get(i).getCapacity());
            data.get(i).add(rooms.get(i).getStatus());
        }
    }
    
    private void showTable() {
        Object[] temp = new Object[columns.size()];
        Object[][] temp2 = new Object[data.size()][columns.size()];
        ArrayList<Object[]> rows = new ArrayList<Object[]>();
        for (List<Object> datum : data) {
            rows.add((Object[]) datum.toArray());
        }
        
        table = new JTable(rows.toArray(temp2), columns.toArray(temp));
        table.setFillsViewportHeight(true);
        table.setEnabled(false);
        table.getTableHeader().setReorderingAllowed(false);
        // Meng-customize table
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        // Membuat alignment center
        cellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        cellRenderer.setVerticalAlignment(SwingConstants.CENTER);
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        headerRenderer.setVerticalAlignment(SwingConstants.CENTER);
        // Membuat warna berbeda pada header
        headerRenderer.setBackground(Color.lightGray);
        // Menerapkan customization
        table.getTableHeader().setDefaultRenderer(headerRenderer);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }
        // Mengatur font
        table.setFont(new Font("Roboto", Font.PLAIN, 16));
        
        // Menambahkan mouse listener
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = table.rowAtPoint(evt.getPoint());
                ArrayList<BorrowingModel> clashBooking = new ArrayList<>();
                int column = table.columnAtPoint(evt.getPoint());
                if (table.getValueAt(row, column).equals("OK")) {
                    table.setValueAt("rusak", row, column);
                    clashBooking = roomInformation.changeRoomStatus(table.getValueAt(row, 0).toString());
                } else if (table.getValueAt(row, column).equals("rusak")) {
                    table.setValueAt("OK", row, column);
                    clashBooking = roomInformation.changeRoomStatus(table.getValueAt(row, 0).toString());
                }
                if(clashBooking.size() != 0) {
                    // Tampilkan booking yang bentrok
                }
            }
        });
        
        roomInformationPane.getViewport().add(table);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane roomInformationPane;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    // End of variables declaration//GEN-END:variables
}
