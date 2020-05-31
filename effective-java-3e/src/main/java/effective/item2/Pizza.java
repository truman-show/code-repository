package effective.item2;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class Pizza {

  public enum Topping {HAM, MUSHROOM, ONION, PERPER, SAUSAGE}

  final Set<Topping> toppings;

  Pizza(Builder<?> builder) {
    toppings = builder.toppings.clone();
  }

  abstract static class Builder<T extends Builder<T>> {
    EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);  //지정된 enum Type의 비어있는 enumSet을 만든다.

    public T addTopping(Topping topping) {
      toppings.add(Objects.requireNonNull(topping));
      return self();
    }

    abstract Pizza build();

    //하위 클래스는 이 메서드를 재정의(overriding)하여
    // "this"를 반환하도록 해야한다.
    protected abstract T self();
  }

  public static void main(String[] args) {
    NyPizza pizza = new NyPizza.Builder(NyPizza.Size.SMALL)
        .addTopping(Topping.SAUSAGE)
        .addTopping(Topping.ONION)
        .build();

    for (Topping topping : pizza.toppings) {
      System.out.println(topping);
    }

    Calzone calzonePizza = new Calzone.Builder()
        .addTopping(Topping.HAM)
        .sauceInside()
        .build();

  }

}
