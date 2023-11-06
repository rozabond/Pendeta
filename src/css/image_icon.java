package css;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.*;
import javax.swing.*;

public class image_icon extends JFrame {
   JPanel mainPanel = new JPanel() {
        ImageIcon originalIcon = new ImageIcon(new ImageIcon(getClass().getResource("/images_main/logo.png")).getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT));

      //ImageIcon originalIcon = new ImageIcon("~/Pictures/apple.png");

      ImageFilter filter = new RGBImageFilter() {
         int transparentColor = Color.white.getRGB() | 0xFF000000;

         public final int filterRGB(int x, int y, int rgb) {
            if ((rgb | 0xFF000000) == transparentColor) {
               return 0x00FFFFFF & rgb;
            } else {
               return rgb;
            }
         }
      };

      ImageProducer filteredImgProd = new FilteredImageSource(originalIcon.getImage().getSource(), filter);
      Image transparentImg = Toolkit.getDefaultToolkit().createImage(filteredImgProd);

      public void paintComponent(Graphics g) {
         g.setColor(getBackground());
         g.fillRect(0, 0, getSize().width, getSize().height);

         // draw the original icon
         g.drawImage(originalIcon.getImage(), 100, 10, this);
         // draw the transparent icon
         g.drawImage(transparentImg, 140, 10, this);
      }
   };

   
   //8.12.2020 a functio that i did, in order to get the transparent stuff been filtered out, in order that the images could be put in computer from sketch
   public static Image changethepixelimages(ImageIcon i) {
         ImageFilter filter = new RGBImageFilter() {
         int transparentColor = Color.white.getRGB() | 0xFF000000;

         public final int filterRGB(int x, int y, int rgb) {
            if ((rgb | 0xFF000000) == transparentColor) {
               return 0x00FFFFFF & rgb;
            } else {
               return rgb;
            }
         }
      };

      ImageProducer filteredImgProd = new FilteredImageSource(i.getImage().getSource(), filter);
      Image transparentImg = Toolkit.getDefaultToolkit().createImage(filteredImgProd);

       
       return transparentImg;
   }
   
   
   public void change_image_color(BufferedImage img) {
            int width = img.getWidth();
        int height = img.getHeight();
   
    for (int y = 0; y < height; y++)
        {
            for (int x = 0; x < width; x++)
            {
                int p = img.getRGB(x,y);
 
                int a = (p>>255)&0xff;
                int r = (p>>16)&0xff;
 
                // set new RGB
                // keeping the r value same as in original
                // image and setting g and b as 0.
                p = (a<<24) | (5<<16) | (217<<8) | (229<<0);
 
                img.setRGB(x, y, p);
            }
        }
   }
   
   public image_icon() {
 
   }

   public static void main(String[] argv) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
        
         }
      });
   }
}