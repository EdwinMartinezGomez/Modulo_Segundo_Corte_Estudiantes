package co.edu.uptc.view;

public class Personans {


    private String nombre;
    private String apellido;
    private int age;

    public Personans (String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;

    }

    public Personans(String nombre, int age) {
        this.nombre = nombre;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Personans{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", age=" + age +
                '}';
    }
}
