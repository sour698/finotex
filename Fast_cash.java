package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

    public class Fast_cash extends JFrame implements ActionListener {
        JButton b1,b2,b3,b4,b5,b6,b7;
        String cardpin;
        Fast_cash(String cardpin){
            this.cardpin=cardpin;

            JLabel l0=new JLabel("FINOTEX BANK");
            l0.setForeground(Color.WHITE);
            l0.setFont(new Font("System",Font.BOLD,25));
            l0.setBounds(250,40,400,20);
            add(l0);

            JLabel l1=new JLabel("SELECT WITHDRAWAL AMOUNT");
            l1.setForeground(Color.WHITE);
            l1.setFont(new Font("System",Font.BOLD,20));
            l1.setBounds(200,90,400,20);
            add(l1);

            b1=new JButton("Rs. 100");
            b1.setFont(new Font("Arial",Font.BOLD,15));
            b1.setForeground(Color.WHITE);
            b1.setBackground(new Color(42, 128, 148));
            b1.setBounds(100, 150, 200, 45);
            b1.addActionListener(this);
            add(b1);

            b2=new JButton("Rs. 1000");
            b2.setFont(new Font("Arial",Font.BOLD,15));
            b2.setForeground(Color.WHITE);
            b2.setBackground(new Color(42, 128, 148));
            b2.setBounds(100, 220, 200, 45);
            b2.addActionListener(this);
            add(b2);

            b3=new JButton("Rs. 5000");
            b3.setFont(new Font("Arial",Font.BOLD,15));
            b3.setForeground(Color.WHITE);
            b3.setBackground(new Color(42, 128, 148));
            b3.setBounds(100, 290, 200, 45);
            b3.addActionListener(this);
            add(b3);

            b4=new JButton("Rs. 500");
            b4.setFont(new Font("Arial",Font.BOLD,15));
            b4.setForeground(Color.WHITE);
            b4.setBackground(new Color(42, 128, 148));
            b4.setBounds(390, 150, 200, 45);
            b4.addActionListener(this);
            add(b4);

            b5=new JButton("Rs. 2000");
            b5.setFont(new Font("Arial",Font.BOLD,15));
            b5.setForeground(Color.WHITE);
            b5.setBackground(new Color(42, 128, 148));
            b5.setBounds(390,220,200,45);
            b5.addActionListener(this);
            add(b5);

            b6=new JButton("Rs. 10000");
            b6.setFont(new Font("Arial",Font.BOLD,15));
            b6.setForeground(Color.WHITE);
            b6.setBackground(new Color(42, 128, 148));
            b6.setBounds(390,290,200,45);
            b6.addActionListener(this);
            add(b6);

            b7=new JButton("BACK");
            b7.setFont(new Font("Arial",Font.BOLD,15));
            b7.setForeground(Color.WHITE);
            b7.setBackground(new Color(42, 128, 148));
            b7.setBounds(250,370,200,45);
            b7.addActionListener(this);
            add(b7);

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
            if(e.getSource()==b7){
                setVisible(false);//screen will be closed and the mainclass screen will be opened
                new Main_class(cardpin);
            }
            else{
                String amount=((JButton)e.getSource()).getText().substring(4);// the Rs. Part will removed
                Con c = new Con();
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                sdf.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));  // IST timezone
                String formattedDate = sdf.format(date);

                try{
                    ResultSet resultSet = c.statement.executeQuery("select * from bank where pin_number = '"+cardpin+"'");
                    int balance =0;
                    while (resultSet.next()){
                        if (resultSet.getString("type").equals("Deposit")){
                            balance += Integer.parseInt(resultSet.getString("amount"));
                        }else {
                            balance -= Integer.parseInt(resultSet.getString("amount"));
                        }
                    }

                    if (e.getSource() != b7 && balance < Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
                        return;
                    }

                    c.statement.executeUpdate("insert into bank values('"+cardpin+"','"+formattedDate+"', 'withdrawl', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
                }catch (Exception E){
                    E.printStackTrace();
                }
                setVisible(false);
                new Main_class(cardpin);
            }

        }

    public static void main(String[]args){
        new Fast_cash("");
    }
}

