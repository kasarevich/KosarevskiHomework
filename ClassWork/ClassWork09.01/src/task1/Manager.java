package task1;

public class Manager {
    private String a;
    private static Manager instance = new Manager(); // можно без new Man(); тогда в гетинст надо будет создавать.
    private Manager(){  }  //конструктор приватный      // но при многопоточности его надо делать синхронайзд, что ёмко
                                                        // однако если конструктор не пустой, без этого не обойтись, тогда данные подаются
    public static Manager getInstance(){                // в getInstance(дфнные). и при инициализации объекта, в конструктор подается
        if (instance == null){
            instance = new Manager();
        }
        return instance;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }
}
