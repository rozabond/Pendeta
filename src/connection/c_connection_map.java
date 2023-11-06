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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Majey
 */
public class c_connection_map {
    public static Connection conn = null;
    public static String sqliteServer = "jdbc:sqlite:";
    public static String resetPath = "";
        public static String getFilePath = new File("").getAbsolutePath();
    public static String fileAbsolutePath = "";
       b_file_locator file = new b_file_locator();
    
    
    public c_connection_map() {
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
          
            
            fileAbsolutePath = file.F_returnString().concat("\\map.db");
            resetPath = fileAbsolutePath;
            System.out.println(resetPath+"Apa la konon map");

            // create a connection to the database
            
            if(isDatabaseExist(fileAbsolutePath)){
                //doesn't really necessary to put it here first
                //System.out.println("DB Selection: ");
                conn = DriverManager.getConnection(sqliteServer+fileAbsolutePath);
               // System.out.println("Connection to SQLite has been established.");
            }else{
                try{
                conn = DriverManager.getConnection(sqliteServer+fileAbsolutePath);    
                    createNewDatabase("database", "family");
                  
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
  
 public void f_insertmap(){
  if(g_check_map2() == 1){
      g_update_map();     
  }else{
 g_insert_map();
  };
  
  }
  
  public String f_outputmap(){
      
        try {
            if(checkiftableexist("mapanggotagereja"+initialization.gereja) != "false"){
                if(g_check_map2() == 1){
                    initialization.i_coordinate = g_display_map();
                }}else{
                   createDatabaseTable();
                   initialization.i_coordinate = initialization.i_coordinate;
            }
        } catch (SQLException ex) {
            Logger.getLogger(c_connection_map.class.getName()).log(Level.SEVERE, null, ex);
        }
  return    initialization.i_coordinate;
  }
  
    
    
    
    public  void createNewDatabase(String fileSubFolder, String fileName) {
 
   
        Connection conn = null;
        Statement statement  = null;
 
        
        try  {
             conn = DriverManager.getConnection(sqliteServer+fileAbsolutePath);
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                // System.out.println("The driver name is " + meta.getDriverName());
                    String querydatabase = "CREATE TABLE " +"mapanggotagereja" + initialization.gereja + " (NAME TEXT NOT NULL, "
                + "coordinate TEXT NOT NULL"
                + ")";
                statement  = conn.createStatement();
                statement.executeQuery(querydatabase);
                System.out.println("Database Has Been Created!");
                // statement.executeQuery("INSERT INTO words (word, type, defn) VALUES (love, verb, Deep pondness)");
            }
          
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "something wrong with creating database - layer 1");
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
        
   String querydatabase = "CREATE TABLE " +"mapanggotagereja" + initialization.gereja + " (NAME TEXT NOT NULL, "
                + "coordinate TEXT NOT NULL"
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
                Logger.getLogger(c_connection_gereja.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }
    
    public void insertDatabaseData(String Tarikh, String Nota ) {
       
        String sql = "INSERT INTO "+"notaanggotagereja" +initialization.first_name+ " (NAME,Tarikh, Nota,ID) VALUES (?,?,?,?)";
 PreparedStatement pstmt = null;
 Connection conn = null;
        try  {
             conn = DriverManager.getConnection(sqliteServer+resetPath);
             pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, initialization.first_name);
            pstmt.setString(2, Tarikh);
            pstmt.setString(3, Nota);
            pstmt.setString(4, Integer.toString(count_table()));
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
                Logger.getLogger(c_connection_gereja.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }
    
    public int count_table(){
        String sql = "SELECT COUNT(*) FROM notaanggotagereja" +initialization.first_name;
  int count = 0;
  Connection conn = null;
  Statement stmt = null;
   ResultSet rs = null;
          try {
               conn = DriverManager.getConnection(sqliteServer+resetPath) ;
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
  
   public static void insertfamilytable(String name, String second_name, String relationship ,String database) {
       
        String sql = "INSERT INTO " +database+" (self_name, name_second, relationship) VALUES (?, ?, ?)";
 PreparedStatement pstmt = null;
 Connection conn = null;    
 try {
      conn = DriverManager.getConnection(sqliteServer+resetPath);   
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, second_name);
            pstmt.setString(3, relationship);
            pstmt.executeUpdate();
            
            System.out.println("Data Inserted!");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally{
            
            try {
           
                pstmt.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(c_connection_gereja.class.getName()).log(Level.SEVERE, null, ex);
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
        }finally{
            
            try {
           
                statement.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(c_connection_gereja.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }
 
    public void g_alter_table_name(String old_name, String new_name){
     String searchQuery = "ALTER TABLE mapanggotagereja"+old_name+" RENAME TO "+"mapanggotagereja"+new_name;
     
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
   
   
  public String g_display_map(){
   String query = "SELECT * FROM mapanggotagereja"+initialization.gereja+ " WHERE NAME LIKE '%"+initialization.Orang+"%'";
   
            int number = 0;
           ResultSet result = null; 
           String coordinate = null;
      Statement statement  = null;
      ResultSet resultSet = null;
      Connection conn = null;
           try{ 
                conn = DriverManager.getConnection(sqliteServer+resetPath);
                 statement  = conn.createStatement();
                 resultSet = statement.executeQuery(query);   
                result = resultSet;
              //  DefaultTableModel tableModel = (DefaultTableModel)listWords.getModel();
              //  tableModel.setRowCount(0);
              coordinate = result.getString("coordinate");
              System.out.println("mari tengok apa coordinate"+ coordinate);
            }catch (SQLException exp){
                System.out.println("Check notes Result Error: " + exp.getMessage());                
            }finally{
            
            try {
                result.close();
                resultSet.close();
                statement.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(c_connection_gereja.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
            // System.out.println("Connect Has Been Generated!");
        
        return coordinate;     
  } 
  
  private String g_check_map(){
       // String query = "SELECT * FROM notaanggotagereja"+initialization.gereja+ "WHERE NAME LIKE '%"+initialization.Orang+"%'"; 
        String query2 = "SELECT * FROM mapanggotagereja"+initialization.gereja+" WHERE NAME="+initialization.Orang+" LIMIT 1"; 
        int number = 0;
           ResultSet result = null; 
           String see = null;
           Statement statement = null;
           ResultSet resultSet = null;
           Connection conn = null;
           try{ 
                conn = DriverManager.getConnection(sqliteServer+resetPath);
                 statement  = conn.createStatement();
                 resultSet = statement.executeQuery(query2);   
                result = resultSet;
              //  DefaultTableModel tableModel = (DefaultTableModel)listWords.getModel();
              //  tableModel.setRowCount(0);
                see = result.getString("NAME");
              
            }catch (SQLException exp){
                System.out.println("Check map Result Error: " + exp);                
            }finally{
            
            try {
                result.close();
                resultSet.close();
                statement.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(c_connection_gereja.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
           
    
            
            
        return see;  
  }
  
   private int g_check_map2() {
     
     
     String searchQuery = "SELECT count(*) FROM mapanggotagereja"+initialization.gereja+ " WHERE NAME LIKE '%"+ initialization.Orang+"%'";
          // System.out.println("SELECT * FROM anggotagerejaKitobu_Gereja WHERE Nama LIKE '%trylagi%'"); 
          // System.out.println(gereja.Gereja_nama + "Kenapa ba ni");
            //         System.out.println(); 
            int number = 0;
       
           Statement statement = null;
           ResultSet resultSet = null;
           Connection conn = null;
        try { 
             conn = DriverManager.getConnection(sqliteServer+resetPath);
                 statement  = conn.createStatement();
                 resultSet = statement.executeQuery(searchQuery);   
              
               // System.out.println(result+ "apa yang di sini");
             //   result.next();
                System.out.println("Table check map contains "+resultSet.getInt("count(*)")+" rows");
              //  DefaultTableModel tableModel = (DefaultTableModel)listWords.getModel();
              //  tableModel.setRowCount(0);
            number = resultSet.getInt("count(*)");
              
            }catch (SQLException exp){
                System.out.println("Result check map Error: " + exp);                
            }finally{
            
            try {
             
                resultSet.close();
                statement.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(c_connection_gereja.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
            // System.out.println("Connect Has Been Generated!");
        
        
        return number;
    }

  public void g_insert_map() {
   //String query = "UPDATE anggotagereja"+initialization.gereja+ "WHERE NAME LIKE '%"+initialization.Orang+"%' SET NAME = ?";
        String sql = "INSERT INTO mapanggotagereja" +initialization.gereja+" (coordinate, NAME) VALUES (?, ?)";
            int number = 0;
          
         Connection conn = null;
         PreparedStatement pstmt  = null;
        try {
        conn = DriverManager.getConnection(sqliteServer+resetPath);
            pstmt = conn.prepareStatement(sql);

            // set the corresponding param
            pstmt.setString(1, initialization.i_coordinate);
            pstmt.setString(2, initialization.Orang);
            // update 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage()+ "checkmap insert error");
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
  
  
  public ResultSet g_update_map(){
   //String query = "UPDATE anggotagereja"+initialization.gereja+ "WHERE NAME LIKE '%"+initialization.Orang+"%' SET NAME = ?";
   String query2 = "UPDATE mapanggotagereja"+initialization.gereja+" SET coordinate = ? WHERE NAME = ?";
            int number = 0;
           ResultSet result = null; 
         Connection conn = null;
         PreparedStatement pstmt  = null; 

        try {
            conn = DriverManager.getConnection(sqliteServer+resetPath);     
            pstmt = conn.prepareStatement(query2);
            pstmt.setString(1, initialization.i_coordinate);
            pstmt.setString(2, initialization.Orang);
            // update 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("masalah dengan g_update_map:"+e.getMessage());
        }finally{
            
            try {
        
                pstmt.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(c_connection_gereja.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
            // System.out.println("Connect Has Been Generated!");      
        return result;     
  } 
  
     public void R_filepath(){
          fileAbsolutePath = file.F_returnString().concat(File.separator+"map.db");
          }
    
  
  
  private void c_checkdatabase(){
        try{            
     String check = checkiftableexist("mapanggotagereja"+initialization.gereja); 
     
     
     //check the system...25/2/2021
                     if(check == "false"){
       createDatabaseTable();
        }    
                             
                                }catch (SQLException ex) {
         System.out.println("Something is wrong withe checking if the table exist" + ex.getMessage());
        }
  }
    
  
}
