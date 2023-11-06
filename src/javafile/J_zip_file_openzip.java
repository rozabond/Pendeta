package javafile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Stack;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
 
/**
 * This utility extracts files and directories of a standard zip file to
 * a destination directory.
 * @author www.codejava.net
 *
 */
public class J_zip_file_openzip {
    /**
     * Size of the buffer to read/write data
     */
    private static final int BUFFER_SIZE = 4096;
    byte[] buffer = new byte[1024];
    /**
     * Extracts a zip file specified by the zipFilePath to a directory specified by
     * destDirectory (will be created if does not exists)
     * @param zipFilePath
     * @param destDirectory
     * @throws IOException
     */
    public Stack unzip(String zipFilePath, String destDirectory) throws IOException {
        Stack<String> stack = new Stack<String>();
        File destDir = new File(destDirectory);
        File newFile = null;
        if (!destDir.exists()) {
            destDir.mkdir();
        }
        ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath));
        ZipEntry entry = zipIn.getNextEntry();
        // iterates over entries in the zip file
        while (entry != null) {
           // String filePath = destDirectory + File.separator + entry.getName();
    
            newFile = new File(destDir, entry.getName());
        //create sub directories
           
            //newFile.getParentFile().mkdirs();
            System.out.println(newFile.getParentFile().getName());
        
            if(!"image".equals(newFile.getParentFile().getName()) && !stack.contains(newFile.getParentFile().getName()))
            {
                stack.add(newFile.getParentFile().getName());
            }
        
            zipIn.closeEntry();
            entry = zipIn.getNextEntry();
        }
       
        zipIn.close();
        return stack;
    }
    /**
     * Extracts a zip entry (file entry)
     * @param zipIn
     * @param filePath
     * @throws IOException
     */
    private void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        byte[] bytesIn = new byte[BUFFER_SIZE];
        int read = 0;
        while ((read = zipIn.read(bytesIn)) != -1) {
            bos.write(bytesIn, 0, read);
        }
        bos.close();
    }
}