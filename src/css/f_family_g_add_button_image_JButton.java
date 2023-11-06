/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package css;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author DELL
 */
public class f_family_g_add_button_image_JButton extends JButton {
     @Override
    protected void paintComponent(Graphics g) {
        int x = 30;
int y = 50;
int width = 120;
int height = 35;
int arcWidth = 20;
int arcHeight = 20;
final int R = 240;
final int G = 240;
final int B = 240;
        

        Rectangle2D shape = new Rectangle2D.Float();
        shape.setFrame(0, 60, 120,50);
        Graphics2D g2 = (Graphics2D) g; 
        g2.setColor(new Color(156,217,229));
        g2.drawRoundRect(10, 60, width , height , arcWidth , arcHeight );
        Rectangle2D shape2 = new Rectangle2D.Float();
        shape2.setFrame(85, 25, 120,50);
        Path2D.Double path = new Path2D.Double();
        path.append(shape2, false);
        
        AffineTransform t = new AffineTransform();
        t.rotate(Math.toRadians(90), shape2.getX(), shape2.getY());

       // t.rotate(Math.toRadians(45));
        path.transform(t);
        g2.setColor(new Color(156,217,229));
        g2.drawRoundRect(53, 20, height , width , arcWidth , arcHeight );
        
        g2.setColor( getBackground() );
        g2.fillRect(0, 0, getWidth(), getHeight());
                super.paintComponent(g);
//g2.draw(path);
        
             /*  Paint p =
                        new GradientPaint(0.0f, 0.0f, new Color(0, 0, 0, ),
                            0.0f, getHeight(), new Color(0, 0, 0, 10), true);
               
                g2.setPaint(p);
                    g2.fillRect(0, 0, getWidth(), getHeight()); */
    }
}
