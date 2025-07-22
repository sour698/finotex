package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp2 extends JFrame implements ActionListener {
    JButton next;
    JRadioButton r1,r2,r3,r4;
    JTextField textPan,textAadhar;
    JComboBox combobox,combobox1,combobox2,combobox3,combobox4;
    String formno;
    //create a constructor and here the formno is passed and received from signup page
    SignUp2(String formno){
        super("APPLICATION FORM");

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));// loading the image in frame
        Image i2=i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);//scalability of image
        ImageIcon i3=new ImageIcon(i2);//make the image visible in frame
        JLabel image=new JLabel(i3);//jLabel helps the image to be visible in frame
        image.setBounds(25,10,100,100);//helps the system to ensure where the image would be visible
        add(image);//image added to frame successfully

        this.formno=formno;//calling of the formno from the signup class to this class

        //Page 2
        JLabel label1=new JLabel("Page 2 :-");
        label1.setFont(new Font("Raleway",Font.BOLD,22));
        label1.setBounds(300,30,400,30);
        add(label1);

        //Additional Details
        JLabel label3=new JLabel("Additional Details ");
        label3.setFont(new Font("Raleway",Font.BOLD,22));
        label3.setBounds(300,70,600,30);
        add(label3);

        //Religion
        JLabel labelReligion=new JLabel("Religion :");
        labelReligion.setFont(new Font("Raleway",Font.BOLD,17));
        labelReligion.setBounds(100,130,200,25);
        add(labelReligion);

        //Dropdown the religion using combobox
        String religion[]={"Select","Hinduism","Islamism","Christianity","Sikhism","Other"};
        combobox=new JComboBox(religion);
        combobox.setBackground(new Color(255, 204, 255));
        combobox.setFont(new Font("Raleway",Font.BOLD,13));
        combobox.setBounds(350,130,200,25);
        add(combobox);

        //Category
        JLabel labelCategory=new JLabel("Category :");
        labelCategory.setFont(new Font("Raleway",Font.BOLD,17));
        labelCategory.setBounds(100,170,200,25);
        add(labelCategory);

        //Dropdown the category using combobox
        String category[]={"Select","General","OBC","ST","SC","Other"};
        combobox1=new JComboBox(category);
        combobox1.setBackground(new Color(255, 204, 255));
        combobox1.setFont(new Font("Raleway",Font.BOLD,13));
        combobox1.setBounds(350,170,200,25);
        add(combobox1);

        //Income
        JLabel labelIncome=new JLabel("Income :");
        labelIncome.setFont(new Font("Raleway",Font.BOLD,17));
        labelIncome.setBounds(100,210,200,25);
        add(labelIncome);

        //Dropdown the Income using combobox
        String income[] = {"Select", "No Income", "<1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000", "Above 10,00,000"};
        combobox2 = new JComboBox(income);
        combobox2.setBackground(new Color(255, 204, 255));
        combobox2.setFont(new Font("Raleway", Font.BOLD, 13));
        combobox2.setBounds(350, 210, 200, 25);
        add(combobox2);

        JLabel labelEducation = new JLabel("Educational ");
        labelEducation.setFont(new Font("Raleway", Font.BOLD, 17));
        labelEducation.setBounds(100, 250, 200, 25);
        add(labelEducation);

        JLabel labelQualify=new JLabel("Qualification : ");
        labelQualify.setFont(new Font("Raleway",Font.BOLD,17));
        labelQualify.setBounds(100,270,200,25);
        add(labelQualify);

        //Dropdown the Educational Qualification using combobox
        String eduqualify[]={"Select","Non-Graduate","Graduate","Post-Graduate","Doctorate","Others"};
        combobox3=new JComboBox(eduqualify);
        combobox3.setBackground(new Color(255, 204, 255));
        combobox3.setFont(new Font("Raleway",Font.BOLD,13));
        combobox3.setBounds(350,270,200,25);
        add(combobox3);

        //Occupation
        JLabel labelOccupation=new JLabel("Occupation :");
        labelOccupation.setFont(new Font("Raleway",Font.BOLD,17));
        labelOccupation.setBounds(100,310,200,25);
        add(labelOccupation);

        //Dropdown the Occupation using combobox
        String occupation[] = {"Select", "Salaried", "Self-Employed", "Business", "Student", "Retired", "Others"};
        combobox4 = new JComboBox(occupation);
        combobox4.setBackground(new Color(255, 204, 255));
        combobox4.setFont(new Font("Raleway", Font.BOLD, 13));
        combobox4.setBounds(350, 310, 200, 25);
        add(combobox4);

        //Pan No
        JLabel labelPan=new JLabel("Pan Number:");
        labelPan.setFont(new Font("Raleway",Font.BOLD,17));
        labelPan.setBounds(100,350,200,25);
        add(labelPan);

        textPan=new JTextField();
        textPan.setFont(new Font("Raleway",Font.BOLD,13));//SETING FONT STYLE AND SIZE
        textPan.setBounds(350,350,200,25);//helps the system to ensure where the text would be visible
        add(textPan);

        //Aadhar No
        JLabel labelAadhar=new JLabel("Aadhar Number:");
        labelAadhar.setFont(new Font("Raleway",Font.BOLD,17));
        labelAadhar.setBounds(100,390,200,25);
        add(labelAadhar);

        textAadhar=new JTextField();
        textAadhar.setFont(new Font("Raleway",Font.BOLD,13));//SETING FONT STYLE AND SIZE
        textAadhar.setBounds(350,390,200,25);//helps the system to ensure where the text would be visible
        add(textAadhar);

        //Senior Citizen
        JLabel labelSenior=new JLabel("Senior Citizen:");
        labelSenior.setFont(new Font("Raleway",Font.BOLD,17));
        labelSenior.setBounds(100,430,200,25);
        add(labelSenior);

        r1=new JRadioButton("Yes");
        r1.setFont(new Font("Raleway",Font.BOLD,13));
        r1.setBackground(new Color(255, 204, 255));
        r1.setBounds(350,430,60,25);
        add(r1);

        r2=new JRadioButton("No");
        r2.setFont(new Font("Raleway",Font.BOLD,13));
        r2.setBackground(new Color(255, 204, 255));
        r2.setBounds(450,430,60,25);
        add(r2);

        ButtonGroup buttonGroup=new ButtonGroup();//grouping of buttons
        buttonGroup.add(r1);
        buttonGroup.add(r2);

        //Existing Account
        JLabel labelExist=new JLabel("Existing Account:");
        labelExist.setFont(new Font("Raleway",Font.BOLD,17));
        labelExist.setBounds(100,470,200,25);
        add(labelExist);

        r3=new JRadioButton("Yes");
        r3.setFont(new Font("Raleway",Font.BOLD,13));
        r3.setBackground(new Color(255, 204, 255));
        r3.setBounds(350,470,60,25);
        add(r3);

        r4=new JRadioButton("No");
        r4.setFont(new Font("Raleway",Font.BOLD,13));
        r4.setBackground(new Color(255, 204, 255));
        r4.setBounds(450,470,60,25);
        add(r4);

        ButtonGroup buttonGroup1=new ButtonGroup();//grouping of buttons
        buttonGroup1.add(r1);
        buttonGroup1.add(r2);

        JLabel label=new JLabel("FORM NO:");
        label.setForeground(Color.BLACK);//text colour set
        label.setFont(new Font("Raleway",Font.BOLD,15));//SET OF Font size,name and style
        label.setBounds(600,10,80,20);//helps the system to ensure where the text would be visible
        add(label);//TEXT  added to frame successfully

        JLabel label2=new JLabel(formno);
        label2.setForeground(Color.BLACK);//text colour set
        label2.setFont(new Font("Raleway",Font.BOLD,15));//SET OF Font size,name and style
        label2.setBounds(690,10,100,20);//helps the system to ensure where the text would be visible
        add(label2);//TEXT  added to frame successfully



        //Next button
        next=new JButton("NEXT");
        next.setFont(new Font("Arial",Font.BOLD,14));
        next.setForeground(Color.WHITE);
        next.setBackground(Color.BLACK);
        next.setBounds(630,500,100,30);
        next.addActionListener(this);
        add(next);

         setLayout(null);
         setSize(800,750);
         setLocation(350,30);
         getContentPane().setBackground(new Color(255, 204, 255));
        setUndecorated(true);
         setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         String rel=(String)combobox.getSelectedItem();//gives us the selected item from the combobox of religion
         String cate=(String)combobox1.getSelectedItem();
         String inco=(String)combobox2.getSelectedItem();
         String edqualify=(String)combobox3.getSelectedItem();
         String occ=(String)combobox4.getSelectedItem();
         String panc=textPan.getText();
         String aadh=textAadhar.getText();
        String sen_citizen=null;
        if(r1.isSelected()){
            sen_citizen="Yes";
        }
        else if(r2.isSelected()){
            sen_citizen="No";
        }
        String exi_account=null;
        if(r3.isSelected()){
            exi_account="Yes";
        }
        else if(r4.isSelected()){
            exi_account="No";
        }
        try{
            if(textPan.getText().equals("") || textAadhar.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Fill all the fields");
            }
            else{
                Con con1= new Con();
                //in the string q , the query is stored which is the details of the applicant.
                String q="insert into signup2 values('"+formno+"','"+rel+"','"+cate+"','"+inco+"','"+edqualify+"','"+occ+"','"+panc+"','"+aadh+"','"+sen_citizen+"','"+exi_account+"')";
                //execute the query
                con1.statement.executeUpdate(q);// go to the next signup page
                new SignUp3(formno);//object of signup2 page which will open the class SignUp2 page
                setVisible(false);//the current signUp page will be closed
            }

        }catch(Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[]args){
        new SignUp2("");//object of the constructor created and empty space is passed
    }
}
