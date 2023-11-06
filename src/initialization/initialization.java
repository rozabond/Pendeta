package initialization;


import connection.c_connection_family;
import connection.c_connection_gereja;
import connection.c_connection_map;
import css.scrollbar;
import f_family.f_family01;
import f_family.f_family01_dpt;
import f_family.f_family02;
import static f_family.f_family04_add.add_pic;
import f_family.f_family_initialization;
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
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import javafile.J_poepleImageSaved;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingWorker;
import javax.swing.border.Border;
import s_sidebar2.s_sidebar1A;
import s_sidebar2.s_sidebar2A;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class initialization {
    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  
  //specifically created for keyboard handler between heavy weight and non heavy weight.!
  public static JFrame jFrame1 = new javax.swing.JFrame("Pendeta");  
  //public static int screenHeight = screenSize.height;
  //public static int screenWidth = screenSize.width;
  
    public static int screenHeight = 768;
  public static int screenWidth = 1366;
  
  public static int panel_church_width = 200;
  public static int panel_church_heigth = 350;
      
  public static int PanelHeight = initialization.screenHeight-initialization.screenHeight/7;
  public static int PanelWidth = initialization.screenWidth-initialization.screenWidth/2-initialization.screenWidth/3+50;
  
  public static int Containerpanelwidth = initialization.screenWidth-initialization.screenWidth/2-initialization.screenWidth/3+62;
  
  public static int PanelMapHeight = initialization.screenHeight-initialization.screenHeight/7;
  public static int PanelMapWidth = initialization.screenWidth- initialization.screenWidth/10 ;
  
  public static int midfamilypanelHeight = initialization.screenHeight-initialization.screenHeight/7;
  public static int midfamilypanelWidth = initialization.screenWidth- initialization.screenWidth/2  - initialization.screenWidth/8 ;
  
  public static int familypanelHeight = initialization.screenHeight-initialization.screenHeight/7;
  public static int familypanelWidth = initialization.screenWidth- initialization.screenWidth/2-initialization.screenWidth/5 ;
  
  //to put things to the right
  public static int PanelBounds = initialization.screenWidth-initialization.screenWidth/4;
  
  public static int notes_panel_width = initialization.screenHeight/8;
  public static int notes_panel_height = initialization.screenHeight/3;
  
  public static int s_panel_width = initialization.screenWidth- initialization.screenWidth/10 ;
  public static int s_panel_height = initialization.screenHeight-initialization.screenHeight/7;
  
  public static List<JPanel> lists_panel = new ArrayList<JPanel>();
  
  public static JPanel container = new JPanel(){
    protected void paintComponent(Graphics g)
    {
        g.setColor( getBackground() );
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
};

  public static JPanel e_container = new JPanel(){
    protected void paintComponent(Graphics g)
    {
        g.setColor( getBackground() );
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
};

  public static int e_containerHeight = initialization.screenHeight-initialization.screenHeight/4 +30 ;
  public static int e_containerWidth = initialization.screenWidth- initialization.screenWidth/2-initialization.screenWidth/4 ;

 public static int e_PanelBounds = initialization.screenWidth-initialization.screenWidth/3 -initialization.screenWidth/6 -initialization.screenWidth/25;
  
 public static JButton f_family_04_add_b = new JButton("Submit");

 public static String indicator;
  
  public static JLayeredPane pane_container = new JLayeredPane(){
    protected void paintComponent(Graphics g)
    {
        g.setColor( getBackground() );
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
};
   public static final scrollbar scrollPanel = new scrollbar(
        pane_container,
        ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
  
  
  public static String Orang;
  public static String gereja = null;
  
  //to ensure that the system show picture nice and without bug 17/2/2021
  public static int check_number =0;
  
  //ini untuk terima itu, textfield pnya input
  public static List<JTextField> lists = new ArrayList<JTextField>();
  public static String second_name; 
  public static String first_name; 
 
  
  static public JPanel notes_panel = new javax.swing.JPanel(new BorderLayout()){
    protected void paintComponent(Graphics g)
    {
        g.setColor( getBackground() );
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
};
  
  static public JButton button = new JButton("back");
  static public JButton button_homie = new JButton("back");
  static public JButton button_notes_homie = new JButton("back");
  
  static public JTextField notes01_B_A_T = new JTextField();
  static public JTextArea notes01_B_B_T = new JTextArea(5,20);
  //i put -1 so that the system know sinario x and y
  static public int notes01_B_A_ID = -1;
  static public int notes01_B_A_T_initialization_id;
  
  //then i started to realized that, all the necessary function that is happening
  //within the code should just be seperated from the gui side
  //error connection_family04

  static public boolean g_connection;
 
  
  //connection the coordinated of the person lives.
  //coordinated if none is connected
  static public String i_coordinate = "";
  public static boolean h_indicator = false;  
  public static c_connection_map c_connect = new c_connection_map();
 
  //file system coordination
    public static String getFilePath = new File("").getAbsolutePath();
    
  public initialization(){
      pane_container();
      container();      
  }
  
  
  public static void pane_container() {
         //initialization.pane_container.setLayout(new GridLayout(0,2,20,10));
        pane_container.setLayout(new GridLayout(0,1,20,10));
        pane_container.setPreferredSize(new Dimension(familypanelWidth,midfamilypanelHeight));
        //jLayeredPane1.setSize(new Dimension(jLayeredPane2.getWidth(),jLayeredPane2.getHeight()));
        // jLayeredPane1.setSize(jLayeredPane2.getWidth(),jLayeredPane2.getHeight());
        pane_container.setBounds(0, 0, familypanelWidth, midfamilypanelHeight);
        pane_container.setBackground(new Color(0,0,0,1));
        container.setOpaque(false); // background of parent will be painted first
       // container.setBackground(new Color(0,0,0,1));
        scrollPanel.setPreferredSize(new Dimension(pane_container.getWidth(),pane_container.getHeight()));
        scrollPanel.setBounds(0, 0, pane_container.getWidth(), pane_container.getHeight());
        scrollPanel.getViewport().setBackground(new Color(0,0,0,1));
        scrollPanel.setVisible(true);     
  }
  
  public static void pane_container_dpt() {
         //initialization.pane_container.setLayout(new GridLayout(0,2,20,10));
        pane_container.setLayout(new GridLayout(0,1,20,10));
        pane_container.setPreferredSize(new Dimension(familypanelWidth+250,midfamilypanelHeight));
        //jLayeredPane1.setSize(new Dimension(jLayeredPane2.getWidth(),jLayeredPane2.getHeight()));
        // jLayeredPane1.setSize(jLayeredPane2.getWidth(),jLayeredPane2.getHeight());
        pane_container.setBounds(0, 0, familypanelWidth+250, midfamilypanelHeight);
        pane_container.setBackground(new Color(0,0,0,1));
        container.setOpaque(false); // background of parent will be painted first
       // container.setBackground(new Color(0,0,0,1));
        scrollPanel.setPreferredSize(new Dimension(pane_container.getWidth(),pane_container.getHeight()));
        scrollPanel.setBounds(0, 0, pane_container.getWidth(), pane_container.getHeight());
        scrollPanel.getViewport().setBackground(new Color(0,0,0,1));
        scrollPanel.setVisible(true);     

  }
  
 public static void container() {
       //container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS)); 
        container.setPreferredSize(new Dimension(Containerpanelwidth,PanelHeight));
        //jLayeredPane1.setSize(new Dimension(jLayeredPane2.getWidth(),jLayeredPane2.getHeight()));
        // jLayeredPane1.setSize(jLayeredPane2.getWidth(),jLayeredPane2.getHeight());
        container.setBounds(initialization.PanelBounds-5, 0, Containerpanelwidth, PanelHeight);
        container.setOpaque(false); // background of parent will be painted first
        container.setBackground(new Color(0,0,0,50));
  }
 
 public static void e_container() {
       e_container.setLayout(new BoxLayout(e_container, BoxLayout.PAGE_AXIS)); 
        e_container.setPreferredSize(new Dimension(e_containerWidth,e_containerHeight));
        //jLayeredPane1.setSize(new Dimension(jLayeredPane2.getWidth(),jLayeredPane2.getHeight()));
        // jLayeredPane1.setSize(jLayeredPane2.getWidth(),jLayeredPane2.getHeight());
        e_container.setBounds(e_PanelBounds+12, 0, e_containerWidth, e_containerHeight);
        Border blackline = BorderFactory.createEmptyBorder(30,0, 0, 0);
        e_container.setBorder(blackline);
        e_container.setOpaque(false); // background of parent will be painted first
        e_container.setBackground(new Color(0,0,0,1));
  
 
 } 
 
  public static void e_container_1() {
       e_container.setLayout(new BoxLayout(e_container, BoxLayout.PAGE_AXIS)); 
        e_container.setPreferredSize(new Dimension(e_containerWidth-25,e_containerHeight-5));
        //jLayeredPane1.setSize(new Dimension(jLayeredPane2.getWidth(),jLayeredPane2.getHeight()));
        // jLayeredPane1.setSize(jLayeredPane2.getWidth(),jLayeredPane2.getHeight());
        e_container.setBounds(e_PanelBounds+75, 0, e_containerWidth-25, e_containerHeight-5);
        Border blackline = BorderFactory.createEmptyBorder(30,0, 0, 0);
        e_container.setBorder(blackline);
        e_container.setOpaque(false); // background of parent will be painted first
        e_container.setBackground(new Color(0,0,0,1));
  
 
 } 
 
 public static JPanel initialized_notes_panel() {
        initialization.notes_panel.setPreferredSize(new Dimension(notes_panel_width,notes_panel_height+400));
        initialization.notes_panel.setBounds(100,0,notes_panel_width,notes_panel_height);
        initialization.notes_panel.setOpaque(false);
        initialization.notes_panel.setBackground( new Color(0, 0, 0,1) );
     
        return    initialization.notes_panel;
   }

 public static void initilialized_action_button() {
 
     //11/3/2021 it is important to seperate this from the main family class, as if i did put it within it would
     //induced a recursive
     
     
          initialization.button.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
            cleareverything();
                            f_family02 family = new f_family02();
                            
                            initialization.pane_container.add(family.return_scroll_pane());
                            initialization.pane_container.setBounds(0, 0, initialization.familypanelWidth, initialization.familypanelHeight);
                            initialization.pane_container.repaint();
                            initialization.pane_container.revalidate();
                            
                            s_sidebar2A sidebar = new s_sidebar2A(initialization.screenWidth/8,initialization.screenHeight/3,initialization.PanelMapWidth,initialization.PanelMapHeight); 
                            initialization.container.add(sidebar.return_container());
                            initialization.container.repaint();
                            initialization.container.revalidate();
                            //initialization.lists_panel.add(sidebar.return_container());
                            
                            initialization.notes_panel.remove(initialization.button);  
                            initialization.button_homie.setBounds(initialization.notes_panel.getWidth()-50, 0, 100, 50);
                            initialization.button_homie.setPreferredSize(new Dimension(100, 50));
                            initialization.button_homie.setBackground( new Color(0, 0, 51, 10) );
                            initialization.button_homie.setForeground(Color.white);
                            initialization.notes_panel.add(initialization.button_homie,BorderLayout.PAGE_END);
                            
   }});
          initialization.button_homie.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
            cleareverything();
                
            s_sidebar1A side = new s_sidebar1A();
            initialization.container();
            initialization.container.add(side.return_container());
            initialization.container.repaint();
            initialization.container.revalidate();
          
            if("FALSE".equals(indicator)) {
        
                f_family01_dpt family = new f_family01_dpt(); 
                initialization.pane_container_dpt();    
                initialization.pane_container.add(family.return_scrollPanel(),3);
                initialization.pane_container.repaint();
                initialization.pane_container.revalidate(); 
            }else{
            f_family01 family = new f_family01(); 
            initialization.pane_container.add(family.return_scrollPanel());
            initialization.pane_container.repaint();
            initialization.pane_container.revalidate();
                
            }
   }});
          
        initialization.f_family_04_add_b.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){  
                 if(!t_a.getText().isEmpty() && !t_b.getText().isEmpty() && !t_c.getText().isEmpty() && !t_d.getText().isEmpty() && !t_e.getText().isEmpty() && !t_f.getText().isEmpty() && !t_g.getText().isEmpty() && !t_h.getText().isEmpty()){
                       add_info();
                    }else{
      JOptionPane.showMessageDialog(null, "Cannot have empty space", "Warning", JOptionPane.WARNING_MESSAGE);                          
                    }
       
   } 
        });
          
   } 
 
  public static void cleareverything(){
     initialization.pane_container.removeAll();
     initialization.container.removeAll();
     initialization.check_number = 0;
     initialization.e_container.removeAll();
     initialization.e_container.repaint();
     initialization.e_container.revalidate();
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
         
public static  void add_info() {
         c_connection_gereja f_family_04_gereja_connect = new c_connection_gereja();
                 c_connection_family f_family_04_familyconnect = new c_connection_family();
 
        //connect.connect("info_bank");
         String container = "" ;
         Stack<String> stack = new Stack<String>();
                            int i = 0;
                            //implemented 19/8/2021 for preventing race condition
       stack.add(t_a.getText().replaceAll("[^a-zA-Z0-9\\s]","__").replace(" ","_").trim());
       stack.add(t_b.getText().replaceAll("[^a-zA-Z0-9\\s\\.]","-").replace(" ","_").trim());
       stack.add(t_c.getText().replaceAll("[^a-zA-Z0-9\\s\\.]","-").replace(" ","_").trim());
       stack.add(t_d.getText().replaceAll("[^a-zA-Z0-9\\s\\.]","-").replace(" ","_").trim());
       stack.add(t_e.getText().replaceAll("[^a-zA-Z0-9\\s\\.]","-").replace(" ","_").trim());
       stack.add(t_f.getText().replaceAll("[^a-zA-Z0-9\\s\\.]","-").replace(" ","_").trim());
       stack.add(t_g.getText().replaceAll("[^a-zA-Z0-9\\s\\.]","-").replace(" ","_").trim());
       stack.add(t_h.getText().replaceAll("[^a-zA-Z0-9\\s\\.]","-").replace(" ","_").trim());
  
                          
  
                   String[] arrSplit = new String[stack.size()];
                    arrSplit = stack.toArray(arrSplit);
        String apn = convertObjectArrayToString(arrSplit,"|");  
        
        
    if(!apn.isEmpty()){
                         try{         
     //check the system...25/2/2021
     if(f_family_04_gereja_connect.checkiftableexist("anggotagereja" + initialization.gereja) == "false"){
        f_family_04_gereja_connect.createDatabaseTable();
        //System.out.println(convertObjectArrayToString(arrSplit,"_"));
      
        
        if(f_family_04_familyconnect.checkiftableexist("family" + initialization.gereja) == "false"){
            f_family_04_familyconnect.createDatabaseTable();
        f_family_04_familyconnect.insertfamilytable(initialization.first_name,arrSplit[0].toLowerCase(),"anak");
        f_family_04_gereja_connect.insertpeopleData(apn,arrSplit[0].toLowerCase(),"anak");                   
      
        }else{
        f_family_04_familyconnect.insertfamilytable(initialization.first_name,arrSplit[0].toLowerCase(),"anak"); 
          f_family_04_gereja_connect.insertpeopleData(apn,arrSplit[0].toLowerCase(),"anak");                   
        }
     
     }else{
        if(f_family_04_familyconnect.checkiftableexist("family" + initialization.gereja) == "false"){
        f_family_04_familyconnect.createDatabaseTable();
        f_family_04_familyconnect.insertfamilytable(initialization.first_name,arrSplit[0].toLowerCase(),"anak");
          f_family_04_gereja_connect.insertpeopleData(apn,arrSplit[0].toLowerCase(),"anak");                   
        }else{
        f_family_04_familyconnect.insertfamilytable(initialization.first_name,arrSplit[0].toLowerCase(),"anak"); 
          f_family_04_gereja_connect.insertpeopleData(apn,arrSplit[0].toLowerCase(),"anak");                   
        }
     }
     
     f_family_initialization stack_1 = new f_family_initialization();
     stack_1.r_returnstack().add(arrSplit[0].toLowerCase());
     J_poepleImageSaved save = new J_poepleImageSaved(arrSplit[0].toLowerCase());
                                
                         }catch (SQLException ex) {
         System.out.println("Something is wrong with the button add up" + ex.getMessage());
        }
                         
                  
   initialization.lists.clear();
   initialization_textfield init = new initialization_textfield();
   init.f_empty_function();
   //alright already add pic+++ 24/2/2021
add_pic();   
}
}
  

  private static String convertObjectArrayToString(Object[] arr, String delimiter) {
		StringBuilder sb = new StringBuilder();
		for (Object obj : arr)
			sb.append(obj.toString()).append(delimiter);
		return sb.substring(0, sb.length() - 1);
	}
}
