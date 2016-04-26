package com.company;

import java.awt.*;

/**
 * Created by NGUYEN DINH QUAN on 4/26/2016.
 */
public class Bullet {
    private int x;
    private int y;
    public static final int WIDTH = 12;
    public static final int HEIGHT = 33;
    Image image;
    public Bullet(int x, int y, Image image){
        this.x = x;
        this. y = y;
        this.image = image;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return this.y;
    }
    public void setX(){
        this.x = x;
    }
    public void sety(){
        this.y = y;
    }
    public void run(){
        y -= 45;
    }
    public void paint(Graphics g){
        g.drawImage(this.image, x, y, WIDTH, HEIGHT, null);
    }

}
