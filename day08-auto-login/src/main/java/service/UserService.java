package service;

import beans.User;
import dao.UserDao;

public class UserService {
    UserDao userDao= new UserDao();

    public User login(User user) {


        return userDao.login(user);
    }
}
