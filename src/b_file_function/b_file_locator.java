/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b_file_function;

import initialization.initialization;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafile.J_DefaultImage;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author DELL
 */
public class b_file_locator {

  boolean indicator = false;    
  
  public b_file_locator() {
      j_returnfilepath();
  }
  
private void j_returnfilepath() {
    final File folder = new File(FileSystemView.getFileSystemView().getDefaultDirectory().getPath()+File.separator+"TanyaPendeta"+File.separator+"Church");
    d_listFilesForFolder(folder);          
         // return FileSystemView.getFileSystemView().getDefaultDirectory().getPath()+"\\TanyaPendeta\\Church\\";
}

public String F_returnString(){
    if(initialization.gereja == null) {
        // For beginning
      //    final File folder = new File(FileSystemView.getFileSystemView().getDefaultDirectory().getPath()+"\\TanyaPendeta\\Church\\Genesis\\");
    Path path = Paths.get(FileSystemView.getFileSystemView().getDefaultDirectory().getPath()+File.separator+"TanyaPendeta"+File.separator+"Church"+File.separator+"Genesis");

        try {
            Files.createDirectories(path);
        } catch (IOException ex) {
            Logger.getLogger(b_file_locator.class.getName()).log(Level.SEVERE, null, ex);
        }
    //d_listFilesForFolder(folder);
    initialization.gereja = "Genesis";
    }    
    return FileSystemView.getFileSystemView().getDefaultDirectory().getPath()+File.separator+"TanyaPendeta"+File.separator+"Church"+File.separator+initialization.gereja;
}

public String F_return_ChurchString(){
   if(initialization.gereja == null) {
        // For beginning
      //    final File folder = new File(FileSystemView.getFileSystemView().getDefaultDirectory().getPath()+"\\TanyaPendeta\\Church\\Genesis\\");
    Path path = Paths.get(FileSystemView.getFileSystemView().getDefaultDirectory().getPath()+File.separator+"TanyaPendeta"+File.separator+"Church"+File.separator+"Genesis"+File.separator);

        try {
            Files.createDirectories(path);
        } catch (IOException ex) {
            Logger.getLogger(b_file_locator.class.getName()).log(Level.SEVERE, null, ex);
        }
    //d_listFilesForFolder(folder);
    initialization.gereja = "Genesis";
    }
   
   //21/6/2021 why it is actually here
   if(initialization.gereja != "Genesis"){
         initialization.gereja = "Genesis";
   }
    return FileSystemView.getFileSystemView().getDefaultDirectory().getPath()+File.separator+"TanyaPendeta"+File.separator+"Church"+File.separator+initialization.gereja;

}

public static String F_returnString_Church(){
    return FileSystemView.getFileSystemView().getDefaultDirectory().getPath()+File.separator+"TanyaPendeta"+File.separator+"Church";
}

public String F_returnFullname(String name){
            File fs = new File(F_returnString().concat(File.separator+"image"+File.separator));
            String[] pathnames = fs.list();
            String nama = null;
            for (String i : pathnames) {
                
            System.out.println(i+"pain in the ass");
            //21/6/2021 debugging process, it is quite fun
            // accessing each element of array
            //System.out.println(name.replace(" ","_")+"_"+i);
     
            if(name.replace(" ","_").concat(".png").equals(i)){    
                nama = i;
            }
         
        }
            if(nama == null){
            nama = "default.png";
            }
          
            
            return nama;
}

private void F_imagenull(){
    
}

private void d_listFilesForFolder(final File folder) {
      boolean indicator = false; 
    
      if(folder.exists()){
    for (final File fileEntry : folder.listFiles()) {
        
     if(initialization.gereja != null){
    if(fileEntry.getName().equals(initialization.gereja)){
         indicator = true;
     } 
     }
    }
    
    if(initialization.gereja == null){
        indicator = true;
    }
    
     if (indicator == false){
           try {

            Path path = Paths.get(FileSystemView.getFileSystemView().getDefaultDirectory().getPath()+File.separator+"TanyaPendeta"+File.separator+"Church"+File.separator+initialization.gereja+File.separator+"image");

            Files.createDirectories(path);
            
            // add the default image 1/6/2021
            J_DefaultImage im = new J_DefaultImage();
            im.J_DefaultImage_C();
            System.out.println("Directory is created!");
            
            //Files.createDirectory(path);

        } catch (IOException e) {
            System.err.println("Failed to create directory!" + e.getMessage());
        }
    }
      }else{
        Path path = Paths.get(FileSystemView.getFileSystemView().getDefaultDirectory().getPath()+File.separator+"TanyaPendeta"+File.separator+"Church");
          try {
              Files.createDirectories(path);
          } catch (IOException ex) {
              Logger.getLogger(b_file_locator.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
}




public void listFilesForFolder(final File folder) {
    for (final File fileEntry : folder.listFiles()) {
      
            System.out.println(fileEntry.getName());
     if(fileEntry.getName() == "TanyaPendeta"){
         indicator = true;
     } 
    }
    
    if (indicator == false){
           try {

            Path path = Paths.get(FileSystemView.getFileSystemView().getDefaultDirectory().getPath()+File.separator+"TanyaPendeta"+File.separator+"Church"+File.separator);

            Files.createDirectories(path);

            System.out.println("Directory is created!");

            //Files.createDirectory(path);

        } catch (IOException e) {
            System.err.println("Failed to create directory!" + e.getMessage());
        }
    }
}
       
}
