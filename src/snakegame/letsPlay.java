/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author kamrul
 */
public class letsPlay extends JPanel implements KeyListener, ActionListener , Runnable{
    private int w , h, upDown = 10;
    private ImageIcon[] mouth = new ImageIcon[4];
    private ImageIcon body;
    private ImageIcon enemy;
    private int delay = 100;
    private int gameStart = 0;
    private Timer t;
    public int counter = 0;
    private int flag;
    private int enePosx = 600 , enePosy = 400;
    private int snakeLength;
    private int[] fx = new int[50];
    private int[] fy = new int[50];

    private int[] dx = {-20,0,20,0};
    private int[] dy = {0,-20,0,20};
    public letsPlay(int _w , int _h) {
       w = _w ;
       h = _h;
       flag = 2;
       fx[0] = 160; fx[1] = 140;fx[2] = 120;fx[3] = 100;fx[4] = 80;
       fy[0] = 200; fy[1] = 200;fy[2] = 200;fy[3] = 200;fy[4] = 200;
            
       snakeLength = 5;
        body = new ImageIcon("snakeimage.png");
        enemy = new ImageIcon("enemy.png");
        mouth[0] =  new ImageIcon("leftmouth.png");
        mouth[1] =  new ImageIcon("upmouth.png");
        mouth[2] =  new ImageIcon("rightmouth.png");
        mouth[3] =  new ImageIcon("downmouth.png");
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        t = new Timer(delay, this);
        t.start();
   }
    
    public void paint(Graphics g){
        g.setColor(new java.awt.Color(39,40,34));
        int x = w-20;
        int y = h-20;
        g.fillRect(0,0,w,h);
        g.setColor(Color.white);
        g.drawRect(10, 10, x, y);
        g.drawString("score: "+Integer.toString(counter), x-70,25);
        if(flag == 5){
            g.drawString("GAME OVER",(int)((double)w*.45),(int)((double)h*.5));
        }
        else{
             enemy.paintIcon(this, g,enePosx,enePosy);
             for(int i = 0 ; i< snakeLength; i++){
                 if(i == 0){
                     mouth[flag].paintIcon(this, g, fx[i], fy[i]);
                 }
                 else{
                     if(i != snakeLength-1) 
                         body.paintIcon(this, g, fx[i], fy[i]);
                     if(counter%4 == 0) g.setColor(Color.red);
                     else if(counter%4 == 1)  g.setColor(Color.yellow);
                     else if(counter%4 == 2)  g.setColor(Color.white);
                     else g.setColor(Color.green);
                     g.fillOval(fx[i]+7, fy[i]+7,10, 10);
                     
                 }
                 
             } 
        }
        
    }

    
   

    @Override
    public void keyTyped(KeyEvent e) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
     public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            if(Math.abs((int) (flag-0))%3 <= 1){
                flag = 0;
                gameStart = 1;
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_UP){
            if(Math.abs((int) (flag-1)) <= 1){
                flag = 1;
                gameStart = 1;

            }
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            if(Math.abs((int) (flag-2)) <= 1){
                flag = 2;
                gameStart = 1;

            }
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            if(Math.abs((int) (flag-3))%3 <= 1){
                flag = 3;
                gameStart = 1;
            }
        }
    }
     
    @Override
    public void run() {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        t.start();
        if(gameStart==1){
            for(int i = snakeLength-1 ; i>0 ; i--){
                fx[i] = fx[i-1];
                fy[i] = fy[i-1];
            }
            fx[0] += dx[flag];
            fy[0] += dy[flag];
            int temp = snakeLength;
            for(int i = 1 ; i < temp ; i++){
                if(fx[i] == fx[0] && fy[i] == fy[0]){
                    flag  = 5;
                    break;
                }
            }
            if( Math.abs((int) (enePosx-fx[0])) <= 20 && Math.abs((int) (enePosy-fy[0])) <= 20 ){
                
                while(true){
                    enePosx = (int) (Math.random()*(double)w);
                    enePosx = (int) (Math.random()*(double)h);
                    int haha = 0;
                    for(int i = 0 ; i< snakeLength ; i++){
                         if(Math.abs((int) (enePosx-fx[i])) <= 15 && Math.abs((int) (enePosy-fy[i])) <= 15){
                             haha = 1;
                         }
                    }
                    if(haha == 1) continue;
                    else break;
                }
                if(enePosx < 25) enePosx += 70;
                if(enePosy< 25) enePosy += 70;
                snakeLength = temp+1;
                counter++;
                
            }
            if(fx[0] <= 5 || fx[0] > w-20 || fy[0] <= 5 || fy[0] > h-20){
                flag = 5;
            }
        }
        repaint();
    }

    
    
    
}
