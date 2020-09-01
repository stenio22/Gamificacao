package com.stenio.gamificacao.model;

import java.util.List;

public interface IResultado {
    public boolean salvar(Resultado resultado);
    public List<Resultado> listar();

}
