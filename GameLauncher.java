import java.util.Scanner;

public class GameLauncher {
    public static void main(String[] args) {
        MonsterManager manager = new MonsterManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("1. Create Monster\n2. View Monsters\n3. Breed Monsters\n4. Save Game\n5. Load Game\n6. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer

            switch (choice) {
                case 1:
                    System.out.println("Enter name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter color:");
                    String color = scanner.nextLine();
                    System.out.println("Enter strength:");
                    int strength = scanner.nextInt();
                    System.out.println("Enter speed:");
                    int speed = scanner.nextInt();

                    Monster m = new FlyingMonster(name, color, strength, speed, 10); // Example
                    manager.addMonster(m);
                    break;

                case 2:
                    manager.displayMonsters(true);
                    break;

                case 3:
                    System.out.println("Select two monsters to breed:");
                    manager.displayMonsters(false);
                    int index1 = scanner.nextInt() - 1;
                    int index2 = scanner.nextInt() - 1;
                    manager.breedMonsters(index1, index2);
                    break;

                case 4:
                    try {
                        manager.saveGame("game_state.ser");
                        System.out.println("Game saved successfully.");
                    } catch (IOException e) {
                        System.err.println("Failed to save game.");
                    }
                    break;

                case 5:
                    try {
                        manager.loadGame("game_state.ser");
                        System.out.println("Game loaded successfully.");
                    } catch (Exception e) {
                        System.err.println("Failed to load game.");
                    }
                    break;

                case 6:
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}
