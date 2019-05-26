package lesson6;

public class Dog extends Animal {
    static int count;
    private int stamina = 200;
    private int swim = 10;


    public Dog(String name) {
        this.name = name;
        count ++;


    }


    public void run( int distance){
        System.out.println(distance<stamina? "Пёс "+ name + " пробежал " + distance + "М "  : "Пёс "+ name + " пробежал " + stamina + "М и лег отдохнуть");
    }
    public void swiming(int distance){
        System.out.println(distance<swim? "Пёс "+ name + " проплыл " + distance + "М "  : "Пёс "+ name + " проплыл " + stamina + "М и после начал тонуть, но это была лужа и он не утанул");
    }
}
