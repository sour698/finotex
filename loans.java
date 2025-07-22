package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class loans extends JFrame implements ActionListener {
    JComboBox<String> loanType;
    JTextField amountField, durationField;
    JButton apply, back;
    String cardpin;

    loans(String cardpin) {
        this.cardpin = cardpin;

        setLayout(null);

        JLabel text = new JLabel("LOAN APPLICATION");
        text.setFont(new Font("Raleway", Font.BOLD, 28));
        text.setBounds(200, 30, 400, 30);
        add(text);

        JLabel typeLabel = new JLabel("Loan Type:");
        typeLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        typeLabel.setBounds(100, 100, 250, 30);
        add(typeLabel);

        String[] types = {"Select","Personal Loan", "Home Loan", "Car Loan", "Education Loan"};
        loanType = new JComboBox<>(types);
        loanType.setBounds(300, 100, 200, 30);
        loanType.setFont(new Font("Raleway", Font.PLAIN, 14));
        add(loanType);

        JLabel amountLabel = new JLabel("Amount (₹):");
        amountLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        amountLabel.setBounds(100, 150, 250, 30);
        add(amountLabel);

        amountField = new JTextField();
        amountField.setFont(new Font("Raleway", Font.BOLD, 14));
        amountField.setBounds(300, 150, 200, 30);
        add(amountField);

        JLabel durationLabel = new JLabel("Duration (months):");
        durationLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        durationLabel.setBounds(100, 200, 250, 30);
        add(durationLabel);

        durationField = new JTextField();
        durationField.setFont(new Font("Raleway", Font.BOLD, 14));
        durationField.setBounds(300, 200, 200, 30);
        add(durationField);

        apply = new JButton("APPLY");
        apply.setBackground(Color.BLACK);
        apply.setForeground(Color.WHITE);
        apply.setFont(new Font("Raleway", Font.BOLD, 14));
        apply.setBounds(350, 270, 100, 30);
        apply.addActionListener(this);
        add(apply);

        back = new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Raleway", Font.BOLD, 14));
        back.setBounds(150, 270, 100, 30);
        back.addActionListener(this);
        add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/Loans.jpg"));// loading the image in frame
        Image i2=i1.getImage().getScaledInstance(700,400, Image.SCALE_DEFAULT);//scalability of backgd image is same as frame size
        ImageIcon i3=new ImageIcon(i2);//make the image visible in frame
        JLabel image=new JLabel(i3);//jLabel helps the image to be visible in frame
        image.setBounds(0,0,700,400);//helps the system to ensure where the image would be visible( for backgd  always x=0 and y=0)
        add(image);//image added to frame successfully

        setSize(700, 400);
        setLocation(300, 150);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == apply) {
            String type = (String) loanType.getSelectedItem();
            String amount = amountField.getText();
            String duration = durationField.getText();

            if (amount.equals("") || duration.equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill all fields");
                return;
            }

            try {
                double loanAmount = Double.parseDouble(amount);
                int loanDuration = Integer.parseInt(duration);

                // Calculate EMI
                double rate = 0.10; // 10% interest rate
                double emi = (loanAmount * rate * Math.pow(1 + rate, loanDuration)) /
                        (Math.pow(1 + rate, loanDuration) - 1);

                Con conn = new Con();
                String query = "insert into loanss values('"+cardpin+"', '"+type+"', "+loanAmount+", "+loanDuration+", "+emi+", 'Pending', NOW())";
                conn.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Loan application submitted successfully!\n" +
                        "Estimated EMI: ₹" + String.format("%.2f", emi) + " per month");
                setVisible(false);
                new Main_class(cardpin).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }

        } else if (ae.getSource() == back) {
            setVisible(false);
            new Main_class(cardpin).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new loans("");
    }
}