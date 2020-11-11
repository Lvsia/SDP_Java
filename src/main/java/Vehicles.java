import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

public class Vehicles {
    private ArrayList<Vehicle> list = new ArrayList<Vehicle>();
    private Scanner scan = new Scanner(System.in);
    private static final Logger log = Logger.getLogger("log");

    public Vehicles(){
        ConsoleAppender consoleAppender = new ConsoleAppender();
        consoleAppender.setLayout(new SimpleLayout());
        consoleAppender.activateOptions();
        Logger.getRootLogger().addAppender(consoleAppender);

        list.add(new Vehicle("Car", 305, "BMW"));
        list.add(new Vehicle("Car", 287, "Lexus"));
        list.add(new Vehicle("Airplane", 871, "Airbus"));
        list.add(new Vehicle("Airplane", 918, "Boeing"));
        list.add(new Vehicle("Ship", 48, "Hyundai"));
        list.add(new Vehicle("Ship",40, "DSME"));
        list.add(new Vehicle("Bicycle",70, "Norco"));
        list.add(new Vehicle("Bicycle", 60, "Trek"));

        int choice = 0;
        while (choice != 6){
            log.info("Choose a number to see the fastest vehicle from selected category!");
            log.info("1. Car");
            log.info("2. Ship");
            log.info("3. Plane");
            log.info("4. Bicycle");
            log.info("5. All");
            log.info("6. Exit");
            try{
                choice = scan.nextInt();
            }catch(InputMismatchException e){
                log.error("Invalid data type!");
            }

            switch(choice){
                case 1:
                    findFastest("Car");
                    break;
                case 2:
                    findFastest("Ship");
                    break;
                case 3:
                    findFastest("Airplane");
                    break;
                case 4:
                    findFastest("Bicycle");
                    break;
                case 5:
                    findFastest("ALL");
                    break;
                case 6:
                    break;
                default:
                    try{
                        log.error("Please choose a valid number!");
                    }catch(NoSuchElementException ex){
                        break;
                    }
            }
        }
    }

    public void findFastest(String vehicle_type){
        Vehicle fastest = new Vehicle("",0, "");

        for (int i = 0; i<list.size(); i++){
            Vehicle actual_list_element = list.get(i);

            if(vehicle_type.equals(actual_list_element.type) && actual_list_element.max_speed > fastest.max_speed)
                fastest = actual_list_element;
            if(vehicle_type.equals("ALL") && actual_list_element.max_speed > fastest.max_speed)
                fastest = actual_list_element;
        }
        log.info("The fastest vehicle from category " + vehicle_type + " is " + fastest.producer + " with maximum speed of " + fastest.max_speed + "hm/h.");
    }

    public static void main(String[] args){
        new Vehicles();
    }
}
