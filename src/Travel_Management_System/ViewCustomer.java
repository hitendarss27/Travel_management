package Travel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewCustomer extends JFrame implements ActionListener {
    JButton back;
    String username;
    ViewCustomer(String username){
        setBounds(450,180,870,625);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icon/bg3.jpg"));
        Image i8 = i7.getImage().getScaledInstance(870,625,Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel bg = new JLabel(i9);
        bg.setBounds(0,0,870,625);
        add(bg);

        JLabel lbusername = new JLabel("Username");
        lbusername.setBounds(30,50,150,25);
        bg.add(lbusername);

        JLabel lableusername = new JLabel();
        lableusername.setBounds(220,50,150,25);
        bg.add(lableusername);

        JLabel name = new JLabel("Name");
        name.setBounds(30,110,150,25);
        bg.add(name);

        JLabel lablename = new JLabel();
        lablename.setBounds(220,110,150,25);
        bg.add(lablename);

        JLabel lbid = new JLabel("ID");
        lbid.setBounds(30,170,150,25);
        bg.add(lbid);

        JLabel lableid = new JLabel();
        lableid.setBounds(220,170,150,25);
        bg.add(lableid);

        JLabel idnumber = new JLabel("ID Number");
        idnumber.setBounds(30,230,150,25);
        bg.add(idnumber);

        JLabel lableidnumber = new JLabel();
        lableidnumber.setBounds(220,230,150,25);
        bg.add(lableidnumber);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(30,290,150,25);
        bg.add(gender);

        JLabel lablegender = new JLabel();
        lablegender.setBounds(220,290,150,25);
        bg.add(lablegender);

        JLabel country = new JLabel("Country");
        country.setBounds(500,50,150,25);
        bg.add(country);

        JLabel lablecountry = new JLabel();
        lablecountry.setBounds(690,50,150,25);
        bg.add(lablecountry);

        JLabel address = new JLabel("Address");
        address.setBounds(500,110,150,25);
        bg.add(address);

        JLabel lableaddress = new JLabel();
        lableaddress.setBounds(690,110,150,25);
        bg.add(lableaddress);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(500,170,150,25);
        bg.add(phone);

        JLabel lablephone = new JLabel();
        lablephone.setBounds(690,170,150,25);
        bg.add(lablephone);

        JLabel mail = new JLabel("E-Mail");
        mail.setBounds(500,230,150,25);
        bg.add(mail);

        JLabel lablemail = new JLabel();
        lablemail.setBounds(690,230,150,25);
        bg.add(lablemail);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(350,350,100,25);
        back.addActionListener(this);
        bg.add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/viewpd.png"));
        Image i2 = i1.getImage().getScaledInstance(600,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(20,400,600,200);
        bg.add(image);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icon/viewpd.png"));
        Image i5 = i4.getImage().getScaledInstance(600,200,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image2 = new JLabel(i6);
        image2.setBounds(600,400,600,200);
        bg.add(image2);

        try{
            Con c = new Con();
            String query = "select * from customer where username = '"+username+"'";
            ResultSet rs = c.statement.executeQuery(query);
            while (rs.next()){
                lableusername.setText(rs.getString("username"));
                lablename.setText(rs.getString("name"));
                lableid.setText(rs.getString("id"));
                lableidnumber.setText(rs.getString("number"));
                lablegender.setText(rs.getString("gender"));
                lablecountry.setText(rs.getString("country"));
                lableaddress.setText(rs.getString("address"));
                lablephone.setText(rs.getString("phone"));
                lablemail.setText(rs.getString("mail"));
            }
        }catch (Exception E){
            E.printStackTrace();
        }


        setVisible(true);
    }
    public static void main(String[] args) {
        new ViewCustomer("honey");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== back){
            setVisible(false);
        }
    }
}
