/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addcomponent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

/**
 *
 * @author DELL
 */
public class round_jp_people {

   
    public static JPanel main_button_stinger(){
                        
                        JPanel jLayeredPane1 = new JPanel();
                        JPanel hai = new JPanel();
                        
                        jLayeredPane1.setSize(100, 500);
                        hai.setSize(200, 500);
                      
                        JPanel hai_second = new JPanel();
                        System.out.println("Jlayered"+jLayeredPane1.getWidth()/4);
                        
                        //test this code for 3 hours plus
                        JPanel panel = new JPanel();
                        panel.setBackground( new Color(255, 0, 0,20) );
                        alphaContainer alphaContainer = new alphaContainer(panel);
                        
                      
                        hai_second.setPreferredSize(new Dimension(jLayeredPane1.getWidth(), jLayeredPane1.getHeight()-325));
                        hai_second.setBounds(0,0,200,500);
                        Border blackline = BorderFactory.createEmptyBorder(50, 0, 0, 0);
                        hai_second.setBorder(blackline);
                        
                        hai_second.setBackground( new Color(178,193,209, 20));
                     /*   JPanel intern = new JPanel();
                        intern.setOpaque(true);
                        intern.setBackground(new Color(255,255,255));*/
                            
                        //hai.setBounds(0,0,hai.getWidth()-40,jLayeredPane1.getHeight()/2-40);
                        //hai.setBackground( new Color(255, 255, 255, 40));
                        hai.setOpaque(false);
                      
                       // String intern = (String) myObject[0];
                   
                       // ImageIcon imageIcon = new ImageIcon(new ImageIcon(getClass().getResource("/image/images1.jpg")).getImage().getScaledInstance(hai.getWidth(), hai.getHeight(), Image.SCALE_DEFAULT));
      
                        rounded b = (new rounded("+")
                                
                                
                                
                                );
                
// b.setPreferredSize(new Dimension(hai.getWidth()-10, hai.getHeight()));

                        b.setOpaque(true);
                        b.setName("+");
                        b.setFont(new Font("Arial", Font.PLAIN, 40));
                        b.setForeground(new Color(178,193,209,100));
                        b.setPreferredSize(new Dimension(50,50));
                        b.setBackground(new Color(255,255,255,50));
                        b.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                     b.setCursor(new Cursor(Cursor.HAND_CURSOR));
                  b.setOpaque(false);
                    
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                      b.setCursor(new Cursor(Cursor.HAND_CURSOR));
                       // hai.setOpaque(false);
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
                       // b.setPreferredSize(new Dimension(300,300));
                   
                        b.addActionListener(new ActionListener(){  
                        public void actionPerformed(ActionEvent e){  
                       
                         
                     
                            
                            //daman...finally i get the result, this things get rosak before it even display the result
                             
                            
                       //System.out.println(intern);
                        
                        }  
                        });
                       // intern.add(b);
                       // alphaContainer.add(b);
                        hai_second.add(b);
                       // hai.add(hai_second);
                        hai.setLayout(new BorderLayout());
                       // JLabelstring.setPreferredSize(new Dimension(150,20));
                       // JLabelstring.setVerticalAlignment(JLabel.BOTTOM);
                          hai.add(new alphaContainer(hai_second),BorderLayout.PAGE_START);
                         // hai.add(JLabelstring,BorderLayout.PAGE_END);
                          
                         
                          return hai;
                   
    }





    
}
