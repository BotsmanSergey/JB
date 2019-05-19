package other;

import java.util.Scanner;

public class fetcha {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        normalIn3(1, 9);

    }

    public static int[] normalIn3(int m, int n) {
        n+=1;
        int l = 2;
        int[] In = new int[l];
        boolean signal;
        boolean signal2;
        int nMax = n;
        if (n>=11){
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
                            if (digit[k].charAt(i) ==  Integer.toString(j).charAt(0)) {
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
                    if (Integer.parseInt(digit[k]) >= m && Integer.parseInt(digit[k])<= n) {
                        In[k] = Integer.parseInt(digit[k]);
                    } else {
                        System.out.printf("Каждое чило должно быть от %d до %d\n" , m, n );
                        signal = false;
                        break;
                    }
                }
            }


        } while (signal == false);
//        System.out.println("Все гуд " + In[0] + " "+ In[1]);
        return In;
    }
}
