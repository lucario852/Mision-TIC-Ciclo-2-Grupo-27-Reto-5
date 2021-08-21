package modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.vo.Requerimiento_1Vo;
import util.JDBCUtilities;

public class Requerimiento_1Dao {
    public ArrayList<Requerimiento_1Vo> requerimiento1() throws SQLException {
        var response = new ArrayList<Requerimiento_1Vo>();
        String consulta = "SELECT l.ID_Lider , l.Salario, l.Ciudad_Residencia"
                        +" FROM Lider l"
                        +" WHERE Salario >(SELECT MIN(Salario) FROM Lider l2) AND Ciudad_Residencia ='Barranquilla'"
                        +" ORDER BY l.Salario ASC;";

        
        try(var connection = JDBCUtilities.getConnection();
        var statment = connection.prepareStatement(consulta);
        var rset = statment.executeQuery()) 
        {
            while(rset.next())
            {
                var requerimiento_1VO = new Requerimiento_1Vo();
                requerimiento_1VO.setID_Lider(rset.getInt("ID_Lider"));
                requerimiento_1VO.setSalario(rset.getInt("Salario"));
                requerimiento_1VO.setCiudad(rset.getString("Ciudad_Residencia"));

                response.add(requerimiento_1VO);
            }    


        }          
        return response;
    }
}