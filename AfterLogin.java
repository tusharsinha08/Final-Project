import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.*;

public class AfterLogin extends JPanel {

    private static String carName;
    private static String levell;

    private static JRadioButton[] carNames = new JRadioButton[4];
    private static JRadioButton[] levelon = new JRadioButton[3];

    private JLabel jcomp1;
    private JTextField name;
    private JLabel jcomp3;
    private JTextField mobile;
    private JLabel jcomp5;
    private JRadioButton jcomp6;
    private JRadioButton jcomp7;
    private JRadioButton jcomp8;
    private JRadioButton jcomp9;
    private JLabel jcomp10;
    private JTextField lic;
    private JLabel jcomp12;
    private JTextField time;
    private JLabel jcomp14;
    private JRadioButton jcomp15;
    private JRadioButton jcomp16;
    private JRadioButton jcomp17;
    private JButton save;
    private JButton view;
    private JLabel jcomp20;
    private JTextField total;

    public AfterLogin() {

        jcomp1 = new JLabel("Name :");
        name = new JTextField(5);
        jcomp3 = new JLabel("Mobile No :");
        mobile = new JTextField(5);
        jcomp5 = new JLabel("Car :");
        jcomp6 = new JRadioButton("BMW");
        jcomp7 = new JRadioButton("TESLA");
        jcomp8 = new JRadioButton("TATA");
        jcomp9 = new JRadioButton("TOYOTA");
        jcomp10 = new JLabel("License No :");
        lic = new JTextField(5);
        jcomp12 = new JLabel("Time :");
        time = new JTextField(5);
        jcomp14 = new JLabel("Level :");
        jcomp15 = new JRadioButton("SILVER");
        jcomp16 = new JRadioButton("GOLD");
        jcomp17 = new JRadioButton("PLATINUM");
        save = new JButton("SAVE");
        view = new JButton("VIEW");
        jcomp20 = new JLabel("Total :");
        total = new JTextField(5);
        save.addActionListener(new SaveButtonListener());
        view.addActionListener(new ViewButtonListener());
        CreateSequentialFile.openFile();

        // adjust size and set layout
        setPreferredSize(new Dimension(752, 430));
        setLayout(null);

        // add components
        add(jcomp1);
        add(name);
        add(jcomp3);
        add(mobile);
        add(jcomp5);
        add(jcomp6);
        add(jcomp7);
        add(jcomp8);
        add(jcomp9);
        add(jcomp10);
        add(lic);
        add(jcomp12);
        add(time);
        add(jcomp14);
        add(jcomp15);
        add(jcomp16);
        add(jcomp17);
        add(save);
        add(view);
        add(jcomp20);
        add(total);

        carNames[0] = jcomp6;
        carNames[1] = jcomp7;
        carNames[2] = jcomp8;
        carNames[3] = jcomp9;

        carNames[0].addItemListener(new ItemHandler());
        carNames[1].addItemListener(new ItemHandler());
        carNames[2].addItemListener(new ItemHandler());
        carNames[3].addItemListener(new ItemHandler());

        // for level
        levelon[0] = jcomp15;
        levelon[1] = jcomp16;
        levelon[2] = jcomp17;

        levelon[0].addItemListener(new LevelHandaler());
        levelon[1].addItemListener(new LevelHandaler());
        levelon[2].addItemListener(new LevelHandaler());

        // Car Button
        ButtonGroup group = new ButtonGroup();
        group.add(carNames[0]);
        group.add(carNames[1]);
        group.add(carNames[2]);
        group.add(carNames[3]);

        // Level Button
        ButtonGroup levelButtonGroup = new ButtonGroup();
        levelButtonGroup.add(levelon[0]);
        levelButtonGroup.add(levelon[1]);
        levelButtonGroup.add(levelon[2]);

        jcomp1.setBounds(90, 40, 100, 25);
        name.setBounds(165, 40, 155, 25);
        jcomp3.setBounds(90, 80, 100, 25);
        mobile.setBounds(165, 80, 155, 25);
        jcomp5.setBounds(90, 125, 100, 25);
        jcomp6.setBounds(165, 125, 100, 25);
        jcomp7.setBounds(165, 150, 100, 25);
        jcomp8.setBounds(165, 175, 100, 25);
        jcomp9.setBounds(165, 200, 100, 25);
        jcomp10.setBounds(380, 40, 100, 25);
        lic.setBounds(480, 40, 155, 25);
        jcomp12.setBounds(380, 80, 100, 25);
        time.setBounds(480, 80, 155, 25);
        jcomp14.setBounds(380, 125, 100, 25);
        jcomp15.setBounds(480, 125, 100, 25);
        jcomp16.setBounds(480, 150, 100, 25);
        jcomp17.setBounds(480, 175, 100, 25);
        save.setBounds(215, 320, 100, 25);
        view.setBounds(375, 320, 100, 25);
        jcomp20.setBounds(240, 255, 100, 25);
        total.setBounds(320, 255, 155, 25);
    }

    private class SaveButtonListener implements ActionListener {

        // 1st hi
        public void actionPerformed(ActionEvent e) {

            String nameString = name.getText();
            String mobileString = mobile.getText();
            String licString = lic.getText();
            String timeString = time.getText();
            String totalString = total.getText();

            CreateSequentialFile.addRecords(nameString, mobileString, carName, licString, timeString, levell,
                    totalString);

        }

    }

    private class ViewButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<CarRentalInfo> list = ReadSequentialFile.readRecords();
            JTableExample table = new JTableExample(list);
            CreateSequentialFile.closeFile();
        }
    }

    private class ItemHandler implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent event) {

            for (int i = 0; i < carNames.length; i++) {
                if (carNames[i].isSelected()) {
                    if (i == 0)
                        carName = "BMW";
                    if (i == 1)
                        carName = "TESLA";
                    if (i == 2)
                        carName = "TATA";
                    if (i == 3)
                        carName = "TOYOTA";
                }

            }
        }
    }

    private class LevelHandaler implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent event) {

            for (int i = 0; i < levelon.length; i++) {
                if (levelon[i].isSelected()) {
                    if (i == 0)
                        levell = "SILVER";
                    if (i == 1)
                        levell = "GOLD";
                    if (i == 2)
                        levell = "PLATINUM";
                }

            }
        }
    } // end private inner class ItemHandler
}
