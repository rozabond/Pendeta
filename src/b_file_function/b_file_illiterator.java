/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b_file_function;

import static b_file_function.b_file_encryption_cannidate.stack;
import java.io.File;
import java.util.Stack;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author DELL
 */
public class b_file_illiterator {
    
    
public static String F_returnString_Church(){
    return FileSystemView.getFileSystemView().getDefaultDirectory().getPath()+File.separator+"TanyaPendeta"+File.separator+"Church";
}
    
    public String[] G_folder_illeterator_church(){

           String[] arr = new String[stack.size()];
          arr = stack.toArray(arr);
            
            return arr;
    }
            }
