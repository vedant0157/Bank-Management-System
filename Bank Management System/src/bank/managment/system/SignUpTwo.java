package bank.managment.system;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class SignUpTwo extends JFrame implements ActionListener{
    long random;
    JTextField pan,aadharNo;
    JButton next;
    JRadioButton syes,sno,eyes,eno;

    JComboBox religon,category,incomecategory,education,occupation;
    String formmo;

    SignUpTwo(String formno)
    {
        this.formmo= formno;
        setLayout(null);

        setTitle("NEW APPLICATION FORM - PAGE 2");

        Random ran =new Random();
        long random = Math.abs((ran.nextLong()%9000L)+1000L);





        JLabel additionaldetails = new JLabel("Page 2 : Additional Details");
        additionaldetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionaldetails.setBounds(290,80,400,30);
        add(additionaldetails);

        JLabel Religon = new JLabel("RELIGON:");
        Religon.setFont(new Font("Raleway",Font.BOLD,20));
        Religon.setBounds(100,140,100,30);
        add(Religon);

        String valReligon[]={"Hindu", "Muslim","Sikh","Christian"};
        religon = new JComboBox(valReligon);
        religon.setBounds(300,140,400,30);
        religon.setBackground(Color.white);
        religon.setForeground(Color.black);
        add(religon);




        JLabel Category = new JLabel("CATEGORY:");
        Category.setFont(new Font("Raleway",Font.BOLD,20));
        Category.setBounds(100,190,200,30);
        add(Category);

        String valCategory[] ={"General","OBC","SC","ST","others"};
        category = new JComboBox(valCategory);
        category.setForeground(Color.black);
        category.setBackground(Color.white);
        category.setBounds(300,190,400,30);
        add(category);



        JLabel income = new JLabel("INCOME:");
        income.setFont(new Font("Raleway",Font.BOLD,20));
        income.setBounds(100,240,200,30);
        add(income);

        String incomeCategory[] ={"NULL","<1,50,000","<2,50,000","<5,00,000","<10,00,000"};
        incomecategory = new JComboBox(incomeCategory);
        incomecategory.setForeground(Color.black);
        incomecategory.setBackground(Color.white);
        incomecategory.setBounds(300,240,400,30);
        add(incomecategory);


        JLabel Education = new JLabel("EDUCATIONAL :");
        Education.setFont(new Font("Raleway",Font.BOLD,20));
        Education.setBounds(100,290,200,30);
        add(Education);

        JLabel qualification = new JLabel("QUALIFICATION:");
        qualification.setFont(new Font("Raleway",Font.BOLD,20));
        qualification.setBounds(100,315,200,30);
        add(qualification);

        String educationValues[] ={"Non-Graduation","Graduate","Post-Graduation","PHD","Others"};
        education = new JComboBox(educationValues);
        education.setForeground(Color.black);
        education.setBackground(Color.white);
        education.setBounds(300,315,400,30);
        add(education);



        JLabel marital = new JLabel("OCCUPATION:");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,390,200,30);
        add(marital);

        String OccupationValues[] = {"salaried","self-Employee","Business","Student","Unemployee","others"};
        occupation = new JComboBox(OccupationValues);
        occupation.setBackground(Color.white);
        occupation.setForeground(Color.black);
        occupation.setBounds(300,395,400,30);
        add(occupation);



        JLabel PanNumber = new JLabel("PAN NUMBER:");
        PanNumber.setFont(new Font("Raleway",Font.BOLD,20));
        PanNumber.setBounds(100,440,200,30);
        add(PanNumber);

        pan = new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,14));
        pan.setBounds(300,440,400,30);
        add(pan);

        JLabel Aadhar = new JLabel("AADHAAR NO:");
        Aadhar.setFont(new Font("Raleway",Font.BOLD,20));
        Aadhar.setBounds(100,490,200,30);
        add(Aadhar);

        aadharNo = new JTextField();
        aadharNo.setFont(new Font("Raleway",Font.BOLD,14));
        aadharNo.setBounds(300,490,400,30);
        add(aadharNo);

        JLabel state = new JLabel("SENIOR CITIZEN:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);

        syes = new JRadioButton("YES");
        syes.setBounds(330,540,100,30);
        syes.setBackground(Color.white);
        syes.setForeground(Color.black);
        add(syes);

        sno = new JRadioButton("NO");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.white);
        sno.setForeground(Color.black);
        add(sno);


        ButtonGroup seniorcitizen = new ButtonGroup();
        seniorcitizen.add(syes);
        seniorcitizen.add(sno);

        JLabel existingacc = new JLabel("EXISTING ACCOUNT:");
        existingacc.setFont(new Font("Raleway",Font.BOLD,20));
        existingacc.setBounds(100,590,400,30);
        add(existingacc);

        eyes = new JRadioButton("YES");
        eyes.setBounds(330,590,100,30);
        eyes.setBackground(Color.white);
        eyes.setForeground(Color.black);
        add(eyes);

        eno = new JRadioButton("NO");
        eno.setBounds(450,590,600,30);
        eno.setBackground(Color.white);
        eno.setForeground(Color.black);
        add(eno);


        ButtonGroup ExistingAccount = new ButtonGroup();
        ExistingAccount.add(eyes);
        ExistingAccount.add(eno);

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
        String sreligon = (String)religon.getSelectedItem();
        String scategory = (String)category.getSelectedItem();
        String sincome = (String)incomecategory.getSelectedItem();
        String seducation = (String)education.getSelectedItem();
        String soccupation = (String)occupation.getSelectedItem();
        String sseniorcitizen =null;
        if(syes.isSelected()){sseniorcitizen= "YES";}
        else if (sno .isSelected()){
            sseniorcitizen = "NO";
        }
        String sexistingaccount = null;
        if(eyes.isSelected()){sexistingaccount = "YES";}
        else if (eno.isSelected()){sexistingaccount = "NO";}

        String span = pan.getText();
        String saadhar =aadharNo.getText();





        try{
                Conn c =new Conn();
                String query ="insert into signuptwo values ('"+formno+"', '"+sreligon+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+sseniorcitizen+"','"+sexistingaccount+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignUpThree(formno).setVisible(true);

        }catch (Exception e){
            System.out.println(e);
        }
    }




    public static void main(String args[]) {

        new SignUpTwo("");

    }
}