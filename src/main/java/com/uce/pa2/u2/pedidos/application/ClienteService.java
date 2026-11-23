package com.uce.pa2.u2.pedidos.application;

import com.uce.pa2.u2.pedidos.domain.model.Cliente;
import com.uce.pa2.u2.pedidos.domain.repository.ClienteRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ClienteService {
    @Inject
    private ClienteRepository clienteRepository;

    public void guardar(Cliente cliente) {
        clienteRepository.create(cliente);
    }

    public Cliente buscarPorId(Integer id) {
        return clienteRepository.read(id);
    }

    public void actualizar(Cliente cliente) {
        clienteRepository.update(cliente);
    }

    public void eliminar(Integer id) {
        clienteRepository.delete(id);
    }
}
