package controller;

import dao.UserDAO;
import model.User;

public class UserController {
    UserDAO userDAO =new UserDAO();

    public boolean SignUp(String name, String username, String password) {
        User user=new User(name, username,password);

        return userDAO.signUp(user);

    }

    public User logIn(String username, String password) {
        User user =new User(username, password);
        return userDAO.logIN(user);
    }
}
