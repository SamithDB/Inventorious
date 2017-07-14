/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

import com.alee.laf.WebLookAndFeel;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;

/**
 *
 * @author Hashith
 */
public class H_run {
    public static void main(String[] args) {
        try {
            LookAndFeel look = new WebLookAndFeel();
            UIManager.setLookAndFeel(look);
            new attendance().setVisible(true);
        } catch (Exception e) {
        }
    }
}
