package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployee extends JFrame implements ActionListener {

    JTextField tfname, tfage, tfphone, tfsalary, tfemail, tfaadhar;
    JRadioButton male, female;
    JButton submit;
    JComboBox cbjob;

    AddEmployee(){

        setLayout(null);

        JLabel name = new JLabel("NAME");
        name.setBounds(60, 30, 120, 30);
        name.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(name);

        tfname = new JTextField();
        tfname.setBounds(200, 30, 150, 30);
        add(tfname);

        JLabel age = new JLabel("AGE");
        age.setBounds(60, 80, 120, 30);
        age.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(age);

        tfage = new JTextField();
        tfage.setBounds(200, 80, 150, 30);
        add(tfage);

        JLabel gender = new JLabel("GENDER");
        gender.setBounds(60, 130, 120, 30);
        gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(200, 130, 70, 30);
        male.setFont(new Font("Tahoma", Font.PLAIN, 14));
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(280, 130, 70, 30);
        female.setFont(new Font("Tahoma", Font.PLAIN, 14));
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(male);
        buttonGroup.add(female);

        JLabel job = new JLabel("JOB");
        job.setBounds(60, 180, 120, 30);
        job.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(job);

        String str[] = {"Select Role", "Front Desk Clerk", "Porters", "Housekeeping", "Kitchen Staff", "Room Service", "Chefs", "Waiter/Waitress", "Manager", "Accountant"};
        cbjob = new JComboBox(str);
        cbjob.setBounds(200, 180, 150, 30);
        cbjob.setBackground(Color.WHITE);
        add(cbjob);

        JLabel salary = new JLabel("SALARY");
        salary.setBounds(60, 230, 120, 30);
        salary.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(salary);

        tfsalary = new JTextField();
        tfsalary.setBounds(200, 230, 150, 30);
        add(tfsalary);

        JLabel phone = new JLabel("PHONE");
        phone.setBounds(60, 280, 120, 30);
        phone.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(phone);

        tfphone = new JTextField();
        tfphone.setBounds(200, 280, 150, 30);
        add(tfphone);

        JLabel email = new JLabel("E-MAIL");
        email.setBounds(60, 330, 120, 30);
        email.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(email);

        tfemail = new JTextField();
        tfemail.setBounds(200, 330, 150, 30);
        add(tfemail);

        JLabel aadhar = new JLabel("AADHAR");
        aadhar.setBounds(60, 380, 120, 30);
        aadhar.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(aadhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(200, 380, 150, 30);
        add(tfaadhar);

        submit = new JButton("SUBMIT");
        submit.setBounds(200, 430, 150, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(350, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 60, 450, 370);
        add(image);

        getContentPane().setBackground(Color.WHITE);
        setBounds(350,200,850,550);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        String name = tfname.getText();
        String age = tfage.getText();
        String salary = tfsalary.getText();
        String phone = tfphone.getText();
        String email = tfemail.getText();
        String aadhar = tfaadhar.getText();

        if(name.equals("")){
            JOptionPane.showMessageDialog(null, "Please enter your name");
            return;
        }

        if(age.equals("")){
            JOptionPane.showMessageDialog(null, "Please enter your age");
            return;
        }

        if(salary.equals("")){
            JOptionPane.showMessageDialog(null, "Please enter your salary");
            return;
        }

        if(phone.equals("")){
            JOptionPane.showMessageDialog(null, "Please enter your phone number");
            return;
        }

        if(!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            JOptionPane.showMessageDialog(null, "Invalid email format");
            return;
        }

        if(aadhar.equals("")){
            JOptionPane.showMessageDialog(null, "Please enter your aadhar");
            return;
        }


        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }
        else if(female.isSelected()){
            gender = "Female";
        }

        String job = cbjob.getSelectedItem().toString();

        try{
            Conn conn = new Conn();

            String query = "insert into employee values('"+name+"', '"+age+"','"+gender+"','"+job+"', '"+salary+"','"+phone+"','"+email+"','"+aadhar+"')";

            conn.stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Employee has been added successfully");

            setVisible(false);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static  void main(String args[]){
        new AddEmployee();
    }
}
