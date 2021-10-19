package App.Swing;

import App.Classes.contBancar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class checkDatorii {
    private JPanel panel;
    private JLabel label;
    private JButton button;
    public void datorii(contBancar c){
        JFrame f = new JFrame();
        panel = new JPanel();
        label = new JLabel("Datorii acumulate: " + c.getDatorii());
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
        f.setTitle("Datorii");
        f.setSize(250   ,100);
        f.setVisible(true);
    }
}
