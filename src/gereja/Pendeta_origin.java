package gereja;

import b_file_function.b_file_encryption_cannidate;
import c_connection.g_testconnection;
import c_connection.g_webserver;
import connection.c_connection_church;
import css.*;
import delete.F_delete;
import f_family.f_family01;
import f_family.f_family01_dpt;
import google_map.Chrome;
import initialization.initialization;
import static initialization.initialization.indicator;
import initialization.initialization_f_family03_info_button;
import initialization.initialization_f_searchbar_button;
import initialization.initialization_genesis;
import initialization.initialization_s_sidebar1A_addbutton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.Transparency;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.*;  
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileSystemView;
import login.F_Encrype_main;
import s_sidebar2.s_sidebar1A;
import s_sidebar2.s_sidebar2A;
import s_sidebar2.s_sidebarAA;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class Pendeta_origin extends javax.swing.JFrame  {
 //JPanel jp = new JPanel();   
 //new  GridLayout(0,3,50,10)
 static public JLayeredPane pane = new JLayeredPane();
 public static String Orang;
 public static JPanel jp_people = new JPanel(new GridLayout(0,2,20,10));   
 static JPanel side_people = new JPanel(new GridLayout(2,1));       
 static JPanel  side_people_2 = new JPanel(new GridLayout(0,2,20,10));   
 JPanel notes = new JPanel(new GridLayout(0,2,20,10));        
 JPanel notas = new JPanel();
 JPanel jp_B_P = new JPanel();
 
 //final int image_panel_width = initialization.PanelMapWidth-initialization.familypanelWidth;
 //final int image_panel_height = initialization.PanelMapHeight;
 
  final int image_panel_width = 500;
 final int image_panel_height = 500;
 
 
 final static  scrollbar scrollPane3 = new scrollbar(
        side_people_2,
        ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
 
 final static scrollbar scrollPane2 = new scrollbar(
        side_people,
        ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );

 final static  scrollbar scrollPanel = new scrollbar(
        jp_people,
        ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
 
  final scrollbar scrollPane_notes = new scrollbar(
        notes,
        ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED );
  
 static int Gereja_height = 200;
 static int Gereja_width = 200;
 public static String Gereja_nama = "";
 
 c_connection_church church = new c_connection_church();
 
 JButton b = (new JButton("Menu"));
  BufferedImage image = null;        
      
    /**
     * Creates new form gereja
     */
    public Pendeta_origin() throws Exception {
     initComponents();
        container_pastor_tools.setVisible(false);
        pane.setPreferredSize(new Dimension(jLayeredPane2.getWidth(),jLayeredPane2.getHeight()));
        //jLayeredPane1.setSize(new Dimension(jLayeredPane2.getWidth(),jLayeredPane2.getHeight()));
        // jLayeredPane1.setSize(jLayeredPane2.getWidth(),jLayeredPane2.getHeight());
        pane.setBounds(0, 0, jLayeredPane2.getWidth(), jLayeredPane2.getHeight());

        jPanel2.add(i_initialization_jp_A(),BorderLayout.PAGE_START);
        jPanel2.add(i_initialization_jp_B(),BorderLayout.CENTER);
   
        G_testConnection();
        g_webserver.t_swing_worker();
        
        i_initialize();
        d_display_map(); 
        d_displaybutton();        
        d_displaygereja(); 

   
display_lukis_logo(); 
   
         i_once_initialization();
        // i_clearthings();
       // display_lukis_logo();     
    }
    
      private void G_testConnection(){
        g_testconnection g_testing = new g_testconnection();
       
        initialization.g_connection =  g_testing.checkInternetConnection();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        
        jFrame1 = new javax.swing.JFrame("Pendeta");  
        jFrame1 = initialization.jFrame1;
        
        this.addWindowListener(new java.awt.event.WindowAdapter() {
    @Override
    public void windowClosing(java.awt.event.WindowEvent e) {
       F_Encrype_main encrpt    = new F_Encrype_main();
                            encrpt.F_illiterating_encrypt();                   
                        cleareverything();
                      //   System.exit(0);
        System.out.println("JFrame Closed!");
                      e.getWindow().dispose();
     
    }
});
                this.setTitle("Pendeta 1.0");
            
        this.setResizable(false);
    /*    jPanel4 = new JPanelGradient() { protected void paintComponent(Graphics g) {
 
                   String f = new File("logo.png").getAbsolutePath();
   System.out.println(f);
     // BufferedImage images = resize(image,400);     
    try {                   
         image = ImageIO.read(new File(f));
       //           
     image = scale(image,image_panel_width,image_panel_height); 
        } catch (IOException ex) {
        System.out.println("");
       }
    
        super.paintComponent(g);
//        image.getScaledInstance(800, 800, Image.SCALE_SMOOTH);
       // image.getScaledInstance(800, 800, Image.SCALE_SMOOTH);

g.drawImage(image, 300, 100, this);
// see javadoc for more info on the parameters            
    }};*/
    jPanel4 = new JPanelGradient();
        jPanel4.setOpaque(false);
      // jPanel4.paintComponents(grphcs);
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        container_pastor_tools = new javax.swing.JPanel();
        notes_panel = new javax.swing.JPanel();
        Map_Panels = new javax.swing.JLayeredPane();
        jPanel2 = new javax.swing.JPanel();
  jLayeredPane2.setPreferredSize(new Dimension(initialization.screenWidth-575,initialization.PanelHeight));
      
  Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
this.setLocation(25, 25);
        
        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
   
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLayeredPane2.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
       // jLayeredPane2.setBackground(Color.yellow);
        jLabel1.setPreferredSize(new Dimension(850,700));
        jLabel1.setBounds(125, 50, image_panel_width, image_panel_height);
        jLayeredPane2.add(jLabel1);
        /*javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap(244, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(242, 242, 242))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap(261, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128))
        );*/
        

        container_pastor_tools.setBackground(new Color(0,0,0));
   
        javax.swing.GroupLayout container_pastor_toolsLayout = new javax.swing.GroupLayout(container_pastor_tools);
        container_pastor_tools.setLayout(container_pastor_toolsLayout);
        container_pastor_toolsLayout.setHorizontalGroup(
            container_pastor_toolsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(container_pastor_toolsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(container_pastor_toolsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(notes_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Map_Panels, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(96, 96, 96))
        );
        container_pastor_toolsLayout.setVerticalGroup(
            container_pastor_toolsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(container_pastor_toolsLayout.createSequentialGroup()
                .addComponent(notes_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Map_Panels, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

     /*   javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(81, 81, 81))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(31, 31, 31)
                .addComponent(jButton5)
                .addGap(98, 98, 98))
        );*/
       // javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(new BorderLayout());
        jPanel2.setPreferredSize(new Dimension(200,200));
        jPanel2.setBounds(0, 0, jPanel2.getWidth(), jPanel2.getHeight());
        jPanel2.setBackground(new Color(0,51,51));
        

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(container_pastor_tools, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGap(25, 25, 25)
            )
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(container_pastor_tools, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>                        

                                   

    
    public static String returnnamagereja(String a){
        
        return a;
    }
    
    
   public void d_displaybutton(){
  
                        b.setPreferredSize(new Dimension(jPanel2.getWidth()-20, 40));
                        //b.setBackground( new Color(102, 102, 153) );
                        b.setBorder(new LineBorder(new Color(5,217,229)));
                        b.setForeground(Color.white);
                        b.addActionListener(new ActionListener(){  
                        public void actionPerformed(ActionEvent e){  
                        
                            
                         initialization_genesis.delete_button.setVisible(false);
                            cleareverything();
                         
                              jLayeredPane2.add(jLabel1);
                           initialization.pane_container();
                           initialization.pane_container.repaint();
                           initialization.pane_container.revalidate();
                           s_sidebarAA side = new s_sidebarAA(); 
                           initialization.container();
                           initialization.container.add(side.return_container());
                           initialization.container.repaint();
                           initialization.container.revalidate();
                          jLayeredPane2.repaint();
                          jLayeredPane2.revalidate();

                            F_Encrype_main Encrype = new F_Encrype_main();
                            Encrype.F_illiterating_encrypt();
                            //  scrollPane2.setVisible(false);
                           //scrollPane3.setVisible(false);
                         
                      
                    
                        }
                        });
                        
                         initialization_genesis.jp.add(b);
                         initialization_genesis.jp.revalidate();
                         initialization_genesis.jp.repaint();
                        
   }
    
   public void d_displaygereja(){
    int number = 0;
    Stack<String> stack = new Stack<String>();
    Stack<String> stack_id = new Stack<String>();
       stack = church.f_church_resultset();
  Iterator<String> itr = stack.iterator();
     
  if(stack.size() > 18){
     initialization_genesis.jp.setPreferredSize(new Dimension(0,initialization.familypanelHeight+stack.size()*36));
  //    initialization_genesis.jp.setLayout(new GridLayout(0,1,0,0));
  }
  
                       while (itr.hasNext()){
                    
                        String[] container =  itr.next().split("_");
                        String intern = (String) container[0];
                        String intern_dpt_boolean = (String) container[1];
                        
                        JButton b = (new JButton(intern.trim().replace("_"," ")));
                        b.setName(intern);
                        b.setHorizontalAlignment(SwingConstants.LEFT);
                       // b.setHorizontalAlignment(SwingConstants.LEFT);
                        b.setPreferredSize(new Dimension(jPanel2.getWidth()-20, 40));
                        b.setBackground( new Color(0, 0, 51, 10) );
                        b.setForeground(Color.white);
                        b.addActionListener(new ActionListener(){  
                        public void actionPerformed(ActionEvent e){  
                           indicator = intern_dpt_boolean;
                           initialization_genesis.delete_button.setVisible(true);
                           cleareverything();
                           JButton o = (JButton)e.getSource();
                       
                           
                           Gereja_nama = o.getName().replaceAll(" ", "_");
                         
                           returnnamagereja(o.getName());
                           initialization.gereja =Gereja_nama;
                           
                          F_Decryt_name();
                            //it work!!
                           s_sidebar1A side = new s_sidebar1A(); 
                           initialization.container();
                           initialization.container.add(side.return_container());
                           initialization.container.repaint();
                           initialization.container.revalidate();
                         
                           
                           //a logic to determine between a department and non department
                           if("FALSE".equals(indicator)) {
                          f_family01_dpt family = new f_family01_dpt(); 
                           initialization.pane_container_dpt();
                           initialization.pane_container.add(family.return_scrollPanel(),3);
                           initialization.pane_container.repaint();
                           initialization.pane_container.revalidate(); 
                           }else{
                            
                           f_family01 family = new f_family01(); 
                           initialization.pane_container();
                           initialization.pane_container.add(family.return_scrollPanel(),3);
                           initialization.pane_container.repaint();
                           initialization.pane_container.revalidate();
                           
                           
                           }
                          //daman...finally i get the result, this things get rosak before it even display the result
                          // display_orang orang = new display_orang();
                          // orang.setVisible(true);   
                          
                        }  
                        });  
                     
                         initialization_genesis.jp.add(b);
                         initialization_genesis.jp.revalidate();
                         initialization_genesis.jp.repaint();
                       }
                       
                       
       
    }
   
   private void F_Decryt_name(){
    b_file_encryption_cannidate name = new b_file_encryption_cannidate();
    
    if(!name.R_stack().contains(initialization.gereja)){
       F_Encrype_main decryp = new F_Encrype_main();
        decryp.F_illiterating_decrypt();
    };
}
   
private void cleareverything(){
     
    initialization.pane_container.removeAll();
    initialization.container.removeAll();
    initialization.e_container.removeAll();
    initialization.notes01_B_A_T.setText("");
    initialization.notes01_B_B_T.setText("");
    initialization.e_container.repaint();
    initialization.e_container.revalidate();
    //jPanel4.setOpaque(false);
    //jPanel4.remove(0);
    initialization_genesis.input = null;
    jLayeredPane2.remove(jLabel1);
    jLayeredPane2.repaint();
    jLayeredPane2.revalidate();
    jp_B_P.repaint();
    jp_B_P.revalidate();
    initialization.pane_container.repaint();
    initialization.pane_container.revalidate();
}
    


private void d_display_map(){
     Chrome web = new Chrome();
    }



  
private void i_once_initialization(){
                    //important initialization
                           initialization.initialized_notes_panel();
                           initialization.initilialized_action_button();
                           initialization_f_searchbar_button.initilialized_action_button();
                           initialization_s_sidebar1A_addbutton ini = new initialization_s_sidebar1A_addbutton();
                           // initialization_f_family03_info_button button = new initialization_f_family03_info_button();
                           initialization_f_family03_info_button button = new initialization_f_family03_info_button();
                           button.i_initialize();
   }
   
   private void display_lukis_logo(){
     
         BufferedImage image = null;     
             String f = new File("logo.png").getAbsolutePath();
   System.out.println(f);
                  
     try {
         image = ImageIO.read(new File(f));
         image = scale(image,image_panel_width,image_panel_height); 
     } catch (IOException ex) {
         Logger.getLogger(Pendeta_origin.class.getName()).log(Level.SEVERE, null, ex.getMessage());
     }

       //ImageIcon imageIcon = new ImageIcon(new ImageIcon(getClass().getResource("/images_main/gereja.png")).getImage().getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_DEFAULT));
       //ImageIcon is = new ImageIcon(image_icon.changethepixelimages(imageIcon));
        ImageIcon imageIcon = new ImageIcon(image);
               //ImageIcon is = new ImageIcon(image_icon.changethepixelimages(imageIcon));

       jLabel1.setIcon(imageIcon);
      // jPanel4.add(jLabel1);
       jLayeredPane2.setLayer(jLabel1,
                         new Integer(1),
                         0);

String f_icon = new File("icon.png").getAbsolutePath();
ImageIcon imgicon = new ImageIcon(f_icon);
this.setIconImage(imgicon.getImage());
       
 }
 
private void i_initialize(){
    
    //all importatnt initialization
    initialization_genesis.delete_button.setVisible(false);
    jLayeredPane2.add(initialization.pane_container);
    jLayeredPane2.setLayer(initialization.pane_container,4); 
    jPanel4.add(initialization.container);
    jPanel4.add(initialization.e_container);
     container_pastor_tools.removeAll();
    s_sidebarAA side = new s_sidebarAA(); 
                           initialization.container();
                           initialization.container.add(side.return_container());
                           initialization.container.repaint();
                           initialization.container.revalidate();
                           jPanel4.add(initialization.container);   
                                 //container_pastor_tools.setVisible(true);
                                  container_pastor_tools.setVisible(true);
                                  pack();
}
   
public JPanel side_button_stinger(JPanel Panel_size, Object myObject[]) {
                        
                       JPanel hai = new JPanel();
                        hai.setBounds(0,0,Panel_size.getWidth()/3,Panel_size.getHeight()/3-Panel_size.getHeight()/20);
                        hai.setBackground( new Color(255, 255, 255, 40));
                        hai.setOpaque(false);
                        hai.setSize(Panel_size.getWidth()/3, Panel_size.getHeight()/3-Panel_size.getHeight()/20);
                        
                        
                  
                        JPanel hai_second = new JPanel();
                        System.out.println("Jlayered"+Panel_size.getWidth()/4);
                        hai_second.setPreferredSize(new Dimension(hai.getWidth()/2,hai.getHeight()-hai.getHeight()/10));
                        hai_second.setBounds(0,0,hai.getWidth()/2,hai.getHeight()-hai.getHeight()/10);                   
                        hai_second.setBackground( new Color(0, 0, 0, 70));
                        hai_second.setOpaque(true);
                      
                        String intern = (String) myObject[0];
                        System.out.println("Jlayered: "+intern);
                        JLabel JLabelstring = new JLabel(intern,SwingConstants.CENTER);
                        JLabelstring.setForeground(Color.white);
                        ImageIcon imageIcon = new ImageIcon(new ImageIcon(getClass().getResource("/image/images1.jpg")).getImage().getScaledInstance(hai_second.getWidth(), hai_second.getHeight(), Image.SCALE_DEFAULT));      
                        JButton b = (new JButton(imageIcon));
                   
                        b.setPreferredSize(new Dimension(hai_second.getWidth()-5, hai_second.getHeight()-10));
                        b.setName(intern);
                        b.setRolloverEnabled(false);
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
             
                          s_sidebar2A sidebar = new s_sidebar2A(initialization.screenWidth/8,initialization.screenHeight/3,initialization.PanelMapWidth,initialization.PanelMapHeight); 
                          
                          jPanel4.remove(initialization.container);
                          initialization.container = sidebar.return_container();
                          jPanel4.add(initialization.container);
                          jPanel4.repaint();
                          jPanel4.revalidate();
                          initialization.lists_panel.add(sidebar.return_container());
                          
                           JButton o = (JButton)e.getSource();
                           Orang = o.getName();
                        
                           side_people.removeAll();
                           side_people_2.removeAll();
                           side_people.setSize(jLayeredPane2.getWidth()/2, jLayeredPane2.getHeight());
                          // side_people_2.setSize(jLayeredPane2.getWidth()/2, jLayeredPane2.getHeight());
                           scrollPane3.setBounds(new Rectangle(0, 0, jLayeredPane2.getWidth()/2-10,jLayeredPane2.getHeight() ));
                           scrollPanel.setVisible(false);
                           scrollPane2.setVisible(false);
                           scrollPane3.setVisible(true);
                           side_people.repaint();
                           side_people_2.repaint();
                           side_people_2.revalidate();
                           side_people.revalidate();
                           pane.repaint();
                           //damn it took me so much time...from 5:30 to 6:45 and from 8:30 to 9:00 am
                           pane.revalidate();
                           pack();
                           Map_Panels.remove(Chrome.jpbrowser);
                    
                          // load_Chrome();
                    
                           
                                //  displayanggota_ketuarumah();
                                // display_wife();
                                // display_keluarga.display_anak(jp_people);
                                //daman...finally i get the result, this things get rosak before it even display the result
                                
                                
                          
                        
                        }  
                        });
                        hai_second.add(b);
                       // hai.add(hai_second);
                     
                        hai.setLayout(new BorderLayout());
                       
                        JLabelstring.setPreferredSize(new Dimension(150,20));
                       // JLabelstring.setVerticalAlignment(JLabel.BOTTOM);
                          hai.add(hai_second,BorderLayout.PAGE_START);
                          hai.add(JLabelstring,BorderLayout.PAGE_END);
                          
                         
                          return hai;
                   
    }
public static BufferedImage scale(BufferedImage src, int w, int h)
{
    BufferedImage img = 
            new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
    int x, y;
    int ww = src.getWidth();
    int hh = src.getHeight();
    int[] ys = new int[h];
    for (y = 0; y < h; y++)
        ys[y] = y * hh / h;
    for (x = 0; x < w; x++) {
        int newX = x * ww / w;
        for (y = 0; y < h; y++) {
            int col = src.getRGB(newX, ys[y]);
            img.setRGB(x, y, col);
        }
    }
    return img;
}   
   
public scrollbar i_initialization_jp_A(){

        initialization_genesis.jp.setPreferredSize(new Dimension(jPanel2.getWidth(),jPanel2.getHeight()+150));
        initialization_genesis.jp.setBounds(0,0,jPanel2.getWidth(),jPanel2.getHeight()+150);
        initialization_genesis.jp.setOpaque(false);
      
        scrollbar scrollPanel = new scrollbar(
        initialization_genesis.jp,
        ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
        
        scrollPanel.setPreferredSize(new Dimension(jPanel2.getWidth(),jPanel2.getHeight()-200));
        scrollPanel.setBounds(0, 0, jPanel2.getWidth(), jPanel2.getHeight()-200);
        scrollPanel.setBackground(new Color(0,0,0));
        scrollPanel.getViewport().setBackground(new Color(0,0,0));
        scrollPanel.setVisible(true);    
        
        return scrollPanel;
}

public JPanel i_initialization_jp_B(){
             //jp.setBounds(50,80,200,200);
        //jp.setLayout(new BoxLayout(jp, BoxLayout.PAGE_AXIS));
       // jp.setLayout(new BorderLayout());
        SpringLayout layout = new SpringLayout();
        jp_B_P.setLayout( layout);
       
        jp_B_P.setPreferredSize(new Dimension(jPanel2.getWidth(),jPanel2.getHeight()+150));
        jp_B_P.setBounds(0,100,jPanel2.getWidth(),jPanel2.getHeight()+150);
        jp_B_P.setOpaque(true);
        //jp_B_P.setBackground( new Color(95,95,175));
       // jp_B_P.setBackground( new Color(84,84,167));
        
        initialization_genesis.delete_button.setPreferredSize(new Dimension(jPanel2.getWidth()-20, 40));
        //initialization_genesis.delete_button.setBackground( new Color(51,48,43));
        initialization_genesis.delete_button.setForeground(Color.WHITE);
        
        initialization_genesis.delete_button.addActionListener(new ActionListener(){  
                        
            public void actionPerformed(ActionEvent e){  
                 JFrame f;  
            f=new JFrame();    
    f.setSize(300, 300);  
    f.setLayout(null);  
    f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);  
    f.setVisible(false); 
    int a =JOptionPane.showConfirmDialog(f,"Are you sure?");  
    if(a==JOptionPane.YES_OPTION){  
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     F_delete f_delete = new F_delete(initialization.gereja);
                            initialization_genesis.jp.removeAll();
                            d_displaybutton();
                            d_displaygereja();
                            initialization_genesis.jp.repaint();
                            initialization_genesis.jp.revalidate();
                            b.doClick();
}  
                                                      
                        }});
        jp_B_P.add(initialization_genesis.delete_button);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER,  initialization_genesis.delete_button, 0, SpringLayout.HORIZONTAL_CENTER, jp_B_P);                          
        layout.putConstraint(SpringLayout.SOUTH,  initialization_genesis.delete_button,-50,SpringLayout.SOUTH, jp_B_P);
                       
        
        return jp_B_P;
}
   

   

   public static void i_clearthings(){
        pane.removeAll();
                            jp_people.removeAll();
                            container_pastor_tools.removeAll();
                            //it feels just nice to code in this such a way
                            jLayeredPane2.remove(initialization.pane_container);
                            jPanel4.remove(initialization.container);   
                            jPanel4.remove(initialization.e_container);
                            
                               jPanel4.add(initialization.container);
                           jPanel4.add(initialization.e_container);
                           
                           
                           scrollPane2.setVisible(false);
                           scrollPane3.setVisible(false);
                           container_pastor_tools.setVisible(true);
                               jLayeredPane2.add(initialization.pane_container);
                           jLayeredPane2.setLayer(initialization.pane_container,4); 
                           //this.pack();
                             scrollPanel.setVisible(true);
                            
                            
   }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
     
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
            
                
                try {
                    new Pendeta_origin().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(Pendeta_origin.class.getName()).log(Level.SEVERE, null, ex);
                }
              
                
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLayeredPane Map_Panels;

    protected static javax.swing.JPanel container_pastor_tools;
    //to be used across many place
    public static javax.swing.JLayeredPane jLayeredPane2;
    protected static javax.swing.JPanel jPanel4;

    private javax.swing.JFrame jFrame1;
    public static javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;

    private javax.swing.JPanel notes_panel;
    // End of variables declaration                   
}
