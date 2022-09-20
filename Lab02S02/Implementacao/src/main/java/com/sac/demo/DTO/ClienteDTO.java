package com.sac.demo.DTO;

import com.sac.demo.model.Cliente;
import com.sac.demo.model.PedidoAluguel;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;


public class ClienteDTO implements Serializable {
    public static final long serialVersionUID = 3128741L;

    private Integer id;

    private String rg;
    private String cpf;
    private String nome;

    private String usuario;
    private String endereco;
    private String profissao;
    private String entidadeEmpregadora;
    private String rendimento;

    List<PedidoAluguel> pedidoAluguelList;

    public ClienteDTO(Cliente obj){
        this.id = obj.getId();
        this.rg = obj.getRg();
        this.cpf = obj.getCpf();
        this.nome = obj.getNome();
        this.usuario = obj.getUsuario();
        this.pedidoAluguelList = obj.getPedidoAluguelList();
        this.endereco = obj.getEndereco();
        this.profissao = obj.getProfissao();
        this.entidadeEmpregadora = obj.getEntidadeEmpregadora();
        this.rendimento = obj.getRendimento();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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
        if (!(o instanceof ClienteDTO)) return false;
        ClienteDTO that = (ClienteDTO) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
