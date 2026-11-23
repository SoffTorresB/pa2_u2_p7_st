package com.uce.pa2.u2.pedidos.domain.repository;

import com.uce.pa2.u2.pedidos.domain.model.Categoria;

public interface CategoriaRepository {
    void create(Categoria categoria);
    Categoria read(Integer id);
    void update(Categoria categoria);
    void delete(Integer id);
}
