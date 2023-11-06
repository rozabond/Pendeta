/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f_family;

import connection.c_connection_family;
import css.scrollbar;
import google_map.Chrome;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import initialization.initialization;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Iterator;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import s_sidebar2.s_sidebar1A_addbutton;



/**
 *
 * @author DELL
 */
public class f_family02 {
 
   c_connection_family orang_connection = new c_connection_family();
      
    String Orang = initialization.Orang;
    JPanel side_people_2 = new JPanel(new GridLayout(0,2,20,10)){
    protected void paintComponent(Graphics g)
    {
        g.setColor( getBackground() );
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
 
    }
};   
      
    final scrollbar scrollPane3 = new scrollbar(
        side_people_2,
        ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER ){
    protected void paintComponent(Graphics g)
    {
        g.setColor( getBackground() );
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
};

    public f_family02() {
        
        side_people_2_bar();
        side_people_2_add_familymember(side_people_2);
        f_chrome_decisionmakeover();
       
       // G_testConnection();
    }
    
  
    
    private void side_people_2_bar(){
        side_people_2.setSize(initialization.familypanelWidth+50, initialization.midfamilypanelHeight);
        side_people_2.setBounds(20,20,initialization.familypanelWidth+50,initialization.midfamilypanelHeight);
        side_people_2.setOpaque(false);
        side_people_2.setBackground(new Color(0,0,0));
        
        Border blackline = BorderFactory.createEmptyBorder(30, 30, 30, 30);
        side_people_2.setBorder(blackline);
       
        scrollPane3.setPreferredSize(new Dimension(initialization.midfamilypanelWidth,initialization.midfamilypanelHeight));
        scrollPane3.setBounds(0, 0, initialization.midfamilypanelWidth, initialization.midfamilypanelHeight);
        scrollPane3.setOpaque(true);
         scrollPane3.setBackground(new Color(0,0,0));
        f_family_initialization.stack.clear();
   }
    
    
    private  void display_anak_main(JPanel pane){
   
      
        Stack<String> resultSets =   orang_connection.c_checkkid();  
       // tambah_keluarga anak = new tambah_keluarga();
    
    
                       Iterator<String> itr = resultSets.iterator();
     
                       while (itr.hasNext()){
                           String hai = itr.next();
                           f_family_initialization.stack.add(hai);
                           //F-20/8/2021 - tambah indicator which one is son, and which one is not
                        Object myObject[] = {hai.replaceAll("_", " ").concat("_").concat("anak")};
                        
                  
                         pane.add(side_bar_add(pane,myObject));
                         pane.revalidate();
                         pane.repaint();
                          
                       }      
    }
    
    private void side_people_2_add_familymember(JPanel penentu){
          f_family04_add add_button = new f_family04_add();
            
            penentu.add(add_button.add_button(penentu));
            penentu.repaint();
            penentu.revalidate();  
        
        initialization.check_number = display_number_anggota_rumah(Orang);     
  
        
        if(initialization.check_number != 0){
            
            displayanggota_ketuarumah(penentu);
           // display_wife(penentu);
            display_anak_main(penentu);  
        }
            //side_bar bar = new side_bar();      
   }
   
      private  void displayanggota_ketuarumah(JPanel Penentu){
    
        //blum jadi
        
        //String query = "SELECT * FROM anggotagereja";
    Stack<String> resultSet =  orang_connection.c_checkhusband();    
    int intern = resultSet.size();
    for (int i = 0; i < intern; i++) {
    if(resultSet.empty()){
         break;
     }
           //jp_people.add(side_bar_add((String) e_i.pop())); 
            //F-20/8/2021 - tambah indicator which one is son, and which one is not for color exchange
           Object myObject[] = {resultSet.pop().replaceAll("_", " ").concat("_").concat("leader")};                   
           Penentu.add(side_bar_add(Penentu,myObject));
}
    Penentu.repaint();
    Penentu.revalidate();
    }
    
public  void display_wife(JPanel Penentu){

        ResultSet resultSet =  orang_connection.c_checkwife();  
        
    try{
       if(resultSet.isBeforeFirst()){
                    // loop through the result set
                    while (resultSet.next()) {
                        Object myObject[] = {resultSet.getString("name_second")};
                        
                       String Nama = (String) myObject[0];
                       
              
                    
                       //System.out.println("nama_wife:" + Nama);
              
                        JPanel hai = new JPanel();
                       // button.button_stinger(jLayeredPane1, hai, myObject);
                        // jp_people.add(side_bar_add(jp_people, myObject));
                       // jp_people.add(side_button_stinger(jp_people,hai, myObject));
                        Penentu.add(side_bar_add(Penentu,myObject)); 
                     
                     /*  if(Nama != ""){
                           nama_wife.setText(Nama);
                          
                       }
                       
                       if(Nama == ""){
                            panel_wife.setVisible(false);
                       }*/
                   
                  
                  //      tableModel.addRow(myObject);
                        // System.out.println(resultSet.getInt("word") + "\t" + rs.getString("type"));
                //        statusTxt.setText("Record found!");
                    }
                }else{
                   // SQLiteConnection.insertDatabaseData(1, "love", "verb", "Deep affecion");
                   System.out.println("There is no data!");
                }
       }catch (SQLException exp){
                System.out.println("Result Error: " + exp);                
            }
          
    }

private JPanel side_bar_add(JPanel Panel_size, Object myObject[]) {
                        
                        JPanel hai = new JPanel();
                        hai.setBounds(0,0,Panel_size.getWidth()/2,Panel_size.getHeight()/3-Panel_size.getHeight()/19);
                        hai.setBackground( new Color(255, 255, 255, 1));
                        hai.setOpaque(false);
                        //24/2/2021..very important feature that i figure out...by His grace, cause honestly, i myself don't have the will or strength to be able to execute this manner of things
                        hai.setPreferredSize(new Dimension(Panel_size.getWidth()/2-75, Panel_size.getHeight()/3-Panel_size.getHeight()/23));
                        
                        
                       String[] intern = F_return_name((String) myObject[0]);
                        JPanel hai_second = new JPanel();
                        System.out.println("Jlayered"+Panel_size.getWidth()/4);
                     //   hai_second.setPreferredSize(new Dimension(30,hai.getHeight()-hai.getHeight()/10));
                        hai_second.setBounds(0,0,hai.getWidth()-50,hai.getHeight()-hai.getHeight()/10);                   
                      
                        
                        hai_second.setOpaque(true);
                      
                    
                   
                        JLabel JLabelstring = new JLabel(intern[0].replace("  ","@").replace("@@","@"),SwingConstants.CENTER);
                        JLabelstring.setForeground(Color.white);
              
                        f_family02_g_image f_family01 = new f_family02_g_image(intern[0]);  
                       
                        
                       JButton b = new JButton();
                        
                        if("anak".equals(intern[1])){
                       // hai_second.setBackground( new Color(217, 239, 243));
                       JLabelstring.setForeground(Color.white);
 hai_second.setBackground( new Color(0, 0, 0));                          
// b.setBorderPainted(false);
                        }else{
                        hai_second.setBackground( new Color(0, 0, 0));   
                        }
                       
                        b.setOpaque(false);
                        b.setPreferredSize(new Dimension(hai_second.getWidth()-60, hai_second.getHeight()-10));
                        b.setName(intern[0]); 
                        b.setRolloverEnabled(false);
                        
                           try {   
                        b.setIcon(new ImageIcon(f_family01.g_uploadimage().getScaledInstance(hai_second.getWidth()-65,hai_second.getHeight()-hai.getHeight()/10, Image.SCALE_DEFAULT)));
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
                        Orang = o.getName().replaceAll(" ", "_");
                        //for delete() function
                        initialization.second_name = Orang;
                        
                        f_family03_info family = new f_family03_info();
                        f_family03_info_button family_delete = new f_family03_info_button();
                        
                         //gereja.return_side_people().getSize(new Dimension(Panel_size.getWidth() ,Panel_size.getHeight()/10));
                         //gereja.return_side_people().setBounds(0, 0,Panel_size.getWidth() ,Panel_size.getHeight()/10 );
                         initialization.e_container.removeAll();
                         
                         initialization.e_container();
                         //initialization.e_container.setLayout(new BoxLayout(initialization.e_container,BoxLayout.PAGE_AXIS));
                         //initialization.e_container.setLayout(new BorderLayout());
                         initialization.e_container.setLayout(new BoxLayout(initialization.e_container, BoxLayout.PAGE_AXIS));
                         initialization.e_container.setBounds(initialization.e_PanelBounds+25, 0, initialization.e_containerWidth, initialization.e_containerHeight);
                         initialization.e_container.add(family.g_appear_box(initialization.e_container,Orang),BorderLayout.CENTER);
                         initialization.e_container.add(family.g_Form(initialization.e_container,family.d_display_information(Orang)),BorderLayout.PAGE_END);
                         initialization.e_container.add(family_delete.s_f_family03_info_p());
                         initialization.e_container.repaint();
                         initialization.e_container.revalidate();
                         initialization.e_container.setVisible(true);
                   
                         i_initialized_button_notes_homie();
                        initialization.notes_panel.remove(initialization.button_homie);  
                        initialization.button_notes_homie.setBounds(initialization.notes_panel.getWidth()-50, 0, 100, 50);
                        initialization.button_notes_homie.setPreferredSize(new Dimension(100, 50));
                        initialization.button_notes_homie.setBackground( new Color(0, 0, 51, 10) );
                        initialization.button_notes_homie.setForeground(Color.white);
                        initialization.notes_panel.add(initialization.button_notes_homie,BorderLayout.PAGE_END);
            
                       
                       
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
    
    private void i_initialized_button_notes_homie(){
    initialization.button_notes_homie.addActionListener(new ActionListener(){  
         public void actionPerformed(ActionEvent e){  
             initialization.notes_panel.remove(initialization.button_notes_homie);  
             initialization.button_homie.setBounds(initialization.notes_panel.getWidth()-50, 0, 100, 50);
             initialization.button_homie.setPreferredSize(new Dimension(100, 50));
             initialization.button_homie.setBackground( new Color(0, 0, 51, 10) );
             initialization.button_homie.setForeground(Color.white);
             initialization.notes_panel.add(initialization.button_homie,BorderLayout.PAGE_END);       
         
             cleareverything();
         
         }  
                        });
    }
    
    
     private void cleareverything(){
     initialization.check_number = 0;
     initialization.e_container.removeAll();
     initialization.e_container.repaint();
     initialization.e_container.revalidate();
}
   
    
private String[] F_return_name(String input){
 
    String[] hai = input.split("_");
    return hai;
}
  
     
     
    private int display_number_anggota_rumah(String nama) {
        
           Orang = nama;
      
      
        //blum jadi
        //2/3/2021
        //String query = "SELECT * FROM anggotagereja" ;

        
        try{
                  // System.out.println("apa la kunu" + orang.checkiftableexist("family"+initialization.gereja));
        if(  orang_connection.checkiftableexist("family"+initialization.gereja) == "true"){
                

       // ResultSet resultSet = orang.displaycountanggota_ketuarumah();    
        initialization.check_number = initialization.check_number+   orang_connection.d_countanggota_ketuarumah();        
        /*if(resultSet != null){
        resultSet.next();
        System.out.println("Table laki contains "+resultSet.getInt("count(*)")+" rows");
        initialization.check_number = initialization.check_number+ resultSet.getInt("count(*)");
        }
        */
        //important to have null, in order that, the computer isn't crash                  
            
        //ResultSet resultBini = orang.d_countwife();  
        initialization.check_number = initialization.check_number+  orang_connection.d_countwife();  
       /* if(resultBini != null){
        resultBini.next();
        System.out.println("Table bini contains "+resultBini.getInt("count(*)")+" rows");
     
        }*/
        

         //ResultSet resultanak = orang.d_countcheckson(); 
          initialization.check_number = initialization.check_number+  orang_connection.d_countcheckson(); 
        /*if(resultanak != null){
        resultanak.next();
        System.out.println("Table anak contains "+resultBini.getInt("count(*)")+" rows");
        initialization.check_number = initialization.check_number+ resultanak.getInt("count(*)");
        }*/
        
        
        
        }else{
        orang_connection.createDatabaseTable();
        initialization.check_number = 0;
        }
        }catch(SQLException exp){
       System.out.println("Database table checking error");
       }
        return initialization.check_number;
    }
    
   
       
       
    public JPanel return_side_people_2() {
        return side_people_2;
    }
    
    public scrollbar return_scroll_pane() {
        return scrollPane3;   
    }
    
    private void f_chrome_decisionmakeover(){
        if(initialization.h_indicator == false){
            
        Chrome.t_swing_worker();
    }
  
}}