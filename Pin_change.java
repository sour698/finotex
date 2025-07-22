package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Pin_change extends JFrame implements ActionListener {
    JPasswordField passwordField1, passwordField2;
    JButton b1, back;
    String cardpin;

    Pin_change(String cardpin) {

        this.cardpin=cardpin;

        JLabel l0=new JLabel("FINOTEX BANK");
        l0.setForeground(Color.WHITE);
        l0.setFont(new Font("System",Font.BOLD,25));
        l0.setBounds(250,40,400,20);
        add(l0);

        JLabel l1 = new JLabel("CHANGE YOUR PIN:");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 20));
        l1.setBounds(200,90,400,20);
        add(l1);

        JLabel l2 = new JLabel("New Pin:");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System", Font.BOLD, 16));
        l2.setBounds(200, 140, 100, 20);
        add(l2);

        passwordField1 = new JPasswordField(15);//means 15 columns wide text box
        passwordField1.setFont(new Font("Arial", Font.BOLD, 15));
        passwordField1.setBackground(new Color(179, 255, 217));
        passwordField1.setForeground(Color.BLACK);
        passwordField1.setBounds(370, 140, 200, 30);//helps the system to ensure where the text would be visible
        add(passwordField1);

        JLabel l3 = new JLabel("Re-Type New Pin:");
        l3.setForeground(Color.WHITE);
        l3.setFont(new Font("System", Font.BOLD, 16));
        l3.setBounds(200, 190, 200, 20);
        add(l3);

        passwordField2 = new JPasswordField(15);//means 15 columns wide text box
        passwordField2.setFont(new Font("Arial", Font.BOLD, 15));
        passwordField2.setBackground(new Color(179, 255, 217));
        passwordField2.setForeground(Color.BLACK);
        passwordField2.setBounds(370, 190, 200, 30);//helps the system to ensure where the text would be visible
        add(passwordField2);

        b1 = new JButton("CHANGE");
        b1.setFont(new Font("Arial", Font.BOLD, 15));
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(42, 128, 148));
        b1.setBounds(390,290,200,45);
        b1.addActionListener(this);
        add(b1);

        back = new JButton("BACK");
        back.setFont(new Font("Arial", Font.BOLD, 15));
        back.setForeground(Color.WHITE);
        back.setBackground(new Color(42, 128, 148));
        back.setBounds(390,360,200,45);
        back.addActionListener(this);
        add(back);

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
        try {

            String pin1 = new String(passwordField1.getPassword());
            String pin2 = new String(passwordField2.getPassword());

            if (!pin1.equals(pin2)) {
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }

            if (e.getSource() == b1) {
                if (passwordField1.getPassword().equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                    return;
                }
                if (passwordField2.getPassword().equals("")) {
                    JOptionPane.showMessageDialog(null, "Re-Enter New PIN");
                    return;
                }

                Con c = new Con();
                String q1 = "update bank set pin_number = '"+pin1+"' where pin_number = '"+cardpin+"'";
                String q2 = "update login set pin_number = '"+pin1+"' where pin_number = '"+cardpin+"'";
                String q3 = "update signup3 set pin_number = '"+pin1+"' where pin_number = '"+cardpin+"'";
                c.statement.executeUpdate(q1);
                c.statement.executeUpdate(q2);
                c.statement.executeUpdate(q3);
                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Main_class(cardpin);

            } else if (e.getSource() == back) {
                new Main_class(cardpin);
                setVisible(false);
            }


        } catch (Exception E) {
            E.printStackTrace();
        }


    }

    public static void main(String[] args) {
        new Pin_change("");
    }
}
