package com.uce.pa2.u2.pedidos.application;

import java.util.List;
import java.util.Optional;

import com.uce.pa2.u2.pedidos.domain.model.Categoria;
import com.uce.pa2.u2.pedidos.domain.repository.CategoriaRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class CategoriaService {

    @Inject
    private CategoriaRepository categoriaRepository;

    public void guardar(Categoria categoria) {
        this.categoriaRepository.create(categoria);
    }

    public Optional<Categoria> buscarPorId(Integer id) {
        return this.categoriaRepository.read(id);
    }

    public List<Categoria> listarTodos() {
        return this.categoriaRepository.readAll();
    }

    public void actualizar(Categoria categoria) {
        this.categoriaRepository.update(categoria);
    }

    public void eliminar(Integer id) {
        this.categoriaRepository.delete(id);
    }
}
