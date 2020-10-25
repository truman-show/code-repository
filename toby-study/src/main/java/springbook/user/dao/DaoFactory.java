package springbook.user.dao;

public class DaoFactory {
  public UserDao userDao() {
    NConnectionMaker connectionMaker = new NConnectionMaker();
    UserDao userDao = new UserDao(connectionMaker);
    return userDao;
  }
}
