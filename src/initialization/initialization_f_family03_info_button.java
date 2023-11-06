/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package initialization;


import connection.c_connection_family;
import connection.c_connection_gereja;
import f_family.f_family01;
import f_family.f_family02;
import f_family.f_family_initialization;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.Normalizer;
import java.util.Iterator;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import s_sidebar2.s_sidebar1A;

/**
 *
 * @author DELL
 */
public class initialization_f_family03_info_button {
    
    public static JButton f_info_button_01_B_C_B_A = new JButton("Delete");
    
  static c_connection_gereja gerejadelete = new c_connection_gereja();
   static c_connection_family familydelete = new c_connection_family();     

     
    public initialization_f_family03_info_button(){  
    }
    
    public  void i_initialize(){
      
        f_info_button_01_B_C_B_A.setPreferredSize(new Dimension(70,30));
        //b.setBounds(0, 0,p.getWidth() , p.getHeight());
        //how.setAlignmentX(Component.RIGHT_ALIGNMENT+100);  
        f_info_button_01_B_C_B_A.addActionListener(new ActionListener(){  
                        public void actionPerformed(ActionEvent e){     
                      
                            //very important to on and off
                      
                   
                        if(initialization.first_name.equals(initialization.second_name)){
                   
                        f_delete_info_main();
                        
                        }else{
                        cleareverything();
                        f_delete_info();
                        re_paint();        
                        }
                        }  
                        });
        
    }
    
//Function dad-deleteall
private void d_delete_all_child(){
   f_family_initialization stack = new f_family_initialization();
     Iterator<String> itr =  stack.r_returnstack().iterator();
          while (itr.hasNext()){
              String kjp =itr.next().replace(" ","_");
              System.out.println("dia masuk ka" + kjp);
          gerejadelete.g_delete(kjp);
          }
}


private void f_delete_info(){

    gerejadelete.d_delete();
    familydelete.f_d_delete();
    
    if(initialization.first_name.equals(initialization.second_name)){
     
    familydelete.f_d_delete_main();
     d_delete_all_child();

       
            }
   //f_family_04_gereja_connect.c_close();
}

private void f_delete_info_main(){
    JFrame f;  
            f=new JFrame();    
    f.setSize(300, 300);  
    f.setLayout(null);  
    f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);  
    f.setVisible(false); 
    int a =JOptionPane.showConfirmDialog(f,"This will delete all Family. Are you sure?");  
    if(a==JOptionPane.YES_OPTION){  
             cleareverything_main();
    f_delete_info();
    f_repaint_main();
    }
}

private void f_repaint_main(){
                
            s_sidebar1A side = new s_sidebar1A();  
             initialization.container();
            initialization.container.add(side.return_container());
            initialization.container.repaint();
            initialization.container.revalidate();
                           
            f_family01 family = new f_family01(); 
            initialization.pane_container.add(family.return_scrollPanel());
            initialization.pane_container.repaint();
            initialization.pane_container.revalidate();
}


public static void cleareverything_main(){
       initialization.pane_container.removeAll();
     initialization.container.removeAll();
     initialization.check_number = 0;
     initialization.e_container.removeAll();
     initialization.e_container.repaint();
     initialization.e_container.revalidate();
}


public static void cleareverything(){
    
     initialization.pane_container.removeAll();
     initialization.check_number = 0;
     initialization.e_container.removeAll();
     initialization.e_container.repaint();
     initialization.e_container.revalidate();
}

public static void re_paint(){
                                     
                            f_family02 family = new f_family02();                            
                            initialization.pane_container.add(family.return_scroll_pane());
                            initialization.pane_container.setBounds(0, 0, initialization.familypanelWidth, initialization.familypanelHeight);
                            initialization.pane_container.repaint();
                            initialization.pane_container.revalidate();
                            
                            initialization.notes_panel.remove(initialization.button_notes_homie);  
                            initialization.button_homie.setBounds(initialization.notes_panel.getWidth()-50, 0, 100, 50);
                            initialization.button_homie.setPreferredSize(new Dimension(100, 50));
                            initialization.button_homie.setBackground( new Color(0, 0, 51, 10) );
                            initialization.button_homie.setForeground(Color.white);
                            initialization.notes_panel.add(initialization.button_homie,BorderLayout.PAGE_END);

}

}
