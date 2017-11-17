package by.it_academy.task4;

public class Task4 {

    public static void main(String[] args) {
        int sum = 13;
        int padej = sum % 10;
        if (sum >= 11 && sum <= 19) {
            System.out.println("Сумма равна " + sum + " рублей.");
        } else {
            switch(padej) {
                case 0:
                    System.out.println("Сумма равна " + sum + " рублей.");
                    break;
                case 1:
                    System.out.println("Сумма равна " + sum + " рубль.");
                    break;
                case 2:
                    System.out.println("Сумма равна " + sum + " рубля.");
                    break;
                case 3:
                    System.out.println("Сумма равна " + sum + " рубля.");
                    break;
                case 4:
                    System.out.println("Сумма равна " + sum + " рубля.");
                    break;
                case 5:
                    System.out.println("Сумма равна " + sum + " рублей.");
                    break;
                case 6:
                    System.out.println("Сумма равна " + sum + " рублей.");
                    break;
                case 7:
                    System.out.println("Сумма равна " + sum + " рублей.");
                    break;
                case 8:
                    System.out.println("Сумма равна " + sum + " рублей.");
                    break;
                case 9:
                    System.out.println("Сумма равна " + sum + " рублей.");
                    break;
                default:
                    System.out.println("Error");
            }
        }

    }
}