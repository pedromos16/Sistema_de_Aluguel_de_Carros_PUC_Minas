package com.sac.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Automovel implements Serializable {
    public static final long serialVersionUID = 3712354283L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String matricula;
    @Column
    private Integer ano;
    @Column
    private String marca;
    @Column
    private String modelo;
    @Column
    private String placa;
    @Column
    private Double preco;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "pedidoAluguel_id")
    @JsonIgnore
    private PedidoAluguel pedidoAluguel;

}
