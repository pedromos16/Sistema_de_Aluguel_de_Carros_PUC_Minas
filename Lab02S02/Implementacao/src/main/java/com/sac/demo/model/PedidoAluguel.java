package com.sac.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
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
    @ElementCollection
    @CollectionTable(name="automoveis", joinColumns = @JoinColumn(name = "Pedido_ID"))
    @Column(name = "auto_NO")
    private List<Automovel> automovelList;

    public PedidoAluguel(String observacao, Double preco, Cliente cliente, List<Automovel> automovelList) {
        this.observacao = observacao;
        this.preco = preco;
        this.automovelList = automovelList;
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public List<Automovel> getAutomovelList() {
        return automovelList;
    }

    public void setAutomovelList(List<Automovel> automovelList) {
        this.automovelList = automovelList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PedidoAluguel)) return false;
        PedidoAluguel that = (PedidoAluguel) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
