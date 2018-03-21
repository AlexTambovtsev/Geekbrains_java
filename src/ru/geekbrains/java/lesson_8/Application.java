package ru.geekbrains.java.lesson_8;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Application extends JFrame {
    public Application() {
        setTitle("SWING_1");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 200, 500, 400);
        setLayout(new GridLayout(1, 2));
        JPanel leftPanel = new JPanel();
        add(leftPanel);
        JPanel rightPanel = new JPanel();
        add(rightPanel);
        leftPanel.setBackground(Color.LIGHT_GRAY);
        leftPanel.setBorder(new LineBorder(Color.BLACK));
        leftPanel.setMaximumSize(new Dimension(100, 100));
        leftPanel.setPreferredSize(new Dimension(100, 100));

        setVisible(true);
    }


}
