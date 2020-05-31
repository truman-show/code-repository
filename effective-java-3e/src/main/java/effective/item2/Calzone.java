package effective.item2;

public class Calzone extends Pizza {

  private final boolean sauceInside;

  Calzone(Builder builder) {
    super(builder);
    sauceInside = builder.sauceInside;
  }

  public static class Builder extends Pizza.Builder<Builder> {

    private boolean sauceInside = false; //기본 값

    public Builder sauceInside() {
      sauceInside = true;
      return this;
    }

    @Override
    public Calzone build() {
      return new Calzone(this);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }

}
