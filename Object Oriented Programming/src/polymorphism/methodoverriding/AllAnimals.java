
package polymorphism.methodoverriding;


public class AllAnimals {
    public static void main(String[] args){
        Animal[] animalObj={
            new Dog(),
            new Cat(),
            new Lion()
        };
        
        for(Animal animal : animalObj){
            animal.sound();
        }      
        
    }
}
