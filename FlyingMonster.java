public class FlyingMonster extends Monster {
    private int wingSpan;

    public FlyingMonster(String name, String color, int strength, int speed, int wingSpan) {
        super(name, color, strength, speed);
        this.wingSpan = wingSpan;
    }

    @Override
    public void performSpecialAbility() {
        System.out.println(getName() + " is flying with a wingspan of " + wingSpan + " meters!");
    }
}

public class AquaticMonster extends Monster {
    private int swimSpeed;

    public AquaticMonster(String name, String color, int strength, int speed, int swimSpeed) {
        super(name, color, strength, speed);
        this.swimSpeed = swimSpeed;
    }

    @Override
    public void performSpecialAbility() {
        System.out.println(getName() + " is swimming at " + swimSpeed + " km/h!");
    }
}

