import java.util.*;

public class Toy implements Actions {

    public int id;

    private static int counter = 1;

    private String name;

    private float chance;

    public Toy(String name, float chance) {
        this.id = counter++;
        this.name = name;
        this.chance = chance;
    }

    public float getChance() {
        return this.chance;
    }

    public String getName() {
        return this.name;
    }

    public float changeChance(float percent) {
        return this.chance += percent;
    }

}
