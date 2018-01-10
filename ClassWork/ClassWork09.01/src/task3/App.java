package task3;


public class App {

        public static void main(String[] args) {

            ParsingThread parsingThread = new ParsingThread();
            DownloadThread downloadThread = new DownloadThread();

            parsingThread.setDownloadThread(downloadThread);
            downloadThread.setParsingThread(parsingThread);

            parsingThread.start();
            downloadThread.start();




    }
}
