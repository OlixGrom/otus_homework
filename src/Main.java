import animals.Animal;
import data.AnimalData;
import data.InputMenu;
import exception.AnimalNotSupported;
import factory.AnimalFactory;
import helpers.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    static private List<Animal> animals = new ArrayList<>();

    public static void main(String[] args) throws AnimalNotSupported {
        Scanner scanner = new Scanner(System.in);
        CheckEnum checkEnum = new CheckEnum();
        DisplayEnum displayEnum = new DisplayEnum();
        PrintList printList = new PrintList();
        while (true) {
            System.out.print(String.format("Введите команду %s: ", displayEnum.displayListEnum(InputMenu.class)));
            String answerOperation = scanner.nextLine();
            answerOperation = answerOperation.toUpperCase(Locale.ROOT).trim();
            if (!checkEnum.checkValueInEnum(InputMenu.class, answerOperation.toUpperCase(Locale.ROOT))) {//проверили команду
                System.out.println(String.format("Команда \"%s\" не верна. Повторите еще раз", answerOperation));
                continue;
            }

            switch (InputMenu.valueOf(answerOperation)) {
                case ADD:
                    addList().
                            say();
                    break;
                case LIST:
                    printList.print(animals);
                    break;
                case EXIT:
                    System.out.println("До свидания!");
                    System.exit(0);
            }
        }
    }

    private static Animal addList() throws AnimalNotSupported {

        String name = "", color = "", tmpStr, typeAnimal;
        int age = 0;
        double weight = 0;
        EnterData enterData = new EnterData(new Scanner(System.in));

        typeAnimal = enterData.enterType();
        AnimalData animalData = AnimalData.valueOf(typeAnimal);


        name = enterData.enterName();
        age = Integer.parseInt(enterData.enterAge());
        weight = Float.parseFloat(enterData.enterWeight());
        color = enterData.enterColor();
        //------------------------------------

        Animal animalObject = new AnimalFactory().create(animalData, name, age, weight, color);
        animals.add(animalObject);
        return animalObject;
    }
}