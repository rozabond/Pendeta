/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f_file_gereja;

import initialization.initialization;
import static initialization.initialization.getFilePath;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
/**
 *
 * @author DELL
 */
public class f_file_gereja {


  public static JLabel l = new JLabel(); 
  public JPanel g_panel = new JPanel(new BorderLayout());
  public JButton g_button = new JButton("save");
  

  int g_panel_width = initialization.s_panel_width;
  int g_panel_height = initialization.s_panel_height /2;
  
  public f_file_gereja(){
      i_initi_panel();
      i_integration();
      g_try_open();
  }
  
    private void i_initi_panel(){
        g_panel.setPreferredSize(new Dimension(g_panel_width,g_panel_height));
        g_panel.setBounds(0, 0,g_panel_width, g_panel_height);
        g_panel.add(g_button,BorderLayout.PAGE_END);
    }
  
    private void i_integration(){
        f_file_gereja_A file_display = new f_file_gereja_A();
        g_panel.add(file_display.f_file_panel_return(),BorderLayout.CENTER);
        g_panel.repaint();
        g_panel.revalidate();
    }
    
    public void g_file_open(){
   //SampleJFileChooser hq  = new  SampleJFileChooser();
   JFileChooser choose = new JFileChooser(FileSystemView.getFileSystemView());  
        
   
    }
    
    public JPanel r_return_gpanel(){
        return g_panel;
    }
    
    
    public void g_try_open(){
        File newPath;      
     
        // if the user presses the save button show the save dialog 
        
        g_button.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
        String com = e.getActionCommand(); 
  
        if (com.equals("save")) { 
            // create an object of JFileChooser class 
            JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 
            FileFilter filter = new FileNameExtensionFilter("MP3 File","mp3");
        FileFilter docx = new FileNameExtensionFilter("MS Word file(.docx)", "docx");
        FileFilter doc = new FileNameExtensionFilter("MS Word file(.doc)", "doc");
        FileFilter pdf = new FileNameExtensionFilter("Pdf file(.pdf)", "pdf");
        j.addChoosableFileFilter(docx);
        j.addChoosableFileFilter(doc);
        j.addChoosableFileFilter(pdf);   
        j.addChoosableFileFilter(filter);
// invoke the showsSaveDialog function to show the save dialog 
            int r = j.showSaveDialog(null); 
            
            // if the user selects a file 
            if (r == JFileChooser.APPROVE_OPTION)
            { 
                // set the label to the path of the selected file 
               try{
                l.setText(j.getSelectedFile().getAbsolutePath()); 
                File file = j.getSelectedFile();
                Path path = Paths.get(j.getSelectedFile().getAbsolutePath());
                String getFilePath = new File("").getAbsolutePath();
                //16.3.2021 file finished and debugging correctted
                Path output = Paths.get(getFilePath.concat("\\src\\g_file_gereja\\" + file.getName()));
                Files.move(path,output);
               }catch(IOException exp){
                System.out.println("Getting file error" + exp.getMessage());
       }
            } 
            // if the user cancelled the operation 
            else
                l.setText("the user cancelled the operation"); 
        } 
  
        // if the user presses the open dialog show the open dialog 
        else { 
            // create an object of JFileChooser class 
            JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 
  
            // invoke the showsOpenDialog function to show the save dialog 
            int r = j.showOpenDialog(null); 
  
            // if the user selects a file 
            if (r == JFileChooser.APPROVE_OPTION) 
  
            { 
                // set the label to the path of the selected file 
                l.setText(j.getSelectedFile().getAbsolutePath()); 
            } 
            // if the user cancelled the operation 
            else
                l.setText("the user cancelled the operation"); 
        }
    }});     
    } 
    
}

