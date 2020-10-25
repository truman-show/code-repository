package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import springbook.user.domain.User;

public abstract class UserDao {

  public void add(User user) throws ClassNotFoundException, SQLException {
    Connection connection = getConnection();

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
    Connection connection = getConnection();

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

  protected abstract Connection getConnection() throws ClassNotFoundException, SQLException;


  public static class NUserDao extends UserDao {

    @Override
    protected Connection getConnection() throws ClassNotFoundException, SQLException {
      Class.forName("org.h2.Driver");
      return DriverManager
          .getConnection("jdbc:h2:tcp://localhost/~/springbook", "sa", "");
    }
  }

  public static class DUserDao extends UserDao {

    @Override
    protected Connection getConnection() throws ClassNotFoundException, SQLException {
      Class.forName("org.h2.Driver");
      return DriverManager
          .getConnection("jdbc:h2:tcp://localhost/~/springbook", "sa", "");
    }
  }

  //테스트용 main()메소드
  public static void main(String[] args) throws SQLException, ClassNotFoundException {
    UserDao dao = new NUserDao();

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
