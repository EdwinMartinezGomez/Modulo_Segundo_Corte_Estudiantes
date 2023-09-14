package co.edu.uptc.model;

public class Admin {
    private String user;
    private String password;

    public Admin() {

    }

    public Admin(String user, String password) {

        this.password = password;
        this.user = user;

    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin [user=" + user + ", password=" + password + "]";
    }

}
