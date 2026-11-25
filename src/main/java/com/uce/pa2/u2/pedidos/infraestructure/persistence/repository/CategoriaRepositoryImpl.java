package com.uce.pa2.u2.pedidos.infraestructure.persistence.repository;

import java.util.List;
import java.util.Optional;

import com.uce.pa2.u2.pedidos.domain.model.Categoria;
import com.uce.pa2.u2.pedidos.domain.repository.CategoriaRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class CategoriaRepositoryImpl implements CategoriaRepository {

    @Inject
    private EntityManager entityManager;

    @Override
    public void create(Categoria categoria) {
        this.entityManager.persist(categoria);
    }

    @Override
    public Optional<Categoria> read(Integer id) {
        return Optional.ofNullable(this.entityManager.find(Categoria.class, id));
    }

    @Override
    public List<Categoria> readAll() {
        return this.entityManager
                .createQuery("SELECT c FROM Categoria c", Categoria.class)
                .getResultList();
    }

    @Override
    public void update(Categoria categoria) {
        this.entityManager.merge(categoria);
    }

    @Override
    public void delete(Integer id) {
        this.read(id).ifPresent(this.entityManager::remove);
    }
}
