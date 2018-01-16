package CleanArchitecture.presentation;

import java.util.ArrayList;

public class Controller {
    private View view;

    public Controller(View view){
        this.view = view;
    }

    public void getMoney(){
        // тут стучимся в UseCase, а затем показываем данные на экране



        // view.showGetMoneyReыult
    }
}
