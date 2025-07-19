package controller;

import dao.UserDAO;
import model.User;

public class UserController {

    public boolean SignUp(String name, String username, String password) {
        User user=new User(name, username,password);
        UserDAO userDAO =new UserDAO();

        return userDAO.signUp(user);

    }
}
