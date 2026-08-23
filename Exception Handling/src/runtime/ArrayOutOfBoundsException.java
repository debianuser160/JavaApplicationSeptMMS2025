
package runtime;


public class ArrayOutOfBoundsException {
    public static void main(String[] args){
        int[] age = {16,21,19,20,14};
        try{
        System.out.println("Element at index 5 is: " + age[6]);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid array index");
        }
    }
}
