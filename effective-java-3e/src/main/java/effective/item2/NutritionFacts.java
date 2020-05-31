package effective.item2;

public class NutritionFacts {

  private final int servingSize;
  private final int servings;
  private final int calories;
  private final int fat;
  private final int sodium;
  private final int carbohydrate;


  private NutritionFacts(Builder builder) {
    servingSize = builder.servingSize;
    servings = builder.servings;
    calories = builder.calories;
    fat = builder.fat;
    sodium = builder.sodium;
    carbohydrate = builder.carbohydrate;
  }

  public static class Builder {

    // 필수 매개변수
    private final int servingSize;
    private final int servings;

    // 선택 매개변수 - 기본값을 초기화 한다.
    private int calories = 0;
    private int fat = 0;
    private int sodium = 0;
    private int carbohydrate = 0;

    public Builder(int servingSize, int servings) {
      this.servingSize = servingSize;
      this.servings = servings;
    }

    public Builder calories(int val) {
      this.calories = val;
      return this;
    }


    public Builder fat(int val) {
      this.fat = val;
      return this;
    }


    public Builder sodium(int val) {
      this.sodium = val;
      return this;
    }


    public Builder carbohydrate(int val) {
      this.carbohydrate = val;
      return this;
    }


    public NutritionFacts build() {
      return new NutritionFacts(this);
    }

  }

  @Override
  public String toString() {
    return "NutritionFacts{" +
        "servingSize=" + servingSize +
        ", servings=" + servings +
        ", calories=" + calories +
        ", fat=" + fat +
        ", sodium=" + sodium +
        ", carbohydrate=" + carbohydrate +
        '}';
  }


  public static void main(String[] args) {

    System.out.println(new Builder(240, 8)
            .calories(100)
            .sodium(35)
            .carbohydrate(27)
            .build()
        .toString());
  }
}
