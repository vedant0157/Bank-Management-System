package bank.managment.system;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;


public class SignupOne extends JFrame implements ActionListener{
    long random;
    JTextField nameTextfield,fnameTextfield,emailTextfield,addressTextfield,cityTextfield,stateTextfield,pincodeTextfield;
    JButton next;
    JRadioButton male ,female,married,unmarried,other,others;
    JDateChooser dateChooser;

    SignupOne()
    {
        setLayout(null);

        Random ran =new Random();
        long random = Math.abs((ran.nextLong()%9000L)+1000L);



        JLabel formno = new JLabel("APPLICATION FORM NO:-" + random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);

        JLabel PersonalDetails = new JLabel("Page 1 : Personal Details");
        PersonalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        PersonalDetails.setBounds(290,80,400,30);
        add(PersonalDetails);

        JLabel name = new JLabel("NAME:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);

        nameTextfield = new JTextField();
        nameTextfield.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextfield.setBounds(300,140,400,30);
        add(nameTextfield);


        JLabel fname = new JLabel("FATHER'S NAME:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);

        fnameTextfield = new JTextField();
        fnameTextfield.setFont(new Font("Raleway",Font.BOLD,14));
        fnameTextfield.setBounds(300,190,400,30);
        add(fnameTextfield);

        JLabel DOB = new JLabel("DATE OF BIRTH:");
        DOB.setFont(new Font("Raleway",Font.BOLD,20));
        DOB.setBounds(100,240,200,30);
        add(DOB);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,240,200,30);
        add(dateChooser);

        JLabel gender = new JLabel("GENDER:");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.white);
        add(male);

        female = new JRadioButton("female");
        female.setBounds(450,290,100,30);
        female.setBackground(Color.white);
        add(female);

        other = new JRadioButton("other");
        other.setBounds(630,290,60,30);

        other.setBackground(Color.white);
        add(other);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        gendergroup.add(other);

        JLabel EMAIL = new JLabel("EMAIL ADDRESS:");
        EMAIL.setFont(new Font("Raleway",Font.BOLD,20));
        EMAIL.setBounds(100,340,200,30);
        add(EMAIL);

        emailTextfield = new JTextField();
        emailTextfield.setFont(new Font("Raleway",Font.BOLD,14));
        emailTextfield.setBounds(300,340,400,30);
        add(emailTextfield);

        JLabel marital = new JLabel("MARITAL STATUS:");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,390,200,30);
        add(marital);

        unmarried = new JRadioButton("UnMarried");
        unmarried.setBounds(300,390,100,30);
        unmarried.setBackground(Color.white);
        add(unmarried);

        married = new JRadioButton("married");
        married.setBounds(450,390,100,30);
        married.setBackground(Color.white);
        add(married);

        others = new JRadioButton("Others");
        others.setBounds(630,390,100,30);
        others.setBackground(Color.white);
        add(others);




        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(others);


        JLabel address = new JLabel("ADDRESS:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);

        addressTextfield = new JTextField();
        addressTextfield.setFont(new Font("Raleway",Font.BOLD,14));
        addressTextfield.setBounds(300,440,400,30);
        add(addressTextfield);

        JLabel city = new JLabel("CITY:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);

        cityTextfield = new JTextField();
        cityTextfield.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextfield.setBounds(300,490,400,30);
        add(cityTextfield);

        JLabel state = new JLabel("STATE:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);

        stateTextfield = new JTextField();
        stateTextfield.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextfield.setBounds(300,540,400,30);
        add(stateTextfield);

        JLabel pincode = new JLabel("PIN CODE:");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);

        pincodeTextfield = new JTextField();
        pincodeTextfield.setFont(new Font("Raleway",Font.BOLD,14));
        pincodeTextfield.setBounds(300,590,400,30);
        add(pincodeTextfield);

        next = new JButton("NEXT");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Arial",Font.BOLD,16));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);




        getContentPane().setBackground(Color.white);


        setSize(850,800);
        setLocation(350,10);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae)
    {
        String formno = " " + random;
        String name = nameTextfield.getText();
        String fname = fnameTextfield.getText();
        String dob =( (JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender =null;
        if(male.isSelected()){gender= "Male";}
        else if (female .isSelected()){
            gender = "Female";
        }
        else if (other.isSelected()){gender="other";}
        String email = emailTextfield.getText();
        String marital = null;
        if(married.isSelected()){marital = "Married";}
        else if (unmarried.isSelected()){marital = "Unmarried";}
        else if (others.isSelected()){marital="other";}

        String address = addressTextfield.getText();
        String city =cityTextfield.getText();
        String state = stateTextfield.getText();
        String pin = pincodeTextfield.getText();



        try{
                Conn c =new Conn();
                String query ="insert into signup values ('"+formno+"', '"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                c.s.executeUpdate(query);

            setVisible(false);
            new SignUpTwo(formno).setVisible(true);



        }catch (Exception e){
            System.out.println(e);
        }
    }




    public static void main(String args[]) {

        new SignupOne();

    }
}