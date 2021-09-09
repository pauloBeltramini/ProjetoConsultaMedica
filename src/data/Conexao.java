
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {
    
    private Connection con;
    
    public Connection getConexao() {
        return con;
    }
    
    public Conexao() throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/bdConsultaMedica?zeroDateTimeBehavior=convertToNull";
        String driver = "com.mysql.jdbc.Driver";
        Class.forName(driver); // Carrega a classe do driver
        con = DriverManager.getConnection(url, "root", "paulo#");
    }
}
