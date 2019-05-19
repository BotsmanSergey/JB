package lesson5;

public class Main5 {
    public static void main(String[] args) {
        Staff[] staff = new Staff[5];
        staff[0] = new Staff("Ivanov Ivan Ivanovig", "boss", "ivan@mail.com", "+7 978 987 64 46", 20 , 20);
        staff[1] = new Staff("Sergeev Sergey Sergeevich", "exboss", "sergey@mail.com", "+7 436 547 68 49", 30 , 30);
        staff[2] = new Staff("Borisov Boris Borisovich", "manager", "boris@mail.com", "+7 623 273 24 43", 40 , 40);
        staff[3] = new Staff("Viktorov Virtor Viktorivich", "engeneer", "viktor@mail.com", "+7 364 377 55 47", 50 , 50);
        staff[4] = new Staff("Maksimov Maksim Maksimvich", "engeneer", "maksim@mail.com", "+7 174 378 58 88", 60 , 60);
        for (int i = 0; i <staff.length ; i++) {
            if(staff[i].age > 40){
                staff[i].info();
            }
        }
    }



}
