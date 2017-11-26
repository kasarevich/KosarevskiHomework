package by.it_academy.Task2;

public class ATM {
    private int twenty;
    private int fifty;
    private int hundred;

    public ATM() {
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

    public boolean add(int sum){
        if(sum % 100 == 0){
            hundred = hundred + sum/100;// начинаем со 100, потому что если здесь в if - true, остальные условия не проверяются
            return true;
        }
            else if(sum % 50 == 0){
             hundred = hundred + sum/100;
             fifty ++; // Поскольку сумма кратна 50, а при целочисленном делении на 100 мы получили количество сотен, в остаток пошла только одна 50-ка.
            return true;
        }
                else if (sum % 20 == 0){
                hundred = hundred + sum/100;
                int buf50 = sum % 100;
                fifty = fifty + buf50/50;
                int buf20 = buf50 % 50;
                twenty = twenty + buf20/20;
                return true;
        }
                        else return false;
    }

    public void withdraw(int sum){
        int counter100 = sum/100;
            int buf50 = sum%100;
            int counter50= buf50/50;
                int buf20 = buf50 % 50;
                int counter20= buf20/20;
                    hundred -= counter100;
                    fifty -= counter50;
                    twenty -= counter20;
        System.out.printf("Вывод денег. Сумма - %dр.\n100р - %dшт.\n50р - %dшт.\n20p - %dшт.", sum, counter100, counter50, counter20);
    }
    public void check(){
        System.out.println("100p - " + hundred + " шт\n50р - " + fifty + " шт\n20р - " + twenty + " шт");
    }
}
