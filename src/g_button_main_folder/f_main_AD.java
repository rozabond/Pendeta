/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g_button_main_folder;

import addcomponent.SpringUtilities;
import connection.c_connection_church;
import css.scrollbar;
import static g_button_main_folder.f_main_initialization.l_a;
import static g_button_main_folder.f_main_initialization.textField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import javafile.J_SampleJFileChooser;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpringLayout;
import javax.swing.border.Border;

/**
 *
 * @author DELL
 */
public class f_main_AD {
       JPanel box = new JPanel(){
    protected void paintComponent(Graphics g)
    {
       super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
      
    }
};
       
 
    
       public static List<JCheckBox> checkBoxes = new ArrayList<JCheckBox>();
          c_connection_church church = new c_connection_church();
 
       public f_main_AD(){
           initialize_box();
           g_checkbox();
       
       }
       
       private void initialize_box(){
        box.setOpaque(true);
        box.setLayout(new GridLayout(0,1,20,10));
        box.setPreferredSize(new Dimension(200,40));
        Border blackline = BorderFactory.createMatteBorder(0, 0, 0, 2, new Color(5,217,229));
           //blackline.paintBorder(box,Color.YELLOW, 0, 0, 0, 0);
        box.setBorder(blackline);
        
        
        box.setBounds(0, 0, box.getWidth(), box.getHeight());
         l_a.setForeground(Color.yellow);
        l_a.setVisible(false);
        textField.setText("");
       }
       
     
  
       
       
       public void g_checkbox(){
    
JPanel hai =new JPanel(){
    protected void paintComponent(Graphics g)
    {
        g.setColor( getBackground() );
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
        
    }
};
    
  SpringLayout layout = new SpringLayout();
                        hai.setLayout(layout);
                        hai.setOpaque(false);
                  
           JPanel hai2 = new JPanel(new GridLayout(0,2,20,10));
           hai2.setPreferredSize(new Dimension(400,30));
           hai2.setBounds(0, 0, hai2.getWidth(), hai2.getHeight());
           
             
            JLabel l = new JLabel("Old Password", JLabel.TRAILING);
    
            hai2.add(l);
            
            textField.setPreferredSize(new Dimension(hai2.getWidth(),70));
            l.setLabelFor(textField);
            hai2.add(textField);
            
            
                       SpringUtilities.makeCompactGrid(hai2,
                                        2, 2, //rows, cols
                                        6, 20,        //initX, initY
                                        6, 20);       //xPad, yPad 
         
           
            
            layout.putConstraint(SpringLayout.VERTICAL_CENTER, hai2, -120, SpringLayout.VERTICAL_CENTER, hai);  
            layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, hai2, -50, SpringLayout.HORIZONTAL_CENTER, hai);           
                     layout.putConstraint(SpringLayout.VERTICAL_CENTER, l_a, -80, SpringLayout.VERTICAL_CENTER, hai);  
            layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, l_a, 40, SpringLayout.HORIZONTAL_CENTER, hai);           
                  hai.add(l_a);          
                   hai.add(hai2);
                   
      box.add(hai);
    box.repaint();
    box.revalidate();
    
       }
    
    public JPanel r_returnbox(){
        return box;
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
