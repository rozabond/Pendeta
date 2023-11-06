/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package google_map;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class c_connection_localhost {
    
    public static void connectToServer() {
    try(ServerSocket serverSocket = new ServerSocket(9991)) {
        Socket connectionSocket = serverSocket.accept();
        
        InputStream inputToServer = connectionSocket.getInputStream();
        OutputStream outputFromServer = connectionSocket.getOutputStream();
        Scanner scanner = new Scanner(inputToServer, "UTF-8");
        PrintWriter serverPrintOut = new PrintWriter(new OutputStreamWriter(outputFromServer, "UTF-8"), true);

serverPrintOut.println("Hello! Enter Peace to exit.");
}catch(IOException e){
    System.out.println("something wrong with connection" + e.getMessage());
     e.printStackTrace();
}
    }
    
   public void connection_1() throws IOException {

        int port = 9000;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        System.out.println("server started at " + port);
      //  server.createContext("/", new Start());
        server.setExecutor(null);
        server.start();
}
    
     public void handle(HttpExchange he) throws IOException {
        byte[] encoded = Files.readAllBytes(
                Paths.get("Views/start.html"));
        he.sendResponseHeaders(200, encoded.length);
        he.getResponseHeaders().set("Content-Type", "text/html");
        OutputStream os = he.getResponseBody();
        os.write(encoded);
        os.close();
    }
    
    
}