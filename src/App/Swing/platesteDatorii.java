package App.Swing;

import App.Classes.contBancar;
import App.Classes.textClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class platesteDatorii extends textClass {
    private JPanel panel;
    private JLabel label, labelSuma;
    private JButton button1, button2;
    private JTextField tf;

    public void plateste(contBancar c){

        JFrame f = new JFrame();
        labelSuma = new JLabel("Datoriile acumulate: " + c.getDatorii());
        panel = new JPanel(new GridLayout(3,2));

        label = new JLabel("Suma: ");
        tf = new JTextField();
        button1 = new JButton("Plateste");
        button2 = new JButton("Close");

        panel.add(labelSuma);
        panel.add(label);
        panel.add(tf);
        panel.add(button1);
        panel.add(button2);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double sumaDePlatit;
                try{
                    sumaDePlatit = Double.parseDouble(tf.getText());
                    System.out.println(sumaDePlatit);
                    if(c.platesteDatorii(sumaDePlatit)){
                        String s = datoriiTotal(c);
                        JOptionPane.showMessageDialog(panel, s);
                    }
                    else{
                        String s = fonduriInsuficiente(c);
                        JOptionPane.showMessageDialog(panel, s);;
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
        f.setTitle("Plateste datorii");
        f.setSize(420,100);
        f.setVisible(true);
    }
}
