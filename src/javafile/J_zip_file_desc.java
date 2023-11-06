/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafile;

import b_file_function.b_file_locator;
import connection.c_connection_church;
import initialization.initialization;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;



/**
 *
 * @author DELL
 */
public class J_zip_file_desc {
     
    c_connection_church conn = new c_connection_church();
     b_file_locator locator = new b_file_locator();
    
      public  J_zip_file_desc(String Nama){
    initialization.gereja = Nama;
    F_return_notepad();    
    F_Open_notedpad(conn.g_take_disc(Nama));
    }
    
    private void F_return_notepad() {
      
        G_Create(locator.F_returnString());
    }
    
    private void G_Create(String Directory){
        try {
      File myObj = new File(Directory+"\\description.txt");
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
      } else {
        System.out.println("File already exists.");
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    }
   
    private void F_Open_notedpad(String words){
        
        G_write(words,locator.F_returnString());
    }
    
    private void G_write(String words, String Location){
         try {
      FileWriter myWriter = new FileWriter(Location+"\\description.txt");
      myWriter.write(words);
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
      System.out.println("An error occurred...G_write");
      e.printStackTrace();
    }
    }
}


