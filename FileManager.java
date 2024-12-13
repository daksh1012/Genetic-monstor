import java.io.*;
import java.util.ArrayList;

public class FileManager {
    public static void saveMonsters(ArrayList<Monster> monsters, String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Monster monster : monsters) {
                writer.write(monster.toString());
                writer.newLine();
            }
        }
    }

    public static ArrayList<Monster> loadMonsters(String filename) throws IOException {
        ArrayList<Monster> monsters = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Parse the line and recreate monsters as needed
            }
        }
        return monsters;
    }
}
