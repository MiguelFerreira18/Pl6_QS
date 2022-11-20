package org.example;

public class Nota {
    private int numALuno;
    private double nota;

    public Nota(int numALuno, double nota) {
        this.numALuno = numALuno;
        this.nota = nota;
    }

    public int getNumALuno() {
        return numALuno;
    }

    public void setNumALuno(int numALuno) {
        this.numALuno = numALuno;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Nota{" +
                "numALuno=" + numALuno +
                ", nota=" + nota +
                '}';
    }
}
