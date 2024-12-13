public class MountainMonster extends Monster {
    private int climbingSkill; // Represents the monster's ability to climb rugged terrain

    public MountainMonster(String name, String color, int strength, int speed, int climbingSkill) {
        super(name, color, strength, speed);
        this.climbingSkill = climbingSkill;
    }

    @Override
    public void performSpecialAbility() {
        System.out.println(getName() + " is climbing with a skill level of " + climbingSkill + "!");
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", ClimbingSkill: %d", climbingSkill);
    }

    @Override
    public void saveToFile(String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this);
        }
    }
}
