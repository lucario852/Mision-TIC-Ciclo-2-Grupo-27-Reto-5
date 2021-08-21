package modelo.vo;

public class Requerimiento_2Vo {
    // Su código

    private Integer id_proyecto;
    private String nombre_material;
    private String importado;

    public Integer getID_Proyecto(){
        return id_proyecto;
    }

    public void setID_Proyecto(Integer id_proyecto){
        this.id_proyecto = id_proyecto;
    }

    public String getNombre_Material(){
        return nombre_material;
    }

    public void setNombre_Material(String nombre_material){
        this.nombre_material = nombre_material;
    }

    public String getImportado(){
        return importado;
    }

    public void setImportado(String importado){
        this.importado = importado;
    }
}
