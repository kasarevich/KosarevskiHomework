package by.it_academy.Task2;

public class ATM {
    private int twenty;
    private int fifty;
    private int hundred;

    public ATM() {              // по умолчанию деньги у нас в банкомате есть
        this.twenty = 300;
        this.fifty = 200;
        this.hundred = 100;
    }

    public ATM(int twenty, int fifty, int hundred) {
        this.twenty = twenty;
        this.fifty = fifty;
        this.hundred = hundred;
    }

    public int getTwenty() {
        return twenty;
    }

    public void setTwenty(int twenty) {
        this.twenty = twenty;
    }

    public int getFifty() {
        return fifty;
    }

    public void setFifty(int fifty) {
        this.fifty = fifty;
    }

    public int getHundred() {
        return hundred;
    }

    public void setHundred(int hundred) {
        this.hundred = hundred;
    }

}
