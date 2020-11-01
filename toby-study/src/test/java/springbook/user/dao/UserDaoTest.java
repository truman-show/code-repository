package springbook.user.dao;


import static org.assertj.core.api.Assertions.assertThat;

import java.sql.SQLException;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springbook.user.domain.User;

public class UserDaoTest {

  @Test //JUnit에게 테스트용 메소드임을 알려준다.
  public void addAndGet() throws SQLException, ClassNotFoundException { // JUnit 테스트 메소드는 반드시 public 으로 선언돼야 한다.
    ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
    UserDao dao = context.getBean("userDao", UserDao.class);

    dao.deleteAll();
    assertThat(dao.getCount()).isSameAs(0);

    User user = new User("truman-show", "이지훈", "1234");

    dao.add(user);
    assertThat(dao.getCount()).isSameAs(1);

    User user2 = dao.get(user.getId());

    assertThat(user2.getName()).isEqualTo(user.getName());
    assertThat(user2.getPassword()).isEqualTo(user.getPassword());
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

}

