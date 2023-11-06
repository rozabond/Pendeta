/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tambah_orang;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafile.connection;

/**
 *
 * @author DELL
 */
public class checkdatabase {
  
    
    public static ResultSet checkprimarydatabase(String searchQuery) {
   // searchQuery = searchQuery + gereja.Gereja_nama+ " WHERE Nama LIKE '%"+ Orang+"%'";
     
      
            int number = 0;
           ResultSet result = null; 
           
        try{
            
            connection connet = new connection();
            connet.connect("church");
            Connection conns = connet.conn;
          
     
            try{
             String sql = searchQuery;
                Statement statement  = conns.createStatement();
                ResultSet resultSet = statement.executeQuery(searchQuery);   
                result = resultSet;

              //  DefaultTableModel tableModel = (DefaultTableModel)listWords.getModel();
              //  tableModel.setRowCount(0);
               
              
            }catch (SQLException exp){
                System.out.println("Result Error: " + exp);                
            }
            // System.out.println("Connect Has Been Generated!");
        }catch (Exception ex){
            System.out.println("Connection Error: " + ex);
        }
        
        return result;
    }    
}


