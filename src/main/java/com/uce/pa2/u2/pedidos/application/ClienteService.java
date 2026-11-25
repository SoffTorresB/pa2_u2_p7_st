package com.uce.pa2.u2.pedidos.application;

import java.util.List;
import java.util.Optional;

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
        this.clienteRepository.create(cliente);
    }

    public Optional<Cliente> buscarPorId(Integer id) {
        return this.clienteRepository.read(id);
    }

    public List<Cliente> listarTodos() {
        return this.clienteRepository.readAll();
    }

    public void actualizar(Cliente cliente) {
        this.clienteRepository.update(cliente);
    }

    public void eliminar(Integer id) {
        this.clienteRepository.delete(id);
    }
}
