package lesson7;

public class Plate {
    private int food;
    private int maxVolume = 100;

    public Plate(int food) {
        this.food = food;
    }

    public void decreaseFood(int n, Cat c) {
        if (food > n) {
            food -= n;
            c.setSatiety(true);
            System.out.println("Кот "+ c.getName()+ " поел на "+ n  );
        } else {
            System.out.println("В миске недостаточно еды для насыщения кота, нужно добавить еды в миску");

        }
    }
    public void appendFood (int n) {
        if ( maxVolume - food > n) {
            food += n;
            System.out.printf("В миску добавленно %d \n", n);
        } else {
            System.out.println("Миску нужно наполнять меньшей по обьему порцией");
        }
    }

    public void info() {
        System.out.println("plate: " + food);
    }
}
