package connection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import b_file_function.b_file_locator;
import initialization.initialization;
import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Majey
 */
public class c_connection_gereja {
    public Connection conn = null;
    public static String sqliteServer = "jdbc:sqlite:";
    public static String resetPath = "";
    public static String getFilePath = new File("").getAbsolutePath();
    public static String fileAbsolutePath = "";
    b_file_locator file = new b_file_locator();
    
    public c_connection_gereja() {
        connect();
        i_checkiftableexist();
        
        System.out.println("Let me check if it appear twice");
    }
    
    public static boolean isDatabaseExist(String dbFilePath){
        File dbFile = new File(dbFilePath);
        return dbFile.exists();
    }

   
    
    public  void connect() {
        try {
            // db parameters
            sqliteServer = "jdbc:sqlite:";
      
   
             fileAbsolutePath = file.F_returnString().concat(File.separator+"info_bank.db");
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
        }finally{
            
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(c_connection_gereja.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 

    }
    
    public  void createNewDatabase(String fileSubFolder, String fileName) {
 
         Connection conn = null;
         Statement statement = null;
            ResultSet resultSet = null;
        
        try {
                 conn = DriverManager.getConnection(sqliteServer+fileAbsolutePath);
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                // System.out.println("The driver name is " + meta.getDriverName());
                    
        String querydatabase = "CREATE TABLE " +"anggotagereja" + initialization.gereja + " (info TEXT NOT NULL,Nama TEXT NOT NULL,type TEXT NOT NULL)";
        
                statement  = conn.createStatement();
                statement.executeQuery(querydatabase);
                System.out.println("Database Has Been Created!");
                // statement.executeQuery("INSERT INTO words (word, type, defn) VALUES (love, verb, Deep pondness)");
            }
           // createDatabaseTable("hello");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally{
            
            try {
                statement.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(c_connection_gereja.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }
    
    public void createDatabaseTable(){
        String querydatabase = "CREATE TABLE " +"anggotagereja" + initialization.gereja + " (info TEXT NOT NULL,Nama TEXT NOT NULL,type TEXT NOT NULL)";
            Connection conn = null;
   
            Statement statement = null;
        
        try{             conn = DriverManager.getConnection(sqliteServer+fileAbsolutePath);
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
        } finally{
            
            try {
               statement.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(c_connection_gereja.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public Object t_takedata(String Nama){
         String searchQuery = "SELECT * FROM anggotagereja"+initialization.gereja+ " WHERE Nama LIKE '%"+ Nama+"%'" ;
         String nama = "";
         ResultSet result = null; 
         Connection conn = null;
          Object myObject[] = null; 
            Statement statement = null;
            ResultSet resultSet = null;
         try{ 
                  conn = DriverManager.getConnection(sqliteServer+fileAbsolutePath);
                statement  = conn.createStatement();
               
                resultSet = statement.executeQuery(searchQuery);   
                result = resultSet;
              
               if(resultSet.isBeforeFirst()){
                    // loop through the result set
               while (resultSet.next()) {
                     Object  myObjects[] = resultSet.getString("info").replace("_"," ").split("\\|");
               myObject = myObjects;             
              
               }
            
                }
           
     
              
            }catch (SQLException exp){
                System.out.println("Check recheck Result Error: " + exp);                
            }finally{
            
            try {
               statement.close();
               resultSet.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(c_connection_gereja.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
         
         return myObject;
    }
    
public  void insertpeopleData(String info,String name,String type)    
       {
String table = "anggotagereja"+initialization.gereja;
String sql = "INSERT INTO " +table+" (info,Nama,type) "
 + "VALUES (?,?,?)";
        Connection conn = null;
        
        PreparedStatement pstmt = null;
    
        
        try{
                 conn = DriverManager.getConnection(sqliteServer+fileAbsolutePath);
             pstmt = conn.prepareStatement(sql);
             
            System.out.println();
            pstmt.setString(1, info);
            pstmt.setString(2, name);
            pstmt.setString(3, type);
            pstmt.executeUpdate();
            System.out.println("C_connection_gereja 01: Data Inserted!");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage()+"data not inserted");
        }finally{
            
            try {
               pstmt.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(c_connection_gereja.class.getName()).log(Level.SEVERE, null, ex);
            }
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
         System.out.println("Something is wrong withe checking if the table exist");
        }

}


  public String checkiftableexist(String table) throws SQLException {
String determiner = "false";
        //connect(database);
        //connect(database);
       Connection c =  DriverManager.getConnection(sqliteServer+fileAbsolutePath);
       System.out.println(sqliteServer+fileAbsolutePath+"Apa path ini ahh");
            ResultSet tables = null; 
       try  {
       
        DatabaseMetaData dbm = c.getMetaData();
        // check if "church" table is there
         tables = dbm.getTables(null, null, table, null);
        while (tables.next()) {
         System.out.println("Table name: "+tables.getString("Table_NAME"));
         System.out.println("Table type: "+tables.getString("TABLE_TYPE"));
         System.out.println("Table schema: "+tables.getString("TABLE_SCHEM"));
         System.out.println("Table catalog: "+tables.getString("TABLE_CAT"));
         System.out.println(" ");
         System.out.println(table);
      if (tables.getString("Table_NAME").equals(table)) {
        determiner = "true";
      }else{
          //what happen if within that database doesn't exist the table..16/2/2021
         
      }
        }             
        } catch (SQLException e) {
            System.out.println("creating database mysqli"+e.getMessage());
        }finally{
            
            try {
                tables.close();
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(c_connection_gereja.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        
            
        
return determiner;
    }
     

   
   
   
 
     public void g_alter_table_name(String old_name, String new_name){
     String searchQuery = "ALTER TABLE anggotagereja"+old_name+" RENAME TO "+"anggotagereja"+new_name;
     
     System.out.println(sqliteServer+fileAbsolutePath + "Harap3");
     System.out.println(searchQuery + "Harap2");
        Statement statement = null;
           PreparedStatement pstmt = null;
           Connection conns = null;
           String words= null;
           
           try{ 
                conns = DriverManager.getConnection(sqliteServer+fileAbsolutePath); 
                statement= conns.createStatement();
               //  pstmt = conns.prepareStatement(searchQuery);
                statement.executeQuery(searchQuery);   
           
              //  DefaultTableModel tableModel = (DefaultTableModel)listWords.getModel();
              //  tableModel.setRowCount(0);
              
             
            }catch (SQLException exp){
                System.out.println("Check c_church g_alter_table_name Error: " + exp);                
            }finally{
            
            try {
              statement.close();  
                conns.close();
            
            } catch (SQLException ex) {
                Logger.getLogger(c_connection_gereja.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
     
 }

    public Stack c_church() {
       String searchQuery = "SELECT * FROM anggotagereja" + initialization.gereja+"";
        //String searchQuery = "SELECT * FROM anggotagereja"+gereja.Gereja_nama+ " WHERE Nama LIKE '%"+ Nama+"%'" ;
    
           int number = 0;
           Stack<String> stack = new Stack<String>();
           Statement statement = null;
           
           Connection conns = null;
           ResultSet resultSet = null;
           //System.out.println(sqliteServer+fileAbsolutePath+"what is the problem");
           //a really bad idea, cause if i make twice it just mess up with the file path...31/3/2021
           // try(Connection conns = DriverManager.getConnection(sqliteServer+fileAbsolutePath)){ 

           
           try{ 
                conns = DriverManager.getConnection(sqliteServer+fileAbsolutePath);    
                statement= conns.createStatement();
                resultSet = statement.executeQuery(searchQuery);   

                 if(resultSet.isBeforeFirst()){
                    // loop through the result set
                    while (resultSet.next()) {
                   
                     String info = resultSet.getString("Nama");
                     String type = resultSet.getString("type");
                     stack.add(info.replace("_"," ").concat("_").concat(type));
                    }
                }else{
                   System.out.println("There is no data! in c_connection_gereja - c_church");
                }
            
               //System.out.println(resultSet.getRow() + "the truth");
              //  DefaultTableModel tableModel = (DefaultTableModel)listWords.getModel();
              //  tableModel.setRowCount(0);
              
             
            }catch (SQLException exp){
                System.out.println("Check c_church Result Error: " + exp);                
            }finally{
            
            try {
              statement.close();  
                conns.close();
               resultSet.close();  
            } catch (SQLException ex) {
                Logger.getLogger(c_connection_gereja.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
            // System.out.println("Connect Has Been Generated!");
        
        return stack;
    }
    
    public void d_delete() {
       // String searchQuery = "DELETE FROM anggotagereja"+initialization.gereja+ " WHERE Nama LIKE '%"+initialization.second_name+"%'" ;
         String sql = "DELETE FROM anggotagereja"+initialization.gereja+ " WHERE Nama = ?" ;
         Connection conn = null;
         PreparedStatement pstmt = null;
          
          try{      
              
                   conn = DriverManager.getConnection(sqliteServer+fileAbsolutePath);
        // Connection conns = DriverManager.getConnection(sqliteServer+fileAbsolutePath);    
        //conn = DriverManager.getConnection(sqliteServer+fileAbsolutePath);
            pstmt = conn.prepareStatement(sql);
            // set the corresponding param
            pstmt.setString(1, initialization.second_name);
            // execute the delete statement
            pstmt.executeUpdate();
   
        } catch (SQLException e) {
            System.out.println("something is wrong with d_delete gereja" +e.getMessage());
        }finally{
            
            try {
            pstmt.close();            
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(c_connection_gereja.class.getName()).log(Level.SEVERE, null, ex);
            }
        }     
    }
    
    public void c_close() {
          try {
                if (conn != null) {
                    conn.close();
                    conn = null;
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
    }
   
    public  void o_open(){
        try {
            if(conn == null){
            conn = DriverManager.getConnection(sqliteServer+fileAbsolutePath);
            }
            } catch (SQLException ex) {
            Logger.getLogger("something is wrong on o_open" +c_connection_family.class.getName()).log(Level.SEVERE, null, ex.getErrorCode());
        }
    }
    
      public void g_delete(String name){
  String sql = "DELETE FROM anggotagereja"+initialization.gereja+ " WHERE Nama = ?" ;
         Connection conn = null;
         PreparedStatement pstmt = null;
           
           try{ 
              conn = DriverManager.getConnection(sqliteServer+fileAbsolutePath);
        // Connection conns = DriverManager.getConnection(sqliteServer+fileAbsolutePath);    
        //conn = DriverManager.getConnection(sqliteServer+fileAbsolutePath);
            pstmt = conn.prepareStatement(sql);
            // set the corresponding param
            pstmt.setString(1,name);
            // execute the delete statement
            pstmt.executeUpdate();
              //  DefaultTableModel tableModel = (DefaultTableModel)listWords.getModel();
              //  tableModel.setRowCount(0);
              
             
            }catch (SQLException exp){
                System.out.println("Error C: "+"Check c_connection_gereja G_delete Error: " + exp);                
            }finally{
            
            try {
              pstmt.close();  
                conn.close();
            
            } catch (SQLException ex) {
                Logger.getLogger(c_connection_gereja.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
            // System.out.println("Connect Has Been Generated!");
         
 }
      
      public void R_filepath(){
          fileAbsolutePath = file.F_returnString().concat(File.separator+"info_bank.db");
          }
    
    
    
}
