package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;


public class Login extends JFrame implements ActionListener {

    JButton login , Signup,clear;
    JTextField cardTextField;
    JPasswordField pinTextField;



    Login(){

        setLayout(null);
        // 1. starting of the fumction frame ki size set ki aur location
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);

        //2. yaha se image ko liya fir usko resize kiya then usko wapas image m badla aur  print kiya
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ICONS/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);

        label.setBounds(70,10,100,100);

        add(label);
        setTitle("AUTOMATED TELLER MACHINE");
        // 3. yaha pr frame ka color change kiya white maine
        getContentPane().setBackground(Color.white);


        //4. text ko add krna hai frame pr
        JLabel text = new JLabel("    Welcome to ATM");
        text.setFont(new Font("Goward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);

        JLabel Cardno = new JLabel("Card No:");
        Cardno.setFont(new Font("Raleway",Font.BOLD,28));
        Cardno.setBounds(120,150,150,40);
        add(Cardno);

        // 5. box print krne kaine liye cardtextfield use kiya hai

        cardTextField = new JTextField();
        cardTextField.setBounds(300,150,250,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,28));
        add(cardTextField);


        JLabel pin = new JLabel("pin:");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120,220,250,30);
        add(pin);

        // 5. box print krne kaine liye cardtextfield use kiya hai

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300,220,250,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,28));
        add(pinTextField);



        // 6. ab button create krege usme signup ,login ,register

        login = new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        Signup = new JButton("SIGN UP");
        Signup.setBounds(300,350,230,30);
        Signup.setBackground(Color.black);
        Signup.setForeground(Color.white);
        Signup.addActionListener(this);
        add(Signup);






    }

    // 6. sabko globally declare krdo button ,text field walo kyuki usme action krna padega
    // 7. action listerner ek interface implement kiya uske baad  usme error aata hai usko
    // remove krne k liye  ek constructor class banayi then  usme 3ino button ki action define kiya .

    public void actionPerformed(ActionEvent ae)
    {
        if(ae .getSource()==clear){
            cardTextField.setText("");
            pinTextField.setText("");

        }
        else if(ae.getSource()==login)
        {
            Conn conn = new Conn();
            String Cardnumber =cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query ="select* from login where cardnumber ='"+Cardnumber+"'and pin = '"+pinnumber+"'";
            try{
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Incorrect cardNumber or pin");
                }

            }catch (Exception e)
            {
                System.out.println(e);
            }

        }
        else if(ae.getSource()==Signup)
        {
            setVisible(false);
            new SignupOne().setVisible(true);

        }



    }

    public static void main(String args[])
    {
        new Login();

    }
}
