/**
 * Aplikasi Room Management
 * @author Irene Wiliudarsan - 13513002
 * @author William Sentosa - 13513026
 * @author Angela Lynn - 13513032
 * @author Devina Ekawati - 13513088
 */
package gui;

import administrator.Administrator;

/**
 *
 * @author angelynz95
 */
public class ChangePasswordPanel extends javax.swing.JPanel {
    
    private Administrator administrator;
    
    /**
     * Creates new form ChangePasswordPanel
     */
    public ChangePasswordPanel() {
        initComponents();
        administrator = new Administrator();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        oldPasswordField = new javax.swing.JPasswordField();
        newPasswordField = new javax.swing.JPasswordField();
        newPasswordConfirmationField = new javax.swing.JPasswordField();
        oldPasswordLabel = new javax.swing.JLabel();
        newPasswordLabel = new javax.swing.JLabel();
        newPasswordConfirmationLabel = new javax.swing.JLabel();
        changePasswordButton = new javax.swing.JButton();
        oldPasswordMessage = new javax.swing.JLabel();
        newPasswordConfirmationMessage = new javax.swing.JLabel();

        oldPasswordField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        newPasswordField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        newPasswordConfirmationField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        oldPasswordLabel.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        oldPasswordLabel.setText("Kata Sandi Lama");

        newPasswordLabel.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        newPasswordLabel.setText("Kata Sandi Baru");

        newPasswordConfirmationLabel.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        newPasswordConfirmationLabel.setText("Konfirmasi Kata Sandi Baru");

        changePasswordButton.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        changePasswordButton.setText("Ubah");
        changePasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePasswordButtonActionPerformed(evt);
            }
        });

        newPasswordConfirmationMessage.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(375, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newPasswordLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newPasswordConfirmationLabel)
                            .addComponent(oldPasswordLabel))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(oldPasswordField)
                                .addComponent(newPasswordField)
                                .addComponent(newPasswordConfirmationField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(changePasswordButton))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(oldPasswordMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(newPasswordConfirmationMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(266, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(226, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oldPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oldPasswordLabel)
                    .addComponent(oldPasswordMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newPasswordLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newPasswordConfirmationField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newPasswordConfirmationLabel)
                    .addComponent(newPasswordConfirmationMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(changePasswordButton)
                .addContainerGap(213, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private String convertToString(char[] src) {
        String result  = "";
        for(int i=0; i<src.length; i++) {
            result = result + src[i];
        }
        return result;
    }
    
    private void changePasswordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePasswordButtonActionPerformed
        // TODO add your handling code here:
        String oldPassword = convertToString(oldPasswordField.getPassword());
        System.out.println(oldPassword);
        String newPassword = convertToString(newPasswordField.getPassword());
        String newPasswordConfirmed = convertToString(newPasswordConfirmationField.getPassword());
        
        if (administrator.validateLogin(oldPassword)) {
            if (newPassword.equals(newPasswordConfirmed)) {
                administrator.changePassword(newPassword);
                PasswordChangedFrame passwordChangedFrame = new PasswordChangedFrame();
                newPasswordConfirmationField.setText("");
                newPasswordField.setText("");
                oldPasswordField.setText("");
                oldPasswordMessage.setText("");
                newPasswordConfirmationMessage.setText("");
            } else {
                newPasswordConfirmationMessage.setText("Konfirmasi kata sandi salah");
            }
        } else{
            oldPasswordMessage.setText("Kata sandi lama salah");
        }
        
        
    }//GEN-LAST:event_changePasswordButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton changePasswordButton;
    private javax.swing.JPasswordField newPasswordConfirmationField;
    private javax.swing.JLabel newPasswordConfirmationLabel;
    private javax.swing.JLabel newPasswordConfirmationMessage;
    private javax.swing.JPasswordField newPasswordField;
    private javax.swing.JLabel newPasswordLabel;
    private javax.swing.JPasswordField oldPasswordField;
    private javax.swing.JLabel oldPasswordLabel;
    private javax.swing.JLabel oldPasswordMessage;
    // End of variables declaration//GEN-END:variables
}
