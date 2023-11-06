/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import b_file_function.b_file_locator;
import initialization.initialization;
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
public class c_connection_search {
       public static Connection conn = null;
    public static String sqliteServer = "jdbc:sqlite:";
    public static String resetPath = "";
    public static String getFilePath = new File("").getAbsolutePath();
    public static String fileAbsolutePath = "";
    Stack<String> STACK = new Stack<String>();
    b_file_locator file = new b_file_locator();
      
    
    
    public c_connection_search() {
        connect();
        i_checkiftableexist();
        System.out.println("saya mau check kalau dia appear twice");
    }
    
    public static boolean isDatabaseExist(String dbFilePath){
        File dbFile = new File(dbFilePath);
        return dbFile.exists();
    }

    
    
    
    public  void connect() {
        try {
            // db parameters
            sqliteServer = "jdbc:sqlite:";
      
   
           fileAbsolutePath = file.F_returnString().concat("\\info_bank.db");
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
                    
        String querydatabase = "CREATE TABLE " +"anggotagereja" + initialization.gereja + " (ID TEXT NOT NULL, "
                + "Nama TEXT NOT NULL,"
                + "Ic TEXT NOT NULL,"
                + "Tarikh_Lahir TEXT NOT NULL,"
                + "Agama_Asal TEXT NOT NULL,"
                + "Agama_Terkini TEXT NOT NULL,"
                + "Tarikh_dibaptis TEXT NOT NULL,"
                + "Alamat_terkini TEXT NOT NULL,"
                + "Nombor_tel TEXT NOT NULL"           
                + ")";
        
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
          String querydatabase = "CREATE TABLE " +"anggotagereja" + initialization.gereja + " (ID TEXT NOT NULL, "
                + "Nama TEXT NOT NULL,"
                + "Ic TEXT NOT NULL,"   
                + "Tarikh_Lahir TEXT NOT NULL,"
                + "Agama_Asal TEXT NOT NULL,"
                + "Agama_Terkini TEXT NOT NULL,"
                + "Tarikh_dibaptis TEXT NOT NULL,"
                + "Alamat_terkini TEXT NOT NULL,"
                + "Nombor_tel TEXT NOT NULL"           
                + ")";
        
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
    
    public Stack t_takedata(String Nama){
         String searchQuery = "SELECT * FROM anggotagereja"+initialization.gereja+ " WHERE Nama LIKE '%"+ Nama+"%'" ;
      
         Stack<String> stack = new Stack<String>();
         ResultSet resultSet  = null;
         Statement statement = null;
         Connection conn = null;
         
         try{ 
             conn = DriverManager.getConnection(sqliteServer+fileAbsolutePath);  
             statement  = conn.createStatement();
             resultSet = statement.executeQuery(searchQuery);                 
            
while(resultSet.next()){  
               stack.add(resultSet.getString("Nama").replaceAll("_", " ")); 
} 
      
         }catch (SQLException exp){
                System.out.println("Check recheck Result Error: " + exp);                
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
         
         return stack;
    }
    
public static void insertpeopleData(int id, 
               String name, 
               String ic,
               String tarikh_lahir,
               String Agama_asal, 
               String Agama_terkini,
               String Tarikh_dibaptis,
               String Alamat_terkini,
               String Nombor_tel) 
      
       {
String table = "anggotagereja"+initialization.gereja;
String sql = "INSERT INTO " +table+" (ID, Nama, Ic, Tarikh_Lahir,Agama_Asal,Agama_Terkini,Tarikh_dibaptis,Alamat_terkini,Nombor_tel) "
 + "VALUES (?,?,?,?,?,?,?,?,?)";
       
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, ic);
            pstmt.setString(4, tarikh_lahir);
            pstmt.setString(5, Agama_asal);
            pstmt.setString(6, Agama_terkini);
            pstmt.setString(7, Tarikh_dibaptis);
            pstmt.setString(8, Alamat_terkini);
            pstmt.setString(9, Nombor_tel);
            
            pstmt.executeUpdate();
            
            System.out.println("Data Inserted!");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage()+"data not inserted");
        }
        
    /*    try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println("c_connection_gereja Closing_problem" + ex.getMessage());
            }*/
        
    }

private void i_checkiftableexist(){
    try{            
     String check = checkiftableexist("anggotagereja"+initialization.gereja); 
     
     
     //check the system...25/2/2021
     System.out.println("check apa nombor check" + check);
                     if(check == "false"){
                         
       createDatabaseTable();
        }    
                             
                        
                                }catch (SQLException ex) {
         System.out.println("i_checkiftableexist wrong");
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
     

   
   
   
    
        public void c_close() {
          try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
    }
   
    public  void o_open(){
        try {
            conn = DriverManager.getConnection(sqliteServer+fileAbsolutePath);
        } catch (SQLException ex) {
            Logger.getLogger("something is wrong on o_open" +c_connection_family.class.getName()).log(Level.SEVERE, null, ex.getErrorCode());
        }
    }
    
    
    public Stack i_f_search(String name){
    String searchQuery = "SELECT * FROM anggotagereja"+initialization.gereja+ " WHERE Nama LIKE '%"+ name+"%'" ;
    String nama = "";
 
    Connection conn = null;  
    Statement statement = null;
    ResultSet resultSet = null;
    
    System.out.println(sqliteServer+fileAbsolutePath);
    try{
         conn = DriverManager.getConnection(sqliteServer+fileAbsolutePath);              
         statement  = conn.createStatement();
         resultSet = statement.executeQuery(searchQuery);   
        
       if(resultSet.isBeforeFirst()){

                    while (resultSet.next()) {
                       
                       STACK.add(resultSet.getString("Nama").replaceAll("_", " ").concat("_").concat(resultSet.getString("type")));
                            
                    }
                }else{
                   System.out.println("There is no data!");
                }
       }catch (SQLException exp){
                System.out.println("i_f_search Error: " + exp.getMessage());                
            }finally {
            try {
                if (conn != null) {
                    statement.close();
                    conn.close();
                    resultSet.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage() + "i_f_search");
            }
        }
  
    return STACK;
    }    
}
