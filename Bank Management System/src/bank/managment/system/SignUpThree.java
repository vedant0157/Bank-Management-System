package bank.managment.system;

import com.mysql.cj.log.Log;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;



public class SignUpThree extends JFrame implements ActionListener {
    long random;
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit, Cancel;
    String formno,pinnumber;





    SignUpThree(String formno){
        this.formno=formno;

        setLayout(null);


        JLabel l1= new JLabel("Page:3 Account Details ");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(240,40,400,40);
        add(l1);

        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,120,200,40);
        add(type);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(Color.white);
        r1.setForeground(Color.black);
        r1.setBounds(100,180,150,20);
        add(r1);

        r2 = new JRadioButton("Current Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(Color.white);
        r2.setForeground(Color.black);
        r2.setBounds(350,180,150,20);
        add(r2);

        r3 = new JRadioButton("FD Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(Color.white);
        r3.setForeground(Color.black);
        r3.setBounds(100,220,150,20);
        add(r3);

        r4 = new JRadioButton("Recurring Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(Color.white);
        r4.setForeground(Color.black);
        r4.setBounds(350,220,200,20);
        add(r4);

        ButtonGroup groupaccount =new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);

        JLabel card = new JLabel(" Card Number :");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,300,200,30);
        card.setForeground(Color.black);
        add(card);

        JLabel numbers = new JLabel("XXXX-XXXX-XXXX-2002");
        numbers.setFont(new Font("Raleway",Font.BOLD,16));
        numbers.setBounds(330,300,400,30);
        numbers.setForeground(Color.black);
        add(numbers);

        JLabel democno = new JLabel("(Your's 16 Digit Card No)");
        democno.setFont(new Font("Raleway",Font.BOLD,14));
        democno.setBounds(330,330,400,30);
        democno.setForeground(Color.black);
        add(democno);

        JLabel pin = new JLabel(" Pin Number :");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,370,200,30);
        pin.setForeground(Color.black);
        add(pin);

        JLabel pinnumber = new JLabel("XXXX");
        pinnumber.setFont(new Font("Raleway",Font.BOLD,16));
        pinnumber.setBounds(330,370,400,30);
        pinnumber.setForeground(Color.black);
        add(pinnumber);

        JLabel demopin = new JLabel("(Your's 4 Digit Pin)");
        demopin.setFont(new Font("Raleway",Font.BOLD,14));
        demopin.setBounds(330,400,400,30);
        demopin.setForeground(Color.black);
        add(demopin);

        JLabel service = new JLabel("Services Required :");
        service.setFont(new Font("Raleway",Font.BOLD,20));
        service.setBounds(100,450,400,30);
        service.setForeground(Color.black);
        add(service);

        c1 = new JCheckBox("ATM Card");
        c1.setBackground(Color.white);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,500,200,30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,500,200,30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.white);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,550,200,30);
        add(c3);

        c4 = new JCheckBox("Email & SMS Alert");
        c4.setBackground(Color.white);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,550,200,30);
        add(c4);



        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.white);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,600,200,30);
        add(c5);

        c6 = new JCheckBox("E statement");
        c6.setBackground(Color.white);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,600,200,30);
        add(c6);

        c7 = new JCheckBox("I hereby declare the above enter details are correct in the best of my Knowledge ");
        c7.setBackground(Color.white);
        c7.setFont(new Font("Raleway",Font.BOLD,14));
        c7.setBounds(100,680,600,30);
        add(c7);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(420,720,100,30);
        submit.addActionListener(this);
        add(submit);

        Cancel = new JButton("Cancel");
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.white);
        Cancel.setFont(new Font("Raleway",Font.BOLD,14));
        Cancel.setBounds(530,720,100,30);
        Cancel.addActionListener(this);
        add(Cancel);

        getContentPane().setBackground(Color.white);
        setSize(800,820);
        setLocation(350,10);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        String formno = " " + random;
        if (ae.getSource() == submit) {
            String accounttype = null;
            if (r1.isSelected()) {
                accounttype = "Saving Account";
            } else if (r2.isSelected()) {
                accounttype = "Current Account";
            } else if (r3.isSelected()) {
                accounttype = "FD Account";
            } else if (r4.isSelected()) {
                accounttype = "Recurring Deposits Account";
            }

            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 90000000L)) + 98619580L;
            String pin = "" + Math.abs((random.nextLong() % 900L)) + 1L;
            String Facility = "";
            if (c1.isSelected()) {
                Facility = Facility + " ATM Card";
            } else if (c2.isSelected()) {
                Facility = Facility + "Internet Banking";
            } else if (c3.isSelected()) {
                Facility = Facility + "Mobile Banking";
            } else if (c4.isSelected()) {
                Facility = Facility + "Email $ SMS Alert";
            } else if (c5.isSelected()) {
                Facility = Facility + "Cheque Book";
            } else if (c6.isSelected()) {
                Facility = Facility + "E-Statement";
            }

            try {
                if (accounttype.equals("")) {
                    JOptionPane.showMessageDialog(null, "Account Type is required");

                } else {
                    Conn conn = new Conn();
                    String query1 = "insert into signupthree values('" + formno + "','" + accounttype +
                            "','" + cardnumber + "','" + pin + "','" + Facility + "')";
                    String query2 = "insert into login values('" + formno + "', '" + cardnumber + "','" + pin + "')";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null,"Card Number:"+cardnumber+"\n PIN: "+pin);

                    setVisible(false);
                    new Deposit(pinnumber).setVisible(false);
                }

            } catch (Exception e) {
                System.out.println(e);
            }

        }
             else if (ae.getSource() == Cancel) {
                 setVisible(false);
                 new Login().setVisible(true);

                }
            }


            public static void main(String args[]){
                new SignUpThree("");
            }

        }
