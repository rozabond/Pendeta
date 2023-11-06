/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s_sidebar2.notes;


import java.awt.GridLayout;
import javax.swing.JPanel;


/**
 *
 * @author DELL
 */
public class s_notes {
     JPanel notes = new JPanel(new GridLayout(0,2,20,10));        
     JPanel notas = new JPanel();
 
 
 /*
      private void load_notes(){      
    
        JPanel kertas = new JPanel();
        kertas.setPreferredSize(new Dimension(notes.getWidth(), notes.getHeight()));
        kertas.setBounds(0,0,notes.getWidth(),notes.getHeight());
        kertas.setOpaque(true);
       // notes.add(header, BorderLayout.NORTH);
        notes hai = new notes();
        kertas.add(hai.loading_info(notes));
        kertas.setBackground( new Color(255,255, 255, 50) );
        kertas.setLayout(new BorderLayout());
       // Border blackline = BorderFactory.createEmptyBorder(10, 10,10, 10);
       
      // notes.add(hai.loading_info(notes));
        //scrollPane_notes.setVisible(false);
        notas.add(kertas);
        notes_panel.add(notas);
        //the things that actually cause the bug, i suddently add two notes..14/1/2021 4 hours debug
        //notes_panel.add(notes);
   }
    
    
       private void put_picture_notes(){
       notes_panel.setVisible(false);
       notes_panel.remove(notas);
       notas.setVisible(false);
       notes.removeAll();                        
       //nice invention 14/1/2021
       side_bar bar = new side_bar();
       bar.side_people_2_add_familymember(notes,Orang);
       scrollPane_notes.repaint();
       scrollPane_notes.revalidate();
       notes.setVisible(true);
       notes_panel.add(scrollPane_notes);
       notes_panel.setVisible(true);
       //notes_panel.add(scrollPane_notes);
      // notes.setVisible(false);
   }
    
   */ 
    
}
