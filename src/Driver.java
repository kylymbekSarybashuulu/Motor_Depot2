import java.io.Reader;
import java.nio.file.Path;

public class Driver {
    private int id;
    private String name;
    private Truck truck;

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

    public Truck getTruck() {
        return truck;
    }

    public void setTruck(Truck truck) {
        this.truck = truck;
    }

    public static Driver makeDriver(int id, String name,Truck truck){
        Driver driver = new Driver();
        driver.id = id;
        driver.name = name;
        driver.truck = truck;
        return driver;


    }

    public static void aDriver(Path path){

        Driver[] drivers = Main.GSON.fromJson(File.readFile2(path), Driver[].class);

        System.out.println("    \n     INFO ABOUT DRIVERS");
        System.out.println(" ---------------------------------");
        System.out.println("#   |NAME     |TRUCK ");

        System.out.println("----------------------------------");

        for (Driver d : drivers) {
           System.out.println(d);
           System.out.println("\n----------------------------------");
        }




    }
    @Override
    public String toString() {
        return "" +
                "  " + id +
                " " + name  +
                "       " + truck ;
    }
}
