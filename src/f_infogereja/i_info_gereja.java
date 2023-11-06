/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f_infogereja;

import b_file_function.b_file_locator;
import connection.c_connection_church;
import f_family.f_family01_g_image;
import f_family.f_family03_info;
import initialization.initialization;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

/**
 *
 * @author DELL
 */
public class i_info_gereja {


     b_file_locator desc = new b_file_locator();
    public JPanel i_info_gereja_P = new JPanel(new BorderLayout()){
    protected void paintComponent(Graphics g)
    {
        g.setColor( getBackground() );
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
};
     
    
         public JLabel notes01_B_A_J = new JLabel("<html><p style=\"text-align:center;\">"+g_takedata(desc.F_returnString())+"</p></html> "){
    protected void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int w = getWidth();
        int h = getHeight();
          super.paintComponent(g);
    }
};
      
         int i_info_gereja_P_width = initialization.Containerpanelwidth-100;
         int i_info_gereja_P_height = initialization.PanelMapHeight-100;
    
     f_family01_g_image f_family01 = new f_family01_g_image(initialization.gereja);  
                      
         
      public i_info_gereja(){ 
            
            i_initialization_i_info_gereja_P();
            i_integration();
        }
      
      private void i_initialization_i_info_gereja_P(){
       // i_info_gereja_P.setLayout(new GridLayout(0,1,20,10));
       
        i_info_gereja_P.setLayout(new BorderLayout());
       i_info_gereja_P.setPreferredSize(new Dimension(i_info_gereja_P_width,i_info_gereja_P_height));
        i_info_gereja_P.setBounds(0,0,i_info_gereja_P_width,i_info_gereja_P_height);
        i_info_gereja_P.setOpaque(false);
        i_info_gereja_P.setBackground( new Color(0, 0, 0) ); 
      }
     
      private void i_integration(){
          
          i_info_gereja_P.add(h_gerejapicture(initialization.gereja.replace("_", " ")),BorderLayout.PAGE_START);
          i_info_gereja_P.add(h_gerejainfo(),BorderLayout.CENTER);
        
      }
      
      
      private JPanel h_gerejainfo(){
          
         notes01_B_A_J.setPreferredSize(new Dimension(250, 200));
          notes01_B_A_J.setOpaque(false);
         notes01_B_A_J.setVerticalAlignment(SwingConstants.TOP);
          
         int panel_width = initialization.midfamilypanelWidth;               
         int panel_height = initialization.midfamilypanelHeight;
         JPanel hai = new JPanel();
                        hai.setBounds(0,0,panel_width/2,panel_height/3-panel_height/19);
                        hai.setBackground( new Color(46, 46, 132));
                        hai.setOpaque(false);
                        //24/2/2021..very important feature that i figure out...by His grace, cause honestly, i myself don't have the will or strength to be able to execute this manner of things
                        hai.setPreferredSize(new Dimension(panel_width/2-75, panel_height/3-panel_height/23));                        
        notes01_B_A_J.setForeground(Color.white);
        hai.add(notes01_B_A_J);

        return hai;
      }   
        
        
      private JPanel h_gerejapicture(String myName) {
             
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
                        hai.setBounds(0,0,panel_width/2,panel_height/3-panel_height/19);
                 
                        hai.setOpaque(false);
                        hai.setBackground( new Color(255, 255, 255, 1));
                        //24/2/2021..very important feature that i figure out...by His grace, cause honestly, i myself don't have the will or strength to be able to execute this manner of things
                        hai.setPreferredSize(new Dimension(panel_width/2-75, panel_height/3-panel_height/23));
                        
                        
                  
                        JPanel hai_second = new JPanel(){
    protected void paintComponent(Graphics g)
    {
        g.setColor( getBackground() );
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
        };
                       
                     //   hai_second.setPreferredSize(new Dimension(30,hai.getHeight()-hai.getHeight()/10));
                     hai_second.setLayout(new BoxLayout(hai_second, BoxLayout.Y_AXIS));
                        hai_second.setBounds(0,0,hai.getWidth()-90,hai.getHeight()-hai.getHeight()/10);                   
                        hai_second.setOpaque(true);
                        hai_second.setBackground( new Color(0, 0, 0));
                      // hai_second.setOpaque(true);
                      
                         String intern = myName;
                       
                        JLabel JLabelstring = new JLabel(intern,SwingConstants.CENTER);
                        JLabelstring.setForeground(Color.white);
                        
                        
                          
 //    ImageIcon imageIcon = new ImageIcon(new ImageIcon(getClass().getResource("/Profile-PNG-Icon.png")).getImage().getScaledInstance(120,150, Image.SCALE_DEFAULT));      
  //   Image tmpImage = imageIcon.getImage();   
  //getting the image      
  f_family01_g_image f_family01 = new f_family01_g_image(myName);    
         try {
             JLabel label = new JLabel(new ImageIcon(f_family01.g_uploadimage().getScaledInstance(hai_second.getWidth()-30,hai_second.getHeight()-hai.getHeight()/15, Image.SCALE_DEFAULT)));
             hai_second.add(label);
         } catch (IOException ex) {
             Logger.getLogger(i_info_gereja.class.getName()).log(Level.SEVERE, null, ex);
         }
  
                        //implementation sides
                         SpringLayout layout = new SpringLayout();
                         hai.setLayout( layout);
                        JLabelstring.setSize(new Dimension(150,30));
                        JLabelstring.setHorizontalAlignment(SwingConstants.CENTER);
                        JLabelstring.setVerticalAlignment(SwingConstants.BOTTOM);
                        hai.add(hai_second,BorderLayout.PAGE_START);
                        hai.add(JLabelstring);
                       
                        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, hai_second, 0, SpringLayout.HORIZONTAL_CENTER, hai);                          
                     
                        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, JLabelstring, 0, SpringLayout.HORIZONTAL_CENTER, hai);                          
                        layout.putConstraint(SpringLayout.SOUTH, JLabelstring,-10,SpringLayout.SOUTH, hai);
                       
             
                        // JLabelstring.setBounds(0,300, JLabelstring.getWidth(), JLabelstring.getHeight());
                         // hai.add(hai_second,BorderLayout.PAGE_START);
                         // hai.add(JLabelstring,BorderLayout.PAGE_END);
                          
// hai.add(JLabelstring);
                          
                         
                          return hai;
                   
    }
      
      public JPanel E_i_info_gereja_P(){
          return i_info_gereja_P;
      }
      
          private String g_takedata(String location){
           String data = "";
        try {
      File myObj = new File(location+"\\description.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        data = data + myReader.nextLine();
       
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
         System.out.println(data);
         return data.replace("_"," ");
    }
  
}
