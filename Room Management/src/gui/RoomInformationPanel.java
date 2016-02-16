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
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import static javax.swing.BorderFactory.createEmptyBorder;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import roominformation.RoomInformation;

/**
 *
 * @author angelynz95
 */
public class RoomInformationPanel extends javax.swing.JPanel {
    private JTable table;
    private ArrayList<RoomModel> data;
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
        data = new ArrayList<RoomModel>();
        // Menampilkan tabel
        setColumns();
        setData();
        showTable();
    }
    
    public RoomInformationPanel(String searchedText) {
        
        initComponents();
        roomInformation = new RoomInformation();
        // Inisialisasi columns
        columns = new ArrayList<Object>();
        // Inisialisasi data
        data = new ArrayList<RoomModel>();
        // Menampilkan tabel
        setColumns();
        this.setSearchedData(searchedText);
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
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

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

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        MenuPanel panel = (MenuPanel)frame.getContentPane();
        panel.getRoomInformationContainer().removeAll();
        panel.getRoomInformationContainer().add(new RoomInformationPanel(searchField.getText()));
        panel.getRoomInformationContainer().revalidate();
        panel.getRoomInformationContainer().repaint();
    }//GEN-LAST:event_searchButtonActionPerformed

    private void setColumns() {
        columns.add("Nama Ruangan");
        columns.add("Kapasitas Ruangan");
        columns.add("Status Ruangan");
    }
    
    private void setData() {
        List<RoomModel> rooms = roomInformation.fetchRoomData();
        for(int i=0; i<rooms.size(); i++) {
            data.add(rooms.get(i));
        }
    }
    
    private void setSearchedData(String text) {
        ArrayList<RoomModel> rooms = roomInformation.searchRoomData(text);
        for(int i=0; i<rooms.size(); i++) {
            data.add(rooms.get(i));
        }
    }
    
    private void showTable() {
        JPanel table = new JPanel();
        GridLayout tabelLayout = new GridLayout(data.size() + 1, columns.size());
        System.out.println(data.size());
        table.setLayout(tabelLayout);
        
        // Menambah header kolom
        for (int i = 0; i < columns.size(); i++) {
            JLabel columnLabel = new JLabel((String) columns.get(i));
            customizeLabel(columnLabel);
            columnLabel.setBackground(Color.lightGray);
            table.add(columnLabel);
        }
        
        // Menambah data
        for (int i = 0; i < data.size(); i++) {
            JLabel roomName = new JLabel(data.get(i).getName());
            customizeLabel(roomName);
            table.add(roomName);
            JLabel roomCapacity = new JLabel(Integer.toString(data.get(i).getCapacity()));
            customizeLabel(roomCapacity);
            table.add(roomCapacity);
            String[] roomStatusStrings = {"OK", "rusak"};
            JComboBox roomStatus = new JComboBox(roomStatusStrings);
            DefaultListCellRenderer dlcr = new DefaultListCellRenderer(); 
            dlcr.setHorizontalAlignment(DefaultListCellRenderer.CENTER); 
            roomStatus.setRenderer(dlcr); 
            if (data.get(i).getStatus().equals("OK")) {
                roomStatus.setSelectedIndex(0);
            } else {
                roomStatus.setSelectedIndex(1);
            }
            table.add(roomStatus);
            roomStatus.addActionListener(new ActionListener() {@Override
                public void actionPerformed(ActionEvent e) {
                    roomInformation.changeRoomStatus(roomName.getText());
                }
            });
        }
        roomInformationPane.setBorder(createEmptyBorder());
        roomInformationPane.getViewport().add(table);
    }

    private void customizeLabel(JLabel label) {
        label.setPreferredSize(new Dimension(200, 16));
        label.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Roboto", Font.PLAIN, 16));
        label.setOpaque(true);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane roomInformationPane;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    // End of variables declaration//GEN-END:variables
}
