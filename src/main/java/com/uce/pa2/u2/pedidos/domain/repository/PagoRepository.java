package com.uce.pa2.u2.pedidos.domain.repository;

import java.util.List;
import java.util.Optional;

import com.uce.pa2.u2.pedidos.domain.model.Pago;

public interface PagoRepository {
    void create(Pago pago);
    Optional<Pago> read(Integer id);
    List<Pago> readAll();
    void update(Pago pago);
    void delete(Integer id);
}
