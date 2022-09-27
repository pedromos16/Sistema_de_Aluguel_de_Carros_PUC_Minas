package com.sac.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Agente extends Usuario implements Serializable {
    public static final long serialVersionUID = 371343683L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String obsAvaliacao;

    @OneToMany(mappedBy = "agente")
    @JsonIgnoreProperties("agente")
    //@JsonIgnore
    private Set<Cliente> clienteList;
}
