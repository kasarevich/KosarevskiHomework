package by.it_academy.Task2;

public class Manager {
    ATM atm = new ATM();

    private void check(ATM atm, int sum, boolean operation){
        int buf100 = 0;
        int buf50 = 0;
        int buf20 = 0;
        if(sum % 100 == 0){
            buf100 = sum/100; // начинаем со 100, потому что если здесь в if - true, остальные условия не проверяются
        }
        else if(sum % 50 == 0){
            buf100 = (sum - 50)/100;
            buf50 = 1;                  // Поскольку сумма кратна 50, а при целочисленном делении на 100 мы получили количество сотен, в остаток пошла только одна 50-ка.
        }
        else if (sum % 20 == 0){
            buf100 = sum/100;
            int buffer = sum%100;
            if(buffer%20 == 0) {
                buf20 = buffer/20;
            }else {
                    buf50 = buffer/50;
                    buffer = buffer%50;
                    buf20 = buffer/20;
                  }
            } else
            System.out.println("Неверная сумма!");

        if(operation){
            atm.setHundred(atm.getHundred() + buf100);
            atm.setFifty(atm.getFifty() + buf50);
            atm.setTwenty(atm.getTwenty() + buf20);
        }
        else{
            atm.setHundred(atm.getHundred() - buf100);
            atm.setFifty(atm.getFifty() - buf50);
            atm.setTwenty(atm.getTwenty() - buf20);
        }


    }
}
