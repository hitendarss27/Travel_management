package Travel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Forgetpassword extends JFrame implements ActionListener {
    JTextField jtusername, jtname, jtsq , jtanswer, jtpass;
    JButton search,retrieve, back;

    Forgetpassword(){
        setBounds(350,200,850,380);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580,70,200,200);
        add(image);

        JPanel p1 =new JPanel();
        p1.setBackground(new Color(133,193,233));
        p1.setBounds(30,30,500,280);
        p1.setLayout(null);
        add(p1);

        JLabel username = new JLabel("Username");
        username.setBounds(40,20,100,25);
        username.setFont(new Font("Tahoma",Font.BOLD, 14));
        p1.add(username);

        jtusername = new JTextField();
        jtusername.setBounds(220,20,150,25);
        jtusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(jtusername);

        search = new JButton("Search");
        search.setBackground(Color.WHITE);
        search.setForeground(new Color(133,193,233));
        search.setBounds(380,20,100,25);
        search.addActionListener(this);
        p1.add(search);

        JLabel name = new JLabel("Name");
        name.setBounds(40,60,100,25);
        name.setFont(new Font("Tahoma",Font.BOLD, 14));
        p1.add(name);

        jtname = new JTextField();
        jtname.setBounds(220,60,150,25);
        jtname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(jtname);

        JLabel sequrityq = new JLabel("Security Question");
        sequrityq.setBounds(40,100,130,25);
        sequrityq.setFont(new Font("Tahoma",Font.BOLD, 14));
        p1.add(sequrityq);

        jtsq = new JTextField();
        jtsq.setBounds(220,100,150,25);
        jtsq.setBorder(BorderFactory.createEmptyBorder());
        p1.add(jtsq);

        JLabel answer = new JLabel("Answer");
        answer.setBounds(40,140,100,25);
        answer.setFont(new Font("Tahoma",Font.BOLD, 14));
        p1.add(answer);

        jtanswer = new JTextField();
        jtanswer.setBounds(220,140,150,25);
        jtanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(jtanswer);

        retrieve = new JButton("Retrieve");
        retrieve.setBackground(Color.WHITE);
        retrieve.setForeground(new Color(133,193,233));
        retrieve.setBounds(380,140,100,25);
        retrieve.addActionListener(this);
        p1.add(retrieve);

        JLabel pass = new JLabel("Password");
        pass.setBounds(40,180,100,25);
        pass.setFont(new Font("Tahoma",Font.BOLD, 14));
        p1.add(pass);

        jtpass = new JTextField();
        jtpass.setBounds(220,180,150,25);
        jtpass.setBorder(BorderFactory.createEmptyBorder());
        p1.add(jtpass);

        back = new JButton("Back");
        back.setBackground(Color.WHITE);
        back.setForeground(new Color(133,193,233));
        back.setBounds(150,230,100,25);
        back.addActionListener(this);
        p1.add(back);

        setVisible(true);
    }
    public static void main(String[] args) {
        new Forgetpassword();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == search){
            try{
                String query = "select * from account where username = '"+jtusername.getText()+"'";
                Conn c = new Conn();
               ResultSet rs =  c.statement.executeQuery(query);   // Resultset available in sql
                while(rs.next()){
                    jtname.setText(rs.getString("name"));
                    jtsq.setText(rs.getString("security"));
                }
            }catch(Exception E){
                E.printStackTrace();
            }
        } else if (e.getSource() == retrieve) {
            try{
                String query = "select * from account where answer = '"+jtanswer.getText()+"' AND username = '"+jtusername.getText()+"'";
                Conn c = new Conn();
                ResultSet rs =  c.statement.executeQuery(query);   // Resultset available in sql
                while(rs.next()){
                    jtpass.setText(rs.getString("password"));
                }
            }catch(Exception E){
                E.printStackTrace();
            }
        }else if(e.getSource() == back){
            new Login();
            setVisible(false);
        }

    }
}
