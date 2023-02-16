package restaurant;

import clients.Client;
import staff.*;
import storage.Storage;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Restaurant {

  private static final String RESTAURANT_NAME = "НАСЛАДА";
  private static final int RESTAURANT_CAPACITY = 30;
  private static final int TABLE_COUNT = 5;
  private static String name;
  private List<Staff> staff;
  private List<Client> clients;
  private Menu menu;
  private BigDecimal initialAmount;  //начална сума
  private int restaurantCapacity;
  private int tablesCount;
  private List<Table> tables;
  private Bar bar;
  private Storage storage;

  public Restaurant() {
    this.name = RESTAURANT_NAME;
    this.staff = new ArrayList<>();
    this.clients = new ArrayList<>();
    clientGenerator();
    this.tables = new ArrayList<>();
    this.menu = new Menu();
    this.bar = new Bar();
    this.storage = new Storage();
    this.initialAmount = new BigDecimal(1000);
    this.restaurantCapacity = RESTAURANT_CAPACITY;
    this.tablesCount = TABLE_COUNT;
    createTables();
    staffGenerator();
    separateWaitersToTables();
  }

  private void clientGenerator() {
    Random random = new Random();
    int clientsPerDay = random.nextInt(20, 51);
    System.out.println("Брой клиенти за деня: " + clientsPerDay);
    boolean isAdult;
    Client client;
    for (int i = 1; i <= clientsPerDay; i++) {
      isAdult = true;
      if (i % 5 == 0) {
        isAdult = false;
      }
      client = new Client(isAdult);
      clients.add(client);
    }
  }

  private void staffGenerator() {

    staff.add(new Waiter("Георги", BigDecimal.valueOf(1350)));
    staff.add(new Waiter("Мария", BigDecimal.valueOf(1250)));
    staff.add(new Cheff("Петър", BigDecimal.valueOf(3000)));
    staff.add(new Bartender("Димитър", BigDecimal.valueOf(1500)));
    staff.add(new Hostess("Виктория", BigDecimal.valueOf(2000)));
  }

  private void createTables() {
    for (int i = 1; i <= tablesCount; i++) {
      tables.add(new Table(i));
    }
  }

  public Waiter getWaiter1() {
    for (Staff value : this.staff) {
        if (value instanceof Waiter) {
            return (Waiter) value;
        }
    }
    return null;
  }

  public Waiter getWaiter2() {
    int counter = 0;
    for (Staff value : this.staff) {
      if (value instanceof Waiter) {
        counter++;
        if (counter == 2) {
          return (Waiter) value;
        }
      }
    }
    return null;
  }

  public Cheff getCheff() {
    for (Staff value : this.staff) {
        if (value instanceof Cheff) {
            return (Cheff) value;
        }
    }
    return null;
  }

  public Bartender getBartender() {
    for (Staff value : this.staff) {
        if (value instanceof Bartender) {
            return (Bartender) value;
        }
    }
    return null;
  }

  public Hostess getHostess() {
    for (Staff value : this.staff) {
        if (value instanceof Hostess) {
            return (Hostess) value;
        }
    }
    return null;
  }

  private void separateWaitersToTables() {
    for (int i = 0; i < tablesCount; i++) {
      if (i % 2 != 0) {
        getWaiter2().addTable(tables.get(i));
      } else {
        getWaiter1().addTable(tables.get(i));
      }
    }
  }

  public void printStaffTip() {
    System.out.println("Бакшиши");
    for (int i = 0; i < staff.size(); i++) {
      if (staff.get(i).getTipFromClients() != BigDecimal.ZERO
          && staff.get(i).getTipFromClients() != null) {
        System.out.println(staff.get(i).getName() + " " + staff.get(i).getTipFromClients());
      }
    }
  }

  public void separateClientsToStaff(List<Client> clients, List<Table> tables, Bar bar) {

    while (clients.size() > 0) {
      getHostess().separateClients(clients, tables, bar);
      getWaiter1().addOrdersToWaiter(getCheff(), getBartender());
      getWaiter2().addOrdersToWaiter(getCheff(), getBartender());
      getBartender().takeOrdersFromBar(bar);
    }

  }

  public void setInitialAmount(BigDecimal initialAmount) {
    this.initialAmount = initialAmount;
  }

  public Storage getStorage() {
    return storage;
  }

  public List<Client> getClients() {
    return clients;
  }

  public Menu getMenu() {
    return menu;
  }

  public BigDecimal getInitialAmount() {
    return initialAmount;
  }

  public List<Table> getTables() {
    return tables;
  }

  public Bar getBar() {
    return bar;
  }

  @Override
  public String toString() {
    return "restaurant.Restaurant{" + "\n" +
        "staff=" + staff + "\n" +
        ", clients=" + clients + "\n" +
        ", sum=" + initialAmount + "\n" +
        ", capacity=" + restaurantCapacity + "\n" +
        ", tablesCount=" + tablesCount + "\n" +
        ", tables=" + tables + "\n" +
        ", bar=" + bar + "\n" +
        '}';
  }
}
