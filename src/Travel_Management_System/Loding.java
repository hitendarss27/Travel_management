package Travel_Management_System;

import javax.swing.*;
import java.awt.*;

public class Loding extends JFrame implements Runnable{
    Thread t;
    JProgressBar bar;
    @Override
    public void run() {
        try{
            for(int i = 1; i<=101; i++){
                int max = bar.getMaximum(); //100
                int value = bar.getValue();

                if(value < max){   //101<100
                    bar.setValue(bar.getValue() + 1);
                }else{
                    setVisible(false);
                    new Dashboard(username);
                    //new class object
                }
                Thread.sleep(50);
            }
        }catch (Exception E){
            E.printStackTrace();
        }
    }
    String username;
    Loding(String username){
        this.username = username;
        t = new Thread(this);
        setBounds(500,200,650,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icon/lodingbg.jpg"));
        Image i8 = i7.getImage().getScaledInstance(650,400,Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel bg = new JLabel(i9);
        bg.setBounds(0,0,650,400);
        add(bg);

        JLabel text = new JLabel("Travel Management Application");
        text.setBounds(50,20,600,40);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Raleway", Font.BOLD,35));
        bg.add(text);

        bar = new JProgressBar();
        bar.setBounds(150,100,300,35);
        bar.setStringPainted(true);
        bg.add(bar);

        JLabel loading = new JLabel("Loading, please wait...");
        loading.setBounds(225,130,180,30);
        loading.setForeground(Color.RED);
        loading.setFont(new Font("Raleway", Font.BOLD,16));
        bg.add(loading);

        JLabel usern = new JLabel("Welcome "+username);
        usern.setBounds(20,310,400,40);
        usern.setForeground(Color.BLUE);
        usern.setFont(new Font("Raleway", Font.BOLD,20));
        bg.add(usern);

        t.start();
        setVisible(true);
    }
    public static void main(String[] args) {
        new Loding("");
    }
}
