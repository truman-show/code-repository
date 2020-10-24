package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import springbook.user.domain.User;

public class UserDao {

  public void add(User user) throws ClassNotFoundException, SQLException {
    Class.forName("org.h2.Driver");
    Connection connection = DriverManager
        .getConnection("jdbc:h2:tcp://localhost/~/springbook", "sa", "");

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
    Class.forName("org.h2.Driver");
    Connection connection = DriverManager
        .getConnection("jdbc:h2:tcp://localhost/~/springbook", "sa", "");

    PreparedStatement preparedStatement = connection.prepareStatement(
        "select * from users where id = ?");
    preparedStatement.setString(1, id);

    ResultSet resultSet = preparedStatement.executeQuery();
    resultSet.next();

    User user = new User();
    user.setId(resultSet.getString("id"));
    user.setId(resultSet.getString("name"));
    user.setId(resultSet.getString("password"));

    resultSet.close();
    preparedStatement.close();
    connection.close();

    return user;
  }


}
