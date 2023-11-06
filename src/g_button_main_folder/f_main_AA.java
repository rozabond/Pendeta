/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g_button_main_folder;

import connection.c_connection_church;
import css.scrollbar;
import initialization.initialization;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author DELL
 */
public class f_main_AA {
       JPanel box = new JPanel(){
    protected void paintComponent(Graphics g)
    {
       super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int w = getWidth();
        int h = getHeight();
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
    
       public static List<JCheckBox> checkBoxes = new ArrayList<JCheckBox>();
          c_connection_church church = new c_connection_church();
 
       public f_main_AA(){
           initialize_box();
           g_checkbox();
         
       }
       
       private void initialize_box(){
           box.setOpaque(true);
           box.setLayout(new GridLayout(0,3,20,10));
        box.setPreferredSize(new Dimension(200,40));
        box.setBounds(0, 0, box.getWidth(), box.getHeight());
           Border blackline = BorderFactory.createMatteBorder(0, 0, 0, 2, new Color(5,217,229));
           //blackline.paintBorder(box,Color.YELLOW, 0, 0, 0, 0);
        box.setBorder(blackline);
        
        
         scrollPanel.setPreferredSize(new Dimension(initialization.pane_container.getWidth(),initialization.pane_container.getHeight()-100));
        scrollPanel.setBounds(0, 0,initialization.pane_container.getWidth(), initialization.pane_container.getHeight()-100);
 
         scrollPanel.getViewport().setBackground(new Color(255,255,255,10));
        //scrollPanel.setBackground(new Color(255,255,255,10));
        scrollPanel.repaint();
        scrollPanel.revalidate();
        
       }
       
     
  
       
       
       public void g_checkbox(){
    
    //11.6.2021 his is he solution that i have for f_MAIN_AA problem
    int z = 0;
    
     Iterator<String> itr = f_take_churchnum();
    
    while (itr.hasNext()){
       
        String intern = (String) itr.next();
        JCheckBox cbox1 = new JCheckBox(intern);
        cbox1.addItemListener(new ItemListener() {
    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
        f_main_initialization.checkBoxes.add(cbox1.getText());
        } else {//checkbox has been deselected
            //do something...
            System.out.println(cbox1.getText());
        f_main_initialization.checkBoxes.remove(cbox1.getText());
        };
    }
});
        f_main_initialization.b.addItemListener(new ItemListener() {
    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
        cbox1.setSelected(true);
        } else {//checkbox has been deselected
        cbox1.setSelected(false);
        };
    }
});
       
      box.add(cbox1);
      z++;
    }      
   //what is the problem F_Main_AA = the scrollbar isn't responding try let it out then it won't extend
           if(z >40){
                box.setPreferredSize(new Dimension(200, (int) (z*20.5)));
           }
           
           box.repaint();
           box.revalidate();
    
       }
    
    public scrollbar r_returnbox(){
        return scrollPanel;
    }
    
    public static void f_checkall(){
    for (JCheckBox checkBox : checkBoxes) {
      checkBox.setSelected(true);
    }
}
    
    public Iterator f_take_churchnum(){
  Stack<String> stack = new Stack<String>();
  stack = church.f_church_resultset();
  Iterator<String> itr = stack.iterator();
     
        return itr;
    }
}
