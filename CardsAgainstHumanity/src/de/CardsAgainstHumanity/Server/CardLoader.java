package de.CardsAgainstHumanity.Server;

import de.CardsAgainstHumanity.Utils;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Timo
 */
public class CardLoader {
    
    public static final String DEFAULT_PATH = "cards/";
    public static final String DEFAULT_WHITE_PATH = "white_cards.txt";
    public static final String DEFAULT_BLACK_PATH = "black_cards.txt";
    
    public static List<String> loadCards(boolean white){
        return loadCards(DEFAULT_PATH,white);
    }
    
    public static List<String> loadCards(String path,boolean white){
        List<String> cardList = new ArrayList<String>();
        String cards = "";
        if(white){
            cards = Utils.loadFile(path+DEFAULT_WHITE_PATH);
        }else{
            cards = Utils.loadFile(path+DEFAULT_BLACK_PATH);
        }
        String [] cardsArray = cards.split(Utils.nl);
        for(String s: cardsArray){
            cardList.add(s);
        }
        return cardList;
    }
}
