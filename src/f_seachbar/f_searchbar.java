/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f_searchbar;


import initialization.initialization;
import static initialization.initialization_f_searchbar_button.notes01_B_A_T_B;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author DELL
 */
public class f_searchbar {
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
    public JLabel notes01_B_A_J = new JLabel("Nama");
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
    

    
    JButton jp = new JButton();  
    
    
    int notes01_B_A_T_width =initialization.Containerpanelwidth-initialization.Containerpanelwidth/3;
    int notes01_B_A_T_B_P_width = initialization.Containerpanelwidth/4;
    
    int notes01_B_width = initialization.Containerpanelwidth;
    int initialized_notes01_B_height = 150;
    
    public f_searchbar() {
        initialized_notes01_B( notes01_B_width ,initialized_notes01_B_height);
        initialized_notes01_B_A_P();
       // initialized_notes01_B_B_P();
       // initialized_notes01_B_C_P();
       // i_initializing();
        notes01_B();
       // button();
    }
    
    private void initialized_notes01_B_A_P(){
        notes01_B_A_P.setLayout(new BorderLayout());
        notes01_B_A_P.setPreferredSize(new Dimension(initialization.Containerpanelwidth,90));
        notes01_B_A_P.setBounds(0,0,initialization.Containerpanelwidth,50);
        notes01_B_A_P.setOpaque(false);
        notes01_B_A_P.setBackground(  new Color(0 , 0, 0)  );
        Border blackline = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(5,217,229));
        notes01_B_A_P.setBorder(blackline);
        
        notes01_B_A_J_P.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        notes01_B_A_J_P.setPreferredSize(new Dimension(notes01_B_A_P.getWidth(),30));
        notes01_B_A_J_P.setBounds(0,0,notes01_B_A_P.getWidth(),30);
        notes01_B_A_J_P.setBackground(  new Color(0 , 0, 0)   );
        notes01_B_A_J_P.setOpaque(false);
        
        notes01_B_A_J.setForeground(Color.white);

        notes01_B_A_J_P.add(notes01_B_A_J);
     
        
        notes01_B_A_T_P.setLayout(new FlowLayout());
        notes01_B_A_T_P.setPreferredSize(new Dimension(notes01_B_A_P.getWidth(),10));
        notes01_B_A_T_P.setBounds(0,0,notes01_B_A_P.getWidth(),10);
        initialization.notes01_B_A_T.setPreferredSize(new Dimension(notes01_B_A_T_width,30)); 
        notes01_B_A_T_P.setBackground( new Color(0 , 0, 0)  );
        //initialization.notes01_B_A_T.setBackground(new Color(53,52,57));
        notes01_B_A_T_P.add(initialization.notes01_B_A_T);
        notes01_B_A_T_B_P.setLayout(new FlowLayout(FlowLayout.RIGHT,0,0));
        notes01_B_A_T_B_P.setPreferredSize(new Dimension(notes01_B_A_T_B_P_width,30));
        notes01_B_A_T_B_P.setBounds(0,0,notes01_B_A_T_B_P_width,30);
        notes01_B_A_T_B_P.setBackground( new Color(0 , 0, 0)  );
        notes01_B_A_T_B_P.add(notes01_B_A_T_B);
        notes01_B_A_T_P.add(notes01_B_A_T_B_P);
        
        notes01_B_A_P.add(notes01_B_A_J_P,BorderLayout.PAGE_START);
        notes01_B_A_P.add(notes01_B_A_T_P,BorderLayout.CENTER);
    }
    
    public JPanel return_notes01_B(){
        return notes01_B;
    }
    
    private void notes01_B(){
        notes01_B.add(notes01_B_A_P,BorderLayout.PAGE_START);
      //  notes01_B.add(notes01_B_B_P,BorderLayout.CENTER);
      //  notes01_B.add(notes01_B_C_P,BorderLayout.PAGE_END);
    }
     
    private JPanel initialized_notes01_B(int width, int height) {
        notes01_B.setPreferredSize(new Dimension(width,height));
        notes01_B.setBounds(0,0,width,height);
        notes01_B.setOpaque(false);
        notes01_B.setBackground( new Color(0, 0, 0) ); 
        return notes01_B;
   }
    
    private void cleareverything(){
     initialization.e_container.removeAll();
        initialization.e_container();
     initialization.e_container.repaint();
     initialization.e_container.revalidate();
}  
 
}
