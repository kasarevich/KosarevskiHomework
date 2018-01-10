package task3;

public class ParsingThread extends Thread {

    private DownloadThread downloadThread;

    public void setDownloadThread(DownloadThread downloadThread) {
        this.downloadThread = downloadThread;
    }

    @Override
    public void run() {
        System.out.println("wait parsing...");
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("json parsing...");
        // parse
        // далее будим даунлоадер
        System.out.println("ping download from parsing");
        downloadThread.notify();// синхронизировать в блок на одном объекте залочить (на доунлоадере)


        System.out.println("wait parsing");
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //нас разбудили

        System.out.println("parsing xml");
        // parseXml
        System.out.println("end parsing");
        downloadThread.notify();// будим даунлоадер, и в нем уже сообщаем о завершении программы




        // Разобраться, почему notify() и  wait(); Находятся в классе Обжект, а не треад!!!




    }
}
