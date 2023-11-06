/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gereja;

import b_file_function.b_file_encryption_cannidate;
import static b_file_function.b_file_encryption_cannidate.stack;
import connection.c_connection_church;
import initialization.initialization;
import initialization.initialization_genesis;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.Normalizer;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafile.J_FileSavedpicture;
import javax.swing.JButton;

/**
 *
 * @author DELL
 */
public class f_save_church {
  
    String church_name= null;
    f_create_guirapaint button = new f_create_guirapaint();
    public f_save_church(){

    }
    
    public void g_save_name(){
     //initialization.gereja = initialization.notes01_B_A_T.getText().trim().replace(" ","_");  
     //imortant to know that i put it here
     c_connection_church church = new c_connection_church();      
     
        String withoutAccent = Normalizer.normalize(initialization.notes01_B_A_T.getText().trim(), Normalizer.Form.NFD);
    String output = withoutAccent.replaceAll("[^a-zA-Z0-9\\s\\.]","_");
     initialization.gereja = output.replaceAll(" ", "_");
    
    String withoutAccent_2 = Normalizer.normalize(initialization.notes01_B_B_T.getText().trim(), Normalizer.Form.NFD);
    String output_2 = withoutAccent_2.replaceAll("[^a-zA-Z0-9\\s\\.]","_");
    String matter = output_2.replaceAll(" ", "_");
     
      
     church_name = initialization.gereja; 
     initialization_genesis.Church_name = church_name;
     church.f_add_data("FALSE",initialization.gereja, matter);
    
     J_FileSavedpicture save = new J_FileSavedpicture(initialization.gereja);
        try {
            save.g_send_default();
        } catch (IOException ex) {
            Logger.getLogger(f_save_church.class.getName()).log(Level.SEVERE, null, ex);
        }
     initialization.notes01_B_A_T.setText("");
     initialization.notes01_B_B_T.setText("");
     b_file_encryption_cannidate encrypt = new b_file_encryption_cannidate();
     encrypt.R_stack().add(matter);
     stack.add(initialization.gereja);
    }
    
    public JButton g_return_savebutton(){
          JButton b = (new JButton(church_name));
                        b.setPreferredSize(new Dimension(100, 40));
                        b.setBackground( new Color(0, 0, 51, 10) );
                        b.setForeground(Color.white);
                        b.addActionListener(new ActionListener(){  
                        public void actionPerformed(ActionEvent e){  
                          // f_create_guirapaint button = new f_create_guirapaint();
                          button.g_repaint();
                        }
                        });
                        
        return b;
    }
    
}
