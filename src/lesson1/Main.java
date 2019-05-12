package lesson1;

public class Main {

    public static void main (String[] args) {
        System.out.println("Задание №2");
        dataType();

        System.out.println("Задание №3");
        System.out.println("a * (b + (c / d)) = "+dataIn(8,2,3,1));

        System.out.println("Задание №4");
        System.out.println(trueOrFalse(5,6));

        System.out.println("Задание №5");
        digit(5);

        System.out.println("Задание №6");
        System.out.println(subZero(5));

        System.out.println("Задание №7");
        helloName("Guest");

        System.out.println("Задание №8");
        yers(1900);

    }

    public static void dataType() {
        byte a = 100;
        short b = 10000;
        int c = 1000000000;
        long d = 1000000000000000000L;
        char e = 'e';
        String f = "FFF";
        float g = 1.12345678910111213141516f;
        double h = 1.12345678910111213141516171819202122;
        boolean i = false;
        System.out.println("byte = " + a);
        System.out.println("short = " + b);
        System.out.println("int = " + c);
        System.out.println("long = " + d);
        System.out.println("char = " + e);
        System.out.println("String = " + f);
        System.out.println("float = " + g);
        System.out.println("double = " + h);
        System.out.println("boolean = " + i);
    }

    public static int dataIn(int a,int b, int c, int d) {
        return a * (b + (c / d));
    }

    public static boolean trueOrFalse(int a, int b) {
        return ((a+b)>=10)&&((a+b)<=20);
    }

    public static void digit(int a) {
        if (a < 0) {
            System.out.println("Отрицательное");
        } else {
            System.out.println("Положительное");
        }
    }

    public static boolean subZero(int a) {
        if (a < 0) {
            return true;
        } else {
            return false;
        }

    }

    public static void helloName(String name) {
        System.out.println("Привет "+ name);
    }

    public static void yers(int a) {
        if (a%400 == 0) {
            System.out.println("Yes");
        } else if (a%100==0) {
            System.out.println("No");
        } else if (a%4==0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
