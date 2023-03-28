// dev branch for Y.Practicum
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // ваш код начнется здесь
        // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости
        int countGuests = 0;
        System.out.println("Введите количество человек, " +
                "на которых нужно разделить счёт");
        do {
            while(!scanner.hasNextInt()){
                System.out.println("Ошибка. Вы ввели не целое число гостей, попробуйте ещё раз");
                scanner.next();
            }
            countGuests = scanner.nextInt();
            if (countGuests > 1) {
                break;
            }
            else if(countGuests == 1) {
                System.out.println("Ошибка. Вы ввели только одного гостя, а программа " +
                        "рассчитана на большее число гостей, попробуйте ещё раз");
            }
            else {
                System.out.println("Ошибка. Вы ввели некорректное количество гостей, " +
                        "попробуйте ещё раз");
            }
        } while(true);

        BillCalculator billCalc = new BillCalculator();

        while(true) {
            System.out.println("Введите название товара");
            String productName = scanner.next();
            System.out.println("Введите стоимость товара в формате \"рубли,копейки\"");
            double productPrice = 0;
            do {
                while(!scanner.hasNextDouble()) {
                    System.out.println("Ошибка. Вы ввели некорректную стоимость, попробуйте ещё раз");
                    scanner.next();
                }
                productPrice = scanner.nextDouble();
                if(productPrice<0)
                {
                    System.out.println("Ошибка. Вы ввели отрицательную стоимость, попробуйте ещё раз");
                }
                else {
                    break;
                }
            } while(true);

            billCalc.addProduct(productName, productPrice);

            System.out.println("Если Вы хотите добавить ещё один товар, то введите любой символ. " +
                    "А если хотите завершить ввод товаров, то введите команду \"Завершить\" в " +
                    "любом регистре");
            String commandName = scanner.next();
            if(commandName.equalsIgnoreCase("Завершить")) {
                break;
            }
        }
        System.out.println("Добавленные товары:");
        billCalc.showProductsList();

        System.out.println("Общая сумма чека равна " +
                PriceFormatter.getFormattedPriceWithRubStringByDouble(billCalc.sumAllProducts));
        System.out.println(String.format("Количество гостей равно %d",countGuests));
        double resOfSplittingBill = billCalc.splitAllSumBetweenGuests(countGuests);
        System.out.println("Сумма,которую должен заплатить каждый гость равна " +
                PriceFormatter.getFormattedPriceWithRubStringByDouble(resOfSplittingBill));

        scanner.close();
    }
}
