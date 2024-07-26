package Enum;

public enum SecondsOfSleep {
    // could be replaced with protected static constants in BasePage
    ONE_SECOND(1000),
    TWO_SECONDS(2000),
    THREE_SECONDS(3000);

    private final int milliseconds;

    SecondsOfSleep(int milliseconds) {
        this.milliseconds = milliseconds;
    }

    public int getMilliseconds() {
        return milliseconds;
    }
}
