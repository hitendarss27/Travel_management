package Travel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCustomer extends JFrame implements ActionListener {
    JLabel lbusername, lbname;
    JComboBox comboid;
    JTextField jtidnumber, jtcountry,jtadd, jtmail, jtphone, jtid, jtgender;
    JRadioButton male, female;
    JButton update,back;

    UpdateCustomer(String username){

        setBounds(500,200,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icon/bg3.jpg"));
        Image i8 = i7.getImage().getScaledInstance(870,625,Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel bg = new JLabel(i9);
        bg.setBounds(0,0,870,625);
        add(bg);

        JLabel text = new JLabel("UPDATE CUSTOMER DETAILS");
        text.setBounds(50,0,300,25);
        text.setFont(new Font("Tahoma", Font.PLAIN,20));
        bg.add(text);

        JLabel user = new JLabel("Username");
        user.setBounds(30,50,150,25);
        bg.add(user);

        lbusername = new JLabel();
        lbusername.setBounds(220,50,150,25);
        bg.add(lbusername);

        JLabel id = new JLabel("ID");
        id.setBounds(30,90,150,25);
        bg.add(id);

        jtid = new JTextField();
        jtid.setBounds(220,90,150,25);
        bg.add(jtid);

        JLabel idnumber = new JLabel("ID Number");
        idnumber.setBounds(30,130,150,25);
        bg.add(idnumber);

        jtidnumber = new JTextField();
        jtidnumber.setBounds(220,130,150,25);
        bg.add(jtidnumber);

        JLabel name = new JLabel("Name");
        name.setBounds(30,170,150,25);
        bg.add(name);

        lbname = new JLabel();
        lbname.setBounds(220,170,150,25);
        bg.add(lbname);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(30,210,150,25);
        bg.add(gender);

        jtgender = new JTextField();
        jtgender.setBounds(220,210,150,25);
        bg.add(jtgender);

        JLabel country = new JLabel("Country");
        country.setBounds(30,250,150,25);
        bg.add(country);

        jtcountry = new JTextField();
        jtcountry.setBounds(220,250,150,25);
        bg.add(jtcountry);

        JLabel add = new JLabel("Address");
        add.setBounds(30,290,150,25);
        bg.add(add);

        jtadd = new JTextField();
        jtadd.setBounds(220,290,150,25);
        bg.add(jtadd);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(30,330,150,25);
        bg.add(phone);

        jtphone = new JTextField();
        jtphone.setBounds(220,330,150,25);
        bg.add(jtphone);

        JLabel mail = new JLabel("E-Mail");
        mail.setBounds(30,370,150,25);
        bg.add(mail);

        jtmail = new JTextField();
        jtmail.setBounds(220,370,150,25);
        bg.add(jtmail);

        update =new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(70,430,100,25);
        update.addActionListener(this);
        bg.add(update);

        back =new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(220,430,100,25);
        back.addActionListener(this);
        bg.add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/update1.png"));
        Image i2 = i1.getImage().getScaledInstance(400,350,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,85,450,350);
        bg.add(image);

        try {
            Conn c = new Conn();
            ResultSet rs = c.statement.executeQuery("select * from customer where username = '"+username+"'");
            while(rs.next()){
                lbusername.setText(rs.getString("username"));
                lbname.setText(rs.getString("name"));
                jtid.setText(rs.getString("id"));
                jtidnumber.setText(rs.getString("number"));
                jtgender.setText(rs.getString("gender"));
                jtcountry.setText(rs.getString("country"));
                jtadd.setText(rs.getString("address"));
                jtphone.setText(rs.getString("phone"));
                jtmail.setText(rs.getString("mail"));



            }
        }catch (Exception E){
            E.printStackTrace();
        }
        setVisible(true);
    }
    public static void main(String[] args) {
        new UpdateCustomer("honey");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == update){
            String username = lbusername.getText();
            String id = jtid.getText();
            String number = jtidnumber.getText();
            String name = lbname.getText();
            String gender = jtgender.getText();
            String country = jtcountry.getText();
            String address = jtadd.getText();
            String phone = jtphone.getText();
            String mail = jtmail.getText();
            try {
                Conn c = new Conn();
                String query = "update customer set username = '"+username+"',id = '"+id+"',number = '"+number+"',name = '"+name+"',gender = '"+gender+"',country = '"+country+"',address = '"+address+"',phone = '"+phone+"',mail = '"+mail+"'";
                c.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Customer Details Updated Successfully");
                setVisible(false);
            }catch (Exception E){
                E.printStackTrace();
            }
        }else if(e.getSource() == back){
            setVisible(false);
        }
    }
}

