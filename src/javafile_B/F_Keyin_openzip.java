package javafile_B;

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
public class F_Keyin_openzip {
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
    public Stack unzip(String zipFilePath, String destDirectory,String New_name,String Old_name) throws IOException {
        Stack<String> stack = new Stack<String>();
        File destDir = new File(destDirectory);
        File newFile = null;
        if (!destDir.exists()) {
            destDir.mkdir();
        }
        
       // System.out.println(New_name+"apani new");
        ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath));
        ZipEntry entry ;
         // iterates over entries in the zip file
        while ((entry = zipIn.getNextEntry()) != null) {
            //System.out.println(entry.getName());
            newFile = new File(destDir, entry.getName());
            //System.out.println(newFile.getParentFile().getName()+Old_name);
            //System.out.println(newFile.getParentFile().getParentFile()+"oktry");
            
            //24.9.2021 One of the finest method that required sacrifice actually
             System.out.println(entry.getName() + "Zone A");
          
            if(newFile.getParentFile().getName().equals(Old_name) || newFile.getParentFile().getParentFile().getName().equals(Old_name)) {
           // String filePath = destDirectory + File.separator + entry.getName();
            newFile = new File(destDir, New_name+File.separator+"image");
        //create sub directories
             newFile.mkdirs();
             System.out.println(entry.getName());
          
             String filePath = destDir + File.separator + entry.getName().replaceFirst(Old_name,New_name).replace("/",File.separator);
             System.out.println(filePath);
           if(!entry.isDirectory()) {
               
               extractFile(zipIn, filePath);
				/*FileOutputStream fos = new FileOutputStream(filePath);
				int len;
				while ((len = zipIn.read(buffer)) >0){
					fos.write(buffer,0,len);
				}
				fos.close();*/
			}
			else {
            //stack.add(newFile.getParentFile().getName());
            File dir = new File(filePath);
				dir.mkdir();
			}
            zipIn.closeEntry();
       
        }
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