package modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.vo.Requerimiento_3Vo;
import util.JDBCUtilities;

public class Requerimiento_3Dao {
    public ArrayList<Requerimiento_3Vo> requerimiento3() throws SQLException {
        var response = new ArrayList<Requerimiento_3Vo>();
        String consulta = "SELECT ID_Proyecto ,Proveedor"
                        +" FROM  Compra c"
                        +" WHERE ID_Proyecto BETWEEN 120 AND 124"
                        +" ORDER BY ID_Proyecto ASC;";

        
        try(var connection = JDBCUtilities.getConnection();
        var statment = connection.prepareStatement(consulta);
        var rset = statment.executeQuery()) 
        {
            while(rset.next())
            {
                var requerimiento_3VO = new Requerimiento_3Vo();
                requerimiento_3VO.setID_Proyecto(rset.getInt("ID_Proyecto"));
                requerimiento_3VO.setProveedor(rset.getString("Proveedor"));

                response.add(requerimiento_3VO);
            }    


        }          
        return response;
    }
}