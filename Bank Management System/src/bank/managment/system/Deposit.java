package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.spec.ECField;
import java.util.Date;


public class Deposit extends JFrame implements ActionListener {
    JTextField amount;
    JButton deposit,back;
    String pinnumber;

    Deposit(String pinnumber)
    {
        this.pinnumber=pinnumber;
        setLayout(null);

        setLayout(null);
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);


        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("ICONS/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Enter the amount to deposit");
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170,300,400,20);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(170,400,320,25);
        image.add(amount);


        deposit = new JButton("Deposit");
        deposit.setBounds(355,485,100,30);
        deposit.addActionListener(this);
        image.add(deposit);


        back = new JButton("BACK");
        back.setBounds(250,485,100,30);
        back.addActionListener(this);
        image.add(back);



    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==deposit)
        {
            String number = amount.getText();
            Date date = new Date();
            if(number.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please enter the amount to deposit");
            }
            else{
                try {
                    Conn conn = new Conn();
                    String query = "insert into bank values('" + pinnumber + "','" + date + "', 'Deposit', '" + number + "')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "RS " + number + "Deposited Successfully");
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                }catch (Exception e)
                {
                    System.out.println(e);
                }
            }

        }
        else if (ae.getSource()==back) {
            {
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);

            }

        }
    }

    public static void main(String arg[])
    {
        new Deposit("");

    }
}
