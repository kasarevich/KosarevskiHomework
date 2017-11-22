package by.it_academy.task1;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;
/*
1) Вам необходимо создать программу с 1-м собственным объектом (классом):
        Пациент (то что мы сделали на занятии, но на примере Студента).
        В объекте вам нужно описать перемен1ные характерные для данной сущности,
        например у пациента могут быть переменные ФИО, возраст, диагноз и тд.
        В классе должны быть обязательно переменные типов int, String, boolean.
        Далее в основном классе(файле) вы должны создать минимум 3 объекта Пациента
         и заполнить их данными из консоли (ввод данных сделать в красивом виде).
        После ввода данных вы должны вывести данные на экран в следующем виде:
        Пациент “ФИО” - Возраст = “возраст”
        Далее вы должны дать пользователю возможность найти пациента по фамилии и
        по возрасту. Тоесть в консоли должно появится предложение найти пользователя по
         ФИО или по возрасту, далее пользователь вводит нужное имя, далее программа
         отображает всех пациентов с данным именем (тоже самое сделать для возраста).
*/


    public class Task {
        static public  void main(String []arg){

            ArrayList<Patient> patients = new ArrayList();          // Создаем не массив а эррэйлист для гибкости - конечное число пациентов неизвестно
            Scanner in = new Scanner(System.in);
            byte n = 0;         // Условие продолжения работы цикла(пока 0, меню зациклено до тех пор, пока пользователь не введет 1)
            do {
                System.out.println("Введите 1 для добавления пациента\nВведите 2 для просмотра всех пациентов\nВведите 3 для поиска пациента");
                int task = in.nextInt();

                switch (task){

                    case 1:
                        addpatient(patients);
                    if (patients.size() > 0)
                        System.out.println("Пациент успешно добавлен!");
                    break;

                    case 2:
                        for (int i = 0; i< patients.size(); i++){
                            patients.get(i).printPatient();    //Вывод всех пациентов на экран
                        }
                    break;

                    case 3:
                        System.out.println("Введите имя, лмбо возраст пациента, которого Вы ищете:");
                        String str = in.next();
                        int counter = 0;
                        for (int i = 0; i < patients.size(); i++){
                            if (searchPatient(str, patients.get(i))){
                                patients.get(i).printPatient();
                                counter++;          // счетчик, чтобы вывести на экран сообщение о том, что ничего не найдено, если он == 0
                            }
                        }
                        if (counter == 0)
                            System.out.println("Совпадений с " + str + " не найдено");

                        default:
                            break;
                }
                System.out.println("Нажмите 0 чтобы продолжить и 1 чтобы выйти:");  // на этом месте снова выплывает главная менюшка с предложением ввести,
                                                                                    // просмотреть или найти, если пользователь введет 0
                if (in.nextByte() != 0)
                n=1;
            } while (n==0);

        }

        /**
         *
         * @param string - текст, который мы ищем (Имя, либо возраст)
         * @param patient - экземпляр класса Patient, в котором мы проводим проверку на совпадение
         * @return true, если нашлось совпадение либо по имени, либо по возрасту, false - если совпадений нет
         */

        public static boolean searchPatient(String string, Patient patient){

            Pattern p = Pattern.compile(string);
            Matcher name = p.matcher(patient.getFio());
            Matcher age = p.matcher(String.valueOf(patient.getAge()));

            if(name.find() || age.find()){
                return true;
            }
                else return false;
        }

        /**
         * В данном методе вводим данные о пациенте, проверяем на корректность данные и, если все корректно,
         * создаем экземпляр класса Patient. Затем записываем его в ArrayList пациентов
         * @param p - Arraylist пациентов для пополнения его новыми
         */

        public static void addpatient(ArrayList<Patient> p){
            Scanner in = new Scanner(System.in);
            System.out.println("Введите имя:");
            String name = in.next();
            System.out.println("Введите диагноз:");
            String dia = in.next();
            System.out.println("Введите возраст:");
            int age = in.nextInt();
            System.out.println("Введите номер палаты:");
            int room = in.nextInt();
            System.out.println("Введите 1 если пациент на лечении, или любую клавишу, если пациент выписан:");
            boolean status = false;         //По условию должна быть одна булевская переменная, но мне фантазии не хватило, как ее задействовать, поэтому вот так
            if (in.nextInt() == 1)
                status = true;
            try {
                Patient patient = new Patient(name, dia, age, room, status);
                p.add(patient);             //добавление в эррэйлист
                }
                catch (Exception ex) {
                System.out.println(ex.getMessage());
                }
        }
}


