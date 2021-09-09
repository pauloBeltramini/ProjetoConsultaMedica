
package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Especialidade;
import model.Medico;


public class EspecialidadeData extends Conexao {
    
    public EspecialidadeData() throws SQLException, ClassNotFoundException {
        
    }
    
    public boolean incluir(Especialidade especialidade) throws Exception {
        String sql = "Insert into especialidade(descricao, codMedico) values (?, ?)";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, especialidade.getDescricao());
        ps.setInt(2, especialidade.getMedico().getCodMedico());
        return ps.executeUpdate() > 0;
    }
    
    public boolean editar(Especialidade especialidade) throws Exception {
        String sql = "Update especialidade set descricao = ?, codMedico = ? where id = ?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, especialidade.getDescricao());
        ps.setInt(2, especialidade.getMedico().getCodMedico());
        ps.setInt(3, especialidade.getId());
        return ps.executeUpdate() > 0;
    }
    
    public boolean excluir(int id) throws Exception {
        String sql = "Delete from especialidade where id = ?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1, id);
        return ps.executeUpdate() > 0;
    }
    
    public ArrayList<Especialidade> pesquisar(String pesquisa) throws Exception {
        ArrayList<Especialidade> lista = new ArrayList<>();
        String sql = "Select * from medico med inner join especialidade esp on (med.codMedico = esp.codMedico)";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Especialidade especialidade = new Especialidade(rs.getInt("id"), rs.getString("descricao"),
                                                           new Medico(rs.getInt("codMedico"), rs.getString("nomeMedico"), rs.getString("crm"), rs.getString("email")));
            lista.add(especialidade);
        }
        return lista;
    }
    
}
