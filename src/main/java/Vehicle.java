import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Vehicle implements Comparable{
    private VehicleTypes type;
    private Integer maxSpeed;
    private String producer;

    public Vehicle(VehicleTypes type, Integer maxSpeed, String producer) {
        this.type = type;
        this.maxSpeed = maxSpeed;
        this.producer = producer;
    }

    public static Vehicle getFastest(VehicleTypes type, ArrayList<Vehicle> list){
        for(Vehicle vehicle : list){
            if(vehicle.getType().equals(type))
                return vehicle;
        }
        throw new NoSuchElementException();
    }

    public VehicleTypes getType() {
        return type;
    }

    public int getSpeed() {
        return maxSpeed;
    }

    public String getProducer() {
        return producer;
    }

    @Override
    public int compareTo(Object o) {
        Vehicle compare = (Vehicle) o;
        int compare_speed = compare.getSpeed();
        return compare_speed - this.maxSpeed;
    }
}
