
package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Consulta;
import model.Medico;
import model.Paciente;


public class ConsultaData extends Conexao {
    
    public ConsultaData() throws SQLException, ClassNotFoundException {
        
    }
    
    public boolean incluir(Consulta obj) throws Exception {
        String sql = "Insert into consulta(codPaciente, codMedico, dataConsulta, horaConsulta) values (?, ?, ?, ?)";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1, obj.getPaciente().getCodPaciente());
        ps.setInt(2, obj.getMedico().getCodMedico());
        ps.setString(3, obj.getDataConsulta());
        ps.setString(4, obj.getHoraConsulta());
        return ps.executeUpdate() > 0;
    }
    
    public boolean editar(Consulta obj) throws Exception {
        String sql = "Update consulta set codPaciente = ?, codMedico = ?, dataConsulta = ?, horaConsulta = ? where idConsulta = ?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1, obj.getPaciente().getCodPaciente());
        ps.setInt(2, obj.getMedico().getCodMedico());
        ps.setString(3, obj.getDataConsulta());
        ps.setString(4, obj.getHoraConsulta());
        ps.setInt(5, obj.getIdConsulta());
        return ps.executeUpdate() > 0;
    }
    
    public boolean excluir(int idConsulta) throws Exception {
        String sql = "Delete from consulta where idConsulta = ?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1, idConsulta);
        return ps.executeUpdate() > 0;
    }
    
    public ArrayList<Consulta> pesquisar(String pesquisa) throws Exception {
        ArrayList<Consulta> lista = new ArrayList<>();
        String sql = "Select * from consulta con inner join paciente pac on (con.codPaciente = pac.codPaciente) inner join medico med on (con.codMedico = med.codMedico)";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Consulta con = new Consulta(rs.getInt("idConsulta"),
                    new Paciente(rs.getInt("codPaciente"), rs.getString("cpf"), rs.getString("nomePaciente"), rs.getString("telefone")),
                    new Medico(rs.getInt("codMedico"), rs.getString("nomeMedico"), rs.getString("crm"), rs.getString("email")),
                    rs.getString("dataConsulta"), rs.getString("horaConsulta"));
            lista.add(con);
        }
        return lista;
    }
    
}
