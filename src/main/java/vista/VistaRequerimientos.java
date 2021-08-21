package vista;

import java.util.ArrayList;

import controlador.ControladorRequerimientos;
import modelo.vo.Requerimiento_1Vo;
import modelo.vo.Requerimiento_2Vo;
import modelo.vo.Requerimiento_3Vo;

public class VistaRequerimientos {

    public static final ControladorRequerimientos controlador = new ControladorRequerimientos();

    public static void requerimiento1() {
        try {
            // Su código
            ArrayList<Requerimiento_1Vo> requerimiento_1s = controlador.consultarRequerimiento1();

            for (Requerimiento_1Vo requerimiento_1 : requerimiento_1s){
                System.out.printf("%d %d %s %n", requerimiento_1.getID_Lider(), requerimiento_1.getSalario(), requerimiento_1.getCiudad());
            }
        } catch (Exception e) {
            System.out.println("Se ha producido el siguiente error:" + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void requerimiento2() {
        try {
            // Su código
            ArrayList<Requerimiento_2Vo> requerimiento_2s = controlador.consultarRequerimiento2();
            for (Requerimiento_2Vo requerimiento_2 : requerimiento_2s){
                System.out.printf("%d %s %s %n", requerimiento_2.getID_Proyecto(), requerimiento_2.getNombre_Material(), requerimiento_2.getImportado());
            }
        } catch (Exception e) {
            System.out.println("Se ha producido el siguiente error:" + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void requerimiento3() {
        try {
            // Su código
            ArrayList<Requerimiento_3Vo> requerimiento_3s = controlador.consultarRequerimiento3();
            for (Requerimiento_3Vo requerimiento_3 : requerimiento_3s){
                System.out.printf("%d %s %n", requerimiento_3.getID_Proyecto(), requerimiento_3.getProveedor());
            }
        } catch (Exception e) {
            System.out.println("Se ha producido el siguiente error:" + e.getMessage());
            e.printStackTrace();
        }
    }

}
