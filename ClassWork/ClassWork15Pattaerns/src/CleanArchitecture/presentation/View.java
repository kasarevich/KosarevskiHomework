package CleanArchitecture.presentation;


public class View {

    private Controller controller;
    public View() {
        controller = new Controller(this);
    }

    public static void main(String[] args) {
        View view = new View();
        view.startUi();


    }

    private void startUi(){
        System.out.println("What do you want?");
        // Например, хочет снять деньги
        controller.getMoney();
    }
    // этот метод будет вызывать контроллер, чтобы показать
    // пользователю ответ на запрос о снятии денег
    public void showGetMoneyResult(boolean ok){
        if(ok){
            System.out.println("The money was snyaty, Igor");
        }else System.out.println("Error");
    }

    public void showMessage(String message){
        System.out.println("Error: " + message);
    }
}
