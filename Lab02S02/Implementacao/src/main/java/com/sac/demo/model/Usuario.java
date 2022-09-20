package com.sac.demo.model;

import java.io.Serializable;

public class Usuario implements Serializable {
    public static final long serialVersionUID = 1737981239L;

    private String usuario;
    private String senha;

    protected Usuario(String usuario, String senha){
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }



}
