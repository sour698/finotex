package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUp3 extends JFrame implements ActionListener {
    JButton submit,cancel;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JRadioButton r1,r2,r3,r4;
    String formno;
    //create Constructor
        SignUp3(String formno){

        super("APPLICATION FORM");

        this.formno=formno;//calling of the formno from the signup2 class to this class
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));// loading the image in frame
        Image i2=i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);//scalability of image
        ImageIcon i3=new ImageIcon(i2);//make the image visible in frame
        JLabel image=new JLabel(i3);//jLabel helps the image to be visible in frame
        image.setBounds(25,10,100,100);//helps the system to ensure where the image would be visible
        add(image);//image added to frame successfully



        //Page 3
        JLabel label1=new JLabel("Page 3 :-");
        label1.setFont(new Font("Raleway",Font.BOLD,22));
        label1.setBounds(300,30,400,30);
        add(label1);

        //Account Details
        JLabel label2=new JLabel("Account Details ");
        label2.setFont(new Font("Raleway",Font.BOLD,22));
        label2.setBounds(300,70,600,30);
        add(label2);

        //Account Type
        JLabel labelAccount=new JLabel("Account Type:");
        labelAccount.setFont(new Font("Raleway",Font.BOLD,17));
        labelAccount.setBounds(100,130,200,25);
        add(labelAccount);

        r1=new JRadioButton("Savings Account");
        r1.setFont(new Font("Raleway",Font.BOLD,13));
        r1.setBackground(new Color(255,255,153));
        r1.setBounds(100,160,200,25);
        add(r1);

        r2=new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway",Font.BOLD,13));
        r2.setBackground(new Color(255,255,153));
        r2.setBounds(350,160,200,25);
        add(r2);

        r3=new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,13));
        r3.setBackground(new Color(255,255,153));
        r3.setBounds(100,190,200,25);
        add(r3);

        r4=new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway",Font.BOLD,13));
        r4.setBackground(new Color(255,255,153));
        r4.setBounds(350,190,200,25);
        add(r4);

        ButtonGroup buttonGroup=new ButtonGroup();//grouping of buttons
        buttonGroup.add(r1);
        buttonGroup.add(r2);
        buttonGroup.add(r3);
        buttonGroup.add(r4);

        //Card Number
        JLabel labelCard=new JLabel("Card Number:");
        labelCard.setFont(new Font("Raleway",Font.BOLD,17));
        labelCard.setBounds(100,240,200,25);
        add(labelCard);

        JLabel label3=new JLabel("(Your 16-digit Card Number)");
        label3.setFont(new Font("Raleway",Font.BOLD,12));
        label3.setBounds(100,260,200,20);
        add(label3);

        //Card Number details
        JLabel labelCardNo=new JLabel("XXXX-XXXX-XXXX-5342");
        labelCardNo.setFont(new Font("Raleway",Font.BOLD,15));
        labelCardNo.setBounds(360,240,200,25);
        add(labelCardNo);

        JLabel label4=new JLabel("It would appear on ATM Card,Cheque Book and Bank Statements");
        label4.setFont(new Font("Raleway",Font.BOLD,12));
        label4.setBounds(350,260,400,20);
        add(label4);

        //Pin Number
        JLabel labelpin=new JLabel("PIN:");
        labelpin.setFont(new Font("Raleway",Font.BOLD,17));
        labelpin.setBounds(100,300,200,25);
        add(labelpin);

        JLabel label5=new JLabel("(4-digit password)");
        label5.setFont(new Font("Raleway",Font.BOLD,12));
        label5.setBounds(100,320,200,20);
        add(label5);

        JLabel labelpin1=new JLabel("XXXX");
        labelpin1.setFont(new Font("Raleway",Font.BOLD,15));
        labelpin1.setBounds(360,300,200,25);
        add(labelpin1);

        //Services Required
        JLabel labelService=new JLabel("Services Required:");
        labelService.setFont(new Font("Raleway",Font.BOLD,17));
        labelService.setBounds(100,360,200,25);
        add(labelService);

        c1=new JCheckBox("ATM CARD");
        c1.setFont(new Font("Raleway",Font.BOLD,15));
        c1.setBackground(new Color(255,255,153));
        c1.setBounds(100,390,200,25);
        add(c1);

        c2=new JCheckBox("MOBILE BANKING");
        c2.setFont(new Font("Raleway",Font.BOLD,15));
        c2.setBackground(new Color(255,255,153));
        c2.setBounds(100,420,200,25);
        add(c2);

        c3=new JCheckBox("CHEQUE BOOK");
        c3.setFont(new Font("Raleway",Font.BOLD,15));
        c3.setBackground(new Color(255,255,153));
        c3.setBounds(100,450,200,25);
        add(c3);

        c4=new JCheckBox("INTERNET BANKING");
        c4.setFont(new Font("Raleway",Font.BOLD,15));
        c4.setBackground(new Color(255,255,153));
        c4.setBounds(350,390,200,25);
        add(c4);

        c5=new JCheckBox("EMAIL ALERTS");
        c5.setFont(new Font("Raleway",Font.BOLD,15));
        c5.setBackground(new Color(255,255,153));
        c5.setBounds(350,420,200,25);
        add(c5);

        c6=new JCheckBox("E-STATEMENTS");
        c6.setFont(new Font("Raleway",Font.BOLD,15));
        c6.setBackground(new Color(255,255,153));
        c6.setBounds(350,450,200,25);
        add(c6);

        c7=new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge");
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBackground(new Color(255,255,153));
        c7.setBounds(100,500,800,25);
        add(c7);

        submit=new JButton("SUBMIT");
        submit.setFont(new Font("Arial",Font.BOLD,14));
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        submit.setBounds(200,560,100,30);
        submit.addActionListener(this);
        add(submit);

        cancel=new JButton("CANCEL");
        cancel.setFont(new Font("Arial",Font.BOLD,14));
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(530,560,100,30);
        cancel.addActionListener(this);
        add(cancel);

        JLabel label=new JLabel("FORM NO:");
        label.setForeground(Color.BLACK);//text colour set
        label.setFont(new Font("Raleway",Font.BOLD,15));//SET OF Font size,name and style
        label.setBounds(600,10,80,20);//helps the system to ensure where the text would be visible
        add(label);//TEXT  added to frame successfully

        JLabel label6=new JLabel(formno);
        label6.setForeground(Color.BLACK);//text colour set
        label6.setFont(new Font("Raleway",Font.BOLD,15));//SET OF Font size,name and style
        label6.setBounds(690,10,100,20);//helps the system to ensure where the text would be visible
        add(label6);//TEXT  added to frame successfully

        setLayout(null);
        setSize(800,750);
        setLocation(350,30);
        getContentPane().setBackground(new Color(255,255,153));
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String acc_type=null;
        if(r1.isSelected()){
            acc_type="Savings Account";
        }
        else if(r2.isSelected()){
            acc_type="Fixed Deposit Account";
        }
        else if(r3.isSelected()){
            acc_type="Current Account";
        }
        else if(r4.isSelected()){
            acc_type="Recurring Deposit Account";
        }
        //card no generation
        Random ran= new Random();
        long first7=(ran.nextLong()% 90000000L)+1409963000000000L;
        String cardno=""+Math.abs(first7);

        //pin generation
        long first3=(ran.nextLong()% 9000L)+1000L;
        String cardpin=""+Math.abs(first3);

        //services
        String ser="";
        if(c1.isSelected()){
            ser=ser+"ATM CARD";
        }
        if(c2.isSelected()) {
            ser =ser+"MOBILE BANKING";
        }
        else if(c3.isSelected()) {
            ser =ser+"CHEQUE BOOK";
        }
        else if(c4.isSelected()) {
            ser =ser+"INTERNET BANKING";
        }
        else if(c5.isSelected()) {
            ser =ser+"EMAIL ALERTS";
        }
        else if(c6.isSelected()) {
            ser =ser+"E-STATEMENTS";
        }
        try{
            //if we click on the submit button
            if(e.getSource()==submit){
                //if the account type is empty
                if(acc_type.equals("")){
                    JOptionPane.showMessageDialog(null,"Fill all the fields");
                }
                else{
                    Con con1= new Con();
                    //in the string q , the query is stored which is the details of the applicant.
                    String q1="insert into signup3 values('"+formno+"','"+acc_type+"','"+cardno+"','"+cardpin+"','"+ser+"')";//execute the query
                    String q2="insert into login values('"+formno+"','"+cardno+"','"+cardpin+"')";
                    con1.statement.executeUpdate(q1);
                    con1.statement.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null,"Card Number: "+cardno+"\nPin number:"+cardpin);// on the message box the card number and the pin number will be shown
                    new Deposit(cardpin);
                    setVisible(false);
                }
            }
            //if we click on the cancel button
            else if(e.getSource()==cancel){
                System.exit(0);//it will close the system

            }

        }catch(Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[]args){

        new SignUp3("");//object of the class is created
    }
}
