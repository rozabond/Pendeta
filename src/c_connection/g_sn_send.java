/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c_connection;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class g_sn_send {
    
      Socket clientSocket = null;  
    public g_sn_send(){
        
        String hostname = "localhost";
        int port = 8081;
        
        try {
            clientSocket = new Socket(hostname, port);
            DataOutputStream dOut = new DataOutputStream(clientSocket.getOutputStream());
            dOut.writeUTF("This is the third type of message (Part 2).");
            dOut.flush(); // Send off the data
            dOut.close();  
            clientSocket.close();
            
        } catch (IOException ex) {
            Logger.getLogger(g_sn_send.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
