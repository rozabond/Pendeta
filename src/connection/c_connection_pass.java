package connection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import b_file_function.b_file_info;
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
public class c_connection_pass {
    public static Connection conn = null;
    public static String sqliteServer = "jdbc:sqlite:";
    public static String resetPath = "";
    public static String getFilePath = new File("").getAbsolutePath();
    public static String fileAbsolutePath = "";
       b_file_info file = new b_file_info();
    
    
    public c_connection_pass() {
        connect();
   c_checkdatabase();
    }
    
    public static boolean isDatabaseExist(String dbFilePath){
        File dbFile = new File(dbFilePath);
        return dbFile.exists();
    }

    
    
    
    public  void connect() {
         try {
            // db parameters
            sqliteServer = "jdbc:sqlite:";
          
   
            fileAbsolutePath = file.F_returnString_Church().concat(File.separator+"info.db");
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
                    createNewDatabase("database");
                  
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
        
    public  void createNewDatabase(String fileSubFolder) {
 
   
        Connection conn = null;
        Statement statement  = null;
 
        
        try  {
             conn = DriverManager.getConnection(sqliteServer+fileAbsolutePath);
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                // System.out.println("The driver name is " + meta.getDriverName());
                    String querydatabase = "CREATE TABLE " +"database" + " (NAME TEXT NOT NULL, "
                + "password TEXT NOT NULL"
                + ")";
                statement  = conn.createStatement();
                statement.executeQuery(querydatabase);
                System.out.println("Database Has Been Created!");
                // statement.executeQuery("INSERT INTO words (word, type, defn) VALUES (love, verb, Deep pondness)");
            }
          
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "something wrong with pass database - layer 1");
        }finally{
            
            try {
                statement.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(c_connection_gereja.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }
    
    public static void createDatabaseTable(){
        
               Connection conn = null;
        Statement statement  = null;
        
    String querydatabase = "CREATE TABLE " +"database" + " (NAME TEXT NOT NULL, "
                + "password TEXT NOT NULL"
                + ")";
        
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
            System.out.println("something wrong dengan create table " + e.getMessage());
        }finally{
            
            try {
                statement.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(c_connection_pass.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }
    
    public void insertDatabaseData(String Name, String password ) {
       
    String sql = "INSERT INTO "+"database"+" (NAME,password) VALUES (?,?)";
    PreparedStatement pstmt = null;
    Connection conn = null;
        try  {
             conn = DriverManager.getConnection(sqliteServer+resetPath);
             pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Name);
            pstmt.setString(2, password);
           // pstmt.setString(3, type);
            pstmt.executeUpdate();
            
            System.out.println("Data Inserted!");
        } catch (SQLException e) {
            System.out.println("Something is wrong dengan inserted data" +e.getMessage());
        }finally{
            
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(c_connection_pass.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }
    
  public void updatepasswosrd(String Name, String password ) {
        
   // String sql = "INSERT INTO "+"database"+" (NAME,password) VALUES (?,?)";
    String sql = "UPDATE database SET password = ? WHERE NAME = ?";
    PreparedStatement pstmt = null;
    Connection conn = null;
        try  {
             conn = DriverManager.getConnection(sqliteServer+resetPath);
             pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, password);
            pstmt.setString(2, Name);
           // pstmt.setString(3, type);
            pstmt.executeUpdate();
            
            System.out.println("Data Inserted!");
        } catch (SQLException e) {
            System.out.println("Something is wrong dengan inserted data" +e.getMessage());
        }finally{
            
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(c_connection_pass.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }
   
  public String checkiftableexist(String table) throws SQLException {
        String determiner = "false";
        //connect(database);
        //connect(database);
       Connection c =  DriverManager.getConnection(sqliteServer+fileAbsolutePath);
    
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
  
 
  private void c_checkdatabase(){
        try{            
     String check = checkiftableexist("database"); 
     
     
     //check the system...25/2/2021
                     if(check == "false"){
       createDatabaseTable();
        }    
                             
                                }catch (SQLException ex) {
         System.out.println("Something is wrong withe checking if the table exist" + ex.getMessage());
        }
  }
    
  public boolean c_Login(String Name, String Password){
       // String sqls = "INSERT INTO " +database+" (self_name, name_second, relationship) VALUES (?, ?, ?)";     
    String query = "select * from database where NAME=? and password=?";
    boolean ind = false;
    Connection conn = null;
   PreparedStatement pstmt = null;
     ResultSet rs = null;
     
          try {
                        conn = DriverManager.getConnection(sqliteServer+resetPath);
             pstmt = conn.prepareStatement(query);
            pstmt.setString(1, Name);
            pstmt.setString(2, Password);
           // pstmt.setString(3, type);
             rs = pstmt.executeQuery();
           
            if(rs.next()){
            ind = true;
            }
           
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally{
            
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(c_connection_gereja.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
          
          return ind;
  }
  
   public Stack c_get_info(String Name){
       // String sqls = "INSERT INTO " +database+" (self_name, name_second, relationship) VALUES (?, ?, ?)";     
        String query = "select * from database where NAME=?";
    boolean ind = false;
    Connection conn = null;
     Stack<String> stack = new Stack<String>();
   PreparedStatement pstmt = null;
     ResultSet rs = null;
     
          try {
                        conn = DriverManager.getConnection(sqliteServer+resetPath);
             pstmt = conn.prepareStatement(query);
            pstmt.setString(1, Name);
           // pstmt.setString(3, type);
             rs = pstmt.executeQuery();
           
                if(rs.isBeforeFirst()){
                    // loop through the result set
                    while (rs.next()) {
                   
                     String info = rs.getString("NAME");
                     String type = rs.getString("password");
                     stack.add(info);
                     stack.add(type);
                    }
                }else{
                   System.out.println("There is no data! in c_connection_gereja - c_church");
                }
           
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally{
            
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(c_connection_gereja.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
          
          return stack;
  }
  
  
  
   public boolean c_login_email(String Name){
       // String sqls = "INSERT INTO " +database+" (self_name, name_second, relationship) VALUES (?, ?, ?)";     
    String query = "select * from database where NAME=?";
    boolean ind = false;
    Connection conn = null;
   PreparedStatement pstmt = null;
     ResultSet rs = null;
     
          try {
                        conn = DriverManager.getConnection(sqliteServer+resetPath);
             pstmt = conn.prepareStatement(query);
            pstmt.setString(1, Name);
           // pstmt.setString(3, type);
             rs = pstmt.executeQuery();
           
            if(rs.next()){
            ind = true;
            }
           
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally{
            
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(c_connection_gereja.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
          
          return ind;
  }
  
  
  
   public boolean count_table(){
        String sql = "SELECT COUNT(*) FROM database";
  int count = 0;
  boolean ind = false;
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
      System.out.println("Check" + count);
            
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
          
        if (count == 0){
              ind = true;
        }
        
  return ind;
    }
  
}
