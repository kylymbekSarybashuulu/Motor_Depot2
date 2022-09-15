import jdk.swing.interop.SwingInterOpUtils;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ServisTruck {

    static Scanner scanner = new Scanner(System.in);

    public static void changeTruck(Truck[] trucks, Driver[] drivers) {
        while (true) {
            System.out.println(" Select the Truck ");
            int trackId = scanner.nextInt();
            if (trackId == 0) {
                break;
            }
            Truck truckGet = getTruckById(trucks,trackId);
            System.out.println(truckGet);
            try {
                System.out.println("Choose the  action  what do you want1 2 3 0");
                int action = scanner.nextInt();
                if (action == 0) {
                    break;
                } else if (action == 1) {
                    changeDriver(truckGet, drivers);
                    System.out.println("Change the driver");
                } else if (action == 2) {
                    startDriving(truckGet);
                    System.out.println("Start Driving");
                } else if (action == 3) {
                    startRepair(truckGet);
                    System.out.println("Go to Repair");
                } else {
                    System.out.println("нет действий");
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private static void startDriving(Truck truck) {
        if (truck.getStatus().equals(Status.ROUTE)){
            System.out.println("Start is alredy on ROUTE");
        } else if (truck.getDriver() != null) {
            System.out.println("Sorry no free Drivers");
        }else {
            truck.setStatus(Status.ROUTE);
            System.out.println("Truck is succeessfully on ROUTE");
        }
    }
    private static void startRepair(Truck truck) {
        if (truck.getStatus().equals(Status.REPAIR)){
            System.out.println("Truck is already on REPAIR");
        }else {
            truck.setStatus(Status.REPAIR);
            System.out.println("Truck is on REPAIR");
        }
    }
    private static void changeDriver(Truck truckGet, Driver[] drivers) {
        Driver driver = getFreeDriver(drivers);
        if (truckGet.getStatus().equals(Status.REPAIR)) {
            System.out.println("Truck is on , you can't change driver");
        } else if (truckGet.getDriver() != null) {
            System.out.println("Truck is on  REPAIR you can't change the driver");
        } else {
            truckGet.setDriver(driver);
            System.out.println(truckGet);
        }
    }
    private static Driver getFreeDriver(Driver[] drivers) {
        return Arrays.stream(drivers)
                .filter(d -> d.getTruck() == null)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Sorry no free drivers"));
    }
    private static Truck getTruckById( Truck[] trucks,int trackId) {
          return Arrays.stream(trucks)
                .filter(f -> f.getId() == trackId)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Truck is not found"));
    }


}
