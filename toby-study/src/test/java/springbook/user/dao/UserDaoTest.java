package springbook.user.dao;


import static org.assertj.core.api.Assertions.assertThat;

import java.sql.SQLException;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import springbook.user.domain.User;

public class UserDaoTest {

  @Test //JUnit에게 테스트용 메소드임을 알려준다.
  public void addAndGet() throws SQLException, ClassNotFoundException { // JUnit 테스트 메소드는 반드시 public 으로 선언돼야 한다.
    ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
    UserDao dao = context.getBean("userDao", UserDao.class);
    User user1 = new User("hello0", "world0", "hello world0");
    User user2 = new User("hello1", "world1", "hello world1");

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
    ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
    UserDao dao = context.getBean("userDao", UserDao.class);

    User user1 = new User("hello0", "world0", "hello world0");
    User user2 = new User("hello1", "world2", "hello world1");
    User user3 = new User("hello2", "world3", "hello world2");

    dao.deleteAll();
    assertThat(dao.getCount()).isSameAs(0);

    dao.add(user1);
    assertThat(dao.getCount()).isSameAs(1);

    dao.add(user2);
    assertThat(dao.getCount()).isSameAs(2);

    dao.add(user3);
    assertThat(dao.getCount()).isSameAs(3);
  }

  @Test(expected = EmptyResultDataAccessException.class)  //테스트 중에 발생할 것으로 기대하는 예외 클래스를 지정해준다.
  public void getUserFailure() throws SQLException {
    ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
    UserDao dao = context.getBean("userDao", UserDao.class);

    dao.deleteAll();
    assertThat(dao.getCount()).isSameAs(0);

    dao.get("unknown_id");  // 이 메소드 실행 중에 예외가 발생해야 한다. 예외가 발생하지 않으면 테스트가 실패한다.
  }


}

