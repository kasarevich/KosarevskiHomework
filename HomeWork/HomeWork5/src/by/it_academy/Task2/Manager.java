package by.it_academy.Task2;

public class Manager {
    ATM atm = new ATM();

    public boolean add(int sum){
        boolean op = true;      // Флаг операции - добавитиь или снять
        return(operation(atm, sum, op));
    }

    public boolean withdraw(int sum){
        boolean op = false;
        return(operation(atm, sum, op));
    }

    /**
     * Метод для проверки количества купюр
     */
    public  void check(){
        System.out.println("Количество купюр, находящихся в банкомате:");
        System.out.println("100p - " + atm.getHundred() + "\n50p - " + atm.getFifty() + "\n20p - " + atm.getTwenty());
    }

    /**
     * Метод проверяет, на какие купюры разбить (учитывая, что купюр 10р у нас нет, такие случаи не обрабатываем)
     * в зависимости от флага, меняет поля класса атм
     * @param atm - экземпляр класса атм
     * @param sum - сумма, которую будем разбивать на купюры
     * @param op - флаг операции - добавить или отнять
     */

    private boolean operation(ATM atm, int sum, boolean op){
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
            if(buffer%20 == 0) {    // Сначала проверяем, как разьивается на 20, для цивр типа 160 - чтобы не белало 1 100, 1 50, 0 20
                buf20 = buffer/20;  // А 1 по 100 и 3 по 20
            }else {
                    buf50 = buffer/50;
                    buffer = buffer%50;
                    buf20 = buffer/20;
                  }
            } else return false;


        if(op){
            atm.setHundred(atm.getHundred() + buf100);
            atm.setFifty(atm.getFifty() + buf50);
            atm.setTwenty(atm.getTwenty() + buf20);
        }
        else{
            atm.setHundred(atm.getHundred() - buf100);
            atm.setFifty(atm.getFifty() - buf50);
            atm.setTwenty(atm.getTwenty() - buf20);
        }
        return true;

    }
}
