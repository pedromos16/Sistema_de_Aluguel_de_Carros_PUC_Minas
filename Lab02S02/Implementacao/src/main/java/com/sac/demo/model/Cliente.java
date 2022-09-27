package com.sac.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente extends Usuario implements Serializable {
    public static final long serialVersionUID = 371231283L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "cliente")
    private Set<PedidoAluguel> pedidoAluguelList;

    @ManyToOne
    @JoinColumn(name="ag_id")
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
    private String rendimentos;

}
