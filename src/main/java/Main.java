import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

public class Main {
    private static final Logger log = Logger.getLogger("log");

    public static void main(String[] args) {
        ConsoleAppender consoleAppender = new ConsoleAppender();
        consoleAppender.setLayout(new SimpleLayout());
        consoleAppender.activateOptions();
        Logger.getRootLogger().addAppender(consoleAppender);
        Scanner scan = new Scanner(System.in);

        ArrayList<Vehicle> list = new ArrayList<Vehicle>();
        list.add(new Vehicle(VehicleTypes.CAR, 305, "BMW"));
        list.add(new Vehicle(VehicleTypes.CAR, 287, "Lexus"));
        list.add(new Vehicle(VehicleTypes.PLANE, 871, "Airbus"));
        list.add(new Vehicle(VehicleTypes.PLANE, 918, "Boeing"));
        list.add(new Vehicle(VehicleTypes.SHIP, 48, "Hyundai"));
        list.add(new Vehicle(VehicleTypes.SHIP, 40, "DSME"));
        list.add(new Vehicle(VehicleTypes.BICYCLE, 70, "Norco"));
        list.add(new Vehicle(VehicleTypes.BICYCLE, 60, "Trek"));
        Collections.sort(list);

        boolean run = true;
        while (run) {
            log.info("Choose one option from ones written below:");
            log.info("CAR, SHIP, PLANE, BICYCLE, ALL, EXIT");
            String choice = scan.next();
            Vehicle vehicle = null;

            switch (choice) {
                case "ALL":
                    vehicle = list.get(0);
                    break;
                case "EXIT":
                    run = false;
                    log.info("Bye!");
                    break;
                default:
                    try {
                        vehicle = Vehicle.getFastest(VehicleTypes.valueOf(choice),list);
                    } catch (IllegalArgumentException ex) {
                        log.error("Please enter a valid option!");
                    }
            }
            if (vehicle != null)
                log.info(vehicle.getType() + " produced by " + vehicle.getProducer() + " with speed of " + vehicle.getSpeed() + " is the fastest.");
        }
    }
}
