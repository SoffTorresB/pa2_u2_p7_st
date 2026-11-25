package com.uce.pa2.u2.pedidos.infraestructure.persistence.repository;

import java.util.List;
import java.util.Optional;

import com.uce.pa2.u2.pedidos.domain.model.Pedido;
import com.uce.pa2.u2.pedidos.domain.repository.PedidoRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@ApplicationScoped
public class PedidoRepositoryImpl implements PedidoRepository {

    @Inject
    private EntityManager entityManager;

    @Override
    public void create(Pedido pedido) {
        this.entityManager.persist(pedido);
    }

    @Override
    public Optional<Pedido> read(Integer id) {
        Pedido pedido = this.entityManager.find(Pedido.class, id);
        return Optional.ofNullable(pedido);
    }

    @Override
    public void update(Pedido pedido) {

        this.entityManager.merge(pedido);

    }

    @Override
    public void delete(Integer id) {

        Optional<Pedido> pedido = this.read(id);

        pedido.ifPresent(this.entityManager::remove);
    }

    @Override
    public Optional<Pedido> readByNumber(String numero) {
        TypedQuery<Pedido> query = this.entityManager.createQuery("SELECT p FROM Pedido p WHERE p.numero = :numeroVariable", Pedido.class);
        query.setParameter("numeroVariable", numero);
        List<Pedido> pedidos = query.getResultList();
        return pedidos.isEmpty() ? Optional.empty() : Optional.of(pedidos.get(0));
    }

    @Override
    public List<Pedido> readAll() {
        return this.entityManager
                .createQuery("SELECT p FROM Pedido p", Pedido.class)
                .getResultList();
    }

}