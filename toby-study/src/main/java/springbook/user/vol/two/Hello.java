package springbook.user.vol.two;

public class Hello {
  String name;
  Printer printer;

  public String sayHello() {
    return "Hello " + name;
  }

  public void print() {
    this.printer.print(sayHello());
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPrinter(Printer printer) {
    this.printer = printer;
  }
}

interface Printer {

  void print(String message);

}

class StringPrinter implements Printer {

  private final StringBuffer buffer = new StringBuffer();

  @Override
  public void print(String message) {
    this.buffer.append(message);
  }

  @Override
  public String toString() {
    return "StringPrinter{" +
        "buffer=" + this.buffer.toString() +
        '}';
  }
}

class ConsolePrinter implements Printer {

  @Override
  public void print(String message) {
    System.out.println(message);
  }
}

