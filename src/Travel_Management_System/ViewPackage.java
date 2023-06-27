package Travel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewPackage extends JFrame implements ActionListener {
    JButton back;
    String username;
    ViewPackage(String username){
        setBounds(420,200,900,450);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icon/bg2.jpg"));
        Image i8 = i7.getImage().getScaledInstance(900,450,Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel bg = new JLabel(i9);
        bg.setBounds(0,0,900,450);
        add(bg);

        JLabel text = new JLabel("Package Details");
        text.setFont(new Font("tahoma",Font.BOLD,20));
        text.setBounds(60,0,300,35);
        bg.add(text);

        JLabel lbusername = new JLabel("Username");
        lbusername.setBounds(30,50,150,25);
        bg.add(lbusername);

        JLabel lableusername = new JLabel();
        lableusername.setBounds(220,50,150,25);
        bg.add(lableusername);

        JLabel lbpackage = new JLabel("Package");
        lbpackage.setBounds(30,90,150,25);
        bg.add(lbpackage);

        JLabel lablepackage = new JLabel();
        lablepackage.setBounds(220,90,150,25);
        bg.add(lablepackage);

        JLabel person = new JLabel("Total Person");
        person.setBounds(30,130,150,25);
        bg.add(person);

        JLabel lableperson = new JLabel();
        lableperson.setBounds(220,130,150,25);
        bg.add(lableperson);

        JLabel lbid = new JLabel("ID");
        lbid.setBounds(30,170,150,25);
        bg.add(lbid);

        JLabel lableid = new JLabel();
        lableid.setBounds(220,170,150,25);
        bg.add(lableid);

        JLabel idnumber = new JLabel("ID Number");
        idnumber.setBounds(30,210,150,25);
        bg.add(idnumber);

        JLabel lableidnumber = new JLabel();
        lableidnumber.setBounds(220,210,150,25);
        bg.add(lableidnumber);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(30,250,150,25);
        bg.add(phone);

        JLabel lablephone = new JLabel();
        lablephone.setBounds(220,250,150,25);
        bg.add(lablephone);

        JLabel mail = new JLabel("E-Mail");
        mail.setBounds(30,290,150,25);
        bg.add(mail);

        JLabel lablemail = new JLabel();
        lablemail.setBounds(220,290,150,25);
        bg.add(lablemail);

        JLabel price = new JLabel("Price");
        price.setBounds(30,330,150,25);
        bg.add(price);

        JLabel lableprice = new JLabel();
        lableprice.setBounds(220,330,150,25);
        bg.add(lableprice);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(125,370,100,25);
        back.addActionListener(this);
        bg.add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/vpack.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450,8,500,400);
        bg.add(image);

        try{
            Con c = new Con();
            String query = "select * from bookpackage where username = '"+username+"'";
            ResultSet rs = c.statement.executeQuery(query);
            while (rs.next()){
                lableusername.setText(rs.getString("username"));
                lablepackage.setText(rs.getString("package"));
                lableperson.setText(rs.getString("person"));
                lableid.setText(rs.getString("id"));
                lableidnumber.setText(rs.getString("idnumber"));
                lablephone.setText(rs.getString("phone"));
                lablemail.setText(rs.getString("mail"));
                lableprice.setText(rs.getString("price"));
            }
        }catch (Exception E){
            E.printStackTrace();
        }


        setVisible(true);
    }
    public static void main(String[] args) {
        new ViewPackage("honey");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== back){
            setVisible(false);
        }
    }
}
