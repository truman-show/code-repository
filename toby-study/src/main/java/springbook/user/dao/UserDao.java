package springbook.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springbook.user.domain.User;

public class UserDao {

  private DataSource datasource;

  public UserDao(DataSource datasource) {
    this.datasource = datasource;
  }

  public void add(User user) throws ClassNotFoundException, SQLException {
    Connection connection = datasource.getConnection();

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
    Connection connection = datasource.getConnection();

    PreparedStatement preparedStatement = connection.prepareStatement(
        "select * from users where id = ?");
    preparedStatement.setString(1, id);

    ResultSet resultSet = preparedStatement.executeQuery();
    resultSet.next();

    User user = new User();
    user.setId(resultSet.getString("id"));
//    user.setName(resultSet.getString("name"));
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
    System.out.println(user2.getName());
    System.out.println(user2.getPassword());
    System.out.println(user2.getId() + "조회 성공");

  }
}
