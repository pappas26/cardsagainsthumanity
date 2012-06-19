package de.CardsAgainstHumanity.Client.Interfaces;

/**
 *
 * @author Timo
 */
public interface ClientCallback {
    
    public void disconnect();
    
    public void sendMessage(String s);
    
    public void sendSystemMessage(String s);
}
