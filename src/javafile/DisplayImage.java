/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafile;

/**
 *
 * @author DELL
 */

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Image;
import java.io.File;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DisplayImage extends JFrame {
    
    public DisplayImage() {
        initUI();
    }

    public void initUI() {       
        
        ImageIcon ii = loadImage();

        JLabel label = new JLabel(ii);
        
        createLayout(label);
        
        setTitle("Image");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    
    public ImageIcon loadImage() {
          String getFilePath = new File("").getAbsolutePath();
          File fs = new File(getFilePath.concat("\\src\\image\\"));
          String[] pathnames = fs.list();
            ImageIcon ii = new ImageIcon(getFilePath.concat("\\src\\image\\images").concat(String.valueOf(pathnames.length)+1).concat(".jpg"));
             System.out.println(getFilePath.concat("\\src\\image\\images").concat(String.valueOf(pathnames.length)+1).concat(".jpg"));
            return ii;
    }

    private void createLayout(JComponent... arg) {

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
        );

        gl.setVerticalGroup(gl.createParallelGroup()
                .addComponent(arg[0])
        );
       
        pack();
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
         DisplayImage ex = new DisplayImage();
            ex.setVisible(true);   
        });
    }
}