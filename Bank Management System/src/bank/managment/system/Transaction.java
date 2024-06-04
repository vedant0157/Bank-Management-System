package bank.managment.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame implements ActionListener {

    JButton deposit,cashwdrwal,fastCash,minstat,pinchange,balanceenq,exit;
    String pinnumber;

    Transaction(String pinnumber)
    {
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ICONS/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Select your transaction");
        text.setBounds(215,300,700,35);
        text.setFont(new Font("System",Font.BOLD,20));
        text.setForeground(Color.white);
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        cashwdrwal = new JButton("Cash Withdrawal");
        cashwdrwal.setBounds(350,415,150,30);
        cashwdrwal.addActionListener(this);
        image.add(cashwdrwal);


        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(170,450,150,30);
        fastCash.addActionListener(this);
        image.add(fastCash);

        minstat = new JButton("Mini Statement");
        minstat.setBounds(350,450,150,30);
        minstat.addActionListener(this);
        image.add(minstat);

        pinchange  = new JButton("Pin-Change");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceenq  = new JButton("Balance Enquiry");
        balanceenq.setBounds(350,485,150,30);
        balanceenq.addActionListener(this);
        image.add(balanceenq);

        exit  = new JButton("Exit");
        exit.setBounds(350,520,150,30);
        exit.addActionListener(this);
        image.add(exit);


        setSize(900,900);
        setLocation(350,10);
        setUndecorated(true);
        setVisible(true);


    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==exit){
            System.exit(0);
        } else if (ae.getSource()==deposit) {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } else if (ae.getSource()==cashwdrwal) {
            setVisible(false);
            new Withdrwal(pinnumber).setVisible(true);
        } else if (ae.getSource()==fastCash) {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);

        } else if (ae.getSource()==pinchange) {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);

        }else if(ae.getSource()==balanceenq){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }else if(ae.getSource()==minstat)
        {
            setVisible(false);
            new MiniStatment(pinnumber).setVisible(true);
        }


    }


    public static  void main(String arg[]){
        new Transaction("");

    }
}
