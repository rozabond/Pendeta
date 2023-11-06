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
import javafile.J_zip_file_desc;

/**
 *
 * @author DELL
 */
public class c_connection_church {
     public Connection conn = null;
    public static String sqliteServer = "jdbc:sqlite:";
    public static String resetPath = "";
    public static String getFilePath = new File("").getAbsolutePath();
    public static String fileAbsolutePath = "";
    b_file_locator file = new b_file_locator();
    
    
    public c_connection_church() {
        connect();
        i_checkiftableexist();
       // f_add_data();
    }
       
       
    public  void connect() {
        try {
            // db parameters
            sqliteServer = "jdbc:sqlite:";
            fileAbsolutePath = file.F_return_ChurchString().concat(File.separator+"church.db");
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
                    createNewDatabase("database", "church");
                  
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
    
      public static boolean isDatabaseExist(String dbFilePath){
        File dbFile = new File(dbFilePath);
        return dbFile.exists();
    }

    
      public  void createNewDatabase(String fileSubFolder, String fileName) {
 
            Statement statement = null; 
           Connection conn = null;
   
   
        try {
                 conn = DriverManager.getConnection(sqliteServer+fileAbsolutePath);
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                // System.out.println("The driver name is " + meta.getDriverName());
                    
                String querydatabase = "CREATE TABLE " +"church"+ " (ID TEXT NOT NULL, "
                + "Nama TEXT NOT NULL,"
                + "disc TEXT NOT NULL"
                + ")";
        
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
  
        public String checkiftableexist(String table) throws SQLException {
        String determiner = "false";
        //connect(database);
        //connect(database);
        
  
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
   
     public void createDatabaseTable(){
          String querydatabase = "CREATE TABLE " +"church" + " (ID TEXT NOT NULL, "
                + "Nama TEXT NOT NULL,"
                + "disc TEXT NOT NULL"
                + ")";
         Connection conn = null;
           Statement statement = null;
         
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
     
     
     
private int count_table(){
        String sql = "SELECT COUNT(*) FROM church";
  int count = 0;
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;
          try {
                  conn = DriverManager.getConnection(sqliteServer+fileAbsolutePath);
     stmt = conn.createStatement();
     rs = stmt.executeQuery(sql);
      //Retrieving the result
      rs.next();
      count = rs.getInt(1);  
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally{
            
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(c_connection_gereja.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
  return count;
    } 
      
 private void i_checkiftableexist(){
    try{            
     String check = checkiftableexist("church"); 
     
     
     //check the system...25/2/2021
        if(check == "false"){                 
       createDatabaseTable();
        }    
                                }catch (SQLException ex) {
         System.out.println("Something is wrong withe checking if the table exist");
        }

}     

 public Stack f_church_resultset() {
      String searchQuery = "SELECT * FROM church";
      Stack<String> stack = new Stack<String>();
        //String searchQuery = "SELECT * FROM anggotagereja"+gereja.Gereja_nama+ " WHERE Nama LIKE '%"+ Nama+"%'" ;
    
           Statement statement = null;
           PreparedStatement pstmt = null;
           Connection conns = null;
           ResultSet resultSet = null;
           
           try{ 
                conns = DriverManager.getConnection(sqliteServer+fileAbsolutePath); 
                statement= conns.createStatement();
               //  pstmt = conns.prepareStatement(searchQuery);
                resultSet = statement.executeQuery(searchQuery);   
           while(resultSet.next()){  
            stack.add(resultSet.getString(2).replaceAll("_", " ")+"_"+resultSet.getString(1)); 
        }   
            
              
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
 
 
 
 
 public void f_add_data(String ID,String nama, String disc){
   //  String table = "anggotagereja"+initialization.gereja;
String sql = "INSERT INTO church(ID, Nama,disc)"
 + " VALUES (?,?,?)";
        Connection conn = null;
         PreparedStatement pstmt = null;
        try{
                 conn = DriverManager.getConnection(sqliteServer+fileAbsolutePath);
                pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,ID);
            pstmt.setString(2,nama.replaceAll(" ", "_"));
            pstmt.setString(3,disc.replaceAll(" ", "_"));
            pstmt.executeUpdate();
            pstmt.close();
            System.out.println("Data Inserted!");
            
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
        //for the sake of putting notepad 21/6/2021
        J_zip_file_desc descs = new J_zip_file_desc(nama);
 }

 public String g_take_disc(String name){
  String searchQuery = "SELECT disc FROM church WHERE NAMA LIKE '%"+name+"%'";
    
        //String searchQuery = "SELECT * FROM anggotagereja"+gereja.Gereja_nama+ " WHERE Nama LIKE '%"+ Nama+"%'" ;
    
           Statement statement = null;
           PreparedStatement pstmt = null;
           Connection conns = null;
           ResultSet resultSet = null;
           String words= null;
           try{ 
                conns = DriverManager.getConnection(sqliteServer+fileAbsolutePath); 
                statement= conns.createStatement();
               //  pstmt = conns.prepareStatement(searchQuery);
                resultSet = statement.executeQuery(searchQuery);   
           while(resultSet.next()){  
              // stack.add(resultSet.getString(1)); 
               words = resultSet.getString(1);
         
} 
            
               System.out.println(resultSet.getRow() + "the truth");
              //  DefaultTableModel tableModel = (DefaultTableModel)listWords.getModel();
              //  tableModel.setRowCount(0);
              
             
            }catch (SQLException exp){
                System.out.println("Check c_church g_take_disc Error: " + exp);                
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
        
        return words;    
 }
 
 public void g_alter_table_name(String old_name, String new_name){
     String searchQuery = "ALTER TABLE family"+old_name+" RENAME TO "+"family"+new_name;
     
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
 

 
 public void g_delete(String name){
  String searchQuery = "DELETE FROM church WHERE NAMA LIKE '%"+name+"%'";
    
        //String searchQuery = "SELECT * FROM anggotagereja"+gereja.Gereja_nama+ " WHERE Nama LIKE '%"+ Nama+"%'" ;
    
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
                System.out.println("Check c_church G_delete Error: " + exp);                
            }finally{
            
            try {
              statement.close();  
                conns.close();
            
            } catch (SQLException ex) {
                Logger.getLogger(c_connection_gereja.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
            // System.out.println("Connect Has Been Generated!");
         
 }
    
 
}
