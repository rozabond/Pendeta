/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafile;

import initialization.initialization;
import initialization.initialization_genesis;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import static java.lang.String.valueOf;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileSystemView;
/**
 *
 * @author DELL
 */
public class J_SampleJFileChooser {
String  input;
    
    public  J_SampleJFileChooser() {
         
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setCurrentDirectory(new File(FileSystemView.getFileSystemView().getDefaultDirectory().getPath()));
            //  jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            JFrame aku = new JFrame();
           
                    String f_icon = new File("icon.png").getAbsolutePath();
ImageIcon imgicon = new ImageIcon(f_icon);
 aku.setIconImage(imgicon.getImage());
   
        int result = jFileChooser.showOpenDialog(aku);
     
     
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jFileChooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
            initialization_genesis.input = selectedFile.getAbsolutePath();
        }
    }
    
    public  void deploy() throws IOException{
        copyFileUsingJava7Files();
    }
    
    public Image f_display_image() throws IOException{
         BufferedImage img = null;
    //ImageIcon imageIcon = new ImageIcon(new ImageIcon(getClass().getResource(input)).getImage().getScaledInstance(120,150, Image.SCALE_DEFAULT));      
                  //Image tmpImage = imageIcon.getImage();   
                   img = ImageIO.read(new File(initialization_genesis.input));
         
                  
   return img;
    }

    public void copyFileUsingJava7Files() throws IOException {
         Path path = Paths.get(input);
            String getFilePath = new File("").getAbsolutePath();
            File fs = new File(getFilePath.concat("\\src\\image\\"));
            String[] pathnames = fs.list();
          
            // String number = String.valueOf(pathnames.length);
            Path output = Paths.get(getFilePath.concat("\\src\\image\\gereja").concat(initialization.gereja).concat(".png"));
            System.out.println("Selected file: " + output);            
      System.out.println(pathnames.length);
          
    Files.copy(path, output);
}
     
    private String j_returnfilepath() {
final File folder = new File("/home/you/Desktop");
listFilesForFolder(folder);          
          return FileSystemView.getFileSystemView().getDefaultDirectory().getPath()+"\\TanyaPendeta\\Church\\";
            
    }
    
    public void listFilesForFolder(final File folder) {
    for (final File fileEntry : folder.listFiles()) {
      
            System.out.println(fileEntry.getName());
        
    }
}


    public static void main(String[] args) {
        new J_SampleJFileChooser();
    }   
    
}
