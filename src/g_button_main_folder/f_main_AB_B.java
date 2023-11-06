/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g_button_main_folder;

import css.scrollbar;
import java.awt.BorderLayout;
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
import javafile.J_zip_file_JFileChoose_import;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpringLayout;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author DELL
 */
public class f_main_AB_B {
       JPanel box = new JPanel(){
    protected void paintComponent(Graphics g)
    {
       super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
    
    }
};
       
    public final scrollbar scrollPanel = new scrollbar(
        box,
        ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER ){
    protected void paintComponent(Graphics g)
    {
        g.setColor( getBackground() );
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
        
    }
};
    
       public f_main_AB_B(){
           initialize_box();
     
           g_buttonbox();
           g_checkbox();    
       }
       
       private void initialize_box(){
           box.setOpaque(true);
     
           box.setLayout(new GridLayout(0,2,20,10));
        box.setPreferredSize(new Dimension(200,40));
        box.setBounds(0, 0, box.getWidth(), box.getHeight());        
          f_main_initialization.la.setText("Status: No Upload");
          f_main_initialization.la.setForeground(Color.WHITE);
       }
       
     
  
       
       
       public void g_buttonbox(){
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
                               hai.setBackground(new Color(255,255,255,10));
           JButton b = new JButton("Import");
               b.setPreferredSize(new Dimension(150, 40));
                        b.setBackground( new Color(0, 0, 51, 10) );
                        b.setForeground(Color.white);
                        b.setBorder(new LineBorder(new Color(5,217,229)));
                   b.setBounds(0, 300, b.getWidth(), b.getHeight());
                   b.addActionListener(new ActionListener(){  
                        public void actionPerformed(ActionEvent e){  
                             J_zip_file_JFileChoose_import zip = new J_zip_file_JFileChoose_import(f_main_initialization.la);
                        }});
                   hai.add(b,BorderLayout.PAGE_END);
                        
                        layout.putConstraint(SpringLayout.VERTICAL_CENTER, b, -5, SpringLayout.VERTICAL_CENTER, hai);  
                        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, b, 0, SpringLayout.HORIZONTAL_CENTER, hai); 
                     
                       
      box.add(hai);
    
    }
       
        
     public void g_checkbox(){
JPanel  hai =new JPanel(){
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
          
             f_main_initialization.b.addItemListener(new ItemListener() {
    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
 
        } else {//checkbox has been deselected
     
        };
    }
});
                        hai.add( f_main_initialization.la,BorderLayout.PAGE_END);
                        hai.setBackground(new Color(255,255,255,10));
                        layout.putConstraint(SpringLayout.VERTICAL_CENTER,  f_main_initialization.la, -5, SpringLayout.VERTICAL_CENTER, hai);  
                        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER,  f_main_initialization.la, 0, SpringLayout.HORIZONTAL_CENTER, hai); 
                     
                       
      box.add(hai);
    
    }
    

    private void F_checkall(){
     f_main_AA.f_checkall();
    } 
       
    public JPanel r_returnbox(){
        return box;
    }
}
