/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f_button_main;

import initialization.initialization;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import login.F_Encrype_main;

/**
 *
 * @author DELL
 */
public class f_button_main_AE_logout {
     JButton b = (new JButton("Logout"));
     int wid;
     public f_button_main_AE_logout(int width_button){
     wid = width_button;
     g_button();   
    }
    private void g_button(){
                        b.setPreferredSize(new Dimension(wid-20, 40));
                        b.setBackground( new Color(0, 0, 51, 10) );
                        b.setForeground(Color.white);
                        b.addActionListener(new ActionListener(){  
                        public void actionPerformed(ActionEvent e){   
                            F_Encrype_main encrpt    = new F_Encrype_main();
                            encrpt.F_illiterating_encrypt();
                        cleareverything();
                         System.exit(0);
                        }
                        });
    }
    private void cleareverything(){     
    initialization.pane_container.removeAll();
    initialization.e_container.removeAll();
    initialization.pane_container.repaint();
    initialization.e_container.repaint();

}
 
    
    public JButton r_g_button(){
        return b;
    }
}
