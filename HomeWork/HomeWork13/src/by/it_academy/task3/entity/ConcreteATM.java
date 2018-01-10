package by.it_academy.task3.entity;

import by.it_academy.task3.interfaces.AtmName;
import by.it_academy.task3.interfaces.AtmProducer;
import by.it_academy.task3.interfaces.AtmWithCheck;

/*
        * Класс описывает конкретный банкома.
        * Клас наследуется от абстрактного АТМ, а значит обязан переопределить и реализовать все методы суперкласса
        * и подключенных к нему интерфейсов, а так же собственные интерфейсы.
        * Поля - количество денег, находящихся в банкомате, покупюрно.
        */
public class ConcreteATM extends ATM implements AtmWithCheck, AtmName, AtmProducer {
    private int twenty;
    private int fifty;
    private int hundred;

    public ConcreteATM(String name, String producer) {  // Конструктор по умолчанию не создаю. Предполагается, что в банкомате всегда должна находится такая сумма
        super(name, producer);
        this.twenty = 300;
        this.fifty = 200;
        this.hundred = 100;
    }

    /**
     * Метод унаследован от суперкласса и реализует интерфейc AtmWithAdd, метод которого должен добавлять деньги на счет
     * @param sum - сумма, которую пользователь вставляет в купюроприемник
     * @return true - успешно пополнен, false - ошибка, неверная сумма
     */
    public boolean add(int sum){
        boolean op = true;      // Флаг операции - добавитиь или снять
        return(change(sum, op)); // Метод change разбивает суммы покупюрно, стараясь выдать наиболее крупными купюрами и меняет поля atm - добавляя к-во купюр.
    }                            // Возвращает true, если успешно, false - некорректная сумма

    /**
     * Аналогично методу add, унаследован от AtmWithDraw
     * @param sum
     * @return
     */
    public boolean take(int sum){
        boolean op = false;   //Принимая флаг фолс, метод ченж будет вычитать сумму из имеющейся в банкомате. остальное аналогично add
        return(change(sum, op));
    }

    /**
     *
     * @param sum - Сумма, которую необходимо разбить покупюрно
     * @param op - флаг операции, для того, чтобы знать, отнимать или прибавлять
     * @return true - операция прошла успешно, false - некорректная сумма
     */
    public boolean change(int sum, boolean op){
        int buf100 = 0;
        int buf50 = 0;
        int buf20 = 0;
        if(sum % 100 == 0){
            buf100 = sum/100;   // начинаем со 100, потому что если здесь в if - true, остальные условия не проверяются и число кратно 100. просто пополняются 100
        }
        else if(sum % 50 == 0){
            buf100 = (sum - 50)/100;
            buf50 = 1;                  // Поскольку сумма кратна 50, а при целочисленном делении на 100 мы получили количество сотен, в остаток пошла только одна 50-ка.
        }
        else if (sum % 20 == 0){
            buf100 = sum/100;
            int buffer = sum%100;
            if(buffer%20 == 0) {    // Сначала проверяем, как разбивается на 20, для цивр типа 160 - чтобы не белало 1 100, 1 50, 0 20
                buf20 = buffer/20;  // А 1 по 100 и 3 по 20
            }else {
                buf50 = buffer/50;
                buffer = buffer%50;
                buf20 = buffer/20;
            }
        } else return false;



        if(op){                     // меняем поля, в зависимости от того, какая операция.
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

    /**
     * Метод реализует унаследованный от суперкласса интерфейс для проверки денег, находящихся в банкомате покупюрно
     */
    public  void check(){
        System.out.println("Количество купюр, находящихся в банкомате:");
        System.out.println("100p - " + hundred + "\n50p - " + fifty + "\n20p - " + twenty);
    }

    /**
     * Метод реализует метод родительского для оплаты моб. телефона
     * @param sum - сумма, на которую пополняем
     */
    public void toPayMobileServices(int sum){
        System.out.println("Баланс успешно пополнен! Сумма : " + sum);
    }
    /**
     * Метод реализует метод родительского для погашения штрафа. телефона
     * @param sum - сумма, на которую пополняем
     */
    public void toPayFines(int sum){
        System.out.println("Штраф успешно погашен! Сумма : " + sum);
    }

    /**
     * Реализация собственного интерфейса по возврату имени банкомата
     * @return имя банкомата
     */
    public String nameOfAtm(){
        return super.getName();
    }

    /**
     * Реализация собственного интерфейса по возврату названия производителя
     * @return название производителя
     */
    public String producer(){
        return super.getProducer();
    }
}
