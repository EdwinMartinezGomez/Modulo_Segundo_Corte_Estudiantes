package co.edu.uptc.controller;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import co.edu.uptc.model.*;
import java.io.*;
import java.util.List;
public class FileControl {
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private FileWriter fw;
    private BufferedReader br;
    private File file;
    public static final String path = "src\\main\\java\\co\\edu\\uptc\\persistence\\";

    public static final String ext = ".json";


    public boolean writeFile(String fileName, Object obj) {
        file = new File(fileName);
        String json = gson.toJson(obj);
        try {
            fw = new FileWriter(path + fileName + ext, true);

            //Si el archivo el vacio añadimos corchetes []
            if (putKey(file)) {
                fw.write("[\n");
            } else {
                deleteCorchete(file);
                fw.write(",");
            }
            fw.write(json);
            fw.write("\n]");
            fw.close();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean putKey(File file) {
        try {
            br = new BufferedReader(new FileReader(path + file + ext));
            if (br.readLine() == null) {
                br.close();
                return true;
            }
            br.close();

        } catch (Exception e) {

        }
        return false;
    }

    public void deleteCorchete(File file) {
        try {

            //Extraemos el tamaño del archivo y lo seteamos con una linea menos para eliminar el ultimo corchete
            RandomAccessFile raf = new RandomAccessFile(path + file + ext, "rw");
            Long size = raf.length();
            raf.setLength(size - 1);
            raf.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public List<Student> readFileStudents(String namefile) {
        file = new File(namefile);
        List<Student> aux = null;

        try (Reader reader = new FileReader(path + namefile + ext)) {

            aux = gson.fromJson(reader, new TypeToken<List<Student>>() {
            }.getType());


        } catch (IOException e) {
            e.printStackTrace();
        }


        return aux;
    }

    public List<Graduated> readFileStudentsGraduated(String namefile) {
        file = new File(namefile);
        List<Graduated> aux = null;

        try (Reader reader = new FileReader(path + namefile + ext)) {

            aux = gson.fromJson(reader, new TypeToken<List<Graduated>>() {
            }.getType());


        } catch (IOException e) {
            e.printStackTrace();
        }


        return aux;
    }

    public List<Admin> readFileAdmins(String namefile) {
        file = new File(namefile);
        List<Admin> aux = null;

        try (FileReader reader = new FileReader(path + namefile + ext)) {

            aux = gson.fromJson(reader, new TypeToken<List<Admin>>() {
            }.getType());


        } catch (IOException e) {
            e.printStackTrace();
        }


        return aux;
    }

    public List<Teacher> readFileTeachers(String namefile) {
        file = new File(namefile);
        List<Teacher> aux = null;

        try (Reader reader = new FileReader(path + namefile + ext)) {

            aux = gson.fromJson(reader, new TypeToken<List<Teacher>>() {
            }.getType());


        } catch (IOException e) {
            e.printStackTrace();
        }


        return aux;
    }

    public List<Secretary> readFileSecretary(String namefile) {
        file = new File(namefile);
        List<Secretary> aux = null;

        try (Reader reader = new FileReader(path + namefile + ext)) {

            aux = gson.fromJson(reader, new TypeToken<List<Secretary>>() {
            }.getType());


        } catch (IOException e) {
            e.printStackTrace();
        }


        return aux;
    }


    }

