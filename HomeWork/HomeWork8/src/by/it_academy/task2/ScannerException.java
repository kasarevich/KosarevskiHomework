package by.it_academy.task2;

public class ScannerException extends Exception {
    public ScannerException(String message) {
        super(message);
    }
    public String getRussianMessage(){
        return super.getMessage();
    }

}
