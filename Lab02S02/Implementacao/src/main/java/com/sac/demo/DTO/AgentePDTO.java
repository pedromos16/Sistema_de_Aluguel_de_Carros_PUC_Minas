package com.sac.demo.DTO;

import com.sac.demo.model.Agente;
import com.sac.demo.model.Cliente;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class AgentePDTO implements Serializable {
    public static final long serialVersionUID = 13981723L;

    private Integer id;

    @NotEmpty
    @Size(min = 5, max = 15, message = "Tamanho minimo: 5 caracteres")
    private String usuario;

    @NotEmpty
    @Size(min = 5, max = 15, message = "Tamanho minimo: 5 caracteres")
    private String senha;

    private String obsAvaliacao;

    public AgentePDTO(){}

    public AgentePDTO(Agente obj){
        this.id = obj.getId();
        this.usuario = obj.getUsuario();
        this.obsAvaliacao = obj.getObsAvaliacao();
        this.usuario = obj.getUsuario();
        this.senha = obj.getSenha();
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getObsAvaliacao() {
        return obsAvaliacao;
    }

    public void setObsAvaliacao(String obsAvaliacao) {
        this.obsAvaliacao = obsAvaliacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AgentePDTO)) return false;
        AgentePDTO that = (AgentePDTO) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
