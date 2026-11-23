package com.uce.pa2.u2.pedidos.domain.repository;

import com.uce.pa2.u2.pedidos.domain.model.Pago;

public interface PagoRepository {
    void create(Pago pago);
    Pago read(Integer id);
    void update(Pago pago);
    void delete(Integer id);
}
