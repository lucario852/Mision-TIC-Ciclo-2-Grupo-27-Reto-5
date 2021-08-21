package modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.vo.Requerimiento_2Vo;
import util.JDBCUtilities;

public class Requerimiento_2Dao {
    public ArrayList<Requerimiento_2Vo> requerimiento2() throws SQLException {
        // Su código

        var response = new ArrayList<Requerimiento_2Vo>();
        String consulta = "SELECT p.ID_Proyecto ,mc.Nombre_Material,mc.Importado"
                        +" FROM Compra c, MaterialConstruccion mc, Proyecto p"
                        +" WHERE p.ID_Proyecto = c.ID_Proyecto AND c.ID_MaterialConstruccion = mc.ID_MaterialConstruccion AND p.ID_Proyecto IN (1,184,400)"
                        +" ORDER BY p.ID_Proyecto ASC;";

        
        try(var connection = JDBCUtilities.getConnection();
        var statment = connection.prepareStatement(consulta);
        var rset = statment.executeQuery()) 
        {
            while(rset.next())
            {
                var requerimiento_2VO = new Requerimiento_2Vo();
                requerimiento_2VO.setID_Proyecto(rset.getInt("ID_Proyecto"));
                requerimiento_2VO.setNombre_Material(rset.getString("Nombre_Material"));
                requerimiento_2VO.setImportado(rset.getString("Importado"));

                response.add(requerimiento_2VO);
            }    


        }          
        return response;
    }
}