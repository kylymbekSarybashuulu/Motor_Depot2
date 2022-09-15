import java.io.Reader;
import java.nio.file.Path;

public class Truck {
    private int id;
    private String name;
    private Driver driver;
    private Status status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public static Truck createTruck(int id, String name, Driver driver, Status status) {
        Truck truck1 = new Truck();
        truck1.id = id;
        truck1.name = name;
        truck1.driver = driver;
        truck1.status = status;
        return truck1;
    }

    public static void infoTruck(Path path) {
        Truck[] trucks = Main.GSON.fromJson(File.readFile(path), Truck[].class);
        //System.out.println(trucks);
        System.out.println("    \n  INFO about TRUCKS");
        System.out.println(" ---------------------------------");
        System.out.printf("%-1s%-10s%-11s%-10s%n", "#", " |TRUCK", " | DRIVER", " | STATE");
        System.out.println("----------------------------------");

        for (Truck truck : trucks) {
            System.out.printf("%-1s |", truck.getId());
            System.out.printf("%-9s|", truck.getName());
            System.out.printf("%-10s|", truck.getDriver());
            System.out.printf("%-10s", truck.getStatus());
            System.out.println("\n----------------------------------");
        }
    }

    @Override
    public String toString() {
        return "" +
                "" + id +
                "   " + name +
                "    " + driver +
                "   " + status + " ";
    }
}
