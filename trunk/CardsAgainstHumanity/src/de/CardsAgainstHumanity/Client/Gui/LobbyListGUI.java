/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * LobbyListGUI.java
 *
 * Created on 26.06.2012, 10:54:37
 */
package de.CardsAgainstHumanity.Client.Gui;

import de.CardsAgainstHumanity.Main;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

/**
 *
 * @author schlefix
 */
public class LobbyListGUI extends javax.swing.JPanel {

    MainGUI parent;
    String link;
    boolean isHost;
    List<JPanel> panels = new ArrayList<JPanel>();
    private LobbyListCreatePanel createPanel = new LobbyListCreatePanel(this);

    public LobbyListGUI(MainGUI parent, String link, boolean isHost) {
        initComponents();
        this.parent = parent;
        this.link = link;
        this.isHost = isHost;
        if (isHost) {
            panels.add(createPanel);

        } else {
            buttonBack.setText("back");
            loadLobbys();
        }
        
        int i = 0;
        for (JPanel jPanel : panels) {
            panelListContainer.add(jPanel, new AbsoluteConstraints(0, i * 85, -1, -1));
            i++;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaNews = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        panelListContainer = new javax.swing.JPanel();
        labelHeader = new javax.swing.JLabel();
        buttonBack = new javax.swing.JButton();

        setBackground(new java.awt.Color(51, 153, 255));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setName("lobbyListPanel"); // NOI18N
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textAreaNews.setColumns(20);
        textAreaNews.setEditable(false);
        textAreaNews.setRows(5);
        textAreaNews.setText("Servernachricht an alle Lobbys: Hallo Welt, viel spaß mit Cards against Humanity");
        textAreaNews.setFocusable(false);
        jScrollPane1.setViewportView(textAreaNews);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 720, 110));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setToolTipText("");
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        panelListContainer.setBackground(new java.awt.Color(255, 255, 102));
        panelListContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jScrollPane2.setViewportView(panelListContainer);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 760, 370));

        labelHeader.setFont(new java.awt.Font("Tahoma", 1, 18));
        labelHeader.setText("your Lobbys");
        add(labelHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, -1, -1));

        buttonBack.setText("Stop server");
        buttonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBackActionPerformed(evt);
            }
        });
        add(buttonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 550, 110, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void buttonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBackActionPerformed
        if (isHost) {
            Main.client.stopServer();
            parent.switchToMain();
        } else {
            parent.switchToPanel(link);
        }
    }//GEN-LAST:event_buttonBackActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBack;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelHeader;
    private javax.swing.JPanel panelListContainer;
    private javax.swing.JTextArea textAreaNews;
    // End of variables declaration//GEN-END:variables

    void removeLobby(LobbyPanel aThis) {
        panels.remove(aThis);
        panelListContainer.removeAll();
        int i = 0;
        for (JPanel jPanel : panels) {
            panelListContainer.add(jPanel, new AbsoluteConstraints(0, i * 85, -1, -1));
            i++;
        }
        jScrollPane2.updateUI();
    }

    void addLobby(LobbyPanel newLobby) {
        panels.remove(createPanel);
        panels.add(newLobby);
        panels.add(createPanel);
        panelListContainer.removeAll();
        int i = 0;
        for (JPanel jPanel : panels) {
            panelListContainer.add(jPanel, new AbsoluteConstraints(0, i * 85, -1, -1));
            i++;
        }
        jScrollPane2.updateUI();
    }

    private void loadLobbys() {
        
        if (panels.isEmpty()) {
            textAreaNews.setText("Keine News vorhanden");
        }
        
    }
}
