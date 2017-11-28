package by.it_academy.task1.atm;

import by.it_academy.task1.interfaces.AtmName;
import by.it_academy.task1.interfaces.AtmProducer;
import by.it_academy.task1.interfaces.atmWithCheck;

public class ConcreteATM extends ATM implements atmWithCheck, AtmName, AtmProducer {
    private int twenty;
    private int fifty;
    private int hundred;

    public ConcreteATM(String name, String producer) {
        super(name, producer);
        this.twenty = 300;
        this.fifty = 200;
        this.hundred = 100;
    }


    public boolean add(int sum){
        boolean op = true;      // Флаг операции - добавитиь или снять
        return(change(sum, op));
    }

    public boolean take(int sum){
        boolean op = false;
        return(change(sum, op));
    }

    public boolean change(int sum, boolean op){
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
            hundred += buf100;
            fifty += buf50;
            twenty += buf20;
        }
        else{
            hundred -= buf100;
            fifty -= buf50;
            twenty -= buf20;
        }
        return true;
    }

    @Override
    public  void check(){
        System.out.println("Количество купюр, находящихся в банкомате:");
        System.out.println("100p - " + hundred + "\n50p - " + fifty + "\n20p - " + twenty);
    }

    @Override
    public void toPayMobileServices(int sum){
        System.out.println("Баланс успешно пополнен! Сумма : " + sum);
    }

    @Override
    public void toPayFines(int sum){
        System.out.println("Штраф успешно погашен! Сумма : " + sum);
    }

    public String nameOfAtm(){
        return super.getName();
    }

    public String producer(){
        return super.getProducer();
    }
}
