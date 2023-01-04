import java.awt.event.*;
import javax.swing.*;

public class LoginPanel extends JFrame {
    private JLabel username;
    private JLabel passeee;
    private JPasswordField passfield;
    private JTextField userfield;
    private JButton loginbtn;
    private String password;

    public LoginPanel() {
        // construct components
        username = new JLabel("Username");
        passeee = new JLabel("Password");
        passfield = new JPasswordField(5);
        userfield = new JTextField(5);
        loginbtn = new JButton("Login");

        // adjust size and set layout
        setSize(371, 341);
        setLayout(null);
        setTitle("Login Panel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
        // add components
        add(username);
        add(passeee);
        add(passfield);
        add(userfield);
        add(loginbtn);

        // set component bounds (only needed by Absolute Positioning)
        username.setBounds(95, 150, 100, 25);
        passeee.setBounds(95, 185, 100, 25);
        passfield.setBounds(195, 185, 100, 25);
        userfield.setBounds(195, 150, 100, 25);
        loginbtn.setBounds(140, 260, 100, 25);

        loginbtn.addActionListener(new SubmitButtonListener());
    }

    private class SubmitButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            char[] enteredPassword = passfield.getPassword();
            password = new String(enteredPassword);
            String enteredUsername = userfield.getText();

            if (password.equals("admin") && enteredUsername.equals("admin")) {
                JFrame frame = new JFrame("Car Rental Service");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(new AfterLogin());
                frame.pack();
                frame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect password. Please try again.");
            }

        }
    }

    public static void main(String[] args) {
        new LoginPanel();
    }
}
