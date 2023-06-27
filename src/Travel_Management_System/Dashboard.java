package Travel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener, Runnable{
    JButton logout, personalDetail, updatePD,viewPD, deletePD, checkpakage,bookPackage,viewPackage,destination,bus,train,flight,payment,calculater,notepade,about;
    String username;
    Thread t1;
    JLabel l1, l2,l3 ,l4, l5, l6, l7, l8, l9, l10;
    JLabel [] lable = new JLabel[]{l1, l2, l3 ,l4, l5, l6, l7, l8, l9, l10};
    JLabel caption;

    Dashboard(String username){
        this.username = username;
//        setBounds(0,0,1600,1000);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // for full screen
        setLayout(null);


        caption = new JLabel();
        caption.setBounds(535,80,1000,70);
        caption.setForeground(Color.BLACK);
        caption.setFont(new Font("Tahoma",Font.BOLD,55));
        add(caption);

        ImageIcon i1=null,i2=null,i3=null,i4=null,i5=null,i6=null,i7=null,i8=null,i9=null,i10=null;
        ImageIcon [] image1 = new ImageIcon[]{i1,i2,i3,i4,i5,i6,i7,i8,i9,i10};

        Image j1=null,j2=null,j3=null,j4=null,j5=null,j6=null,j7=null,j8=null,j9=null,j10=null;
        Image [] image2 = new Image[]{j1,j2,j3,j4,j5,j6,j7,j8,j9,j10};

        ImageIcon k1=null,k2=null,k3=null,k4=null,k5=null,k6=null,k7=null,k8=null,k9=null,k10=null;
        ImageIcon [] image3 = new ImageIcon[]{k1,k2,k3,k4,k5,k6,k7,k8,k9,k10};

        for(int i = 0; i<=9;i++) {
            image1[i] = new ImageIcon(ClassLoader.getSystemResource("dashboard/dest"+(i+1)+".jpg"));
            image2[i] = image1[i].getImage().getScaledInstance(1542, 911, Image.SCALE_DEFAULT);
            image3[i] = new ImageIcon(image2[i]);
            lable[i] = new JLabel(image3[i]);
            lable[i].setBounds(300, 65, 1542, 911);
            add(lable[i]);
        }

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(15, 137, 218));
        p1.setBounds(0,0,1600,65);
        add(p1);



        ImageIcon im1 = new ImageIcon(ClassLoader.getSystemResource("icon/dashboard.png"));
        Image im2 = im1.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT);
        ImageIcon im3 = new ImageIcon(im2);
        JLabel icon = new JLabel(im3);
        icon.setBounds(5,0,70,70);
        p1.add(icon);

        t1 = new Thread(this);
        t1.start();


        JLabel heading = new JLabel("Home");
        heading.setBounds(80,15,300,40);
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("Raleway",Font.BOLD,30));
        p1.add(heading);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(15, 137, 218));
        p2.setBounds(0,65,300,900);
        add(p2);

        logout = new JButton("Logout");
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.setBounds(1420,20,100,25);
        logout.addActionListener(this);
        p1.add(logout);

        personalDetail = new JButton("Add Personal Details");
        personalDetail.setBounds(0,0,300,49);
        personalDetail.setBackground(new Color(15, 137, 218));
        personalDetail.setForeground(Color.BLACK);
        personalDetail.setFont(new Font("Raleway", Font.PLAIN, 20));
        personalDetail.setMargin(new Insets(0,0,0,20));
        personalDetail.addActionListener(this);
        p2.add(personalDetail);

        updatePD = new JButton("Update Personal Details");
        updatePD.setBounds(0,49,300,49);
        updatePD.setBackground(new Color(15, 137, 218));
        updatePD.setForeground(Color.BLACK);
        updatePD.setFont(new Font("Raleway", Font.PLAIN, 20));
        updatePD.setMargin(new Insets(0,0,0,20));
        updatePD.addActionListener(this);
        p2.add(updatePD);

        viewPD = new JButton("View Personal Details");
        viewPD.setBounds(0,98,300,49);
        viewPD.setBackground(new Color(15, 137, 218));
        viewPD.setForeground(Color.BLACK);
        viewPD.setFont(new Font("Raleway", Font.PLAIN, 20));
        viewPD.setMargin(new Insets(0,0,0,20));
        viewPD.addActionListener(this);
        p2.add(viewPD);

        deletePD = new JButton("Delete Personal Details");
        deletePD.setBounds(0,147,300,49);
        deletePD.setBackground(new Color(15, 137, 218));
        deletePD.setForeground(Color.BLACK);
        deletePD.setFont(new Font("Raleway", Font.PLAIN, 20));
        deletePD.setMargin(new Insets(0,0,0,20));
        deletePD.addActionListener(this);
        p2.add(deletePD);

        checkpakage = new JButton("Check Package");
        checkpakage.setBounds(0,196,300,49);
        checkpakage.setBackground(new Color(15, 137, 218));
        checkpakage.setForeground(Color.BLACK);
        checkpakage.setFont(new Font("Raleway", Font.PLAIN, 20));
        checkpakage.setMargin(new Insets(0,0,0,20));
        checkpakage.addActionListener(this);
        p2.add(checkpakage);

        bookPackage = new JButton("Book Package");
        bookPackage.setBounds(0,245,300,49);
        bookPackage.setBackground(new Color(15, 137, 218));
        bookPackage.setForeground(Color.BLACK);
        bookPackage.setFont(new Font("Raleway", Font.PLAIN, 20));
        bookPackage.setMargin(new Insets(0,0,0,20));
        bookPackage.addActionListener(this);
        p2.add(bookPackage);

        viewPackage = new JButton(" View Package");
        viewPackage.setBounds(0,294,300,49);
        viewPackage.setBackground(new Color(15, 137, 218));
        viewPackage.setForeground(Color.BLACK);
        viewPackage.setFont(new Font("Raleway", Font.PLAIN, 20));
        viewPackage.setMargin(new Insets(0,0,0,20));
        viewPackage.addActionListener(this);
        p2.add(viewPackage);

        destination = new JButton("Destinations");
        destination.setBounds(0,343,300,49);
        destination.setBackground(new Color(15, 137, 218));
        destination.setForeground(Color.BLACK);
        destination.setFont(new Font("Raleway", Font.PLAIN, 20));
        destination.setMargin(new Insets(0,0,0,20));
        destination.addActionListener(this);
        p2.add(destination);

        bus = new JButton("Bus Booking");
        bus.setBounds(0,392,300,49);
        bus.setBackground(new Color(15, 137, 218));
        bus.setForeground(Color.BLACK);
        bus.setFont(new Font("Raleway", Font.PLAIN, 20));
        bus.setMargin(new Insets(0,0,0,20));
        bus.addActionListener(this);
        p2.add(bus);

        train = new JButton("Train Booking");
        train.setBounds(0,441,300,49);
        train.setBackground(new Color(15, 137, 218));
        train.setForeground(Color.BLACK);
        train.setFont(new Font("Raleway", Font.PLAIN, 20));
        train.setMargin(new Insets(0,0,0,20));
        train.addActionListener(this);
        p2.add(train);

        flight = new JButton("Flight Booking");
        flight.setBounds(0,490,300,49);
        flight.setBackground(new Color(15, 137, 218));
        flight.setForeground(Color.BLACK);
        flight.setFont(new Font("Raleway", Font.PLAIN, 20));
        flight.setMargin(new Insets(0,0,0,20));
        flight.addActionListener(this);
        p2.add(flight);

        payment = new JButton("Payment");
        payment.setBounds(0,539,300,49);
        payment.setBackground(new Color(15, 137, 218));
        payment.setForeground(Color.BLACK);
        payment.setFont(new Font("Raleway", Font.PLAIN, 20));
        payment.setMargin(new Insets(0,0,0,20));
        payment.addActionListener(this);
        p2.add(payment);

        calculater = new JButton("Calculater");
        calculater.setBounds(0,588,300,49);
        calculater.setBackground(new Color(15, 137, 218));
        calculater.setForeground(Color.BLACK);
        calculater.setFont(new Font("Raleway", Font.PLAIN, 20));
        calculater.setMargin(new Insets(0,0,0,20));
        calculater.addActionListener(this);
        p2.add(calculater);

        notepade = new JButton("Notepade");
        notepade.setBounds(0,637,300,49);
        notepade.setBackground(new Color(15, 137, 218));
        notepade.setForeground(Color.BLACK);
        notepade.setFont(new Font("Raleway", Font.PLAIN, 20));
        notepade.setMargin(new Insets(0,0,0,20));
        notepade.addActionListener(this);
        p2.add(notepade);

        about = new JButton("About");
        about.setBounds(0,686,300,49);
        about.setBackground(new Color(15, 137, 218));
        about.setForeground(Color.BLACK);
        about.setFont(new Font("Raleway", Font.PLAIN, 20));
        about.setMargin(new Insets(0,0,0,20));
        about.addActionListener(this);
        p2.add(about);


        setVisible(true);
    }
    public static void main(String[] args) {
        new Dashboard("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == personalDetail){
            new AddCustomer(username);
        } else if (e.getSource()==viewPD) {
            new ViewCustomer(username);
        }else if (e.getSource()==updatePD) {
            new UpdateCustomer(username);
        }else if (e.getSource()==checkpakage) {
            new CheckPakage();
        } else if (e.getSource() == bookPackage) {
            new BookPackage(username);
        } else if (e.getSource() == viewPackage) {
            new ViewPackage(username);
        } else if (e.getSource() == destination) {
            new Destinations();
        } else if (e.getSource()==payment) {
            new Payment();
        } else if(e.getSource()==calculater){
            try{
                Runtime .getRuntime().exec("calc.exe");
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (e.getSource() == notepade) {
            try{
                Runtime .getRuntime().exec("notepad.exe");
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (e.getSource() == about) {
            new About();
        } else if (e.getSource()==deletePD) {
            new DeleteDetails(username);
        }else if(e.getSource()==logout){
            new Login();
            setVisible(false);
        } else if (e.getSource() == bus) {
            new Bus();
        } else if (e.getSource()==train) {
            new Train();
        }else if(e.getSource()==flight){
            new Flight();
        }
    }

    @Override
    public void run() {
        try{
            int j = 1;
            while(j !=0) {
                for (int i = 0; i <= 9; i++) {
                    lable[i].setVisible(true);
                    caption.setText("Travel Management System");
                    Thread.sleep(2500);
                    lable[i].setVisible(false);
                }
            }
        }catch(Exception E){
            E.printStackTrace();
        }
    }
}
