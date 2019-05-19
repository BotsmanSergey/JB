package lesson3;


import java.util.Random;
import java.util.Scanner;

public class Main3 {

    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();

    public static void main(String[] args) {
        System.out.println("Задание №1");
        guessTheNuber();
        System.out.println("Задание №2");
        guessWord();
        sc.close();
    }

    //1. Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки угадать это число.
    // При каждой попытке компьютер должен сообщить, больше ли указанное пользователем число, чем загаданное, или меньше.
    // После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
    public static void guessTheNuber() {

        int g;
        int b;

        do {
            int a = rand.nextInt(10);
            //System.out.println("Загаданное число - " + a);
            for (int i = 3; i > 0; i--) {
                System.out.printf("Угадайте число от 0 до 9 за %d попытки\n", i);
                g = normalIn(0, 9);
                if (g == a) {
                    System.out.printf("You are the champion!!! c %d -го раза\n", 4 - i);
                    break;
                } else if (g < a) {
                    System.out.printf("Недобор, осталость %d попытки\n", i - 1);
                } else {
                    System.out.printf("Перебор, осталость %d попытки\n", i - 1);
                }
//                switch (i) {
//                    case 3:
//                        System.out.println("Осталасть две попытки");
//                        break;
//                    case 2:
//                        System.out.println("Осталасть одна попытка");
//                        break;
//                    case 1:
//                        System.out.println("Попыток больше нет");
//                        break;
//                }
            }
            System.out.println("Хочешь испытать удачу ещё раз? 1-да/0-нет");
            b = normalIn(0, 1);
        } while (b != 0);


    }
    public static int normalIn(int m, int n){
        int g = -1;
        do {
            String str = sc.nextLine();
            if (str.length() == 1) {
                for (int i = m; i < n+1; i++) {
                    if (str.equals(Integer.toString(i))) {
                        g = i;
                        break;
                    }
                }
                if (!(g >= 0 && g <= n)){
                    System.out.printf("Не верный ввод, введите число от 0 до %d\n", n);
                }
            } else {
                System.out.printf("Не верный ввод, введите число от 0 до %d (только один символ)\n", n);
            }
        }while (!(g >= 0 && g <= n));
        //System.out.println("воздврат нормалИн " + g);
        return g;
    }

    //2. * Создать массив из слов
    //String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"}.
    //При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя, сравнивает его с загаданным
    // словом и сообщает, правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы, которые стоят на своих местах.
    //apple – загаданное
    //apricot - ответ игрока
    //ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
    //Для сравнения двух слов посимвольно можно пользоваться:
    //String str = "apple";
    //char a = str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
    //Играем до тех пор, пока игрок не отгадает слово.
    //Используем только маленькие буквы.

    public static void guessWord() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String food = words[rand.nextInt(words.length)];
//        System.out.println("Загаданное слово: " + food);
        System.out.println("Угадайте слово");
        String answer;
        do {
            answer = sc.nextLine();
            if (!(answer.equals(food))) {
                int minLength = Math.min(food.length(), answer.length());
                for (int i = 0; i < minLength; i++) {
                    if (food.charAt(i) == answer.charAt(i)) {
                        System.out.print(food.charAt(i));
                    } else {
                        System.out.print("*");
                    }
                }

                for (int i = minLength; i < 15; i++) {
                    System.out.print("*");
                }

                System.out.println();
            }
        } while (!(answer.equals(food)));
        System.out.println("Верно: " + food);
    }
}