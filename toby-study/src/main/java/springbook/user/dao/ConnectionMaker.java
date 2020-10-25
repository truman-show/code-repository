package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface ConnectionMaker {

  Connection makeConnection() throws ClassNotFoundException, SQLException;

}

class NConnectionMaker implements ConnectionMaker {

  @Override
  public Connection makeConnection() throws ClassNotFoundException, SQLException {
    Class.forName("org.h2.Driver");
    return DriverManager
        .getConnection("jdbc:h2:tcp://localhost/~/springbook", "sa", "");
  }
}

class DConnectionMaker implements ConnectionMaker {

  @Override
  public Connection makeConnection() throws ClassNotFoundException, SQLException {
    Class.forName("org.h2.Driver");
    return DriverManager
        .getConnection("jdbc:h2:tcp://localhost/~/springbook", "sa", "");
  }
}

