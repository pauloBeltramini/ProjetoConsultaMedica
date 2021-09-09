
package model;


public class Especialidade {
    
    private int id;
    private String descricao;
    private Medico medico;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Especialidade() { 
        id = 0;
        descricao = new String();
        medico = new Medico();
    }

    public Especialidade(int id, String descricao, Medico medico) {
        this.id = id;
        this.descricao = descricao;
        this.medico = medico;
    }
    
}
