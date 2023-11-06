/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addcomponent;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;


/**
 *
 * @author DELL
 */
public class button_tambah  {
    
    //18/12/2020
   public static JPanel display_button(int w, int h,String nama){
           JPanel jp = new JPanel();   
          jp.setBounds(0,h/3,w,h);
            jp.setOpaque(false);
         //rounded rb = new rounded("Gereja");
         JButton rb =new JButton(nama);
          rb.setPreferredSize(new Dimension(w-10, h/2));
   rb.setBackground( new Color(0, 0, 51, 10) );
                          rb.setForeground(Color.white);
         rb.addActionListener(new ActionListener(){  
                        public void actionPerformed(ActionEvent e){  
                            
                        }  
                        });
         jp.add(rb);
         return jp;
    }
    
  
   
}
