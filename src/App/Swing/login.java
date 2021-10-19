package App.Swing;
import App.Classes.contBancar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class login {
    private JPanel panel;
    private JLabel user_label, password_label, message;
    private JTextField userName_text;
    private JPasswordField password_text;
    private JButton submit, cancel;
    private JFrame frame;

    public void logare(){
        frame = new JFrame();
        //username
        user_label = new JLabel();
        user_label.setText("Username:");
        userName_text = new JTextField();

        //password
        password_label = new JLabel();
        password_label.setText("Password");
        password_text = new JPasswordField();

        //validare
        submit = new JButton("Submit");
        cancel = new JButton("Cancel");

        panel = new JPanel(new GridLayout(4,2));
        panel.add(user_label);
        panel.add(userName_text);

        panel.add(password_label);
        panel.add(password_text);

        message = new JLabel();
        panel.add(submit);
        panel.add(cancel);
        panel.add(message);


        //listeners
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = userName_text.getText();
                String password = String.valueOf(password_text.getPassword());
                if(userName.trim().equals("") && password.trim().equals("")){
                    contBancar c = new contBancar();
                    int a = c.getCodClient();
                    swing s = new swing();
                    s.meniuPrincipal(a);
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
                else
                    message.setText("Date invalide.");
            }
        });

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.add(panel, BorderLayout.CENTER);
        frame.setTitle("Log in");
        frame.setSize(300,100);
        frame.setVisible(true);
    }
}
