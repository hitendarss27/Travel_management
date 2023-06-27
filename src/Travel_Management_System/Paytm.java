package Travel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Paytm extends JFrame implements ActionListener {
    JButton back;
    Paytm(){
        setBounds(400,100,800,600);

        JEditorPane pane = new JEditorPane();
        pane.setEditable(false);
        try{
            pane.setPage("https://paytm.com/rent-payment");
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
    public static void main(String[] args) {
        new Paytm();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back){
            setVisible(false);
            new Payment();
        }
    }
}
