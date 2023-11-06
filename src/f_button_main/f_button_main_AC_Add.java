/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f_button_main;

import gereja.f_main_AC;
import gereja.f_main_AC_B;
import gereja.f_save_department;
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
public class f_button_main_AC_Add {
     JButton b = (new JButton("Add Department"));
     int wid;
     
     public f_button_main_AC_Add(int width_button){
     wid = width_button;
     g_button();   
    }
     
     
    private void g_button(){
                        b.setPreferredSize(new Dimension(wid-20, 40));
                        b.setBackground( new Color(0, 0, 51, 10) );
                        b.setForeground(Color.white);
                        b.addActionListener(new ActionListener(){  
                        public void actionPerformed(ActionEvent e){             
                           f_main_AC department = new f_main_AC();
                           f_main_AC_B department_tambah_gambar = new f_main_AC_B();
                           f_save_department return_button = new f_save_department();
                            
                            
                       
                            cleareverything();
                            department.i_initializing_pane_container();
                            //initialization.pane_container.setLayout(new GridLayout(0,2,20,10));
                            initialization.pane_container.add(department_tambah_gambar.side_bar_add(),3);
                            initialization.pane_container.add(department.return_notes01_B(),3);
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

}
 
    
    public JButton r_g_button(){
        return b;
    }
}
