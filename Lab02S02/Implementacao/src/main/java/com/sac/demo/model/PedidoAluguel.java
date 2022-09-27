package com.sac.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoAluguel implements Serializable {
    public static final long serialVersionUID = 385431283L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="cliente_id")
    private Cliente cliente;

    @Column
    private String observacao;

    @Column
    private Double preco;


    private List<Automovel> automovelList;

}
