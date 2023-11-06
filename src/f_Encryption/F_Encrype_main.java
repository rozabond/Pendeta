package login;
 
import b_file_function.b_file_encryption_cannidate;
import b_file_function.b_file_illiterator;
import b_file_function.b_file_info;
import initialization.initialization;
import java.io.File;
 
/**
 * A tester for the CryptoUtils class.
 * @author www.codejava.net
 *
 */
public class F_Encrype_main {
        b_file_info encrype = new b_file_info();
      String key = "seventhdayadvent";
        public F_Encrype_main() {
      
        }
        
    public void F_decrype_church(String file){
        File encryptedFile = new File(encrype.F_returnString()+File.separator+file);
        if(encryptedFile.exists()){
                   File decryptedFile = new File(encrype.F_returnString()+File.separator+file);   
        try {
            //F_Cytorype.encrypt(key, inputFile, encryptedFile);
           F_Cytorype.decrypt(key, encryptedFile, decryptedFile);
        } catch (CryptoEncryption ex) {
            System.out.println("Error 1: f_Encryption"+ex.getMessage());
            ex.printStackTrace();
        } 
          }
    }
    
       public void F_encrype_church(String file){
        File inputFile = new File(encrype.F_returnString()+File.separator+file);
        
        if(inputFile.exists()){
        File encryptedFile = new File(encrype.F_returnString()+"\\"+file);
          try {
            F_Cytorype.encrypt(key, inputFile, encryptedFile);
           //F_Cytorype.decrypt(key, encryptedFile, decryptedFile);
        } catch (CryptoEncryption ex) {
            System.out.println("Error 1: f_Encryption"+ex.getMessage());
            ex.printStackTrace();
        } 
           }
        //to ensure that whenever this function is call, everything tersu kena settle or buang
        b_file_encryption_cannidate remove = new b_file_encryption_cannidate();
        remove.R_stack().removeAllElements();
    }
        
        public void F_illiterating_encrypt(){
            b_file_illiterator file = new b_file_illiterator();
           String[] pathnames = {"church.db","family.db","info_bank.db","map.db","description.txt"};
            
            for (String i : file.G_folder_illeterator_church()) {
               initialization.gereja = i;
                 for (String z : pathnames) {
                      F_encrype_church(z);
            }
            }
         
        }
     
           public void F_illiterating_decrypt(){
           
           String[] pathnames = {"church.db","family.db","info_bank.db","map.db","description.txt"};

           
                 for (String z : pathnames) {
                      F_decrype_church(z);
            }
        }
        
        }