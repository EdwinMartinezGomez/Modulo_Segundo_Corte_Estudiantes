package co.edu.uptc.model;

public class Secretary extends Persona {
    private String id;

    public Secretary() {

    }

    public Secretary(String name, String lastName, String phone, String email, Account account, String id) {
        super(name, lastName, phone, email, account);
        this.id = id;
    }

    @Override
    public String toString() {
        return "Secretary [id=" + id + "]";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
