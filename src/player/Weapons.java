package player;

public class Weapons {

    protected String name;
    protected int attack;
    protected String type;

    public Weapons(String name, String type, int attack) {
        this.name = name;
        this.attack = attack;
        this.type = type;
    }

    public String getName() { return this.name; }
    public int getAttack() { return this.attack; }
    public String getType() { return this.type; }
}
