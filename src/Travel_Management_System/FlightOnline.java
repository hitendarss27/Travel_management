package Travel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FlightOnline extends JFrame implements ActionListener {
    JButton back;
    FlightOnline(){
        setBounds(400,100,800,600);

        JEditorPane pane = new JEditorPane();
        pane.setEditable(false);
        try{
            pane.setPage("https://www.makemytrip.com/");
        }catch (Exception e){
            pane.setContentType("text/html");
            pane.setText("<html>Could not load, Error 404</html>");
        }

        JScrollPane sb = new JScrollPane(pane);
        getContentPane().add(sb);

        back = new JButton("Back");
        back.setBounds(610,20,80,30);
        back.setBackground(new Color(65, 167, 236));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        pane.add(back);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back){
            setVisible(false);
            new Flight();
        }
    }

    public static void main(String[] args) {
        new FlightOnline();
    }
}
