/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Medico;

/**
 *
 * @author Paulo
 */
public class MedicoData extends Conexao {
    
     public MedicoData() throws SQLException, ClassNotFoundException {
        
    }
    
    public boolean incluir(Medico obj) throws Exception {
        String sql = "Insert into medico(nomeMedico, crm, email) values (?, ?, ?)";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, obj.getNomeMedico());
        ps.setString(2, obj.getCrm());
        ps.setString(3, obj.getEmail());
        return ps.executeUpdate() > 0;
    }
    
     public boolean editar(Medico obj) throws Exception {
        String sql = "Update medico set nomeMedico = ?, crm = ?, email = ?" + " where codMedico = ?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, obj.getNomeMedico());
        ps.setString(2, obj.getCrm());
        ps.setString(3, obj.getEmail());
        ps.setInt(4, obj.getCodMedico());
        return ps.executeUpdate() > 0;
    }
     
    public boolean excluir(int codMedico) throws Exception {
        String sql = "Delete from medico where codMedico = ?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1, codMedico);
        return ps.executeUpdate() > 0;
    }
    
    public ArrayList<Medico> pesquisar(String pesquisa) throws Exception {
        ArrayList<Medico> lista = new ArrayList<>();
        String sql = "Select * from medico where nomeMedico like '" + pesquisa + "%'";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Medico obj = new Medico(rs.getInt("codMedico"), rs.getString("nomeMedico"), rs.getString("crm"), rs.getString("email"));
            lista.add(obj);
        }
        return lista;
    }
    
    public ArrayList<Medico> carregarCombo() throws Exception {
        ArrayList<Medico> lista = new ArrayList<>();
        String sql = "Select * from medico order by nomeMedico";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Medico obj = new Medico(rs.getInt("codMedico"), rs.getString("nomeMedico"), rs.getString("crm"), rs.getString("email"));
            lista.add(obj);
        }
        return lista;
    }
    
}
