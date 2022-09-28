package com.sac.demo.DTO.Request;

import com.sac.demo.model.Agente;
import com.sac.demo.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgenteRequestDTO implements Serializable {
    public static final long serialVersionUID = 13981723L;

    private String usuario;
    private String senha;
    private String obsAvaliacao;
    private Set<Cliente> clients = new HashSet<>();
    private Integer id;

    public Agente build(){
        Agente obj = new Agente();
        obj.setUsuario(this.getUsuario());
        obj.setId(this.getId());
        obj.setSenha(this.getSenha());
        obj.setObsAvaliacao(this.getObsAvaliacao());
        obj.setClienteList(this.getClients());
        return obj;
    }


}
