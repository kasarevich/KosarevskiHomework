package by.it_academy;


import java.util.Iterator;
import java.util.function.Consumer;

public class App {
    public static void main(String[] args) {

        MyCollection<String, String> myCollection = new MyCollection();
        //  for(String staff : myCollection) - сделать с помощью паттерна итератор
        // имплементим класс Iterator

    }
}


class MyCollectionIterator implements Iterator{
    private int index = -1;
    private MyCollection mc;
    @Override
    public void remove() {

    }

    @Override
    public void forEachRemaining(Consumer action) {

    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }
}
