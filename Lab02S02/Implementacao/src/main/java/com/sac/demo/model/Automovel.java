package com.sac.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Automovel implements Serializable {
    public static final long serialVersionUID = 3712354283L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String matricula;
    @Column
    private Integer ano;
    @Column
    private String marca;
    @Column
    private String modelo;
    @Column
    private String placa;

    public Automovel(String matricula, Integer ano, String marca,
                     String modelo, String placa) {
        this.matricula = matricula;
        this.ano = ano;
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Automovel)) return false;
        Automovel automovel = (Automovel) o;
        return getId().equals(automovel.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
