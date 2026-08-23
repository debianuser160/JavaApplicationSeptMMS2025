
package runtime;


public class NumberFormatExceptionHandling {
    public static void main(String[] args){
        try{
        String age = "twenty";
        
        int myAge = Integer.parseInt(age);
        
        System.out.println("I am " + myAge + " Years old");
            
        }
        catch(NumberFormatException e){
            System.out.println("Enter a valid number");
            System.out.println(e.getMessage());
        }
        
        
    }
}
