package com.sac.demo.DTO.Response;

import com.sac.demo.model.Agente;
import com.sac.demo.model.Cliente;
import com.sac.demo.model.PedidoAluguel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgenteResponseDTO implements Serializable {
    public static final long serialVersionUID = 13981723L;

    private String usuario;
    private String senha;
    private Integer id;
    private String obsAvaliacao;
    private Set<Cliente> clientes;

    public AgenteResponseDTO(Agente obj){
        this.id = obj.getId();
        this.usuario = obj.getUsuario();
        this.senha = obj.getSenha();
        this.obsAvaliacao = obj.getObsAvaliacao();
        this.clientes = obj.getClienteList();
    }
}
