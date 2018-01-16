package MVC;

import java.util.ArrayList;

public class Controller {
    private ArrayList <Model> data;
    private View view;

    public Controller(View view){
        this.view = view;
    }

    public String getHello(){
        return  "Hello";
    }
    public String getDataSortByName(){
        return data.get(5).getName();
    }
    public int getNumber(){
        view.showMessage("afaefaf");
        return 5;
    }
}
