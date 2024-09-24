package br.com.petEssence.model;

public class Especie {
    private int idEspecie;
    private String nomeEspecie;

    public int getIdEspecie() {
        return idEspecie;
    }

    public void setIdEspecie(int idEspecie) {
        this.idEspecie = idEspecie;
    }

    public String getNomeEspecie() {
        return nomeEspecie;
    }

    public void setNomeEspecie(String nomeEspecie) {
        this.nomeEspecie = nomeEspecie;
    }

    public Especie(int idEspecie, String nomeEspecie) {
        this.idEspecie = idEspecie;
        this.nomeEspecie = nomeEspecie;
    }

    public Especie() {
        this.idEspecie = 0;
        this.nomeEspecie = "";
    }
}
