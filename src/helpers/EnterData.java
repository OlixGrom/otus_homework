package helpers;

import data.AnimalData;
import data.ColorData;

import java.util.Locale;
import java.util.Scanner;

public class EnterData {
    String tmpStr;
    Scanner scanner;

    public EnterData(Scanner scanner) {
        this.scanner = scanner;
    }


    public String enterType(){
        while (true) {
            System.out.print(String.format("Выберите животное: %s ", DisplayEnum.displayListEnum(AnimalData.class)));
            tmpStr = scanner.next().trim();
            tmpStr = tmpStr.toUpperCase(Locale.ROOT).trim();
            if (CheckEnum.checkValueInEnum(AnimalData.class, tmpStr.toUpperCase(Locale.ROOT))) {//проверили животное
                break;
            }
            System.out.println(String.format("Животное \"%s\" выбрано не верно. Повторите еще раз ", tmpStr));
        }
        return tmpStr;
    }

    public String enterName(){
        while (true) {
            System.out.print("Введите кличку животного: ");
            tmpStr = scanner.next().trim();
            if (Validators.isStringChars(tmpStr)) {
                break;
            }
            System.out.println("Вы ввели некорректную кличку животного");
        }
        return tmpStr;
    }

    public String enterWeight(){
        while (true) {
            System.out.print("Введите вес: ");
            tmpStr = scanner.next().trim();
            if (Validators.isStringFloat(tmpStr) && Float.parseFloat(tmpStr) > 0) {
                break;
            }
            System.out.println("Вы ввели некорректный возраст животного");
        }
        return tmpStr;
    }

    public String enterAge(){
        while (true) {
            System.out.print("Введите возраст: ");
            tmpStr = scanner.next().trim();
            if (Validators.isStringNumber(tmpStr) && Integer.parseInt(tmpStr) > 0) {
                break;
            }
            System.out.println("Вы ввели некорректный возраст животного");
        }
        return tmpStr;
    }

    public String enterColor(){
        while (true) {
            System.out.print(String.format("Выберите цвет животного: %s ", DisplayEnum.displayListEnum(ColorData.class)));
            tmpStr = scanner.next().toUpperCase(Locale.ROOT).trim();
            if (CheckEnum.checkValueInEnum(ColorData.class, tmpStr)) {//проверили животное
                break;
            }
            System.out.println(String.format("Вы ввели некорректный цвет - %s. Повторите еще раз", tmpStr));
        }
        return tmpStr;
    }

}
