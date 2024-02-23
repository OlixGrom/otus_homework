import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import animals.*;
import data.*;
import exception.AnimalNotSupported;
import factory.AnimalFactory;

public class Main {
    static List<Animal> animals = new ArrayList<>();
    static String name = "", color = "";
    static int age = 0;
    static double weight = 0;
    static Animal cat, dog, duck;

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws AnimalNotSupported {
        boolean flagAnswer = true;
        while (true) {
            System.out.print(displayInputMenu());//приглашение к вводу команд
            String answerOperation = scanner.nextLine(); // считали команду
            answerOperation = answerOperation.toUpperCase(Locale.ROOT).trim();
            if (!verifyCommand(answerOperation.toUpperCase(Locale.ROOT))) {//проверили команду
                System.out.println(String.format("Команда \"%s\" не верна. Повторите еще раз", answerOperation));
                continue;//повторили запрос на ввод команды
            }

            switch (InputMenu.valueOf(answerOperation)) {//если команда валидная - продолжаем
                case ADD:
                    if (addList()) {
                        break;
                    } else {
                        continue;
                    }
                case LIST:
                    printList();
                    break;
                case EXIT:
                    System.out.println("До свидания!");
                    System.exit(0);
            }
        }
    }

    private static boolean addList() throws AnimalNotSupported {
        System.out.print(displayAnimal());
        String answerAnimal = scanner.nextLine(); // считали животное
        answerAnimal = answerAnimal.toUpperCase(Locale.ROOT).trim();
        if (!verifyAnimal(answerAnimal.toUpperCase(Locale.ROOT))) {//проверили животное
            System.out.println(String.format("Животное \"%s\" выбрано не верно. Повторите еще раз", answerAnimal));
            return false;//повторили запрос на ввод команды
        }

        Scanner animalType = new Scanner(System.in);
        System.out.print("Введите имя: ");
        name = animalType.nextLine().toLowerCase(Locale.ROOT).trim();

        System.out.print("Введите цвет:");
        color = animalType.nextLine().toLowerCase(Locale.ROOT).trim();

        System.out.print("Введите возраст: ");

        if (animalType.hasNextInt()) {
            age = animalType.nextInt();
            if (age < 0) {
                System.out.println("Не корректный возраст!");
                return false;
            }
        } else {
            System.out.println("Ошибка ввода!");
            return false;
        }

        System.out.print("Введите вес: ");
        if (animalType.hasNextDouble()) {
            weight = animalType.nextDouble();
            if (weight < 0) {
                System.out.println("Не корректный вес!");
                return false;
            }
        } else {
            System.out.println("Ошибка ввода!");
            return false;
        }
        //------------------------------------
        AnimalData animalData = AnimalData.valueOf(answerAnimal);
        Animal animalObject = new AnimalFactory().create(animalData, name, age, weight, color);
        animals.add(animalObject);
        return true;
    }

    private static void printList() {
        if (animals.size() == 0) {
            System.out.println("Список животных пуст. ");
        } else {
            System.out.println("Список животных: ");
            for (Animal animal : animals) {//toString()
                System.out.println(animal.toString());
            }
        }
    }
    private static boolean verifyCommand(String input) {
        InputMenu[] inputMenu = InputMenu.values();
        for (int i = 0; i < InputMenu.values().length; i++) {
            if (input.equals(inputMenu[i].name())) {
                return true;
            }
        }
        return false;
    }
    private static boolean verifyAnimal(String animal) {
        AnimalData[] animalData = AnimalData.values();
        for (int i = 0; i < AnimalData.values().length; i++) {
            if (animal.equals(animalData[i].name())) {
                return true;
            }
        }
        return false;
    }
    private static String displayInputMenu() {
        InputMenu[] inputMenu = InputMenu.values();
        String[] listInputMenu = new String[InputMenu.values().length];
        for (int i = 0; i < listInputMenu.length; i++) {
            listInputMenu[i] = inputMenu[i].name().toUpperCase();
        }
        return String.format("Что вы хотите сделать %s: ", String.join("/", listInputMenu));
    }
    private static String displayAnimal() {
        AnimalData[] animalData = AnimalData.values();
        String[] listAnimal = new String[AnimalData.values().length];
        for (int i = 0; i < listAnimal.length; i++) {
            listAnimal[i] = animalData[i].name().toUpperCase();
        }
        return String.format("Какое животное вы хотите добавить: %s ", String.join("/", listAnimal));
    }
}

