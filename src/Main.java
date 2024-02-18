import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static ArrayList<Animal> animals = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean flagAnswer = true;
        do {
            System.out.print("Что вы хотите сделать: add/list/exit: ");
            String answerOperation = scanner.nextLine();
            answerOperation = answerOperation.toUpperCase(Locale.ROOT).trim();
            switch (InputMenu.valueOf(answerOperation)) {
                case ADD:
                    addAnimal();
                    flagAnswer = true;
                    break;
                case LIST:
                    flagAnswer = true;
                    if (animals.size() == 0) {
                        System.out.println("Список животных пуст. ");
                    } else {
                        for (Animal animal : animals) {
                            System.out.println(animal.toString());
                        }
                    }
                    break;
                case EXIT:
                    flagAnswer = false;
                    System.out.println("<- Exit");
                    break;
                default:
                    System.out.println("Не верная команда. Повторите еще раз");
                    break;
            }
        } while (flagAnswer);
    }

    public static void addAnimal() {
        String name="", color="";
        int age=0;
        double weight=0;
        Animal cat, dog, duck;

        //System.out.print("Какое животное вы хотите добавить (cat/dog/duck) или вернитесь назад (back): ");
        System.out.print("Какое животное вы хотите добавить (cat/dog/duck): ");
        Scanner animalType = new Scanner(System.in);
        String answerType = animalType.nextLine();
        answerType = answerType.toLowerCase(Locale.ROOT).trim();

        if (answerType.equals("cat") || answerType.equals("dog")|| answerType.equals("duck")) {
            System.out.print("Введите имя: ");
            name = animalType.nextLine().toLowerCase(Locale.ROOT).trim();

            System.out.print("Введите цвет:");
            color = animalType.nextLine().toLowerCase(Locale.ROOT).trim();

            System.out.print("Введите возраст: ");
            age = animalType.nextInt();
            //animalType.nextLine();

            System.out.print("Введите вес:");
            weight = animalType.nextDouble();
        }

        switch (answerType) {
            case "cat":
                cat = new Cat(name, age, weight, color);
                animals.add(cat);
                cat.Say();
                break;
            case "dog":
                dog = new Dog(name, age, weight, color);
                animals.add(dog);
                dog.Say();
                break;
            case "duck":
                duck = new Duck(name, age, weight, color);
                animals.add(duck);
                duck.Say();
                break;
            /*case "back":
                System.out.println("Back <-");
                break;*/
            default:
                System.out.println("Back <-");
                break;
        }
    }
}

    /*static Scanner scanner = new Scanner(System.in);
    static int v, t, s, x;

    public static void main(String[] args) {
        boolean flag = true;
        do{
            System.out.print("Что хотите s/t/v/[E]xit: ");
            String answer = scanner.nextLine();
            answer = answer.toLowerCase(Locale.ROOT).trim();

            switch (answer){
                case "s":
                    getS();
                    //flag = false;
                    break;
                case "v":
                    //flag = false;
                    break;
                case "t":
                    //flag = false;
                    break;
                case "e":
                    System.out.print("The end");
                    flag = false;
                    break;
                default:
                    //flag = true;
                    break;
            }
        }while(flag);
    }

    public static void getS() {
        do {
            System.out.println("Введите cкорость >0 в км/ч:");
            v = scanner.nextInt();
        } while (v <= 0);
        /*while(v <= 0){
            System.out.println("Скорость ");
            v= scanner.nextInt();
        }
        do {
            System.out.println("Введит время >0 в ч:");
            t = scanner.nextInt();
        } while (t <= 0);
        /*while(t <0){
            System.out.println("Время ");
            t= scanner.nextInt();
        }
        s = v * t;
        System.out.println("s = v*t");
        System.out.println("s = " + v + "*" + t);
        System.out.println("s = " + s);
    }*/
