import java.io.File;
import java.util.ArrayList;

/*Напишите программу, ищущую в указанных папках (и всех их подпапках) файлы с указанным расширением, и формирующую вывод результатов поиска в консоль в виде
        c:/dir1/dir2/file1.ext
        c:/dir1/dir2/file2.ext
        и в XML-файл в виде (представлен фрагмент, описывающий один файл)
<file>
<name>file1.ext</name>
<path>c:/dir1/dir2/</path>
<size>1234567</size>
<datetime>23.12.2015 23:56:48</datetime>
</file>
        Пример параметров командной строки при запуске программы:
        C:/SomePath1/ D:/SomePath2 E:/SomePath3/ C:/SomePath4 docx c:/results.xml*/
public class App {
    public static void main(String[] args) {
        Manager m = new Manager(args[]);
        m.parseJava();

    }

}
