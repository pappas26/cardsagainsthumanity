package de.CardsAgainstHumanity;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Timo
 */
public class PropertyManager {
    public static final String DEFAULT_PATH = "data/config.properties";
    
    private File propFile;
    private Properties prop;
    
    public PropertyManager(){
        this(new File(DEFAULT_PATH));
    }
    
    public PropertyManager(String path){
        this(new File(path));
    }
    
    public PropertyManager(File f){
        propFile = f;
        prop = new Properties();
    }
    
    /**
     * If there is no property for the given key, the field is created with
     * the default value.
     * 
     * @param key
     * @param defaultValue
     * @return 
     */
    public String getOrCreateValueAsString(String key, String defaultValue){
        boolean exsists = false;
        for(String s:prop.stringPropertyNames()){
            if(s.equals(key)){
                exsists = true;
                break;
            }
        }
        if(exsists){
            return prop.getProperty(key);
        }else{
            prop.setProperty(key, defaultValue);
            return defaultValue;
        }
    }
    
    /**
     * Adds the string value for given key as a property.
     * 
     * @param key
     * @param value 
     */
    public void setValueAsString(String key, String value){
        prop.setProperty(key, value);
    }
    
    /**
     * Adds the int value for given key as a property.
     * 
     * @param key
     * @param value 
     */
    public int getOrCreateValueAsInt(String key, int defaultValue){
        return Integer.valueOf(getOrCreateValueAsString(key, defaultValue+""));
    }    
    
    /**
     * Loads the properties file from the default path. If the file doesn't
     * exist it's created.
     */
    public void load(){
        BufferedInputStream bfs = null;
        try {
            if(propFile.createNewFile()){
                return;
            }
            bfs = new BufferedInputStream(new FileInputStream(propFile));
            prop.load(bfs);
        } catch (FileNotFoundException ex) {
            
        } catch (IOException ex) {
            
        } finally {
            try {
                if(bfs!=null)bfs.close();
            } catch (IOException ex) {
                
            }
        }
    }
    
    /**
     * Saves the properties file to the default path.
     */
    public void save() {
        BufferedOutputStream bos = null;
        try {
            if(!propFile.exists()){
                File parent = new File(propFile.getParent());
                parent.mkdirs();
                propFile.createNewFile();
            }
            bos = new BufferedOutputStream(new FileOutputStream(propFile));
            prop.store(bos, "Last Edit: " + Utils.getFormatedDate());
        } catch (FileNotFoundException ex) {
            
        } catch (IOException ex) {
            
        } finally {
            try {
                if(bos!=null)bos.close();
            } catch (IOException ex) {
                
            }
        }
    }
}
