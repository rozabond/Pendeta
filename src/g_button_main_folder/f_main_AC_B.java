/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gereja;

import f_family.f_family02;
import initialization.initialization;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafile.J_SampleJFileChooser;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import s_sidebar2.s_sidebar2A;

/**
 *
 * @author DELL
 */
public class f_main_AC_B {
    
    
    
           public JPanel side_bar_add() {
         
         //important
         int panel_width = initialization.midfamilypanelWidth;               
         int panel_height = initialization.midfamilypanelHeight;
                        JPanel hai = new JPanel(){
    protected void paintComponent(Graphics g)
    {
        g.setColor( getBackground() );
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
};
                        hai.setPreferredSize(new Dimension(panel_width/2-75, panel_height/3-panel_height/28));
                        hai.setBounds(0,0,panel_width/2,panel_height/3-panel_height/19);
                        hai.setOpaque(true);
                       // hai.setBackground( new Color(0, 0, 0, 1));
                        //24/2/2021..very important feature that i figure out...by His grace, cause honestly, i myself don't have the will or strength to be able to execute this manner of things
                    
                        
                  
                        JPanel hai_second = new JPanel(){
    protected void paintComponent(Graphics g)
    {
        g.setColor( getBackground() );
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
};
                       
                        
                        
                     //   hai_second.setPreferredSize(new Dimension(30,hai.getHeight()-hai.getHeight()/10));
                        hai_second.setBounds(0,0,hai.getWidth()-50,hai.getHeight()-hai.getHeight()/10);                   
                        hai_second.setOpaque(false);
                       // hai_second.setBackground( new Color(255, 255, 255));
                      // hai_second.setOpaque(true);
                           Border blackline2 = BorderFactory.createLineBorder(Color.black,2);
                          //blackline.createLineBorder(Color.black);
                           hai_second.setBorder(blackline2);
                      
                        JLabel JLabelstring = new JLabel("Click Upload",SwingConstants.CENTER);
                        JLabelstring.setForeground(Color.white);
                       JButton b = new JButton();
                        b.setOpaque(false);
                        b.setPreferredSize(new Dimension(hai_second.getWidth()-65, hai_second.getHeight()-10));
                        b.setName("Gereja");
                        b.setRolloverEnabled(false);
                        b.setBorder(new LineBorder(new Color(5,217,229)));
                        
                        b.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        b.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        hai.setOpaque(true);
                    
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                
  
                    }

                            @Override
                            public void mouseClicked(MouseEvent me) {
                                     J_SampleJFileChooser hq  = new  J_SampleJFileChooser();
                                   //  i_canvas_main_image image = new i_canvas_main_image();
                        try {
                            //JLabel hai= new JLabel(new ImageIcon(hq.f_display_image().getScaledInstance(b.getWidth(),b.getHeight(), Image.SCALE_DEFAULT)));
                            //hai.setPreferredSize(new Dimension(b.getWidth(),b.getHeight()));
                            b.setIcon(new ImageIcon(hq.f_display_image().getScaledInstance(hai_second.getWidth(),hai_second.getHeight(), Image.SCALE_DEFAULT)));
                        } catch (IOException ex) {
                            Logger.getLogger(f_create_church_A.class.getName()).log(Level.SEVERE, null, ex);
                        }
                                     //b.drawImage(new ImageIcon(hq.f_display_image().getScaledInstance(hai_second.getWidth(),hai_second.getHeight(), Image.SCALE_DEFAULT)), 0, 0, null);
                                    // b.setIcon(image);
                                     b.repaint();
                                     b.revalidate();
                                 
 }

                            @Override
                            public void mousePressed(MouseEvent me) {
                               //To change body of generated methods, choose Tools | Templates.
                            }

                            @Override
                            public void mouseReleased(MouseEvent me) {
                                //To change body of generated methods, choose Tools | Templates.
                            }
                });
                        b.setBackground(new Color(0,0,0,0));
                     
                       
                        
                        
                        //implementation sides
                        hai_second.add(b);
                       // hai.add(hai_second);
                       if(initialization.check_number >=3){
                     
                         SpringLayout layout = new SpringLayout();
                         hai.setLayout( layout);
                        JLabelstring.setSize(new Dimension(150,30));
                        JLabelstring.setHorizontalAlignment(SwingConstants.CENTER);
                        JLabelstring.setVerticalAlignment(SwingConstants.BOTTOM);
                        hai.add(hai_second,BorderLayout.PAGE_START);
                        hai.add(JLabelstring,BorderLayout.PAGE_END);
                      
                    layout.putConstraint(SpringLayout.VERTICAL_CENTER, hai_second, -5, SpringLayout.VERTICAL_CENTER, hai);  
                        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, hai_second, 0, SpringLayout.HORIZONTAL_CENTER, hai); 
                       
                        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, JLabelstring, 0, SpringLayout.HORIZONTAL_CENTER, hai_second);                          
                        layout.putConstraint(SpringLayout.SOUTH, JLabelstring,b.getHeight()+25,SpringLayout.SOUTH, hai_second);
                       
                       }else{
                           //man
                        
                         JLabelstring.setPreferredSize(new Dimension(150,30));
                         JLabelstring.setHorizontalAlignment(SwingConstants.CENTER);
                         JLabelstring.setVerticalAlignment(SwingConstants.BOTTOM);
                              SpringLayout layout = new SpringLayout();
                         hai.setLayout( layout);
                         hai.add(hai_second);
                         hai.add(JLabelstring);
                       
                        
                        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, JLabelstring, 0, SpringLayout.HORIZONTAL_CENTER, hai_second);                          
                        layout.putConstraint(SpringLayout.SOUTH, JLabelstring,b.getHeight()+25,SpringLayout.SOUTH, hai_second);
                       
                       }
                       
                       
                       
    
                        // JLabelstring.setBounds(0,300, JLabelstring.getWidth(), JLabelstring.getHeight());
                         // hai.add(hai_second,BorderLayout.PAGE_START);
                         // hai.add(JLabelstring,BorderLayout.PAGE_END);
                          
// hai.add(JLabelstring);
                          
JPanel container = new JPanel(){
    protected void paintComponent(Graphics g)
    {
        g.setColor( getBackground() );
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
};
container.add(hai);
container.setPreferredSize(new Dimension(initialization.PanelWidth+20,initialization.PanelHeight));
container.setBounds(0, 0, initialization.PanelWidth+20,initialization.PanelHeight);
   Border blackline = BorderFactory.createMatteBorder(0, 0, 0, 2, new Color(5,217,229));
           //blackline.paintBorder(box,Color.YELLOW, 0, 0, 0, 0);
        container.setBorder(blackline);
//container.setBackground(new Color(0,0,0,1));

                         SpringLayout layout = new SpringLayout();
                         container.setLayout( layout);
                         
    layout.putConstraint(SpringLayout.VERTICAL_CENTER, hai, -5, SpringLayout.VERTICAL_CENTER, container);  
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, hai, 0, SpringLayout.HORIZONTAL_CENTER, container); 
                          

                          return container;
                   
    }
  
}
