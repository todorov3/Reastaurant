import restaurant.Menu;
import restaurant.Restaurant;

public class Main {

  public static void main(String[] args) {
    Menu menu = new Menu();
    System.out.println(menu);
    Restaurant restaurant = new Restaurant();

    System.out.println();

    restaurant.separateClientsToStaff(restaurant.getClients(), restaurant.getTables(),
        restaurant.getBar());
    restaurant.getBartender().removeDrinksFromStorage(restaurant.getStorage());
    restaurant.getCheff().removeFoodsFromStorage(restaurant.getStorage());

    System.out.println("Ресторант сума: " + restaurant.getInitialAmount());
    restaurant.getWaiter1().addBillToRestaurant(restaurant);
    System.out.println(
        "Добавя към ресторанта от сервитьор " + restaurant.getWaiter1().getName() + " каса: "
            + restaurant.getWaiter1().getMoneyFromClients());

    restaurant.getWaiter2().addBillToRestaurant(restaurant);
    System.out.println(
        "Добавя към ресторанта от сервитьор " + restaurant.getWaiter2().getName() + " каса: "
            + restaurant.getWaiter2().getMoneyFromClients());

    restaurant.getBartender().addBillToRestaurant(restaurant);
    System.out.println(
        "Добавя към ресторанта от барман " + restaurant.getBartender().getName() + " каса: "
            + restaurant.getBartender().getMoneyFromClients());

    System.out.println("Ресторант сума: " + restaurant.getInitialAmount());
    restaurant.printStaffTip();

    restaurant.getStorage().printStorage();
    restaurant.getStorage().printNumberOfOrdersStatistic();
    System.out.println();

    restaurant.getMenu().getMostOrdered(restaurant.getStorage());
    restaurant.getMenu().removeLeastOrdered(restaurant.getStorage());
    System.out.println();

    restaurant.getWaiter1().addsBonusToSalary();
    restaurant.getWaiter2().addsBonusToSalary();
    restaurant.getBartender().addsBonusToSalary();
    restaurant.getHostess().addsBonusToSalary();
    restaurant.getCheff().addsBonusToSalary();

    System.out.println(restaurant.getMenu());
  }
}
