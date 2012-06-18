package de.CardsAgainstHumanity.Client.Game;

/**
 *
 * @author Timo
 */
public class Card {
    public static final byte WHITE_CARD = 0;
    public static final byte BLACK_CARD = 1;
    
    private String text;
    
    public Card(String text){
        this.text = text;
    }
    
    @Override
    public String toString(){
        return text;
    }
}
