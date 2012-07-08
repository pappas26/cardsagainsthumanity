
package de.CardsAgainstHumanity.Client.Gui;

import de.CardsAgainstHumanity.Main;
import de.CardsAgainstHumanity.Server.Interfaces.Lobby;
import de.CardsAgainstHumanity.Server.Interfaces.Lobby.Gametype;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class LobbyListCreatePanel extends javax.swing.JPanel {
    private LobbyListGUI parent;
    private DefaultListModel dlm;
    
    public LobbyListCreatePanel(LobbyListGUI parent) {
        initComponents();
        this.parent = parent;
        fillList();
    }
    
    private void fillList(){
        Gametype [] gametypes = Lobby.Gametype.values();
        dlm = new DefaultListModel();
        for(Gametype g:gametypes){
            dlm.addElement(Gametype.toString(g));
        }
        gametypeList.setModel(dlm);
        gametypeList.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        createBtn = new javax.swing.JButton();
        spinnerMaxPlayers = new javax.swing.JSpinner();
        maxPlayerLabel = new javax.swing.JLabel();
        lobbyNameField = new javax.swing.JTextField();
        gametypeScroll = new javax.swing.JScrollPane();
        gametypeList = new javax.swing.JList();

        setBackground(new java.awt.Color(255, 153, 0));
        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setMinimumSize(new java.awt.Dimension(650, 80));
        setName("panelCreateLobby"); // NOI18N
        setPreferredSize(new java.awt.Dimension(650, 85));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        createBtn.setText("Create Lobby");
        createBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createBtnActionPerformed(evt);
            }
        });
        add(createBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 100, 40));
        add(spinnerMaxPlayers, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 40, -1));

        maxPlayerLabel.setText("max Players");
        add(maxPlayerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, -1, 20));

        lobbyNameField.setText("Lobby1");
        add(lobbyNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 140, -1));

        gametypeScroll.setBorder(javax.swing.BorderFactory.createTitledBorder("Gametype"));

        gametypeScroll.setViewportView(gametypeList);

        add(gametypeScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 170, 60));
    }// </editor-fold>//GEN-END:initComponents

    private void createBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBtnActionPerformed
        if(Main.client.createLobby(lobbyNameField.getText(), (Integer)spinnerMaxPlayers.getValue(), Gametype.fromString(gametypeList.getSelectedValue().toString()))){
            parent.addLobby(new LobbyPanel(parent, lobbyNameField.getText(),(Integer)spinnerMaxPlayers.getValue(),gametypeList.getSelectedValue().toString()));
        }else{
            JOptionPane.showMessageDialog(this, "An error occured while creating a new lobby.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_createBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createBtn;
    private javax.swing.JList gametypeList;
    private javax.swing.JScrollPane gametypeScroll;
    private javax.swing.JTextField lobbyNameField;
    private javax.swing.JLabel maxPlayerLabel;
    private javax.swing.JSpinner spinnerMaxPlayers;
    // End of variables declaration//GEN-END:variables
}
