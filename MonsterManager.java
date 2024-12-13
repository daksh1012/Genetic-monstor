import java.io.*;
import java.util.ArrayList;

public class MonsterManager {
    private ArrayList<Monster> monsters;

    public MonsterManager() {
        monsters = new ArrayList<>();
    }

    public void addMonster(Monster m) {
        monsters.add(m);
    }

    public void displayMonsters(boolean detailed) {
        for (int i = 0; i < monsters.size(); i++) {
            System.out.println((i + 1) + ". " + monsters.get(i).toString());
        }
    }

    public Monster breedMonsters(int index1, int index2) {
        Monster parent1 = monsters.get(index1);
        Monster parent2 = monsters.get(index2);

        String name = parent1.getName() + "-" + parent2.getName();
        String color = parent1.getColor() + "-" + parent2.getColor();
        int strength = (parent1.getStrength() + parent2.getStrength()) / 2;
        int speed = (parent1.getSpeed() + parent2.getSpeed()) / 2;

        Monster offspring = new FlyingMonster(name, color, strength, speed, 10); // Example
        monsters.add(offspring);

        System.out.println("New monster created: " + offspring.toString());
        return offspring;
    }

    public void saveGame(String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(monsters);
        }
    }

    public void loadGame(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            monsters = (ArrayList<Monster>) ois.readObject();
        }
    }
}
