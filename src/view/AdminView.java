package view;

import model.User;

public class AdminView {
    public  static void showAdminView(User user){
        System.out.println("Welcome Back "+user.getName());

    }
}
