/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f_family;



import initialization.initialization_f_family03_info_button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

/**
 *
 * @author DELL
 */
public class f_family03_info_button {
      JPanel p = new JPanel();
  
  
       
    public f_family03_info_button() {
        i_initialize_p();
      }
    
     public void i_initialize_p(){
   
         p.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 10));
     p.setPreferredSize(new Dimension(200,50));
     p.setBounds(0,0,200,50);
     p.setOpaque(true);
     p.setBackground( new Color(255, 255, 255,50) ); 
        
     p.add(initialization_f_family03_info_button.f_info_button_01_B_C_B_A);
     }
     
     public JPanel s_f_family03_info_p(){
     
         return p;
     }
}
