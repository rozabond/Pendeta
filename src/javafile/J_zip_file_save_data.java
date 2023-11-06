package javafile;

import b_file_function.b_file_get_zip;
import b_file_function.b_file_locator;
import connection.c_connection_church;
import gereja.f_create_guirapaint;
import initialization.initialization;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class J_zip_file_save_data {
    b_file_locator desc = new b_file_locator();
           b_file_get_zip zip = new b_file_get_zip();
     c_connection_church church = new c_connection_church();   
     Stack<String> stack_keyin = new Stack<String>();
    J_GuiraPaint refresh = new J_GuiraPaint();
     
     public J_zip_file_save_data(){
         g_get_database_name();
         g_save_name();
    
    }
     
     private void g_change_database_name(String name){
         //tmr k
     }
    
     
    private void g_get_database_name(){
     Stack<String> stack = new Stack<String>();
     stack = church.f_church_resultset();
     Iterator<String> itr = stack.iterator();
     String[] pathnames =  g_get_folder_name();
     //18/6/2021 get the 
                        for (String i : pathnames) {
                            if(!stack.contains(i) && !"Genesis".equals(i)){
                                System.out.println("ada content "+ i);
                                stack_keyin.add(i);
                            }
                        }
    }
    
    private String[] g_get_folder_name(){
        String[] pathnames = zip.F_returnFileexistance();
        return pathnames;
    }
    
    public void g_save_name(){
     Iterator<String> itr = stack_keyin.iterator();      
     String con;    
       while (itr.hasNext()){
    String intern = (String) itr.next();
    initialization.gereja = intern;
    con =  g_takedata(desc.F_returnString());
    church.f_add_data(intern.trim().replace(" ","_"),intern.trim().replace(" ","_"), con);
    refresh.g_repaint(intern.trim().replace(" ","_"));
       }
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
    
}
