package com.uce.pa2.u2.pedidos.application;

import java.util.List;
import java.util.Optional;

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
        this.pagoRepository.create(pago);
    }

    public Optional<Pago> buscarPorId(Integer id) {
        return this.pagoRepository.read(id);
    }

    public List<Pago> listarTodos() {
        return this.pagoRepository.readAll();
    }

    public void actualizar(Pago pago) {
        this.pagoRepository.update(pago);
    }

    public void eliminar(Integer id) {
        this.pagoRepository.delete(id);
    }
}
