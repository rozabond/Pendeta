/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafile_B;

import static b_file_function.b_file_encryption_cannidate.stack;
import b_file_function.b_file_locator;
import connection.c_connection_church;
import connection.c_connection_family;
import connection.c_connection_gereja;
import connection.c_connection_map;
import initialization.initialization;
import initialization.initialization_genesis;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafile.J_GuiraPaint;
import login.F_Encrype_main;

/**
 *
 * @author DELL
 */
public class F_Keyin_save_name {
     b_file_locator desc = new b_file_locator();
     c_connection_church church = new c_connection_church();
     c_connection_gereja gereja = new c_connection_gereja();
     c_connection_family family = new c_connection_family();
  
     J_GuiraPaint refresh = new J_GuiraPaint();
     F_Keyin_openzip unzipper = new F_Keyin_openzip();
      F_Encrype_main Encrype = new F_Encrype_main();

    
    
     public void g_save_name(String name){
   // initialization.gereja = original_name;
    String con =  g_takedata(desc.F_returnString());
    church.f_add_data(name.replace(" ","_"),name.replace(" ","_"), con);
    refresh.g_repaint(name.replace(" ","_"));
       
    }
     
     public void g_change_data(String new_name, String old_name){
        
        String zipFilePath = initialization_genesis.input;
        System.out.println(zipFilePath+"apani");
        //String destDirectory = b_file_locator.F_returnString_Church();
        //Decided that to ask the user not to put any weird symbol...23.9.2021
        new_name = new_name.replace(" ","_");
      
        initialization.gereja = new_name;
     c_connection_map map = new c_connection_map();
        String destDirectory = b_file_locator.F_returnString_Church();
        try {
        unzipper.unzip(zipFilePath, destDirectory,new_name,old_name);
        } catch (Exception ex) {
            // some errors occurred
            ex.printStackTrace();
        }
        Encrype.F_illiterating_decrypt();
        
        gereja.R_filepath();
        family.R_filepath();
        //change the alter the table name  
        gereja.g_alter_table_name(old_name, new_name);
        family.g_alter_table_name(old_name, new_name);
        map.g_alter_table_name(old_name,  new_name);
        g_save_name(new_name);
        
        stack.add(new_name);
       // Encrype.F_illiterating_encrypt();
//One of the bug i realized shouldn't be here...        
//cleareverything();
     }
     
       public void g_change_data_oldname(String new_name, String old_name){
        
        String zipFilePath = initialization_genesis.input;
        System.out.println(zipFilePath+"apani");
        //String destDirectory = b_file_locator.F_returnString_Church();
        //Decided that to ask the user not to put any weird symbol...23.9.2021
        new_name = new_name.replace(" ","_");
      
        initialization.gereja = new_name;
         String destDirectory = b_file_locator.F_returnString_Church();
        try {
        unzipper.unzip(zipFilePath, destDirectory,new_name,old_name);
        } catch (Exception ex) {
            // some errors occurred
            ex.printStackTrace();
        }
        Encrype.F_illiterating_decrypt();
            
       gereja.R_filepath();
       family.R_filepath();
        //change the alter the table name  
      // gereja.g_alter_table_name(old_name, new_name);
      // family.g_alter_table_name(old_name, new_name);
        g_save_name(new_name);
        stack.add(new_name);
      //  Encrype.F_illiterating_encrypt();
      //  cleareverything();
       //For encryption
     }
     
      private String g_takedata(String location){
           String data = "";
        try {
      File myObj = new File(location+File.separator+"description.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        data = data + myReader.nextLine();
       
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
         System.out.println(data);
         return data;
    }
      
      private void cleareverything(){
          //pain in the ass 1 hours bug 24.9.2021
          // path name for when folder are going input...
          // importatnt to have the circle of life theory
       //   initialization_genesis.input = null;
      }
     
}
