package modelo.vo;

public class Requerimiento_1Vo {
    // Su código
    private Integer id_Lider;
    private Integer salario;
    private String ciudad;

    public Integer getID_Lider(){
        return id_Lider;
    }

    public void setID_Lider(Integer id_Lider){
        this.id_Lider = id_Lider;
    }

    public Integer getSalario(){
        return salario;
    }

    public void setSalario(Integer salario){
        this.salario = salario;
    }

    public String getCiudad(){
        return ciudad;
    }

    public void setCiudad(String ciudad){
        this.ciudad = ciudad;
    }
}
