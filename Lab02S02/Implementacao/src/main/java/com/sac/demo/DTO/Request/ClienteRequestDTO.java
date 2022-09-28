package com.sac.demo.DTO.Request;

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
public class ClienteRequestDTO implements Serializable {
    public static final long serialVersionUID = 3128741L;

    private Set<PedidoAluguel> pedidoAlugueis = new HashSet<>();

    private Integer id;
    private String usuario;
    private String senha;
    private String rg;
    private String cpf;
    private String nome;
    private String endereco;
    private String profissao;
    private String entidadeEmpregadora;
    private String rendimentos;
    private Agente agente;

    public ClienteRequestDTO(Cliente cliente) {
    }

    public Cliente build(){
        Cliente obj = new Cliente();
        obj.setUsuario(this.getUsuario());
        obj.setSenha(this.getSenha());
        obj.setId(this.getId());
        obj.setRg(this.getRg());
        obj.setCpf(this.getCpf());
        obj.setNome(this.getNome());
        obj.setEndereco(this.getEndereco());
        obj.setProfissao(this.getProfissao());
        obj.setEntidadeEmpregadora(this.getEntidadeEmpregadora());
        obj.setRendimentos(this.getRendimentos());
        return obj;
    }
}
