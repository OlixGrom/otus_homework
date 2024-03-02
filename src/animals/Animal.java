package animals;

public abstract class Animal {
    //Свойства
    private String name;
    private int age;
    private double weight;
    private String color;

    public Animal(String name, int age, double weight, String color) {
        setName(name);
        setAge(age);
        setWeight(weight);
        setColor(color);
    }

    //геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    //Методы
    public void say() {
        System.out.println("Я говорю");
    }

    public void go() {
        System.out.println("Я иду");
    }

    public void drink() {
        System.out.println("Я пью");
    }

    public void eat() {
        System.out.println("Я ем");
    }

    @Override
    public String toString() {
        return  String.format("Привет! меня зовут %s, мне %d %s , я вешу - %.3f кг, мой цвет - %s",name,age,getYearStr(),weight,color);
    }
    private String getYearStr (){
        int ostatok = age%10;

        if (age >= 11 && age <= 14){
            return "лет";
        }

        if (ostatok == 1){
            return "год";
        }

        if (ostatok >= 5){
            return "лет";
        }

        if (ostatok >= 2){
            return "года";
        }

        return "лет";
    }
}
