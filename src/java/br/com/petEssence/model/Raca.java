package br.com.petEssence.model;

public class Raca {
    
    private int idRaca;
    private String nomeRaca;

    public int getIdRaca() {
        return idRaca;
    }

    public void setIdRaca(int idRaca) {
        this.idRaca = idRaca;
    }

    public String getNomeRaca() {
        return nomeRaca;
    }

    public void setNomeRaca(String nomeRaca) {
        this.nomeRaca = nomeRaca;
    }
    
    public Raca(int idRaca, String nomeRaca) {
        this.idRaca = idRaca;
        this.nomeRaca = nomeRaca;
    }

    public Raca() {
        this.idRaca = 0;
        this.nomeRaca = "";
    }
}
