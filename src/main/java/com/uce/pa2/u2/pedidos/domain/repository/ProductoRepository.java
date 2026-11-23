package com.uce.pa2.u2.pedidos.domain.repository;

import com.uce.pa2.u2.pedidos.domain.model.Producto;

public interface ProductoRepository {
    void create(Producto producto);
    Producto read(Integer id);
    void update(Producto producto);
    void delete(Integer id);
}
