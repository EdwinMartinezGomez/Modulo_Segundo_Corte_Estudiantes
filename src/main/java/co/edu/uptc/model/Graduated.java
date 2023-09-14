package co.edu.uptc.model;

public class Graduated  extends Student {
    private boolean estadoEmp;
    private String nombEmpresa;
    private String cargo;

    public Graduated() {

    }

    public Graduated(boolean estadoEmp, String nombEmpresa, String cargo) {
        this.estadoEmp = estadoEmp;
        this.nombEmpresa = nombEmpresa;
        this.cargo = cargo;
    }

    public Graduated(String id, boolean egresado, boolean estadoEmp, String nombEmpresa, String cargo) {
        super(id, egresado);
        this.estadoEmp = estadoEmp;
        this.nombEmpresa = nombEmpresa;
        this.cargo = cargo;
    }

    public Graduated(String name, String lastName, String phone, String email, Account account, String id,
                     boolean egresado, boolean estadoEmp, String nombEmpresa, String cargo) {
        super(name, lastName, phone, email, account, id, egresado);
        this.estadoEmp = estadoEmp;
        this.nombEmpresa = nombEmpresa;
        this.cargo = cargo;
    }

    public boolean isEstadoEmp() {
        return estadoEmp;
    }

    public void setEstadoEmp(boolean estadoEmp) {
        this.estadoEmp = estadoEmp;
    }

    public String getNombEmpresa() {
        return nombEmpresa;
    }

    public void setNombEmpresa(String nombEmpresa) {
        this.nombEmpresa = nombEmpresa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Graduated [estadoEmp=" + estadoEmp + ", nombEmpresa=" + nombEmpresa + ", cargo=" + cargo + "]";
    }

}
