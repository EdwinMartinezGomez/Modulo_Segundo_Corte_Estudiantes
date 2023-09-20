package co.edu.uptc.controller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import co.edu.uptc.model.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class AccountControl {
    Graduated graduated;
    Account account;
    Admin admin;
    Persona persona;
    Secretary secretary;
    Student student;
    Teacher teacher;
    FileControl fc = new FileControl();
    List<Student> cuentas = new ArrayList<>();
    Gson gson= new GsonBuilder().setPrettyPrinting().create();

	/*public void addAdminAccount() {

		admin = new Admin();
		admin.setPassword("admin123");
		admin.setUser("admin");
		fc.writeFile("Admin",admin);
		//cuentas.add(admin);
	}

	public void addPreObjects() {// Se añaden cuentas predefinidas

		student = new Student("Juan ", "Muñoz", "3104567980", "Juan.munoz@uptc.edu.co",
				account = new Account(createUser("Juan", "Munoz", 1), createPassword("3104567980", "Juan")),
				"202209456", false);
		fc.writeFile("Students",student);
		Student student1 = new Student("Luis ", "Robelto", "3103695003", "luis.robelto@uptc.edu.co",
				account = new Account(createUser("Luis", "Robelto", 2), createPassword("3103695003", "Luis")),
				"202128044", false);
		fc.writeFile("Students", student1);
		graduated = new Graduated("Daniel", "Espinosa", "3135669845", "Daniel.espinosa@uptc.edu.co",
				account = new Account(createUser("Daniel", "Espinosa", 3), createPassword("3135669845", "Daniel")),
				"201809456", true, true, "IBM", "Pasante");
		fc.writeFile("Graduated",graduated);
		graduated = new Graduated("Sofia", "Granados", "3125669045", "Sofia.granados@uptc.edu.co",
				account = new Account(createUser("Sofia", "Granados", 4), createPassword("3125669045", "Sofia")),
				"201799126", true, false, "################", "################");
		fc.writeFile("Graduated",graduated);

		teacher = new Teacher("Alvaro", "Pérez", "3178993402", "Alvaro.perez@uptc.edu.co",
				account = new Account(createUser("Alvaro", "Perez", 5), createPassword("3178993402", "Alvaro")),
				"1003661120", true);
		fc.writeFile("Teachers",teacher);

	}*/

    public List<Student> showStudentsAccpo() {// Mostrar estudiantes
        cuentas = fc.readFileStudents("Students");
        return cuentas;
        /*String accounts = "-------------------------------------------------------------------";

        for (int i = 0; i < cuentas.size(); i++) {

            Object aux = cuentas.get(i);

            if (aux instanceof Student) {
                Student account = (Student) aux;

                if (account.isEgresado() == false) {
                    accounts += "\n" + " | " + account.getId() + " | " + account.getName() + " | "
                            + account.getLastName() + " | " + account.getPhone() + " | " + account.getEmail() + " | ";
                }

            }
        }

        accounts += "\n-------------------------------------------------------------------";
        return accounts;*/
    }



    public String showGraduatedAccounts() {// mostrar gradudados
        List<Graduated> graduateds=fc.readFileStudentsGraduated("Graduated");
        String accounts = "----------------------------------------------------------------------------------------------------------------";

        for (int i = 0; i < graduateds.size(); i++) {

            Object aux = graduateds.get(i);
            String egresad = "";

            if (aux instanceof Graduated) {
                Graduated account = (Graduated) aux;

                if (account.isEstadoEmp() == true) {
                    egresad = "Empleado";

                } else {
                    egresad = "No empleado";
                }

                accounts += "\n" + " | " + account.getId() + " | " + account.getName() + " | " + account.getLastName()
                        + " | " + account.getPhone() + " | " + account.getEmail() + " | " + egresad + "  |  "
                        + account.getNombEmpresa() + " | " + account.getCargo() + " | ";

            }
        }

        accounts += "\n-----------------------------------------------------------------------------------------------------------------";
        return accounts;
    }

    public String searchAccount(String user, String password) {// buscar cuenta
        List<Admin> aux1=fc.readFileAdmins("Admin");
        for (Object aux : aux1) {
            if (aux instanceof Admin) {// se busca admin
                Admin account = (Admin) aux;
                if (account.getUser().equals(user) && account.getPassword().equals(password)) {
                    return account.getClass().getName(); // Devolver el objeto Admin que coincida con el usuario y
                    // contraseña
                }
            }
        }
        List<Student> aux2=fc.readFileStudents("Students");
        for (Object aux : aux2) {
            if (aux instanceof Student) {// se busca estudiante
                Student account = (Student) aux;
                if (account.getAccount().getUser().equals(user)
                        && account.getAccount().getPassword().equals(password)) {
                    return account.getClass().getName(); // Devolver el objeto Admin que coincida con el usuario y
                    // contraseña
                }
            }
        }
        List<Teacher> aux3=fc.readFileTeachers("Teachers");
        for (Object aux : aux3) {
            if (aux instanceof Teacher) {// se busca profesor
                Teacher account = (Teacher) aux;
                if (account.getAccount().getUser().equals(user)
                        && account.getAccount().getPassword().equals(password)) {
                    if (account.isDirector() == true) {
                        return "------------------Director";
                    } else {
                        return account.getClass().getName(); // Devolver el objeto Admin que coincida con el usuario y
                    } // contraseña
                }
            }
        }
        List<Secretary> aux4=fc.readFileSecretary("Secretary");
        for (Object aux : aux4) {
            if (aux instanceof Secretary) {// se busca secretaria
                Secretary account = (Secretary) aux;
                if (account.getAccount().getUser().equals(user)
                        && account.getAccount().getPassword().equals(password)) {
                    return account.getClass().getName(); // Devolver el objeto Admin que coincida con el usuario y
                    // contraseña
                }
            }
        }
        return null;

    }

    public void addTeacher(String name, String lastName, String phone, String email, String user, String password,
                           String id, boolean director) {// añadir profesores

        account = new Account(user, password);
        teacher = new Teacher(name, lastName, phone, email, account, id, director);
        fc.writeFile("Teachers",teacher);
        //cuentas.add(teacher);

    }

    public void addSecretary(String name, String lastName, String phone, String email, String user, String password,
                             String id) {// añadir secretaria
        account = new Account(user, password);
        secretary = new Secretary(name, lastName, phone, email, account, id);
        fc.writeFile("Secretary",secretary);
        //cuentas.add(secretary);

    }

    public void addStudent(String name, String lastName, String phone, String email, String id, boolean egresado,
                           String password, String user) {// añadir estudiantes nuevos

        account = new Account();
        account.setUser(user);
        account.setPassword(password);

        student = new Student(name, lastName, phone, email, account, id, egresado);
        fc.writeFile("Student", student);
        cuentas.add(student);

    }

    public String createUser(String name, String lastname, int i) {// metodo para crear usuario

        return "" + name + "." + lastname + i;
    }

    public String createPassword(String phone, String name) {// metodo para crear contraseña

        return name + phone.substring(0, 4);
    }

    public void addGraduated(String name, String lastName, String phone, String email, String id, boolean egresado,
                             String password, String user, boolean estadoEmp, String cargo, String nombreEmpresa) {// agregar estudiante
        // egresado

        account = new Account(user, password);
        graduated = new Graduated(name, lastName, phone, email, account, id, egresado, estadoEmp, nombreEmpresa, cargo);
        fc.writeFile("Graduated",graduated);
        //cuentas.add(graduated);
    }

    public boolean verifyName(String s) {
        for (int i = 0; i < s.length(); i++) {
            char aux = s.charAt(i);
            if ((int) aux < 65) {

                return false;

            }
            if ((int) aux > 90 && (int) aux < 97) {

                return false;
            }
            if ((int) aux > 122) {

                return false;
            }

        }
        return true;
    }

    public boolean verifyIdLetters(String s) {
        for (int i = 0; i < s.length(); i++) {
            char aux = s.charAt(i);
            if ((int) aux < 48 || (int) aux > 57) {
                return false;
            }

        }
        return true;
    }

    public boolean verifyContainsArr(String s) {
        return s.contains("@");
    }

    public boolean verifyNumber(String s) {
        for (int i = 0; i < s.length(); i++) {
            char aux = s.charAt(i);
            if ((int) aux > 57 || (int) aux < 48) {
                return false;
            } else if (s.length() != 10) {
                return false;
            }

        }
        return true;
    }

    public boolean verifyIdStudent(String id) {
        if (id.length() != 9 || verifyIdLetters(id) == false) {
            return false;
        } else {
            for (Object o : cuentas) {
                if (o instanceof Student) {
                    Student aux = (Student) o;
                    if (aux.getId() == id) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean verifyIdPersonal(String id) {
        if (id.length() != 10 || verifyIdLetters(id) == false) {
            return false;
        } else {
            for (Object o : cuentas) {
                if (o instanceof Secretary) {
                    Secretary aux = (Secretary) o;
                    if (aux.getId() == id) {
                        return false;
                    }
                } else if (o instanceof Teacher) {
                    Teacher aux = (Teacher) o;
                    if (aux.getId() == id) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

}
