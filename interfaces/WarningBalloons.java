/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

import java.awt.Color;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import net.java.balloontip.BalloonTip;
import net.java.balloontip.styles.*;

/**
 *
 * @author Deeptha
 */
public class WarningBalloons {
    public static BalloonTip getTip(JComponent com,String text){
        JLabel lbl = new JLabel(text);
        lbl.setForeground(Color.white);
        BalloonTipStyle style;
        style = new RoundedBalloonStyle(5, 5, Color.black , Color.black);
        BalloonTip tip = new BalloonTip(com,lbl,style,BalloonTip.Orientation.RIGHT_ABOVE,BalloonTip.AttachLocation.EAST,50,10,false);
        return tip;   
    }
}
