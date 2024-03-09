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
                return new Duck( name,  age,  weight,  color );
            }
            case DOG:{
                return new Dog( name,  age,  weight,  color);
            }
            case CAT:{
                return new Cat( name,  age,  weight,  color);
            }
        }
        throw new AnimalNotSupported(animalData);
    }
}
