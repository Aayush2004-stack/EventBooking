package model;

public class User {
    private String name, username, password;
    private Boolean isAdmin;

    public User(String name, String username, String password){
        this.name =name;
        this.username =username;
        this.password=password;

    }
    public User( String username, String password){

        this.username =username;
        this.password=password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
