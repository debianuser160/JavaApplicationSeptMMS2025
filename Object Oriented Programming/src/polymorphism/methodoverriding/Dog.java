
package polymorphism.methodoverriding;


public class Dog extends Animal{

    public Dog() {
    }
    @Override
    void sound(){
        System.out.println("All Dogs Bark");
    }
}
