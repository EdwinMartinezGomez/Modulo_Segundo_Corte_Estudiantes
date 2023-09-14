package co.edu.uptc.model;

public class Student extends Persona {
    private String id;
    private boolean egresado;
    // Aqui debería crearse los atributos para la información acerca del agresado

    public Student() {

    }

    public Student(String id, boolean egresado) {
        this.id = id;
        this.egresado = egresado;
    }

    public Student(String name, String lastName, String phone, String email, Account account, String id,
                   boolean egresado) {
        super(name, lastName, phone, email, account);
        this.id = id;
        this.egresado = egresado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isEgresado() {
        return egresado;
    }

    public void setEgresado(boolean egresado) {
        this.egresado = egresado;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", egresado=" + egresado + "]";
    }
}
