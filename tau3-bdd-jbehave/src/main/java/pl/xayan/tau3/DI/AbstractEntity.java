package pl.xayan.tau3.DI;

public class AbstractEntity implements EntityInterface {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
