
package de.CardsAgainstHumanity.Client.Gui;

public class LobbyListCreatePanel extends javax.swing.JPanel {
    LobbyListGUI parent;
    /** Creates new form LobbyListCreatePanel */
    public LobbyListCreatePanel(LobbyListGUI parent) {
        initComponents();
        this.parent = parent;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonCreate = new javax.swing.JButton();
        spinnerMaxPlayers = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        textFieldLobbyName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();

        setBackground(new java.awt.Color(255, 153, 0));
        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setMinimumSize(new java.awt.Dimension(650, 80));
        setName("panelCreateLobby"); // NOI18N
        setPreferredSize(new java.awt.Dimension(650, 85));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonCreate.setText("create Lobby");
        buttonCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCreateActionPerformed(evt);
            }
        });
        add(buttonCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 100, 40));
        add(spinnerMaxPlayers, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 40, -1));

        jLabel1.setText("max Players");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, -1, 20));

        textFieldLobbyName.setText("enter Lobby Name");
        add(textFieldLobbyName, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 140, -1));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Gametype"));

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "normal", "hardcore", "etc..." };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 170, 60));
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCreateActionPerformed
        parent.addLobby(new LobbyPanel(parent, textFieldLobbyName.getText(),(Integer)spinnerMaxPlayers.getValue(),jList1.getSelectedValue().toString()));
        //TODO START LOBBY
    }//GEN-LAST:event_buttonCreateActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCreate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spinnerMaxPlayers;
    private javax.swing.JTextField textFieldLobbyName;
    // End of variables declaration//GEN-END:variables
}
