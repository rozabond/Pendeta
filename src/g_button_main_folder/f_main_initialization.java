/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g_button_main_folder;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author DELL
 */
public class f_main_initialization {
       public static List<String> checkBoxes = new ArrayList<String>();
        public static JCheckBox b = new JCheckBox("Check me once");
         public static JLabel la = new JLabel("Status: No Upload");
         public static JLabel l_a = new JLabel("Old Password isn't match", JLabel.TRAILING);  
         public static JLabel l_a_p = new JLabel("New Password isn't match", JLabel.TRAILING);  
         public static JTextField textField = new JTextField(50);
         public static  JTextField textField_1 = new JTextField(50);
         public static JTextField textField_2 = new JTextField(50);
      
}
