/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package initialization;

import connection.c_connection_search;
import f_seachbar.f_button;
import f_searchbar.f_searchbar;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

/**
 *
 * @author DELL
 */
public class initialization_f_searchbar_button {
       public static JButton notes01_B_A_T_B=  new JButton("Search");
           static int notes01_B_A_T_B_P_width = initialization.Containerpanelwidth/4;
    
       
        
  public static void cleareverything(){
     initialization.pane_container.removeAll();
    // initialization.container.removeAll();
     initialization.check_number = 0;
     initialization.e_container.removeAll();
     initialization.e_container.repaint();
     initialization.e_container.revalidate();
}
       
       public static void initilialized_action_button(){
           //notes01_B_A_T_B.setBackground(new Color(222,220,137));
            notes01_B_A_T_B.setForeground(new Color(255,255,255));
             notes01_B_A_T_B.setPreferredSize(new Dimension(notes01_B_A_T_B_P_width-3,30));
            // notes01_B_A_T_B.setBorder(new LineBorder(new Color(5,217,229)));
         notes01_B_A_T_B.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
            if(!initialization.notes01_B_A_T.getText().isEmpty()){
               cleareverything();
                c_connection_search box = new c_connection_search();
               f_button bar = new f_button(box.i_f_search(initialization.notes01_B_A_T.getText().trim().replace(" ","_"))); 
               initialization.pane_container.add(bar.return_scrollPanel());
            }
   }});
       }
}
