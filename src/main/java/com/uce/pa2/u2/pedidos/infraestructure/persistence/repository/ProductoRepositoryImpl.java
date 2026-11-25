package com.uce.pa2.u2.pedidos.infraestructure.persistence.repository;

import java.util.List;
import java.util.Optional;

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
        this.entityManager.persist(producto);
    }

    @Override
    public Optional<Producto> read(Integer id) {
        return Optional.ofNullable(this.entityManager.find(Producto.class, id));
    }

    @Override
    public List<Producto> readAll() {
        return this.entityManager
                .createQuery("SELECT p FROM Producto p", Producto.class)
                .getResultList();
    }

    @Override
    public void update(Producto producto) {
        this.entityManager.merge(producto);
    }

    @Override
    public void delete(Integer id) {
        this.read(id).ifPresent(this.entityManager::remove);
    }
}
