package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField userName;
    JPasswordField password;
    JButton login, cancel;

    Login() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel user = new JLabel("Username");
        user.setBounds(40, 20, 100, 30);
        add(user);

        userName = new JTextField();
        userName.setBounds(150, 20, 150, 30);
        add(userName);


        JLabel pass = new JLabel("Password");
        pass.setBounds(40, 70, 100, 30);
        add(pass);

        password = new JPasswordField();
        password.setBounds(150, 70, 150, 30);
        add(password);

        login = new JButton("Login");
        login.setBounds(40, 150, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(180, 150, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new  JLabel(i3);
        image.setBounds(350,10,200,200);
        add(image);

        setBounds(500,200,600,300);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login){
            String user = userName.getText();
            String pass = new String(password.getPassword());

            try{
                Conn c = new Conn();
                String query = "SELECT * FROM login WHERE username = ? AND password = ?";
                PreparedStatement pst = c.prepareStatement(query);

                pst.setString(1, user);
                pst.setString(2, pass);

                ResultSet rs = pst.executeQuery();

                if(rs.next()){
                    setVisible(false);
                    new Dashboard();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                    setVisible(false);
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == cancel){
            setVisible(false);
        }
    }

    public static void main(String[] args){

        new Login();
    }
}
