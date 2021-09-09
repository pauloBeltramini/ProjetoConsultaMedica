
package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Endereco;
import model.Paciente;


public class EnderecoData extends Conexao {
    
     public EnderecoData() throws SQLException, ClassNotFoundException {
        
    }
    
    public boolean incluir(Endereco endereco) throws Exception {
        String sql = "Insert into endereco(rua, bairro, numero, cidade, estado, codpaciente) values (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, endereco.getRua());
        ps.setString(2, endereco.getBairro());
        ps.setInt(3, endereco.getNumero());
        ps.setString(4, endereco.getCidade());
        ps.setString(5, endereco.getEstado());
        ps.setInt(6, endereco.getPaciente().getCodPaciente());
        return ps.executeUpdate() > 0;
    }
    
    public boolean editar(Endereco endereco) throws Exception {
        String sql = "Update endereco set rua = ?, bairro = ?, numero = ?, cidade = ?, estado = ?, codpaciente = ?" 
                          + " where id = ?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, endereco.getRua());
        ps.setString(2, endereco.getBairro());
        ps.setInt(3, endereco.getNumero());
        ps.setString(4, endereco.getCidade());
        ps.setString(5, endereco.getEstado());
        ps.setInt(6, endereco.getPaciente().getCodPaciente());
        ps.setInt(7, endereco.getId());
        return ps.executeUpdate() > 0;
    }
    
    public boolean excluir(int id) throws Exception {
        String sql = "Delete from endereco where id = ?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1, id);
        return ps.executeUpdate() > 0;
    }
    
    public ArrayList<Endereco> pesquisar(String pesquisa) throws Exception {
        ArrayList<Endereco> lista = new ArrayList<>();
        String sql = "Select * from paciente pac inner join endereco end on (pac.codpaciente = end.codpaciente)";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Endereco endereco = new Endereco(rs.getInt("id"), rs.getString("rua"), rs.getString("bairro"),
                                                    rs.getInt("numero"), rs.getString("cidade"), rs.getString("estado"),
                                            new Paciente(rs.getInt("codpaciente"), rs.getString("cpf"), rs.getString("nomePaciente"), rs.getString("telefone")));
            lista.add(endereco);
        }
        return lista;
    }
    
}
