package dao;

import beans.User;
import org.junit.jupiter.api.Test;

class UserDaoTest {

    @Test
    void login() {
        UserDao userDao = new UserDao();
        User user = new User("root", "123456");
        User login = userDao.login(user);
        System.out.println(login);
    }
}