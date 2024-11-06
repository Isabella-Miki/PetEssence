package br.com.petEssence.model;

public class Pet {
    
    private int idPet;
    private String nomePet;
    private Especie especie;
    private Raca raca;
    private String situacao;
    
    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }


    public int getIdPet() {
        return idPet;
    }

    public void setIdPet(int idPet) {
        this.idPet = idPet;
    }

    public String getNomePet() {
        return nomePet;
    }

    public void setNomePet(String nomePet) {
        this.nomePet = nomePet;
    }

    public Raca getRaca() {
        return raca;
    }

    public void setRaca(Raca raca) {
        this.raca = raca;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    
    public Pet (int idPet, String nomePet, Especie especie, Raca raca, String situacao) {
        this.idPet = idPet;
        this.nomePet = nomePet;
        this.especie = especie;
        this.raca = raca;
        this.situacao = situacao;
    }
    
    public Pet() {
        this.idPet = 0;
        this.nomePet = "";
        this.situacao = "A";
        this.especie = new Especie();
        this.raca = new Raca();
    }
    
}
