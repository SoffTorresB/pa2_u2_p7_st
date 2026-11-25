package com.uce.pa2.u2.pedidos.application;

import java.util.Optional;
import java.util.List;

import com.uce.pa2.u2.pedidos.domain.model.Pedido;
import com.uce.pa2.u2.pedidos.domain.repository.PedidoRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped 
@Transactional // Anotación para indicar que los métodos de esta clase deben ejecutarse dentro de una transacción
public class PedidoService {
    @Inject 
    private PedidoRepository pedidoRepository;

    public void guardar (Pedido pedido) {
        pedidoRepository.create(pedido);
    }

    public Optional<Pedido> buscarPorId (Integer id) {
        return this.pedidoRepository.read(id);
    }
    public Optional<Pedido> buscarPorNumero (String numero) {
        return this.pedidoRepository.readByNumber(numero);
    }

    public List<Pedido> listarTodos() {
        return this.pedidoRepository.readAll();
    }

    public void actualizar (Pedido pedido) {
        this.pedidoRepository.update(pedido);
    }

    public void eliminar (Integer id) {
        this.pedidoRepository.delete(id);
    }
}
