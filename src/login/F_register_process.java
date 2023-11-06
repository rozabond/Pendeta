/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.util.Arrays;

/**
 *
 * @author DELL
 */
public class F_register_process {
    String new_pas;
    String retype;
    String product_id_cont;
    String product_id[] = { "4100-7750-5929-7845-3185","4087-8321-1477-9136-3939","testing","4243-1530-7047-7548-6647","6136-2280-3576-3821-1827","8783-9908-6213-4489-4636","8676-5244-8003-6260-2448","1375-7798-2761-6965-8437"
            ,"2652-8795-9646-5104-6199","7114-4472-6303-7404-4226"};
 
    
    
    public F_register_process(String new_pass, String Retype, String Product_id){
   
        new_pas = new_pass;
        retype = Retype;
        product_id_cont = Product_id;
    }
    public boolean f_match(){
       boolean ind = false;
        if(new_pas.equals(retype)){
            ind = true;
        }
        
        return ind;
    }
    
    public boolean f_product(){
        boolean ind;
        ind = Arrays.asList(product_id).contains(product_id_cont);
        return ind;
    }
}
