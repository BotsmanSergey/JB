package lesson7;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety = false;
    static int countCat = 0;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        countCat++;
    }

    public void eat(Plate p, Cat c) {
        p.decreaseFood(appetite, c);
    }

    public void getCountCat() {
        System.out.printf("Количество котов дошло до %d штук\n", countCat);
    }

    public String getName() {
        return name;
    }
    public void setSatiety(boolean c){
        satiety = c;
    }

    public String getSatiety() {
        if (satiety) {
            return "сыт";
        } else {
            return "остался голодным";
        }
    }
}
