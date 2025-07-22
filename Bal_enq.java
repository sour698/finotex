package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Bal_enq extends JFrame implements ActionListener {
    JButton b1;
    String cardpin;
    Bal_enq(String cardpin){
        this.cardpin=cardpin;

        JLabel l0=new JLabel("FINOTEX BANK");
        l0.setForeground(Color.WHITE);
        l0.setFont(new Font("System",Font.BOLD,25));
        l0.setBounds(250,40,400,20);
        add(l0);

        JLabel l1=new JLabel("Your Current Account Balance is Rs:");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System",Font.BOLD,20));
        l1.setBounds(200,90,400,20);
        add(l1);

        JLabel label2 = new JLabel();
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("System", Font.BOLD, 20));
        label2.setBounds(200,140,400,35);
        add(label2);

        b1 = new JButton("BACK");
        b1.setFont(new Font("Arial",Font.BOLD,20));
        b1.setBounds(390,360,200,45);
        b1.setBackground(new Color(42, 128, 148));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        int balance =0;
        try{
            Con c = new Con();
            ResultSet resultSet = c.statement.executeQuery("Select * from bank where pin_number= '"+cardpin+"'" );
            while (resultSet.next()){
                if (resultSet.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("amount"));
                }else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        label2.setText(""+balance);


        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/MainPage.png"));// loading the image in frame
        Image i2=i1.getImage().getScaledInstance(660,530, Image.SCALE_DEFAULT);//scalability of backgd image is same as frame size
        ImageIcon i3=new ImageIcon(i2);//make the image visible in frame
        JLabel image=new JLabel(i3);//jLabel helps the image to be visible in frame
        image.setBounds(0,0,660,530);//helps the system to ensure where the image would be visible( for backgd  always x=0 and y=0)
        add(image);//image added to frame successfully

        setLayout(null);
        setSize(660,530);
        setLocation(250,90);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Main_class(cardpin);
    }

    public static void main(String[]args){
        new Bal_enq("");
    }
}
