/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame;

import com.sun.glass.ui.Cursor;
import com.sun.glass.ui.Screen;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author kamrul
 */
public class SnakeGame{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame j = new JFrame("SNAKE GAME");
        
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        int x = (int) (d.width*0.1);
        int y = (int) (d.height*0.1);
        int w = d.width-2*x;
        int h = d.height-2*y;
        j.setBounds(x, y, w, h);
        j.getContentPane().add(new letsPlay(w,h));
        j.setBackground(new java.awt.Color(39,40,34));
        j.setVisible(true);
        j.setResizable(false);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
}
