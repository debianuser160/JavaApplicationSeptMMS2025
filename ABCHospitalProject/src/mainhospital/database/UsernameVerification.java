
package mainhospital.database;


public class UsernameVerification {
    public void username(){
        
        String username = "barakroberts";
        int password = 12345;
        System.out.println("Username: ");
        
        while (true){
            if (username == "barakroberts"){
                if(password == 12345){
                    continue;
                }
                else{
                    System.out.println("Incorrect password. try again");
                    System.out.println("Terminating...");
                    break;
                }
            }
            else{
                System.out.println("Incorrect username. Please try again");
            }
        }
        
        
    }
}
