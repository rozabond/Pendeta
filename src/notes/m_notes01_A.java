/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notes;

import connection.c_connection_notes;
import css.scrollbar;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import initialization.initialization;
import java.awt.Graphics;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author DELL
 */
public class m_notes01_A {
    
      int container;
    
    public JPanel notes01_A = new JPanel(new BorderLayout()){
    protected void paintComponent(Graphics g)
    {
        g.setColor( getBackground() );
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
};
    
    public JPanel notes01_A_A_P = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 20)){
    protected void paintComponent(Graphics g)
    {
        g.setColor( getBackground() );
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
};
    
    public JLabel notes01_A_A_J = new JLabel("Lawatan");
      DefaultTableModel daDefaultTableModel = new DefaultTableModel(0, 0);
        
       
    
    JButton jp = new JButton();  
    int heigth_m_notes01_A = initialization.e_containerHeight-375;
    
    
    public m_notes01_A() {
        initialized_notes01_A(initialization.e_containerWidth,heigth_m_notes01_A);
        initializaed_notes01_A_A();
        initialized_notes01_A_A_P(initialization.e_containerWidth,50);
        initialized_notes01_A_A_J();
        notes01_A();
        d_notes01_A_checkmaximumamount(container);
        
    }
    
    public JPanel return_notes01_A(){
        return notes01_A;
    }
    
    private void notes01_A(){
        notes01_A.add(notes01_A_A_P,BorderLayout.PAGE_START);
        notes01_A.add(notes01_A_B(initialization.e_containerWidth,initialization.e_containerHeight),BorderLayout.CENTER);
        
    }
     
    private JPanel initialized_notes01_A(int width, int height) {
        notes01_A.setPreferredSize(new Dimension(width,height));
        notes01_A.setBounds(0,0,width,height);
        notes01_A.setOpaque(true);
        notes01_A.setBackground( new Color(0, 0, 0,1) ); 
        return notes01_A;
   }
    
    
    private JPanel initialized_notes01_A_A_P(int width, int height) {
        notes01_A_A_P.setPreferredSize(new Dimension(width,height));
        notes01_A_A_P.setBounds(0,0,width,height);
        notes01_A_A_P.setOpaque(false);
        notes01_A_A_P.setBackground( new Color(0, 0, 0,1) ); 
        return notes01_A_A_P;
   }
    
    private void initialized_notes01_A_A_J() {
        notes01_A_A_J.setForeground(Color.WHITE);
   }
    
    
    private JPanel initializaed_notes01_A_A(){
        notes01_A_A_P.add(notes01_A_A_J);
        return notes01_A_A_P;
    }
    
    private JScrollPane notes01_A_B(int width,int height) {            
        
        String[][] data = { 
            { "Kundan Kumar Jha", "CSE" }, 
            { "Anand Jha", "IT" } 
        }; 
        // Column Names 
        String[] columnNames = { "Name", "NOTES" }; 
        JTable listWords = new javax.swing.JTable();
      
        listWords.setBounds(0, 0, width, height); 
  
        daDefaultTableModel.setColumnIdentifiers(columnNames);
        daDefaultTableModel.addRow(new Object[] {"NAME","NOTES"});
        d_display_row();
                         
            
        listWords.setModel(daDefaultTableModel);
        final scrollbar jScrollPane1 = new scrollbar(
        listWords,
        ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
        
        //jScrollPane1.add(button_map.m_returnawt());
        jScrollPane1.setPreferredSize(new Dimension(width,height-20));
        jScrollPane1.setBounds(0, 0, width,height);
        jScrollPane1.getViewport().setBackground(new Color(255,255,255,10));
        
        
        
listWords.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseClicked(java.awt.event.MouseEvent evt) {
       int getTableRow = listWords.getSelectedRow();
       initialization.notes01_B_A_ID = getTableRow -1;
       String selectedWordStr = listWords.getValueAt(getTableRow, 0).toString();
       String selectedWordTypeStr = listWords.getValueAt(getTableRow, 1).toString();
       
       initialization.notes01_B_A_T.setText(selectedWordStr);
       initialization.notes01_B_B_T.setText(selectedWordTypeStr);
      // System.out.println(selectedWordStr + selectedWordTypeStr);
    
    }
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        //listWordsMouseEntered(evt);
    }
});


return jScrollPane1;
    }
    
public void d_display_row() {
   c_connection_notes count = new c_connection_notes();
  container = count.count_table();
    if (container > 0){
            d_a_display_row();
    }else{
        //tambah block pergi notes
        d_checknotesamount(count.count_table());   
    }
}

private void d_a_display_row() {
    c_connection_notes orang = new c_connection_notes();
        //blum jadi
        int number = 0;
        
 
        ArrayList<Object> resultSet = orang.g_display_anggota(); 
          Iterator<Object> itr = resultSet.iterator();
     
                       while (itr.hasNext()){
        
                           // loop through the result set
                           Object myObject[] = (Object[]) itr.next();
                           number++;
                          // Object myObject[] = {resultSet.getString("Tarikh"),resultSet.getString("Nota")};
                           daDefaultTableModel.addRow(new Object[] {myObject[0],myObject[1]});
       //to make sure the number of notes_block is sufficient
   
}
                             d_checknotesamount(number);  
}

  
private void d_checknotesamount(int amount){
    int block_note = 12;
    while(amount < block_note){
        daDefaultTableModel.addRow(new Object[] {"",""});        
        amount++;
    }
}

private void d_notes01_A_checkmaximumamount(int i) {
    System.out.println("it is something???");
    int block_note = 12;
    if(block_note < i){
        int initia = 0;
    while(initia < 5){
        daDefaultTableModel.addRow(new Object[] {"",""});        
        initia++;
    } 
    }
}


}
