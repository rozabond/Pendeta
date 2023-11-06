/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import addcomponent.SpringUtilities;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import static login.F_Login_initialization.LostPassword;
import static login.F_Login_initialization.back;
import static login.F_Login_initialization.l_a_product_email;
import static login.F_Login_initialization.l_a_product_email_warning;
import static login.F_Login_initialization.textField_1;

/**
 *
 * @author DELL
 */
public class F_forget_password {
 JPanel hai_origin = new JPanel();
 
 F_forget_password(){
     init_label();
 }
 
   private void init_label(){
        F_Login_initialization.l_a_product_email_warning.setVisible(false);
        F_Login_initialization.l_a_product_email_warning.setForeground(Color.yellow);
    }
    
 
    public JPanel init(){
           SpringLayout layout = new SpringLayout();
           hai_origin.setLayout(layout);
           hai_origin.setPreferredSize(new Dimension(325,350));
           hai_origin.setBounds(0, 0, hai_origin.getWidth(), hai_origin.getHeight());
          // hai_origin.setBackground(new Color(255,255,255,10));
           
           JLabel Title = new JLabel("Enter Your Email", JLabel.TRAILING);
           Title.setForeground(Color.WHITE);
       
           JPanel hai2 = new JPanel(new GridLayout(0,2,20,10));
           hai2.setPreferredSize(new Dimension(400,40));
           hai2.setBounds(0, 0, hai2.getWidth(), hai2.getHeight());
           hai2.setBackground(new Color(23,25,34));
   
       
           
           
            JLabel l = new JLabel("Email", JLabel.TRAILING);
            hai2.add(l);
            textField_1.setPreferredSize(new Dimension(hai2.getWidth(),70));
            l.setLabelFor(textField_1);
            hai2.add(textField_1);
            
             SpringUtilities.makeCompactGrid(hai2,
                                        2, 2, //rows, cols
                                        2, 20,        //initX, initY
                                        2, 20);       //xPad, yPad 
            
            layout.putConstraint(SpringLayout.VERTICAL_CENTER, Title, -75, SpringLayout.VERTICAL_CENTER, hai_origin);  
            layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, Title,-80, SpringLayout.HORIZONTAL_CENTER, hai_origin); 
            layout.putConstraint(SpringLayout.VERTICAL_CENTER, hai2,-30, SpringLayout.VERTICAL_CENTER, hai_origin);  
            layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, hai2,-70, SpringLayout.HORIZONTAL_CENTER, hai_origin); 
            layout.putConstraint(SpringLayout.VERTICAL_CENTER, LostPassword, 100, SpringLayout.VERTICAL_CENTER, hai_origin);  
            layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, LostPassword,90, SpringLayout.HORIZONTAL_CENTER, hai_origin); 
            layout.putConstraint(SpringLayout.VERTICAL_CENTER, back, 100, SpringLayout.VERTICAL_CENTER, hai_origin);  
            layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, back,-90, SpringLayout.HORIZONTAL_CENTER, hai_origin);         
            layout.putConstraint(SpringLayout.VERTICAL_CENTER, l_a_product_email_warning, 20, SpringLayout.VERTICAL_CENTER, hai_origin);  
            layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, l_a_product_email_warning, -60, SpringLayout.HORIZONTAL_CENTER, hai_origin);           
                    
            
            hai_origin.add(Title);
            hai_origin.add(hai2);
            hai_origin.add(LostPassword);
            hai_origin.add(back);  
            hai_origin.add(l_a_product_email_warning);
            
            return hai_origin;
    }
}
