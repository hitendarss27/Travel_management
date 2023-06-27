package Travel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Flight extends JFrame implements ActionListener {
    JButton book, back;
    Flight(){
        setBounds(400,100,800,600);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/flight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,600);
        add(image);

        JLabel text = new JLabel("Flight Booking");
        text.setForeground(new Color(16, 53, 84));
        text.setFont(new Font("TAHOMA",Font.BOLD,40));
        text.setBounds(250,25,300,50);
        image.add(text);

        book  = new JButton("Book");
        book.setBounds(280,500,80,30);
        book.setBackground(new Color(16, 53, 84));
        book.setForeground(Color.WHITE);
        book.addActionListener(this);
        image.add(book);

        back  = new JButton("Back");
        back.setBounds(440,500,80,30);
        back.setBackground(new Color(16, 53, 84));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        image.add(back);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Flight();
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == book){
            setVisible(false);
            new FlightOnline();
        }else if(e.getSource() == back){
            setVisible(false);
        }
    }

}
