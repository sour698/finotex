package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JLabel label1,label2,label3;
    JTextField textField2;//FOR THE SECOND LABEL
    JPasswordField passwordField3;// FOR THE THIRD LABEL
    JButton button1,button2,button3;

    //create a constructor
    Login(){
        super("Bank Management System");//title of the webpage

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));// loading the image in frame
        Image i2=i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);//scalability of image
        ImageIcon i3=new ImageIcon(i2);//make the image visible in frame
        JLabel image=new JLabel(i3);//jLabel helps the image to be visible in frame
        image.setBounds(370,10,100,100);//helps the system to ensure where the image would be visible
        add(image);//image added to frame successfully

        ImageIcon ii1=new ImageIcon(ClassLoader.getSystemResource("icon/cards.png"));// loading the image in frame
        Image ii2=ii1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);//scalability of image
        ImageIcon ii3=new ImageIcon(ii2);//make the image visible in frame
        JLabel iimage=new JLabel(ii3);//jLabel helps the image to be visible in frame
        iimage.setBounds(630,300,100,100);//helps the system to ensure where the image would be visible
        add(iimage);//image added to frame successfully

        label1=new JLabel("WELCOME TO FINOTEX BANK");
        label1.setForeground(Color.BLACK);//text colour set
        label1.setFont(new Font("AvantGarde",Font.BOLD,30));//SET OF Font size,name and style
        label1.setBounds(250,140,450,40);//helps the system to ensure where the text would be visible
        add(label1);//TEXT  added to frame successfully

        label2=new JLabel("CARD NO:");
        label2.setFont(new Font("Ralway",Font.BOLD,20));
        label2.setForeground(Color.BLACK);
        label2.setBounds(200,200,375,30);
        add(label2);

        //CARD NO FIELD
        textField2=new JTextField(15);//means 15 columns wide text box
        textField2.setFont(new Font("Arial",Font.BOLD,14));//SETING FONT STYLE AND SIZE
        textField2.setBounds(325,200,230,30);//helps the system to ensure where the text would be visible
        add(textField2);

        label3=new JLabel("PIN :");
        label3.setFont(new Font("Ralway",Font.BOLD,20));
        label3.setForeground(Color.BLACK);
        label3.setBounds(200,260,375,30);
        add(label3);

        //PIN NO FIELD
        passwordField3=new JPasswordField(15);//means 15 columns wide text box
        passwordField3.setFont(new Font("Arial",Font.BOLD,14));
        passwordField3.setBounds(325,260,230,30);//helps the system to ensure where the text would be visible
        add(passwordField3);

        //SIGN IN BUTTON
        button1=new JButton("SIGN IN");
        button1.setFont(new Font("Arial",Font.BOLD,14));
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.BLACK);
        button1.setBounds(320,310,100,30);
        button1.addActionListener(this);//for the action to be implemented
        add(button1);

        //CLEAR BUTTON
        button2=new JButton("CLEAR");
        button2.setFont(new Font("Arial",Font.BOLD,14));
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.BLACK);
        button2.setBounds(450,310,100,30);
        button2.addActionListener(this);//for the action to be implemented
        add(button2);

        //SIGN UP BUTTON
        button3=new JButton("SIGN UP");
        button3.setFont(new Font("Arial",Font.BOLD,14));
        button3.setForeground(Color.WHITE);
        button3.setBackground(Color.BLACK);
        button3.setBounds(320,350,230,30);
        button3.addActionListener(this);//for the action to be implemented
        add(button3);


        ImageIcon iii1=new ImageIcon(ClassLoader.getSystemResource("icon/background.jpg"));// loading the image in frame
        Image iii2=iii1.getImage().getScaledInstance(850,480, Image.SCALE_DEFAULT);//scalability of backgd image is same as frame size
        ImageIcon iii3=new ImageIcon(iii2);//make the image visible in frame
        JLabel iiimage=new JLabel(iii3);//jLabel helps the image to be visible in frame
        iiimage.setBounds(0,0,850,480);//helps the system to ensure where the image would be visible( for backgd  always x=0 and y=0)
        add(iiimage);//image added to frame successfully

        setLayout(null);
        setSize(850,480);//size of the frame
        setLocation(250,90);//adjusting the frame from x-axis ie from left to right shift
        //adjusting the frame from y-axis ie from top to down shift
        setUndecorated(true);
        setVisible(true);//frame visibility
    }
    //work of "ActionEvent" is that it takes the command from the button 1,2,3, with the help of action listener
    // and then finds out inside try through if-else statements that which button is working and then does the action accordingly
    @Override
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource() == button1){
                String cardno = textField2.getText().trim();
                String cardpin = passwordField3.getText().trim();
                String q = "select * from login where card_number= '"+cardno+"' and pin_number= '"+cardpin+"'";

                System.out.println("Executing Query: " + q); // Debug print

                Con c = new Con();
                ResultSet resultSet = c.statement.executeQuery(q);

                if(resultSet.next()){
                    System.out.println("Login successful");
                    setVisible(false);
                    new Main_class(cardpin);
                } else {
                    System.out.println("Login failed");
                    JOptionPane.showMessageDialog(null,"Incorrect Card number or pin number");
                }
            }

            else if(e.getSource()==button2){
                textField2.setText("");//clearing the text
                passwordField3.setText("");//clearing the password
            }
            else if(e.getSource()==button3){
                new SignUp();
                setVisible(false);
            }

        }catch(Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[]args){

        new Login();//object is created for constructor Login
    }
}
