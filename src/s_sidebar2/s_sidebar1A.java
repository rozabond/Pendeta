/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s_sidebar2;

import f_file_gereja.f_file_gereja;
import f_infogereja.i_info_gereja;
import f_searchbar.f_searchbar;
import initialization.initialization;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author DELL
 */
public class s_sidebar1A {
        
    JPanel notes_panel = new javax.swing.JPanel();
    JPanel map_panel = new javax.swing.JPanel();
    JPanel container = new javax.swing.JPanel();
    
      public s_sidebar1A(){
initialized_container();
g_addfile_system();
g_addinfo_gereja();
    }  
    
    
       private JPanel initialized_container(){
        container.setLayout(new BoxLayout(container,BoxLayout.PAGE_AXIS)); 
        // container.setLayout(new BorderLayout()); 
        container.setSize(initialization.PanelWidth+100,initialization.screenHeight);
        container.setBounds(0,0,initialization.PanelWidth+100,initialization.PanelHeight);
        container.setOpaque(true);
        container.setBackground( new Color(0,0,0,25) );
     
      return container;
   }
       
       private void g_addfile_system(){
          // f_file_gereja file = new f_file_gereja();
          // container.add(file.r_return_gpanel());
          f_searchbar bar = new f_searchbar();
          container.add(bar.return_notes01_B());
          
    }
       
       private void g_addinfo_gereja(){
           i_info_gereja info = new i_info_gereja();
           container.add(info.E_i_info_gereja_P());
       }
       
 public JPanel return_container(){
  return container;
  }
   
}
