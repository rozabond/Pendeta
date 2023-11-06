/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delete;

import b_file_function.b_file_locator;
import connection.c_connection_church;
import gereja.Pendeta_origin;
import java.io.File;

/**
 *
 * @author DELL
 */
public class F_delete {
    c_connection_church deleting = new c_connection_church();
    public F_delete(String name) {
      G_delete(name);  
      G_delete_file(name);
    }
    
    private void G_delete(String name){
        deleting.g_delete(name);
    }
   
    private void G_delete_file(String name){
          b_file_locator desc = new b_file_locator();
          File file = new File(desc.F_returnString_Church()+"\\"+name);
          String[] pathnames = file.list();
           for (String i : pathnames) {
  
          File currentFile = new File(file.getPath(),i);
          currentFile.delete();
        }
          File files = new File(desc.F_returnString_Church()+"\\"+name+"\\image\\");
          String[] pathname = files.list();
           for (String i : pathname) {
  
          File currentFile = new File(files.getPath(),i);
          currentFile.delete();
        }
           files.delete();
           file.delete();
          
        
    } 
    
}
