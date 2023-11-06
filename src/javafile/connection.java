package javafile;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import initialization.initialization;
import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

/**
 *
 * @author Majey
 */
public class connection {
    public static Connection conn = null;
    public static String sqliteServer = "jdbc:sqlite:";
    public static String resetPath = "";
    
    public static boolean isDatabaseExist(String dbFilePath){
        File dbFile = new File(dbFilePath);
        return dbFile.exists();
    }

    
    public static void connect(String database) {
        try {
            // db parameters
            sqliteServer = "jdbc:sqlite:";
            String getFilePath = new File("").getAbsolutePath();
            String fileAbsolutePath = "";
            
            if(database == "family"){
             fileAbsolutePath = getFilePath.concat("\\src\\database\\family.db");
            resetPath = fileAbsolutePath;
            }
            if(database == "church"){
             fileAbsolutePath = getFilePath.concat("\\src\\database\\church.db");
            resetPath = fileAbsolutePath; 
            }
            if(database == "info_bank"){
             fileAbsolutePath = getFilePath.concat("\\src\\database\\info_bank.db");
            resetPath = fileAbsolutePath; 
            }

            // create a connection to the database
            
            if(isDatabaseExist(fileAbsolutePath)){
                //doesn't really necessary to put it here first
                //System.out.println("DB Selection: ");
                conn = DriverManager.getConnection(sqliteServer+fileAbsolutePath);
               // System.out.println("Connection to SQLite has been established.");
            }else{
                try{
                    if(database == "family"){
                    createNewDatabase("database", "family");
                    }
                    if(database == "church"){
                    createNewDatabase("database", "church");  
                    }
                    if(database == "info_bank"){
                    createNewDatabase("database", "info_bank");  
                    }
                }catch (Exception ex){
                    System.out.println("Error: " + ex);
                }             
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        /*
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        */
    }
    
    public static void createNewDatabase(String fileSubFolder, String fileName) {
 
        String getFilePath = new File("").getAbsolutePath();
        String fileAbsolutePath = "";
        
        if(fileSubFolder.isEmpty()){
            fileAbsolutePath = getFilePath.concat("\\src\\database\\"+fileName+".db");
            resetPath = fileAbsolutePath;
        }else{
            fileAbsolutePath = getFilePath.concat("\\src\\"+fileSubFolder+"\\"+fileName+".db");
            resetPath = fileAbsolutePath;
        }
        
        try (Connection conn = DriverManager.getConnection(sqliteServer+fileAbsolutePath)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                // System.out.println("The driver name is " + meta.getDriverName());
                Statement statement  = conn.createStatement();
                statement.executeQuery("CREATE TABLE member(ID INT PRIMARY KEY NOT NULL, name TEXT NOT NULL);");
                System.out.println("Database Has Been Created!");
                // statement.executeQuery("INSERT INTO words (word, type, defn) VALUES (love, verb, Deep pondness)");
            }
           // createDatabaseTable("hello");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void createDatabaseTable(String hai){
        try (Connection conn = DriverManager.getConnection(sqliteServer+resetPath)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("Database Path: " + resetPath);
                
                Statement statement  = conn.createStatement();
               
                statement.executeUpdate(hai);
                System.out.println("Table Has Been Created!");
                // statement.executeQuery("INSERT INTO words (word, type, defn) VALUES (love, verb, Deep pondness)");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void insertDatabaseData(double id, String church_name, String table) {
       
        String sql = "INSERT INTO " +table+" (ID, name) VALUES (?, ?)";
 
        try (Connection conn = DriverManager.getConnection(sqliteServer+resetPath)) {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, id);
            pstmt.setString(2, church_name);
           // pstmt.setString(3, type);
            pstmt.executeUpdate();
            
            System.out.println("Data Inserted!");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
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
       
       System.out.println(id +"ini id dia");
        try (Connection conn = DriverManager.getConnection(sqliteServer+resetPath)) {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, id);
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
    }

  public String checkiftableexist(String table,String database) throws SQLException {
String determiner = "false";
        connect(database);
        Connection c = conn;
        DatabaseMetaData dbm = c.getMetaData();
// check if "church" table is there
        ResultSet tables = dbm.getTables(null, null, table, null);
       
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
        
return determiner;
    }
  
   public static void insertfamilytable(String name, String second_name, String relationship ,String database) {
       
        String sql = "INSERT INTO " +database+" (self_name, name_second, relationship) VALUES (?, ?, ?)";
 
        try (Connection conn = DriverManager.getConnection(sqliteServer+resetPath)) {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, second_name);
            pstmt.setString(3, relationship);
            pstmt.executeUpdate();
            
            System.out.println("Data Inserted!");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
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
  
}
