package com.uce.pa2.u2.pedidos.infraestructure.persistence.repository;

import java.util.List;
import java.util.Optional;

import com.uce.pa2.u2.pedidos.domain.model.Cliente;
import com.uce.pa2.u2.pedidos.domain.repository.ClienteRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class ClienteRepositoryImpl implements ClienteRepository {

    @Inject
    private EntityManager entityManager;

    @Override
    public void create(Cliente cliente) {
        this.entityManager.persist(cliente);
    }

    @Override
    public Optional<Cliente> read(Integer id) {
        return Optional.ofNullable(this.entityManager.find(Cliente.class, id));
    }

    @Override
    public List<Cliente> readAll() {
        return this.entityManager
                .createQuery("SELECT c FROM Cliente c", Cliente.class)
                .getResultList();
    }

    @Override
    public void update(Cliente cliente) {
        this.entityManager.merge(cliente);
    }

    @Override
    public void delete(Integer id) {
        this.read(id).ifPresent(this.entityManager::remove);
    }
}
