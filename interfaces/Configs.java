/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 *
 * @author Thusitha
 */
public class Configs {
    
    public static Properties prop = new Properties();
    
    public void SaveProp(String title,String value){
        try {
            prop.setProperty(title, value);
            prop.store(new FileOutputStream("config.cnf"), null);
        } catch (Exception e) {
        }
    }
    
    public String getProp(String title){
        String value="";
        try {
            prop.load(new FileInputStream("config.cnf"));
            value = prop.getProperty(title);
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return value;
    }
}
