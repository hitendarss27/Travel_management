package Travel_Management_System;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup extends JFrame implements ActionListener {
    JTextField jtUsername, jtName,jtPassword, jtSecurity;
    Choice security;
    JButton b1,b2;
    Signup(){
        setBounds(350,200,900,360);       // setBound is copy of setSize and setLocation
//        setSize(900,400);
//        setLocation(350,200);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131,193,233));
        p1.setBounds(0,0,500,400);
        p1.setLayout(null);
        add(p1);

        JLabel username = new JLabel("Username");
        username.setForeground(Color.DARK_GRAY);
        username.setFont(new Font("Tahoma",Font.BOLD,14));
        username.setBounds(50,20,125,25);
        p1.add(username);

        jtUsername = new JTextField();
        jtUsername.setBounds(195,20,180,25);
        jtUsername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(jtUsername);

        JLabel name = new JLabel("Name");
        name.setForeground(Color.DARK_GRAY);
        name.setFont(new Font("Tahoma",Font.BOLD,14));
        name.setBounds(50,60,125,25);
        p1.add(name);

        jtName = new JTextField();
        jtName.setBounds(195,60,180,25);
        jtName.setBorder(BorderFactory.createEmptyBorder());
        p1.add(jtName);

        JLabel password = new JLabel("Password");
        password.setForeground(Color.DARK_GRAY);
        password.setFont(new Font("Tahoma",Font.BOLD,14));
        password.setBounds(50,100,125,25);
        p1.add(password);

        jtPassword = new JTextField();
        jtPassword.setBounds(195,100,180,25);
        jtPassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(jtPassword);

        JLabel securityQuestion = new JLabel("Security Question");
        securityQuestion.setForeground(Color.DARK_GRAY);
        securityQuestion.setFont(new Font("Tahoma",Font.BOLD,14));
        securityQuestion.setBounds(50,140,140,25);
        p1.add(securityQuestion);

        security = new Choice();
        security.add("Favourite Sports");
        security.add("Favourite Food");
        security.add("Favourite Marvel Superhero");
        security.add("Favourite Cartoon");
        security.add("Favourite Destination");
        security.setBounds(195,140,180,25);
        p1.add(security);

        JLabel sec = new JLabel("Answer");
        sec.setForeground(Color.DARK_GRAY);
        sec.setFont(new Font("Tahoma",Font.BOLD,14));
        sec.setBounds(50,180,125,25);
        p1.add(sec);

        jtSecurity = new JTextField();
        jtSecurity.setBounds(195,180,180,25);
        jtSecurity.setBorder(BorderFactory.createEmptyBorder());
        p1.add(jtSecurity);

        b1 = new JButton("Create");
        b1.setFont(new Font("Tahoma", Font.BOLD,14));
        b1.setBounds(80,250,100,30);
        b1.setForeground(new Color(131,193,233));
        b1.setBorder(BorderFactory.createEmptyBorder());
        b1.addActionListener(this);
        p1.add(b1);

        b2 = new JButton("Back");
        b2.setFont(new Font("Tahoma", Font.BOLD,14));
        b2.setBounds(250,250,100,30);
        b2.setForeground(new Color(131,193,233));
        b2.setBorder(BorderFactory.createEmptyBorder());
        b2.addActionListener(this);
        p1.add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));  // classLoder is a static class and getSystemResource is method of classLoder,gSR go to system and search the image and put the image in i1 object,
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);   // getscalinctance take width and higth and dicress the size of image
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(568,40,250,250);
        add(image);



        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource()==b1){
                String uname = jtUsername.getText();
                String name = jtName.getText();
                String pass = jtPassword.getText();
                String securityQ = security.getSelectedItem();
                String answer = jtSecurity.getText();

                String query = "insert into account values('"+uname+"','"+name+"','"+pass+"','"+securityQ+"','"+answer+"')";
                try{
                    Conn c = new Conn();
                    c.statement.executeUpdate(query);  //DML command

                    JOptionPane.showMessageDialog(null,"Account Created Successfully");
                    setVisible(false);
                    new Login();
                }catch (Exception ex){
//                    ex.printStackTrace();
                        JOptionPane.showMessageDialog(null,"This username is not available.");
                }
            }
            else if(e.getSource()== b2){
                new Login();
                setVisible(false);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}
