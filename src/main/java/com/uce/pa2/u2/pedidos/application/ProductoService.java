package com.uce.pa2.u2.pedidos.application;

import com.uce.pa2.u2.pedidos.domain.model.Producto;
import com.uce.pa2.u2.pedidos.domain.repository.ProductoRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ProductoService {
    @Inject
    private ProductoRepository productoRepository;

    public void guardar(Producto producto) {
        productoRepository.create(producto);
    }

    public Producto buscarPorId(Integer id) {
        return productoRepository.read(id);
    }

    public void actualizar(Producto producto) {
        productoRepository.update(producto);
    }

    public void eliminar(Integer id) {
        productoRepository.delete(id);
    }
}
