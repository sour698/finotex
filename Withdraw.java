package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Withdraw extends JFrame implements ActionListener {
    JButton withdraw, back;
    JTextField textField1;
    String cardpin;

    Withdraw(String cardpin) {

        this.cardpin = cardpin;

        JLabel l0=new JLabel("FINOTEX BANK");
        l0.setForeground(Color.WHITE);
        l0.setFont(new Font("System",Font.BOLD,25));
        l0.setBounds(250,40,400,20);
        add(l0);

        JLabel l1 = new JLabel("MAXIMUM AMOUNT CAN BE ENTERED IS Rs.10,000");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 13));
        l1.setBounds(230, 100, 400, 20);
        add(l1);

        JLabel l2 = new JLabel("Please Enter Your Amount");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System", Font.BOLD, 15));
        l2.setBounds(230, 140, 400, 20);
        add(l2);

        textField1 = new JTextField(15);//means 15 columns wide text box
        textField1.setFont(new Font("Arial", Font.BOLD, 15));//SETING FONT STYLE AND SIZE
        textField1.setBackground(new Color(179, 255, 217));
        textField1.setForeground(Color.BLACK);
        textField1.setBounds(230,180,360,30);//helps the system to ensure where the text would be visible
        add(textField1);

        withdraw = new JButton("WITHDRAW");
        withdraw.setFont(new Font("Arial", Font.BOLD, 15));
        withdraw.setForeground(Color.WHITE);
        withdraw.setBackground(new Color(42, 128, 148));
        withdraw.setBounds(390,290,200,45);
        withdraw.addActionListener(this);
        add(withdraw);

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
            String amount = textField1.getText();
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sdf.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));  // IST timezone
            String formattedDate = sdf.format(date);
            if (e.getSource() == withdraw) {
                if (textField1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter the amount you want to withdraw");
                }
                else{
                    Con c= new Con();
                    ResultSet resultSet=c.statement.executeQuery("select * from bank where pin_number='"+cardpin+"'");
                    int balance=0;
                    while (resultSet.next()) {
                        if(resultSet.getString("type").equals("Deposit")){
                            balance+=Integer.parseInt(resultSet.getString("amount"));
                        }
                        else{
                            balance-=Integer.parseInt(resultSet.getString("amount"));
                        }
                    }
                    if(balance<Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null,"Insufficient Balance");
                        return;
                    }
                    c.statement.executeUpdate("insert into bank values('"+cardpin+"', '"+formattedDate+"','Withdrawal', '"+amount+"')");
                    JOptionPane.showMessageDialog(null,"Rs. "+amount+" debitted Successfully");
                    setVisible(false);
                    new Main_class(cardpin);
                }
            } else if (e.getSource() == back) {
                new Main_class(cardpin);
                setVisible(false);//the screen will be closed of deposition
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Withdraw("");
    }
}


