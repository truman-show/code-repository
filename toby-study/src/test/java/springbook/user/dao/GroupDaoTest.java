package springbook.user.dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DaoFactory.class) // UserDaoTest.class의 스프링 컨텍스트 설정파일과 동일하다
public class GroupDaoTest {

  @Autowired
  private UserDao dao;

  @Before
  public void setUp(){
    System.out.println("==============userDaoTest");
    System.out.println(dao);
    System.out.println("==============userDaoTest");
  }

  @Test
  public void temp(){

  }
}
