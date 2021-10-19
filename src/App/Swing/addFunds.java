package App.Swing;

import App.Classes.contBancar;
import App.Classes.textClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class addFunds extends textClass {
    private JPanel panel1;
    private JLabel labelAddFunds;
    private JButton buttonAddFunds, cancel;
    private JTextField textAddFunds;

    public void add(contBancar c){
        JFrame f = new JFrame();
        panel1 = new JPanel(new GridLayout(2,2));
        labelAddFunds = new JLabel("Introduceti suma care sa fie depusa: ");
        textAddFunds = new JTextField();
        buttonAddFunds = new JButton("Adaugare");
        cancel = new JButton("Iesire");
        panel1.add(labelAddFunds);
        panel1.add(textAddFunds);
        panel1.add(buttonAddFunds);
        panel1.add(cancel);
        buttonAddFunds.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double sumaDepusa = 0;
                try{
                    sumaDepusa = Double.parseDouble(textAddFunds.getText());
                    c.addFunds(sumaDepusa);
                    String s = depuneBani(c);
                    JOptionPane.showMessageDialog(panel1, s);
                } catch(NumberFormatException nfe){
                    JOptionPane j = new JOptionPane("Eroare", JOptionPane.ERROR_MESSAGE);
                    JDialog dialog = j.createDialog("IMPOSIBIL");
                    dialog.setAlwaysOnTop(true);
                    dialog.setVisible(true);
                }
            }
        });
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        f.add(panel1, BorderLayout.CENTER);
        f.setTitle("Adauga sold");
        f.setSize(250   ,100);
        f.setVisible(true);
    }
}
