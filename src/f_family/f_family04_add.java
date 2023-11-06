/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f_family;

import addcomponent.SpringUtilities;
import css.f_family_g_add_button_image;


import initialization.initialization;
import static initialization.initialization_textfield.t_a;
import static initialization.initialization_textfield.t_b;
import static initialization.initialization_textfield.t_c;
import static initialization.initialization_textfield.t_d;
import static initialization.initialization_textfield.t_e;
import static initialization.initialization_textfield.t_f;
import static initialization.initialization_textfield.t_g;
import static initialization.initialization_textfield.t_h;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafile.J_SampleJFileChooser;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import s_sidebar2.s_sidebar1A_addbutton;

/**
 *
 * @author DELL
 */
public class f_family04_add {
    
      List<JTextField> lists = new ArrayList<JTextField>();
      public f_family04_add(){
     //i_JButton_submit();
      }
      
      

      
     public JPanel add_button(JPanel Panel_size) {
                        
                        JPanel hai = new JPanel();
                        hai.setBounds(0,0,Panel_size.getWidth()/2,Panel_size.getHeight()/3-Panel_size.getHeight()/19);
                        hai.setBackground( new Color(255, 255, 255, 1));
                        hai.setOpaque(false);
                        hai.setSize(Panel_size.getWidth()/2, Panel_size.getHeight()/3-Panel_size.getHeight()/19);
                        
                        
                  
                        f_family_g_add_button_image hai_second = new f_family_g_add_button_image();
                        System.out.println("Jlayered"+Panel_size.getWidth()/4);
                        //hai_second.setPreferredSize(new Dimension(30,hai.getHeight()-hai.getHeight()/10));
                        hai_second.setBounds(0,0,hai.getWidth()-50,hai.getHeight()-hai.getHeight()/10);                   
                       // hai_second.setBackground( new Color(0, 0, 0, 70));
                        hai_second.setOpaque(false);
                      
               
                       // JLabel JLabelstring = new JLabel(intern,SwingConstants.CENTER);
                       // JLabelstring.setForeground(Color.white);
                        //ImageIcon imageIcon = new ImageIcon(new ImageIcon(getClass().getResource("/image/plus.png")).getImage().getScaledInstance(hai_second.getWidth(), hai_second.getHeight(), Image.SCALE_DEFAULT));      
                        
                        JButton b = new JButton();
                        b.setOpaque(false);
                        b.setPreferredSize(new Dimension(hai_second.getWidth()-65, hai_second.getHeight()-10));
                        //b.setName(intern);
                        b.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        b.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    
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
                
                         initialization.e_container.removeAll();
                         initialization.e_container();
                       
                         h_button_homie();
                         initialization.e_container.setLayout(new BoxLayout(initialization.e_container, BoxLayout.PAGE_AXIS)); 
                       
                         initialization.e_container.add(appear_add_box(initialization.e_container),BorderLayout.PAGE_START);
                         initialization.e_container.add(Add_Form(initialization.e_container),BorderLayout.CENTER);
                         initialization.e_container.add(Add_jackButton(initialization.e_container),BorderLayout.PAGE_END);
                         initialization.e_container.repaint();
                         initialization.e_container.revalidate();
                         initialization.e_container.setVisible(true);
                         
                         
                        
                        
                        }  
                        });
                        
                        
                        //implementation sides
                        hai_second.add(b);
                       // hai.add(hai_second);
                       if(initialization.check_number >=3){
                        SpringLayout layout = new SpringLayout();
                       hai.setLayout( layout);
                         hai.add(hai_second);
                         //JLabelstring.setSize(new Dimension(150,30));
                         //JLabelstring.setHorizontalAlignment(SwingConstants.CENTER);
                         //JLabelstring.setVerticalAlignment(SwingConstants.BOTTOM);
                         // hai.add(JLabelstring,BorderLayout.PAGE_END);
                       }else{
                           //man
                         //JLabelstring.setPreferredSize(new Dimension(150,30));
                         //JLabelstring.setHorizontalAlignment(SwingConstants.CENTER);
                         //JLabelstring.setVerticalAlignment(SwingConstants.BOTTOM);
                              SpringLayout layout = new SpringLayout();
                       hai.setLayout( layout);
                         hai.add(hai_second);
                          //hai.add(JLabelstring);
                        
                          /*  layout.putConstraint(SpringLayout.EAST, JLabelstring,
                          JLabelstring.getWidth()- JLabelstring.getWidth()/2+ JLabelstring.getWidth()/10,
                             SpringLayout.WEST, hai_second);
                            */
                       // layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, JLabelstring, 0, SpringLayout.HORIZONTAL_CENTER, hai_second);                          
                       // layout.putConstraint(SpringLayout.SOUTH, JLabelstring,b.getHeight()+25,SpringLayout.SOUTH, hai_second);
                       
                       }
                       
                       
                       
    
                        // JLabelstring.setBounds(0,300, JLabelstring.getWidth(), JLabelstring.getHeight());
                         // hai.add(hai_second,BorderLayout.PAGE_START);
                         // hai.add(JLabelstring,BorderLayout.PAGE_END);
                          
// hai.add(JLabelstring);
                          return hai;
    }
     
    private JPanel Add_Form(JPanel Panel_size) {
         JPanel p = new JPanel(new SpringLayout());
         p.setSize(new Dimension(Panel_size.getWidth(),Panel_size.getHeight()/2));
         p.setBounds(0, 0, Panel_size.getWidth(), Panel_size.getHeight()/2);
         String[] labels = {"Nama","Ic: ", "Tarikh_lahir: ", "Agama_Asal: ","Agama_Terkini:","Tarikh_dibaptis:","Alamat_terkini:","Nombor_tel:"};
         int numPairs = labels.length;
         
        JLabel l = new JLabel(labels[0], JLabel.TRAILING);
            p.add(l);          
            t_a.setPreferredSize(new Dimension(20,29));
            l.setLabelFor(t_a);
            p.add(t_a);
            
            JLabel l_b = new JLabel(labels[1], JLabel.TRAILING);
            p.add(l_b);   
            t_b.setPreferredSize(new Dimension(20,29));
            l_b.setLabelFor(t_b);
            p.add(t_b);
            
            JLabel l_c = new JLabel(labels[2], JLabel.TRAILING);
            p.add(l_c);   
            t_c.setPreferredSize(new Dimension(20,29));
            l_c.setLabelFor(t_c);
            p.add(t_c);
            
            JLabel l_d = new JLabel(labels[3], JLabel.TRAILING);
            p.add(l_d);  
            t_d.setPreferredSize(new Dimension(20,29));
            l_d.setLabelFor(t_d);
            p.add(t_d);
            
            JLabel l_e = new JLabel(labels[4], JLabel.TRAILING);
            p.add(l_e); 
            t_e.setPreferredSize(new Dimension(20,29));
            l_e.setLabelFor(t_e);
            p.add(t_e);
            
            JLabel l_f = new JLabel(labels[5], JLabel.TRAILING);
            p.add(l_f); 
            t_f.setPreferredSize(new Dimension(20,29));
            l_f.setLabelFor(t_f);
            p.add(t_f);
            
            JLabel l_g = new JLabel(labels[6], JLabel.TRAILING);
            p.add(l_g); 
            t_g.setPreferredSize(new Dimension(20,29));
            l_g.setLabelFor(t_g);
            p.add(t_g);
        
            JLabel l_h = new JLabel(labels[7], JLabel.TRAILING);
            p.add(l_h); 
            t_h.setPreferredSize(new Dimension(20,29));
            l_h.setLabelFor(t_h);
            p.add(t_h);
        
        
          SpringLayout layout = new SpringLayout();
      
         SpringUtilities.makeCompactGrid(p,
                                        numPairs, 2, //rows, cols
                                        6, 6,        //initX, initY
                                        6, 6);       //xPad, yPad 
         
          //p.setSize(new Dimension(Panel_size.getWidth(),Panel_size.getHeight()/2-300));
        //p.setBackground(new Color(255,255,255));
        return p;
    }
        
       private JPanel appear_add_box(JPanel Panel_size){
           JPanel hai = new JPanel();
                        hai.setBounds(0,0,Panel_size.getWidth(),Panel_size.getHeight()/3-Panel_size.getHeight()/19);
                        hai.setBackground( new Color(0, 0, 0));
                        hai.setOpaque(false);
                        hai.setSize(Panel_size.getWidth(), Panel_size.getHeight()/3-Panel_size.getHeight()/15);
                        
                        
                  
                        JPanel hai_second = new JPanel();
                        System.out.println("Jlayered"+Panel_size.getWidth()/4);
                        hai_second.setSize(new Dimension(hai.getWidth()/2,hai.getHeight()-hai.getHeight()/10));
                        hai_second.setBounds(hai.getWidth()/4,0,hai.getWidth()/2,hai.getHeight()-hai.getHeight()/10);                   
                        hai_second.setBackground( new Color(0, 0, 0));
                        hai_second.setOpaque(true);
                      
                        
                        JButton b = (new JButton());
                     
                        // b.setBackground(new Color(0,0,0));
                        JButton intern = new JButton("click");
                        b.setBackground(new Color(117,117,118));
                        b.setOpaque(false);
                        intern.addActionListener(new ActionListener(){  
                        public void actionPerformed(ActionEvent e){                              
                        JButton o = (JButton)e.getSource();
                            J_SampleJFileChooser hq  = new  J_SampleJFileChooser();
                                   //  i_canvas_main_image image = new i_canvas_main_image();
                        try {
                           
                             b.setIcon(new ImageIcon(hq.f_display_image().getScaledInstance(hai_second.getWidth(),hai_second.getHeight()-hai.getHeight()/15, Image.SCALE_DEFAULT)));
                        } catch (IOException ex) {
                            Logger.getLogger(s_sidebar1A_addbutton.class.getName()).log(Level.SEVERE, null, ex);
                        }
                                     b.repaint();
                                     b.revalidate();
                        
                        }  
                        });
                        
                        b.setPreferredSize(new Dimension(hai_second.getWidth()-65, hai_second.getHeight()-10));
                        
                      
                        
                        
                        //implementation sides
                        hai_second.add(b);
                        intern.setPreferredSize(new Dimension(80,25));
                        intern.setHorizontalAlignment(SwingConstants.CENTER);
                        intern.setVerticalAlignment(SwingConstants.BOTTOM);
                        SpringLayout layout = new SpringLayout();
                        hai.setLayout( layout);
                        hai.add(hai_second);
                        hai.add(intern);
                        
                          /*  layout.putConstraint(SpringLayout.EAST, JLabelstring,
                          JLabelstring.getWidth()- JLabelstring.getWidth()/2+ JLabelstring.getWidth()/10,
                             SpringLayout.WEST, hai_second);
                            */
                        layout.putConstraint(SpringLayout.VERTICAL_CENTER, hai_second, 0, SpringLayout.VERTICAL_CENTER, hai);  
                        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, hai_second, 0, SpringLayout.HORIZONTAL_CENTER, hai); 
                        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, intern, 0, SpringLayout.HORIZONTAL_CENTER, hai_second);                          
                        layout.putConstraint(SpringLayout.SOUTH, intern,b.getHeight()+35,SpringLayout.SOUTH, hai_second);
                       
                       
                       
                       
                       
    
                        // JLabelstring.setBounds(0,300, JLabelstring.getWidth(), JLabelstring.getHeight());
                         // hai.add(hai_second,BorderLayout.PAGE_START);
                         // hai.add(JLabelstring,BorderLayout.PAGE_END);
                          
// hai.add(JLabelstring);
                          
                         
                          return hai;
    }
         
       private JPanel Add_jackButton(JPanel Panel_size){
   
        JPanel p = new JPanel();
       // p.setLayout(new BoxLayout(p,BoxLayout.PAGE_AXIS));
            FlowLayout experimentLayout = new FlowLayout(FlowLayout.RIGHT, 0, 20);
            p.setLayout(experimentLayout);
      
        p.setPreferredSize(new Dimension(Panel_size.getWidth()/5,Panel_size.getHeight()/12));
        p.setBounds(0, 0, p.getWidth(), p.getHeight());   
    

   
        
        p.setBackground(new Color(0,0,0,1));
        p.add(initialization.f_family_04_add_b);
        
        return p;
   }



public static void add_pic(){
         cleareverything();
  f_family02 family = new f_family02();
                            initialization.pane_container.add(family.return_scroll_pane());
                            initialization.pane_container.setBounds(0, 0, initialization.familypanelWidth, initialization.familypanelHeight);
                            initialization.pane_container.repaint();
                            initialization.pane_container.revalidate();
}

private void h_button_homie(){
      i_initialized_button_notes_homie();
                        initialization.notes_panel.remove(initialization.button_homie);  
                        initialization.button_notes_homie.setBounds(initialization.notes_panel.getWidth()-50, 0, 100, 50);
                        initialization.button_notes_homie.setPreferredSize(new Dimension(100, 50));
                        initialization.button_notes_homie.setBackground( new Color(0, 0, 51, 10) );
                        initialization.button_notes_homie.setForeground(Color.white);
                        initialization.notes_panel.add(initialization.button_notes_homie,BorderLayout.PAGE_END);
}

private void i_initialized_button_notes_homie(){
    initialization.button_notes_homie.addActionListener(new ActionListener(){  
         public void actionPerformed(ActionEvent e){  
             initialization.notes_panel.remove(initialization.button_notes_homie);  
             initialization.button_homie.setBounds(initialization.notes_panel.getWidth()-50, 0, 100, 50);
             initialization.button_homie.setPreferredSize(new Dimension(100, 50));
             initialization.button_homie.setBackground( new Color(0, 0, 51, 10) );
             initialization.button_homie.setForeground(Color.white);
             initialization.notes_panel.add(initialization.button_homie,BorderLayout.PAGE_END);       
         
             cleareverything_2();
             //cleareverything();
         
         }  
                        });
    }

private void cleareverything_2(){
    initialization.e_container.removeAll();
       initialization.e_container.repaint();
      initialization.e_container.revalidate();
}

public static void cleareverything(){
     
    initialization.pane_container.removeAll();
     initialization.pane_container.repaint();
      initialization.pane_container.revalidate();

}
     
        
}
