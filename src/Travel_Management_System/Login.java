package Travel_Management_System;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField tfpassword , tfusername;
    JButton login, signup, forgetp;
    Login(){
        setSize(900,400);
        setLocation(350,200);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131,193,233)); // color awt m hota hai
        p1.setBounds(0,0,400,400);
        p1.setLayout(null);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100,85,200,200);
        p1.add(image);


        JPanel p2 = new JPanel();
        p2.setBounds(400,30,450,300);
        p2.setLayout(null);
        add(p2);

        JLabel lbusername = new JLabel("Username");
        lbusername.setBounds(60,20,100,25);
        lbusername.setFont(new Font("SAN SERIF", Font.BOLD,20));
        p2.add(lbusername);

        tfusername = new JTextField();
        tfusername.setBounds(60,60,300,30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfusername);

        JLabel lbpassword = new JLabel("Password");
        lbpassword.setBounds(60,100,100,25);
        lbpassword.setFont(new Font("SAN SERIF", Font.BOLD,20));
        p2.add(lbpassword);

        tfpassword = new JTextField();
        tfpassword.setBounds(60,140,300,30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpassword);

        login =new JButton("Login");
        login.setBounds(60,200,120,30);
        login.setBackground(new Color(133,193,233));
        login.setForeground(Color.WHITE);
        login.setBorder(new LineBorder(new Color(133,193,233)));
        login.addActionListener(this);
        p2.add(login);

        signup =new JButton("Signup");
        signup.setBounds(240,200,120,30);
        signup.setBackground(new Color(133,193,233));
        signup.setForeground(Color.WHITE);
        signup.setBorder(new LineBorder(new Color(133,193,233)));
        signup.addActionListener(this);
        p2.add(signup);

        forgetp =new JButton("Forget Password");
        forgetp.setBounds(150,250,130,30);
        forgetp.setBackground(new Color(133,193,233));
        forgetp.setForeground(Color.WHITE);
        forgetp.setBorder(new LineBorder(new Color(133,193,233)));
        forgetp.addActionListener(this);
        p2.add(forgetp);

        JLabel text = new JLabel("Trouble in login...");
        text.setBounds(300,253,150,20);
        text.setForeground(Color.RED);
        p2.add(text);

        setVisible(true);
    }
    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == signup){
            new Signup();
            setVisible(false);
        } else if (e.getSource() == forgetp) {
            new Forgetpassword();
            setVisible(false);
        } else if (e.getSource() == login) {
            try{
                String username = tfusername.getText();
                String password = tfpassword.getText();
                String query = "select * from account where username = '"+username+"' AND password = '"+password+"'";
                Con c = new Con();
                ResultSet rs = c.statement.executeQuery(query);
                if(rs.next()){
                    new Loding(username);
                    setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect username and password");
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
