package Travel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Payment extends JFrame  implements ActionListener {

    JButton pay, back;
    Payment(){
        setBounds(400,100,800,600);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/paytm.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(800,600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,600);
        add(image);

        pay  = new JButton("Pay");
        pay.setBounds(120,500,80,30);
        pay.setBackground(new Color(65, 167, 236));
        pay.setForeground(Color.WHITE);
        pay.addActionListener(this);
        image.add(pay);

        back  = new JButton("Back");
        back.setBounds(600,500,80,30);
        back.setBackground(new Color(65, 167, 236));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        image.add(back);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == pay){
            setVisible(false);
            new Paytm();
        }else if(e.getSource() == back){
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Payment();
    }
}
