package com.sac.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Cliente extends Usuario implements Serializable {
    public static final long serialVersionUID = 371231283L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "cliente")
    private List<PedidoAluguel> pedidoAluguelList;

    @ManyToOne
    private Agente agente;
    @Column
    private String rg;
    @Column
    private String cpf;
    @Column
    private String nome;
    @Column
    private String endereco;
    @Column
    private String profissao;
    @Column
    private String entidadeEmpregadora;
    @Column
    private String rendimento;


    public Cliente(String usuario, String senha){
        super(usuario, senha);
    }

    public Cliente(String usuario, String senha, String rg, String cpf,
                   String nome, String endereco, String profissao,
                   String entidadeEmpregadora, String rendimento) {
        super(usuario, senha);
        this.id = null;
        this.rg = rg;
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.profissao = profissao;
        this.entidadeEmpregadora = entidadeEmpregadora;
        this.rendimento = rendimento;
    }


    public Cliente(Integer id, String usuario, String senha, String rg, String cpf,
                   String nome, String endereco, String profissao,
                   String entidadeEmpregadora, String rendimento) {
        super(usuario, senha);
        this.id = id;
        this.rg = rg;
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.profissao = profissao;
        this.entidadeEmpregadora = entidadeEmpregadora;
        this.rendimento = rendimento;
    }

    public Agente getAgente() {
        return agente;
    }

    public void setAgente(Agente agente) {
        this.agente = agente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public List<PedidoAluguel> getPedidoAluguelList() {
        return pedidoAluguelList;
    }

    public void setPedidoAluguelList(List<PedidoAluguel> pedidoAluguelList) {
        this.pedidoAluguelList = pedidoAluguelList;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getEntidadeEmpregadora() {
        return entidadeEmpregadora;
    }

    public void setEntidadeEmpregadora(String entidadeEmpregadora) {
        this.entidadeEmpregadora = entidadeEmpregadora;
    }

    public String getRendimento() {
        return rendimento;
    }

    public void setRendimento(String rendimento) {
        this.rendimento = rendimento;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        Cliente cliente = (Cliente) o;
        return getId().equals(cliente.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
