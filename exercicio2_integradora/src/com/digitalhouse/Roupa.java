package com.digitalhouse;

public class Roupa {


    private String tipo;

    private String tamanho;
    private boolean eNova;
    private boolean importada;

    public Roupa(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public boolean isNova() {
        return eNova;
    }

    public void setNova(boolean eNova) {
        this.eNova = eNova;
    }

    public boolean isImportada() {
        return importada;
    }

    public void setImportada(boolean importada) {
        this.importada = importada;
    }
}
