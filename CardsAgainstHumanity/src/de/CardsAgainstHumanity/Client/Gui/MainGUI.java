package de.CardsAgainstHumanity.Client.Gui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class MainGUI extends javax.swing.JFrame {

    public static final String HOSTPANEL = "hostPanel";
    public static final String LOBBYLISTHOSTPANEL = "lobbyListHostPanel";
    public static final String LOBBYLISTJOINPANEL = "lobbyListJoinPanel";
    public static final String JOINPANEL = "joinPanel";
    private static List<JPanel> panels = new ArrayList<JPanel>();
    private LobbyListGUI lobbyListHost = new LobbyListGUI(this,HOSTPANEL,true);
    private LobbyListGUI lobbyListJoin = new LobbyListGUI(this,JOINPANEL,false);
    private HostGUI hostGUI= new HostGUI(this);
    private JoinGUI joinGUI = new JoinGUI(this);
    
    /** Creates new form MainGUI */
    public MainGUI() {
        initComponents();
        panels.add(mainPanel);
        addPanel(hostGUI, HOSTPANEL);
        addPanel(lobbyListHost, LOBBYLISTHOSTPANEL);
        addPanel(lobbyListJoin, LOBBYLISTJOINPANEL);
        addPanel(joinGUI, JOINPANEL);
    }

    public void switchToMain() {
        for (JPanel jPanel : panels) {
            jPanel.setVisible(false);
        }
        mainPanel.setVisible(true);
    }

    public void switchToPanel(String name) {

        JPanel tmp = null;
        for (JPanel jPanel : panels) {
            if (jPanel.getName().equals(name)) {
                tmp = jPanel;
            } else {
                jPanel.setVisible(false);
            }
        }

        try {
            add2Layout(tmp);
            tmp.setVisible(true);
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
    }

    private void addPanel(JPanel panel, String name) {
        this.add(panel);
        panel.setName(name);
        panels.add(panel);
        panel.setVisible(false);
    }

    private void add2Layout(JPanel panel) {
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 800, Short.MAX_VALUE).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(0, 0, 0).addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGap(0, 0, 0))));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 600, Short.MAX_VALUE).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(0, 0, 0).addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGap(0, 0, 0))));
        panel.setVisible(false);
        pack();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        buttonPlayOnline = new javax.swing.JButton();
        buttonPlayOff = new javax.swing.JButton();
        buttonHost = new javax.swing.JButton();
        buttonExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cards Against Humanity");
        setBounds(new java.awt.Rectangle(0, 0, 800, 600));
        setName("MainMenue"); // NOI18N
        setResizable(false);

        mainPanel.setName("mainPanel");
        mainPanel.setBackground(new java.awt.Color(102, 153, 255));
        mainPanel.setAlignmentX(0.0F);
        mainPanel.setAlignmentY(0.0F);
        mainPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonPlayOnline.setText("play online");
        buttonPlayOnline.setAlignmentY(0.0F);
        buttonPlayOnline.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        buttonPlayOnline.setMaximumSize(new java.awt.Dimension(73, 23));
        buttonPlayOnline.setMinimumSize(new java.awt.Dimension(73, 23));
        buttonPlayOnline.setPreferredSize(new java.awt.Dimension(73, 23));
        buttonPlayOnline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPlayOnlineActionPerformed(evt);
            }
        });
        mainPanel.add(buttonPlayOnline, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 300, 90));

        buttonPlayOff.setText("play offline");
        buttonPlayOff.setToolTipText("");
        buttonPlayOff.setIconTextGap(-140);
        mainPanel.add(buttonPlayOff, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, 140, 50));

        buttonHost.setText("host game");
        buttonHost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHostActionPerformed(evt);
            }
        });
        mainPanel.add(buttonHost, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 200, 140, 50));

        buttonExit.setText("Exit");
        buttonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExitActionPerformed(evt);
            }
        });
        mainPanel.add(buttonExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, 140, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonHostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHostActionPerformed
       
        switchToPanel(HOSTPANEL);
    }//GEN-LAST:event_buttonHostActionPerformed

    private void buttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_buttonExitActionPerformed

    private void buttonPlayOnlineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPlayOnlineActionPerformed
        switchToPanel(JOINPANEL);
    }//GEN-LAST:event_buttonPlayOnlineActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonExit;
    private javax.swing.JButton buttonHost;
    private javax.swing.JButton buttonPlayOff;
    private javax.swing.JButton buttonPlayOnline;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton offlineBtn;
    // End of variables declaration//GEN-END:variables
}
