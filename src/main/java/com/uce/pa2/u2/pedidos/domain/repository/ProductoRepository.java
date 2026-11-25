package com.uce.pa2.u2.pedidos.domain.repository;

import java.util.List;
import java.util.Optional;

import com.uce.pa2.u2.pedidos.domain.model.Producto;

public interface ProductoRepository {
    void create(Producto producto);
    Optional<Producto> read(Integer id);
    List<Producto> readAll();
    void update(Producto producto);
    void delete(Integer id);
}
