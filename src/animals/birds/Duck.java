package animals.birds;
import animals.Animal;

public class Duck extends Animal implements iFlying {
    public Duck(String name, int age, double weight, String color) {
        super(name,age,weight,color);
    }
    @Override
    public void say() {
        System.out.println("Кря");
    }

    @Override
    public void fly() {
        System.out.println("Я лечу");
    }

}
