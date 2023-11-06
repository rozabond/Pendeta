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
public class J_FileSavedpicture {
    b_file_locator file = new b_file_locator();
   
    public J_FileSavedpicture(String Nama){
       try {
           g_copyFileUsingJava7Files(Nama.replace(" ","_"));
       } catch (IOException ex) {
           Logger.getLogger(J_FileSavedpicture.class.getName()).log(Level.SEVERE, null, ex.getMessage());
       }
    }
    
        public void g_copyFileUsingJava7Files(String Nama) throws IOException {
            
          /*  if(initialization_genesis.input == null){
                initialization_genesis.input = file.F_returnString_Church()+"\\default.png";
            }*/
          if(initialization_genesis.input != null){
         Path path = Paths.get(initialization_genesis.input);
            String getFilePath = new File("").getAbsolutePath();
            File fs = new File(b_file_locator.F_returnString_Church());
            String[] pathnames = fs.list();
          
           // b_file_locator.F_returnString().concat("\\church.db");
            String number = String.valueOf(pathnames.length);
            Path output = Paths.get(file.F_returnString().concat("\\image\\").concat(Nama).concat(".png"));
           // System.out.println("Selected file: " + output);            
            //System.out.println(pathnames.length);
          
    Files.copy(path, output);
          }
    initialization_genesis.input = null;
}
        
        public void g_send_default() throws IOException {
        String getFilePath = new File("").getAbsolutePath();
                                   String fileAbsolutePath = "";
   
                                   fileAbsolutePath = getFilePath.concat("\\img\\");
    initialization_genesis.input = fileAbsolutePath+"default.png";
            
    Path path = Paths.get(initialization_genesis.input);

    Path output = Paths.get(file.F_returnString().concat("\\image\\default.png"));
           // System.out.println("Selected file: " + output);            
            //System.out.println(pathnames.length);
     
            Files.copy(path, output);
       
    initialization_genesis.input = null;
            
        }
        
}
