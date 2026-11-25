package com.uce.pa2.u2.pedidos.domain.repository;

import java.util.List;
import java.util.Optional;

import com.uce.pa2.u2.pedidos.domain.model.Cliente;

public interface ClienteRepository {
    void create(Cliente cliente);
    Optional<Cliente> read(Integer id);
    List<Cliente> readAll();
    void update(Cliente cliente);
    void delete(Integer id);
}
