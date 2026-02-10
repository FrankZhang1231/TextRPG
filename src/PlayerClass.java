abstract public class PlayerClass {
    public String name;
    public int health;
    public int attack;

    public PlayerClass(String name) {
        this.name = name;
    }

    public void setHealth(int a) {
        health = a;
    }

    public void setAttack(int a) {
        attack = a;
    }

    abstract void describe();
}
