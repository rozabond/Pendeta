/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package css;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

/**
 *
 * @author DELL
 */
public class f_family_g_add_button_image extends JPanel {
     @Override
    protected void paintComponent(Graphics g) {
        int x = 30;
int y = 50;
int width = 120;
int height = 35;
int arcWidth = 20;
int arcHeight = 20;
 
        
        super.paintComponent(g);
        Rectangle2D shape = new Rectangle2D.Float();
        shape.setFrame(0, 60, 120,50);
        Graphics2D g2 = (Graphics2D) g; 
        g2.setColor(new Color(156,217,229));
        g2.drawRoundRect(0, 60, width , height , arcWidth , arcHeight );
        Rectangle2D shape2 = new Rectangle2D.Float();
        shape2.setFrame(85, 25, 120,50);
        Path2D.Double path = new Path2D.Double();
        path.append(shape2, false);
        
        AffineTransform t = new AffineTransform();
        t.rotate(Math.toRadians(90), shape2.getX(), shape2.getY());

       // t.rotate(Math.toRadians(45));
        path.transform(t);
        g2.setColor(new Color(156,217,229));
        g2.drawRoundRect(43, 20, height , width , arcWidth , arcHeight );
        //g2.draw(path);
    }
}
