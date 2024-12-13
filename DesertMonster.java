public class DesertMonster extends Monster {
    private int heatResistance; 

    public DesertMonster(String name, String color, int strength, int speed, int heatResistance) {
        super(name, color, strength, speed);
        this.heatResistance = heatResistance;
    }

    @Override
    public void performSpecialAbility() {
        System.out.println(getName() + " is withstanding extreme heat with a resistance level of " + heatResistance + "!");
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", HeatResistance: %d", heatResistance);
    }

    @Override
    public void saveToFile(String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this);
        }
    }
}
