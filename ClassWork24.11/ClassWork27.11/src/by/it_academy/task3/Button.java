package by.it_academy.task3;

public class Button{
    private ButtonClick ui;

    public void setUi(ButtonClick ui)
    {
        this.ui = ui;
    }
    //имулируем нажатие на кнопку. Это чисто тестовый метод
    public void emmulateclickOnButton(){
        if(ui != null) ui.onClick();
    }






}
