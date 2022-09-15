import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class File {
    public static void writeFile(String object, Path path){
        Path write = Paths.get(String.valueOf(path));
        try {
            Files.writeString(write, object, StandardOpenOption.CREATE, StandardOpenOption.WRITE);

        } catch (Exception e) {
            e.getMessage();
        }

    }
    public static String readFile(Path path) {
        String json = " ";
        try {
            FileReader reader = new FileReader(String.valueOf(Main.URL_TRUCK));
            int a;
            while ((a = reader.read()) != -1) {
                json += (char) a;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return json;
    }
    public static String readFile2(Path path) {
        String json = " ";
        try {
            FileReader reader = new FileReader(String.valueOf(Main.URL_DRIVER));
            int a;
            while ((a = reader.read()) != -1) {
                json += (char) a;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return json;
    }
}
