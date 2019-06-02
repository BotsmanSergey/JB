package lesson7;

public class Main7 {
    public static void main(String[] args) {
        Cat[] catM = new Cat[3];
        catM[0] = new Cat("Murzik", 40);
        catM[2] = new Cat("Barsik", 30);
        catM[1] = new Cat("Rizik", 35);
        Plate plate = new Plate(100);
        plate.info();
        catM[1].eat(plate, catM[1]);
        plate.info();
        plate.appendFood(60);
        plate.info();
        plate.appendFood(5);
        plate.info();
        catM[2].eat(plate, catM[2]);
        plate.info();
        catM[0].eat(plate, catM[0]);
        plate.info();
        catM[0].getCountCat();
        for (Cat o: catM) {
            System.out.println("Кот по имени " + o.getName() + " " + o.getSatiety() );
        }
    }
}

