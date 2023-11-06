/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package initialization;

import connection.c_connection_family;
import connection.c_connection_gereja;
import f_family.f_family01;
import static initialization.initialization.Containerpanelwidth;
import static initialization.initialization.PanelHeight;
import static initialization.initialization.indicator;
import static initialization.initialization_textfield.t_a;
import static initialization.initialization_textfield.t_b;
import static initialization.initialization_textfield.t_c;
import static initialization.initialization_textfield.t_d;
import static initialization.initialization_textfield.t_e;
import static initialization.initialization_textfield.t_f;
import static initialization.initialization_textfield.t_g;
import static initialization.initialization_textfield.t_h;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.Normalizer;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafile.J_poepleImageSaved;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author DELL
 */
public class initialization_s_sidebar1A_addbutton {
         //  c_connection_gereja connect = new c_connection_gereja();
       // c_connection_family familyconnect = new c_connection_family(); 
       public static JButton b = new JButton("Submit");
       public static JButton back = new JButton("back");
       
public initialization_s_sidebar1A_addbutton(){

           initialize();
       }

    private void initialize(){
      
        b.setPreferredSize(new Dimension(70,30));
        //b.setBounds(0, 0,p.getWidth() , p.getHeight());
        //how.setAlignmentX(Component.RIGHT_ALIGNMENT+100);  
        b.addActionListener(new ActionListener(){  
                        public void actionPerformed(ActionEvent e){     
                            //very important to on and off
                    if(!t_a.getText().isEmpty() && !t_b.getText().isEmpty() && !t_c.getText().isEmpty() && !t_d.getText().isEmpty() && !t_e.getText().isEmpty() && !t_f.getText().isEmpty() && !t_g.getText().isEmpty() && !t_h.getText().isEmpty()){
                       add_info();
                    }else{
      JOptionPane.showMessageDialog(null, "Cannot have empty space", "Warning", JOptionPane.WARNING_MESSAGE);                          
                    }
                        }  
                        });
        
      
        back.setPreferredSize(new Dimension(70,30));
        back.addActionListener(new ActionListener(){  
                        public void actionPerformed(ActionEvent e){    
                         
                         initialization.e_container.removeAll();   
                         initialization.e_container.repaint();
                         initialization.e_container.revalidate();
                        // initialization.container.setBounds(initialization.PanelBounds-25, 0, Containerpanelwidth, PanelHeight);
                        //move things to its original place
                        initialization.container.setBounds(initialization.PanelBounds-2, 0, Containerpanelwidth, PanelHeight);
                        initialization.container.repaint();
                        initialization.container.revalidate();
                         
                        
                            if("FALSE".equals(indicator)) {
                        initialization.pane_container.setBounds(0, 0, initialization.familypanelWidth+250, initialization.midfamilypanelHeight);
                        initialization.pane_container.repaint();
                        initialization.pane_container.revalidate();
                            }
                         
                        }  
                        });
        
    }
    
private void setdata_empty(){
//to empty things up
    t_a.setText("");
        t_b.setText("");
        t_c.setText("");
        t_d.setText("");
        t_e.setText("");
        t_f.setText("");
        t_g.setText("");
        t_h.setText("");
    }
    
private void add_info() {
     //connect.connect("info_bank");
     String temp = null;
         Stack<String> stack = new Stack<String>();
                            int i = 0;
                            //strMain.split(", ");
       stack.add(t_a.getText().replaceAll("[^a-zA-Z0-9\\s]","__").replace(" ","_").trim());
       stack.add(t_b.getText().replaceAll("[^a-zA-Z0-9\\s\\.]","-").replace(" ","_").trim());
       stack.add(t_c.getText().replaceAll("[^a-zA-Z0-9\\s\\.]","-").replace(" ","_").trim());
       stack.add(t_d.getText().replaceAll("[^a-zA-Z0-9\\s\\.]","-").replace(" ","_").trim());
       stack.add(t_e.getText().replaceAll("[^a-zA-Z0-9\\s\\.]","-").replace(" ","_").trim());
       stack.add(t_f.getText().replaceAll("[^a-zA-Z0-9\\s\\.]","-").replace(" ","_").trim());
       stack.add(t_g.getText().replaceAll("[^a-zA-Z0-9\\s\\.]","-").replace(" ","_").trim());
       stack.add(t_h.getText().replaceAll("[^a-zA-Z0-9\\s\\.]","-").replace(" ","_").trim());
            
                            
                            i = 0;
  
                    String[] arrSplit = new String[stack.size()];
                    arrSplit = stack.toArray(arrSplit);

      c_connection_gereja connect = new c_connection_gereja();
        c_connection_family familyconnect = new c_connection_family(); 
          String apn = convertObjectArrayToString(arrSplit,"|");  
                    
                           
     //check the system...25/2/2021
     if(!apn.isEmpty()){
         try {
             if("false".equals(connect.checkiftableexist("anggotagereja" + initialization.gereja))){
                 connect.createDatabaseTable();
                 //just to make sure the person doesn't exist before..
                 
                 if(familyconnect.checkiftableexist("family" + initialization.gereja) == "true"){
                     
                     if(familyconnect.r_recheck(arrSplit[0].toLowerCase()) == null ){
                    
                         familyconnect.insertfamilytable(arrSplit[0].toLowerCase(),arrSplit[0].toLowerCase(),"leader");
                          connect.insertpeopleData(apn,arrSplit[0].toLowerCase(),"leader");
                
                     }else{
                         connect.insertpeopleData(apn,arrSplit[0].toLowerCase(),"anak");
                         familyconnect.insertfamilytable(arrSplit[0].toLowerCase(),arrSplit[0].toLowerCase(),"anak");
                     }
                     
                 }else{
                     familyconnect.createDatabaseTable();
                     if(familyconnect.r_recheck(arrSplit[0].toLowerCase()) == null ){
                         //name exist
                         familyconnect.insertfamilytable(arrSplit[0].toLowerCase(),arrSplit[0].toLowerCase(),"leader");
                           connect.insertpeopleData(apn,arrSplit[0].toLowerCase(),"leader");
                
                     }else{
                         //name doesn't exist
                         familyconnect.insertfamilytable(arrSplit[0].toLowerCase(),arrSplit[0].toLowerCase(),"anak");
                           connect.insertpeopleData(apn,arrSplit[0].toLowerCase(),"anak");
                
                     }
                 }
                 
                 
             }else{
                 
                 System.out.println(arrSplit[0].toLowerCase()+"check ini kenapa lower case");
                 
                 if(familyconnect.checkiftableexist("family" + initialization.gereja) == "true"){
                     
                     if(familyconnect.r_recheck(arrSplit[0].toLowerCase()) == null ){
                         //name exist   //name doesn't exist
                         
                         familyconnect.insertfamilytable(arrSplit[0].toLowerCase(),arrSplit[0].toLowerCase(),"leader");
                           connect.insertpeopleData(apn,arrSplit[0].toLowerCase(),"leader");
                
                     }else{
                         //name exist
                         familyconnect.insertfamilytable(arrSplit[0].toLowerCase(),arrSplit[0].toLowerCase(),"anak");
                           connect.insertpeopleData(apn,arrSplit[0].toLowerCase(),"anak");
                
                     }
                 }else{
                     familyconnect.createDatabaseTable();
                     familyconnect.insertfamilytable(arrSplit[0].toLowerCase(),arrSplit[0].toLowerCase(),"leader");
                       connect.insertpeopleData(apn,arrSplit[0].toLowerCase(),"leader");
                
                 }
                 
             }   } catch (SQLException ex) {
             Logger.getLogger(initialization_s_sidebar1A_addbutton.class.getName()).log(Level.SEVERE, null, ex.getMessage());
         }
     
     
     }
                         
           //24.5.2021 put image and if user decided not to upload image then the submit button cannot work
J_poepleImageSaved save = new J_poepleImageSaved(arrSplit[0].toLowerCase().trim().replace(" ","_"));
            
                    
   setdata_empty();
   //alright already add pic+++ 24/2/2021
add_pic();   
}
    
      private static String convertObjectArrayToString(Object[] arr, String delimiter) {
		StringBuilder sb = new StringBuilder();
		for (Object obj : arr)
			sb.append(obj.toString()).append(delimiter);
		return sb.substring(0, sb.length() - 1);
	}

private void add_pic(){
         cleareverything();
  f_family01 family = new f_family01();
  
      initialization.pane_container.add(family.return_scrollPanel());
       initialization.pane_container.repaint();
      initialization.pane_container.revalidate();
      
}

private void cleareverything(){
    initialization.pane_container.removeAll();
    initialization.e_container.removeAll();
    initialization.e_container.repaint();
    initialization.e_container.revalidate();
          initialization.container.setBounds(initialization.PanelBounds-25, 0, Containerpanelwidth, PanelHeight);
                         initialization.container.repaint();
                         initialization.container.revalidate();
}
     
        

}
