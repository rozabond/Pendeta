/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f_button_main;

import g_button_main_folder.f_main_AB;
import g_button_main_folder.f_main_AB_B;
import gereja.f_create_church;
import initialization.initialization;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author DELL
 */
public class f_button_main_AB_import {
     JButton b = (new JButton("Import"));
     int wid;
     public f_button_main_AB_import(int width_button){
     wid = width_button;
     g_button();   
    }
    private void g_button(){
                        b.setPreferredSize(new Dimension(wid-20, 40));
                        b.setBackground( new Color(0, 0, 51, 10) );
                        b.setForeground(Color.white);
                        b.addActionListener(new ActionListener(){  
                        public void actionPerformed(ActionEvent e){             
                            f_create_church gereja_tambah = new f_create_church();
                        f_main_AB box = new f_main_AB(); 
                       f_main_AB_B box_input = new f_main_AB_B();     
                       
                            cleareverything();
                            gereja_tambah.i_initializing_pane_container();
                            //initialization.pane_container.setLayout(new GridLayout(0,2,20,10));
                            initialization.pane_container.add(box.r_returnbox(),3);
                            initialization.pane_container.add(box_input.r_returnbox(),3);
                            initialization.pane_container.repaint();
                            initialization.pane_container.revalidate();
                        }
                        });
    }
    private void cleareverything(){     
    initialization.pane_container.removeAll();
    initialization.e_container.removeAll();
    initialization.pane_container.repaint();
    initialization.e_container.repaint();
    f_main_AB.box.removeAll();
    f_main_AB.box.repaint();

}
 
    
    public JButton r_g_button(){
        return b;
    }
}
