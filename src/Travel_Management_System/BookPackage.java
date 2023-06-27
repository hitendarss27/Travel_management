package Travel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BookPackage extends JFrame implements ActionListener {
    Choice cpackage;
    JTextField jtmember;
    String username;
    JLabel lableusername, lableidnumber,lableid,lablephone,lableprice,lablemail;
    JButton checkprice, book, back;

    BookPackage(String username){
        this.username =username;
        setBounds(300,150,1100,500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icon/bg2.jpg"));
        Image i8 = i7.getImage().getScaledInstance(1100,500,Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel bg = new JLabel(i9);
        bg.setBounds(0,0,1100,500);
        add(bg);

        JLabel text = new JLabel("BOOK PACKAGE");
        text.setBounds(100,10,200,30);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        bg.add(text);

        JLabel lbusername = new JLabel("Username");
        lbusername.setBounds(40,70,100,20);
        lbusername.setFont(new Font("Tahoma",Font.PLAIN,16));
        bg.add(lbusername);

        lableusername = new JLabel();
        lableusername.setFont(new Font("Tahoma",Font.PLAIN,16));
        lableusername.setBounds(250,70,200,25);
        bg.add(lableusername);

        JLabel selectpaackage = new JLabel("Select Package");
        selectpaackage.setFont(new Font("Tahoma",Font.PLAIN,16));
        selectpaackage.setBounds(40,110,150,20);
        bg.add(selectpaackage);

        cpackage = new Choice();
        cpackage.add("Char Dham Yatra");
        cpackage.add("Manali Tour");
        cpackage.add("Rajasthan Tour");
        cpackage.setBounds(250,110,200,25);
        bg.add(cpackage);

        JLabel lbmember = new JLabel("Total Person");
        lbmember.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbmember.setBounds(40,150,150,25);
        bg.add(lbmember);

        jtmember = new JTextField("1");
        jtmember.setBounds(250,150,200,25);
        bg.add(jtmember);

        JLabel id = new JLabel("ID");
        id.setFont(new Font("Tahoma",Font.PLAIN,16));
        id.setBounds(40,190,150,20);
        bg.add(id);

        lableid = new JLabel();
        lableid.setBounds(250,190,200,25);
        bg.add(lableid);

        JLabel idnumber = new JLabel("ID Number");
        idnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        idnumber.setBounds(40,230,150,25);
        bg.add(idnumber);

        lableidnumber = new JLabel();
        lableidnumber.setBounds(250,230,150,25);
        bg.add(lableidnumber);

        JLabel phone = new JLabel("Phone");
        phone.setFont(new Font("Tahoma",Font.PLAIN,16));
        phone.setBounds(40,270,150,25);
        bg.add(phone);

        lablephone = new JLabel();
        lablephone.setBounds(250,270,150,25);
        bg.add(lablephone);

        JLabel mail = new JLabel("Mail");
        mail.setFont(new Font("Tahoma",Font.PLAIN,16));
        mail.setBounds(40,310,150,25);
        bg.add(mail);

        lablemail = new JLabel();
        lablemail.setBounds(250,310,150,25);
        bg.add(lablemail);

        JLabel price = new JLabel("Total Price");
        price.setFont(new Font("Tahoma",Font.PLAIN,16));
        price.setBounds(40,350,150,25);
        bg.add(price);

         lableprice = new JLabel();
        lableprice.setBounds(250,350,150,25);
        bg.add(lableprice);

        checkprice = new JButton("Check Price");
        checkprice.setForeground(Color.WHITE);
        checkprice.setBackground(Color.BLACK);
        checkprice.setBounds(60,400,120,25);
        checkprice.addActionListener(this);
        bg.add(checkprice);

        book = new JButton("Book Package");
        book.setForeground(Color.WHITE);
        book.setBackground(Color.BLACK);
        book.setBounds(200,400,120,25);
        book.addActionListener(this);
        bg.add(book);

        back = new JButton("Back");
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(340,400,120,25);
        back.addActionListener(this);
        bg.add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/flag.jpg"));
        Image i2 =i1.getImage().getScaledInstance(800,495,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550,0,800,495);
        bg.add(image);

        try{
            Conn c = new Conn();
            String query = "select * from customer where username = '"+username+"'";
            ResultSet rs = c.statement.executeQuery(query);
            while (rs.next()){
                lableusername.setText(rs.getString("username"));
                lableid.setText(rs.getString("id"));
                lableidnumber.setText(rs.getString("number"));
                lablephone.setText(rs.getString("phone"));
                lablemail.setText(rs.getString("mail"));
            }
        }catch (Exception E){
            E.printStackTrace();
        }

        setVisible(true);
    }
    @Override
    public  void actionPerformed(ActionEvent e){
        if(e.getSource() == checkprice){
        String pack = cpackage.getSelectedItem();
        int cost =0;
        if(pack.equals("Char Dham Yatra")){
            cost += 24000;
        } else if (pack.equals("Manali Tour")) {
            cost += 30000;
        } else if (pack.equals("Rajasthan Tour")) {
            cost += 20000;
        }
        int person = Integer.parseInt(jtmember.getText());
        cost *= person;
        lableprice.setText("Rs "+cost);
        }else if(e.getSource()  == book){
            try{
                Conn c = new Conn();
                final String s = "','" + lableidnumber.getText() + "',)";
                String query = "insert into bookpackage values('"+lableusername.getText()+"','"+cpackage.getSelectedItem()+"','"+jtmember.getText()+"','"+lableid.getText()+"','"+lableidnumber.getText()+"','"+lablephone.getText()+"','"+lablemail.getText()+"','"+lableprice.getText()+"')";
                c.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Package Booked Successfully");
                setVisible(false);
            }catch (Exception E){
                E.printStackTrace();
            }
        }else if(e.getSource() == back){
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new BookPackage("honey");
    }
}
