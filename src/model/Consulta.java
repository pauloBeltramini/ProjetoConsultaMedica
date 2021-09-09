
package model;


public class Consulta {
    
    private int idConsulta;
    private Paciente paciente;
    private Medico medico;
    private String dataConsulta;
    private String horaConsulta;

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public String getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(String dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getHoraConsulta() {
        return horaConsulta;
    }

    public void setHoraConsulta(String horaConsulta) {
        this.horaConsulta = horaConsulta;
    }

    public Consulta() {
        idConsulta = 0;
        paciente = new Paciente();
        medico = new Medico();
        dataConsulta = new String();
        horaConsulta = new String();
    }

    public Consulta(int idConsulta, Paciente paciente, Medico medico, String dataConsulta, String horaConsulta) {
        this.idConsulta = idConsulta;
        this.paciente = paciente;
        this.medico = medico;
        this.dataConsulta = dataConsulta;
        this.horaConsulta = horaConsulta;
    }
    
}
