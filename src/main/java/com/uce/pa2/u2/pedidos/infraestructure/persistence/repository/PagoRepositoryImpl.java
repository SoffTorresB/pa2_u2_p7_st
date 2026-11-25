package com.uce.pa2.u2.pedidos.infraestructure.persistence.repository;

import java.util.List;
import java.util.Optional;

import com.uce.pa2.u2.pedidos.domain.model.Pago;
import com.uce.pa2.u2.pedidos.domain.repository.PagoRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class PagoRepositoryImpl implements PagoRepository {

    @Inject
    private EntityManager entityManager;

    @Override
    public void create(Pago pago) {
        this.entityManager.persist(pago);
    }

    @Override
    public Optional<Pago> read(Integer id) {
        return Optional.ofNullable(this.entityManager.find(Pago.class, id));
    }

    @Override
    public List<Pago> readAll() {
        return this.entityManager
                .createQuery("SELECT p FROM Pago p", Pago.class)
                .getResultList();
    }

    @Override
    public void update(Pago pago) {
        this.entityManager.merge(pago);
    }

    @Override
    public void delete(Integer id) {
        this.read(id).ifPresent(this.entityManager::remove);
    }
}
