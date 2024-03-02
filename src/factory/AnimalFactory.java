package factory;
import animals.*;
import animals.birds.Duck;
import animals.pets.Cat;
import animals.pets.Dog;
import data.AnimalData;
import exception.AnimalNotSupported;

public class AnimalFactory {
    public Animal create(AnimalData animalData, String name, int age, double weight, String color) throws AnimalNotSupported {
        switch(animalData){
            case DUCK:{
                Duck duck = new Duck( name,  age,  weight,  color );
                return duck;
            }
            case DOG:{
                Dog dog = new Dog( name,  age,  weight,  color);
                return dog;
            }
            case CAT:{
                Cat cat = new Cat( name,  age,  weight,  color);
                return cat;
            }
        }
        throw new AnimalNotSupported(animalData);
    }
}
