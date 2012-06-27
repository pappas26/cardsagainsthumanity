package de.CardsAgainstHumanity.Client.Interfaces;

/**
 *
 * @author Timo
 */
public interface ClientCallback {
    
    public void disconnect();
    
    public void sendMessage(String s);
    
    public void sendSystemMessage(String s);
    
    public void giveCard(String text);
    
    public void sendCardInformation(String text, String player);
    
    public void synchronizeGameTime(long time);
    
    public void startRound(boolean b);
    
    public void startGame(boolean b);
}
