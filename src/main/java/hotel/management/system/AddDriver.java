package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDriver extends JFrame implements ActionListener {

    JButton add, cancel;
    JTextField tfname, tfage, tfcompany,tfmodel, tflocation;
    JComboBox<String> availableCB, bedCB, genderComboBox;

    AddDriver(){

        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel heading = new JLabel("Add Drivers");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        heading.setBounds(194, 10, 200, 22);
        add(heading);

        JLabel name = new JLabel("Name");
        name.setFont(new Font("Tahoma", Font.PLAIN, 16));
        name.setBounds(64, 70, 102, 22);
        add(name);

        tfname = new JTextField();
        tfname.setBounds(174, 70, 156, 20);
        add(tfname);

        JLabel age = new JLabel("Age");
        age.setFont(new Font("Tahoma", Font.PLAIN, 16));
        age.setBounds(64, 110, 102, 22);
        add(age);

        tfage = new JTextField();
        tfage.setBounds(174, 110, 156, 20);
        add(tfage);

        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        gender.setBounds(64, 150, 102, 22);
        add(gender);

        String genderOption[] = {"Female","Male"};
        genderComboBox = new JComboBox(genderOption);
        genderComboBox.setBounds(176, 150, 154, 20);
        genderComboBox.setBackground(Color.white);
        add(genderComboBox);

        JLabel carCompany = new JLabel("Car Company");
        carCompany.setFont(new Font("Tahoma", Font.PLAIN, 16));
        carCompany.setBounds(64, 190, 102, 22);
        add(carCompany);

        tfcompany = new JTextField();
        tfcompany.setBounds(174, 190, 156, 20);
        add(tfcompany);

        JLabel carModel = new JLabel("Car Model");
        carModel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        carModel.setBounds(64, 230, 102, 22);
        add(carModel);

        tfmodel = new JTextField();
        tfmodel.setBounds(174, 230, 156, 20);
        add(tfmodel);

        JLabel available = new JLabel("Available");
        available.setFont(new Font("Tahoma", Font.PLAIN, 16));
        available.setBounds(64, 270, 102, 22);
        add(available);

        String driverOpt[] = {"Available", "Busy"};
        availableCB = new JComboBox<>(driverOpt);
        availableCB.setBounds(176, 270, 154, 20);
        availableCB.setBackground(Color.white);
        add(availableCB);

        JLabel location = new JLabel("Location");
        location.setFont(new Font("Tahoma", Font.PLAIN, 16));
        location.setBounds(64, 310, 102, 22);
        add(location);

        tflocation = new JTextField();
        tflocation.setBounds(174, 310, 156, 20);
        add(tflocation);

        add =  new JButton("Add Driver");
        add.setBackground(Color.BLACK);
        add.setBounds(64, 380, 111, 33);
        add.setForeground(Color.white);
        add.addActionListener(this);
        add(add);

        cancel =  new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(200, 380, 111, 33);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 30, 500, 300);
        add(image);

        setBounds(300,200,980,470);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == add){
            String name = tfname.getText();
            String age = tfage.getText();
            String gender = genderComboBox.getSelectedItem().toString();
            String company = tfcompany.getText();
            String model = tfmodel.getText();
            String available = availableCB.getSelectedItem().toString();
            String location  = tflocation.getText();

            try{
                Conn c = new Conn();
                String query = "insert into driver values('"+ name+"', '"+ age+"','"+ gender+"','"+ company+"','"+ model+"','"+ available+"','"+ location+"')";

                c.stmt.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "New Driver Added");
                setVisible(false);

            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args){
        new AddDriver().setVisible(true);
    }
}
