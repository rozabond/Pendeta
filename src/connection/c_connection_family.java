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
public class c_connection_family {
    Connection conn = null;
    public static String sqliteServer = "jdbc:sqlite:";
    public static String resetPath = "";
    public static String getFilePath = new File("").getAbsolutePath();
    public static String fileAbsolutePath = "";
   b_file_locator file = new b_file_locator();
    
    
    public c_connection_family() {
        connect();
        i_checkiftableexist();
    }
    
    public static boolean isDatabaseExist(String dbFilePath){
        File dbFile = new File(dbFilePath);
        return dbFile.exists();
    }

    
    
    
   public void connect() {
        try {
            // db parameters
            sqliteServer = "jdbc:sqlite:";       
          fileAbsolutePath = file.F_returnString().concat(File.separator+"family.db");
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
    

    
    public  void createNewDatabase(String fileSubFolder, String fileName) {
 
        
           Statement statement = null;
            Connection conn =null;
        
        
        try  {
       conn = DriverManager.getConnection(sqliteServer+fileAbsolutePath);
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                // System.out.println("The driver name is " + meta.getDriverName());
                    
                
        //bug error fixed 3:26..4/3/2021 it took me like 3 hours just to fix this bug        
        String querydatabase = "CREATE TABLE " +"family" + initialization.gereja + " (self_name TEXT NOT NULL, "
                + "name_second TEXT NOT NULL,"
                + "relationship TEXT NOT NULL"
                + ");";
              //statement.executeQuery("CREATE TABLE words(ID INT PRIMARY KEY NOT NULL, word TEXT NOT NULL, type TEXT NOT NULL, defn TEXT NOT NULL);");
               statement  = conn.createStatement();
                statement.executeQuery(querydatabase);
                System.out.println("Database Has Been Created!");
                // statement.executeQuery("INSERT INTO words (word, type, defn) VALUES (love, verb, Deep pondness)");
            }
           // createDatabaseTable("hello");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally{
            
            try {
                statement.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(c_connection_gereja.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }
    
    public void createDatabaseTable(){
        String querydatabase = "CREATE TABLE " +"family" + initialization.gereja + " (self_name TEXT NOT NULL, "
                + "name_second TEXT NOT NULL,"
                + "relationship TEXT NOT NULL"
                + ");";
         Connection conn = null;
         
           Statement statement = null;
           
        try  {
                conn = DriverManager.getConnection(sqliteServer+fileAbsolutePath);
            
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                statement  = conn.createStatement();
               
                statement.executeUpdate(querydatabase);
                System.out.println("Table Has Been Created!");
                // statement.executeQuery("INSERT INTO words (word, type, defn) VALUES (love, verb, Deep pondness)");
            }
        } catch (SQLException e) {
            System.out.println("creating database mysqli"+e.getMessage());
        }finally{
            
            try {
                statement.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(c_connection_gereja.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }
    
    public String returnfirstname(String second_name){
  
   // String sqls = "INSERT INTO " +database+" (self_name, name_second, relationship) VALUES (?, ?, ?)";     
    String sql = "SELECT self_name FROM family"+initialization.gereja +" WHERE name_second LIKE '%"+ second_name +"%'";
    String firstname = "";
     Connection conn = null;
     Statement stmt = null;
     ResultSet rs = null;
     
          try {
                  conn = DriverManager.getConnection(sqliteServer+fileAbsolutePath);
     stmt = conn.createStatement();
      rs = stmt.executeQuery(sql);
      //Retrieving the result
      rs.next();
      firstname = rs.getString(1);  
            
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
    
    //key event if firstname isn't exist than, we take the orignal Orang into the firstname.
    
    if(firstname == ""){
       firstname = initialization.Orang; 
    }
    
    
    
  return firstname;
    }
    
    
    public void insertDatabaseData(String Tarikh, String Nota ) {
       
        String sql = "INSERT INTO "+"notaanggotagereja" +initialization.first_name+ " (ID,Tarikh, Nota) VALUES (?,?,?)";
 PreparedStatement pstmt =null;
  Connection conn = null;
  
  
  
        try  {
                conn = DriverManager.getConnection(sqliteServer+fileAbsolutePath);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(0, Integer.toString(count_table()));
            pstmt.setString(1, Tarikh);
            pstmt.setString(2, Nota);
           // pstmt.setString(3, type);
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
    
    private int count_table(){
        String sql = "SELECT COUNT(*) FROM notaanggotagereja" +initialization.first_name;
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
    
    
public void insertpeopleData(int id, 
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
 Connection conn = null;
       PreparedStatement pstmt =null;
        try  {
                conn = DriverManager.getConnection(sqliteServer+fileAbsolutePath);
            pstmt= conn.prepareStatement(sql);
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
        }finally{
            
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(c_connection_gereja.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }

private void i_checkiftableexist(){
    try{            
     String check = checkiftableexist("family"+initialization.gereja); 
     
     
     //check the system...25/2/2021
   
        if(check == "false"){
            System.out.println("why it is checking again?");
                         createDatabaseTable();
        }    
                             
                        
                                }catch (SQLException ex) {
         System.out.println("Something is wrong withe checking if the table exist" + ex.getMessage());
        }

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
  
public void insertfamilytable(String name, String second_name, String relationship ) {
//
       String database = "family" +initialization.gereja;
       String sql = "INSERT INTO " +database+" (self_name, name_second, relationship) VALUES (?, ?, ?)";
  //System.out.println(sql+"check dlu betul ka semua" ); 
   Connection conn = null;

             PreparedStatement pstmt = null;

   
   try {
conn = DriverManager.getConnection(sqliteServer+fileAbsolutePath);
           pstmt = conn.prepareStatement(sql);                
            pstmt.setString(1, name);
            pstmt.setString(2, second_name);
            pstmt.setString(3, relationship);
            pstmt.executeUpdate();   
        } catch (SQLException e) {
            System.out.println("fail untuk insert family table?: " + e.getMessage());
        }finally{
            
            try {
                conn.close();
                pstmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(c_connection_gereja.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            }
        } 
        
    }
   

 public void g_alter_table_name(String old_name, String new_name){
     String searchQuery = "ALTER TABLE family"+old_name+" RENAME TO "+"family"+new_name;
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
                System.out.println("Check c_church G_delete Error: " + exp);                
            }finally{
            
            try {
              statement.close();  
                conns.close();
            
            } catch (SQLException ex) {
                Logger.getLogger(c_connection_gereja.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
     
 }

    public int d_countanggota_ketuarumah() {
     
     
     String searchQuery = "SELECT count(*) FROM family"+initialization.gereja+ " WHERE self_name LIKE '%"+ initialization.Orang+"%' AND name_second LIKE '%" + initialization.Orang+"%'";
          // System.out.println("SELECT * FROM anggotagerejaKitobu_Gereja WHERE Nama LIKE '%trylagi%'"); 
          // System.out.println(gereja.Gereja_nama + "Kenapa ba ni");
            //         System.out.println(); 
            int number = 0;
            Connection conn = null;
            
           Statement statement = null;
            ResultSet resultSet = null;

        try { 
               conn = DriverManager.getConnection(sqliteServer+fileAbsolutePath);
               statement  = conn.createStatement();
               resultSet = statement.executeQuery(searchQuery);   
              
               // System.out.println(result+ "apa yang di sini");
                resultSet.next();
                System.out.println("Table laki contains "+resultSet.getInt("count(*)")+" rows");
              //  DefaultTableModel tableModel = (DefaultTableModel)listWords.getModel();
              //  tableModel.setRowCount(0);
            number = resultSet.getInt("count(*)");
              
            }catch (SQLException exp){
                System.out.println("Result count laki Error: " + exp);                
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
    
      public int d_countwife() {
   // searchQuery = searchQuery + gereja.Gereja_nama+ " WHERE Nama LIKE '%"+ Orang+"%'";
       String searchQuery = "SELECT count(*) FROM family" + initialization.gereja + " WHERE self_name LIKE '%"+initialization.Orang+"%' AND relationship LIKE '%isteri%'";
      
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
                System.out.println("Table perempuan contains "+resultSet.getInt("count(*)")+" rows");
              number = resultSet.getInt("count(*)");
            }catch (SQLException exp){
                System.out.println("Check Wife Result Error: " + exp);                
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
    
    public int d_countcheckson() {
   // searchQuery = searchQuery + gereja.Gereja_nama+ " WHERE Nama LIKE '%"+ Orang+"%'";
     
   String searchQuery = "SELECT count(*) FROM family" + initialization.gereja + " WHERE self_name LIKE '%"+initialization.Orang+"%' AND relationship LIKE '%anak%'";
      
     
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
                   System.out.println("Table anak contains "+resultSet.getInt("count(*)")+" rows");
              number = resultSet.getInt("count(*)");
              
            }catch (SQLException exp){
                System.out.println("Result Error: " + exp);                
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
    
 
      //main box entity: anak
public ResultSet c_checkwife() {
   // searchQuery = searchQuery + gereja.Gereja_nama+ " WHERE Nama LIKE '%"+ Orang+"%'";
       String searchQuery = "SELECT * FROM family" + initialization.gereja + " WHERE self_name LIKE '%"+initialization.Orang+"%' AND relationship LIKE '%isteri%'";
      
  
           Connection conn = null;
           Statement statement = null;
           ResultSet resultSet = null;
           try{ 
                   conn = DriverManager.getConnection(sqliteServer+fileAbsolutePath);
                   statement  = conn.createStatement();
                   resultSet = statement.executeQuery(searchQuery);   

                            
            }catch (SQLException exp){
                System.out.println("Check Wife Result Error: " + exp);                
            }finally{
            
            try {
                statement.close();
               resultSet.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(c_connection_gereja.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
            // System.out.println("Connect Has Been Generated!");
        
        return resultSet;
    }

    public Stack c_checkkid() {
   // searchQuery = searchQuery + gereja.Gereja_nama+ " WHERE Nama LIKE '%"+ Orang+"%'";
   // in order that if son picture been clicked it can also display the other family member that is why i put OR 
   //ok here is the problem 12.3.2021 #return double name bu
   //p_samename_problem 1A - solved
   String searchQuerys = "SELECT * FROM family" + initialization.gereja + " WHERE self_name LIKE '%"+initialization.Orang+"%'  AND relationship LIKE '%anak%'";
     // 
            int number = 0;
      Stack<String> stack = new Stack<String>();
           Connection conn = null;
           Statement statement = null;
            ResultSet resultSet = null;
           
           try{ 
                   conn = DriverManager.getConnection(sqliteServer+fileAbsolutePath);
                   statement  = conn.createStatement();
                   resultSet = statement.executeQuery(searchQuerys);   
          
               if(resultSet.isBeforeFirst()){
                    // loop through the result set
                    while (resultSet.next()) {
             
                     stack.add(resultSet.getString("name_second").replaceAll("_", " "));
                  
                 
                      
                    }
                }else{
                   System.out.println("There is no data! in c_connection_family - c_checkhusband");
                }
               
              
            }catch (SQLException exp){
                System.out.println("Check kid Result Error: " + exp);                
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
        
        return stack;
    }

    public Stack c_checkhusband() {

//p_samenameProblem. 12.3.2021
String searchQuery= "SELECT * FROM family"+ initialization.gereja +" WHERE (self_name = '"+initialization.Orang+"' AND relationship = 'leader') OR name_second = '"+initialization.Orang+"'";      
            int number = 0;
            Stack<String> stack = new Stack<String>();
           // ResultSet result = null; 
            Connection conn = null;
            Statement statement = null;
            ResultSet resultSet = null;
      
           try{ 
                   conn = DriverManager.getConnection(sqliteServer+fileAbsolutePath);
                  statement  = conn.createStatement();
               
                  resultSet = statement.executeQuery(searchQuery);   
        
                    if(resultSet.isBeforeFirst()){
                    // loop through the result set
                    while (resultSet.next()) {
                     stack.add(resultSet.getString("self_name").replaceAll("_", " ")); 
                    
                    }
                }else{
                   System.out.println("There is no data! in c_connection_family - c_checkhusband");
                }
            
     
              
            }catch (SQLException exp){
                System.out.println("Check husband Result Error: " + exp);                
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
        
        return stack;
    }

    public String r_recheck(String name) {
 
         String searchQuery = "SELECT * FROM family" + initialization.gereja + " WHERE name_second LIKE '%"+name+"%'";
         String nama = null;
         Connection conn = null;
         Statement statement = null;
         ResultSet resultSet = null;
          
          try{     conn = DriverManager.getConnection(sqliteServer+fileAbsolutePath);
                statement  = conn.createStatement();
                resultSet = statement.executeQuery(searchQuery);   
          
            if (resultSet.next()) {
                       nama = resultSet.getString("self_name");
            } 
   
            }catch (SQLException exp){
                System.out.println("Check recheck Result Error: " + exp.getMessage());                
            }finally{
            
            try {
                resultSet.close();
                statement.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(c_connection_gereja.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
         
         return nama;
    }
    

    
        public void f_d_delete() {
       // String searchQuery = "DELETE FROM anggotagereja"+initialization.gereja+ " WHERE Nama LIKE '%"+initialization.second_name+"%'" ;
  String sql = "DELETE FROM family"+ initialization.gereja+ " WHERE name_second = ?" ;
         

         PreparedStatement pstmt = null;
         Connection conn = null;
          try{
                conn = DriverManager.getConnection(sqliteServer+fileAbsolutePath);
               pstmt = conn.prepareStatement(sql);
            // set the corresponding param
            pstmt.setString(1, initialization.second_name);
            // execute the delete statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("f_d_delete delete function"+e.getMessage());
        }finally{
            
            try {
               pstmt.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(c_connection_gereja.class.getName()).log(Level.SEVERE, null, ex);
            }
        }     
    }
        
        
    public void f_d_delete_main() {
       // String searchQuery = "DELETE FROM anggotagereja"+initialization.gereja+ " WHERE Nama LIKE '%"+initialization.second_name+"%'" ;
  String sql = "DELETE FROM family"+ initialization.gereja+ " WHERE self_name = ? OR name_second = ?" ;
         

         PreparedStatement pstmt = null;
         Connection conn = null;
          try{
                conn = DriverManager.getConnection(sqliteServer+fileAbsolutePath);
               pstmt = conn.prepareStatement(sql);
            // set the corresponding param
            pstmt.setString(1, initialization.second_name);
            pstmt.setString(2, initialization.second_name);
            // execute the delete statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("f_d_delete delete function"+e.getMessage());
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
            Logger.getLogger("something is wrong on o_open" +c_connection_family.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void R_filepath(){
          fileAbsolutePath = file.F_returnString().concat(File.separator+"family.db");
          }
 
}
