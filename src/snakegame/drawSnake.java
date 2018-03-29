/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author kamrul
 */
public class drawSnake extends JPanel{

    public drawSnake() {
    }
    public void paint(Graphics g){
        g.setColor(Color.red);
        g.fillOval(10,10,7,7);
        
    }
    
}
