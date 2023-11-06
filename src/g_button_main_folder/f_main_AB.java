/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g_button_main_folder;

import connection.c_connection_church;
import css.scrollbar;
import initialization.initialization;
import static initialization.initialization.pane_container;
import static initialization.initialization.scrollPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author DELL
 */
public class f_main_AB {
      public static JPanel box = new JPanel(){
    protected void paintComponent(Graphics g)
    {
       super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

    }
};
       
    public final scrollbar scrollPanel = new scrollbar(
        box,
        ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,
        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS ){
    protected void paintComponent(Graphics g)
    {
        g.setColor( getBackground() );
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
        
    }
};
    
       public static List<JCheckBox> checkBoxes = new ArrayList<JCheckBox>();
          c_connection_church church = new c_connection_church();
 
       public f_main_AB(){
           initialize_box();
         //  g_checkbox();
         
       }
       
       private void initialize_box(){
           box.setOpaque(true);
           box.setLayout(new BoxLayout(box, BoxLayout.PAGE_AXIS));
       // box.(new Dimension(200,40));
        Border blackline = BorderFactory.createMatteBorder(0, 0, 0, 2, new Color(5,217,229));
           //blackline.paintBorder(box,Color.YELLOW, 0, 0, 0, 0);
        box.setBorder(blackline);
        
        box.setBounds(0, 0, box.getWidth(), 500);
         scrollPanel.setSize(new Dimension(initialization.pane_container.getWidth(),100));
        scrollPanel.setBounds(0, 0,initialization.pane_container.getWidth(), 100);
 
         scrollPanel.getViewport().setBackground(new Color(255,255,255));
        scrollPanel.setBackground(new Color(255,255,255));
        scrollPanel.repaint();
        scrollPanel.revalidate();
       }
       
     
  
       
       
       public void g_checkbox(){
    
    
       }
    
    public scrollbar r_returnbox(){
        return scrollPanel;
    }
    
    public static void f_checkall(){
    for (JCheckBox checkBox : checkBoxes) {
      checkBox.setSelected(true);
    }
}
    
    public Iterator f_take_churchnum(){
  Stack<String> stack = new Stack<String>();
  stack = church.f_church_resultset();
  Iterator<String> itr = stack.iterator();
     
        return itr;
    }
}
