package br.com.petEssence.model;

import br.com.petEssence.utils.Conversao;
import java.time.LocalTime;
import java.util.Date;

public class Atendimento {

    private int idAtendimento;
    private String descricao, nomeVeterinario;
    private Pet pet;
    private Date dataAtendimento;
    private LocalTime horario, duracao;
    private double valor;

    public Atendimento(int idAtendimento, String descricao, String nomeVeterinario, Pet pet, Date dataAtendimento, LocalTime horario, LocalTime duracao, double valor) {
        this.idAtendimento = idAtendimento;
        this.descricao = descricao;
        this.nomeVeterinario = nomeVeterinario;
        this.pet = pet;
        this.dataAtendimento = dataAtendimento;
        this.horario = horario;
        this.duracao = duracao;
        this.valor = valor;
    }

    public Atendimento() {
        this.idAtendimento = 0;
        this.descricao = "";
        this.nomeVeterinario = "";
        this.pet = new Pet();
        this.dataAtendimento = Conversao.dataAtual();
        this.horario = Conversao.horaAtual();
        this.duracao = Conversao.horaAtual();
        this.valor = 0;
    }

    public int getIdAtendimento() {
        return idAtendimento;
    }

    public void setIdAtendimento(int idAtendimento) {
        this.idAtendimento = idAtendimento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNomeVeterinario() {
        return nomeVeterinario;
    }

    public void setNomeVeterinario(String nomeVeterinario) {
        this.nomeVeterinario = nomeVeterinario;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Date getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(Date dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public LocalTime getDuracao() {
        return duracao;
    }

    public void setDuracao(LocalTime duracao) {
        this.duracao = duracao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

}
