/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c_connection;

import java.net.InetSocketAddress;
import java.net.Socket;

/**
 *
 * @author DELL
 */
public class g_testconnection {
    public boolean checkInternetConnection()
{
     boolean status = false;
     Socket sock = new Socket();
     InetSocketAddress address = new InetSocketAddress("www.google.com", 80);

     try
     {
        sock.connect(address, 3000);
        if(sock.isConnected()) status = true;
     }
     catch(Exception e)
     {
         status = false;       
     }
     finally
     {
        try
         {
            sock.close();
         }
         catch(Exception e){}
     }

     return status;
}
}
