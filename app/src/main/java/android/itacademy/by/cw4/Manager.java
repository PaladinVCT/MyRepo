package android.itacademy.by.cw4;

public class Manager {
    private static Manager instance = new Manager();

    public static Manager getInstance() {
        return instance;
    }

    private cw4Activity cw4;

    private Manager() {

    }

    public void setCw4(cw4Activity cw4) {
        this.cw4 = cw4;
    }
}
