public class BillCalculator {
    double sumAllProducts = 0;
    String allProductNames = new String();

    public void addProduct(String name,double price){
        if(!allProductNames.isEmpty())
            allProductNames += "\n";
        allProductNames += name;
        sumAllProducts += price;

        System.out.println("Товар \""+name+"\" успешно добавлен!");
    }

    public void showProductsList(){
        System.out.println(allProductNames);
    }

    public double splitAllSumBetweenGuests(int countGuests){
        if(countGuests >= 1)
            return sumAllProducts/((double)countGuests);
        else {
            System.out.println("Ошибка! Неверное число гостей!");
            return 0;
        }
    }

}
