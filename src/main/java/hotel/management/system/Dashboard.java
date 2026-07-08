package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {

    Dashboard(){
        setBounds(0,0,1550,1000);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500,1000,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new  JLabel(i3);
        image.setBounds(0,0,1550,1000);
        add(image);

        JLabel text = new JLabel("THE TAJ GROUP WELCOMES YOU");
        text.setBounds(400,80,1000,50);
        text.setFont(new Font("Tahoma",Font.BOLD,45));
        text.setForeground(Color.white);
        image.add(text);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0,0,1550,30);
        image.add(menuBar);

        JMenu hotel = new  JMenu("Hotel Management");
        hotel.setForeground(Color.RED);
        menuBar.add(hotel);

        JMenuItem reception = new JMenuItem("RECEPTION");
        hotel.add(reception);
        reception.addActionListener(this);


        JMenu admin = new  JMenu("ADMIN");
        admin.setForeground(Color.BLUE);
        menuBar.add(admin);

        JMenuItem addEmployee = new JMenuItem("ADD EMPLOYEE");
        addEmployee.addActionListener(this);
        admin.add(addEmployee);

        JMenuItem addRooms = new JMenuItem("ADD ROOMS");
        addRooms.addActionListener(this);
        admin.add(addRooms);

        JMenuItem addDrivers = new JMenuItem("ADD DRIVERS");
        addDrivers.addActionListener(this);
        admin.add(addDrivers);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("RECEPTION")){
            new Reception().setVisible(true);
        }
        else if(ae.getActionCommand().equals("ADD EMPLOYEE")){
            new AddEmployee();
        }
        else if(ae.getActionCommand().equals("ADD ROOMS")){
            new AddRooms();
        }
        else if(ae.getActionCommand().equals("ADD DRIVERS")){
            new AddDriver();
        }
    }

    public static void main(String[] args){

        new  Dashboard();
    }
}
