/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafile;

import b_file_function.b_file_locator;
import initialization.initialization;
import initialization.initialization_genesis;
import java.io.File;
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
public class J_poepleImageSaved {
      b_file_locator file = new b_file_locator();
   public J_poepleImageSaved(String Nama){
       try {
           g_copyFileUsingJava7Files(Nama);
       } catch (IOException ex) {
           Logger.getLogger(J_poepleImageSaved.class.getName()).log(Level.SEVERE, null, ex.getMessage());
       }
    }
    
        public void g_copyFileUsingJava7Files(String Nama) throws IOException {
            // 9/8/2021 i mansuh kan this item, so that the image that is generally bukan default tidak perlu upload pergi main file
            /*  if(initialization_genesis.input == null){
                   initialization_genesis.input = file.F_returnString_Church()+"\\default.png";
                   System.out.println("adakah betul2 default...testing");
            }*/
            
              if(initialization_genesis.input != null){
            Path path = Paths.get(initialization_genesis.input);
            String getFilePath = new File("").getAbsolutePath();
            Path output = Paths.get(file.F_returnString().concat("\\image\\").concat(Nama).concat(".png"));
           // System.out.println("Selected file: " + output);            
            //System.out.println(pathnames.length);
          
    Files.copy(path, output);
              }
    initialization_genesis.input = null;
}
        
       
        
}
