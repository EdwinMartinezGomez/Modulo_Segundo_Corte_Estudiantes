package co.edu.uptc.model;

import java.util.Objects;

/**
 * Person Class is for manage and simulate a person
 * @Author Edwin Martinez
 * @Author Samuel Gonzalez Zambrano
 * @Author Nicolas Sarmiento
 */
public class Person {
    private String id;
    private String name;
    private String lastname;
    private String phone;
    private  String email;

    private Account account;


    public Person(String id, String name, String lastname, String phone , String email) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
    }

    public Person(String id, String name, String lastname, String phone , String email, Account account) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
        this.account = account;

    }

    public Person() {
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(name, person.name) && Objects.equals(lastname, person.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastname);
    }

    public String toString(){
        return "Name: " + this.getName() + " Last Name: " + this.getLastname() + " Id: " + this.getId() + " Data Acount: " + this.getAccount().toString();
    }



}

