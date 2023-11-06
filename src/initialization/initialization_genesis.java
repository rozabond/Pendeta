/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package initialization;

import java.awt.BorderLayout;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author DELL
 */
public class initialization_genesis {
     
  static public JPanel notes_panel = new javax.swing.JPanel(){
    protected void paintComponent(Graphics g)
    {
        g.setColor( getBackground() );
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
};
  
  public static String input = null;
  
  public static JPanel jp = new JPanel();  
  public static String Church_name;
   public static JButton delete_button = new JButton("Delete");
}
