package by.it_academy.task2;

public class DevideByZeroException extends Exception {
    String russianMessage;
    public DevideByZeroException (String message) {
        this.russianMessage = message;
    }

    public String getRussianMessage() {
        return russianMessage;
    }
}
