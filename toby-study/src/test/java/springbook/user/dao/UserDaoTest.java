package springbook.user.dao;


import static org.assertj.core.api.Assertions.assertThat;

import java.sql.SQLException;
import javax.sql.DataSource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import springbook.user.domain.User;

@RunWith(SpringJUnit4ClassRunner.class) // 스프링의 테스트 컨텍스트 프레임워크의 JUnit확장기능 지정
@ContextConfiguration(classes = {DaoFactory.class})
@DirtiesContext // 테스트 메소드에서 애플리케이션 컨텍스트의 구성이나 상태를 변경한다는 것을 테스트 프레임워크에 알려준다.
public class UserDaoTest {

  private UserDao dao;  //setUp() 메소드에서 만드는 오브젝트를 테스트 메소드에서 사용할 수 있도록 인스턴스 변수로 선언한다.
  private User user1;
  private User user2;
  private User user3;

  @Before // JUnit이 제공하는 애노테이션. @Test  메소드가 실행되기 전에 먼저 실행해야하는 메소드를 정의한다.
  public void setUp() {
    System.out.println(dao);

    DataSource dataSource = new SingleConnectionDataSource(
        "jdbc:h2:tcp://localhost/~/springbook", "sa", "", true);
    dao = new UserDao(dataSource);
    this.user1 = new User("hello0", "world0", "hello world0");
    this.user2 = new User("hello1", "world2", "hello world1");
    this.user3 = new User("hello2", "world3", "hello world2");
  }

  @Test //JUnit에게 테스트용 메소드임을 알려준다.
  public void addAndGet() throws SQLException { // JUnit 테스트 메소드는 반드시 public 으로 선언돼야 한다.
    dao.deleteAll();
    assertThat(dao.getCount()).isSameAs(0);

    dao.add(user1);
    dao.add(user2);
    assertThat(dao.getCount()).isSameAs(2);

    User userget1 = dao.get(user1.getId());
    assertThat(userget1.getName()).isEqualTo(user1.getName());
    assertThat(userget1.getPassword()).isEqualTo(user1.getPassword());

    User userget2 = dao.get(user2.getId());
    assertThat(userget2.getName()).isEqualTo(user2.getName());
    assertThat(userget2.getPassword()).isEqualTo(user2.getPassword());
  }

  @Test
  public void count() throws SQLException {
    dao.deleteAll();
    assertThat(dao.getCount()).isSameAs(0);

    dao.add(user1);
    assertThat(dao.getCount()).isSameAs(1);

    dao.add(user2);
    assertThat(dao.getCount()).isSameAs(2);

    dao.add(user3);
    assertThat(dao.getCount()).isSameAs(3);
  }

  //then
  @Test(expected = EmptyResultDataAccessException.class)  //테스트 중에 발생할 것으로 기대하는 예외 클래스를 지정해준다.
  public void getUserFailure() throws SQLException {
    // given
    dao.deleteAll();
    assertThat(dao.getCount()).isSameAs(0);

    //when
    dao.get("unknown_id");  // 이 메소드 실행 중에 예외가 발생해야 한다. 예외가 발생하지 않으면 테스트가 실패한다.
  }


}

