package springbook.user.dao;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

@Configuration
public class DaoFactoryForTest {

  @Bean
  public UserDao userDao() {
    return new UserDao(dataSourceTest());
  }

  @Bean
  public DataSource dataSourceTest() {
    DataSource dataSource = new SingleConnectionDataSource(
        "jdbc:h2:tcp://localhost/~/springbook", "sa", "", true);
    return dataSource;
  }

}
