/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notes;

import connection.c_connection_notes;
import css.scrollbar;
import google_map.m_map01;
import initialization.initialization;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JComponent;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class notes {
    
    public JPanel g_notes = new JPanel(){
    protected void paintComponent(Graphics g)
    {
        g.setColor( getBackground() );
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
}; 
   
    public notes(){
        //initialized_notes();
    }
    
    public void initialized_notes(){
        g_notes.setPreferredSize(new Dimension(initialization.notes_panel_width,initialization.notes_panel_height));
        g_notes.setBounds(0,0,initialization.notes_panel_width,initialization.notes_panel_height);
        g_notes.setOpaque(false);
        g_notes.setBackground( new Color(0, 0, 0,1) ); 
        g_notes.add(loading_info(g_notes));
    }
    
    public JLayeredPane pane = new JLayeredPane(){
    protected void paintComponent(Graphics g)
    {
        g.setColor( getBackground() );
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
        };       
     DefaultTableModel daDefaultTableModel = new DefaultTableModel(0, 0);
        
    m_map01 button_map = new m_map01();
    
    public JScrollPane loading_info(JPanel hello) {            
   
        String[][] data = { 
            { "Kundan Kumar Jha", "CSE" }, 
            { "Anand Jha", "IT" } 
        }; 
        //daDefaultTableModel.setRowCount(0);
        // Column Names 
        String[] columnNames = { "Name", "Department" }; 
        JTable listWords = new javax.swing.JTable();
    
       
        listWords.setBounds(0, 0, hello.getWidth(), hello.getHeight()); 
        daDefaultTableModel.setColumnIdentifiers(columnNames);
        daDefaultTableModel.addRow(new Object[] {"Tarikh","Catatan"});
        d_display_row(); 
      
        
        
        listWords.setModel(daDefaultTableModel);
        listWords.getColumnModel().getColumn(0).setCellRenderer(new CustomRenderer());
        listWords.getColumnModel().getColumn(1).setCellRenderer(new CustomRenderer());
    
        final scrollbar jScrollPane1 = new scrollbar(
        listWords,
        ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
        
         //jScrollPane1.add(button_map.m_returnawt());
        jScrollPane1.setPreferredSize(new Dimension(hello.getWidth(),hello.getHeight()-20));
        jScrollPane1.setBounds(0, 0, hello.getWidth(), hello.getHeight());
        jScrollPane1.getViewport().setBackground(new Color(255,255,255,10));
        
        
        
listWords.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        //listWordsMouseClicked(evt);
    }
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        //listWordsMouseEntered(evt);
    }
});


return jScrollPane1;
    }
    
    public void d_display_row() {
   c_connection_notes count = new c_connection_notes();
    if (count.count_table() > 0){
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

public JPanel r_return_g_notes(){
    return g_notes;
}

  
private void d_checknotesamount(int amount){
    int block_note = 6;
    while(amount < block_note){
        daDefaultTableModel.addRow(new Object[] {"",""});        
        amount++;
    }
}

class CustomRenderer extends DefaultTableCellRenderer 
{
private static final long serialVersionUID = 6703872492730589499L;

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if(row == 0){
        ((JComponent) cellComponent).setBorder(new LineBorder(new Color(52,54,57)));   } else if ( row == 1){
         ((JComponent) cellComponent).setBorder(new LineBorder(new Color(52,54,57)));  } else {
       ((JComponent) cellComponent).setBorder(new LineBorder(new Color(52,54,57)));
        }
        return cellComponent;
    }
}
}
