package storage;

import java.util.LinkedHashMap;
import java.util.Map;

public class Storage {

  private Map<String, Integer> foods;
  private Map<String, Integer> drinks;
  private Map<String, Integer> numberOfOrdersStatistic;

  public Storage() {
    this.foods = new LinkedHashMap<>();
    this.drinks = new LinkedHashMap<>();
    this.numberOfOrdersStatistic = new LinkedHashMap<>();
    makeStorage();
    makeZeroValuesNumberOfOrderStatistic();
  }

  private void makeStorage() {
    this.foods.put("Шопска салата", 50);
    this.foods.put("Овчарска салата", 50);
    this.foods.put("Зелена салата", 50);
    this.foods.put("Гръцка салата", 50);
    this.foods.put("Италианска салата", 50);

    this.foods.put("Пица", 50);
    this.foods.put("Спагети", 50);
    this.foods.put("Омлет", 50);
    this.foods.put("Калмари", 50);
    this.foods.put("Кюфтета", 50);
    this.foods.put("Пържени картофи", 50);
    this.foods.put("Пържола", 50);
    this.foods.put("Кебапчета", 50);
    this.foods.put("Виенски шницел", 50);
    this.foods.put("Яйца на очи", 50);

    this.foods.put("Сладолед", 50);
    this.foods.put("Торта", 50);

    this.drinks.put("Ракия", 50);
    this.drinks.put("Вино", 50);
    this.drinks.put("Бира", 50);

    this.drinks.put("Сок", 50);
    this.drinks.put("Кола", 50);
    this.drinks.put("Минерална вода", 50);
    this.drinks.put("Айрян", 50);
  }

  private void makeZeroValuesNumberOfOrderStatistic() {
    numberOfOrdersStatistic.putAll(foods);
    numberOfOrdersStatistic.putAll(drinks);

    for (Map.Entry<String, Integer> m : numberOfOrdersStatistic.entrySet()) {
      m.setValue(0);
    }
  }

  public void decreaseFoodValue(String str) {
    if (foods.containsKey(str)) {
      if (foods.get(str) > 1) {
        foods.put(str, foods.get(str) - 1);
        increaseNumberOfProductsStatistic(str);

      } else if (foods.get(str) == 1) {

        foods.put(str, foods.get(str) - 1);
        increaseNumberOfProductsStatistic(str);
        foods.put(str, foods.get(str) + 10);
        System.out.println("Зареждане на храни: " + str);

      }
    }
  }

  public void decreaseDrinkValue(String str) {
    if (drinks.containsKey(str)) {
      if (drinks.get(str) > 1) {
        drinks.put(str, drinks.get(str) - 1);
        increaseNumberOfProductsStatistic(str);

      } else if (drinks.get(str) == 1) {

        drinks.put(str, drinks.get(str) - 1);
        increaseNumberOfProductsStatistic(str);
        drinks.put(str, drinks.get(str) + 10);
        System.out.println("Зареждане на напитки: " + str);
      }
    }
  }

  public void increaseNumberOfProductsStatistic(String str) {
    numberOfOrdersStatistic.put(str, numberOfOrdersStatistic.get(str) + 1);
  }

  public Map<String, Integer> getNumberOfOrdersStatistic() {
    return numberOfOrdersStatistic;
  }

  public void printStorage() {
    System.out.println();
    System.out.println("-------------------------");
    System.out.println("Наличности в края на деня");
    System.out.println("-------------------------");
    System.out.println("=== Хранителни ===");
    foods.forEach((k, v) -> System.out.println("Продукт: " + k + " Брой: " + v));
    System.out.println();
    System.out.println("=== Напитки ===");
    drinks.forEach((k, v) -> System.out.println("Продукт: " + k + " Брой: " + v));

  }

  public void printNumberOfOrdersStatistic() {
    System.out.println();
    System.out.println("-----------------------");
    System.out.println("Статистика на поръчките");
    System.out.println("-----------------------");
    numberOfOrdersStatistic.forEach((k, v) -> System.out.println("Продукт: " + k + " Брой: " + v));
  }
}
