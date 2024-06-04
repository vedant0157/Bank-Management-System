package bank.managment.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton deposit,cashwdrwal,fastCash,minstat,pinchange,balanceenq,exit;
    String pinnumber;

    FastCash(String pinnumber)
    {
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ICONS/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Select withDrawal amount");
        text.setBounds(215,300,700,35);
        text.setFont(new Font("System",Font.BOLD,20));
        text.setForeground(Color.white);
        image.add(text);

        deposit = new JButton("100");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        cashwdrwal = new JButton("500");
        cashwdrwal.setBounds(350,415,150,30);
        cashwdrwal.addActionListener(this);
        image.add(cashwdrwal);


        fastCash = new JButton("1000");
        fastCash.setBounds(170,450,150,30);
        fastCash.addActionListener(this);
        image.add(fastCash);

        minstat = new JButton("2000");
        minstat.setBounds(350,450,150,30);
        minstat.addActionListener(this);
        image.add(minstat);

        pinchange  = new JButton("5000");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceenq  = new JButton("10,000");
        balanceenq.setBounds(350,485,150,30);
        balanceenq.addActionListener(this);
        image.add(balanceenq);

        exit  = new JButton("BACK");
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
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        } else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn conn = new Conn();
            try{
                ResultSet rs =conn.s.executeQuery("select * from bank where pin ='"+pinnumber+"'");
                int balance = 0 ;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance +=Integer.parseInt(rs.getString("amount"));
                    }else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                if(ae.getSource()!=exit && balance< Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficent Balance");
                    return;
                }

                Date date = new Date();
                String query = "Insert into bank values('"+pinnumber+"','"+date+"','Withdrwal','"+amount+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs" +amount+ " Debited Successfully");

                setVisible(false);
                new Transaction(pinnumber).setVisible(true);


            }catch (Exception e)
            {
                System.out.println(e);
            }

        }


    }


    public static  void main(String arg[]){
        new FastCash("");

    }
}

