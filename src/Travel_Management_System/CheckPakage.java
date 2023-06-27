package Travel_Management_System;

import javax.swing.*;
import java.awt.*;

public class CheckPakage extends JFrame {
    CheckPakage(){
        setBounds(380,140,900,600);

        String [] paclage1 = {"Char Dham Yatra", "Badrinath-Kedarnath-Gangotri-Yamunotri","12 Days And 11 Nights","From Jaipur","Daily Buffet","Free Parking and Toll","Free Hotel Stays","Experienced Guide","Pickup & Drop","BOOK NOW!!","Rs 24000/-","package1.jpg","chardhambg.jpg"};
        String [] paclage2 = {"Manali Tour","Kullu-Manali-Leh-Ladakh-Pangong","11 Days And 10 Nights","From Jaipur","Nigth Camping at Pangong","Free Food & Hotel Stays","Sightseeing","Experienced Guide","Pickup & Drop","BOOK NOW!!","Rs 30000/-","manali.jpg","manalibg.jpg"};
        String [] paclage3 = {"Rajasthan Tour","Jaipur-Jaisalmer-Jodhpur-Udaipur-Bikaner","7 Days And 8 Nights","From Jaipur","Camel & Elephant Safari","Free Meals & Hotel Stays","Shightseeing","Daal Bati Churma","Pickup & Drop","BOOK NOW!!","Rs 20000/-","raj.jpg","rajbg.jpg"};

        JTabbedPane tab =new JTabbedPane();
        JPanel p1 = createPackage(paclage1);
        tab.addTab("Package 1",null,p1);

        JPanel p2 = createPackage(paclage2);
        tab.addTab("Package 2",null,p2);

        JPanel p3 = createPackage(paclage3);
        tab.addTab("Package 3",null,p3);
        add(tab);

        setVisible(true);
    }
    public JPanel createPackage(String [] pack){
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icon/"+pack[12]));
        Image i5 =i4.getImage().getScaledInstance(900,600,Image.SCALE_DEFAULT);
        ImageIcon i6 =new ImageIcon(i5);
        JLabel image1 = new JLabel(i6);
        image1.setBounds(0,0,900,600);


        JPanel p1 =new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.WHITE);

        p1.add(image1);


        JLabel l1 =new JLabel(pack[0]);
        l1.setBounds(300,5,300,37);
        l1.setForeground(new Color(164, 127, 13));
        l1.setFont(new Font("Tahoma", Font.BOLD,30));
        image1.add(l1);

        JLabel l2 =new JLabel(pack[1]);
        l2.setBounds(275,35,350,30);
        l2.setForeground(Color.RED);
        l2.setFont(new Font("Raleway", Font.BOLD,15));
        image1.add(l2);

        JLabel l3 =new JLabel(pack[2]);
        l3.setBounds(30,110,300,30);
        l3.setForeground(new Color(164, 127, 13));
        l3.setFont(new Font("Raleway", Font.BOLD,20));
        image1.add(l3);

        JLabel l4 =new JLabel(pack[3]);
        l4.setBounds(30,160,300,30);
        l4.setForeground(Color.RED);
        l4.setFont(new Font("Raleway", Font.BOLD,20));
        image1.add(l4);

        JLabel l5 =new JLabel(pack[4]);
        l5.setBounds(30,210,300,30);
        l5.setForeground(new Color(164, 127, 13));
        l5.setFont(new Font("Raleway", Font.BOLD,20));
        image1.add(l5);

        JLabel l6 =new JLabel(pack[5]);
        l6.setBounds(30,260,300,30);
        l6.setForeground(Color.RED);
        l6.setFont(new Font("Raleway", Font.BOLD,20));
        image1.add(l6);

        JLabel l7 =new JLabel(pack[6]);
        l7.setBounds(30,310,300,30);
        l7.setForeground(new Color(164, 127, 13));
        l7.setFont(new Font("Raleway", Font.BOLD,20));
        image1.add(l7);

        JLabel l8 =new JLabel(pack[7]);
        l8.setBounds(30,360,300,30);
        l8.setForeground(Color.RED);
        l8.setFont(new Font("Raleway", Font.BOLD,20));
        image1.add(l8);

        JLabel l9 =new JLabel(pack[8]);
        l9.setBounds(30,410,300,30);
        l9.setForeground(new Color(164, 127, 13));
        l9.setFont(new Font("Raleway", Font.BOLD,20));
        image1.add(l9);

        JLabel l10 =new JLabel(pack[9]);
        l10.setBounds(30,470,300,30);
        l10.setForeground(new Color(177, 2, 186));
        l10.setFont(new Font("Tahoma", Font.BOLD,30));
        image1.add(l10);

        JLabel l11 =new JLabel(pack[10]);
        l11.setBounds(590,425,300,30);
        l11.setForeground(new Color(164, 127, 13));
        l11.setFont(new Font("Tahoma", Font.BOLD,30));
        image1.add(l11);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/"+pack[11]));
        Image i2 =i1.getImage().getScaledInstance(350,225,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(490,130,350,225);
        image1.add(image);


        return p1;
    }
    public static void main(String[] args) {
        new CheckPakage();
    }
}
