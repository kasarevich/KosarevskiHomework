package by.it_academy.Task2;

public class Manager {
    ATM atm = new ATM();

    public boolean add(int sum){
        if(sum % 100 == 0){
           atm.setHundred(atm.getHundred()+sum/10); // начинаем со 100, потому что если здесь в if - true, остальные условия не проверяются
            return true;
        }
        else if(sum % 50 == 0){
            atm.setHundred(atm.getHundred()+sum/100);
            atm.setFifty(atm.getFifty()+1);  // Поскольку сумма кратна 50, а при целочисленном делении на 100 мы получили количество сотен, в остаток пошла только одна 50-ка.
            return true;
        }
        else if (sum % 20 == 0){
            atm.setHundred(atm.getHundred()+sum/100);
            int buf50 = sum % 100;
            if (buf50%20 == 0)
            {atm.setTwenty(atm.getTwenty()+ buf50/20);} // Проверка для сумм типа 160 - чтобы не зачисляло 1 пятдесят, а сразу проверила делится ли без остатка
            else {                                           // на 20. в этом случае операторы работы с 50-рублевыми пропускаются, а 20 зачисляются
                atm.setFifty(atm.getFifty()+ buf50/50);
            int buf20 = buf50 % 50;
                atm.setTwenty(atm.getTwenty()+ buf20/20);
            return true;}
        }
        else return false;
        return false;
    }
}
