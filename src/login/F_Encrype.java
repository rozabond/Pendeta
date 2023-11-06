package login;
 
import b_file_function.b_file_info;
import java.io.File;
 
/**
 * A tester for the CryptoUtils class.
 * @author www.codejava.net
 *
 */
public class F_Encrype {
        b_file_info encrype = new b_file_info();
       String key = "seventhdayadvent";
        public F_Encrype() {
   F_decrype_church();
        }
        
          public void F_decrype_church(){
        File encryptedFile = new File(encrype.F_returnString_Church()+"\\info.db");
          if(encryptedFile.exists()){
                   File decryptedFile = new File(encrype.F_returnString_Church()+"\\info.db");
   
        try {
            //F_Cytorype.encrypt(key, inputFile, encryptedFile);
           F_Cytorype.decrypt(key, encryptedFile, decryptedFile);
        } catch (CryptoEncryption ex) {
            System.out.println("Error 1: f_Encryption"+ex.getMessage());
            ex.printStackTrace();
        } 
          }
    }
          
           public void F_encrype_church(){
         File inputFile = new File(encrype.F_returnString_Church()+"\\info.db");
        if(inputFile.exists()){
          File encryptedFile = new File(encrype.F_returnString_Church()+"\\info.db");
          try {
            F_Cytorype.encrypt(key, inputFile, encryptedFile);
           //F_Cytorype.decrypt(key, encryptedFile, decryptedFile);
        } catch (CryptoEncryption ex) {
            System.out.println("Error 1: f_Encryption"+ex.getMessage());
            ex.printStackTrace();
        }   
        }
    }
    

}   