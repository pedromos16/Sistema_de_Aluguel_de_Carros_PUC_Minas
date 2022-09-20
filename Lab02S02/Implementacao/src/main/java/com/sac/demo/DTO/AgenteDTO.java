package com.sac.demo.DTO;

import com.sac.demo.model.Agente;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

public class AgenteDTO implements Serializable {
    public static final long serialVersionUID = 13981723L;

    private Integer id;

    @NotEmpty
    @Size(min = 5, max = 15, message = "Tamanho minimo: 5 caracteres")
    private String usuario;

    @NotEmpty
    @Size(min = 5, max = 15, message = "Tamanho minimo: 5 caracteres")
    private String senha;

    public AgenteDTO(Agente obj){
        this.id = obj.getId();
        this.usuario = obj.getUsuario();
        this.senha = obj.getSenha();
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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
