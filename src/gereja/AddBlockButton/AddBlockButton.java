package gereja.AddBlockButton;

import initialization.initialization_genesis;
import s_sidebar2.s_sidebarAA;

import javax.swing.*;
import javax.swing.border.LineBorder;

import f_button_main.f_button_main_AC_Add;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import initialization.initialization;

public class AddBlockButton {
    private JButton b;
    f_button_main_AC_Add block = new f_button_main_AC_Add(initialization.container.getWidth());
   
    public void AddBlockButton() {
        
        b = block.r_g_button();
        b.setText("+ add block");
        // Set button size based on the panel width
        b.setPreferredSize(new Dimension(initialization_genesis.jp.getWidth() - 20, 40));
        
        // Style the button
        b.setBorder(new LineBorder(new Color(5, 217, 229)));
        b.setForeground(Color.WHITE);
        b.setBackground(new Color(0, 0, 0, 0)); // Transparent background
        b.setFocusPainted(false);
        b.setCursor(new Cursor(Cursor.HAND_CURSOR));
             
        // Add button to panel and refresh
        initialization_genesis.jp.add(b);
        initialization_genesis.jp.revalidate();
        initialization_genesis.jp.repaint();
    }
    
    // Getter for the button
    public JButton getButton() {
        return b;
    }
}