package by.it_academy.task2;

public class Button {
    private  UI ui;
    // Записываем в Button ссылку на Main, чтобы баттон мог вызывать методы у мэйн,
    // поскольку из нестатик мы не можем вызвать статик
    public void setUi(UI ui){
        this.ui = ui;
    }
    //имулируем нажатие на кнопку. Это чисто тестовый метод
    public void emmulateclickOnButton(){
        if(ui != null) ui.onClick();
    }






}
