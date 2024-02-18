public class Animal {
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

    /*public Animal() {

    }*/

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
    public void Say() {
        System.out.println("Я говорю");
    }

    public void Go() {
        System.out.println("Я иду");
    }

    public void Drink() {
        System.out.println("Я пью");
    }

    public void Eat() {
        System.out.println("Я ем");
    }

    @Override
    public String toString() {
        String yearStr = (age == 1) ? "год" : ((age >= 2 && age <= 4) ? "года" : "лет");
        return "Привет! меня зовут " + getName() + ", мне " + getAge() + " " + yearStr +
                ", я вешу - " + getWeight() + " кг, мой цвет - " + getColor();
    }
}
