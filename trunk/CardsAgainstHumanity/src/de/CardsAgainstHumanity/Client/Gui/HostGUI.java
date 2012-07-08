
package de.CardsAgainstHumanity.Client.Gui;

import de.CardsAgainstHumanity.Main;

public class HostGUI extends javax.swing.JPanel {
    private MainGUI parent;
    
    public HostGUI(MainGUI parent) {
        initComponents();
        this.parent = parent;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backBtn = new javax.swing.JButton();
        portField = new javax.swing.JTextField();
        portLabel = new javax.swing.JLabel();
        startServerBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 153, 255));
        setAlignmentX(0.0F);
        setAlignmentY(0.0F);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setName("hostPanel"); // NOI18N
        setPreferredSize(new java.awt.Dimension(800, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backBtn.setText("back!");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 540, 90, 40));

        portField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        portField.setText("25565");
        portField.setToolTipText("");
        portField.setAlignmentX(0.0F);
        portField.setAlignmentY(0.0F);
        portField.setMargin(new java.awt.Insets(4, 4, 4, 4));
        add(portField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 400, 30));

        portLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        portLabel.setForeground(new java.awt.Color(255, 255, 255));
        portLabel.setText("Port:");
        portLabel.setAlignmentY(0.0F);
        add(portLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 60, 20));

        startServerBtn.setText("Start Server!");
        startServerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startServerBtnActionPerformed(evt);
            }
        });
        add(startServerBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, 100, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        parent.switchToMain();
    }//GEN-LAST:event_backBtnActionPerformed

    private void startServerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startServerBtnActionPerformed
        parent.switchToPanel(MainGUI.LOBBYLISTPANEL);
        Main.client.hostServer(Integer.valueOf(portField.getText()));
    }//GEN-LAST:event_startServerBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JTextField portField;
    private javax.swing.JLabel portLabel;
    private javax.swing.JButton startServerBtn;
    // End of variables declaration//GEN-END:variables
}
