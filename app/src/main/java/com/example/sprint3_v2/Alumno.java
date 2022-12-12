package com.example.sprint3_v2;

public class Alumno {
    String documento;
    String estatura;
    String peso;
    String imc;

    public Alumno(String documento, String estatura, String peso, String imc) {
        this.documento = documento;
        this.estatura = estatura;
        this.peso = peso;
        this.imc = imc;
    }

    public Alumno() {
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getEstatura() {
        return estatura;
    }

    public void setEstatura(String estatura) {
        this.estatura = estatura;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getImc() {
        return imc;
    }

    public void setImc(String imc) {
        this.imc = imc;
    }
}
