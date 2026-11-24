package com.uce.pa2.u2.pedidos.domain.repository;

import java.util.List;
import java.util.Optional;

import com.uce.pa2.u2.pedidos.domain.model.Pedido;

public interface PedidoRepository {
    // CREATE
    public void create(Pedido pedido);
    // READ: por id
    // public Pedido read(Integer id);

    public Optional<Pedido> read(Integer id);

    public Optional<Pedido> readByNumber(String numero);

    public List<Pedido> readAll();

    // UPDATE
    public void update(Pedido pedido);

    // DELETE
    public void delete(Integer id);

}
