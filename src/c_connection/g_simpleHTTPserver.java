/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c_connection;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author DELL
 */
public class g_simpleHTTPserver {
    public g_simpleHTTPserver() throws Exception{
      //  final ServerSocket server = new ServerSocket(8080); System.out.println("Listening for connection on port 8080 ....");
      
        while (true) { 
          try (ServerSocket serverSocket = new ServerSocket(8080)) {
            while (true) {
                try (Socket client = serverSocket.accept()) {
                    handleClient(client);
                }
            }
        }
        
        }
 /*while (true){ // spin forever }
    final Socket client = server.accept();
    InputStreamReader isr = new InputStreamReader(client.getInputStream()); 
    BufferedReader reader = new BufferedReader(isr); 
    String line = reader.readLine(); 
    while (!line.isEmpty()) 
    { System.out.println(line); line = reader.readLine(); }
      
  try (Socket socket = server.accept()) 
  { Date today = new Date(); 
  String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today; 
  socket.getOutputStream().write(httpResponse.getBytes("UTF-8")); }
   }*/
}
    
     private static void handleClient(Socket client) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));

        StringBuilder requestBuilder = new StringBuilder();
        String line;
        while (!(line = br.readLine()).isEmpty()) {
            requestBuilder.append(line + "\r\n");
        }

        String request = requestBuilder.toString();
        String[] requestsLines = request.split("\r\n");
        String[] requestLine = requestsLines[0].split(" ");
        String method = requestLine[0];
        String path = requestLine[1];
        String version = requestLine[2];
        String host = requestsLines[1].split(" ")[1];

        List<String> headers = new ArrayList<>();
        for (int h = 2; h < requestsLines.length; h++) {
            String header = requestsLines[h];
            headers.add(header);
        }

        String accessLog = String.format("Client %s, method %s, path %s, version %s, host %s, headers %s",
                client.toString(), method, path, version, host, headers.toString());
        System.out.println(accessLog);


        Path filePath = getFilePath(path);
        if (Files.exists(filePath)) {
            // file exist
            String contentType = guessContentType(filePath);
            sendResponse(client, "200 OK", contentType, Files.readAllBytes(filePath));
        } else {
            // 404
            byte[] notFoundContent = "<h1>Not found :(</h1>".getBytes();
            sendResponse(client, "404 Not Found", "text/html", notFoundContent);
        }

    }
    
     
     
    private static String guessContentType(Path filePath) throws IOException {
        return Files.probeContentType(filePath);
    }
    
    private static Path getFilePath(String path) {

       String getFilePath = new File("").getAbsolutePath();
       String fileAbsolutePath = "";
   
       fileAbsolutePath = getFilePath.concat("\\src\\index.html");
           
        if ("/".equals(path)) {
            path = fileAbsolutePath;
        }

        return Paths.get("", path);
    }
    
    private static void sendResponse(Socket client, String status, String contentType, byte[] content) throws IOException {
        OutputStream clientOutput = client.getOutputStream();
        clientOutput.write(("HTTP/1.1 \r\n" + status).getBytes());
        clientOutput.write(("ContentType: " + contentType + "\r\n").getBytes());
        clientOutput.write("\r\n".getBytes());
        clientOutput.write(content);
        clientOutput.write("\r\n\r\n".getBytes());
        clientOutput.flush();
        client.close();
    }

}
