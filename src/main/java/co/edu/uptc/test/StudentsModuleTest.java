package co.edu.uptc.test;
import co.edu.uptc.controller.AccountControl;

import java.util.Scanner;



public class StudentsModuleTest {

    public static void main(String[] args) {

        AccountControl acc = new AccountControl();
        //acc.addPreObjects();// se cargan las cuentas predefinidas
        //acc.addAdminAccount();// se añade automáticamente la cuenta de admnistrador

        String name = "", lastName = "", phone = "", email = "", id = "", pAssword = "", uSer = "";
        boolean egresado = false, direct = false;
        String graduat = "", director = "";

        int contador = 6;
        Scanner sc = new Scanner(System.in);
        String cuentaEncontrada = null;// Aqui se guarda la cuenta con la que se inicia sesion

        String op = "";

        System.out.println("----------------------------------------\n" + "Systems Engineering - STUDENTS MODULE");

        while (!op.equals("6")) {

            System.out.println("\n----------------------------------------"
                    + "\nPlease select an option: \n1. Login\n2. See Students database\n3. See Graduated Students database\n4. Sign in\n5. Logout "
                    + "\n6. Exit\n----------------------------------------");
            op = sc.nextLine();

            switch (op) {
                case "1":
                    if (cuentaEncontrada == null) {
                        String user = "";
                        String password = "";

                        System.out.println("Input your user: ");
                        user = sc.next();
                        sc.nextLine();

                        System.out.println("Input your password: ");
                        password = sc.next();
                        sc.nextLine();

                        cuentaEncontrada = acc.searchAccount(user, password);// metodo para buscar existencia de cuenta

                        if (cuentaEncontrada == null) {
                            System.out.println("The account doesnt exist ");
                        } else {
                            cuentaEncontrada = cuentaEncontrada.substring(18, cuentaEncontrada.length());
                            System.out.println("\nWelcome! " + cuentaEncontrada);
                        }
                    } else {
                        System.out.println("\nFirst log out!");
                    }
                    break;
                case "2":

                    if (cuentaEncontrada != null) {
                        if (cuentaEncontrada.equals("Secretary") || cuentaEncontrada.equals("Director")) {

                            System.out.println("\n                   Active Students Database: ");
                            System.out.println(" |  Id   |  Name  |   Last name  |  Phone  |   Email  | ");
                            System.out.println(acc.showStudentsAccpo());

                        } else {
                            System.out.println("\nFirst login as secretary or principal teacher to access to this option.");
                        }
                    } else {
                        System.out.println("First Log in");
                    }
                    break;

                case "4":

                    if (cuentaEncontrada != null) {
                        if (cuentaEncontrada.equals("Admin")) {
                            String op2 = "";

                            System.out.println("Please select the role you want to register: "
                                    + "\n1. Student\n2. Teacher\n3. Secretary\n4. Return");
                            op2 = sc.nextLine();

                            switch (op2) {

                                case "1":// Estudiante

                                    do {
                                        System.out.println("\nInput your name: ");
                                        name = sc.nextLine();// no tenga simbolos ni numeros

                                        if (acc.verifyName(name)) { // false = tiene simbolos o numeros
                                        } else {
                                            System.out.println("This entry cant contains numbers or characters");
                                        }
                                    } while (acc.verifyName(name) == false);

                                    do {
                                        System.out.println("Input your last name: ");
                                        lastName = sc.nextLine();// no tenga simbolos ni numeros
                                        if (acc.verifyName(lastName)) { // false = tiene simbolos o numeros
                                        } else {
                                            System.out.println("This entry cant contains numbers or characters");
                                        }
                                    } while (acc.verifyName(lastName) == false);

                                    do {

                                        System.out.println("Input your phone: ");
                                        phone = sc.nextLine();// n tenga simbolos ni letras y tenga 10 digitos
                                        if (acc.verifyNumber(phone) == false) {
                                            System.out.println(
                                                    "This entry cant contains numbers or characters and must contains 10 digits");
                                        }

                                    } while (acc.verifyNumber(phone) == false);

                                    do {
                                        System.out.println("Input your email: ");
                                        email = sc.nextLine();// que contenga @
                                        if (acc.verifyContainsArr(email) == false) { // true = si tiene @
                                            System.out.println("This entry must contains @");
                                        }
                                    } while (acc.verifyContainsArr(email) == false);

                                    do {
                                        System.out.println("Input your id");
                                        id = sc.nextLine();// Para estudiante que tenga 9 digitos ni letras y simbolos
                                        if (acc.verifyIdStudent(id) == false) {
                                            System.out.println(
                                                    "This entry cant contains characters and must contains 9 digits");
                                        }
                                    } while (acc.verifyIdStudent(id) == false); // para el resto 10 digitos id sin repetir

                                    System.out.println("You are an active or graduated student?\n1. Active\n2. Graduated");
                                    graduat = sc.nextLine();

                                    if (!graduat.equals("1") && !graduat.equals("2")) {// se valida la entrada de estado
                                        // estudiante
                                        while (!graduat.equals("1") && !graduat.equals("2")) {
                                            System.out.println("Please input a valid option: ");
                                            System.out.println(
                                                    "\nYou are an active or graduated student?\n1. Active\n2. Graduated");
                                            graduat = sc.nextLine();
                                        }
                                    }
                                    if (graduat.equals("2")) {
                                        egresado = true;
                                    }

                                    uSer = acc.createUser(name, lastName, contador);
                                    contador++;
                                    pAssword = acc.createPassword(phone, name);

                                    if (egresado != true) {

                                        acc.addStudent(name, lastName, phone, email, id, egresado, pAssword, uSer);

                                    } else {// se agrega información sobre el egresado

                                        String cargo = "", nombreEmpresa = "", estad = "";
                                        boolean estado = false;

                                        System.out.println("Do you currently have a job?\n1. Yes\n2. No");
                                        estad = sc.nextLine();

                                        if (!estad.equals("1") && !estad.equals("2")) {// se valida la entrada de estado
                                            // estudiante
                                            while (!estad.equals("1") && !estad.equals("2")) {
                                                System.out.println("Please input a valid option: ");
                                                System.out.println("Do you currently have a job?\n1. Yes\n2. No");
                                                estad = sc.nextLine();
                                            }
                                        }
                                        if (estad.equals("2")) {
                                            estado = false;
                                            nombreEmpresa = "################";
                                            cargo = "################";

                                        } else {
                                            estado = true;
                                            System.out.println("Input the company name: ");
                                            nombreEmpresa = sc.nextLine();

                                            System.out.println("Input your position in the company: ");
                                            cargo = sc.nextLine();

                                        }

                                        acc.addGraduated(name, lastName, phone, email, id, egresado, pAssword, uSer, estado,
                                                cargo, nombreEmpresa);

                                    }
                                    System.out.println("Your user is: " + uSer);
                                    System.out.println("Your password is: " + pAssword);
                                    break;

                                case "2":// Profesor

                                    do {
                                        System.out.println("\nInput your name: ");
                                        name = sc.nextLine();// no tenga simbolos ni numeros

                                        if (acc.verifyName(name)) { // false = tiene simbolos o numeros
                                        } else {
                                            System.out.println("This entry cant contains numbers or characters");
                                        }
                                    } while (acc.verifyName(name) == false);

                                    do {
                                        System.out.println("Input your last name: ");
                                        lastName = sc.nextLine();// no tenga simbolos ni numeros
                                        if (acc.verifyName(lastName)) { // false = tiene simbolos o numeros
                                        } else {
                                            System.out.println("This entry cant contains numbers or characters");
                                        }
                                    } while (acc.verifyName(lastName) == false);

                                    do {

                                        System.out.println("Input your phone: ");
                                        phone = sc.nextLine();// n tenga simbolos ni letras y tenga 10 digitos
                                        if (acc.verifyNumber(phone) == false) {
                                            System.out.println(
                                                    "This entry cant contains numbers or characters and must contains 10 digits");
                                        }

                                    } while (acc.verifyNumber(phone) == false);

                                    do {
                                        System.out.println("Input your email: ");
                                        email = sc.nextLine();// que contenga @
                                        if (acc.verifyContainsArr(email)) { // true = si tiene @
                                        } else {
                                            System.out.println("This entry must contains @");
                                        }
                                    } while (acc.verifyContainsArr(email) == false);

                                    do {
                                        System.out.println("Input your id");
                                        id = sc.nextLine();// Para estudiante que tenga 9 digitos ni letras y simbolos
                                        if (acc.verifyIdPersonal(id) == false) {
                                            System.out.println(
                                                    "This entry cant contains numbers or characters and must contains 9 digits");
                                        }
                                    } while (acc.verifyIdPersonal(id) == false);

                                    uSer = acc.createUser(name, lastName, contador);
                                    pAssword = acc.createPassword(phone, lastName);
                                    contador++;

                                    System.out.println("\nYou are a principal teacher?\n1. Yes\n2. No");
                                    director = sc.nextLine();

                                    if (!director.equals("1") && !director.equals("2")) {// se valida la entrada de
                                        // estado
                                        // estudiante
                                        while (!director.equals("1") && !director.equals("2")) {
                                            System.out.println("Please input a valid option: ");
                                            System.out.println("You are a principal teacher?\n1. Yes\n2. No");
                                            director = sc.nextLine();
                                        }
                                    }
                                    if (director.equals("1")) {
                                        direct = true;
                                    }

                                    System.out.println("Your user is: " + uSer);
                                    System.out.println("Your password is: " + pAssword);

                                    acc.addTeacher(name, lastName, phone, email, uSer, pAssword, id, direct);

                                    break;
                                case "3":// Secretaria

                                    do {
                                        System.out.println("\nInput your name: ");
                                        name = sc.nextLine();// no tenga simbolos ni numeros

                                        if (acc.verifyName(name)) { // false = tiene simbolos o numeros
                                        } else {
                                            System.out.println("This entry cant contains numbers or characters");
                                        }
                                    } while (acc.verifyName(name) == false);

                                    do {
                                        System.out.println("Input your last name: ");
                                        lastName = sc.nextLine();// no tenga simbolos ni numeros
                                        if (acc.verifyName(lastName)) { // false = tiene simbolos o numeros
                                        } else {
                                            System.out.println("This entry cant contains numbers or characters");
                                        }
                                    } while (acc.verifyName(lastName) == false);

                                    do {

                                        System.out.println("Input your phone: ");
                                        phone = sc.nextLine();// n tenga simbolos ni letras y tenga 10 digitos
                                        if (acc.verifyNumber(phone) == false) {
                                            System.out.println(
                                                    "This entry cant contains numbers or characters and must contains 10 digits");
                                        }

                                    } while (acc.verifyNumber(phone) == false);

                                    do {
                                        System.out.println("Input your email: ");
                                        email = sc.nextLine();// que contenga @
                                        if (acc.verifyContainsArr(email)) { // true = si tiene @
                                        } else {
                                            System.out.println("This entry must contains @");
                                        }
                                    } while (acc.verifyContainsArr(email) == false);

                                    do {
                                        System.out.println("Input your id");
                                        id = sc.nextLine();// Para estudiante que tenga 9 digitos ni letras y simbolos
                                        if (acc.verifyIdPersonal(id) == false) {
                                            System.out.println(
                                                    "This entry cant contains numbers or characters and must contains 9 digits");
                                        }
                                    } while (acc.verifyIdPersonal(id) == false);

                                    uSer = acc.createUser(name, lastName, contador);
                                    pAssword = acc.createPassword(phone, lastName);
                                    contador++;

                                    acc.addSecretary(name, lastName, phone, email, uSer, pAssword, id);

                                    System.out.println("Your user is: " + uSer);
                                    System.out.println("Your password is: " + pAssword);

                                    break;
                                default:
                                    System.out.println("Please select an valid option");
                                    break;
                            }
                        } else {
                            System.out.println("\nFirst login as admin to access to this option.");
                        }
                    } else {
                        System.out.println("First log in");
                    }
                    break;

                case "5":
                    if (cuentaEncontrada == null) {

                        System.out.println("- First log in!");
                    } else {
                        System.out.println("Logged out successfully!!");
                        cuentaEncontrada = null;
                    }
                    break;
                case "6":
                    System.out.println("----------------------------------------\n" + //
                            "Thanks you for visiting our module\n----------------------------------------\n" + //
                            "");

                    break;
                case "3":
                    if (cuentaEncontrada != null) {
                        if (cuentaEncontrada.equals("Secretary") || cuentaEncontrada.equals("Director")) {

                            System.out.println("\n                           Graduated Students Database: ");
                            System.out.println(
                                    " |   Id   |  Name  |   Last name  |  Phone  |   Email  |    Employability   |    Company   |    Position    |");
                            System.out.println(acc.showGraduatedAccounts());

                        } else {
                            System.out.println("\nFirst login as secretary or principal teacher to access to this option.");
                        }
                    } else {
                        System.out.println("First Log in");
                    }

                    break;

                default:
                    System.out.println("Please select an valid option");
                    break;
            }

        }

    }
}
