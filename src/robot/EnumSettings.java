package robot;

public enum EnumSettings {
    COORDINATE_X(3100), COORDINATE_Y(965), DELAY(300);

    private int value;

    private EnumSettings(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
