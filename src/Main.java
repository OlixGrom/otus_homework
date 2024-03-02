import animals.Animal;
import data.AnimalData;
import data.ColorData;
import data.InputMenu;
import exception.AnimalNotSupported;
import factory.AnimalFactory;
import helpers.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    static List<Animal> animals = new ArrayList<>();

    public static void main(String[] args) throws AnimalNotSupported {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            //System.out.println(DisplayEnum.displayListEnum(InputMenu.class));
            System.out.print(String.format("Введите команду %s: ", DisplayEnum.displayListEnum(InputMenu.class)));
            String answerOperation = scanner.nextLine();
            answerOperation = answerOperation.toUpperCase(Locale.ROOT).trim();
            if (!CheckEnum.checkValueInEnum(InputMenu.class, answerOperation.toUpperCase(Locale.ROOT))) {//проверили команду
                System.out.println(String.format("Команда \"%s\" не верна. Повторите еще раз", answerOperation));
                continue;
            }

            switch (InputMenu.valueOf(answerOperation)) {
                case ADD:
                    if (addList()) {
                        break;
                    } else {
                        continue;
                    }
                case LIST:
                    PrintList.print(animals);
                    break;
                case EXIT:
                    System.out.println("До свидания!");
                    System.exit(0);
            }
        }
    }

    private static boolean addList() throws AnimalNotSupported {
        //Scanner scanner = new Scanner(System.in);
        String name = "", color = "", tmpStr, typeAnimal;
        int age = 0;
        double weight = 0;
        EnterData enterData = new EnterData(new Scanner(System.in));

        typeAnimal = enterData.enterType();
        name = enterData.enterName();
        age = Integer.parseInt(enterData.enterAge());
        weight = Float.parseFloat(enterData.enterWeight());
        color = enterData.enterColor();
        //------------------------------------
        AnimalData animalData = AnimalData.valueOf(typeAnimal);
        Animal animalObject = new AnimalFactory().create(animalData, name, age, weight, color);
        animals.add(animalObject);
        animalObject.say();
        return true;
    }
}

