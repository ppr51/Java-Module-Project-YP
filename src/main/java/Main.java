import java.util.Scanner;// dev branch for Y.Practicum
public class Main {

    public static void main(String[] args) {
        System.out.println("На скольких человек необходимо разделить счёт?");
        Scanner scan = new Scanner(System.in);
        int AmountOfPeople = scan.nextInt();
        String AllNames = "";
        double AllPrices = 0;

        while (AmountOfPeople == 1 || AmountOfPeople < 1) {
            System.out.println("Введеное значение некоректно.");
            AmountOfPeople = scan.nextInt();
        }
        while (true) {
            System.out.println("Напишите название товара:");
            String name = scan.next();
            AllNames += name + " ";

            System.out.println("Напишите цену товара:");
            double price = scan.nextDouble();
            AllPrices += price;
            System.out.println("Хотите добавить ещё товар?");
            String answer = scan.next();
            if (answer.equals("Завершить")) {
                break;
            }
        }
        System.out.println("Добавленные товары: " + AllNames);
        String prices = String.format("%.2f",AllPrices);
        System.out.println("Итоговый счёт: " + prices);
        double total = AllPrices / AmountOfPeople;
        String result = String.format("%.2f",total);
        System.out.println("Итоговая сумма с каждого гостя: " + result + " " + Formarter(total));
    }
    public static String Formarter(double x) {

        if(x % 10 == 1) {
            return "рубль";
        }
        else if (x % 10 == 2 || x % 10 == 3 || x % 10 == 4) {
            return "рубля";
        } else {
            return "рублей";
        }

    }
}
