package App.Swing;

import App.Classes.contBancar;
import App.Classes.textClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class retragereBani extends textClass {
    private JPanel panel;
    private JLabel label;
    private JButton button1, button2;
    private JTextField tf;

    public void retrage(contBancar c){

        JFrame f = new JFrame();

        panel = new JPanel(new GridLayout(2,2));
        label = new JLabel("Introduce suma care sa fie retrasa: ");
        tf = new JTextField();
        button1 = new JButton("Retrage");
        button2 = new JButton("Close");

        panel.add(label);
        panel.add(tf);
        panel.add(button1);
        panel.add(button2);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double sumaDeRetras;
                try{
                    sumaDeRetras = Double.parseDouble(tf.getText());
                    System.out.println(sumaDeRetras);
                    if(c.retragereBani(sumaDeRetras)){
                        String s = retragere(c);
                        JOptionPane.showMessageDialog(panel, s);
                    }
                    else{
                        String s = fonduriInsuficiente(c);
                        JOptionPane.showMessageDialog(panel, "Fonduri insuficiente. Sold cont:  " + c.getSoldCont());
                    }
                } catch(NumberFormatException nfe){
                    JOptionPane j = new JOptionPane("Eroare", JOptionPane.ERROR_MESSAGE);
                    JDialog dialog = j.createDialog("IMPOSIBIL");
                    dialog.setAlwaysOnTop(true);
                    dialog.setVisible(true);
                }
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        f.add(panel, BorderLayout.CENTER);
        f.setTitle("Retrage bani");
        f.setSize(420,100);
        f.setVisible(true);
    }
}
