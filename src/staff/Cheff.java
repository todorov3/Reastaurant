package staff;

import clients.Order;
import storage.Storage;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Cheff extends Staff {

  private Queue<Order> orders;

  public Cheff(String name, BigDecimal salary) {
    super(name, salary);
    orders = new LinkedList<>();
  }

  public void setOrders(Order order) {
    this.orders.add(order);
  }

  public void removeFoodsFromStorage(Storage storage) {
    Order order;
    while (!orders.isEmpty()) {
      order = orders.poll();
      for (int i = 0; i < order.getItems().size(); i++) {
        String item = order.getItems().get(i).getName();
        storage.decreaseFoodValue(item);
      }
    }
  }

  @Override
  public void addsBonusToSalary() {
    Random rn = new Random();
    int bonus = rn.nextInt(10) + 1;
    if (bonus > 6) {
      System.out.println("Добавни 200лв. към заплатата на " + getName() + " !");
      setSalary(getSalary().add(BigDecimal.valueOf(200)));
      System.out.println("Заплата: " + getSalary() + "лв.");
    }
  }

  @Override
  public String toString() {
    return "staff.Cheff{" +
        "orders=" + orders +
        '}';
  }
}
