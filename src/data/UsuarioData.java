
package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Usuario;


public class UsuarioData extends Conexao {
    
    public UsuarioData() throws SQLException, ClassNotFoundException {
        
    }
    
    public boolean incluir(Usuario obj) throws Exception {
        String sql = "Insert into usuario (nome, usuario, senha, tipo) values (?, ?, ?, ?)";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, obj.getNome());
        ps.setString(2, obj.getUsuario());
        ps.setString(3, obj.getSenha());
        ps.setInt(4, obj.getTipo());
        return ps.executeUpdate() > 0;
    }
    
    public boolean excluir(int id) throws Exception {
        String sql = "Delete from usuario where id = ?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1, id);
        return ps.executeUpdate() > 0;
    }
    
    public boolean editar(Usuario obj) throws Exception {
        String sql = "Update usuario set nome = ?, usuario = ?, senha = ?, tipo = ?" + " where id = ?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, obj.getNome());
        ps.setString(2, obj.getUsuario());
        ps.setString(3, obj.getSenha());
        ps.setInt(4, obj.getTipo());
        ps.setInt(5, obj.getId());
        return ps.executeUpdate() > 0;
    }
    
    public ArrayList<Usuario> pesquisar(String pesquisa) throws Exception {
        ArrayList<Usuario> lista = new ArrayList<>();
        String sql = "Select * from usuario where nome like '" + pesquisa + "%'";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Usuario obj = new Usuario(rs.getInt("id"), rs.getString("nome"), rs.getString("usuario"), rs.getString("senha"), rs.getInt("tipo"));
            lista.add(obj);
        }
        return lista;
    }
    
    public Usuario validarUsuario(String usuario, String senha) throws Exception {
        String sql = "Select * from usuario where usuario = ? and senha = ?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, usuario);
        ps.setString(2, senha);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Usuario obj = new Usuario();
            obj.setId(rs.getInt("id"));
            obj.setNome(rs.getString("nome"));
            obj.setUsuario(rs.getString("usuario"));
            obj.setSenha(rs.getString("senha"));
            obj.setTipo(rs.getInt("tipo"));
            return obj;
        }
        else {
            return null;
        }
    }
    
}
