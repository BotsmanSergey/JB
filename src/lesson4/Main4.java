package lesson4;

import java.util.Scanner;

public class Main4 {
    static Scanner sc = new Scanner(System.in);
    static final int SIZE = 5;
    static final int DOTS_TO_WIN = 4;     //Не может быть больше чем SIZE
    static final char[] simbols = {'X', 'O'};
    static char[][] pg = new char[SIZE][SIZE];

    public static void main(String[] args) {


        map();
        output();
        do {
            stepPlayer();
            output();
            if (checkToWin(0)) {
                break;
            }
            if (checkToDraw()) {
                break;
            }
            stepPC();
            output();
            if (checkToWin(1)) {
                break;
            }
            if (checkToDraw()) {
                break;
            }
        } while (true);

        sc.close();
    }

    public static int[] normalIn3(int m, int n) {
        n += 1;
        int l = 2;
        int[] In = new int[l];
        boolean signal;
        boolean signal2;
        int nMax = n;
        if (n >= 11) {
            nMax = 10;
        }
        do {
            signal = true;

            String str = sc.nextLine();
            //  System.out.println(str);
            String[] digit = str.trim().split(" ");
            //  System.out.println("digit ="+digit[0]+"digit" +digit[1]);
            if (digit.length != l) {
                signal = false;
                System.out.printf("Ведите %d числа\n", l);
            } else {
                for (int k = 0; k < l; k++) {
                    //              System.out.printf("K = %d\n", k);
                    if (signal == false) {
                        break;
                    }
                    for (int i = 0; i < digit[k].length(); i++) {
                        if (signal == false) {
                            break;
                        }
                        signal2 = false;
                        for (int j = m; j < nMax; j++) {
                            if (digit[k].charAt(i) == Integer.toString(j).charAt(0)) {
                                //                    System.out.println(digit[k].charAt(i) + " " + Integer.toString(j).charAt(0));
                                signal2 = true;
                                signal = true;
                                break;
                            }
                        }
                        if (signal2 == false) {
//                           System.out.printf("индекс %d ввод %d НЕ пройден\n" ,i, k);
                            System.out.println("Вводите только цифры");
                            signal = false;
                            break;
                        }
//                        else {
//                            System.out.printf("индекс %d ввод %d пройден\n",i, k);
//                        }
                    }
                }

            }
            if (signal) {
                for (int k = 0; k < l; k++) {
                    if (Integer.parseInt(digit[k]) >= m && Integer.parseInt(digit[k]) <= n) {
                        In[k] = Integer.parseInt(digit[k]);
                    } else {
                        System.out.printf("Каждое чило должно быть от %d до %d\n", m, n);
                        signal = false;
                        break;
                    }
                }
            }


        } while (signal == false);
        // System.out.println("Все гуд " + In[0] + " "+ In[1]);
        return In;
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

    public static void stepPlayer() {
        System.out.println("Ваш Ход");
        int[] step;
        do {
            step = normalIn3(1, SIZE);
        } while (pg[step[1] - 1][step[0] - 1] != '.');
        pg[step[1] - 1][step[0] - 1] = simbols[0];

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
                    System.out.println("You are the champion!!!");
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
                    System.out.println("You are the champion!!!");
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
                    System.out.println("You are the champion!!!");
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
        boolean b;
        //Защита
        for (int h = 1; h < DOTS_TO_WIN; h++) {
            b = false;
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
//        if (b == false) {
//            for (int h = 1; h < DOTS_TO_WIN; h++) {
//                b = false;
//                for (int y = 0; y < SIZE; y++) {
//                    for (int x = 0; x < SIZE - DOTS_TO_WIN + 1; x++) {
//                        if (b) {
//                            break;
//                        }
//                        s = 0;
//                        for (int i = 0; i < DOTS_TO_WIN; i++) {
//                            if (pg[y][x + i] == simbols[1]) {
//                                s += 1;
//                            } else if (pg[y][x + i] == simbols[0]) {
//                                break;
//                            }
//                        }
//                        if (s == DOTS_TO_WIN - h) {
//                            for (int i = 0; i < DOTS_TO_WIN; i++) {
//                                if (pg[y][x + i] == '.') {
//                                    pg[y][x + i] = simbols[1];
//                                    b = true;
//                                    break;
//                                }
//                            }
//                        }
//                    }
//                }
//                if (b) {
//                    break;
//                }
//                for (int y = 0; y < SIZE - DOTS_TO_WIN + 1; y++) {
//                    for (int x = 0; x < SIZE; x++) {
//                        if (b) {
//                            break;
//                        }
//                        s = 0;
//                        for (int i = 0; i < DOTS_TO_WIN; i++) {
//                            if (pg[y + i][x] == simbols[1]) {
//                                s += 1;
//                            } else if (pg[y + i][x] == simbols[0]) {
//                                break;
//                            }
//                        }
//                        if (s == DOTS_TO_WIN - h) {
//                            for (int i = 0; i < DOTS_TO_WIN; i++) {
//                                if (pg[y + i][x] == '.') {
//                                    pg[y + i][x] = simbols[1];
//                                    b = true;
//                                    break;
//                                }
//                            }
//                        }
//                    }
//                }
//                if (b) {
//                    break;
//                }
//                for (int y = 0; y < SIZE - DOTS_TO_WIN + 1; y++) {
//                    for (int x = 0; x < SIZE - DOTS_TO_WIN + 1; x++) {
//                        if (b) {
//                            break;
//                        }
//                        s = 0;
//                        for (int i = 0; i < DOTS_TO_WIN; i++) {
//                            if (pg[y + i][x + i] == simbols[1]) {
//                                s += 1;
//                            } else if (pg[y + i][x + i] == simbols[0]) {
//                                break;
//                            }
//                        }
//                        if (s == DOTS_TO_WIN - h) {
//                            for (int i = 0; i < DOTS_TO_WIN; i++) {
//                                if (pg[y + i][x + i] == '.') {
//                                    pg[y + i][x + i] = simbols[1];
//                                    b = true;
//                                    break;
//                                }
//                            }
//                        }
//
//                    }
//                }
//                if (b) {
//                    break;
//                }
//                for (int y = 0; y < SIZE - DOTS_TO_WIN + 1; y++) {
//                    for (int x = DOTS_TO_WIN - 1; x < SIZE; x++) {
//                        if (b) {
//                            break;
//                        }
//                        s = 0;
//                        for (int i = 0; i < DOTS_TO_WIN; i++) {
////                    System.out.println(pg[y+i][DOTS_TO_WIN-i-1]+" "+ simbols[c]+ " x="+(DOTS_TO_WIN-i-1)+" " +i+" y="+(y+i));
//                            if (pg[y + i][DOTS_TO_WIN - i - 1] == simbols[1]) {
//                                s += 1;
//                            } else if (pg[y + i][DOTS_TO_WIN - i - 1] == simbols[0]) {
//                                break;
//                            }
//
//                        }
//                        if (s == DOTS_TO_WIN - h) {
//                            for (int i = 0; i < DOTS_TO_WIN; i++) {
//                                if (pg[y + i][DOTS_TO_WIN - i - 1] == '.') {
//                                    pg[y + i][DOTS_TO_WIN - i - 1] = simbols[1];
//                                    b = true;
//                                    break;
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
    }
}




