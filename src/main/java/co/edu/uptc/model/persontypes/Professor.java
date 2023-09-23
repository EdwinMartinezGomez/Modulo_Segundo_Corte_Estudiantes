package co.edu.uptc.model.persontypes;
import co.edu.uptc.model.Account;
import co.edu.uptc.model.Person;

public class Professor extends Person {


    public Professor(String id, String name, String lastname, String email, String phone) {
        super(id, name, lastname, email, phone);
    }
    public Professor(String id, String name, String lastname, Account account, String email, String phone) {
        super(id, name, lastname, email, phone,account);
    }
}
