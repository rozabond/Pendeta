/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gereja;

import css.scrollbar;
import initialization.initialization;
import static initialization.initialization.container;
import static initialization.initialization.familypanelWidth;
import static initialization.initialization.midfamilypanelHeight;
import static initialization.initialization.pane_container;
import static initialization.initialization.scrollPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ScrollPaneConstants;

/**
 *
 * @author DELL
 */
public class f_create_church {
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
    public JLabel notes01_B_A_J = new JLabel("gereja");
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
    public JLabel notes01_B_B_J = new JLabel("Desciption");
    //public JTextArea notes01_B_B_T = new JTextArea(5,20);
    
    
    
    
    public JPanel notes01_B_C_P = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 20)){
    protected void paintComponent(Graphics g)
    {
        g.setColor( getBackground() );
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
};;
  
    public JButton notes01_B_C_B_B = new JButton("Tambah");
    
    f_save_church f_save_church = new f_save_church();
    f_create_guirapaint button = new f_create_guirapaint();
 
    
    JButton jp = new JButton();  
    
    public f_create_church() {
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
    
        notes01_B_A_J_P.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 20));
        notes01_B_A_J_P.setPreferredSize(new Dimension(initialization.e_containerWidth,50));
        notes01_B_A_J_P.setBounds(0,0,initialization.e_containerWidth,50);
        notes01_B_A_J.setForeground(Color.white);
        notes01_B_A_J_P.add(notes01_B_A_J);
     
        
        notes01_B_A_T_P.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        notes01_B_A_T_P.setPreferredSize(new Dimension(initialization.e_containerWidth,10));
        notes01_B_A_T_P.setBounds(0,0,initialization.e_containerWidth,10);
        initialization.notes01_B_A_T.setPreferredSize(new Dimension(200,30)); 
        notes01_B_A_T_P.add(initialization.notes01_B_A_T);
        notes01_B_A_T_B_P.setLayout(new FlowLayout(FlowLayout.RIGHT,0,0));
        notes01_B_A_T_B_P.setPreferredSize(new Dimension(initialization.e_containerWidth/3,30));
        notes01_B_A_T_B_P.setBounds(0,0,initialization.e_containerWidth/3,30);
         notes01_B_A_T_P.add(notes01_B_A_T_B_P);
        
        notes01_B_A_P.add(notes01_B_A_J_P,BorderLayout.PAGE_START);
        notes01_B_A_P.add(notes01_B_A_T_P,BorderLayout.CENTER);
    }
    
   
    
    
    private void initialized_notes01_B_B_P(){
        notes01_B_B_P.setLayout(new BorderLayout());
        notes01_B_B_P.setPreferredSize(new Dimension(initialization.e_containerWidth,50));
        notes01_B_B_P.setBounds(0,0,initialization.e_containerWidth-200,50);
    
        notes01_B_B_T_P.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 10));
        notes01_B_B_T_P.setPreferredSize(new Dimension(initialization.e_containerWidth,40));
        notes01_B_B_T_P.setBounds(0,0,initialization.e_containerWidth,40);
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
        notes01_B_C_P.setBackground( new Color(100, 101, 107) ); 
        
       // notes01_B_C_P.add(notes01_B_C_B_A);
        notes01_B_C_P.add(notes01_B_C_B_B); 
        
    }
    
    public JPanel return_notes01_B(){
        JPanel container = new JPanel(){
    protected void paintComponent(Graphics g)
    {
        g.setColor( getBackground() );
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
};
        //Purpose - Make the Container center
        JPanel container1 = new JPanel(){
    protected void paintComponent(Graphics g)
    {
        g.setColor( getBackground() );
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
};
          JPanel container2 = new JPanel(){
    protected void paintComponent(Graphics g)
    {
        g.setColor( getBackground() );
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
};
        container.setLayout(new BorderLayout());
        container.setPreferredSize(new Dimension(initialization.e_containerWidth,initialization.e_containerHeight));
        container.setBounds(0, 0, initialization.e_containerWidth+50, initialization.e_containerHeight);
        container.setBackground(new Color(0,0,0,1));
        container1.setPreferredSize(new Dimension(initialization.e_containerWidth,100));
        container1.setVisible(true);
        container1.setBackground(new Color(0,0,0,1));
        container2.setPreferredSize(new Dimension(initialization.e_containerWidth,100));
        container2.setVisible(true);
        container2.setBackground(new Color(0,0,0,1));
        container.add(container1,BorderLayout.PAGE_START);
        container.add(notes01_B,BorderLayout.CENTER);
        container.add(container2,BorderLayout.PAGE_END);
       //  SpringLayout layout = new SpringLayout();
       // container.setLayout( layout);         
       // layout.putConstraint(SpringLayout.VERTICAL_CENTER, container, -5, SpringLayout.VERTICAL_CENTER, notes01_B);  
        //layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, container, 0, SpringLayout.HORIZONTAL_CENTER, notes01_B); 
    //layout.putConstraint(SpringLayout.SOUTH, container,20,SpringLayout.SOUTH, notes01_B);
                       
                                       
        return container;
    }
    
    private void notes01_B(){
        notes01_B.add(notes01_B_A_P,BorderLayout.PAGE_START);
        notes01_B.add(notes01_B_B_P,BorderLayout.CENTER);
        notes01_B.add(notes01_B_C_P,BorderLayout.PAGE_END);
    }
     
    private JPanel initialized_notes01_B(int width, int height) {
        notes01_B.setPreferredSize(new Dimension(width,height-250));
        notes01_B.setBounds(0,200,width,height-250);
         return notes01_B;
   }
    
    private void cleareverything(){
     initialization.e_container.removeAll();
        initialization.e_container();
     initialization.e_container.repaint();
     initialization.e_container.revalidate();
}  
    

    
    private void button(){
        notes01_B_C_B_B.addActionListener(new ActionListener(){  
                        public void actionPerformed(ActionEvent e){ 
                      if(!initialization.notes01_B_A_T.getText().isEmpty() && !initialization.notes01_B_B_T.getText().isEmpty()){
                       f_save_church.g_save_name();
                       Pendeta_origin.i_clearthings();
                    
                       button.g_repaint();
                      }else{
        JOptionPane.showMessageDialog(null, "Church or Description cannot be empty", "Warning", JOptionPane.WARNING_MESSAGE);                          
        
                      }
                        }
        
        });
    }
    
    

    
    private void i_initializing(){
        initialization.notes01_B_A_ID = -1;
    }
    
    
    public void i_initializing_pane_container(){
        int panel_width = familypanelWidth + 300;
        pane_container.setPreferredSize(new Dimension(panel_width,midfamilypanelHeight));
        pane_container.setLayout(new GridLayout(0,2,20,10));
        pane_container.setBounds(0, 0, panel_width, midfamilypanelHeight);
        pane_container.setBackground(null);
        
        container.setOpaque(false); 
        scrollPanel.setPreferredSize(new Dimension(pane_container.getWidth(),pane_container.getHeight()));
        scrollPanel.setBounds(0, 0,pane_container.getWidth(), pane_container.getHeight());
        scrollPanel.getViewport().setBackground(new Color(0,0,0,1));
        scrollPanel.setVisible(false);    
        scrollPanel.repaint();
        scrollPanel.revalidate();
  
    }
    
}
