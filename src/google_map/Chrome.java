/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package google_map;

import addcomponent.button_tambah;
import initialization.initialization;
import static initialization.initialization.c_connect;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.KeyboardFocusManager;
import java.net.URL;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import org.cef.CefApp;
import org.cef.CefClient;
import org.cef.CefSettings;
import org.cef.browser.CefBrowser;
import org.cef.handler.CefAppHandlerAdapter;
import org.cef.handler.CefKeyboardHandlerAdapter;


/**
 *
 * @author DELL
 */
public class Chrome {
    
    public static JPanel jpbrowser = new JPanel(new BorderLayout());  
        public static JPanel jpbrowsers = new JPanel(new BorderLayout());  
    public static CefBrowser browser; 
        public static CefBrowser browsers; 


public Chrome(){
            display_map();    
            //display coordinate
                c_connect.f_outputmap();
           } 
            
 private void display_map(){

           URL url = this.getClass().getResource("index.html");
           
//webEngine.reload();
    }
       
static String f_map_decisionmakeover() {
    c_connect.R_filepath();
     c_connect.f_outputmap();
    String url = "";
      if(initialization.i_coordinate.isEmpty()){
    url = "https://www.google.com.my/maps/@4.140634,109.6181485,6z";
   
    }else{
    String[] cooridnate = initialization.i_coordinate.split(",");
    url = "http://maps.google.com/maps?&z=8&mrt=all&t=m&q="+cooridnate[1]+"+"+cooridnate[0];
    }
    return url;
}




public static void f_public_initialize_createbrowser(){
    
        
        boolean useOSR = false;
       CefApp.addAppHandler(new CefAppHandlerAdapter(null) {
            @Override
            public void stateHasChanged(CefApp.CefAppState state) {
                if (state == CefApp.CefAppState.TERMINATED) System.exit(0);
            }
        });

        final CefSettings settings = new CefSettings();
        settings.windowless_rendering_enabled = useOSR;

        final CefApp cefApp = CefApp.getInstance(settings);

        final CefClient client = cefApp.createClient();
        
        //very important for keyboard handler 20.4.2021
client.addKeyboardHandler(new CefKeyboardHandlerAdapter() {
   @Override
   public boolean onKeyEvent(CefBrowser thisBrowserInstance, CefKeyEvent event) {
      thisBrowserInstance.setFocus(false);
      KeyboardFocusManager.getCurrentKeyboardFocusManager().clearGlobalFocusOwner();
      initialization.jFrame1.requestFocus();
      return false;
   }
});
        
    if(initialization.g_connection == true){
           
        browser = client.createBrowser(f_map_decisionmakeover(), useOSR, useOSR);
        browsers  = client.createBrowser(f_map_decisionmakeover(), useOSR, useOSR);
        }else{
        browser = client.createBrowser("http://localhost:8080", useOSR, useOSR);
        browsers  = client.createBrowser("http://localhost:8080", useOSR, useOSR);
        }
           
        final Component browserUI = browser.getUIComponent();
        final Component browserUIs = browsers.getUIComponent();
        
        jpbrowsers.add(browserUIs,BorderLayout.CENTER);
        jpbrowser.add(browserUI, BorderLayout.CENTER);    
}

public static void t_swing_worker(){

    //finally, 29/3/2021...man i have been doing researching over this thing about 5 hours and extra 3 hours...just finally i could know that this tings actually does existss amennn
SwingWorker sw1 = new SwingWorker() 
        {
  
            @Override
            protected String doInBackground() throws Exception 
            {
                String hello = "";
            f_public_initialize_createbrowser();
             return hello;   
            }
            @Override
        
            protected void done() {
        initialization.h_indicator = true;
    }


         
           
        };
          
        // executes the swingworker on worker thread
        sw1.execute(); 
        
}

}
       


