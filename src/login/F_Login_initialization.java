/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author DELL
 */
public class F_Login_initialization {
      static  JButton Registerbtn = new javax.swing.JButton("Register");
     static  JButton LostPassword = new javax.swing.JButton("Enter");
      
           static JLabel l_a_p = new JLabel("Retype-PSW tidak sama", JLabel.TRAILING);
           static JLabel l_a_product = new JLabel("product tidak wujud", JLabel.TRAILING);
           static JLabel l_a_product_valid_email = new JLabel("Please enter valid email address", JLabel.TRAILING);
           static JLabel l_a_product_email = new JLabel("Password send to email", JLabel.TRAILING);
           static JLabel l_a_product_email_warning = new JLabel("Email isn't the same", JLabel.TRAILING);
    public static String current_psw = "test";
    public static String current_Id = "testid";
     public static JPanel hai_origin = new JPanel();
      public static JButton back = new JButton("back");
      static public String notes01_B_B_T_PASTOR = "###Pastor ALvin###";
         static public JTextField textField_1 = new JTextField(50);
          static public JTextField textField_2 = new JTextField(50); 
          static public JTextField textField_3 = new JTextField(50); 
          static public JTextField textField_4 = new JTextField(50); 
}
