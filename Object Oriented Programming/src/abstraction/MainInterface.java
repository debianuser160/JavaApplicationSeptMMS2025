
package abstraction;

public class MainInterface {
    public static void main(String[] args){
        SmartPhone smartPhone = new SmartPhone();
        
        Nokia3310 nokia = new Nokia3310();
        
        System.out.println("\nSmartPhone Interface");
        smartPhone.makeCall();
        smartPhone.connectToWiFi();
        smartPhone.takePicture();
        smartPhone.playGame();
        smartPhone.playMovie();
        smartPhone.playMusic();
        
        System.out.println("===================");
        
        System.out.println("\nNokia 3310 Interface");
        nokia.makeCall();
        nokia.playGame();
        nokia.playMusic();
        
    } 
}
