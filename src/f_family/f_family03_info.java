/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f_family;

import addcomponent.SpringUtilities;
import connection.c_connection_gereja;
import initialization.initialization;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

/**
 *
 * @author DELL
 */
public class f_family03_info {
    JPanel p = new JPanel(new SpringLayout());
    
        c_connection_gereja orang = new c_connection_gereja();
       
        public f_family03_info() {
}
        
     public JPanel g_appear_box(JPanel Panel_size,String name){
                
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
                      
                         String intern = name.replace("_"," ");
                       
                        JLabel JLabelstring = new JLabel(intern.replace("  ","@").replace("@@","@"),SwingConstants.CENTER);
                        JLabelstring.setForeground(Color.white);
                        
                        
                          
 //    ImageIcon imageIcon = new ImageIcon(new ImageIcon(getClass().getResource("/Profile-PNG-Icon.png")).getImage().getScaledInstance(120,150, Image.SCALE_DEFAULT));      
  //   Image tmpImage = imageIcon.getImage();   
  //getting the image      
  f_family01_g_image f_family01 = new f_family01_g_image(name);    
         try {
             JLabel label = new JLabel(new ImageIcon(f_family01.g_uploadimage().getScaledInstance(hai_second.getWidth()-30,hai_second.getHeight()-hai.getHeight()/15, Image.SCALE_DEFAULT)));
             hai_second.add(label);
         } catch (IOException ex) {
             Logger.getLogger(f_family03_info.class.getName()).log(Level.SEVERE, null, ex);
         }
  
                        //implementation sides
                         SpringLayout layout = new SpringLayout();
                         hai.setLayout( layout);
                        JLabelstring.setSize(new Dimension(150,30));
                        JLabelstring.setHorizontalAlignment(SwingConstants.CENTER);
                        JLabelstring.setVerticalAlignment(SwingConstants.BOTTOM);
                        hai.add(hai_second);
                        hai.add(JLabelstring);
                       
                        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, hai_second, 0, SpringLayout.HORIZONTAL_CENTER, hai);                          
                       layout.putConstraint(SpringLayout.SOUTH, hai_second,-50,SpringLayout.SOUTH, hai);
                       
                        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, JLabelstring, 0, SpringLayout.HORIZONTAL_CENTER, hai);                          
                        layout.putConstraint(SpringLayout.SOUTH, JLabelstring,-25,SpringLayout.SOUTH, hai);
                       
             
                        // JLabelstring.setBounds(0,300, JLabelstring.getWidth(), JLabelstring.getHeight());
                         // hai.add(hai_second,BorderLayout.PAGE_START);
                         // hai.add(JLabelstring,BorderLayout.PAGE_END);
                          
// hai.add(JLabelstring);
                          
                         
                          return hai;
    }
    
     
     public void i_initialize_p(){
     p.setPreferredSize(new Dimension(initialization.e_container.getWidth(),initialization.e_container.getHeight()/2-50));
     p.setBounds(0, 0, initialization.e_container.getWidth(), initialization.e_container.getHeight()/2-50);
     }
     
 public JPanel g_Form(JPanel Panel_size,Object Info[]) {
            i_initialize_p();
         String[] labels = {"Ic: ", "Tarikh_lahir: ", "Agama_Asal: ","Agama_Terkini:","Tarikh_dibaptis:","Alamat_terkini:","Nombor_tel:"};
         int numPairs = labels.length;
         
         for (int i = 0; i < numPairs; i++) {
            JLabel l = new JLabel(labels[i].replaceAll("_"," "), JLabel.TRAILING);
            p.add(l);
            JTextField textField = new JTextField(10);
            
            textField.setText((String) Info[i+1].toString().replaceAll("_","-").replaceAll("@","-"));
            l.setLabelFor(textField);
            p.add(textField);
        }
        
          SpringLayout layout = new SpringLayout();
      
         SpringUtilities.makeCompactGrid(p,
                                        numPairs, 2, //rows, cols
                                        6, 6,        //initX, initY
                                        6, 6);       //xPad, yPad 
         
          //p.setSize(new Dimension(Panel_size.getWidth(),Panel_size.getHeight()/2-300));
       // p.setBackground(new Color(255,255,255));
        return p;
}
 

public Object[] d_display_information(String Nama) {
        //Object container[] = {};
     //blum jadi
     
       // Object resultSet[] = (Object[]) orang.t_takedata(Nama); 
               
  
    
      return (Object[]) orang.t_takedata(Nama); 
    }


 
   
    
}
