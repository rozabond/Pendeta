/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s_sidebar2;

import f_family.f_family01;
import f_family.f_family02;
import google_map.m_map01;
import notes.m_notes01;
import initialization.initialization;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import notes.notes;

/**
 *
 * @author DELL
 */
public class s_sidebar2A {
    

    JPanel map_panel = new javax.swing.JPanel(new BorderLayout()) { protected void paintComponent(Graphics g) {
    BufferedImage image = null;     
            String f = new File("google_map_1.png").getAbsolutePath();
    try {                   
         image = ImageIO.read(new File(f));
                  
        } catch (IOException ex) {
        System.out.println("");
       }
        super.paintComponent(g);
        g.drawImage(image, -150, -30, this); // see javadoc for more info on the parameters            
    }};
    
    JPanel container = new javax.swing.JPanel();
    
 
    
  public s_sidebar2A(int width_notes_panel, int height_notes_panel, int width_map_panel,int height_map_panel){
   // initialized_notes_panel(width_notes_panel-50,height_notes_panel);
    initialization.initialized_notes_panel(); 
    initialized_map_panel(width_map_panel,height_map_panel-325);
    initialized_container(width_notes_panel+100);
    add_notes();
    //add_button();
    add_button_home();
    
}  

  
  private JPanel initialized_map_panel(int width, int height) {
      int b_flowLyout = height-150;
        
        m_map01 button_map = new m_map01();
        FlowLayout experimentLayout = new FlowLayout(FlowLayout.RIGHT, 20, b_flowLyout);
        map_panel.setLayout(experimentLayout);
          // map_panel.setSize(width,height);
      // map_panel.setLayout(new BoxLayout(map_panel,));
       // map_panel.setLayout(experimentLayout);
        map_panel.setPreferredSize(new Dimension(width,height-b_flowLyout));
      //  map_panel.setSize(width,height+150);
        map_panel.setBounds(0,0,width,height);
        map_panel.setOpaque(true);
        //map_panel.setBackground( new Color(0, 0, 0) );
        //System.out.println(width+"nah, mesti gia dia di sini ni"+height);
        map_panel.add(button_map.m_returnawt(),BorderLayout.PAGE_END);
        //button_map.m_returnawt().setBounds(map_panel.getWidth()-50, map_panel.getHeight()-50, map_panel.getWidth(),map_panel.getHeight());
        map_panel.repaint();
        map_panel.revalidate();
        return map_panel;
  }
        
   private JPanel initialized_container(int width){
        container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS)); 
        //container.setLayout(new BorderLayout()); 
        container.setPreferredSize(new Dimension(width,initialization.screenHeight-125));
        container.setBounds(initialization.PanelBounds,0,initialization.PanelWidth,initialization.PanelHeight);
        container.setOpaque(false);
        container.setBackground( new Color(0, 0, 0) );

    
        container.add(   initialization.notes_panel);
        container.add(map_panel);
     
      return container;
   }
   
   private void add_notes() {
       
       JPanel container = new JPanel(new BorderLayout()){
    protected void paintComponent(Graphics g)
    {
        g.setColor( getBackground() );
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
};       
    
       notes nota = new notes();
       m_notes01 button_map = new m_notes01();
       
       container.setVisible(true);
       container.setBackground(new Color(0, 0, 0,1));
       
       container.add(button_map.m_returnawt(),BorderLayout.PAGE_START);
      
         // initialization.notes_panel.add(nota.loading_info(initialization.notes_panel),BorderLayout.PAGE_START);   
         initialization.notes_panel.add(nota.loading_info(initialization.notes_panel),BorderLayout.PAGE_START);   
         initialization.notes_panel.add(container,BorderLayout.CENTER);
    

   }
    
private void add_button_home() {
       JPanel container = new JPanel(new BorderLayout());
       container.setBounds(   initialization.notes_panel.getWidth()-50, 0, 100, 100);
       container.setPreferredSize(new Dimension(100, 100));
          initialization.button_homie.setBounds(   initialization.notes_panel.getWidth()-50, 0, 100, 50);
          initialization.button_homie.setPreferredSize(new Dimension(100, 50));
          initialization.button_homie.setBackground( new Color(0, 0, 51, 10) );
          initialization.button_homie.setForeground(Color.white);
        container.setVisible(false);
        container.add(initialization.button_homie,BorderLayout.PAGE_END);
          initialization.notes_panel.add(initialization.button_homie,BorderLayout.PAGE_END);
     //18/2/2021 getting the things back to the second phase       
   }
   

   
  public JPanel return_notes_panel(){
   return    initialization.notes_panel;
  }
  
  public JPanel return_map_panel() {
  return map_panel;
  }
  
  public JPanel return_container(){
  return container;
  }
 
}
