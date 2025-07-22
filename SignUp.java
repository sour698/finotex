package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUp extends JFrame implements ActionListener {

    JRadioButton r1,r2,r3,r4,r5;
    JButton next;
    JTextField textName,textFName,textEmail,textAdd,textCity,textPinCode,textState;
    JDateChooser dateChooser;
    //random generation of application form no.
    Random ran= new Random();
    long first4=(ran.nextLong()%9000L)+1000L;
    String first=" "+Math.abs(first4);
    //create a constructor
    SignUp(){
        super("APPLICATION FORM");

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));// loading the image in frame
        Image i2=i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);//scalability of image
        ImageIcon i3=new ImageIcon(i2);//make the image visible in frame
        JLabel image=new JLabel(i3);//jLabel helps the image to be visible in frame
        image.setBounds(25,10,100,100);//helps the system to ensure where the image would be visible
        add(image);//image added to frame successfully

        //for the application no.
        JLabel label1=new JLabel("APPLICATION FORM NO."+first);
        label1.setForeground(Color.BLACK);//text colour set
        label1.setFont(new Font("Raleway",Font.BOLD,30));//SET OF Font size,name and style
        label1.setBounds(160,20,800,30);//helps the system to ensure where the text would be visible
        add(label1);//TEXT  added to frame successfully

        //for the page 1.
        JLabel label2=new JLabel("Page 1");
        label2.setFont(new Font("Raleway",Font.BOLD,22));
        label2.setBounds(330,70,400,30);
        add(label2);

        //for the personal details
        JLabel label3=new JLabel("Personal Details");
        label3.setFont(new Font("Raleway",Font.BOLD,22));
        label3.setBounds(290,110,600,30);
        add(label3);

        //Name
        JLabel labelName=new JLabel("Name :");
        labelName.setFont(new Font("Raleway",Font.BOLD,17));
        labelName.setBounds(100,160,80,25);
        add(labelName);

        textName=new JTextField();
        textName.setFont(new Font("Raleway",Font.BOLD,13));//SETING FONT STYLE AND SIZE
        textName.setBounds(300,160,400,25);//helps the system to ensure where the text would be visible
        add(textName);

        //father's Name
        JLabel labelFName=new JLabel("Father's Name :");
        labelFName.setFont(new Font("Raleway",Font.BOLD,17));
        labelFName.setBounds(100,190,200,25);
        add(labelFName);

        textFName=new JTextField();
        textFName.setFont(new Font("Raleway",Font.BOLD,13));//SETING FONT STYLE AND SIZE
        textFName.setBounds(300,190,400,25);//helps the system to ensure where the text would be visible
        add(textFName);

        //DOB
        JLabel dob=new JLabel("Date of Birth :");
        dob.setFont(new Font("Raleway",Font.BOLD,17));
        dob.setBounds(100,220,200,25);
        add(dob);

        //date of birth choose using calender
        dateChooser=new JDateChooser();
        dateChooser.setForeground(new Color(205,205,205));
        dateChooser.setBounds(300,220,400,25);
        add(dateChooser);

        //gender
        JLabel gender=new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,17));
        gender.setBounds(100,250,200,25);
        add(gender);

        r1=new JRadioButton("Male");
        r1.setFont(new Font("Raleway",Font.BOLD,13));
        r1.setBackground(new Color(222,255,228));
        r1.setBounds(300,250,60,25);
        add(r1);

        r2=new JRadioButton("Female");
        r2.setFont(new Font("Raleway",Font.BOLD,13));
        r2.setBackground(new Color(222,255,228));
        r2.setBounds(400,250,90,25);
        add(r2);

        ButtonGroup buttonGroup=new ButtonGroup();//grouping of buttons means if we select male then female will be deselected and if we select female the male will be deselected
        buttonGroup.add(r1);
        buttonGroup.add(r2);

        //EMAIL ID
        JLabel labelEmail=new JLabel("Email ID :");
        labelEmail.setFont(new Font("Raleway",Font.BOLD,17));
        labelEmail.setBounds(100,280,200,25);
        add(labelEmail);

        textEmail=new JTextField();
        textEmail.setFont(new Font("Raleway",Font.BOLD,13));//SETING FONT STYLE AND SIZE
        textEmail.setBounds(300,280,400,25);//helps the system to ensure where the text would be visible
        add(textEmail);

        //Marital status
        JLabel labelMs=new JLabel("Marital status :");
        labelMs.setFont(new Font("Raleway",Font.BOLD,17));
        labelMs.setBounds(100,310,200,25);
        add(labelMs);

        r3=new JRadioButton("Married");
        r3.setFont(new Font("Raleway",Font.BOLD,13));
        r3.setBackground(new Color(222,255,228));
        r3.setBounds(300,310,90,25);
        add(r3);

        r4=new JRadioButton("Unmarried");
        r4.setFont(new Font("Raleway",Font.BOLD,13));
        r4.setBackground(new Color(222,255,228));
        r4.setBounds(400,310,90,25);
        add(r4);

        r5=new JRadioButton("Widow");
        r5.setFont(new Font("Raleway",Font.BOLD,13));
        r5.setBackground(new Color(222,255,228));
        r5.setBounds(550,310,90,25);
        add(r5);

        ButtonGroup buttonGroup1=new ButtonGroup();
        buttonGroup1.add(r3);
        buttonGroup1.add(r4);
        buttonGroup1.add(r5);

        //Address
        JLabel labelAdd=new JLabel("Address :");
        labelAdd.setFont(new Font("Raleway",Font.BOLD,17));
        labelAdd.setBounds(100,340,200,25);
        add(labelAdd);

        textAdd=new JTextField();
        textAdd.setFont(new Font("Raleway",Font.BOLD,13));//SETING FONT STYLE AND SIZE
        textAdd.setBounds(300,340,400,25);//helps the system to ensure where the text would be visible
        add(textAdd);

        //City
        JLabel labelCity=new JLabel("City :");
        labelCity.setFont(new Font("Raleway",Font.BOLD,17));
        labelCity.setBounds(100,370,200,25);
        add(labelCity);

        textCity=new JTextField();
        textCity.setFont(new Font("Raleway",Font.BOLD,13));//SETING FONT STYLE AND SIZE
        textCity.setBounds(300,370,200,25);//helps the system to ensure where the text would be visible
        add(textCity);

        //Pincode
        JLabel labelPinCode=new JLabel("Pincode :");
        labelPinCode.setFont(new Font("Raleway",Font.BOLD,17));
        labelPinCode.setBounds(100,400,200,25);
        add(labelPinCode);

        textPinCode=new JTextField();
        textPinCode.setFont(new Font("Raleway",Font.BOLD,14));//SETING FONT STYLE AND SIZE
        textPinCode.setBounds(300,400,200,25);//helps the system to ensure where the text would be visible
        add(textPinCode);

        //State
        JLabel labelState=new JLabel("State :");
        labelState.setFont(new Font("Raleway",Font.BOLD,17));
        labelState.setBounds(100,430,200,25);
        add(labelState);

        textState=new JTextField();
        textState.setFont(new Font("Raleway",Font.BOLD,17));//SETING FONT STYLE AND SIZE
        textState.setBounds(300,430,200,25);//helps the system to ensure where the text would be visible
        add(textState);

        next=new JButton("NEXT");
        next.setFont(new Font("Arial",Font.BOLD,14));
        next.setForeground(Color.WHITE);
        next.setBackground(Color.BLACK);
        next.setBounds(630,500,100,30);
        next.addActionListener(this);
        add(next);



         getContentPane().setBackground(new Color(222,255,228));//set the colour of the background using rgb
         setLayout(null);
         setSize(850,800);
         setLocation(330,30);
        setUndecorated(true);
         setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //on clicking next button the details will be saved in the mysql database
       String formno=first;
       String name=textName.getText();
       String fname=textFName.getText();
       String dob=((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
       String gender=null;
       if(r1.isSelected()){
           gender="Male";
       }
       else if(r2.isSelected()){
           gender="Female";
       }
       String email=textEmail.getText();
       String ms=null;
        if(r3.isSelected()){
            ms="Married";
        }
        else if(r4.isSelected()){
            ms="Unmarried";
        }else if(r5.isSelected()){
            ms="Widow";
        }
        String address=textAdd.getText();
        String city=textCity.getText();
        String pincode=textPinCode.getText();
        String state=textState.getText();

        //for the data to be stored there maybe some exceptions coming
        try{
            //If the name field is blank then this will be shown
            if(textName.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Fill all the fields");
            }
            //else the name will be gone into the data base
            else{
                Con con1= new Con();
                //in the string q , the query is stored which is the details of the applicant.
                String q="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+ms+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
                //execute the query
                con1.statement.executeUpdate(q);
                // go to the next signup page
                new SignUp2(first);//object of signup2 page which will open the class SignUp2 page
                setVisible(false);//the current signUp page will be closed
            }


        }catch(Exception E){
            E.printStackTrace();
        }

    }

    public static void main(String[] args){

        new SignUp();//new object created for the signUp
    }
}
