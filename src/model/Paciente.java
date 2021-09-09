
package model;


public class Paciente {
    
    private int codPaciente;
    private String cpf;
    private String nomePaciente;
    private String telefone;

    public int getCodPaciente() {
        return codPaciente;
    }

    public void setCodPaciente(int codPaciente) {
        this.codPaciente = codPaciente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Paciente() {
        codPaciente = 0;
        cpf = new String();
        nomePaciente = new String();
        telefone = new String();
    }

    public Paciente(int codPaciente, String cpf, String nomePaciente, String telefone) {
        this.codPaciente = codPaciente;
        this.cpf = cpf;
        this.nomePaciente = nomePaciente;
        this.telefone = telefone;
    }
    
}
