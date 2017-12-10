package by.it_academy.task2;

import java.io.IOException;
import java.util.InputMismatchException;

public class ScannerException extends InputMismatchException {
    String russianMessage;
    public ScannerException(String message) {
        this.russianMessage = message;
    }

    public String getRussianMessage() {
        return russianMessage;
    }
}
