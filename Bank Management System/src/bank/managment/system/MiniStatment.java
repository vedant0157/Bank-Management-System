package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatment extends JFrame {

    String pinnumber;

    MiniStatment(String pinnumber){
        this.pinnumber=pinnumber;


        setTitle("Mini - Statement");

        setLayout(null);

        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
        setVisible(true);


        JLabel text = new JLabel();
        add(text);

        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);

        JLabel mini = new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);

        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel balance =new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);

        try{

            Conn conn = new Conn();
            int bal =0;
            ResultSet rs =conn.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
            while (rs.next())
            {
                card.setText("Card Number: " +rs.getString("cardnumber").substring(0,4)+"XXXXXXXX" + rs.getString("cardnumber").substring(12) );
                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your Current balance is Rs " +bal);


        }catch (Exception e)
        {
            System.out.println(e);
        }

        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while (rs.next())
            {
                mini.setText(mini.getText() + "<HTML>" + rs.getString("date") +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount")+"<br><br></HTML>");

            }

        }catch (Exception e)
        {
            System.out.println(e);
        }







    }

    public static void main(String args[])
    {
        new MiniStatment("");
    }
}
