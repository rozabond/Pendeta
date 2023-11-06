/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gereja;

import initialization.initialization_genesis;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author DELL
 */
public class i_canvas_main_image implements Icon {
            BufferedImage img = null;
    //ImageIcon imageIcon = new ImageIcon(new ImageIcon(getClass().getResource(input)).getImage().getScaledInstance(120,150, Image.SCALE_DEFAULT));      
                  //Image tmpImage = imageIcon.getImage();   
              
                  
      
   /* public void paint(Graphics g) {  
  
        Toolkit t=Toolkit.getDefaultToolkit();  
        Image i=t.getImage(initialization_genesis.input);  
        
        BufferedImage img = null; 
        try {
            img = ImageIO.read(new File(initialization_genesis.input));
        } catch (IOException ex) {
            Logger.getLogger(i_canvas_main_image.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        g.drawImage(img, 120,100,this);  
          
    }  
*/
    @Override
    public void paintIcon(Component cmpnt, Graphics grphcs, int i, int i1) {
                try {
                    img = ImageIO.read(new File(initialization_genesis.input));
                } catch (IOException ex) {
                    Logger.getLogger(i_canvas_main_image.class.getName()).log(Level.SEVERE, null, ex);
                }
         
     //super.paintComponent(g);
                        Graphics2D g2d = (Graphics2D) grphcs;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int w = 150;
        int h = 160;
        Color color1 = new Color(0, 0, 255);
        Color color2 =  new Color(147, 112, 219);
        GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
        g2d.drawImage(img, 0, 0, null);
                            
    g2d.dispose();
    }

    @Override
    public int getIconWidth() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getIconHeight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
