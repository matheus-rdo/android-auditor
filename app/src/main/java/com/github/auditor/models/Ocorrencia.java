package com.github.auditor.models;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.Objects;

public class Ocorrencia implements Serializable {

    private String codigo;

    private String ocorrencia;

    private String providencia;

    private Tipo tipo;

    public Ocorrencia() {

    }

    public Ocorrencia(String codigo, String ocorrencia, String providencia, Tipo tipo) {
        this.codigo = codigo;
        this.ocorrencia = ocorrencia;
        this.providencia = providencia;
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getOcorrencia() {
        return ocorrencia;
    }

    public void setOcorrencia(String ocorrencia) {
        this.ocorrencia = ocorrencia;
    }

    public String getProvidencia() {
        return providencia;
    }

    public void setProvidencia(String providencia) {
        this.providencia = providencia;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public enum Tipo {
        OK, NOK;
    }

    @Override
    public String toString() {
        return "Ocorrencia{" +
                "codigo='" + codigo + '\'' +
                ", ocorrencia='" + ocorrencia + '\'' +
                ", tipo=" + tipo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ocorrencia that = (Ocorrencia) o;
        return codigo.equals(that.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
