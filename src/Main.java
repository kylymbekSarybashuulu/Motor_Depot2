import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


public class Main {

    public static GsonBuilder GSON_BUILDER = new GsonBuilder();
    public static Gson GSON = GSON_BUILDER.setPrettyPrinting().create();
    public static Path URL_TRUCK = Paths.get("./trucks.json");
    public static Path URL_DRIVER = Paths.get("./driver.json");

    public static void main(String[] args) {

       // Truck[] trucks1 = trucks;
        Truck[] trucks = {
                Truck.createTruck(1, "VOLVO", null, Status.BASE),
                Truck.createTruck(2, "DAF", null, Status.BASE),
                Truck.createTruck(3, "RENO", null, Status.BASE)
        };
      // Truck[] trucks1 = trucks;


        Driver[] drivers = {
                Driver.makeDriver(1, "Petr", null),
                Driver.makeDriver(2, "Askar", null),
                Driver.makeDriver(3, "Uson", null)
        };
        Driver[] drivers1 = drivers;
        Truck[] trucks1 = trucks;

        String jsonTruck = GSON.toJson(trucks);
        //File.writeFile(jsonTruck, URL_TRUCK);
        //File.readFile(URL_TRUCK);
        Truck.infoTruck(URL_TRUCK);

        String jsonDriver = GSON.toJson(drivers);
        //File.writeFile(jsonDriver, URL_DRIVER);
        Driver.aDriver(URL_DRIVER);
       // File.readFile(URL_DRIVER);

        ServisTruck.changeTruck(trucks, drivers);


    }


}