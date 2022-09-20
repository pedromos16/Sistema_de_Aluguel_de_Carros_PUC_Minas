package com.sac.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Agente extends Usuario implements Serializable {
    public static final long serialVersionUID = 371343683L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String obsAvaliacao;

    @OneToMany(mappedBy = "agente")
    private List<Cliente> clienteList;

    public Agente(String usuario, String senha, String obsAvaliacao, List<Cliente> clienteList) {
        super(usuario, senha);
        this.id = null;
        this.obsAvaliacao = obsAvaliacao;
        this.clienteList = clienteList;
    }
    public Agente(Integer id, String usuario, String senha) {
        super(usuario, senha);
        this.id = id;
        this.clienteList = new ArrayList<>();
    }

    public String getObsAvaliacao() {
        return obsAvaliacao;
    }

    public void setObsAvaliacao(String obsAvaliacao) {
        this.obsAvaliacao = obsAvaliacao;
    }

    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Agente)) return false;
        Agente agente = (Agente) o;
        return id.equals(agente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
