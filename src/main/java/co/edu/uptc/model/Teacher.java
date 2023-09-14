package co.edu.uptc.model;

public class Teacher extends Persona {

    private String id;
    private boolean director;

    public Teacher() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isDirector() {
        return director;
    }

    public void setDirector(boolean director) {
        this.director = director;
    }

    public Teacher(String id, boolean director) {
        this.id = id;
        this.director = director;
    }

    public Teacher(String name, String lastName, String phone, String email, Account account, String id,
                   boolean director) {
        super(name, lastName, phone, email, account);
        this.id = id;
        this.director = director;
    }

    @Override
    public String toString() {
        return "Teacher [id= " + id + ", director= " + director + "]";
    }

}
