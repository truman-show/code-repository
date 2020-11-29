package springbook.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.dao.EmptyResultDataAccessException;
import springbook.user.domain.User;

public class UserDao {

  private final DataSource datasource;

  public UserDao(DataSource datasource) {
    this.datasource = datasource;
  }

  public DataSource getDatasource() {
    return this.datasource;
  }

  public void add(User user) throws SQLException {
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

  public User get(String id) throws SQLException {
    Connection connection = datasource.getConnection();

    PreparedStatement preparedStatement = connection.prepareStatement(
        "select * from users where id = ?");
    preparedStatement.setString(1, id);

    ResultSet resultSet = preparedStatement.executeQuery();
    User user = null;
    if (resultSet.next()) {
      user = new User();
      user.setId(resultSet.getString("id"));
      user.setName(resultSet.getString("name"));
      user.setPassword(resultSet.getString("password"));
    }

    resultSet.close();
    preparedStatement.close();
    connection.close();

    if (user == null) throw new EmptyResultDataAccessException(1);

    return user;
  }

  public void deleteAll() throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;


    try {
      // 예외가 발생할 가능성이 있는 코드를 모두 try 블록으로 묶어준다.
      connection = datasource.getConnection();
      preparedStatement = connection.prepareStatement("delete from users");
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      throw e;
    } finally {
      if (preparedStatement != null) {
        try {
          preparedStatement.close();
        } catch (SQLException e) {
        }
      }
      if (connection != null) {
        try {
          connection.close();
        } catch (SQLException e) {
        }
      }
    }

    preparedStatement.close();
    connection.close();

  }

  public int getCount() throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
      connection = datasource.getConnection();
      preparedStatement = connection.prepareStatement("select count(*) from users");
      resultSet = preparedStatement.executeQuery();
      resultSet.next();

      return resultSet.getInt(1);

    } catch (SQLException e) {
      throw e;
    } finally {

      if (resultSet != null) {
        try {
          resultSet.close();
        } catch (SQLException throwables) {
          throwables.printStackTrace();
        }
      }

      if (preparedStatement != null) {
        try {
          preparedStatement.close();
        } catch (SQLException throwables) {
          throwables.printStackTrace();
        }
      }

      if (connection != null) {
        try {
          connection.close();
        } catch (SQLException throwables) {
          throwables.printStackTrace();
        }
      }
    }

  }


}
