/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addcomponent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



/**
 *
 * @author DELL
 */
public abstract class component_factory implements ActionListener {
    
    
 
public  static JPanel addcomponent(JFrame hai) {
       JPanel panel = new JPanel(new BorderLayout());   
     
       panel.setOpaque(true);
       panel.setBackground(Color.CYAN);
       panel.setBounds(400,100,300,400);
       hai.add(panel);
           JLabel label_name = new JLabel("name: ");
           JTextField field_name = new JTextField("Team Awesome!");  
           JLabel label_ic = new JLabel("ic: ");
           JTextField field_ic = new JTextField("Team Awesome!");  
           JLabel label_tarikh_lahir = new JLabel("tarikh_lahir: ");
           JTextField field_tarikh_lahir = new JTextField("Team Awesome!");  
           JLabel label_agama_asal = new JLabel("agama_asal: ");
                  JTextField field_agama_asal = new JTextField("Team Awesome!");  
                    JLabel label_agama_terkini  = new JLabel("agama_terkini: ");
                      JTextField field_agama_terkini = new JTextField("Team Awesome!");  
                          JLabel label_no_tel = new JLabel("no tel: ");
                            JTextField field_no_tel = new JTextField("Team Awesome!"); 
                             JLabel label_tarikh_dibaptis = new JLabel("Tarikh_dibaptiskan: ");
                            JTextField textfield_tarikh_dibaptis = new JTextField("Team Awesome!"); 
                            JLabel label_alamat_terkini = new JLabel("Alamat_terkini: ");
                            JTextField JTextField_alamat_terkini = new JTextField("Team Awesome!"); 
      
                            
                                   JButton b = (new JButton("Submit"));
    
          b.addActionListener(new ActionListener(){  
                        public void actionPerformed(ActionEvent e){  
                          
                             Object myObject[] = {field_name.getText()
                                     ,field_ic.getText()
                                     ,field_tarikh_lahir.getText()
                                     ,field_agama_asal.getText()
                                     ,field_agama_terkini.getText()
                                     ,textfield_tarikh_dibaptis.getText()
                                     ,JTextField_alamat_terkini.getText()
                                     ,field_no_tel.getText()};
                          
                              hai.dispose();
                        }  
                        });   
          

                            
                            
                            
                            
        javax.swing.GroupLayout panel_wifeLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panel_wifeLayout);
        panel_wifeLayout.setHorizontalGroup(
            panel_wifeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_wifeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_wifeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_wifeLayout.createSequentialGroup()
                        .addGroup(panel_wifeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_name)
                            .addComponent(label_ic)
                            .addComponent(label_tarikh_lahir)
                            .addComponent(label_agama_asal)
                            .addComponent(label_agama_terkini)
                            .addComponent(label_tarikh_dibaptis)
                            .addComponent(label_alamat_terkini)
                            .addComponent(label_no_tel)
                          
                        
                        
                        )
                            
                            
                            
                            
                             
                        .addGap(18, 18, 18)
                        .addGroup(panel_wifeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(field_name, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                            .addComponent(field_ic)
                            .addComponent(field_tarikh_lahir)
                            .addComponent(field_agama_asal)
                            .addComponent(field_agama_terkini)
                            .addComponent(field_no_tel)
                            .addComponent(textfield_tarikh_dibaptis)
                                .addComponent(JTextField_alamat_terkini)
                                .addComponent(b)
                          ))
                    
                  )
                .addGap(47, 47, 47))
        );
        
        
        
        
        panel_wifeLayout.setVerticalGroup(
            panel_wifeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_wifeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_wifeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel_wifeLayout.createSequentialGroup()
                        .addGroup(panel_wifeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_name)
                            .addComponent(field_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_wifeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_ic)
                            .addComponent(field_ic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_wifeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_tarikh_lahir)
                            .addComponent(field_tarikh_lahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_wifeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_agama_asal)
                            .addComponent(field_agama_asal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(panel_wifeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_agama_terkini)
                            .addComponent(field_agama_terkini, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_wifeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_tarikh_dibaptis)
                            .addComponent(textfield_tarikh_dibaptis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_wifeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_alamat_terkini)
                            .addComponent(JTextField_alamat_terkini, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_wifeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_no_tel)
                            .addComponent(field_no_tel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)  
                          .addGroup(panel_wifeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(b, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                         
                            
                       )
                   )
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addContainerGap(14, Short.MAX_VALUE))
                
        );
        
        
          
        
      //    hai.add(b);
                       
return panel;  
}

private void addbutton(JFrame hai) {
    
     JButton b = (new JButton(""));
          b.setName("Submit");
          try{
          b.addActionListener(new ActionListener(){  
                        public void actionPerformed(ActionEvent e){  
                          
                          
                            
                            
                        }  
                        });
          }catch (Exception ex){
            System.out.println("Connection Error: " + ex);
        }
    
    
}


    
}
