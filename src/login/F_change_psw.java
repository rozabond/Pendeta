/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

/**
 *
 * @author DELL
 */
public class F_change_psw {
    String Old_pas;
    String new_pas;
    String retype;
    
    public F_change_psw(String Old_pass, String new_pass, String Retype){
        Old_pas = Old_pass;
        new_pas = new_pass;
        retype = Retype;
    }
    
    public boolean f_old_pass(){
        boolean ind = false;
        if(Old_pas.equals(F_Login_initialization.current_psw)){
            ind = true;
        }
        
       // System.out.println(F_Login_initialization.current_psw+"Apa la");
        System.out.println(Old_pas+"apala ini ");
        return ind;
    }
    
    public boolean f_match(){
       boolean ind = false;
        if(new_pas.equals(retype)){
            ind = true;
        }
        
        return ind;
    }
}
