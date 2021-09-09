
package data;

import java.sql.PreparedStatement;


public class TesteConexao {
    
    public static void main(String[] args) {
        try {
            Conexao c = new Conexao();
            System.out.println("Conexão OK!");
            System.out.println("Inserindo dados na tabela usuario");
            String sql = "Insert into usuario(id, nome, usuario, senha, tipo)" +
                              " values (1, 'Paulo Beltramini', 'paulo', '12345', 1)";
            PreparedStatement ps = c.getConexao().prepareStatement(sql);
            if (ps.executeUpdate() > 0) {
                System.out.println("Gravado!");
            }
            else {
                System.out.println("Não foi possível atualizar!");
            }
        } catch (Exception e) {
            System.out.println("Erro na conexão: " + e.getMessage());
        }
    }
    
}
