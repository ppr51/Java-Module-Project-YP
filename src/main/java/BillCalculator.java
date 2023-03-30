public class BillCalculator {
    double sumAllProducts = 0;
    StringBuilder allProductNames = new StringBuilder();

    public void addProduct(String name, double price) {
        if (0 < allProductNames.length())
            allProductNames.append("\n");
        allProductNames.append(name);
        sumAllProducts += price;

        System.out.println("Товар \"" + name + "\" успешно добавлен!");
    }

    public void showProductsList() {
        System.out.println(allProductNames.toString());
    }

    public double splitAllSumBetweenGuests(int countGuests) {
        if (countGuests >= 1)
            return sumAllProducts / ((double) countGuests);
        else {
            System.out.println("Ошибка! Неверное число гостей!");
            return 0;
        }
    }

}
