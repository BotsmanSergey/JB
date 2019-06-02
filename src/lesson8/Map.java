package lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Map extends JPanel {

    public static final int MODE_H_V_A = 0;
    public static final int MODE_H_V_H = 1;

    int[][] field;
    int fieldSizeX;
    int fieldSizeY;
    int winLength;

    int cellHeight;
    int cellWidth;



    boolean isInit = false;



    static  int SIZE;
    static  int DOTS_TO_WIN ;
    static final char[] simbols = {'X', 'O'};
    static char[][] pg;





    public Map(){
        setBackground(Color.ORANGE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                update(e);
            }
        });

    }

    public void update(MouseEvent e) {
        int cellX = e.getX()/cellWidth;
        int cellY = e.getY()/cellHeight;
        System.out.println(cellX + " " + cellY);



        stepPlayer(cellY, cellX);
        output();
        checkToWin(0);//не реализована остановка игры
        checkToDraw();
        stepPC();
        output();
        checkToWin(1);
        checkToDraw();

        repaint();
    }

    public void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
        System.out.println(mode+ " " +fieldSizeX+ " " +fieldSizeY+ " " + winLength);

        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        this.winLength = winLength;
        field = new int[fieldSizeY][fieldSizeX];

        SIZE = fieldSizeX;
        DOTS_TO_WIN = winLength;
        pg = new char[fieldSizeX][fieldSizeY];

        isInit = true;
        repaint();
vmap();
       // maind = new Logic();


    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(10));
        render (g);
    }

    private void render(Graphics g) {
        if(!isInit) {
            return;
        }
        int panelWidth = getWidth();
        int panelHeight = getHeight();

        cellHeight = panelHeight / fieldSizeY;
        cellWidth = panelWidth / fieldSizeX;

        for (int i = 0; i < fieldSizeY; i++) {
            int y = i*cellHeight;
            g.drawLine(0, y, panelWidth,y);
        }
        for (int i = 0; i < fieldSizeX; i++) {
            int x = i*cellWidth;
            g.drawLine(x, 0,x, panelHeight);
        }
        for (int y = 0; y <pg.length ; y++) {
            for (int x = 0; x <pg[y].length ; x++) {
                if (pg[y][x] == 'X') {
                    g.drawLine(x*cellWidth+20, y*cellHeight+20, x*cellWidth + cellWidth-20, y*cellHeight + cellHeight-20);
                    g.drawLine(x*cellWidth+cellWidth-20, y*cellHeight+20, x*cellWidth +20, y*cellHeight + cellHeight-20);
                } else if (pg[y][x] == 'O') {
                    g.drawOval(x*cellWidth+20, y*cellHeight+20,cellWidth-40,cellHeight-40);

                }
            }

        }

    }



    public  void vmap() {

        map();
        output();



    }



    public static char[][] map() {
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                pg[y][x] = '.';
            }
        }
        return pg;
    }

    public static void output() {

        System.out.print("  ");
        for (int i = 1; i < SIZE + 1; i++) {
            System.out.print(i + " ");
        }
        System.out.println("X");
        for (int y = 0; y < SIZE; y++) {
            System.out.print(y + 1 + " ");
            for (int x = 0; x < SIZE; x++) {
                System.out.print(pg[y][x] + " ");
            }
            System.out.println();
        }
        System.out.println("Y");
    }

    public static void stepPlayer(int y, int x) {
        System.out.println("Ваш Ход");
        do {

        } while (pg[y][x] != '.');
        pg[y][x] = simbols[0];

    }

    public static boolean checkToWin(int c) {
        int s;
        boolean win = false;
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE - DOTS_TO_WIN + 1; x++) {
                s = 0;
                for (int i = 0; i < DOTS_TO_WIN; i++) {
                    if (pg[y][x + i] == simbols[c]) {
                        s += 1;
                    }

                }
                if (s == DOTS_TO_WIN) {
                    System.out.println(simbols[c] + " the champion!!!");
                    win = true;
                    break;

                }
            }
        }
        for (int y = 0; y < SIZE - DOTS_TO_WIN + 1; y++) {
            for (int x = 0; x < SIZE; x++) {
                s = 0;
                for (int i = 0; i < DOTS_TO_WIN; i++) {
                    if (pg[y + i][x] == simbols[c]) {
                        s += 1;
                    }

                }
                if (s == DOTS_TO_WIN) {
                    System.out.println(simbols[c] + " the champion!!!");
                    win = true;
                    break;

                }
            }
        }
        for (int y = 0; y < SIZE - DOTS_TO_WIN + 1; y++) {
            for (int x = 0; x < SIZE - DOTS_TO_WIN + 1; x++) {
                s = 0;
                for (int i = 0; i < DOTS_TO_WIN; i++) {
                    if (pg[y + i][x + i] == simbols[c]) {
                        s += 1;
                    }

                }
                if (s == DOTS_TO_WIN) {
                    System.out.println(simbols[c]+ " the champion!!!");
                    win = true;
                    break;

                }
            }
        }

        for (int y = 0; y < SIZE - DOTS_TO_WIN + 1; y++) {
            for (int x = DOTS_TO_WIN - 1; x < SIZE; x++) {
                s = 0;
                for (int i = 0; i < DOTS_TO_WIN; i++) {
//                    System.out.println(pg[y+i][DOTS_TO_WIN-i-1]+" "+ simbols[c]+ " x="+(DOTS_TO_WIN-i-1)+" " +i+" y="+(y+i));

                    if (pg[y + i][DOTS_TO_WIN - i - 1] == simbols[c]) {
                        s += 1;
                    }

                }
                if (s == DOTS_TO_WIN) {
                    System.out.println(simbols[c] + " the champion!!!");
                    win = true;
                    break;

                }
            }
        }

        return win;
    }

    public static boolean checkToDraw() {
        boolean s = true;
        for (int i = 0; i < SIZE; i++) {
            if (s == false) {
                break;
            }
            for (int j = 0; j < SIZE; j++) {
                if (pg[i][j] == '.') {
                    s = false;
                    break;
                }
            }

        }
        //     System.out.println(s);
        if (s) {
            System.out.println("Ничья");
        }
        return s;
    }

    public static void stepPC() {
        System.out.println("Ход PC");
        int s;
        boolean b = false;
        //Защита
        for (int h = 1; h < DOTS_TO_WIN; h++) {
            //b = false;
            for (int y = 0; y < SIZE; y++) {
                for (int x = 0; x < SIZE - DOTS_TO_WIN + 1; x++) {
                    if (b) {
                        break;
                    }
                    s = 0;
                    for (int i = 0; i < DOTS_TO_WIN; i++) {
                        if (pg[y][x + i] == simbols[0]) {
                            s += 1;
                        } else if (pg[y][x + i] == simbols[1]) {
                            s = 0;
                            break;
                        }
                    }
                    if (s == DOTS_TO_WIN - h) {
                        for (int i = 0; i < DOTS_TO_WIN; i++) {
                            if (pg[y][x + i] == '.') {
                                pg[y][x + i] = simbols[1];
                                b = true;
                                break;
                            }
                        }
                    }
                }
            }
            if (b) {
                break;
            }
            for (int y = 0; y < SIZE - DOTS_TO_WIN + 1; y++) {
                for (int x = 0; x < SIZE; x++) {
                    if (b) {
                        break;
                    }
                    s = 0;
                    for (int i = 0; i < DOTS_TO_WIN; i++) {
                        if (pg[y + i][x] == simbols[0]) {
                            s += 1;
                        } else if (pg[y + i][x] == simbols[1]) {
                            s = 0;
                            break;
                        }
                    }
                    if (s == DOTS_TO_WIN - h) {
                        for (int i = 0; i < DOTS_TO_WIN; i++) {
                            if (pg[y + i][x] == '.') {
                                pg[y + i][x] = simbols[1];
                                b = true;
                                break;
                            }
                        }
                    }
                }
            }
            if (b) {
                break;
            }
            for (int y = 0; y < SIZE - DOTS_TO_WIN + 1; y++) {
                for (int x = 0; x < SIZE - DOTS_TO_WIN + 1; x++) {
                    if (b) {
                        break;
                    }
                    s = 0;
                    for (int i = 0; i < DOTS_TO_WIN; i++) {
                        if (pg[y + i][x + i] == simbols[0]) {
                            s += 1;
                        } else if (pg[y + i][x + i] == simbols[1]) {
                            s = 0;
                            break;
                        }
                    }
                    if (s == DOTS_TO_WIN - h) {
                        for (int i = 0; i < DOTS_TO_WIN; i++) {
                            if (pg[y + i][x + i] == '.') {
                                pg[y + i][x + i] = simbols[1];
                                b = true;
                                break;
                            }
                        }
                    }

                }
            }
            if (b) {
                break;
            }
            for (int y = 0; y < SIZE - DOTS_TO_WIN + 1; y++) {
                for (int x = DOTS_TO_WIN - 1; x < SIZE; x++) {
                    if (b) {
                        break;
                    }
                    s = 0;
                    for (int i = 0; i < DOTS_TO_WIN; i++) {
//                    System.out.println(pg[y+i][DOTS_TO_WIN-i-1]+" "+ simbols[c]+ " x="+(DOTS_TO_WIN-i-1)+" " +i+" y="+(y+i));
                        if (pg[y + i][DOTS_TO_WIN - i - 1] == simbols[0]) {
                            s += 1;
                        } else if (pg[y + i][DOTS_TO_WIN - i - 1] == simbols[1]) {
                            s = 0;
                            break;
                        }

                    }
                    if (s == DOTS_TO_WIN - h) {
                        for (int i = 0; i < DOTS_TO_WIN; i++) {
                            if (pg[y + i][DOTS_TO_WIN - i - 1] == '.') {
                                pg[y + i][DOTS_TO_WIN - i - 1] = simbols[1];
                                b = true;
                                break;
                            }
                        }
                    }
                }
            }

        }
        //Нападение
        if (b == false) {
            for (int h = 1; h < DOTS_TO_WIN; h++) {
                b = false;
                for (int y = 0; y < SIZE; y++) {
                    for (int x = 0; x < SIZE - DOTS_TO_WIN + 1; x++) {
                        if (b) {
                            break;
                        }
                        s = 0;
                        for (int i = 0; i < DOTS_TO_WIN; i++) {
                            if (pg[y][x + i] == simbols[1]) {
                                s += 1;
                            } else if (pg[y][x + i] == simbols[0]) {
                                break;
                            }
                        }
                        if (s == DOTS_TO_WIN - h) {
                            for (int i = 0; i < DOTS_TO_WIN; i++) {
                                if (pg[y][x + i] == '.') {
                                    pg[y][x + i] = simbols[1];
                                    b = true;
                                    break;
                                }
                            }
                        }
                    }
                }
                if (b) {
                    break;
                }
                for (int y = 0; y < SIZE - DOTS_TO_WIN + 1; y++) {
                    for (int x = 0; x < SIZE; x++) {
                        if (b) {
                            break;
                        }
                        s = 0;
                        for (int i = 0; i < DOTS_TO_WIN; i++) {
                            if (pg[y + i][x] == simbols[1]) {
                                s += 1;
                            } else if (pg[y + i][x] == simbols[0]) {
                                break;
                            }
                        }
                        if (s == DOTS_TO_WIN - h) {
                            for (int i = 0; i < DOTS_TO_WIN; i++) {
                                if (pg[y + i][x] == '.') {
                                    pg[y + i][x] = simbols[1];
                                    b = true;
                                    break;
                                }
                            }
                        }
                    }
                }
                if (b) {
                    break;
                }
                for (int y = 0; y < SIZE - DOTS_TO_WIN + 1; y++) {
                    for (int x = 0; x < SIZE - DOTS_TO_WIN + 1; x++) {
                        if (b) {
                            break;
                        }
                        s = 0;
                        for (int i = 0; i < DOTS_TO_WIN; i++) {
                            if (pg[y + i][x + i] == simbols[1]) {
                                s += 1;
                            } else if (pg[y + i][x + i] == simbols[0]) {
                                break;
                            }
                        }
                        if (s == DOTS_TO_WIN - h) {
                            for (int i = 0; i < DOTS_TO_WIN; i++) {
                                if (pg[y + i][x + i] == '.') {
                                    pg[y + i][x + i] = simbols[1];
                                    b = true;
                                    break;
                                }
                            }
                        }

                    }
                }
                if (b) {
                    break;
                }
                for (int y = 0; y < SIZE - DOTS_TO_WIN + 1; y++) {
                    for (int x = DOTS_TO_WIN - 1; x < SIZE; x++) {
                        if (b) {
                            break;
                        }
                        s = 0;
                        for (int i = 0; i < DOTS_TO_WIN; i++) {
//                    System.out.println(pg[y+i][DOTS_TO_WIN-i-1]+" "+ simbols[c]+ " x="+(DOTS_TO_WIN-i-1)+" " +i+" y="+(y+i));
                            if (pg[y + i][DOTS_TO_WIN - i - 1] == simbols[1]) {
                                s += 1;
                            } else if (pg[y + i][DOTS_TO_WIN - i - 1] == simbols[0]) {
                                break;
                            }

                        }
                        if (s == DOTS_TO_WIN - h) {
                            for (int i = 0; i < DOTS_TO_WIN; i++) {
                                if (pg[y + i][DOTS_TO_WIN - i - 1] == '.') {
                                    pg[y + i][DOTS_TO_WIN - i - 1] = simbols[1];
                                    b = true;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
    }


}
