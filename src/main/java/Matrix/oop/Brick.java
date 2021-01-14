package Matrix.oop;

/**
 * Brick contains just value
 */
public class Brick {

    private int value;

    public Brick(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Brick setValue(int value) {
        this.value = value;
        return this;
    }
}
