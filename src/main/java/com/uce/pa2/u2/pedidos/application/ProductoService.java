package com.uce.pa2.u2.pedidos.application;

import java.util.List;
import java.util.Optional;

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
        this.productoRepository.create(producto);
    }

    public Optional<Producto> buscarPorId(Integer id) {
        return this.productoRepository.read(id);
    }

    public List<Producto> listarTodos() {
        return this.productoRepository.readAll();
    }

    public void actualizar(Producto producto) {
        this.productoRepository.update(producto);
    }

    public void eliminar(Integer id) {
        this.productoRepository.delete(id);
    }
}
