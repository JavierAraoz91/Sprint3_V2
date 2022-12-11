package com.example.sprint3_v2;

public class Alumno {
    String nombre;
    String curso;
    int peso;
    int image;

    public Alumno(String nombre, String curso, int peso, int image) {
        this.nombre = nombre;
        this.curso = curso;
        this.peso = peso;
        this.image = image;
    }

    public Alumno() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
