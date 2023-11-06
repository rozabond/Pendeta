/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notes;

import google_map.Chrome;
import initialization.initialization;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author DELL
 */
public class m_notes01 {
    public JLayeredPane pane = new JLayeredPane();
    JButton jp = new JButton(){
    protected void paintComponent(Graphics g)
    {
        g.setColor( getBackground() );
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
};    
     
     
    
public m_notes01() {
        awt_map_button(100, 50,"Lihat Notes");
    }
    
    
public void put_map() {
 
    Chrome.jpbrowsers.setBounds(0,0,pane.getWidth(),pane.getHeight());
    Chrome.browsers.loadURL("https://www.google.com.my/maps/@4.140634,109.6181485,6z"); 
    //put_picture_notes();
    }
    

       
private  JButton awt_map_button(int w, int h,String nama){
           
          jp.setBounds(w-50,h-50,w,h);
            jp.setOpaque(true);
            jp.setFocusPainted(false);
         //rounded rb = new rounded("Gereja");
         JButton rb =new JButton(nama){
    protected void paintComponent(Graphics g)
    {
        g.setColor( getBackground() );
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
};       
          rb.setPreferredSize(new Dimension(w, h-5));
          rb.setOpaque(false);
          rb.setBorder(new LineBorder( new Color(5,217,229)));
         // rb.setBackground( new Color(0, 0, 51) );
          rb.setForeground(Color.white);
          rb.setFocusPainted(false);
          
          rb.addActionListener(new ActionListener(){  
         public void actionPerformed(ActionEvent e){  
                        
            cleareverything();
            add_notes();
            i_initialized_button_notes_homie();
             initialization.notes_panel.remove(initialization.button_homie);  
             initialization.button_notes_homie.setBounds(initialization.notes_panel.getWidth()-50, 0, 100, 50);
             initialization.button_notes_homie.setPreferredSize(new Dimension(100, 50));
             initialization.button_notes_homie.setBackground( new Color(0, 0, 51, 10) );
             initialization.button_notes_homie.setForeground(Color.white);
             initialization.notes_panel.add(initialization.button_notes_homie,BorderLayout.PAGE_END);
            
            
            
//Map_Panels.removeAll();  
                           //buang.removeAll();
                           //Map_Panels.add(Chrome.jpbrowsers,new Integer(0));
                           //panel1.add(awt_map_button(panel1.getWidth(),panel1.getHeight(),"Zoom",Map_Panels));
                           //panel1.setBounds(Map_Panels.getWidth()/2+Map_Panels.getWidth()/10, Map_Panels.getHeight()/2+Map_Panels.getHeight()/5, panel1.getWidth(), panel1.getHeight());
                           //Map_Panels.add(panel1,new Integer(2));
                        
                              
                    
                        }  
                        });
          
         jp = rb;
         return jp;  
    }
      
private void cleareverything(){
     initialization.e_container.removeAll();
     initialization.e_container();
     initialization.e_container.repaint();
     initialization.e_container.revalidate();
}   

public JButton m_returnawt(){
          return jp;
      }

private void add_notes(){
initialization.e_container.setLayout(new BorderLayout());
Border blackline = BorderFactory.createEmptyBorder(30,0, 0, 0);



    m_notes01_A a = new m_notes01_A();
    m_notes01_B b = new m_notes01_B();

initialization.e_container.setBorder(blackline);
initialization.e_container.add(a.return_notes01_A(),BorderLayout.PAGE_START);
initialization.e_container.add(b.return_notes01_B(),BorderLayout.CENTER);
initialization.e_container.repaint();
initialization.e_container.revalidate();        
}

private void i_initialized_button_notes_homie(){
    initialization.button_notes_homie.addActionListener(new ActionListener(){  
         public void actionPerformed(ActionEvent e){  
             initialization.notes_panel.remove(initialization.button_notes_homie);  
             initialization.button_notes_homie.setBounds(initialization.notes_panel.getWidth()-50, 0, 100, 50);
             initialization.button_notes_homie.setPreferredSize(new Dimension(100, 50));
             initialization.button_notes_homie.setBackground( new Color(0, 0, 51, 10) );
             initialization.button_notes_homie.setForeground(Color.white);
             initialization.notes_panel.add(initialization.button_homie,BorderLayout.PAGE_END);       
         
             cleareverything();
         
         }  
                        });
}




}
