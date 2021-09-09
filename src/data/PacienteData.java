
package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Paciente;


public class PacienteData extends Conexao {
    
    public PacienteData() throws SQLException, ClassNotFoundException {
        
    }
    
    public boolean incluir(Paciente obj) throws Exception {
        String sql = "Insert into paciente(cpf, nomePaciente, telefone) values (?, ?, ?)";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, obj.getCpf());
        ps.setString(2, obj.getNomePaciente());
        ps.setString(3, obj.getTelefone());
        return ps.executeUpdate() > 0;
    }
    
    public boolean excluir(int codPaciente) throws Exception {
        String sql = "Delete from paciente where codPaciente = ?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1, codPaciente);
        return ps.executeUpdate() > 0;
    }
    
    public boolean editar(Paciente obj) throws Exception {
        String sql = "Update paciente set cpf = ?, nomePaciente = ?, telefone = ?" + " where codPaciente = ?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, obj.getCpf());
        ps.setString(2, obj.getNomePaciente());
        ps.setString(3, obj.getTelefone());
        ps.setInt(4, obj.getCodPaciente());
        return ps.executeUpdate() > 0;
    }
    
    public ArrayList<Paciente> pesquisar(String pesquisar) throws Exception {
        ArrayList<Paciente> lista = new ArrayList<>();
        String sql = "Select * from paciente where nomePaciente like '" + pesquisar +"%'";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Paciente obj = new Paciente(rs.getInt("codPaciente"), rs.getString("cpf"), rs.getString("nomePaciente"), rs.getString("telefone"));
            lista.add(obj);
        }
        return lista;
    }
    
    public ArrayList<Paciente> carregarCombo() throws Exception {
        ArrayList<Paciente> lista = new ArrayList<>();
        String sql = "Select * from paciente order by nomePaciente";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Paciente obj = new Paciente(rs.getInt("codPaciente"), rs.getString("cpf"), rs.getString("nomePaciente"), rs.getString("telefone"));
            lista.add(obj);
        }
        return lista;
    }
    
}
