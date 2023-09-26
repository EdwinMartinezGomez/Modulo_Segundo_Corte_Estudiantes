package co.edu.uptc.model.persontypes;

import co.edu.uptc.model.Account;
import co.edu.uptc.model.Person;

public class Student extends Person {

    private boolean egresado;
    public Student(String id, String name, String lastname, String phone, String email, Account account,boolean egresado) {
        super(id, name, lastname, phone, email,account);
        this.egresado=egresado;
    }


    public Student(String id, boolean egresado) {
        this.setId(id);
        this.egresado = egresado;
    }

    public Student() {
        super();
    }

    public Student(String id, String name, String lastName, String phone, String email) {
        super(id,name,lastName,phone,email);
    }

    public Student(String id, String name, String lastname, String phone, String email, Account account) {
        super(id,name,lastname,phone,email,account);
    }

    public Student(String id, String name, String lastName, String phone, String email, boolean egresado) {
        super(id,name,lastName,phone,email);
        this.egresado=egresado;
    }

    public boolean isEgresado() {
        return egresado;
    }

    public void setEgresado(boolean egresado) {
        this.egresado = egresado;
    }
}
