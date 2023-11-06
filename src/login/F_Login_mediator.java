/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import static login.F_Login_initialization.current_Id;
import static login.F_Login_initialization.notes01_B_B_T_PASTOR;

/**
 *
 * @author DELL
 */
public class F_Login_mediator {
    
   public F_Login_mediator(){
       
   }
   
   public String F_return_id(){
           return current_Id;
   }
   
   public String F_return_login(){
       return notes01_B_B_T_PASTOR;
   }
}
