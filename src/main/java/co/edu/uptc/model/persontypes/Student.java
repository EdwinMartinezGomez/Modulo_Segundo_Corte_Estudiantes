package co.edu.uptc.model.persontypes;

import co.edu.uptc.model.Account;
import co.edu.uptc.model.Person;

public class Student extends Person {

    private boolean egresado;
    public Student(String id, String name, String lastname, String phone, Account account, String email) {
        super(id, name, lastname, phone, email);
    }



    public Student(String id, boolean egresado) {
        this.setId(id);
        this.egresado = egresado;
    }

    public Student() {
        super();
    }
}
