package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Deposit extends JFrame implements ActionListener {

    JButton deposit,back;
    JTextField textField1;
    String cardpin;

    Deposit(String cardpin){

        this.cardpin=cardpin;//calling the cardpin from the signup3 page

        JLabel l0=new JLabel("FINOTEX BANK");
        l0.setForeground(Color.WHITE);
        l0.setFont(new Font("System",Font.BOLD,25));
        l0.setBounds(250,40,400,20);
        add(l0);


        JLabel l1=new JLabel("Enter Amount you want to Deposit");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System",Font.BOLD,20));
        l1.setBounds(200,90,400,20);
        add(l1);

        textField1=new JTextField(15);//means 15 columns wide text box
        textField1.setFont(new Font("Arial",Font.BOLD,15));//SETING FONT STYLE AND SIZE
        textField1.setBackground(new Color(179, 255, 217));
        textField1.setForeground(Color.BLACK);
        textField1.setBounds(200,150,360,30);//helps the system to ensure where the text would be visible
        add(textField1);

        deposit=new JButton("DEPOSIT");
        deposit.setFont(new Font("Arial",Font.BOLD,15));
        deposit.setForeground(Color.WHITE);
        deposit.setBackground(new Color(42, 128, 148));
        deposit.setBounds(390,290,200,45);
        deposit.addActionListener(this);
        add(deposit);

        back=new JButton("BACK");
        back.setFont(new Font("Arial",Font.BOLD,15));
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
            Date date= new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sdf.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));  // IST timezone
            String formattedDate = sdf.format(date);
            if(e.getSource()==deposit) {
                if (textField1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter the amount you want to deposit");
                } else {
                    Con c = new Con();
                    c.statement.executeUpdate("insert into bank values('"+cardpin+"', '"+formattedDate+"','Deposit', '"+amount+"')");
                    JOptionPane.showMessageDialog(null,"Rs. "+amount+" Deposited Successfully");
                    setVisible(false);
                    new Main_class(cardpin);
                }
            }
            else if(e.getSource()==back){
                new Main_class(cardpin);
                setVisible(false);//the screen will be closed of deposition
            }
        }catch(Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[]args){
        new Deposit("");

    }
}
