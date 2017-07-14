/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

import com.alee.laf.WebLookAndFeel;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Thusitha
 */
public class BuildPC {

    /**
     * @param args the command line arguments
     */
            static login log = new login();
    public static void main(String[] args) {
        // TODO code application logic here
        LookAndFeel l = new WebLookAndFeel();
        try {
            UIManager.setLookAndFeel(l);
            log.setVisible(true);
//            new Home().setVisible(true);
            
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
    }
    
}
