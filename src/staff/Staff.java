package staff;

import java.math.BigDecimal;

public abstract class Staff {

  private String name;
  private BigDecimal salary;

  private BigDecimal tip;

  public Staff(String name, BigDecimal salary) {
    this.name = name;
    this.salary = salary;
  }

  public abstract void addsBonusToSalary();

  public String getName() {
    return name;
  }

  public BigDecimal getSalary() {
    return salary;
  }

  public void setSalary(BigDecimal salary) {
    this.salary = salary;
  }

  public BigDecimal getTipFromClients() {
    return tip;
  }

}
