/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timer;

import java.awt.Graphics2D;
import java.awt.SplashScreen;
import java.io.IOException;
import java.util.Date;
import java.util.TimerTask;
import javax.swing.Timer;

/**
 *
 * @author Ali Zeeshan
 */
public class properties_check {

    /**
     * @param args the command line arguments
     */
    private static final int delay = 50;
    private static final int factor = 1;
    
    public static void main(String[] args) {
        try {
            
            splashScreen sp = new splashScreen();
            sp.setVisible(true);
            String filePath = System.getProperty("user.home") + "/Desktop/"+"foo.txt";
            
            ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "dxdiag", "/t", filePath);
            Process p = pb.start();
            p.waitFor();
            
            for (int i = 0; i <= 100; i++) {
                
                Thread.sleep(delay * factor);
                sp.per.setText(Integer.toString(i));
                sp.progress.setValue(i);
                
            }
     
            sp.setVisible(false);
            MainFrame _mf = new MainFrame();
            _mf.show();
              
          
           
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
}
