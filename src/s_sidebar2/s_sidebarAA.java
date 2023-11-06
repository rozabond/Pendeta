/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s_sidebar2;


import f_button_main.f_button_main_AA;
import f_button_main.f_button_main_AB_import;
import f_button_main.f_button_main_AC_Add;
import f_button_main.f_button_main_AC_Add_gereja;
import f_button_main.f_button_main_AD_Change;
import f_button_main.f_button_main_AE_logout;
import f_infogereja.i_info_gereja;
import f_searchbar.f_searchbar;
import initialization.initialization;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author DELL
 */
public class s_sidebarAA {
        
    JPanel notes_panel = new javax.swing.JPanel();
    JPanel map_panel = new javax.swing.JPanel();
    JPanel container = new javax.swing.JPanel();

 
    
      public s_sidebarAA(){
initialized_container();
g_addfile_system();

    }  
    
    
       private JPanel initialized_container(){
       //container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS)); 
        container.setLayout(new GridLayout(0,1)); 
        container.setSize(initialization.PanelWidth+100,initialization.screenHeight);
        container.setBounds(0,0,initialization.PanelWidth+100,initialization.PanelHeight);
        container.setOpaque(true);
        container.setBackground( new Color(0, 0, 0) );
     
      return container;
   }
       
       private void g_addfile_system(){
   f_button_main_AA first = new f_button_main_AA(container.getWidth());    
   f_button_main_AB_import imp = new f_button_main_AB_import(container.getWidth());  
   f_button_main_AC_Add add = new f_button_main_AC_Add(container.getWidth());
   f_button_main_AC_Add_gereja gereja = new f_button_main_AC_Add_gereja(container.getWidth());
   f_button_main_AD_Change change = new f_button_main_AD_Change(container.getWidth());  
   f_button_main_AE_logout logout = new f_button_main_AE_logout(container.getWidth());  
   container.add(first.r_g_button());
   container.add(imp.r_g_button());
   container.add(add.r_g_button());
   container.add(gereja.r_g_button());
   container.add(change.r_g_button());
   container.add(logout.r_g_button());
    }
       
    
 public JPanel return_container(){
  return container;
  }
   
}
