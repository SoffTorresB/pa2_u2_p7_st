package com.uce.pa2.u2.pedidos.domain.repository;

import com.uce.pa2.u2.pedidos.domain.model.Cliente;

public interface ClienteRepository {
    void create(Cliente cliente);
    Cliente read(Integer id);
    void update(Cliente cliente);
    void delete(Integer id);
}
