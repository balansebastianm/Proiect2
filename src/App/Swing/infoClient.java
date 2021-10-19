package App.Swing;

import App.Classes.contBancar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class infoClient {
    private JPanel panel;
    private JLabel label, info;
    private JButton button;
    public void getInfo(contBancar c){
        JFrame f = new JFrame();
        panel = new JPanel();
        label = new JLabel("Informatii client: ");
        String s = c.toString();

        info = new JLabel(s);
        panel.add(label);
        panel.add(info);
        button = new JButton("Close");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });
        panel.add(button);
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        f.add(panel, BorderLayout.CENTER);
        f.setTitle("Info client");
        f.setSize(222   ,320);
        f.setVisible(true);
    }
}
