package springbook.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
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
    user.setName(resultSet.getString("name"));
    user.setPassword(resultSet.getString("password"));

    resultSet.close();
    preparedStatement.close();
    connection.close();

    return user;
  }

  public void deleteAll() throws SQLException {
    Connection connection = datasource.getConnection();

    PreparedStatement preparedStatement = connection.prepareStatement("delete from users");
    preparedStatement.executeUpdate();

    preparedStatement.close();
    connection.close();

  }

  public int getCount() throws SQLException {
    Connection connection = datasource.getConnection();

    PreparedStatement preparedStatement = connection.prepareStatement("select count(*) from users");
    ResultSet resultSet = preparedStatement.executeQuery();
    resultSet.next();
    int count = resultSet.getInt(1);

    resultSet.close();
    preparedStatement.close();
    connection.close();

    return count;
  }


}
