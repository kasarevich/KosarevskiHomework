package by.it_academy.task2;

public class Main {
    public static void main(String [] arg){
        Button button = new Button();
        UI ui = new UI();
        button.setUi(ui);// Мы просто скидываем ссылку на мэйн, чтобы баттон мог вызывать методы мэйна

        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){}
        //Эммулируем нажатие на кнопку
        //В реальности этого метода не будет
        button.emmulateclickOnButton();
    }


}
