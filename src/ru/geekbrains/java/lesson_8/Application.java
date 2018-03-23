package ru.geekbrains.java.lesson_8;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Application extends JFrame {
    public Application() {
        setTitle("SWING_1");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 200, 500, 400);
        setLayout(new GridLayout(1,2));
        JPanel leftPanel = new JPanel();
        add(leftPanel);
        JPanel rightPanel = new JPanel();
        add(rightPanel);
        leftPanel.setBackground(Color.LIGHT_GRAY);
        leftPanel.setBorder(new LineBorder(Color.blue));
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setPreferredSize(new Dimension(50, 50));
        JButton b1 = new JButton("Button_1");
        JButton b2 = new JButton("Button_2");
        JButton b3 = new JButton("Button_3");
        JButton b4 = new JButton("Button_4");
        leftPanel.add(b1);
        leftPanel.add(b2);
        leftPanel.add(b3);
        leftPanel.add(b4);

        rightPanel.setLayout(new CardLayout());
        JPanel rightPanelRed = new JPanel();
        rightPanelRed.setBackground(Color.red);
        rightPanel.add(rightPanelRed ,"RED");
        JPanel rightPanelBlue = new JPanel();
        rightPanelBlue.setBackground(Color.blue);
        rightPanel.add(rightPanelBlue ,"BLUE");
        ((CardLayout)rightPanel.getLayout()).show(rightPanel, "BLUE");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ((CardLayout)rightPanel.getLayout()).show(rightPanel, "BLUE");
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ((CardLayout)rightPanel.getLayout()).show(rightPanel, "RED");
            }
        });

        setVisible(true);
    }


}
