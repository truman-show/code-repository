## 아이템1 생성자 대신 정적 팩터리 메서드를 고려하라

- 클래스는 생성자와 별도로 정적 팩터리 메서드를 제공할 수 있다.


## 장점
1. 이름을 가질 수 있다.
2. 호출될 때마다 인스턴스를 새로 생성하지는 않아도 된다.
3. 반환 타입의 하위 타입 객체를 반환할 수 있는 능력이 있다.
  - 반환할 객체의 클래스를 자유롭게 선택할 수 있게하는 '엄청난 유연성' 을 선물한다.

```java

``` 