package com.company;

import java.awt.*;

public class EnemyPlane {
    public int x;
    public int y;
    public Image image;
    public final int WIDTH = 45;
    public final int HEIGHT = 40;

    public void paint(Graphics g) {
        g.drawImage(image, x, y, WIDTH, HEIGHT, null);
    }

    public void run() {
        y += 5;
    }


    public void repait() {
        if (this.x <= 25) this.x = 30;
        if (this.x >= 500) this.x = 50;
        if (this.y <= 25) this.y = 25;
        if (this.y >= 600) {
            this.y = 35;
            this.x += 80;
        }
    }


    public void plane(int x, int y, Image image) {
        this.y = y;
        this.x = x;
        this.image = image;


    }


}