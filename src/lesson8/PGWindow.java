package lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PGWindow extends JFrame {


    private static final int WIN_HEIGHT = 555;
    private static final int WIN_WIDTH = 505;
    private static final int WIN_POS_X = 500;
    private static final int WIN_POS_Y = 300;

    private static Setting setting;
    private static Map field;




    public PGWindow()  {
        setBounds(WIN_POS_X, WIN_POS_Y, WIN_WIDTH, WIN_HEIGHT);
        setTitle("PGWindow");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JPanel sPanel = new JPanel(new GridLayout(1,2));
        add(sPanel, BorderLayout.SOUTH);
        sPanel.setPreferredSize(new Dimension(40,40));

        setting = new Setting(this);

        JButton startNewGame = new JButton("Start");
        sPanel.add(startNewGame);
        startNewGame.setPreferredSize(new Dimension(40, 40));
        startNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setting.setVisible(true);
                System.out.println("pushed btn1");
            }
        });

        JButton exitGame = new JButton("Exit");
        sPanel.add(exitGame);
        exitGame.setPreferredSize(new Dimension(100, 100));
        exitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        field = new Map();
        add(field, BorderLayout.CENTER);



        setVisible(true);
    }

    public void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
        field.startNewGame(mode, fieldSizeX, fieldSizeY, winLength);

    }

}
