package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;


public class Plane {
    public int x;
    public int y;
    public int dx;
    public int dy;
    public Image image;
    Bullet bullet;
    public final int WIDTH = 70;
    public final int HEIGHT = 60;
    public void paint (Graphics g){
        g.drawImage(image, x, y,WIDTH,HEIGHT, null);
        if(bullet != null)
            bullet.paint(g);
    }
    public void run(){
        x+=dx;
        y+=dy;
        if(bullet != null)
            bullet.run();
    }
    public void shot(){
        try {
            this.bullet = new Bullet(this.x+WIDTH/2-Bullet.WIDTH/2,this.y, ImageIO.read(new File("resources/bullet.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    public void move(Movement m){
//        if(m.dx>0) dx=5;
//        else if(m.dx<0) dx=-5;
//        else dx=0;
//        if(m.dy>0) dy=5;
//        else if(m.dy<0) dy=-5;
//        else dy=0;
//    }
//    public void stop (KeyEvent y) {
//    }
    public void plane(int x, int y, Image image){
        this.y = y;
        this.x = x;
        this.image = image;

    }

    public void repait(){
        if(this.x<=25) this.x=25;
        if(this.x>=500) this.x=500;
        if(this.y<=35) this.y=35;
        if(this.y>=500) this.y=500;

    }

}
