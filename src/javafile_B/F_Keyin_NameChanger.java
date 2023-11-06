/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafile_B;

import g_button_main_folder.f_main_AB;
import java.util.Iterator;
import java.util.Stack;

/**
 *
 * @author DELL
 */
public class F_Keyin_NameChanger {
    F_keyin_NameChanger_gui keyin = new F_keyin_NameChanger_gui();
    public F_Keyin_NameChanger(Stack stk){
        F_Keyin_NameChanger_A(stk);
    }
    
    private void F_Keyin_NameChanger_A(Stack stk){
        // tambah_keluarga anak = new tambah_keluarga();
    
    
                       Iterator<String> itr = stk.iterator();
     
                       while (itr.hasNext()){
                        String hai = itr.next();
                        f_main_AB.box.add(keyin.F_keyin_NameChanger_gui_A(hai));
                        
    }
                       F_reititerate();
    }
    
    private void F_reititerate(){
        f_main_AB.box.repaint();
        f_main_AB.box.revalidate();
    }
    
}
