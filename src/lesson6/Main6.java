package lesson6;

public class Main6 {


public static void main(String[] args) {
    Cat cat = new Cat("Barsik");
    Cat cat1 = new Cat("Rizik");
    Dog dog = new Dog("Shorik");
    Dog dog1 = new Dog("Tuzik");

    cat.run(250);
    cat.swiming();
    cat1.run(100);
    dog.run (400);
    dog.swiming(5);
    dog1.run(600);
    dog1.swiming(15);
    System.out.println("All animals - " + (cat.count+dog.count));
}
}
