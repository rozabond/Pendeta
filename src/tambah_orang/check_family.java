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

/**
 *
 * @author DELL
 */
public class check_family {
    
     public ResultSet checkson(String searchQuery) {
   // searchQuery = searchQuery + gereja.Gereja_nama+ " WHERE Nama LIKE '%"+ Orang+"%'";
     
      
            int number = 0;
           ResultSet result = null; 
           
        try{
       
            Connection conns = null;
          
     
            try{
                String sql = searchQuery;
                Statement statement  = conns.createStatement();
                ResultSet resultSet = statement.executeQuery(searchQuery);   
                result = resultSet;
                
                System.out.println();
                
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
