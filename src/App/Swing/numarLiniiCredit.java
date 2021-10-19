package App.Swing;

import App.Classes.contBancar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class numarLiniiCredit {
    private JPanel panel;
    private JLabel label;
    private JButton button;
    void checkLinii(contBancar c){
        JFrame f = new JFrame();
        panel = new JPanel();
        label = new JLabel("Numar linii de credit: " + (c.getNumarLiniiDeCredit()+1));
        panel.add(label);
        button = new JButton("Close");
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    f.dispose();
                }
        });
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        f.add(panel, BorderLayout.CENTER);
        f.setTitle("Verificare nr. linii credit.");
        f.setSize(250   ,100);
        f.setVisible(true);
    }
}

