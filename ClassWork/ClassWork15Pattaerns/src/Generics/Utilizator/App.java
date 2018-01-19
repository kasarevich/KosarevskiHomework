package Generics.Utilizator;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class App {
    private Student st = new Student();


    private SoftReference<Student> studentSoftReference
            = new SoftReference<Student>(new Student());// делаем "мягкую" ссылку, оборачивая в софт-референс класс


    private WeakReference<Student> studentWeakReference
                = new WeakReference<Student>(st);    // софт реф только при нехватке памяти.
                                                     // weak ref - как только остались только weak ref, джава удалит

    public void main(String[] args) {

        Student student1 = new Student();// не удалится до конца программы,
        // потому что есть сильная ссылка на уровне класса
        // объект удалится только когда на него не останется ссылок

        Student student2 = studentSoftReference.get(); // джава может удалить этот объект, при недостатке памяти

        App app = new App();
    }
}
