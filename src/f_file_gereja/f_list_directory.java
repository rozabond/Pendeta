/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f_file_gereja;

import static initialization.initialization.getFilePath;
import java.io.File;
import java.util.Stack;

/**
 *
 * @author DELL
 */
public class f_list_directory {
      
    public Stack f_fileshow(){
           // Creates an array in which we will store the names of files and directories
        String[] pathnames;
            Stack<String> STACK = new Stack<String>();
        // Creates a new File instance by converting the given pathname string
        // into an abstract pathname
        File f = new File(getFilePath+"//src//g_file_gereja");

        // Populates the array with names of files and directories
        pathnames = f.list();

        // For each pathname in the pathnames array
        for (String pathname : pathnames) {
            // Print the names of files and directories
           STACK.add(pathname);
        }
    return STACK;
    }
}
