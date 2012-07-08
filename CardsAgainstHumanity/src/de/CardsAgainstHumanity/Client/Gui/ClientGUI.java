package de.CardsAgainstHumanity.Client.Gui;

import de.CardsAgainstHumanity.Main;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.synth.SynthLookAndFeel;

/**
 *
 * @author Timo & Felix
 */
public class ClientGUI {
    private static final String LOOK_AND_FEEL_STYLE_PATH = "style.xml";
    
    private MainGUI gui;
    
    /**
     * Initializes all gui components.
     * @param title
     */
    private void initGui(){ 
        SynthLookAndFeel synth = new SynthLookAndFeel();
        try {
            synth.load(Main.class.getClassLoader().getResource(LOOK_AND_FEEL_STYLE_PATH));
            UIManager.setLookAndFeel(synth);
        } catch (Exception ex) {
            Logger.getLogger(ClientGUI.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error in INIT GUI");
            System.exit(1);
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                gui = new MainGUI();
                gui.setTitle("Cards Against Humanity");
                gui.setVisible(true);
            }
        });
        
    }
    public static void main(String[] args) {
        try {
            final ClientGUI gui = new ClientGUI();
            SwingUtilities.invokeAndWait(new Runnable() {
                
                @Override
                public void run() {
                    gui.initGui();
                }
            });
        } catch (InterruptedException ex) {
            Logger.getLogger(ClientGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(ClientGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
