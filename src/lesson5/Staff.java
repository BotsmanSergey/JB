package lesson5;

public class Staff {
    private String name;
    private String position;
    private String email;
    private String tel;
    private int salary;
    public int age;
    void info(){
        System.out.println(name + " " + position + " " + email + " " + tel + " " + salary + " " + age);
    }

     Staff(String name, String position, String email, String tel, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.tel = tel;
        this.salary = salary;
        this.age = age;
    }
}
