/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafile;

import b_file_function.b_file_locator;
import gereja.f_create_guirapaint;
import initialization.initialization_genesis;
import java.util.Stack;
import javafile_B.F_Keyin_NameChanger;

/**
 *
 * @author DELL
 */
public class J_zip_file_openzip_main {
   public J_zip_file_openzip_main(){
   Stack<String> stack = new Stack<String>();
        String zipFilePath = initialization_genesis.input;
        System.out.println(zipFilePath+"apani");
        //String destDirectory = b_file_locator.F_returnString_Church();
         String destDirectory = b_file_locator.F_returnString_Church();
        J_zip_file_openzip unzipper = new J_zip_file_openzip();
        try {
       stack=unzipper.unzip(zipFilePath, destDirectory);
        } catch (Exception ex) {
            // some errors occurred
            ex.printStackTrace();
        }
        
       F_Keyin_NameChanger keyin_name = new F_Keyin_NameChanger(stack);
        
       //J_zip_file_save_data save_database = new J_zip_file_save_data();
        g_Refresh_button();
    }
  
    private void g_Refresh_button(){
         f_create_guirapaint refresh = new f_create_guirapaint();
     }
}