package com.sac.demo.DTO.Response;

import com.sac.demo.model.Agente;
import com.sac.demo.model.Cliente;
import com.sac.demo.model.PedidoAluguel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponseDTO implements Serializable {
    public static final long serialVersionUID = 3128744121L;

    private Agente agente;

    private Set<PedidoAluguel> pedidosAlugueis = new HashSet<>();

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

    public ClienteResponseDTO(Cliente obj){
        this.usuario = obj.getUsuario();
        this.senha = obj.getSenha();
        this.id = obj.getId();
        this.agente = obj.getAgente();
        this.pedidosAlugueis = obj.getPedidoAluguelList();
        this.rg = obj.getRg();
        this.cpf = obj.getCpf();
        this.nome = obj.getNome();
        this.endereco = obj.getEndereco();
        this.profissao = obj.getProfissao();
        this.entidadeEmpregadora = obj.getEntidadeEmpregadora();
        this.rendimentos = obj.getRendimentos();
    }
}
