/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f_family;

import b_file_function.b_file_locator;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author DELL
 */
public class f_family01_g_image {
    
    String nama = "";
    
  public  f_family01_g_image(String name){
    nama = name;
    }
  
private void g_returnpath(){
        
    }
    
public Image g_uploadimage() throws IOException{
    String path_1 = "";
     b_file_locator file = new b_file_locator();
     String name = file.F_returnFullname(nama);
     String path = file.F_returnString()+File.separator+"image"+File.separator+name;
     System.out.println(path + "hoho");
        BufferedImage img = null;
    //ImageIcon imageIcon = new ImageIcon(new ImageIcon(getClass().getResource(input)).getImage().getScaledInstance(120,150, Image.SCALE_DEFAULT));      
                  //Image tmpImage = imageIcon.getImage();   
     
                  img = ImageIO.read(new File(path));
   //  ImageIcon imageIcon = new ImageIcon(path);
   //  Image tmpImage = imageIcon.getImage();         
      // get width and height
      
    
   
     return img;
    }
}
