package com.sac.demo.DTO;

import com.sac.demo.model.Agente;
import com.sac.demo.model.Cliente;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class AgenteDTO implements Serializable {
    public static final long serialVersionUID = 13981723L;

    private Integer id;

    private String usuario;

    private List<Cliente> clienteList;

    private String obsAvaliacao;

    public AgenteDTO(){}

    public AgenteDTO(Agente obj){
        this.id = obj.getId();
        this.usuario = obj.getUsuario();
        this.clienteList = obj.getClienteList();
        this.obsAvaliacao = obj.getObsAvaliacao();
        this.usuario = obj.getUsuario();
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

    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
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
        if (!(o instanceof AgenteDTO)) return false;
        AgenteDTO agenteDTO = (AgenteDTO) o;
        return getId().equals(agenteDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
