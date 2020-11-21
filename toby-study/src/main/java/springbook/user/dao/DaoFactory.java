package springbook.user.dao;

import javax.sql.DataSource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

//@Configuration  // 애플리케이션 컨텍스트 또는 빈 팩토리가 사용할 설정정보라는 표시
public class DaoFactory {

  //@Bean //오브젝트 생성을 담당하는 IoC용 메소드라는 표시
  public UserDao userDao() {
    return new UserDao(dataSource());
  }

  //  @Bean
  public DataSource dataSource() {
    SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
    dataSource.setDriverClass(org.h2.Driver.class);
    dataSource.setUrl("jdbc:h2:tcp://localhost/~/springbook");
    dataSource.setUsername("sa");
    dataSource.setPassword("");
    return dataSource;
  }

}
