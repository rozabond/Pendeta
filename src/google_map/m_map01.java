/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package google_map;


import c_connection.g_chatserver;
import c_connection.g_testconnection;
import connection.c_connection_map;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import initialization.initialization;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.LineBorder;
/**
 *
 * @author DELL
 */
public class m_map01{
    
    public JLayeredPane pane = new JLayeredPane();
    JButton jp = new JButton();  
    c_connection_map c_connect = new c_connection_map(); 
    
    public JPanel m_b_p = new JPanel(){
    protected void paintComponent(Graphics g)
    {
        g.setColor( getBackground() );
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
};
    public JButton m_b_b_p = new JButton("Tukar Coord");
    public JButton m_b_b_b_b_p = new JButton("save");
    public JButton m_b_b_b_p = new JButton("back");
    
   
public m_map01() {
        awt_map_button(100, 50,"map");

        initialialized_m_b_b_p_listener();
        initialialized_m_b_b_b_p_listener();
        initialialized_m_b_b_b_b_p_listener();
        
    }
    
    
private void initialialized_m_b_b_p_listener(){
          m_b_b_p.addActionListener(new ActionListener(){  
             public void actionPerformed(ActionEvent e){  
            Chrome.browsers.loadURL("http://localhost:8080"); 
            m_b_b_b_p.setVisible(true);
            m_b_b_b_b_p.setVisible(true);
             }});
        
}

private void initialialized_m_b_b_b_p_listener(){
 m_b_b_b_p.addActionListener(new ActionListener(){  
             public void actionPerformed(ActionEvent e){  
           f_map_decisionmakeover();
            m_b_b_b_p.setVisible(false);
            m_b_b_b_b_p.setVisible(false);
             }});    
 m_b_b_b_p.setVisible(false);
}

private JButton initialialized_m_b_b_p() {
      m_b_b_p.setPreferredSize(new Dimension(100, 50-5));
         // m_b_b_p.setBackground( new Color(0, 0, 51) );
          m_b_b_p.setBorder(new LineBorder(new Color(5,217,229)));
          m_b_b_p.setForeground(Color.white);
          return m_b_b_p;
}

private void initialialized_m_b_b_b_b_p_listener(){
 m_b_b_b_b_p.addActionListener(new ActionListener(){  
             public void actionPerformed(ActionEvent e){  
                // c_connection_map map = new c_connection_map();
                   c_connect.R_filepath();
                 c_connect.f_insertmap();
                 m_b_b_b_b_p.setVisible(false);
                 m_b_b_b_p.setVisible(false);
                 m_b_b_p.setVisible(false);
                 f_map_decisionmakeover();
                 ActionListener listener = new ActionListener(){
        public void actionPerformed(ActionEvent event){
          m_b_b_p.setVisible(true);
        }
    };
                  Timer timer = new Timer(5000, listener);
                timer.setRepeats(false);
                timer.start();
             }});
 m_b_b_b_b_p.setVisible(false);
}

private JButton initialialized_m_b_b_b_p() {
     m_b_b_b_p.setPreferredSize(new Dimension(100, 50-5));
         // m_b_b_b_p.setBackground( new Color(0, 0, 51) );
           m_b_b_b_p.setBorder(new LineBorder(new Color(5,217,229)));
         m_b_b_b_p.setForeground(Color.white);
          return m_b_b_b_p;
}

private JButton initialialized_m_b_b_b_b_p() {
     m_b_b_b_b_p.setPreferredSize(new Dimension(100, 50-5));
         // m_b_b_b_b_p.setBackground( new Color(0, 0, 51) );
         m_b_b_b_b_p.setBorder(new LineBorder(new Color(5,217,229)));
         
          m_b_b_b_b_p.setForeground(Color.white);
          return m_b_b_b_b_p;
}

private JPanel inititialized_m_b_p() {
     FlowLayout experimentLayout = new FlowLayout(FlowLayout.LEFT, 20, 20);
       
    m_b_p.setLayout(experimentLayout);
    m_b_p.setBounds(0, 0, initialization.pane_container.getWidth(), 100);
    m_b_p.setPreferredSize(new Dimension(initialization.pane_container.getWidth(),100));
    m_b_p.add(initialialized_m_b_b_p());
    m_b_p.add(initialialized_m_b_b_b_p());
    m_b_p.add(initialialized_m_b_b_b_b_p());
    m_b_p.setOpaque(false);
    m_b_p.setBackground( new Color(0, 0, 0,90) );

            
    return m_b_p;
}

       
private  JButton awt_map_button(int w, int h,String nama){
           
          jp.setBounds(w-50,h-50,w,h);
            jp.setOpaque(true);
         //rounded rb = new rounded("Gereja");
         JButton rb =new JButton(nama);
         
          rb.setPreferredSize(new Dimension(w, h-5));
          rb.setBackground( new Color(0, 0, 0) );
          rb.setForeground(Color.white);
          
          rb.addActionListener(new ActionListener(){  
         public void actionPerformed(ActionEvent e){  
                        
             if(initialization.h_indicator == false){
    ActionListener listener = new ActionListener(){
        public void actionPerformed(ActionEvent event){
            if(initialization.h_indicator == true){
                      g_initializad_map(); 
            }else{
                 g_timer(this);
            }   
      
        }
    };
                   
          
              g_timer(listener);
             
             
             }else{
                g_initializad_map(); 
             }
                              
                    
                        }  
                        });
          
         jp = rb;
         return jp;
    }
     
private void g_timer(ActionListener listener){
    System.out.println("tengok berapa banyak");
            Timer timer = new Timer(500, listener);
                timer.setRepeats(false);
                timer.start();
             
}


private void g_initializad_map(){
       cleareverything();
             f_setupsocket();
             f_map_decisionmakeover();       
            
            initialization.pane_container.setLayout(new BorderLayout());
            initialization.pane_container.add(Chrome.jpbrowsers,BorderLayout.CENTER);
            initialization.pane_container.add(inititialized_m_b_p(),BorderLayout.PAGE_END);
            initialization.pane_container.setPreferredSize(new Dimension(initialization.PanelMapWidth, initialization.PanelMapHeight));
            initialization.pane_container.setBounds(0, 20, initialization.PanelMapWidth, initialization.PanelMapHeight-20);
            initialization.pane_container.repaint();
            initialization.pane_container.revalidate();
            
       
                
             initialization.notes_panel.remove(initialization.button_homie);     
             initialization.notes_panel.remove(initialization.button_notes_homie);
             initialization.button.setBounds(initialization.notes_panel.getWidth()-50, 0, 100, 50);
             initialization.button.setPreferredSize(new Dimension(100, 50));
             initialization.button.setBackground( new Color(0, 0, 51, 10) );
             initialization.button.setForeground(Color.white);
             initialization.notes_panel.add(initialization.button,BorderLayout.PAGE_END);
}

  private boolean G_testConnection(){
        g_testconnection g_testing = new g_testconnection();
       
       boolean g_connection =  g_testing.checkInternetConnection();
       return g_connection;
    }
  
private void f_map_decisionmakeover() {
 String url = "";

    if(initialization.i_coordinate.isEmpty()){
    url = "https://www.google.com.my/maps/@4.140634,109.6181485,6z";
   
    }else{
    String[] cooridnate = initialization.i_coordinate.split(",");
    url = "http://maps.google.com/maps?&z=8&mrt=all&t=m&q="+cooridnate[1]+"+"+cooridnate[0];
    }
    
    if(G_testConnection() == true){
                Chrome.browsers.loadURL(url); 
                //put_picture_notes();
                }else{
                Chrome.browsers.loadURL("http://localhost:8080");  
                }
}

private void f_setupsocket(){
           g_chatserver socket = new g_chatserver();
            socket.t_swing_worker();
         initialization.i_coordinate = c_connect.f_outputmap();
}

private void cleareverything(){
     initialization.e_container.setVisible(false);
    initialization.pane_container.setVisible(false);
    initialization.pane_container.removeAll();
     initialization.e_container.removeAll();
           initialization.pane_container.setVisible(true);
            initialization.e_container.setVisible(true);
 
  }   

public JButton m_returnawt(){
          return jp;
      }
    
    
}
