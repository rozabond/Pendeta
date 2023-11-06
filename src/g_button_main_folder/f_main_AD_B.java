/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g_button_main_folder;

import addcomponent.SpringUtilities;
import connection.c_connection_pass;
import css.scrollbar;
import static g_button_main_folder.f_main_initialization.l_a;
import static g_button_main_folder.f_main_initialization.l_a_p;
import static g_button_main_folder.f_main_initialization.textField_1;
import static g_button_main_folder.f_main_initialization.textField_2;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javafile.J_SampleJFileChooser;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpringLayout;
import javax.swing.border.LineBorder;
import login.F_Encrype;
import login.F_Login_mediator;
import login.F_change_psw;

/**
 *
 * @author DELL
 */
public class f_main_AD_B {
       JPanel box = new JPanel(){
    protected void paintComponent(Graphics g)
    {
       super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
    
    }
};
       
    public final scrollbar scrollPanel = new scrollbar(
        box,
        ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER ){
    protected void paintComponent(Graphics g)
    {
        g.setColor( getBackground() );
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
        
    }
};
    
       public f_main_AD_B(){
           initialize_box();
     
           g_buttonbox();
        //   g_checkbox();    
       }
       
       private void initialize_box(){
           box.setOpaque(true);
           box.setLayout(new GridLayout(0,1,20,10));
        box.setPreferredSize(new Dimension(200,40));
        box.setBounds(0, 0, box.getWidth(), box.getHeight());   
        l_a_p.setForeground(Color.yellow);
        l_a_p.setVisible(false);
        textField_1.setText("");
        textField_2.setText("");
       }
       
  private void F_setnew(){
            textField_1.setText("");
         f_main_initialization.textField.setText("");
        textField_2.setText("");
  }   
  
       
       
       public void g_buttonbox(){
JPanel hai =new JPanel(){
    protected void paintComponent(Graphics g)
    {
        g.setColor( getBackground() );
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
        
    }
};
    
  SpringLayout layout = new SpringLayout();
                        hai.setLayout(layout);
                        hai.setOpaque(false);
                 
           JPanel hai2 = new JPanel(new GridLayout(0,2,20,10));
           hai2.setPreferredSize(new Dimension(400,70));
           hai2.setBounds(0, 0, hai2.getWidth(), hai2.getHeight());
                  
            JLabel l = new JLabel("New Password", JLabel.TRAILING);
            hai2.add(l);
        
            textField_1.setPreferredSize(new Dimension(hai2.getWidth(),70));
            l.setLabelFor(textField_1);
            hai2.add(textField_1);
            JLabel l_2 = new JLabel("Retype", JLabel.TRAILING);
            hai2.add(l_2);
            textField_2.setPreferredSize(new Dimension(hai2.getWidth(),70));
            l.setLabelFor(textField_2);
            hai2.add(textField_2);
            
                       SpringUtilities.makeCompactGrid(hai2,
                                        2, 2, //rows, cols
                                        6, 20,        //initX, initY
                                        6, 20);       //xPad, yPad 
         
            //initialization.lists.add(textField);
        
        
                        
                        JButton b = new JButton("Save");
                    b.setPreferredSize(new Dimension(150, 40));
                        b.setBorder(new LineBorder(new Color(5,217,229)));
                        b.setForeground(Color.white);
                   b.setBounds(0, 300, b.getWidth(), b.getHeight());
                   b.addActionListener(new ActionListener(){  
                        public void actionPerformed(ActionEvent e){  
                        
                        F_change_psw file = new F_change_psw(f_main_initialization.textField.getText(),textField_1.getText(),textField_2.getText());
                        if(file.f_match() && file.f_old_pass()){
                        F_Encrype decrpte = new F_Encrype();
                        c_connection_pass key_in =  new c_connection_pass();
                        F_Login_mediator Id = new F_Login_mediator();
                        key_in.updatepasswosrd(Id.F_return_login(),textField_1.getText());
                        decrpte.F_encrype_church();
                        F_setnew();
                        }
       
                        if(file.f_match() == false){
                            
                          l_a_p.setVisible(true);
                        }
                        
                        if(file.f_old_pass() == false){
                          l_a.setVisible(true);
                        }
                        }});
                   
                   hai.add(hai2);
                        hai.add(b,BorderLayout.PAGE_END);
                        hai.add(l_a_p);
            
                          layout.putConstraint(SpringLayout.VERTICAL_CENTER, hai2, -100, SpringLayout.VERTICAL_CENTER, hai);  
                        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, hai2, -50, SpringLayout.HORIZONTAL_CENTER, hai);           
                       layout.putConstraint(SpringLayout.VERTICAL_CENTER, b, -5, SpringLayout.VERTICAL_CENTER, hai);  
                        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, b, 80, SpringLayout.HORIZONTAL_CENTER, hai); 
                     layout.putConstraint(SpringLayout.VERTICAL_CENTER, l_a_p, 30, SpringLayout.VERTICAL_CENTER, hai);  
                        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, l_a_p, 80, SpringLayout.HORIZONTAL_CENTER, hai); 
                     
                       
      box.add(hai);
    
    }
       
        
     public void g_checkbox(){
JPanel  hai =new JPanel(){
    protected void paintComponent(Graphics g)
    {
        g.setColor( getBackground() );
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
        
    }
};
    
  SpringLayout layout = new SpringLayout();
                       hai.setLayout(layout);
                       hai.setOpaque(false);
          
             f_main_initialization.b.addItemListener(new ItemListener() {
    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
 
        } else {//checkbox has been deselected
     
        };
    }
});
                        hai.add( f_main_initialization.la,BorderLayout.PAGE_END);
                        hai.setBackground(new Color(255,255,255,10));
                        layout.putConstraint(SpringLayout.VERTICAL_CENTER,  f_main_initialization.la, -5, SpringLayout.VERTICAL_CENTER, hai);  
                        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER,  f_main_initialization.la, 0, SpringLayout.HORIZONTAL_CENTER, hai); 
                     
                       
      box.add(hai);
    
    }
    

    private void F_checkall(){
     f_main_AA.f_checkall();
    } 
       
    public JPanel r_returnbox(){
        return box;
    }
}
