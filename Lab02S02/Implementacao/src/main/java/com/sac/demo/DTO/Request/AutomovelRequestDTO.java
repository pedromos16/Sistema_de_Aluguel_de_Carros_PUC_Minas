package com.sac.demo.DTO.Request;

import com.sac.demo.model.Automovel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AutomovelRequestDTO {
    private String matricula;
    private Integer ano;
    private String marca;
    private String modelo;
    private String placa;
    private Integer id;
    private Double preco;

    public Automovel build(){
        Automovel obj = new Automovel();
        obj.setMatricula(this.matricula);
        obj.setAno(this.getAno());
        obj.setMarca(this.getMarca());
        obj.setModelo(this.getModelo());
        obj.setPlaca(this.getPlaca());
        obj.setPreco(this.getPreco());
        obj.setId(this.getId());
        return obj;
    }

}
