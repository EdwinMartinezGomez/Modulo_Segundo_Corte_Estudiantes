package co.edu.uptc.model;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ClaseAux  {
    private String id;
    private String name;
    private String lastname;
    private String phone;
    private String email;

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    private String pass;
    private String role;
    private String emailGenerado;
    private Button bt;

    public ClaseAux(String id, String name, String lastname, String phone, String email, String role,String pass, String emailGenerado,Button bt) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
        this.role = role;
        this.pass = pass;
        this.emailGenerado = emailGenerado;
        this.bt=bt;
    }

    public ClaseAux() {

    }

    public Button getBt() {
        return bt;
    }

    public void setBt(Button bt) {
        this.bt = bt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmailGenerado() {
        return emailGenerado;
    }

    public void setEmailGenerado(String emailGenerado) {
        this.emailGenerado = emailGenerado;
    }
}
