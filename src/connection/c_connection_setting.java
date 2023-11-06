/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;


import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author DELL
 */
public class c_connection_setting {
       public static Connection conn = null;
    public static String sqliteServer = "jdbc:sqlite:";
    public static String resetPath = "";
    public static String getFilePath = new File("").getAbsolutePath();
    public static String fileAbsolutePath = "";
    Stack<String> STACK = new Stack<String>();

      
    
    
    public c_connection_setting() {
        connect();
        i_checkiftableexist();
       }
    
    public static boolean isDatabaseExist(String dbFilePath){
        File dbFile = new File(dbFilePath);
        return dbFile.exists();
    }

    
    
    
    public  void connect() {
        try {
            // db parameters
            sqliteServer = "jdbc:sqlite:";
      
            String getFilePath = new File("").getAbsolutePath();

   
             fileAbsolutePath = getFilePath.concat("\\info_bank.db");
              resetPath = fileAbsolutePath;
          

            // create a connection to the database
            
            if(isDatabaseExist(fileAbsolutePath)){
                //doesn't really necessary to put it here first
                //System.out.println("DB Selection: ");
                conn = DriverManager.getConnection(sqliteServer+fileAbsolutePath);
               // System.out.println("Connection to SQLite has been established.");
            }else{
                try{
                conn = DriverManager.getConnection(sqliteServer+fileAbsolutePath);
                    createNewDatabase("database", "info_bank");
                  
                }catch (Exception ex){
                    System.out.println("Error: " + ex);
                }             
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public static void createNewDatabase(String fileSubFolder, String fileName) {
  Statement statement  = null;
        Connection conn = null;
        try  {
             conn = DriverManager.getConnection(sqliteServer+fileAbsolutePath);
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                // System.out.println("The driver name is " + meta.getDriverName());
                    
        String querydatabase = "CREATE TABLE " +"setting (setting TEXT NOT NULL)";
        
                 statement  = conn.createStatement();
                statement.executeQuery(querydatabase);
                System.out.println("Database Has Been Created!");
                // statement.executeQuery("INSERT INTO words (word, type, defn) VALUES (love, verb, Deep pondness)");
            }
           // createDatabaseTable("hello");
        } catch (SQLException e) {
            System.out.println(e.getMessage()+"Create new database error");
        }finally {
            try {
                if (conn != null) {
                    statement.close();
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public void createDatabaseTable(){
        String querydatabase = "CREATE TABLE " +"setting (Setting TEXT NOT NULL)";
        
          Connection conn = null;
          Statement statement  = null;
        try{
            
             conn = DriverManager.getConnection(sqliteServer+fileAbsolutePath); 
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("Database Path: " + resetPath);
                
                statement  = conn.createStatement();
               
                statement.executeUpdate(querydatabase);
                System.out.println("Table Has Been Created!");
                // statement.executeQuery("INSERT INTO words (word, type, defn) VALUES (love, verb, Deep pondness)");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                if (conn != null) {
                    statement.close();
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
      /*   try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println("c_connection_gereja Closing_problem" + ex.getMessage());
            }*/
    }
    


private void i_checkiftableexist(){
    try{            
     String check = checkiftableexist("setting"); 
     
     
     //check the system...25/2/2021
     System.out.println("check apa nombor check" + check);
                     if(check == "false"){
                         
       createDatabaseTable();
        }    
                             
                        
                                }catch (SQLException ex) {
         System.out.println("c_connection_setting: i_checkiftableexist wrong" );
        }

}


  public String checkiftableexist(String table) throws SQLException {
       
       String determiner = "false";
       ResultSet tables = null;
       Connection c =  DriverManager.getConnection(sqliteServer+fileAbsolutePath);
       
       try  {
       
        DatabaseMetaData dbm = c.getMetaData();
        // check if "church" table is there
         tables = dbm.getTables(null, null, table, null);
        while (tables.next()) {
      if (tables.getString("Table_NAME").equals(table)) {
            System.out.println("Table exists: "+tables.getString("Table_NAME"));
        
        determiner = "true";
      }else{
          //what happen if within that database doesn't exist the table..16/2/2021
          System.out.println("Table doesn't exists: ");
        
      }
        }             
        } catch (SQLException e) {
            System.out.println("checkiftableexist problem"+e.getMessage());
        }finally{
            
            try {
                tables.close();
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(c_connection_gereja.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            }
        }         
return determiner;
    }
  
  public void F_insert(String settingstring){
      DeleteDatabaseTable();
      insertsetting(settingstring);
  }
       
 public void insertsetting(String settingstring) {
//
       String sql = "INSERT INTO setting (setting) VALUES (?)";
  //System.out.println(sql+"check dlu betul ka semua" ); 
   Connection conn = null;

   PreparedStatement pstmt = null;

   
   try {
                conn = DriverManager.getConnection(sqliteServer+fileAbsolutePath);
           pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, settingstring);
            pstmt.executeUpdate();   
        } catch (SQLException e) {
            System.out.println("c_connection_setting: fail untuk insert setting: " + e.getMessage());
        }
        
       try {
                if (conn != null) {
                    conn.close();
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println("c_connection_setting: insertsetting" + ex.getMessage());
            }
        
    }
 
   public  void DeleteDatabaseTable(){
       
    String sql = "DELETE FROM setting";
       Connection conn = null;
              Statement statement = null;
        try {
             conn = DriverManager.getConnection(sqliteServer+resetPath);
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
         
                statement  = conn.createStatement();
               
                statement.executeUpdate(sql);
        
                System.out.println("Delete Succesful " + resetPath);
                // statement.executeQuery("INSERT INTO words (word, type, defn) VALUES (love, verb, Deep pondness)");
            }
        } catch (SQLException e) {
       System.out.println("c_connection_setting: deleteDatabasetable: " + e.getMessage());
        }finally{
            
            try {
               statement.close();
                conn.close();
            } catch (SQLException ex) {
                 System.out.println("c_connection_setting: insertsetting" + ex.getMessage());
                Logger.getLogger(c_connection_gereja.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    
   
   }
   
   public String take_database(){
       String panel = null;
       String searchQuery = "SELECT * FROM setting";
      
            int number = 0;
     
            Connection conn = null;
             Statement statement = null;

            ResultSet resultSet = null;
           try{ 
                   conn = DriverManager.getConnection(sqliteServer+fileAbsolutePath);
                   statement  = conn.createStatement();
                   resultSet = statement.executeQuery(searchQuery);   

              //  DefaultTableModel tableModel = (DefaultTableModel)listWords.getModel();
              //  tableModel.setRowCount(0);
             while(resultSet.next()){  
               panel = resultSet.getString("setting"); 
} 
              
           }catch (SQLException exp){
                System.out.println("C_connection_setting:  take_database" + exp);                
            }finally{
            
            try {
                resultSet.close();
               statement.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(c_connection_gereja.class.getName()).log(Level.SEVERE, null, ex);
            }
   }
           
           return panel;
   }
}
