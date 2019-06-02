package lesson8;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Setting extends JFrame {


    private final PGWindow pGWindow;

    private static final int WIN_HEIGHT = 230;
    private static final int WIN_WIDTH = 350;
    private static final int MIN_WIN_LEN = 3;
    private static final int MAX_WIN_LEN = 10;
    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;
    private static final String STR_WIN_LEN = "Winning length: ";
    private static final String STR_FIELD_SIZE ="Field size: ";
    private static final String STR_CHOOSE_GM="Choose game mode: ";
    private static final String STR_CHOOSE_FS="Choose field size: ";
    private static final String STR_CHOOSE_WL="Choose win length: ";

    private JRadioButton jrbHumVsAi = new JRadioButton("Human vs Ai", true);
    private JRadioButton jrbHumVsHum = new JRadioButton("Human vs Human");
    private ButtonGroup gameMode = new ButtonGroup();

    private JSlider slFieldSize;
    private JSlider slWinLength;

    int currentFieldSize;


    public Setting(PGWindow pGWindow) {
        this.pGWindow = pGWindow;
        setSize(WIN_WIDTH,WIN_HEIGHT);
        setTitle("Setting");

        Rectangle pGWindowBounds = pGWindow.getBounds();
        int posX = (int) (pGWindowBounds.getCenterX() - WIN_WIDTH / 2);
        int posY = (int) (pGWindowBounds.getCenterY() - WIN_HEIGHT /2);
        setLocation(posX, posY);

        setLayout(new GridLayout(10,1));

        addGameControlMode();
        addGameControlFieldWinLength();

        JButton btnStartGame = new JButton("Start a game");
        add(btnStartGame,BorderLayout.SOUTH);
        btnStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnStartGameClick();
            }
        });

        setVisible(false);
    }

    private void btnStartGameClick(){
        int gameMode;
        if(jrbHumVsAi.isSelected()){
            gameMode = Map.MODE_H_V_A;
        } else {
            gameMode = Map.MODE_H_V_H;
        }

        int fieldSize = slFieldSize.getValue();
        int winLength = slWinLength.getValue();

        pGWindow.startNewGame(gameMode, fieldSize, fieldSize, winLength);

        setVisible(false);




    }

    private void addGameControlMode() {
        add(new JLabel(STR_CHOOSE_GM));
        gameMode.add(jrbHumVsAi);
        gameMode.add(jrbHumVsHum);
        add(jrbHumVsAi);
        add(jrbHumVsHum);

    }

    private void addGameControlFieldWinLength() {
        add(new JLabel(STR_CHOOSE_FS));
        JLabel lblFieldSize = new JLabel(STR_FIELD_SIZE + MIN_FIELD_SIZE);
        add(lblFieldSize);

        slFieldSize = new JSlider(MIN_FIELD_SIZE,MAX_FIELD_SIZE,MIN_FIELD_SIZE);
        slFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentFieldSize = slFieldSize.getValue();
                lblFieldSize.setText(STR_FIELD_SIZE + currentFieldSize);
                slWinLength.setMaximum(currentFieldSize);
            }
        });

        add(slFieldSize);

        add(new JLabel(STR_CHOOSE_WL));
        JLabel lblWinLen = new JLabel(STR_WIN_LEN + MIN_WIN_LEN);
        add(lblWinLen);

        slWinLength = new JSlider(MIN_WIN_LEN,MAX_WIN_LEN,MIN_WIN_LEN);
        slWinLength.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lblWinLen.setText(STR_WIN_LEN + slWinLength.getValue());
            }
        });
        add(slWinLength);

    }
    public int getCurrentFieldSize() {
        return currentFieldSize;
    }
}
