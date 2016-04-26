package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.dnd.MouseDragGestureRecognizer;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by NGUYEN DINH QUAN on 4/25/2016.
 */
public class GameWindow extends Frame implements Runnable {
    Image backgroundImage;
    Image planeImage;
    Image plane1Image;
    Plane plane1 = new Plane();
    Plane plane2 = new Plane();
    EnemyPlane plane3 = new EnemyPlane();
    EnemyPlane plane4 = new EnemyPlane();
    EnemyPlane plane5 = new EnemyPlane();

    Thread thread;
    Image backbufferImage;//tao 1 anh phu
    public GameWindow(){

        this.setVisible(true);//hien man hinh
        this.setSize(600,600);//chinh kich thuoc man hinh
//load anh va ve anh
        try {
            backgroundImage=ImageIO.read(new File("resources/background.png"));//gan anh
//            plane1.image=ImageIO.read(new File("resources/plane3.png"));//gan anh
//            plane2.image = ImageIO.read(new File("resources/plane2.png"));//gan anh
//            plane3.image = ImageIO.read(new File("resources/plane1.png"));//gan anh
            plane1.plane(100,500,ImageIO.read(new File("resources/plane3.png")));
            plane2.plane(100,500,ImageIO.read(new File("resources/plane2.png")));
            plane3.plane(100,25,ImageIO.read(new File("resources/plane1.png")));
            plane4.plane(300,25,ImageIO.read(new File("resources/plane1.png")));
            plane5.plane(500,25,ImageIO.read(new File("resources/plane1.png")));

        } catch (IOException e) {
            e.printStackTrace();
        }

        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("windowOpened");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("windowClosing");
                System.exit(0);//dung de tao su kien dong chuong trinh;nhan ctrl exit
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("windowClosed");
            }

            @Override
            public void windowIconified(WindowEvent e) {
                System.out.println("windowIconified");
            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });//bat tat man hinh
//        this.addMouseMotionListener(new MouseMotionListener() {
//            @Override
//            public void mouseDragged(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseMoved(MouseEvent e) {
//
//            }
//        });
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                plane2.shot();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        //di chuyen may bay bang cach tao su kien bang ban phim
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("keyTyped");
            }
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("keyPressed");
                //lay su kien tu ban phim
                System.out.println(e.getKeyCode());
                switch(e.getKeyCode()){
                    case KeyEvent.VK_UP:
                        // y-=5;//gan gia tri cho y
                        //repaint();//phai ve lai hinh vi day ko phai hinh dong
                        plane1.dy = - 5;
                        break;
                    case KeyEvent.VK_DOWN:
                        //y+=5;
                        plane1.dy=+5;
                        //repaint();
                        break;
                    case KeyEvent.VK_RIGHT:
                        //x+=5;
                        // repaint();
                        plane1.dx=5;
                        break;
                    case KeyEvent.VK_LEFT:
                        //x-=5;
                        // repaint();
                        plane1.dx=-5;
                        break;
                    case KeyEvent.VK_SPACE:
                        plane1.shot();
                        break;
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("keyReleased");
                switch(e.getKeyCode()){
                    case KeyEvent.VK_UP:
                        // y-=5;//gan gia tri cho y
                        //repaint();//phai ve lai hinh vi day ko phai hinh dong
                        plane1.dy = 0;
                        break;
                    case KeyEvent.VK_DOWN:
                        //y+=5;
                        plane1.dy= 0;
                        //repaint();
                        break;
                    case KeyEvent.VK_RIGHT:
                        //x+=5;
                        // repaint();
                        plane1.dx= 0;
                        break;
                    case KeyEvent.VK_LEFT:
                        //x-=5;
                        // repaint();
                        plane1.dx= 0;
                        break;
                }

            }
        });
        //this.repaint();
        thread = new Thread(this);//khi nao thread chay thi goi den ham run
        thread.start();

    }


    @Override//ham ve
    public void update(Graphics g) {
        System.out.println("Update");

        if(backbufferImage== null){
            backbufferImage=new BufferedImage(600,600,1);
        }
        //ve len hinh minh vua load
        Graphics backbufferGraphics = backbufferImage.getGraphics();//but ve
        backbufferGraphics.drawImage(backgroundImage, 0, 0,null);//toa do anh nam goc tren ben trai
        //backbufferGraphics.drawImage(plane1.image,plane1.x,plane1.y,null);
       plane1.paint(backbufferGraphics);
       plane2.paint(backbufferGraphics);
        plane3.paint(backbufferGraphics);
        plane4.paint(backbufferGraphics);
        plane5.paint(backbufferGraphics);
        g.drawImage(backbufferImage, 0 , 0 ,null);
    }

    @Override
    public void run() {//ham chay
        long count = 0;
        while(true){
            plane1.repait();
            plane2.repait();
            plane3.repait();
            plane4.repait();
            plane5.repait();




//            if(plane1.x<=25) plane1.x=25;
//            if(plane1.x>=500) plane1.x=500;
//            if(plane1.y<=35) plane1.y=35;
//            if(plane1.y>=500) plane1.y=500;
//            if(plane2.x<=25) plane2.x=25;
//            if(plane2.x>=500) plane2.x=500;
//            if(plane2.y<=35) plane2.y=35;
//            if(plane2.y>=500) plane2.y=500;
            try {
                Point mousePoint=MouseInfo.getPointerInfo().getLocation();//luon lay lien tuc vi tri cua co chuot
                mousePoint.x-=getLocationOnScreen().x;
                mousePoint.y-=getLocationOnScreen().y;

                if(mousePoint.x-5>plane2.x)
                    plane2.dx=5;
                else if(mousePoint.x+5<plane2.x)
                    plane2.dx=-5;
                else plane2.dx=0;
                if(mousePoint.y-5>plane2.y)
                    plane2.dy=5;
                else if(mousePoint.y+5<plane2.y)
                    plane2.dy=-5;
                else plane2.dy=0;
                plane1.run();
                plane2.run();
                plane3.run();
                plane4.run();
                plane5.run();
                repaint();
                thread.sleep(17);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
