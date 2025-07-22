package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class budget_Planner extends JFrame implements ActionListener {
    JTextField incomeField, housingField, foodField, transportField, entertainmentField, savingsField;
    JButton calculate, back;
    String cardpin;

    budget_Planner(String cardpin) {
        this.cardpin = cardpin;

        setLayout(null);

        JLabel text = new JLabel("BUDGET PLANNER");
        text.setForeground(new Color(240, 240, 240));
        text.setFont(new Font("Raleway", Font.BOLD, 28));
        text.setBounds(230, 20, 400, 30);
        add(text);

        JLabel incomeLabel = new JLabel("Monthly Income (₹):");
        incomeLabel.setForeground(new Color(255, 215, 0));
        incomeLabel.setFont(new Font("Raleway", Font.BOLD, 16));
        incomeLabel.setBounds(200, 70, 200, 30);
        add(incomeLabel);

        incomeField = new JTextField();
        incomeField.setFont(new Font("Raleway", Font.PLAIN, 14));
        incomeField.setBounds(400, 70, 150, 30);
        add(incomeField);

        JLabel housingLabel = new JLabel("Housing (%):");
        housingLabel.setForeground(new Color(255, 215, 0));
        housingLabel.setFont(new Font("Raleway", Font.BOLD, 16));
        housingLabel.setBounds(200, 120, 200, 30);
        add(housingLabel);

        housingField = new JTextField("30");
        housingField.setFont(new Font("Raleway", Font.PLAIN, 14));
        housingField.setBounds(400, 120, 150, 30);
        add(housingField);

        JLabel foodLabel = new JLabel("Food (%):");
        foodLabel.setForeground(new Color(255, 215, 0));
        foodLabel.setFont(new Font("Raleway", Font.BOLD, 16));
        foodLabel.setBounds(200, 170, 200, 30);
        add(foodLabel);

        foodField = new JTextField("15");
        foodField.setFont(new Font("Raleway", Font.PLAIN, 14));
        foodField.setBounds(400, 170, 150, 30);
        add(foodField);

        JLabel transportLabel = new JLabel("Transport (%):");
        transportLabel.setForeground(new Color(255, 215, 0));
        transportLabel.setFont(new Font("Raleway", Font.BOLD, 16));
        transportLabel.setBounds(200, 220, 200, 30);
        add(transportLabel);

        transportField = new JTextField("10");
        transportField.setFont(new Font("Raleway", Font.PLAIN, 14));
        transportField.setBounds(400, 220, 150, 30);
        add(transportField);

        JLabel entertainmentLabel = new JLabel("Entertainment (%):");
        entertainmentLabel.setForeground(new Color(255, 215, 0));
        entertainmentLabel.setFont(new Font("Raleway", Font.BOLD, 16));
        entertainmentLabel.setBounds(200, 270, 200, 30);
        add(entertainmentLabel);

        entertainmentField = new JTextField("10");
        entertainmentField.setFont(new Font("Raleway", Font.PLAIN, 14));
        entertainmentField.setBounds(400, 270, 150, 30);
        add(entertainmentField);

        JLabel savingsLabel = new JLabel("Savings (%):");
        savingsLabel.setForeground(new Color(255, 215, 0));
        savingsLabel.setFont(new Font("Raleway", Font.BOLD, 16));
        savingsLabel.setBounds(200, 320, 200, 30);
        add(savingsLabel);

        savingsField = new JTextField("20");
        savingsField.setFont(new Font("Raleway", Font.PLAIN, 14));
        savingsField.setBounds(400, 320, 150, 30);
        add(savingsField);

        calculate = new JButton("CALCULATE");
        calculate.setBackground(Color.BLACK);
        calculate.setForeground(Color.WHITE);
        calculate.setFont(new Font("Raleway", Font.BOLD, 14));
        calculate.setBounds(200, 380, 150, 30);
        calculate.addActionListener(this);
        add(calculate);

        back = new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Raleway", Font.BOLD, 14));
        back.setBounds(400, 380, 150, 30);
        back.addActionListener(this);
        add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/Budget Planner.jpg"));// loading the image in frame
        Image i2=i1.getImage().getScaledInstance(650,480, Image.SCALE_DEFAULT);//scalability of backgd image is same as frame size
        ImageIcon i3=new ImageIcon(i2);//make the image visible in frame
        JLabel image=new JLabel(i3);//jLabel helps the image to be visible in frame
        image.setBounds(0,0,650,480);//helps the system to ensure where the image would be visible( for backgd  always x=0 and y=0)
        add(image);//image added to frame successfully//

        setSize(650, 480);
        setLocation(300, 150);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == calculate) {
            try {
                double income = Double.parseDouble(incomeField.getText());
                double housingPercent = Double.parseDouble(housingField.getText());
                double foodPercent = Double.parseDouble(foodField.getText());
                double transportPercent = Double.parseDouble(transportField.getText());
                double entertainmentPercent = Double.parseDouble(entertainmentField.getText());
                double savingsPercent = Double.parseDouble(savingsField.getText());

                double totalPercent = housingPercent + foodPercent + transportPercent +
                        entertainmentPercent + savingsPercent;

                if (totalPercent > 100) {
                    JOptionPane.showMessageDialog(null, "Total percentage exceeds 100%");
                    return;
                }

                double housingAmount = income * housingPercent / 100;
                double foodAmount = income * foodPercent / 100;
                double transportAmount = income * transportPercent / 100;
                double entertainmentAmount = income * entertainmentPercent / 100;
                double savingsAmount = income * savingsPercent / 100;

                String result = "Recommended Budget:\n\n" +
                        "Housing: ₹" + String.format("%.2f", housingAmount) + "\n" +
                        "Food: ₹" + String.format("%.2f", foodAmount) + "\n" +
                        "Transport: ₹" + String.format("%.2f", transportAmount) + "\n" +
                        "Entertainment: ₹" + String.format("%.2f", entertainmentAmount) + "\n" +
                        "Savings: ₹" + String.format("%.2f", savingsAmount) + "\n\n" +
                        "Total: ₹" + String.format("%.2f", (housingAmount + foodAmount +
                        transportAmount + entertainmentAmount + savingsAmount)) +
                        " of ₹" + String.format("%.2f", income);

                JOptionPane.showMessageDialog(null, result);

                // Save budget plan to database
                Con conn = new Con();
                String query = "insert into budget values('"+cardpin+"', "+income+", "+housingPercent+", "+
                        foodPercent+", "+transportPercent+", "+entertainmentPercent+", "+
                        savingsPercent+", NOW())";
                conn.statement.executeUpdate(query);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Please enter valid numbers");
                System.out.println(e);
            }

        } else if (ae.getSource() == back) {
            setVisible(false);
            new Main_class(cardpin).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new budget_Planner("");
    }
}