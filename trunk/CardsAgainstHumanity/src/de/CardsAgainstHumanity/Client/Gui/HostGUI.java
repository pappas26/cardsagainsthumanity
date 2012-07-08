
package de.CardsAgainstHumanity.Client.Gui;

public class HostGUI extends javax.swing.JPanel {
    MainGUI parent;
    /** Creates new form HostGUI */
    public HostGUI(MainGUI parent) {
        initComponents();
        this.parent = parent;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        buttonStartServer = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 153, 255));
        setAlignmentX(0.0F);
        setAlignmentY(0.0F);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setName("hostPanel"); // NOI18N
        setPreferredSize(new java.awt.Dimension(800, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("back!");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 540, 90, 40));

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField1.setText("255625");
        jTextField1.setToolTipText("");
        jTextField1.setAlignmentX(0.0F);
        jTextField1.setAlignmentY(0.0F);
        jTextField1.setMargin(new java.awt.Insets(4, 4, 4, 4));
        add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 400, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Port:");
        jLabel1.setAlignmentY(0.0F);
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 60, 20));

        buttonStartServer.setText("Start Server!");
        buttonStartServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStartServerActionPerformed(evt);
            }
        });
        add(buttonStartServer, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, 100, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        parent.switchToMain();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void buttonStartServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStartServerActionPerformed
        parent.switchToPanel(MainGUI.LOBBYLISTPANEL);
    }//GEN-LAST:event_buttonStartServerActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonStartServer;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
