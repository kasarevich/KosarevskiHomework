package ReflectionAPI.ATMListener;

public class App {
    public static void main(String[] args){
        getMoney(55, new OnGetMoneyListener() {
            @Override
            public void onMoney(boolean isOk) {
                //вызовется когда банкомат посчитает деньги.
                System.out.println("Все про");
            }
        });
        // Показть прогресс бар, и тд, пока банкомат выдает деньги
    }
    public  static void getMoney(int count, OnGetMoneyListener listener){
        // здесь реализация выдачи денег (расчет купюр и тд)
        //if (allOk){...
        listener.onMoney(true);// та строка заменяет ретурн
        // else{ listener.onMoney(false);

    }
    interface OnGetMoneyListener {
        void onMoney(boolean isOk);

    }
}
