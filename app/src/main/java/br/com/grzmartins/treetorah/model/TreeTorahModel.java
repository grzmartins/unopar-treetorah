package br.com.grzmartins.treetorah.model;

public class TreeTorahModel {

    public int id;
    public int ano;
    public String estado;
    public int arvoresCortadas;
    public int arvoresRepostas;
    public int volume;
    public int valor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getArvoresCortadas() {
        return arvoresCortadas;
    }

    public void setArvoresCortadas(int arvoresCortadas) {
        this.arvoresCortadas = arvoresCortadas;
    }

    public int getArvoresRepostas() {
        return arvoresRepostas;
    }

    public void setArvoresRepostas(int arvoresRepostas) {
        this.arvoresRepostas = arvoresRepostas;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
