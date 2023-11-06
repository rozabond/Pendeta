/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafile;


import b_file_function.b_file_locator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class J_DefaultImage {
     
    b_file_locator file = new b_file_locator();
    public J_DefaultImage(){
     
    }
    
        public void g_copyFileUsingDefaultimage() throws IOException {
            
           
            
         Path path = Paths.get(file.F_returnString_Church().concat("\\default.png"));
   
           // b_file_locator.F_returnString().concat("\\church.db");
          Path output = Paths.get(file.F_returnString().concat("\\image\\").concat("default").concat(".png"));
           // System.out.println("Selected file: " + output);            
            //System.out.println(pathnames.length);
          
    Files.copy(path, output);
}
        
     public void J_DefaultImage_C(){
       try {
           g_copyFileUsingDefaultimage();
       } catch (IOException ex) {
           Logger.getLogger(J_poepleImageSaved.class.getName()).log(Level.SEVERE, null, ex.getMessage());
       }
     }
        
}
