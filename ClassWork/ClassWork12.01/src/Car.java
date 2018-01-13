public class Car {
    private  int id;
    public String name;

    interface Listener {
        void onClick();
    }

     //class Windows{// Внутренний класс без статик, вложенный статик
    static class Windows{
        private int idWindows;
        private String model;

        public void test(){ // теперь для создания класса нет необходимости содавать новый класс кар
            //name = "afeefr"; // они не зависят друг от друга, поэтому вызывать не static поля Car
            //id = 5;
        }
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
