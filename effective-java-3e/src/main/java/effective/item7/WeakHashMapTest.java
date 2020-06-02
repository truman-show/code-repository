package effective.item7;

import java.util.WeakHashMap;

/**
 * 아이템 7 다 쓴 객체 참조는 해제하라
 */
public class WeakHashMapTest {

  public static void main(String[] args) {
    WeakHashMap<Integer, String> map = new WeakHashMap<>();
    Integer key1 = 1_000;
    Integer key2 = 2_000;

    map.put(key1, "aaaa");
    map.put(key2, "bbbb");

    key1 = null;
    System.gc();//강제 GC
    map.entrySet().stream().forEach(el -> System.out.println(el));
    // JVM은 미리 불변 객체로 String 객체를 리터럴 방식으로생성하거나 -127~128 의 Integer Class값으로 Key를 사용할경우
    // Key 가 null 처리(참조 해제) 되더라도 WeakHashMap에서 삭제 되지 않는다
    // 위 예제의 Key1 값을 -127~128 범위의 값으로 지정하고 테스트 해봐라
  }

}
