package de.CardsAgainstHumanity;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

/**
 *
 * @author Timo
 */
public class Utils {

    public static final byte OS_UNKNOWN = -1;
    public static final byte OS_WIN = 0;
    public static final byte OS_UNIX = 1;
    public static final byte OS_SOLARIS = 2;
    public static final byte OS_MAC = 3;
    
    public static final String nl = System.getProperty("line.separator");
    
    /**
     * Determines the current operating system.
     * 
     * @return 
     */
    public static byte getOS(){
        String os = System.getProperty("os.name").toLowerCase();
        if(os.indexOf("win") >= 0){
            return OS_WIN;
        }else if(os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0){
            return OS_UNIX;
        }else if(os.indexOf("sunos") >= 0){
            return OS_SOLARIS;
        }else if(os.indexOf("mac") >= 0){
            return OS_MAC;
        }
        return OS_UNKNOWN;
    }

    
    /**
     * Loads text from a file and returns it as string.
     * 
     * @param path
     * @return 
     */
    public static String loadFile(String path) {
        BufferedReader br = null;
        String line = null;
        StringBuilder sb = new StringBuilder();
        try {
            br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                line += System.getProperty("line.separator");
                sb.append(line);
            }
        } catch (FileNotFoundException e) {
            
        } catch (IOException e) {
            
        } finally {
            try {
                if(br != null)br.close();
            } catch (IOException e) {
                
            }
        }
        return sb.toString();
    }
    
    /**
     * Function to get a proper formated date-string.
     * 
     * @return 
     */
    public static String getFormatedDate(){
        Calendar c = Calendar.getInstance();
        String formatedDate = "";
        formatedDate += c.get(Calendar.DAY_OF_MONTH)+"/";
        formatedDate += (c.get(Calendar.MONTH)+1)+"/";
        formatedDate += c.get(Calendar.YEAR)+" ";
        formatedDate += c.get(Calendar.HOUR_OF_DAY)+":";
        formatedDate += c.get(Calendar.MINUTE)+":";
        formatedDate += c.get(Calendar.SECOND);
        return  formatedDate;
    }
}
