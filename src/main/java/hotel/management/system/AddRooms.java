package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRooms extends JFrame implements ActionListener {

    JButton add, cancel;
    JTextField tfroom, tfprice;
    JComboBox<String> availableCB, bedCB, cleaningCB;

    AddRooms(){

        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel heading = new JLabel("Add Rooms");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        heading.setBounds(150, 20, 200, 20);
        add(heading);

        JLabel roomNo = new JLabel("Room Number");
        roomNo.setFont(new Font("Tahoma", Font.PLAIN, 16));
        roomNo.setBounds(60, 80, 120, 30);
        add(roomNo);

        tfroom = new JTextField();
        tfroom.setBounds(200, 80, 150, 30);
        add(tfroom);

        JLabel available = new JLabel("Available");
        available.setFont(new Font("Tahoma", Font.PLAIN, 16));
        available.setBounds(60, 130, 120, 30);
        add(available);

        String availableOpt[] = {"Available", "Occupied"};
        availableCB = new JComboBox<>(availableOpt);
        availableCB.setBounds(200, 130, 150, 30);
        availableCB.setBackground(Color.white);
        add(availableCB);

        JLabel clean = new JLabel("Cleaning Status");
        clean.setFont(new Font("Tahoma", Font.PLAIN, 16));
        clean.setBounds(60, 180, 120, 30);
        add(clean);

        String cleaningOpt[] = {"Cleaned", "Not Cleaned"};
        cleaningCB = new JComboBox<>(cleaningOpt);
        cleaningCB.setBounds(200, 180, 150, 30);
        cleaningCB.setBackground(Color.white);
        add(cleaningCB);

        JLabel price = new JLabel("Room Price");
        price.setFont(new Font("Tahoma", Font.PLAIN, 16));
        price.setBounds(60, 230, 120, 30);
        add(price);

        tfprice = new JTextField();
        tfprice.setBounds(200, 230, 150, 30);
        add(tfprice);

        JLabel bType = new JLabel("Bed Type");
        bType.setFont(new Font("Tahoma", Font.PLAIN, 16));
        bType.setBounds(60, 280, 120, 30);
        add(bType);

        String bedOpt[] = {"Single Bed", "Double Bed"};
        bedCB = new JComboBox<>(bedOpt);
        bedCB.setBounds(200, 280, 150, 30);
        bedCB.setBackground(Color.white);
        add(bedCB);

        add =  new JButton("Add Room");
        add.setBackground(Color.BLACK);
        add.setBounds(60, 350, 130, 30);
        add.setForeground(Color.white);
        add.addActionListener(this);
        add(add);

        cancel =  new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(220, 350, 130, 30);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/twelve.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400, 30, 500, 300);
        add(image);

        setBounds(320,200,940,470);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == add){
            String roomNum = tfroom.getText();
            String availability = availableCB.getSelectedItem().toString();
            String cleanStatus = cleaningCB.getSelectedItem().toString();
            String price = tfprice.getText();
            String bedType = bedCB.getSelectedItem().toString();

            try{
                Conn c = new Conn();
                String query = "insert into room (roomnumber, availability, cleaning_status, price, bed_type) values('"+ roomNum+"', '"+ availability+"','"+ cleanStatus+"','"+ price+"','"+ bedType+"')";
                c.stmt.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Room Added");
                setVisible(false);

            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args){
        new AddRooms();
    }
}
