
package classwork2;


public class VehicleMain {
    public static void main(String[] args){
        Vehicle[] vehicleObj={
            new Car(),
            new Bus(),
            new Bike()
        };
        
        for(Vehicle vehicle : vehicleObj){
            vehicle.move();
        }
    }
}
