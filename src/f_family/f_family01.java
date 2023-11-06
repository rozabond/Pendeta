/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f_family;

import b_file_function.b_file_encryption_cannidate;
import connection.c_connection_family;
import connection.c_connection_gereja;
import css.scrollbar;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout; 
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import initialization.initialization;
import static initialization.initialization.Containerpanelwidth;
import static initialization.initialization.PanelHeight;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import s_sidebar2.s_sidebar1A_addbutton;
import s_sidebar2.s_sidebar2A;
/**
 *
 * @author DELL
 */
public class f_family01 {
        
     public JPanel jp_people = new JPanel(new GridLayout(0,2,20,10)){
    protected void paintComponent(Graphics g)
    {
       super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int w = getWidth();
        int h = getHeight();
    }
};    
        final scrollbar scrollPanel = new scrollbar(
        jp_people,
        ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
        
        c_connection_gereja orang = new c_connection_gereja();
    
        
      Object myObject[] = {};
        Stack<String> STACK = new Stack<String>();
        //local variables, for knowing when is yes and no for e_f_family01
        boolean neatural = false;
        
        
        public f_family01() {
            main_bar();
            display_button();
            displaynama();
            //display in stack
            e_f_family01(STACK);
            //for encription 2/7/2021
            F_Encryt_name();
            
        }
    
   private void main_bar() {
       float THRESHOLD = 0.95f; 
   
        jp_people.setSize(initialization.midfamilypanelWidth, initialization.midfamilypanelHeight);
        jp_people.setBounds(20,20,initialization.midfamilypanelWidth,initialization.midfamilypanelHeight);
        jp_people.setOpaque(true);
        jp_people.setBackground( new Color(0, 0, 0) );
        
        Border blackline = BorderFactory.createEmptyBorder(30, 30, 30, 30);
        jp_people.setBorder(blackline);
     
        scrollPanel.setPreferredSize(new Dimension(initialization.familypanelWidth+50,initialization.midfamilypanelHeight));
        scrollPanel.setBounds(0, 0, initialization.familypanelWidth+100,initialization.midfamilypanelHeight);
        scrollPanel.getViewport().setBackground(new Color(255,255,255));
        scrollPanel.setBackground(new Color(255,255,255));
        //tambah adjustment detecting bila sampai hujung sdh 26/4/2021
        scrollPanel.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener()
    {
      @Override
      public void adjustmentValueChanged(AdjustmentEvent e)
      {
        int maxValue = scrollPanel.getVerticalScrollBar().getMaximum() - scrollPanel.getVerticalScrollBar().getVisibleAmount();
        int currentValue = scrollPanel.getVerticalScrollBar().getValue();
        float fraction = (float) currentValue / (float) maxValue;

        if (fraction > THRESHOLD && neatural == false)
        {
            
          System.out.println("Scroll bar is near the bottom");  
          if(!STACK.empty()){
        
              t_swing_worker(STACK);
          neatural = true;
          }
        }
      
        if( fraction > 0.70 && neatural == true && fraction < 0.80){
         System.out.println(fraction);
     neatural = false;
        }
      }
    });
        
        
   }
   
   
   private void display_button(){
       
            s_sidebar1A_addbutton add_button = new s_sidebar1A_addbutton();
            JPanel hai = new JPanel();
                  hai = add_button.add_button(jp_people);
                  hai.setOpaque(false);
            jp_people.add(hai);
   }
   
   
    private void displaynama(){
       STACK = orang.c_church(); 
    }
    
     private JPanel side_bar_add(String myName) {
         
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
                    System.out.println(myName);
                        String intern[] =F_return_name(myName);
                        
                     //   hai_second.setPreferredSize(new Dimension(30,hai.getHeight()-hai.getHeight()/10));
                        hai_second.setBounds(0,0,hai.getWidth()-50,hai.getHeight()-hai.getHeight()/10);                   
                        hai_second.setOpaque(true);
                        
                      // hai_second.setOpaque(true);
                      
                       
                        JLabel JLabelstring = new JLabel(intern[0].replace("  ","@").replace("@@","@"),SwingConstants.CENTER);
                        JLabelstring.setForeground(Color.white);
                        
                        
                          
 //    ImageIcon imageIcon = new ImageIcon(new ImageIcon(getClass().getResource("/Profile-PNG-Icon.png")).getImage().getScaledInstance(120,150, Image.SCALE_DEFAULT));      
  //   Image tmpImage = imageIcon.getImage();   
  //getting the image      
  f_family01_g_image f_family01 = new f_family01_g_image(intern[0].replace(" ","_"));  
                       
  
  
                        JButton b = new JButton();
                        b.setOpaque(false);
                        b.setPreferredSize(new Dimension(hai_second.getWidth()-75, hai_second.getHeight()-10));
                        b.setName(intern[0]);
                        b.setRolloverEnabled(false);
                         if("anak".equals(intern[1])){
                       // hai_second.setBackground( new Color(217, 239, 243));
                       JLabelstring.setForeground(Color.white);
 hai_second.setBackground( new Color(0, 0, 0));                          
// b.setBorderPainted(false);
                        }else{
                        hai_second.setBackground( new Color(0, 0, 0));   
                        }
                        
                           try {                           
                        b.setIcon(new ImageIcon(f_family01.g_uploadimage().getScaledInstance(hai_second.getWidth()-80,hai_second.getHeight()-hai.getHeight()/10, Image.SCALE_DEFAULT)));
                        } catch (IOException ex) {
                            Logger.getLogger(s_sidebar1A_addbutton.class.getName()).log(Level.SEVERE, null, ex);
                        }
                                     b.repaint();
                                     b.revalidate();
                        
                        b.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        b.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        hai.setOpaque(true);
                    
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        b.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        hai.setOpaque(false);
                    }

                            @Override
                            public void mouseClicked(MouseEvent me) {
                                 //To change body of generated methods, choose Tools | Templates.
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
                        b.addActionListener(new ActionListener(){  
                        public void actionPerformed(ActionEvent e){ 
                            
                       
                         JButton o = (JButton)e.getSource();
                           initialization.Orang = o.getName().replaceAll(" ","_");
                          
                            returnfirstname();
                            cleareverything();
                            
                            f_family02 family = new f_family02();
                            
                            //initialization.pane_container();
                            initialization.pane_container.setLayout(new GridLayout(0,1,20,10));
                            initialization.pane_container.add(family.return_scroll_pane());
                            initialization.pane_container.setBounds(0, 0, initialization.familypanelWidth, initialization.familypanelHeight);
                            initialization.pane_container.repaint();
                            initialization.pane_container.revalidate();
                    
                            
                            s_sidebar2A sidebar = new s_sidebar2A(initialization.screenWidth/8,initialization.screenHeight/3,initialization.PanelMapWidth,initialization.PanelMapHeight); 
                            initialization.container();
                            initialization.container.add(sidebar.return_container());
                            initialization.container.setBounds(initialization.PanelBounds, 0, Containerpanelwidth, PanelHeight+10);
                            initialization.container.repaint();
                            initialization.container.revalidate();
                                      
                        }  
                        });
                        
                        
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
                        
                          /*  layout.putConstraint(SpringLayout.EAST, JLabelstring,
                          JLabelstring.getWidth()- JLabelstring.getWidth()/2+ JLabelstring.getWidth()/10,
                             SpringLayout.WEST, hai_second);
                            */
                        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, JLabelstring, 0, SpringLayout.HORIZONTAL_CENTER, hai_second);                          
                        layout.putConstraint(SpringLayout.SOUTH, JLabelstring,b.getHeight()+25,SpringLayout.SOUTH, hai_second);
                       
                       }
                       
                       
                       
    
                        // JLabelstring.setBounds(0,300, JLabelstring.getWidth(), JLabelstring.getHeight());
                         // hai.add(hai_second,BorderLayout.PAGE_START);
                         // hai.add(JLabelstring,BorderLayout.PAGE_END);
                          
// hai.add(JLabelstring);
                          
                         
                          return hai;
                   
    }
  
//used to return the first name for easy data query
private void returnfirstname() {
    c_connection_family firstname = new c_connection_family();
    initialization.first_name = firstname.returnfirstname(initialization.Orang);
    initialization.Orang = initialization.first_name;
    //initialization.Orang this is the absolute component
}

private void cleareverything(){
    initialization.i_coordinate = "";
     initialization.e_container.removeAll();
     initialization.pane_container.removeAll();
     initialization.container.removeAll();
     initialization.check_number = 0;
     initialization.notes_panel.removeAll();
       initialization.e_container.revalidate();
         initialization.e_container.repaint();
                             initialization.container.setBounds(initialization.PanelBounds-25, 0, Containerpanelwidth, PanelHeight);
                         initialization.container.repaint();
                         initialization.container.revalidate();
         

}
    
public scrollbar return_scrollPanel() {
    return scrollPanel;
}

private String[] F_return_name(String input){
 
    String[] hai = input.split("_");
    return hai;
}
  


private void e_f_family01(Stack e_i){
   int intern = e_i.size();
 for (int i = 0; i < 20; i++) {
     
     if(e_i.empty()){
         break;
     }
          jp_people.add(side_bar_add((String) e_i.pop()));
         
}
       jp_people.revalidate();
                         jp_people.repaint(); 
}

private void e_f_family01_A(Stack e_i){
    
     for (int i = 0; i < 20; i++) {
     
     if(e_i.empty()){
         break;
     }
          jp_people.add(side_bar_add((String) e_i.pop()));
         
}
            jp_people.revalidate();
                         jp_people.repaint(); 
}

private void t_swing_worker(Stack e_i){

SwingWorker sw1 = new SwingWorker() 
        {
  
            @Override
            protected String doInBackground() throws Exception 
            {
                String hello = "";
                e_f_family01_A(e_i);
                   //bad practice but that the work that i still thought possible
                   return hello;      
            } 
        };  
        // executes the swingworker on worker thread
        sw1.execute();                 
}

private void F_Encryt_name(){
    b_file_encryption_cannidate name = new b_file_encryption_cannidate();
    
    if(!name.R_stack().contains(initialization.gereja)){
      name.R_stack().add(initialization.gereja);
    };
}

}
