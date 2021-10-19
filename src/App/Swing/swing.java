package App.Swing;

import App.Classes.contBancar;
import App.Classes.textClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class swing extends textClass {

    private JPanel panel1;
    private JLabel labelAddFunds, labelPosibil, labelCheckFunds, labelNrLinii, labelListareLinii, labelRetragereBani, labelDatorii, labelPlatesteDatorii, labelInfoClient, labelTemp, label2Temp;
    private JButton buttonAddFunds, buttonPosibil, buttonCheckFunds, buttonNrLinii, buttonListareLinii, buttonRetragereBani, buttonDatorii, buttonPlatesteDatorii, buttonInfoClient, buttonExit;

    public void meniuPrincipal(int codClient){
        JFrame f = new JFrame();
        panel1 = new JPanel(new GridLayout(11, 2));
        contBancar c = new contBancar();

        //Adaugare fonduri:
        labelAddFunds = new JLabel();
        buttonAddFunds = new JButton();

        labelAddFunds.setText("Adauga fonduri: ");
        buttonAddFunds.setText("Click");


        panel1.add(labelAddFunds);
        panel1.add(buttonAddFunds);

        //Action listener pentru add funds
        buttonAddFunds.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFunds fund = new addFunds();
                fund.add(c);
            }
        });
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.add(panel1, BorderLayout.CENTER);
        f.setTitle("Meniu");
        f.setSize(500,333);
        f.setVisible(true);

        //Verificare sold
        labelCheckFunds = new JLabel();
        buttonCheckFunds = new JButton();

        labelCheckFunds.setText("Verifica sold: ");
        buttonCheckFunds.setText("Click");


        panel1.add(labelCheckFunds);
        panel1.add(buttonCheckFunds);

        //Action listener pentru check funds
        buttonCheckFunds.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkFunds f = new checkFunds();
                f.checkSold(c);
            }
        });

        //numar linii de credit
        labelNrLinii = new JLabel();
        buttonNrLinii = new JButton();

        labelNrLinii.setText("Verifica numar linii de credit: ");
        buttonNrLinii.setText("Click");

        f.setLayout(new FlowLayout());
        panel1.add(labelNrLinii);
        panel1.add(buttonNrLinii);

        //Action listener linii de credit
        buttonNrLinii.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numarLiniiCredit n = new numarLiniiCredit();
                n.checkLinii(c);
            }
        });
        //listare linii de credit
        labelListareLinii = new JLabel();
        buttonListareLinii = new JButton();

        labelListareLinii.setText("Verifica linii de credit: ");
        buttonListareLinii.setText("Click");

        f.setLayout(new FlowLayout());
        panel1.add(labelListareLinii);
        panel1.add(buttonListareLinii);

        //Action listener linii de credit
        buttonListareLinii.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listareLinii l = new listareLinii();
                l.listare(c);
            }
        });
        //retragere bani
        labelRetragereBani = new JLabel();
        buttonRetragereBani = new JButton();

        labelRetragereBani.setText("Retrage bani: ");
        buttonRetragereBani.setText("Click");

        f.setLayout(new FlowLayout());
        panel1.add(labelRetragereBani);
        panel1.add(buttonRetragereBani);

        //Action listener linii de credit
        buttonRetragereBani.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                retragereBani r = new retragereBani();
                r.retrage(c);
            }
        });
        //datorii acumulate
        labelDatorii = new JLabel();
        buttonDatorii = new JButton();

        labelDatorii.setText("Datorii: ");
        buttonDatorii.setText("Click");

        f.setLayout(new FlowLayout());
        panel1.add(labelDatorii);
        panel1.add(buttonDatorii);

        //Action listener datorii
        buttonDatorii.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkDatorii ch = new checkDatorii();
                ch.datorii(c);
            }
        });

        //plateste datorii
        labelPlatesteDatorii = new JLabel();
        buttonPlatesteDatorii = new JButton();

        labelPlatesteDatorii.setText("Plateste datorii: ");
        buttonPlatesteDatorii.setText("Click");

        f.setLayout(new FlowLayout());
        panel1.add(labelPlatesteDatorii);
        panel1.add(buttonPlatesteDatorii);

        //Action listener datorii
        buttonPlatesteDatorii.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                platesteDatorii p = new platesteDatorii();
                p.plateste(c);
            }
        });


        //posibil datorii
        labelPosibil = new JLabel();
        buttonPosibil = new JButton();

        labelPosibil.setText("Plateste integral datorii(y/n): ");
        buttonPosibil.setText("Click");

        f.setLayout(new FlowLayout());
        panel1.add(labelPosibil);
        panel1.add(buttonPosibil);

        //Action listener datorii
        buttonPosibil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(c.platesteDatorii()){
                    String y = plataIntegralaY(c);
                    JOptionPane.showMessageDialog(panel1, y, "Posibil", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    String n = plataIntegralaN(c);
                    JOptionPane.showMessageDialog(panel1, n, "Imposibil", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //info client
        labelInfoClient = new JLabel();
        buttonInfoClient = new JButton();

        labelInfoClient.setText("Informatii client: ");
        buttonInfoClient.setText("Click");

        f.setLayout(new FlowLayout());
        panel1.add(labelInfoClient);
        panel1.add(buttonInfoClient);

        //Action listener info client
        buttonInfoClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                infoClient i = new infoClient();
                i.getInfo(c);
            }
        });

        //buton exit
        labelTemp = new JLabel();
        labelTemp.setText("");
        panel1.add(labelTemp);
        label2Temp = new JLabel();
        label2Temp.setText("");
        panel1.add(labelTemp);
        panel1.add(label2Temp);
        buttonExit = new JButton();
        buttonExit.setText("Exit");
        panel1.add(buttonExit);

        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
