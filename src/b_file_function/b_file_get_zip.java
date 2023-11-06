/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b_file_function;

import java.io.File;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author DELL
 */
public class b_file_get_zip {
    
    public b_file_get_zip(){
       
    }
    
 public  String F_returnString_Church(){
    return FileSystemView.getFileSystemView().getDefaultDirectory().getPath()+File.separator+"TanyaPendeta"+File.separator+"Church";
}

    public String[] F_returnFileexistance(){
            File fs = new File(F_returnString_Church().concat(File.separator));
            String[] pathnames = fs.list();
            return pathnames;
}
}
