package com.uce.pa2.u2.pedidos.application;

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
        categoriaRepository.create(categoria);
    }

    public Categoria buscarPorId(Integer id) {
        return categoriaRepository.read(id);
    }

    public void actualizar(Categoria categoria) {
        categoriaRepository.update(categoria);
    }

    public void eliminar(Integer id) {
        categoriaRepository.delete(id);
    }
}
