package Generics.task1;

public class MyCollection<T extends Number, R extends String> { //можно исп. любое значение, наследуемое от намбер
                                                // R - by String
    private T value;
    private R valueR;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public R getValueR() {
        return valueR;
    }

    public void setValueR(R valueR) {
        this.valueR = valueR;
    }
}
