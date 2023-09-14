package co.edu.uptc.model;

public class Persona {
    private String name;
    private String lastName;
    private String phone;
    private String email;
    private Account account;

    public Persona() {

    }

    public Persona(String name, String lastName, String phone, String email, Account account) {
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Persona [name=" + name + ", lastName=" + lastName + ", phone=" + phone + ", email=" + email
                + ", account=" + account + "]";
    }

}
