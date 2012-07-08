
package de.CardsAgainstHumanity.Client.Gui;

import de.CardsAgainstHumanity.Main;
import java.awt.Graphics;
import javax.swing.JOptionPane;

public class LobbyPanel extends javax.swing.JPanel{
    private LobbyListGUI parent;
    private String name;
    private String gameMode;
    private int maxPlayer;
    private int curPlayer;
    
    public LobbyPanel(LobbyListGUI parent,String name, int maxPlayer) {
        this(parent, name, maxPlayer, "normal");
    }
     public LobbyPanel(LobbyListGUI parent,String name, int maxPlayer,String mode) {
        initComponents();
        this.parent = parent;
        this.name = name;
        this.maxPlayer=maxPlayer;
        this.gameMode=mode;
        this.labelGametypeType.setText(gameMode);
        this.labelLobbyName.setText(name);
        this.labelPlayersNR.setText(curPlayer+"/"+maxPlayer);
     }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonJoin = new javax.swing.JButton();
        labelLobbyName = new javax.swing.JLabel();
        labelPlayers = new javax.swing.JLabel();
        lableGametype = new javax.swing.JLabel();
        buttonClose = new javax.swing.JButton();
        labelPlayersNR = new javax.swing.JLabel();
        labelGametypeType = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 51, 0));
        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setMinimumSize(new java.awt.Dimension(650, 80));
        setName("lobbyPanel"); // NOI18N
        setPreferredSize(new java.awt.Dimension(650, 80));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonJoin.setText("Join");
        buttonJoin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonJoinActionPerformed(evt);
            }
        });
        add(buttonJoin, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 110, 40));

        labelLobbyName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelLobbyName.setText("Lobbyname");
        add(labelLobbyName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 130, -1));

        labelPlayers.setText("Spieler:");
        add(labelPlayers, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        lableGametype.setText("Gametype:");
        add(lableGametype, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        buttonClose.setText("Close");
        buttonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseActionPerformed(evt);
            }
        });
        add(buttonClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 110, 40));

        labelPlayersNR.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelPlayersNR.setText("cur/max");
        labelPlayersNR.setFocusable(false);
        add(labelPlayersNR, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 100, -1));

        labelGametypeType.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelGametypeType.setText("normal");
        add(labelGametypeType, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 100, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseActionPerformed
        if(Main.client.closeLobby(name)){
            parent.removeLobby(this);
        }else{
            JOptionPane.showMessageDialog(this, "An error occured while closing a lobby.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttonCloseActionPerformed

    private void buttonJoinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonJoinActionPerformed
        if(curPlayer<maxPlayer){
            curPlayer++;
            
            //TODO JOIN GAME!
        }
    }//GEN-LAST:event_buttonJoinActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonClose;
    private javax.swing.JButton buttonJoin;
    private javax.swing.JLabel labelGametypeType;
    private javax.swing.JLabel labelLobbyName;
    private javax.swing.JLabel labelPlayers;
    private javax.swing.JLabel labelPlayersNR;
    private javax.swing.JLabel lableGametype;
    // End of variables declaration//GEN-END:variables

    @Override
    protected void paintComponent(Graphics g) {
        this.labelGametypeType.setText(gameMode);
        this.labelLobbyName.setText(name);
        this.labelPlayersNR.setText(curPlayer+"/"+maxPlayer);
        super.paintComponent(g);
        
    }

    

}
