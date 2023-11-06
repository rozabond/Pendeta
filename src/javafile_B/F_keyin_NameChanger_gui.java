/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafile_B;

import static f_family.f_family_initialization.stack;
import g_button_main_folder.f_main_AB;
import initialization.initialization;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author DELL
 */
public class F_keyin_NameChanger_gui {
    F_Keyin_save_name save_name = new F_Keyin_save_name();
    String current_name;
    public JPanel F_keyin_NameChanger_gui_A(String name){
        JPanel hai = new JPanel(new GridLayout(0,2,20,10));
        hai.setPreferredSize(new Dimension(initialization.pane_container.getWidth()/2-10,150));
        Border blackline = BorderFactory.createMatteBorder(0, 0, 2, 1, new Color(5,217,229));
           //blackline.paintBorder(box,Color.YELLOW, 0, 0, 0, 0);
        hai.setBorder(blackline);
            
    
        hai.add(F_keyin_NameChanger_gui_button(name,hai));
        
        return hai;
    }
    
    
    private JPanel F_keyin_NameChanger_gui_button(String name,JPanel cont){
        JPanel hai = new JPanel(new GridLayout(1,0,30,30));
        hai.setPreferredSize(new Dimension(initialization.pane_container.getWidth()/2,70));
     
        JPanel hai2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        JButton b_1 = new JButton("import");
        b_1.setPreferredSize(new Dimension(130, 40));
    
        JButton b = new JButton("Change name");
        b.setPreferredSize(new Dimension(130, 40));
        b.setBounds(0, 45, 130, 45);     
        
        hai2.add(b_1);
        hai2.add(b);
        hai.add(hai2);
       // hai.add(hai3);
           cont.add(F_keyin_NameChanger_gui_label(name,cont,b,b_1));
       
        return hai;
    }
    
    private JPanel F_keyin_NameChanger_gui_label(String name,JPanel cont,JButton b,JButton b_2){
        JPanel hai = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 30));
       // hai.setLayout(new BoxLayout(box, BoxLayout.PAGE_AXIS));
        JFormattedTextField item = new JFormattedTextField();
        item.setColumns(10);
        item.getDocument().addDocumentListener(new DocumentListener() {
    public void changedUpdate(DocumentEvent e) {
        warn(item.getText());
    }
    public void removeUpdate(DocumentEvent e) {
        warn(item.getText());
    }
    public void insertUpdate(DocumentEvent e) {
        warn(item.getText());
    }       
    
    public void warn(String textcheck) {
        textcheck = item.getText();
        boolean match = textcheck.matches("^[a-zA-Z0-9 ]+$"); 

        if (match == false && !textcheck.isEmpty()) {      
            JOptionPane.showMessageDialog(null, "You have inserted restricted characters (Only alphanumeric characters are allowed)", "Warning", JOptionPane.WARNING_MESSAGE);                          
        }

        if (match == true) {                            
            textcheck = item.getText() ;                     
        }                   
    }
});
        
        
        hai.setPreferredSize(new Dimension(initialization.pane_container.getWidth()/2,100));
  
        JLabel b_1 = new JLabel(name.replace("_"," "));
       
        b.addActionListener(new ActionListener(){  
        boolean magi = false;
            public void actionPerformed(ActionEvent e){  
       
          
            if(magi == false){
        b.setText("Enter"); 
         magi = true;
            hai.add(item);
   hai.repaint();
                hai.revalidate();
            }else{
               
             b.setText("Change Name");    
              b_1.setText(item.getText().replaceAll("[^a-zA-Z0-9\\s\\.]",""));
                hai.remove(item);
                hai.repaint();
                hai.revalidate();
                magi = false;
                item.setText("");
            }
        
                        }
           });
        
            b_2.addActionListener(new ActionListener(){  
        @Override
        public void actionPerformed(ActionEvent e){  
            if(!b_1.getText().isEmpty()&& !b_1.getText().equals(name.replace("_"," "))){
               // System.out.println(b_1.getText()+"APa ni ahh"+name);
            stack.add(b_1.getText());
            save_name.g_change_data(b_1.getText(),name);
            cont.setVisible(false);
            f_main_AB.box.repaint();
            f_main_AB.box.revalidate();
                        } else {
          if(b_1.getText().equals(name.replace("_"," "))){
              //     initialization.gereja = name;
               // save_name.g_save_name(name);
                 stack.add(name.replace("_"," "));
            save_name.g_change_data_oldname(name.replace("_"," "),name);
            cont.setVisible(false);
            f_main_AB.box.repaint();
            f_main_AB.box.revalidate();
            }
            }
            
            
            if(b_1.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Name Cannot be empty", "Warning", JOptionPane.WARNING_MESSAGE);                          
            }
        }
           });
        
        
        hai.add(b_1);
        return hai;
    }
}
