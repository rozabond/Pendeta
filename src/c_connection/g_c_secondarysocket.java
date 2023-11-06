package c_connection;

import google_map.Chrome;
import initialization.initialization;
import java.awt.BorderLayout;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingWorker;



public class g_c_secondarysocket {

public void t_swing_worker(){

    //finally, 29/3/2021...man i have been doing researching over this thing about 5 hours and extra 3 hours...just finally i could know that this tings actually does existss amennn
SwingWorker sw1 = new SwingWorker() 
        {
  
            @Override
            protected String doInBackground() throws Exception 
            {
                String hello = "";
                g_onclick_java();
             return hello;   
            }
  
         
           
        };
          
        // executes the swingworker on worker thread
        sw1.execute(); 
        
}

public void t_swing_worker_socket(){

    //finally, 29/3/2021...man i have been doing researching over this thing about 5 hours and extra 3 hours...just finally i could know that this tings actually does existss amennn
SwingWorker sw1 = new SwingWorker() 
        {
  
            @Override
            protected String doInBackground() throws Exception 
            {
                String hello = "";
          g_opensocket();
             return hello;   
            }
  
         
           
        };
          
        // executes the swingworker on worker thread
        sw1.execute(); 
        
}
   



    public void g_onclick_java() {
    try {
        /*   ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        // read script file
        try {
        
        engine.eval(Files.newBufferedReader(Paths.get("C:\\Users\\DELL\\Desktop\\Work\\System_Pastor\\java_tile_downloader\\jTileDownloader\\g_c_connectionoutput.js"), StandardCharsets.UTF_8));
        
        Invocable inv = (Invocable) engine;
        
        // call function from script file
        inv.invokeFunction("g_c_connectionoutput", "param");
        } catch (ScriptException ex) {
        Logger.getLogger(g_c_secondarysocket.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
        Logger.getLogger(g_c_secondarysocket.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
        Logger.getLogger(g_c_secondarysocket.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        unit_testing();
    } catch (Exception ex) {
        Logger.getLogger(g_c_secondarysocket.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    public static void unit_testing() throws Exception {
        File file = new File("C:\\Users\\DELL\\Desktop\\Work\\System_Pastor\\java_tile_downloader\\jTileDownloader\\g_c_connectionoutput.html");
				
        URL myUrl = file.toURI().toURL();
        System.out.println("can i ge the conclusion" + myUrl);
        URLConnection conn = myUrl.openConnection();
        Path sourceFile = Paths.get(file.toURI());
       // Chrome.browser.loadURL(sourceFile);
       // initialization.pane_container.add(Chrome.jpbrowser,BorderLayout.CENTER);
        System.out.println("can i ge the conclusion");
    } 
    
    
    
     public void g_opensocket() throws Exception {
        ServerSocket welcomeSocket = new ServerSocket(8081);
        String cars = null;
      boolean done = false;
     while(!done) {
            Socket connectionSocket = welcomeSocket.accept();
            InputStreamReader inFromClient = new InputStreamReader(connectionSocket.getInputStream());
            
            DataOutputStream dataOut = new DataOutputStream(connectionSocket.getOutputStream());
            
            
            int c = 0;
            System.out.println("-------------------------");
            System.out.println("Connection open");
            while(true) {
                c = inFromClient.read();
                cars = cars + (char)c;
                System.out.print((char)c);
            
                if(!inFromClient.ready()) {
                    break;
                }
            }
            
            
            
            
            dataOut.writeUTF("This is the third type of message (Part 1).");
	    dataOut.flush();
            
            System.out.println("-------------------------");
            System.out.println(cars);
            initialization.i_coordinate = cars;
            
    }
     }
}