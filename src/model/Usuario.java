
package model;


public class Usuario {
    
    private int id;
    private String nome; 
    private String usuario;
    private String senha;
    private int tipo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Usuario() {
        id = 0;
        nome = new String();
        usuario = new String();
        senha = new String();
        tipo = 0;
    }

    public Usuario(int id, String nome, String usuario, String senha, int tipo) {
        this.id = id;
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.tipo = tipo;
    }
    
}
