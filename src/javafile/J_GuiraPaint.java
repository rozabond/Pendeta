/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafile;

import b_file_function.b_file_encryption_cannidate;
import f_family.f_family01;
import gereja.Pendeta_origin;
import initialization.initialization;
import initialization.initialization_genesis;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import login.F_Encrype_main;
import s_sidebar2.s_sidebar1A;

/**
 *
 * @author DELL
 */
public class J_GuiraPaint {
     public void g_repaint(String name){
 
         //Too make sure got enough space
  if( initialization_genesis.jp.getComponentCount() > 18){
      initialization_genesis.jp.setPreferredSize(new Dimension(0,initialization.familypanelHeight+initialization_genesis.jp.getComponentCount()*36));
   //   initialization_genesis.jp.setLayout(new GridLayout(0,1,0,0));
  }
                        JButton b = (new JButton(name.replaceAll("_"," ")));
                        b.setName(name);
                        b.setHorizontalAlignment(SwingConstants.LEFT);
                        b.setPreferredSize(new Dimension(initialization_genesis.jp.getWidth()-20, 40));
                        b.setBackground( new Color(0, 0, 51, 10) );
                        b.setForeground(Color.white);
                        b.addActionListener(new ActionListener(){  
                        public void actionPerformed(ActionEvent e){  
                       
                            cleareverything();
                           JButton o = (JButton)e.getSource(); 
                           initialization.gereja =o.getName().replaceAll(" ","_");
                      
                           F_Decryt_name();
                   
                           s_sidebar1A side = new s_sidebar1A(); 
                           initialization.container();
                           initialization.container.add(side.return_container());
                           initialization.container.repaint();
                           initialization.container.revalidate();
                  
                           //it work!!
                           f_family01 family = new f_family01(); 
                           initialization.pane_container();
                           initialization.pane_container.add(family.return_scrollPanel(),3);
                            initialization.pane_container.setBackground(null);
                           initialization.pane_container.repaint();
                           initialization.pane_container.revalidate();
                             
                          //daman...finally i get the result, this things get rosak before it even display the result
                          // display_orang orang = new display_orang();
                          // orang.setVisible(true)
                           
                      
                          
                        }  });  
                     
                         initialization_genesis.jp.add(b);
                         initialization_genesis.jp.revalidate();
                         initialization_genesis.jp.repaint();
                   
    }
     
           private void F_Decryt_name(){
    b_file_encryption_cannidate name = new b_file_encryption_cannidate();
    
    if(!name.R_stack().contains(initialization.gereja)){
       F_Encrype_main decryp = new F_Encrype_main();
        decryp.F_illiterating_decrypt();
    };
}
     
         private void cleareverything(){
  
    initialization.pane_container.removeAll();
    initialization.container.removeAll();
    initialization.e_container.removeAll();
    Pendeta_origin.jLayeredPane2.remove(Pendeta_origin.jLabel1);
      Pendeta_origin.jLayeredPane2.repaint();
        Pendeta_origin.jLayeredPane2.revalidate();
    //initialization_genesis.jp.removeAll();
    initialization.notes01_B_A_T.setText("");
    initialization.notes01_B_B_T.setText("");
        initialization_genesis.input = null;
}
   
    
}
