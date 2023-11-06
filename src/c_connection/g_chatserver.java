/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c_connection;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.SwingWorker;

/**
 *
 * @author DELL
 */
public class g_chatserver {
    
    public void t_swing_worker(){

    //finally, 29/3/2021...man i have been doing researching over this thing about 5 hours and extra 3 hours...just finally i could know that this tings actually does existss amennn
SwingWorker sw1 = new SwingWorker() 
        {
  
            @Override
            protected String doInBackground() throws Exception 
            {
                String hello = "";
          g_f_chatserver();
             return hello;   
            }
  
         
           
        };
          
        // executes the swingworker on worker thread
        sw1.execute(); 
        
}
    
    public void g_f_chatserver() throws InterruptedException, IOException{
          int port = 8081; // 843 flash policy port
   
    ChatServer s = new ChatServer(port);
    s.start();
    System.out.println("ChatServer started on port: " + s.getPort());

    BufferedReader sysin = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      String in = sysin.readLine();
      s.broadcast(in);
      if (in.equals("exit")) {
        s.stop(1000);
        break;
      }
    }
    }
}
