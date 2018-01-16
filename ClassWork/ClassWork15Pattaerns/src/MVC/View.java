package MVC;


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
    }

    public void showMessage(String message){
        System.out.println("Error: " + message);
    }
}
