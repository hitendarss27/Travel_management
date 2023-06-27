package Travel_Management_System;

import javax.swing.*;
import  java.awt.*;
public class Destinations extends JFrame implements Runnable{
    Thread t1;
    JLabel l1, l2,l3 ,l4, l5, l6, l7, l8, l9, l10;
    JLabel [] lable = new JLabel[]{l1, l2, l3 ,l4, l5, l6, l7, l8, l9, l10};
    JLabel caption;
    Destinations(){
        setBounds(400,150,800,600);

        caption = new JLabel();
        caption.setBounds(50,490,1000,70);
        caption.setFont(new Font("Tahoma",Font.BOLD,40));
        caption.setForeground(Color.WHITE);
        add(caption);

        ImageIcon i1=null, i2=null, i3=null ,i4=null, i5=null, i6=null, i7=null, i8=null, i9=null, i10=null;
        ImageIcon [] image = new ImageIcon[]{i1, i2, i3 ,i4, i5, i6, i7, i8, i9, i10};

        Image img1=null, img2=null, img3=null ,img4=null, img5=null, img6=null, img7=null, img8=null, img9=null, img10=null;
        Image [] jimage= new Image []{img1, img2, img3 ,img4, img5, img6, img7, img8, img9, img10};

        ImageIcon k1=null, k2=null, k3=null ,k4=null, k5=null, k6=null, k7=null, k8=null, k9=null, k10=null;
        ImageIcon [] kimage = new ImageIcon[]{k1, k2, k3 ,k4, k5, k6, k7, k8, k9, k10};



        for(int i =0; i<=9; i++) {
            image [i] = new ImageIcon(ClassLoader.getSystemResource("destination/dest"+(i+1)+".jpg"));
            jimage[i] = image[i].getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
            kimage[i] = new ImageIcon(jimage[i]);
            lable[i] = new JLabel(kimage[i]);
            lable[i].setBounds(0, 0, 800, 600);
            add(lable[i]);
        }

        t1 =new Thread(this);
        t1.start();

        setVisible(true);
    }
    public static void main(String[] args) {
        new Destinations();
    }

    @Override
    public void run() {
        String [] text = new String[]{"Jaisalmer", "Leh-Ladakh","Jaipur", "Kedarnath", "Manali", "Udaipur","Badrinath", "Pangong Lake","Bikaner","Amritsar"};
        try{
            int j = 1;
            while(j!=0) {
                for (int i = 0; i <= 9; i++) {
                    lable[i].setVisible(true);
                    caption.setText(text[i]);
                    Thread.sleep(2500);
                    lable[i].setVisible(false);
                }
            }
        }catch (Exception E){
            E.printStackTrace();
        }
    }
}
