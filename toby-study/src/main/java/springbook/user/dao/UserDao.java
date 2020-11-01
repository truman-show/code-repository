package springbook.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springbook.user.domain.User;

public class UserDao {

  private ConnectionMaker connectionMaker;

  public UserDao(ConnectionMaker connectionMaker) {
    this.connectionMaker = connectionMaker;
  }

  public void add(User user) throws ClassNotFoundException, SQLException {
    Connection connection = connectionMaker.makeConnection();

    PreparedStatement preparedStatement = connection.prepareStatement(
        "insert into users(id, name, password) values (?, ?, ?)");
    preparedStatement.setString(1, user.getId());
    preparedStatement.setString(2, user.getName());
    preparedStatement.setString(3, user.getPassword());

    preparedStatement.executeUpdate();
    preparedStatement.close();
    connection.close();

  }

  public User get(String id) throws ClassNotFoundException, SQLException {
    Connection connection = connectionMaker.makeConnection();

    PreparedStatement preparedStatement = connection.prepareStatement(
        "select * from users where id = ?");
    preparedStatement.setString(1, id);

    ResultSet resultSet = preparedStatement.executeQuery();
    resultSet.next();

    User user = new User();
    user.setId(resultSet.getString("id"));
    user.setName(resultSet.getString("name"));
    user.setPassword(resultSet.getString("password"));

    resultSet.close();
    preparedStatement.close();
    connection.close();

    return user;
  }

}

class UserDaoTest {

  //테스트용 main()메소드
  public static void main(String[] args) throws SQLException, ClassNotFoundException {

//    DaoFactory daoFactory = new DaoFactory();
//    UserDao dao = daoFactory.userDao();

    ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
    UserDao dao = context.getBean("userDao", UserDao.class);

    User user = new User();
    user.setId("truman-show");
    user.setName("이지훈");
    user.setPassword("1234");

    dao.add(user);

    System.out.println(user.getId() + " 등록 성공");

    User user2 = dao.get(user.getId());
    if (!user.getName().equals(user2.getName())) {
      System.out.println("테스트 실패 (name)");
    } else if (!user.getPassword().equals(user2.getPassword())) {
      System.out.println("테스트 실패 (password)");
    }
    else {
      System.out.println("조회 테스트 성공");
    }

  }
}
