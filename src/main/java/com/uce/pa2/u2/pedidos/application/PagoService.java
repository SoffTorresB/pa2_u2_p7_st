package com.uce.pa2.u2.pedidos.application;

import com.uce.pa2.u2.pedidos.domain.model.Pago;
import com.uce.pa2.u2.pedidos.domain.repository.PagoRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class PagoService {
    @Inject
    private PagoRepository pagoRepository;

    public void guardar(Pago pago) {
        pagoRepository.create(pago);
    }

    public Pago buscarPorId(Integer id) {
        return pagoRepository.read(id);
    }

    public void actualizar(Pago pago) {
        pagoRepository.update(pago);
    }

    public void eliminar(Integer id) {
        pagoRepository.delete(id);
    }
}
