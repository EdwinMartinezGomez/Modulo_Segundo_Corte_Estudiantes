package co.edu.uptc.model.persontypes;

import co.edu.uptc.model.Account;
import co.edu.uptc.model.Person;

public class Administrator extends Person {
    public Administrator(String id, String name, String lastname,String email, String phone) {
        super(id, name, lastname, email, phone);
    }
    public Administrator(String id, String name, String lastname, Account account, String email, String phone) {
        super(id, name, lastname, phone,email, account);
    }
}
