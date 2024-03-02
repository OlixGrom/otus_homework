package helpers;

import animals.Animal;

import java.util.List;

public class PrintList {
    public static void print(List<Animal> animals) {
        if (animals.size() == 0) {
            System.out.println("Список животных пуст. ");
        } else {
            System.out.println("Список животных: ");
            for (Animal animal : animals) {
                System.out.println(animal.toString());
            }
        }
    }
}
