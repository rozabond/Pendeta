package login;

import addcomponent.SpringUtilities;
import c_connection.g_testconnection;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialDeepOceanContrastIJTheme;
import connection.c_connection_pass;
import gereja.Pendeta_origin;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import static login.F_Login_initialization.back;
import static login.F_Login_initialization.l_a_product_email;
import static login.F_Login_initialization.l_a_product_email_warning;
import static login.F_Login_initialization.l_a_product_valid_email;
import static login.F_Login_initialization.notes01_B_B_T_PASTOR;
import static login.F_Login_initialization.textField_1;
import static login.F_Login_initialization.textField_2;
import static login.F_Login_initialization.textField_3;
import static login.F_Login_initialization.textField_4;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jude
 */
public class F_login extends javax.swing.JFrame {
    JLabel l_a_p = new JLabel("Username or Password not correct", JLabel.TRAILING);
    JLabel Register = new JLabel("<HTML><U>Register</U></HTML>");
    JLabel Forget_Password = new JLabel("<HTML><U>Forget Password?</U></HTML>");
         JLabel Title = new JLabel("Welcome, Pendeta", JLabel.TRAILING);
        
    F_Encrype decrpte = new F_Encrype();
    c_connection_pass key_in =  new c_connection_pass();

 /**
     * Creates new form MainFrame
     */
    public F_login() {
        init_label();
        this.getContentPane().add(initComponents());
           C_Register();
           C_login_recheck_pass();
        R_returnbutton();
    
        pack();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                         
    private void init_label(){
        l_a_p.setVisible(false);
        l_a_p.setForeground(Color.yellow);
        Register.setForeground(new Color(75,82,109));
        Forget_Password.setForeground(new Color(75,82,109));      
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
this.setLocation(dim.width/2-325/2, dim.height/4);
String f = new File("icon.png").getAbsolutePath();
System.out.println(f);
ImageIcon imgicon = new ImageIcon(f);
this.setIconImage(imgicon.getImage());
//frame.setIconImage(icon.getImage());
    }
    
    private void C_Register(){
        if(key_in.count_table()){
            Register.setVisible(true);
            Forget_Password.setVisible(false);
        }else{
            Register.setVisible(false);
            Forget_Password.setVisible(true);
        }
    }
    
    private void C_login_recheck_pass(){
        l_a_product_email.setVisible(false);
        l_a_product_email.setForeground(Color.yellow);    
    }
    
    private JPanel initComponents() {
            this.setResizable(false);
            this.setTitle("Pendeta 1.0");
            
            //this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
             	
        try {
            UIManager.setLookAndFeel( new FlatMaterialDeepOceanContrastIJTheme() );
            //JLabel background=new JLabel(new ImageIcon("C:\\Users\\Computer\\Downloads\\colorful design.png"));
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(F_login.class.getName()).log(Level.SEVERE, null, ex);
        }
     
          this.addWindowListener(new java.awt.event.WindowAdapter() {
    @Override
    public void windowClosing(java.awt.event.WindowEvent e) {
  
                      //  
         decrpte.F_encrype_church();
                     // this.dispose();
      System.exit(0);
    }
});
        
        
            SpringLayout layout = new SpringLayout();
            F_Login_initialization.hai_origin.setLayout(layout);
            F_Login_initialization.hai_origin.setPreferredSize(new Dimension(325,350));
            F_Login_initialization.hai_origin.setBounds(0, 0,  F_Login_initialization.hai_origin.getWidth(),  F_Login_initialization.hai_origin.getHeight());
        
      
           Title.setForeground(Color.WHITE);
           JButton loginbtn = new javax.swing.JButton("Login");
           JTextField textField_1 = new JTextField(50);
           JTextField textField_2 = new JTextField(50); 
           JPanel hai2 = new JPanel(new GridLayout(0,2,20,10));
           hai2.setPreferredSize(new Dimension(400,70));
           hai2.setBounds(0, 0, hai2.getWidth(), hai2.getHeight());
           //hai2.setBackground(new Color(0,0,51));
         
           Register.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
           Register.addMouseListener(new MouseAdapter()  
{  
    public void mouseClicked(MouseEvent e)  
    {  
      RegisterbtnActionPerformed();
    }  
}); 
           Forget_Password.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
           Forget_Password.addMouseListener(new MouseAdapter()  
{  
    public void mouseClicked(MouseEvent e)  
    {  
     // RegisterbtnActionPerformed();
        Forget_PasswordbtnActionPerformed();
    }  
}); 
           
           
           loginbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               // loginbtnActionPerformed(evt);
               LoginbtnActionPerformed(textField_1.getText(),textField_2.getText());
               
            }
        });
           
           
            JLabel l = new JLabel("Email", JLabel.TRAILING);
            l.setForeground(Color.WHITE);
            hai2.add(l);
        
            textField_1.setPreferredSize(new Dimension(hai2.getWidth(),70));
            l.setLabelFor(textField_1);
            hai2.add(textField_1);
            JLabel l_2 = new JLabel("Password", JLabel.TRAILING);
            l_2.setForeground(Color.WHITE);
            hai2.add(l_2);
            textField_2.setPreferredSize(new Dimension(hai2.getWidth(),70));
            l.setLabelFor(textField_2);
            hai2.add(textField_2);
            
            SpringUtilities.makeCompactGrid(hai2,
                                        2, 2, //rows, cols
                                        6, 20,        //initX, initY
                                        6, 20);       //xPad, yPad 
            
            layout.putConstraint(SpringLayout.VERTICAL_CENTER, Title, -90, SpringLayout.VERTICAL_CENTER,  F_Login_initialization.hai_origin);  
            layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, Title,0, SpringLayout.HORIZONTAL_CENTER,  F_Login_initialization.hai_origin); 
            layout.putConstraint(SpringLayout.VERTICAL_CENTER, hai2, -5, SpringLayout.VERTICAL_CENTER,  F_Login_initialization.hai_origin);  
            layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, hai2,-70, SpringLayout.HORIZONTAL_CENTER,  F_Login_initialization.hai_origin); 
            layout.putConstraint(SpringLayout.VERTICAL_CENTER, loginbtn, 90, SpringLayout.VERTICAL_CENTER,  F_Login_initialization.hai_origin);  
            layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, loginbtn,100, SpringLayout.HORIZONTAL_CENTER,  F_Login_initialization.hai_origin); 
            layout.putConstraint(SpringLayout.VERTICAL_CENTER, Register, 90, SpringLayout.VERTICAL_CENTER,  F_Login_initialization.hai_origin);  
            layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, Register,-100, SpringLayout.HORIZONTAL_CENTER,  F_Login_initialization.hai_origin); 
            layout.putConstraint(SpringLayout.VERTICAL_CENTER, Forget_Password, 90, SpringLayout.VERTICAL_CENTER,  F_Login_initialization.hai_origin);  
            layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, Forget_Password,-80, SpringLayout.HORIZONTAL_CENTER,  F_Login_initialization.hai_origin); 
            layout.putConstraint(SpringLayout.VERTICAL_CENTER, l_a_p, 120, SpringLayout.VERTICAL_CENTER,  F_Login_initialization.hai_origin);  
            layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, l_a_p,30, SpringLayout.HORIZONTAL_CENTER,  F_Login_initialization.hai_origin); 
            layout.putConstraint(SpringLayout.VERTICAL_CENTER,   l_a_product_email, -90, SpringLayout.VERTICAL_CENTER,  F_Login_initialization.hai_origin);  
            layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, l_a_product_email,0, SpringLayout.HORIZONTAL_CENTER,  F_Login_initialization.hai_origin); 
                             
            
             F_Login_initialization.hai_origin.add(Title);
             F_Login_initialization.hai_origin.add(hai2);
             F_Login_initialization.hai_origin.add(loginbtn);
             F_Login_initialization.hai_origin.add(Register);
             F_Login_initialization.hai_origin.add(Forget_Password);
             F_Login_initialization.hai_origin.add(l_a_p);
              F_Login_initialization.hai_origin.add(l_a_product_email);
            
   return F_Login_initialization.hai_origin;   
    }// </editor-fold>                        
  
    private void backbtnactionperformed(){
    C_Register();
    this.getContentPane().setBackground(Color.yellow);
    this.getContentPane().removeAll();
    getContentPane().add(F_Login_initialization.hai_origin);   
    this.repaint();
    this.revalidate();
    }
    
    private void R_returnbutton(){
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Title.setVisible(true);
                F_regenerate();
                     backbtnactionperformed();
            }
        }); 
        
        
           F_Login_initialization.Registerbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                        F_regenerate();
                        
                  F_register_process file = new F_register_process(textField_2.getText(),textField_3.getText(),textField_4.getText());
           
                    if(textField_1.getText().contains("@")){
                        if(file.f_match() && file.f_product()){
                        c_connection_pass key_in =  new c_connection_pass();
                        key_in.insertDatabaseData(textField_1.getText(), textField_2.getText());
                      //  F_Login_mediator Id = new F_Login_mediator();
                       // key_in.insertDatabaseData(Id.F_return_id(),textField_1.getText());
                       backbtnactionperformed();
                       Title.setText("Welcome, Pendeta, Registration successful");
                        }
                           }else{
                               l_a_product_valid_email.setVisible(true);
                           }
                 
                        if(file.f_match()== false){
                          F_Login_initialization.l_a_p.setVisible(true);
                        }
                        
                        if(file.f_product() == false){
                            F_Login_initialization.l_a_product.setVisible(true);
                        }
                
                
            }
        });
           
            F_Login_initialization.LostPassword.addActionListener(new java.awt.event.ActionListener() {
                 public void actionPerformed(java.awt.event.ActionEvent evt) {
                       F_regenerate();
 if(G_testConnection() == true){                     
        if(key_in.c_login_email(textField_1.getText())){
              Stack<String> stack = key_in.c_get_info(textField_1.getText());
        F_email_sending email = new F_email_sending((String) stack.pop(),(String)  stack.pop());    
        backbtnactionperformed();
        l_a_product_email.setVisible(true);
        Title.setVisible(false);
       
        }else{
        F_Login_initialization.l_a_product_email_warning.setVisible(true);
        } 
            }else{
      JOptionPane.showMessageDialog(null, "No internet Connection", "Warning", JOptionPane.WARNING_MESSAGE);                          
      
 }
                 }     
           });
           
           
    }

    private void RegisterbtnActionPerformed() {                                         
    this.getContentPane().setBackground(Color.yellow);
    this.getContentPane().removeAll();
    F_register regis = new F_register();
          
    getContentPane().add(regis.init_());   
    this.repaint();
    this.revalidate();
    }
    
    private void Forget_PasswordbtnActionPerformed() {                                         
    this.getContentPane().setBackground(Color.yellow);
    this.getContentPane().removeAll();
    F_forget_password regis = new F_forget_password();
          
    getContentPane().add(regis.init());   
    this.repaint();
    this.revalidate();
    }
    
          private boolean G_testConnection(){
        g_testconnection g_testing = new g_testconnection();
       
       boolean g_connection =  g_testing.checkInternetConnection();
       return g_connection;
    }
    
    private void F_regenerate(){
                      F_Login_initialization.l_a_product.setVisible(false);
                      F_Login_initialization.l_a_p.setVisible(false);
                      l_a_product_email.setVisible(false);
                      l_a_product_email_warning.setVisible(false);
                      l_a_p.setVisible(false);
          }

    private void LoginbtnActionPerformed(String Name, String Password) {                                         
       
        if(key_in.c_Login(Name, Password)){
            notes01_B_B_T_PASTOR = Name;
            F_Login_initialization.current_psw = Password;
                try {
                    decrpte.F_encrype_church();
                    new Pendeta_origin().setVisible(true);
                    this.dispose();
                } catch (Exception ex) {
                    Logger.getLogger(Pendeta_origin.class.getName()).log(Level.SEVERE, null, ex);
                }
              
        }else{
            l_a_p.setVisible(true);
        }
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
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(F_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(F_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(F_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(F_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new F_login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton loginbtn;
    private javax.swing.JTextField uname;
    private javax.swing.JTextField upass;
    // End of variables declaration                   
}