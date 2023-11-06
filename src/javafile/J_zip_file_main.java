/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafile;

import b_file_function.b_file_get_zip;
import connection.c_connection_family;
import initialization.initialization_genesis;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.filechooser.FileSystemView;
import login.F_Encrype_main;
import initialization.initialization;
/**
 *
 * @author DELL
 */
public class J_zip_file_main {
    String[] con = {};
           public static List<String> Hai = new ArrayList<String>();
      
           
    public J_zip_file_main(List<String> hai){
        Hai = hai;
        g_haistart();
    }
    
    private void R_checklist(String path, String gereja) {
        boolean check = false;
        
         File fs = new File(path);
         String[] pathnames = fs.list();
        
         for (String i : pathnames) {
            if("family.db".equals(i)){
                check = true;
            }
        }
         
        if(check == false){
            initialization.gereja = gereja;
        c_connection_family f_family_04_familyconnect = new c_connection_family();
        } 
    }
    
    private String[] g_getfile(){
        
        b_file_get_zip zip = new b_file_get_zip();
        
          String[] pathnames = zip.F_returnFileexistance();
          System.out.println(Hai.size());
          List<String> al = new ArrayList<String>();
     
          
            for (String i : Hai) {
          
                String path = FileSystemView.getFileSystemView().getDefaultDirectory().getPath()+File.separator+"TanyaPendeta"+File.separator+"Church" +File.separator+ i.replaceAll(" ","_");
                R_checklist(path,i.replaceAll(" ","_"));
                al.add(path);
                initialization.gereja = i.replaceAll(" ","_");
                System.out.println(initialization.gereja+"Apa lagi ini");
               // Encrype.F_illiterating_decrypt();
           
            }
            
          String[] container = new String[al.size()];
                  container = al.toArray(container);
            return  container;
    }
        
    public void g_haistart(){
        String[] myFiles = g_getfile();
        String zipFile = initialization_genesis.input;
        J_zip_file zipUtil = new J_zip_file();
        System.out.println(zipFile+"hoho");
        try {
            zipUtil.zip(myFiles, zipFile+".pendeta");
        } catch (Exception ex) {
            // some errors occurred
            ex.printStackTrace();
        }
    }
    
      public  int[] addX(int n, int arr[], int x)
    {
        int i;
  
        // create a new array of size n+1
        int newarr[] = new int[n + 1];
  
        // insert the elements from
        // the old array into the new array
        // insert all elements till n
        // then insert x at n+1
        for (i = 0; i < n; i++)
            newarr[i] = arr[i];
  
        newarr[n] = x;
  
        return newarr;
    }
}
