package de.CardsAgainstHumanity.Client.Gui;

import java.awt.event.ActionEvent;

/**
 *
 * @author schlefix
 */
public class JoinGUI extends HostGUI {

    public JoinGUI(MainGUI parent) {
        super(parent);
        buttonStartServer.setText("join Server");
        buttonStartServer.removeActionListener(buttonStartServer.getActionListeners()[0]);
        buttonStartServer.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonJoinServerActionPerformed(evt);
            }
        });
    }

    private void buttonJoinServerActionPerformed(ActionEvent evt) {
        parent.switchToPanel(MainGUI.LOBBYLISTJOINPANEL);
    }
}
