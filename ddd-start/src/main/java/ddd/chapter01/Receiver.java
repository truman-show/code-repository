package ddd.chapter01;

public class Receiver {

  private String name;
  private String phoneNumber;

  @Override
  public boolean equals(Object other) {
    if (other == null) return false;
    if (this == other) return true;
    if (!(other instanceof Receiver)) return false;

    Receiver that = (Receiver) other;
    return this.name.equals(that.name) && this.phoneNumber.equals(that.phoneNumber);

  }

}
