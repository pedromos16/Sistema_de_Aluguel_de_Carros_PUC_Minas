package com.sac.demo.DTO.Request;

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
public class PedidoAluguelRequestDTO {

    private Cliente cliente;
    private String observacao;
    private List<Automovel> automoveis;

    public PedidoAluguel build(){
        PedidoAluguel obj = new PedidoAluguel();
        obj.setCliente(this.getCliente());
        obj.setAutomovelList(this.getAutomoveis());
        obj.setObservacao(this.getObservacao());
        return obj;
    }
}
