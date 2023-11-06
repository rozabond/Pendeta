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
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Majey
 */
public class c_connection_notes {
    public static Connection conn = null;
    public static String sqliteServer = "jdbc:sqlite:";
    public static String resetPath = "";
    public String getFilePath = new File("").getAbsolutePath();
    public String fileAbsolutePath = "";
    b_file_locator file = new b_file_locator();
    
    public c_connection_notes() {
        connect();
   c_checkdatabase();
   initialization.notes01_B_A_T_initialization_id = count_table();
    }
    
    public static boolean isDatabaseExist(String dbFilePath){
        File dbFile = new File(dbFilePath);
        return dbFile.exists();
    }

    
    
    
    public  void connect() {
        try {
            // db parameters
            sqliteServer = "jdbc:sqlite:";
         
   
           fileAbsolutePath = file.F_returnString().concat(File.separator+"notes.db");
            resetPath = fileAbsolutePath;
          

            // create a connection to the database
            
            if(isDatabaseExist(fileAbsolutePath)){
                //doesn't really necessary to put it here first
                //System.out.println("DB Selection: ");
                conn = DriverManager.getConnection(sqliteServer+fileAbsolutePath);
               // System.out.println("Connection to SQLite has been established.");
            }else{
                try{
                    
                    createNewDatabase("database", "notes");
                  
                }catch (Exception ex){
                    System.out.println("Error: " + ex);
                }             
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    
    public  void createNewDatabase(String fileSubFolder, String fileName) {
 

        
            Statement statement = null; 
           Connection conn = null;
        
        

        
        try{
            conn = DriverManager.getConnection(sqliteServer+fileAbsolutePath);
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                // System.out.println("The driver name is " + meta.getDriverName());
                    String querydatabase = "CREATE TABLE " +"notaanggotagereja" + initialization.first_name + " (NAME TEXT NOT NULL, "
                + "Tarikh TEXT NOT NULL,"
                + "Nota TEXT NOT NULL,"
                + ")";
                statement  = conn.createStatement();
                statement.executeQuery(querydatabase);
                System.out.println("Database Has Been Created!");
                // statement.executeQuery("INSERT INTO words (word, type, defn) VALUES (love, verb, Deep pondness)");
            }
           // createDatabaseTable("hello");
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
    }
    
    public void createDatabaseTable(){
        
    String querydatabase = "CREATE TABLE " +"notaanggotagereja" + initialization.first_name + " (NAME TEXT NOT NULL, "
                + "Tarikh TEXT NOT NULL,"
                + "Nota TEXT NOT NULL,"
                + "ID TEXT NOT NULL"
                + ")";
        
         Statement statement = null; 
           Connection conn = null;
        
        
    
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
    
    public void insertDatabaseData(String Tarikh, String Nota ) {
  PreparedStatement pstmt = null;
        
        Connection conn = null;
        String sql = "INSERT INTO "+"notaanggotagereja" +initialization.first_name+ " (NAME,Tarikh, Nota,ID) VALUES (?,?,?,?)";
 
        try  {
            conn = DriverManager.getConnection(sqliteServer+resetPath);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, initialization.first_name);
            pstmt.setString(2, Tarikh);
            pstmt.setString(3, Nota);
            pstmt.setString(4, Integer.toString(initialization.notes01_B_A_T_initialization_id));
           // pstmt.setString(3, type);
            pstmt.executeUpdate();
            
            System.out.println("Data Inserted!");
            
        } catch (SQLException e) {
            System.out.println("Something is wrong dengan inserted data" +e.getMessage());
        }finally {
            try {
                if (conn != null) {
                    pstmt.close();
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public void g_updatedatabasedata(String Tarikh, String Nota) {
        //String sql = "INSERT INTO "+"notaanggotagereja" +initialization.first_name+ " (NAME,Tarikh, Nota,ID) VALUES (?,?,?,?)";
          PreparedStatement pstmt = null;
        
        Connection conn = null;
        
        String sql2 = "UPDATE notaanggotagereja"+initialization.first_name+" SET Tarikh = ?, Nota = ? WHERE NAME = ? AND ID = ?";
        
        try  {
            conn = DriverManager.getConnection(sqliteServer+resetPath);
            pstmt = conn.prepareStatement(sql2);
            pstmt.setString(1, Tarikh);
            pstmt.setString(2, Nota);
            pstmt.setString(3, initialization.first_name);
            pstmt.setString(4, Integer.toString(initialization.notes01_B_A_ID));
           // pstmt.setString(3, type);
            pstmt.executeUpdate();
            
            System.out.println("Data Inserted!");
            
        } catch (SQLException e) {
            System.out.println("Something is wrong dengan updated data" +e.getMessage());
        }finally {
            try {
                if (conn != null) {
                    pstmt.close();
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public int count_table(){
        String sql = "SELECT COUNT(*) FROM notaanggotagereja" +initialization.first_name;
    int count = 0;
        // PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection conn = null;  
         Statement stmt = null;
    
    try { 
       conn = DriverManager.getConnection(sqliteServer+resetPath);
        
       stmt = conn.createStatement();
       rs = stmt.executeQuery(sql);
      //Retrieving the result
      rs.next();
      count = rs.getInt(1);  
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                if (conn != null) {
                    stmt.close();
                    rs.close();
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
  return count;
    }
    


  public String checkiftableexist(String table) throws SQLException {
String determiner = "false";
        //connect(database);
            ResultSet tables = null;
        Connection c = null;       
      try  {
    c = DriverManager.getConnection(sqliteServer+fileAbsolutePath);
        DatabaseMetaData dbm = c.getMetaData();
        // check if "church" table is there
         tables = dbm.getTables(null, null, table, null);
        while (tables.next()) {
         System.out.println("Table name: "+tables.getString("Table_NAME"));
      
      if (tables.getString("Table_NAME").equals(table)) {
        determiner = "true";
         System.out.println(table + "table exist");
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
  
   public static void insertfamilytable(String name, String second_name, String relationship ,String database) {
       
        String sql = "INSERT INTO " +database+" (self_name, name_second, relationship) VALUES (?, ?, ?)";
        Connection conn = null; 
          PreparedStatement pstmt = null;
        
        try  {
            conn = DriverManager.getConnection(sqliteServer+resetPath);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, second_name);
            pstmt.setString(3, relationship);
            pstmt.executeUpdate();
            
            System.out.println("Data Inserted!");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                if (conn != null) {
                   // stmt.close();
                    pstmt.close();
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
   
   public void DeleteDatabaseTable(int hai){
       
    String sql = "DELETE FROM notaanggotagereja" +initialization.first_name+" WHERE ID LIKE '%"+hai+"%';";
    Statement statement  = null;
   Connection conn = null; 
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
            System.out.println(e.getMessage());
            System.out.println("Delete Has Problem");
        }finally {
            try {
                if (conn != null) {
                   // stmt.close();
                    statement.close();
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
   
  public ArrayList g_display_anggota(){
    String query = "SELECT * FROM notaanggotagereja"+initialization.first_name+"" ;
        
            int number = 0;

           ArrayList<Object> arrays = new ArrayList<Object>();

           
           ResultSet result = null; 
           Statement statement = null;
           ResultSet resultSet = null;
           Connection conn = null;
           try{ 
               conn = DriverManager.getConnection(sqliteServer+resetPath);
                statement  = conn.createStatement();
                resultSet = statement.executeQuery(query);   
                result = resultSet;
            
                  if(resultSet.isBeforeFirst()){
                    // loop through the result set
                    while (resultSet.next()) {
                    // stack.add(resultSet.getString("Tarikh"),resultSet.getString("Nota")); 
                    Object myObject[] = {resultSet.getString("Tarikh"),resultSet.getString("Nota")};
                    arrays.add(myObject);

                    }
                }else{
                   System.out.println("There is no data! in c_connection_notes - g_display_anggota");
                }
                
                
               
              
            }catch (SQLException exp){
                System.out.println("Check notes Result Error: " + exp);                
            }finally {
            try {
                if (conn != null) {
                   // stmt.close();
                    statement.close();
                    conn.close();
                    resultSet.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
            // System.out.println("Connect Has Been Generated!");
        
         return arrays;
  } 
  
  private void c_checkdatabase(){
        try{            
     String check = checkiftableexist("notaanggotagereja"+initialization.first_name); 
     
     
     //check the system...25/2/2021
                     if(check == "false"){
       createDatabaseTable();
        }    
                             
                                }catch (SQLException ex) {
         System.out.println("Something is wrong withe checking if the table exist" + ex.getMessage());
        }
  }
    
  
}
