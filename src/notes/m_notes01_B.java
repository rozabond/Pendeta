/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notes;

import connection.c_connection_notes;
import css.scrollbar;
import initialization.initialization;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import login.F_Login_mediator;

/**
 *
 * @author DELL
 */
public class m_notes01_B {
      public JPanel notes01_B = new JPanel(new BorderLayout()){
    protected void paintComponent(Graphics g)
    {
        g.setColor( getBackground() );
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
};
    
    public JPanel notes01_B_A_P = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 20)){
    protected void paintComponent(Graphics g)
    {
        g.setColor( getBackground() );
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
};
    
    public JPanel notes01_B_A_J_P = new JPanel(){
    protected void paintComponent(Graphics g)
    {
        g.setColor( getBackground() );
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
};
    public JLabel notes01_B_A_J = new JLabel("Tarikh");
    public JPanel notes01_B_A_T_P = new JPanel(){
    protected void paintComponent(Graphics g)
    {
        g.setColor( getBackground() );
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
};
    public JPanel notes01_B_A_T_B_P = new JPanel(){
        protected void paintComponent(Graphics g)
    {
        g.setColor( getBackground() );
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }   
    };
    
    public JButton notes01_B_A_T_B=  new JButton("baharu");
    
    
    //public JTextField notes01_B_A_T = new JTextField();
    
    public JPanel notes01_B_B_P = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 20)){
    protected void paintComponent(Graphics g)
    {
        g.setColor( getBackground() );
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
};
    public JPanel notes01_B_B_T_P = new JPanel(){
    protected void paintComponent(Graphics g)
    {
        g.setColor( getBackground() );
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
};
    public JLabel notes01_B_B_J = new JLabel("Catatan");
    //public JTextArea notes01_B_B_T = new JTextArea(5,20);
    
    
    
    
    public JPanel notes01_B_C_P = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 20)){
    protected void paintComponent(Graphics g)
    {
        g.setColor( getBackground() );
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
};;
    public JButton notes01_B_C_B_A = new JButton("Delete");
    public JButton notes01_B_C_B_B = new JButton("Tambah");
    
    
    JButton jp = new JButton();  
    
    public m_notes01_B() {
        initialized_notes01_B(initialization.e_containerWidth,initialization.e_containerHeight/2+200);
        initialized_notes01_B_A_P();
        initialized_notes01_B_B_P();
        initialized_notes01_B_C_P();
        i_initializing();
        notes01_B();
        button();
    }
    
    private void initialized_notes01_B_A_P(){
        notes01_B_A_P.setLayout(new BorderLayout());
        notes01_B_A_P.setPreferredSize(new Dimension(initialization.e_containerWidth-100,80));
        notes01_B_A_P.setBounds(0,0,initialization.e_containerWidth,30);
        notes01_B_A_P.setOpaque(true);
        //notes01_B_A_P.setBackground( new Color(0, 0, 0,1) ); 
        
        notes01_B_A_J_P.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 20));
        notes01_B_A_J_P.setPreferredSize(new Dimension(initialization.e_containerWidth,50));
        notes01_B_A_J_P.setBounds(0,0,initialization.e_containerWidth,50);
        //notes01_B_A_J_P.setBackground( new Color(0, 0, 0,1) ); 
        notes01_B_A_J.setForeground(Color.white);
        notes01_B_A_J_P.add(notes01_B_A_J);
     
        
        notes01_B_A_T_P.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        notes01_B_A_T_P.setPreferredSize(new Dimension(initialization.e_containerWidth,10));
        notes01_B_A_T_P.setBounds(0,0,initialization.e_containerWidth,10);
        initialization.notes01_B_A_T.setPreferredSize(new Dimension(200,30)); 
        //notes01_B_A_T_P.setBackground( new Color(0, 0, 0,1) ); 
        notes01_B_A_T_P.add(initialization.notes01_B_A_T);
        notes01_B_A_T_B_P.setLayout(new FlowLayout(FlowLayout.RIGHT,0,0));
        notes01_B_A_T_B_P.setPreferredSize(new Dimension(initialization.e_containerWidth/3,30));
        notes01_B_A_T_B_P.setBounds(0,0,initialization.e_containerWidth/3,30);
     //   notes01_B_A_T_B_P.setBackground( new Color(0, 0, 0,1) ); 
        notes01_B_A_T_B_P.add(notes01_B_A_T_B);
        notes01_B_A_T_P.add(notes01_B_A_T_B_P);
        
        notes01_B_A_P.add(notes01_B_A_J_P,BorderLayout.PAGE_START);
        notes01_B_A_P.add(notes01_B_A_T_P,BorderLayout.CENTER);
    }
    
   
    
    
    private void initialized_notes01_B_B_P(){
        notes01_B_B_P.setLayout(new BorderLayout());
        notes01_B_B_P.setPreferredSize(new Dimension(initialization.e_containerWidth,50));
        notes01_B_B_P.setBounds(0,0,initialization.e_containerWidth-200,50);
        notes01_B_B_P.setOpaque(true);
        notes01_B_B_P.setBackground( new Color(0, 0, 0,1) ); 
      
        notes01_B_B_T_P.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 10));
        notes01_B_B_T_P.setPreferredSize(new Dimension(initialization.e_containerWidth,40));
        notes01_B_B_T_P.setBounds(0,0,initialization.e_containerWidth,40);
        notes01_B_B_T_P.setBackground( new Color(0, 0, 0,1) ); 
        notes01_B_B_J.setForeground(Color.white);
        notes01_B_B_T_P.add(notes01_B_B_J);
        
        scrollbar scroll = new scrollbar (initialization.notes01_B_B_T,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        notes01_B_B_P.add(notes01_B_B_T_P,BorderLayout.PAGE_START);
        notes01_B_B_P.add(scroll,BorderLayout.CENTER);  
    }

    private void initialized_notes01_B_C_P(){
        notes01_B_C_P.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 10));
        notes01_B_C_P.setPreferredSize(new Dimension(initialization.e_containerWidth,50));
        notes01_B_C_P.setBounds(0,0,initialization.e_containerWidth,50);
        notes01_B_C_P.setOpaque(true);
        notes01_B_C_P.setBackground( new Color(255, 255, 255,50) ); 
        
        notes01_B_C_P.add(notes01_B_C_B_A);
        notes01_B_C_P.add(notes01_B_C_B_B); 
        
    }
    
    public JPanel return_notes01_B(){
        return notes01_B;
    }
    
    private void notes01_B(){
        notes01_B.add(notes01_B_A_P,BorderLayout.PAGE_START);
        notes01_B.add(notes01_B_B_P,BorderLayout.CENTER);
        notes01_B.add(notes01_B_C_P,BorderLayout.PAGE_END);
    }
     
    private JPanel initialized_notes01_B(int width, int height) {
        notes01_B.setPreferredSize(new Dimension(width,height));
        notes01_B.setBounds(0,0,width,height);
        notes01_B.setOpaque(true);
        notes01_B.setBackground( new Color(0, 0, 0,1) ); 
        return notes01_B;
   }
    
    private void cleareverything(){
     initialization.e_container.removeAll();
        initialization.e_container();
     initialization.e_container.repaint();
     initialization.e_container.revalidate();
}  
    
    private void add_notes(){
initialization.e_container.setLayout(new BorderLayout());
Border blackline = BorderFactory.createEmptyBorder(30,0, 0, 0);



    m_notes01_A a = new m_notes01_A();
    m_notes01_B b = new m_notes01_B();

initialization.e_container.setBorder(blackline);
initialization.e_container.add(a.return_notes01_A(),BorderLayout.PAGE_START);
initialization.e_container.add(b.return_notes01_B(),BorderLayout.CENTER);
initialization.e_container.repaint();
initialization.e_container.revalidate();    
    
}
    
    private void button(){
        notes01_B_C_B_B.addActionListener(new ActionListener(){  
                        public void actionPerformed(ActionEvent e){ 
                        //tambah    
                        Date date = new Date(); //
                        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                        System.out.println(formatter.format(date));
                        
                        
                        f_tambah_notes();
                        cleareverything();
                        initialization.notes01_B_A_T.setText("");
                        initialization.notes01_B_B_T.setText("");
                        add_notes();
                        //make things initialize back to its original form again
                        i_initializing();
                      
                      
                       // notes.insertDatabaseData(formatter.format(date), initialization.notes01_B_B_T.getText());
                            
                        }});
        
        notes01_B_C_B_A.addActionListener(new ActionListener(){  
                        public void actionPerformed(ActionEvent e){ 
                        //delete    
                        f_delete_notes();
                        cleareverything();
                        initialization.notes01_B_A_T.setText("");
                        initialization.notes01_B_B_T.setText("");
                        add_notes();
                        }});

        notes01_B_A_T_B.addActionListener(new ActionListener(){  
                        public void actionPerformed(ActionEvent e){ 
                        //tambah tarikh
                        Date date = new Date(); //
                        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                        System.out.println(formatter.format(date));
                        initialization.notes01_B_A_T.setText(formatter.format(date));
                           F_Login_mediator Login = new F_Login_mediator();
                        initialization.notes01_B_B_T.setText("###"+Login.F_return_login()+"###");
                        //if click notes01_B_A_T_B means it is no longer for update
                        initialization.notes01_B_A_ID = -1;
                        }});
    }
    
    
    private void f_tambah_notes() {
          c_connection_notes notes = new c_connection_notes();
            try{         
     //check the system...25/2/2021
    
     if(notes.checkiftableexist("notaanggotagereja" + initialization.first_name) == "false"){
        notes.createDatabaseTable();
        if(initialization.notes01_B_A_ID >= initialization.notes01_B_A_T_initialization_id || (initialization.notes01_B_A_ID == -1 )){
        notes.insertDatabaseData(initialization.notes01_B_A_T.getText(),  initialization.notes01_B_B_T.getText());
        }else{
        notes.g_updatedatabasedata(initialization.notes01_B_A_T.getText(),  initialization.notes01_B_B_T.getText());  
        }
        
     }else{
        if(initialization.notes01_B_A_ID >= initialization.notes01_B_A_T_initialization_id || (initialization.notes01_B_A_ID == -1 )){
        notes.insertDatabaseData(initialization.notes01_B_A_T.getText(),  initialization.notes01_B_B_T.getText());
        }else{
        notes.g_updatedatabasedata(initialization.notes01_B_A_T.getText(),  initialization.notes01_B_B_T.getText());  
        }}
            }catch (SQLException ex) {
        System.out.println("Something is wrong with the notes add up" + ex.getMessage());}
       
    }
    
    private void f_delete_notes(){
         c_connection_notes notes = new c_connection_notes();
         //check the system...25/2/2021
         
         notes.DeleteDatabaseTable(initialization.notes01_B_A_ID);
    }
    
    private void i_initializing(){
        initialization.notes01_B_A_ID = -1;
    }
    
}
