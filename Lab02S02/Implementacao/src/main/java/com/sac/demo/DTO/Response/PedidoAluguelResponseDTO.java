package com.sac.demo.DTO.Response;

import com.sac.demo.model.Automovel;
import com.sac.demo.model.Cliente;
import com.sac.demo.model.PedidoAluguel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoAluguelResponseDTO {
    private Cliente cliente;
    private String observacao;
    private List<Automovel> automoveis;
    private Double preco;

    public PedidoAluguelResponseDTO(PedidoAluguel obj){
        this.cliente = obj.getCliente();
        this.observacao = obj.getObservacao();
        this.automoveis = obj.getAutomovelList();
        this.preco = obj.getPreco();
    }
}
