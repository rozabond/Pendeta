/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f_file_gereja;

import initialization.initialization;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Stack;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

/**
 *
 * @author DELL
 */
public class f_file_gereja_A {
        
    JPanel contai = new javax.swing.JPanel();
    
    JPanel f_file_panel = new javax.swing.JPanel();
    


    
    int f_file_panel_width = initialization.notes_panel_width;
    int f_file_panel_height = initialization.notes_panel_height;
    int f_file_panel_A_width = initialization.notes_panel_width;
    int f_file_panel_A_height = 30;
    
public f_file_gereja_A(){
initialized_container();
i_integration();

    }  
    
    
private JPanel initialized_container(){
      //f_file_panel.setLayout(new BoxLayout(f_file_panel, BoxLayout.PAGE_AXIS)); 
        f_file_panel.setPreferredSize(new Dimension(f_file_panel_width,f_file_panel_height));
        f_file_panel.setBounds(0,0,f_file_panel_width,f_file_panel_height);
        f_file_panel.setOpaque(true);
        f_file_panel.setBackground( new Color(0, 0, 0) );
     
      return f_file_panel;
}

private JPanel initialized_container_A(String label){
    JPanel f_file_panel_A = new javax.swing.JPanel();
    JLabel f_file_panel_A_J = new JLabel(label);
 /*      FlowLayout experimentLayout = new FlowLayout(FlowLayout.LEFT, 40, 0);
    
         
       f_file_panel_A.setLayout(experimentLayout);*/
    SpringLayout layout = new SpringLayout();
                         f_file_panel_A.setLayout(layout);
 
       f_file_panel_A.setPreferredSize(new Dimension(f_file_panel_A_width,f_file_panel_A_height));
        f_file_panel_A.setBounds(0,0,f_file_panel_A_width,f_file_panel_A_height);
        f_file_panel_A.setOpaque(true);
        f_file_panel_A.setBackground( new Color(255, 255, 255) );
        
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, f_file_panel_A_J, 0, SpringLayout.HORIZONTAL_CENTER, f_file_panel_A);                          
        //layout.putConstraint(SpringLayout.SOUTH, f_file_panel_A_J,0,SpringLayout.SOUTH, f_file_panel_A);
                       
        
         f_file_panel_A_J.setSize(new Dimension(150,30));
          f_file_panel_A_J.setHorizontalAlignment(SwingConstants.CENTER);
          f_file_panel_A_J.setVerticalAlignment(SwingConstants.BOTTOM);
        
          
          
          
        f_file_panel_A.add(f_file_panel_A_J);
        
        return f_file_panel_A;
}

private void i_integration(){
 
      Stack<String> STACK = g_addfile_system();

while(!STACK.empty()){
          System.out.println(STACK.size()+"apa yang actually berada di sini ahh");
 f_file_panel.add(initialized_container_A((String) STACK.pop()));   
 }
f_file_panel.repaint();
f_file_panel.revalidate();

}

private Stack g_addfile_system(){
           f_list_directory file = new f_list_directory();
            
           return file.f_fileshow();
       }

public JPanel f_file_panel_return(){
    return f_file_panel;
}
       
  
}
