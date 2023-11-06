package google_map;

import java.io.File;
import java.net.URL;
import javafx.beans.value.ChangeListener;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.scene.web.WebEngine;
 
public class map extends Application
{
    public static void main(String[] args) 
    {
        Application.launch(args);
    }
     
    public void start(JFXPanel fxPanel) 
    {
        // Create the WebView
        WebView webView = new WebView();
         
        // Disable the context menu
        webView.setContextMenuEnabled(false);
         
        // Increase the text font size by 20%
        webView.setFontScale(1.20);
         
        // Set the Zoom 20%
        webView.setZoom(1.20);
         
        // Set font smoothing type to GRAY
        webView.setFontSmoothingType(FontSmoothingType.GRAY);
         
        // Create the WebEngine
        final WebEngine webEngine = webView.getEngine();
        // Load the StartPage
           //String getFilePath = new File("").getAbsolutePath();
            
           // String fileAbsolutePath = getFilePath.concat("\\src\\database\\index.html");
           //finally, 26/10/2020...i get the capabilities to just finished this map application.. which is vital for the psstor
           //to being able to used this API.
        URL url = this.getClass().getResource("index.html");
        System.out.println(url);
        webEngine.load(url.toString());
        //webEngine.load(f.toURI().toString());
        
        
        
       // webEngine.load("https://graphhopper.com/maps/");
         
        // Update the stage title when a new web page title is available        
        webEngine.titleProperty().addListener(new ChangeListener<String>()
        {
            public void changed(ObservableValue<? extends String> ov,
                    final String oldvalue, final String newvalue) 
            {
               // stage.setTitle(newvalue);
            }
        });
         
        // Create the VBox
        VBox root = new VBox();
        // Add the Children to the VBox
        root.getChildren().add(webView);
 
        // Set the Style-properties of the VBox
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");
 
        // Create the Scene
        Scene scene = new Scene(root);
        fxPanel.setScene(scene);
      
        
        // Add  the Scene to the Stage
    
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
      public void on_tv(JFXPanel fxPanel){
        WebView webView = new WebView();
    fxPanel.setScene(new Scene(webView));
     URL url = this.getClass().getResource("java/index.html");
    webView.getEngine().load(url.toString());
         
        // Disable the context menu
        webView.setContextMenuEnabled(false);
         
        // Increase the text font size by 20%
        webView.setFontScale(1.20);
         
        // Set the Zoom 20%
        webView.setZoom(1.20);
         
        // Set font smoothing type to GRAY
        webView.setFontSmoothingType(FontSmoothingType.GRAY);
         
        // Create the WebEngine
       
        // Load the StartPage
           //String getFilePath = new File("").getAbsolutePath();
            
           // String fileAbsolutePath = getFilePath.concat("\\src\\database\\index.html");
           //finally, 26/10/2020...i get the capabilities to just finished this map application.. which is vital for the psstor
           //to being able to used this API.          
    }
}