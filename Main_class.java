package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_class extends JFrame implements ActionListener {
    JButton deposit,fast_cash,pin_change,loans,budget_plan,withdraw,mini_state,balance,exit;
    String cardpin;

    Main_class(String cardpin){

        this.cardpin=cardpin;

        JLabel l0=new JLabel("FINOTEX BANK");
        l0.setForeground(Color.WHITE);
        l0.setFont(new Font("System",Font.BOLD,25));
        l0.setBounds(250,40,400,20);
        add(l0);

        JLabel l1=new JLabel("Please Select Your Transaction");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System",Font.BOLD,20));
        l1.setBounds(200,90,400,20);
        add(l1);

        deposit=new JButton("DEPOSIT");
        deposit.setFont(new Font("Arial",Font.BOLD,15));
        deposit.setForeground(Color.WHITE);
        deposit.setBackground(new Color(42, 128, 148));
        deposit.setBounds(100, 150, 200, 45);
        deposit.addActionListener(this);
        add(deposit);

        fast_cash=new JButton("FAST CASH");
        fast_cash.setFont(new Font("Arial",Font.BOLD,15));
        fast_cash.setForeground(Color.WHITE);
        fast_cash.setBackground(new Color(42, 128, 148));
        fast_cash.setBounds(100, 220, 200, 45);
        fast_cash.addActionListener(this);
        add(fast_cash);

        pin_change=new JButton("PIN CHANGE");
        pin_change.setFont(new Font("Arial",Font.BOLD,15));
        pin_change.setForeground(Color.WHITE);
        pin_change.setBackground(new Color(42, 128, 148));
        pin_change.setBounds(100,290,200,45);
        pin_change.addActionListener(this);
        add(pin_change);

        loans=new JButton("LOANS");
        loans.setFont(new Font("Arial",Font.BOLD,15));
        loans.setForeground(Color.WHITE);
        loans.setBackground(new Color(42, 128, 148));
        loans.setBounds(100,360,200,45);
        loans.addActionListener(this);
        add(loans);

        budget_plan=new JButton("BUDGET PLANNER");
        budget_plan.setFont(new Font("Arial",Font.BOLD,15));
        budget_plan.setForeground(Color.WHITE);
        budget_plan.setBackground(new Color(42, 128, 148));
        budget_plan.setBounds(390,360,200,45);
        budget_plan.addActionListener(this);
        add(budget_plan);

        withdraw=new JButton("CASH WITHDRAWAL");
        withdraw.setFont(new Font("Arial",Font.BOLD,15));
        withdraw.setForeground(Color.WHITE);
        withdraw.setBackground(new Color(42, 128, 148));
        withdraw.setBounds(390, 150, 200, 45);
        withdraw.addActionListener(this);
        add(withdraw);

        mini_state=new JButton("MINI-STATEMENT");
        mini_state.setFont(new Font("Arial",Font.BOLD,15));
        mini_state.setForeground(Color.WHITE);
        mini_state.setBackground(new Color(42, 128, 148));
        mini_state.setBounds(390,220,200,45);
        mini_state.addActionListener(this);
        add(mini_state);

        balance=new JButton("BALANCE ENQUIRY");
        balance.setFont(new Font("Arial",Font.BOLD,15));
        balance.setForeground(Color.WHITE);
        balance.setBackground(new Color(42, 128, 148));
        balance.setBounds(390,290,200,45);
        balance.addActionListener(this);
        add(balance);

        exit=new JButton("EXIT");
        exit.setFont(new Font("Arial",Font.BOLD,17));
        exit.setForeground(Color.WHITE);
        exit.setBackground(new Color(42, 128, 148));
        exit.setBounds(250,450,200,45);
        exit.addActionListener(this);
        add(exit);


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
        if(e.getSource()==deposit){
            new Deposit(cardpin);
            setVisible(false);
        }
        else if(e.getSource()==exit){
            System.exit(0);
        }
        else if(e.getSource()==withdraw){
            new Withdraw(cardpin);
            setVisible(false);
        }
        else if(e.getSource()==balance){
            new Bal_enq(cardpin);
            setVisible(false);
        }
        else if(e.getSource()==fast_cash){
            new Fast_cash(cardpin);
            setVisible(false);
        }
        else if(e.getSource()==pin_change){
            new Pin_change(cardpin);
            setVisible(false);
        }
        else if(e.getSource()==mini_state){
            new mini(cardpin);
            setVisible(true);
        }
        else if(e.getSource()==loans){
            new loans(cardpin);
            setVisible(false);
        }
        else if(e.getSource()==budget_plan){
            new budget_Planner(cardpin);
            setVisible(false);
        }


    }

    public static void main(String[]args){
        new Main_class("");
    }

}
