
package model;


public class Medico {
    
    private int codMedico;
    private String nomeMedico;
    private String crm;
    private String email;

    public int getCodMedico() {
        return codMedico;
    }

    public void setCodMedico(int codMedico) {
        this.codMedico = codMedico;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Medico() {
        codMedico = 0;
        nomeMedico = new String();
        crm = new String();
        email = new String();
    }

    public Medico(int codMedico, String nomeMedico, String crm, String email) {
        this.codMedico = codMedico;
        this.nomeMedico = nomeMedico;
        this.crm = crm;
        this.email = email;
    }
    
}
