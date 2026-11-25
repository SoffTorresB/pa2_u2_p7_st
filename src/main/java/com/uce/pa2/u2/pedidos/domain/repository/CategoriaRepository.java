package com.uce.pa2.u2.pedidos.domain.repository;

import java.util.List;
import java.util.Optional;

import com.uce.pa2.u2.pedidos.domain.model.Categoria;

public interface CategoriaRepository {
    void create(Categoria categoria);
    Optional<Categoria> read(Integer id);
    List<Categoria> readAll();
    void update(Categoria categoria);
    void delete(Integer id);
}
