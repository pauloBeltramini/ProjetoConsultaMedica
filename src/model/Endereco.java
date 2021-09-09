
package model;


public class Endereco {
    
    private int id;
    private String rua;
    private String bairro;
    private int numero;
    private String cidade;
    private String estado;
    private Paciente paciente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Endereco() {
        id = 0;
        rua = new String();
        bairro = new String();
        numero = 0;
        cidade = new String();
        estado = new String();
        paciente = new Paciente();
    }

    public Endereco(int id, String rua, String bairro, int numero, String cidade, String estado, Paciente paciente) {
        this.id = id;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.paciente = paciente;
    }
    
}
