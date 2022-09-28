package com.sac.demo.DTO.Response;


import com.sac.demo.model.Automovel;
import com.sac.demo.model.PedidoAluguel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AutomovelResponseDTO {

    private Integer id;

    private String matricula;
    private Integer ano;
    private String marca;
    private String modelo;
    private String placa;

    private Double preco;

    public AutomovelResponseDTO(Automovel obj){
        this.id = obj.getId();
        this.ano = obj.getAno();
        this.marca = obj.getMarca();
        this.modelo = obj.getModelo();
        this.placa = obj.getPlaca();
        this.matricula = obj.getMatricula();
        this.preco = obj.getPreco();
    }
}
