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
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author DELL
 */
public class b_file_info {

  boolean indicator = false;    
  
  public b_file_info() {
      j_returnfilepath();
  }
  
  
  
private void j_returnfilepath() {
    final File folder = new File(FileSystemView.getFileSystemView().getDefaultDirectory().getPath()+File.separator+"TanyaPendeta");
    d_listFilesForFolder(folder);          
         // return FileSystemView.getFileSystemView().getDefaultDirectory().getPath()+"\\TanyaPendeta\\Church\\";
}

public static String F_returnString_Church(){
    return FileSystemView.getFileSystemView().getDefaultDirectory().getPath()+File.separator+"TanyaPendeta"+File.separator+"Info";
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


private void d_listFilesForFolder(final File folder) {
    
    if(folder.exists()){
    for (final File fileEntry : folder.listFiles()) {
      
            System.out.println(fileEntry.getName());
     if("Info".equals(fileEntry.getName())){
         indicator = true;
     } 
    }
        
    if (indicator == false){
           try {

            Path path = Paths.get(FileSystemView.getFileSystemView().getDefaultDirectory().getPath()+File.separator+"TanyaPendeta"+File.separator+"Info");

            Files.createDirectories(path);

            System.out.println("Directory is created!");

            //Files.createDirectory(path);

        } catch (IOException e) {
            System.err.println("Failed to create directory!" + e.getMessage());
        }
    }
    }else{
           Path paths = Paths.get(FileSystemView.getFileSystemView().getDefaultDirectory().getPath()+File.separator+"TanyaPendeta"+File.separator+"Info");

        try {
            Files.createDirectories(paths);
        } catch (IOException ex) {
            Logger.getLogger(b_file_info.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}




public void listFilesForFolder(final File folder) {
    if(folder.exists()){
    for (final File fileEntry : folder.listFiles()) {
      
            System.out.println(fileEntry.getName());
     if(fileEntry.getName() == "Info"){
         indicator = true;
     } 
    }
    
    if (indicator == false){
           try {

            Path path = Paths.get(FileSystemView.getFileSystemView().getDefaultDirectory().getPath()+File.separator+"TanyaPendeta"+File.separator+"Info");

            Files.createDirectories(path);

            System.out.println("Directory is created!");

            //Files.createDirectory(path);

        } catch (IOException e) {
            System.err.println("Failed to create directory!" + e.getMessage());
        }
    }
    }
}
       
}
