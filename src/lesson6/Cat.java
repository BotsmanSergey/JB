package lesson6;

public class Cat extends Animal {
    static int count;
    private int stamina = 200;
    //private int swim = 0;


    public Cat(String name) {
        this.name = name;
        count ++;


    }


    public void run( int distance){
        System.out.println(distance<stamina? "Кот "+ name + " пробежал " + distance + "М "  : "Кот "+ name + " пробежал " + stamina + "М и лег отдохнуть");
    }
    public void swiming(){
        System.out.println("Кот " + name + " не умеет плавать!!!");
    }

}
