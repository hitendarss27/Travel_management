package Travel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AddCustomer extends JFrame implements ActionListener {
    JLabel lbusername, lbname;
    JComboBox comboid;
    JTextField jtidnumber, jtcountry,jtadd, jtmail, jtphone;
    JRadioButton male, female;
    JButton Add,back;

    AddCustomer(String username){

        setBounds(400,100,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icon/bg1.jpg"));
        Image i5 = i4.getImage().getScaledInstance(850,550,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image2 = new JLabel(i6);
        image2.setBounds(0,0,850,550);
        add(image2);

        JLabel user = new JLabel("Username");
        user.setBounds(30,50,150,25);
        image2.add(user);

        lbusername = new JLabel();
        lbusername.setBounds(220,50,150,25);
        image2.add(lbusername);

        JLabel id = new JLabel("ID");
        id.setBounds(30,90,150,25);
        image2.add(id);

        comboid =new JComboBox(new String[] {"Passport", "Aadhar Card", "Pen Card", "Ration Card"});
        comboid.setBounds(220,90,150,25);
        comboid.setBackground(Color.WHITE);
        image2.add(comboid);

        JLabel idnumber = new JLabel("ID Number");
        idnumber.setBounds(30,130,150,25);
        image2.add(idnumber);

        jtidnumber = new JTextField();
        jtidnumber.setBounds(220,130,150,25);
        image2.add(jtidnumber);

        JLabel name = new JLabel("Name");
        name.setBounds(30,170,150,25);
        image2.add(name);

        lbname = new JLabel();
        lbname.setBounds(220,170,150,25);
        image2.add(lbname);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(30,210,150,25);
        image2.add(gender);

        male = new JRadioButton("Male");
        male.setBounds(220,210,70,25);
        male.setBackground(Color.WHITE);
        image2.add(male);

        female = new JRadioButton("Female");
        female.setBounds(300,210,70,25);
        female.setBackground(Color.WHITE);
        image2.add(female);

        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        JLabel country = new JLabel("Country");
        country.setBounds(30,250,150,25);
        image2.add(country);

        jtcountry = new JTextField();
        jtcountry.setBounds(220,250,150,25);
        image2.add(jtcountry);

        JLabel add = new JLabel("Address");
        add.setBounds(30,290,150,25);
        image2.add(add);

        jtadd = new JTextField();
        jtadd.setBounds(220,290,150,25);
        image2.add(jtadd);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(30,330,150,25);
        image2.add(phone);

        jtphone = new JTextField();
        jtphone.setBounds(220,330,150,25);
        image2.add(jtphone);

        JLabel mail = new JLabel("E-Mail");
        mail.setBounds(30,370,150,25);
        image2.add(mail);

        jtmail = new JTextField();
        jtmail.setBounds(220,370,150,25);
        image2.add(jtmail);

        Add =new JButton("Add");
        Add.setBackground(Color.BLACK);
        Add.setForeground(Color.WHITE);
        Add.setBounds(70,430,100,25);
        Add.addActionListener(this);
        image2.add(Add);

        back =new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(220,430,100,25);
        back.addActionListener(this);
        image2.add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/newcustomer1.png"));
        Image i2 = i1.getImage().getScaledInstance(400,500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,55,450,420);
        image2.add(image);

        try {
            Conn c = new Conn();
            ResultSet rs = c.statement.executeQuery("select * from account where username = '"+username+"'");
            while(rs.next()){
                lbusername.setText(rs.getString("username"));
                lbname.setText(rs.getString("name"));
            }
        }catch (Exception E){
            E.printStackTrace();
        }



        setVisible(true);
    }
    public static void main(String[] args) {
        new AddCustomer("honey");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Add){
            String username = lbusername.getText();
            String id = (String) comboid.getSelectedItem();
            String number = jtidnumber.getText();
            String name = lbname.getText();
            String gender = null;
            if(male.isSelected()){
                gender = "Male";
            }else{
                gender = "Female";
            }
            String country = jtcountry.getText();
            String address = jtadd.getText();
            String phone = jtphone.getText();
            String mail = jtmail.getText();
            try {
                Conn c = new Conn();
                String query = "insert into customer values('"+username+"','"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+address+"','"+phone+"','"+mail+"')";
                c.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Customer Details Added Successfully");
                setVisible(false);
            }catch (Exception E){
                E.printStackTrace();
            }
        }else if(e.getSource() == back){
            setVisible(false);
        }
    }
}
