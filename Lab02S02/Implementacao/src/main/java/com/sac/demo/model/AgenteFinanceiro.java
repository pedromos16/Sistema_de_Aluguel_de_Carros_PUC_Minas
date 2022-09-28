package com.sac.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
public class AgenteFinanceiro extends Agente implements Serializable {
    public static final long serialVersionUID = 13819381L;

    public void avaliarPedido(Integer id){

    }

}
