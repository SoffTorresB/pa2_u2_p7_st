package com.uce.pa2.u2.pedidos.infraestructure.persistence.repository;

import com.uce.pa2.u2.pedidos.domain.model.Producto;
import com.uce.pa2.u2.pedidos.domain.repository.ProductoRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class ProductoRepositoryImpl implements ProductoRepository {
    @Inject
    private EntityManager entityManager;

    @Override
    public void create(Producto producto) {
        entityManager.persist(producto);
    }

    @Override
    public Producto read(Integer id) {
        return entityManager.find(Producto.class, id);
    }

    @Override
    public void update(Producto producto) {
        entityManager.merge(producto);
    }

    @Override
    public void delete(Integer id) {
        Producto producto = read(id);
        if (producto != null) {
            entityManager.remove(producto);
        }
    }
}
